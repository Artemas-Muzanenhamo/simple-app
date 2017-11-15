package com.simpleapp.Service;

import com.simpleapp.Model.Item;
import com.simpleapp.Repository.ShoppingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by amuzanenhamo on 17/05/2017.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class StoreDashBoardRepositoryTest {

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Before
    public void before(){
        Item item = new Item("tangarine", "Tangarine", "Similar to an Orange", "Citric");
        shoppingRepository.save(item);
    }

    @Test
    public void whenAValidListItemIsPassedThenAddToTheList() throws Exception {

        Item item = new Item("apples", "Apples", "another fruit", "Fruit");

        shoppingRepository.save(item);

        assertEquals(2, shoppingRepository.count());
    }


    @Test
    public void whenAValidIdIsPassedInThenGETBasketByIdWillReturnAnItem() throws Exception {

        Item item = new Item("orange", "Orange", "Fruit", "Fruit");
        shoppingRepository.save(item);

        assertEquals("Orange", shoppingRepository.findOne("orange").getName());
    }

    @Test
    public void whenAListItemIsDeletedFromTheListThenReturnTheListMinusTheItem() throws Exception {

        Item item = new Item("orange", "Orange", "Fruit", "Fruit");
        shoppingRepository.save(item);

        shoppingRepository.delete("tangarine");

        assertEquals(1, shoppingRepository.count());

    }


}
