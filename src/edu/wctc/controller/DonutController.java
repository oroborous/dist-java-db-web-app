package edu.wctc.controller;


import edu.wctc.entity.Donut;
import edu.wctc.service.DonutService;
import edu.wctc.service.DonutShopService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/donut")
public class DonutController {
    // Inject the Donut Service
    @Autowired
    private DonutService donutService;

    // Inject the Donut Shop service
    @Autowired
    private DonutShopService donutShopService;

    @GetMapping("/list")
    public String listDonuts(HttpServletRequest request, Model theModel) {
        System.out.println(request.getServletContext().getRealPath("/"));

        // Get donuts from service
        List<Donut> donutList = donutService.getDonuts();

        // Add the list of donuts to the model
        theModel.addAttribute("donuts", donutList);

        // Return the name of the view
        return "list-donuts";
    }

    @GetMapping("/showAddDonutForm")
    public String showAddDonutForm(Model theModel) {
        Donut theDonut = new Donut();

        theModel.addAttribute("donut", theDonut);

        theModel.addAttribute("donutShops", donutShopService.getDonutShops());

        return "add-donut-form";
    }

    @PostMapping("/saveDonut")
    public String saveDonut(@RequestParam("image") MultipartFile file,
                            @Valid @ModelAttribute("donut") Donut theDonut,
                            BindingResult bindingResult,
                            HttpServletRequest request,
                            Model theModel) {
        String fileName = null;

        if (!file.isEmpty()) {

            try {
                // Find the image subfolder for this donut shop
                String donutShopFolder = theDonut.getShop().getImageDirectory();

                // Find the complete path of the application
                String appPath = request.getServletContext().getRealPath("/");

                // Need to store the image in the artifact directory...
                // (where the application is currently running)
                String artifactPath = appPath + "WEB-INF\\resources\\img\\" + donutShopFolder;

                // ... and the source code directory
                // (so it gets checked into GitHub)
                String sourcePath = appPath + "..\\..\\..\\web\\WEB-INF\\resources\\img\\" + donutShopFolder;

                // What is the name of the uploaded file?
                fileName = file.getOriginalFilename();

                // Transfer the uploaded file to the artifact directory
                File imageFile = new File(artifactPath, fileName);
                file.transferTo(imageFile);

                // Copy the uploaded file to the source directory
                File copyOfImage = new File(sourcePath, fileName);
                FileUtils.copyFile(imageFile, copyOfImage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Any validation errors?
        if (bindingResult.hasErrors()) {
            // Put list of donut shops back in the new model
            theModel.addAttribute("donutShops", donutShopService.getDonutShops());

            // Send back to form with error messages
            return "add-donut-form";
        } else {
            // Set the filename in the entity object so Hibernate can save it to the database
            theDonut.setImageFilename(fileName);

            // Use the service to save the donut
            donutService.saveDonut(theDonut);

            // Redirect back to the donut list
            return "redirect:/donut/list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Trim whitespace from all string form parameters read by this controller
        // If the entire string is whitespace, trim it to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        e.printStackTrace();
    }
}
