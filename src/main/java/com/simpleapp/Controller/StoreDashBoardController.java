package com.simpleapp.Controller;

import com.simpleapp.Model.Item;
import com.simpleapp.Service.ShoppingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amuzanenhamo on 16/05/2017.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StoreDashBoardController {


    /**
     * In Case we need to test from Controller to Service without JPA.
     *
     * @Autowired
     * StoreDashBoardService dashBoardService;
     */

    @Autowired
    ShoppingAppService shoppingAppServiceImpl;

    @RequestMapping("/basket")
    public List<Item> showBasket() {

        return shoppingAppServiceImpl.getBasket();
    }

    @RequestMapping("/basket/item/{itemId}")
    public Item item(@PathVariable String itemId){
        return shoppingAppServiceImpl.getBasketById(itemId);
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/addItems"))
    public void addItemToBasket(@RequestBody Item item){
        shoppingAppServiceImpl.addItemToBasket(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/deleteItem/{itemId}"))
    public void deleteItemFromBasket(@PathVariable String itemId){
        shoppingAppServiceImpl.deleteItem(itemId);
    }

}
