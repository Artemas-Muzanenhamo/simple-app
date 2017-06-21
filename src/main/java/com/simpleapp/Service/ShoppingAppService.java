package com.simpleapp.Service;

import com.simpleapp.Model.Item;

import java.util.List;

/**
 * Created by amuzanenhamo on 02/06/2017.
 */
public interface ShoppingAppService {

    /**
     * Return All the items in the Shopping Basket
     * @return
     */
    public List<Item> getBasket();

    /**
     * Add an Item into the Shopping Basket
     * @param item
     */
    public void addItemToBasket(Item item);


    /**
     * Return an Item given an ID
     * @param id
     * @return
     */
    public Item getBasketById(String id);

    /**
     * Deletes an Item given an ID
     *
     * @param id - for the Item to be Deleted
     */
    public void deleteItem(String id);

}
