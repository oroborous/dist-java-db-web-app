package edu.wctc.controller;

import edu.wctc.entity.Donut;
import edu.wctc.service.DonutReviewService;
import edu.wctc.service.DonutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private DonutService donutService;

    @Autowired
    private DonutReviewService donutReviewService;

    @RequestMapping("/list")
    public String listReviews(@RequestParam("donutId") int donutId, Model theModel) {
        // Get the donut and its reviews
        Donut theDonut = donutService.getDonutAndReviews(donutId);

        theModel.addAttribute("donut", theDonut);

        return "list-reviews";
    }

    @PostMapping("/user/delete")
    public String deleteDonut(@RequestParam("reviewId") int theId) {
        // Delete the review
        donutReviewService.deleteReview(theId);

        return "redirect:/donut/list";
    }
}
