package edu.wctc.service.converter;

import edu.wctc.entity.DonutShop;
import edu.wctc.service.DonutShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToDonutShopConverter implements Converter<String, DonutShop> {
    @Autowired
    private DonutShopService donutShopService;

    /*
     * Source is guaranteed to not be null, see:
     * https://docs.spring.io/spring/docs/4.1.3.RELEASE/spring-framework-reference/htmlsingle/#core-convert
     */
    @Override
    public DonutShop convert(String source) {
        int shopId = Integer.parseInt(source);
        DonutShop aShop = donutShopService.getDonutShop(shopId);

        return aShop;
    }
}
