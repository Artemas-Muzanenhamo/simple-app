package com.simpleapp.Controller;

import com.simpleapp.Model.Item;
import com.simpleapp.Service.ShoppingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amuzanenhamo on 16/05/2017.
 */
@RestController
public class StoreDashBoardController {


    /**
     * In Case we need to test from Controller to Service without JPA.
     *
     * @Autowired
     * StoreDashBoardService dashBoardService;
     */

    @Autowired
    ShoppingAppService shoppingAppService;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/basket")
    public List<Item> showBasket() {

        return shoppingAppService.getBasket();
    }

    @RequestMapping("/basket/item/{itemId}")
    public Item item(@PathVariable String itemId){
        return shoppingAppService.getBasketById(itemId);
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/addItems"))
    public void addItemToBasket(@RequestBody Item item){
        shoppingAppService.addItemToBasket(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/deleteItem/{itemId}"))
    public void deleteItemFromBasket(@PathVariable String itemId){
        shoppingAppService.deleteItem(itemId);
    }

}
