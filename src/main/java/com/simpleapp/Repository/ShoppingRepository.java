package com.simpleapp.Repository;

import com.simpleapp.Model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by amuzanenhamo on 02/06/2017.
 */
public interface ShoppingRepository extends CrudRepository<Item, String> {  }
