package com.simpleapp.Service;

import com.simpleapp.Model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amuzanenhamo on 16/05/2017.
 */
@Service
public class StoreDashBoardService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Item> list = new ArrayList<>(Arrays.asList(

            new Item("orange", "Orange", "Citric Fruit", "Fruit"),
            new Item("jordan5", "Nike Air Jordan V5", "Basketball shoes", "Footwear")

    ));

    public List<Item> getBasket(){

        return list;
    }

    public void addItemToBasket(Item item) {

        try {
            if (item.getId().length() > 0){
                list.add(item);
            }
        }catch (NullPointerException e){
            logger.info("Exception Thrown in `addItemToBasket`: " + e.getMessage());
        }

    }

    public Item getBasketById(String id) {

        try {
            if (!id.isEmpty()){
                return list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
            }else{
                return new Item("", "", "", "");
            }
        }catch (Exception e){
            logger.error("Exception Thrown in `getBasketById`" + e.getMessage());
        }

            //I don't like this...
            return new Item("", "", "", "");

    }

    public void deleteItem(String id) {

        list.removeIf(t -> t.getId().equals(id));
    }
}
