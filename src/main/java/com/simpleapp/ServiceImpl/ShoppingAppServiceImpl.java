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
import java.util.Optional;

/**
 * Created by Artemas on 13/06/2017.
 */
@Service
public class ShoppingAppServiceImpl implements ShoppingAppService{

    @Autowired
    ShoppingRepository shoppingRepository;

    public List<Item> getBasket(){
        List<Item> list = new ArrayList<>();
        shoppingRepository.findAll().forEach(list :: add);
        return list;
    }


    public void addItemToBasket(Item item) {
        Optional<Item> itemOptional = Optional.ofNullable(item);
        if (itemOptional.isPresent()){
            if (!itemOptional.get().getId().equals("id")){
                shoppingRepository.save(item);
            }
        }
    }


    public Item getBasketById(String id) {
        Optional<String> idOptional = Optional.ofNullable(id);
        if (idOptional.isPresent()){
            if (idOptional.get().length() > 0){
                return shoppingRepository.findOne(id);
            }else{
                return new Item("", "", "", "");
            }
        }else{
            return new Item("", "", "", "");
        }

    }

    public void deleteItem(String id) {
        Optional<String> itemOptional = Optional.ofNullable(id);
        if (itemOptional.isPresent()){
            shoppingRepository.delete(id);
        }
    }
}
