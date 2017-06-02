package com.simpleapp.Service;

import com.simpleapp.Model.Item;
import com.simpleapp.Repository.ShoppingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amuzanenhamo on 02/06/2017.
 */
@Service
public class ShoppingAppService {

    @Autowired
    ShoppingRepository shoppingRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Item> list1 = new ArrayList<>(Arrays.asList(

            new Item("orange", "Orange", "Citric Fruit", "Fruit"),
            new Item("jordan5", "Nike Air Jordan V5", "Basketball shoes", "Footwear")

    ));

    /**
     * Return All the items in the Shopping Basket
     * @return
     */
    public List<Item> getBasket(){

        List<Item> list = new ArrayList<>();
        shoppingRepository.findAll().forEach(list :: add);

        return list;
    }

    /**
     * Add an Item into the Shopping Basket
     * @param item
     */
    public void addItemToBasket(Item item) {

        shoppingRepository.save(item);

    }


    /**
     * Return an Item given an ID
     * @param id
     * @return
     */
    public Item getBasketById(String id) {

        return shoppingRepository.findOne(id);

    }

    public void deleteItem(String id) {

        shoppingRepository.delete(id);
    }
}
