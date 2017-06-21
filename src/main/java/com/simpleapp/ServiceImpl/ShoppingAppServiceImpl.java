package com.simpleapp.ServiceImpl;

import com.simpleapp.Model.Item;
import com.simpleapp.Repository.ShoppingRepository;
import com.simpleapp.Service.ShoppingAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Artemas on 13/06/2017.
 */
@Service
public class ShoppingAppServiceImpl implements ShoppingAppService{

    @Autowired
    ShoppingRepository shoppingRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Item> list1 = new ArrayList<>(Arrays.asList(

            new Item("orange", "Orange", "Citric Fruit", "Fruit"),
            new Item("jordan5", "Nike Air Jordan V5", "Basketball shoes", "Footwear")

    ));

    public List<Item> getBasket(){

        List<Item> list = new ArrayList<>();
        if (shoppingRepository.findAll() != null) {
            shoppingRepository.findAll().forEach(list :: add);
        }

        return list;
    }


    public void addItemToBasket(Item item) {

        if (item != null){
            if (!item.getId().equals("")){
                shoppingRepository.save(item);
            }
        }
    }


    public Item getBasketById(String id) {

        if (id != null){
            if (id.length() > 0){
                return shoppingRepository.findOne(id);
            }else{
                return new Item("", "", "", "");
            }
        }else{
            return new Item("", "", "", "");
        }

    }

    public void deleteItem(String id) {

        shoppingRepository.delete(id);
    }
}
