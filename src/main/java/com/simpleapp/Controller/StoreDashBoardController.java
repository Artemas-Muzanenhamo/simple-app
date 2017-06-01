package com.simpleapp.Controller;

import com.simpleapp.Model.Item;
import com.simpleapp.Service.StoreDashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amuzanenhamo on 16/05/2017.
 */
@RestController
public class StoreDashBoardController {

    @Autowired
    StoreDashBoardService dashBoardService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/basket")
    public List<Item> showBasket() {

        return dashBoardService.getBasket();
    }

    @RequestMapping("/basket/item/{itemId}")
    public Item item(@PathVariable String itemId){
        return dashBoardService.getBasketById(itemId);
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/addItems"))
    public void addItemToBasket(@RequestBody Item item){
        dashBoardService.addItemToBasket(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/deleteItem/{itemId}"))
    public void deleteItemFromBasket(@PathVariable String itemId){
        dashBoardService.deleteItem(itemId);
    }

}
