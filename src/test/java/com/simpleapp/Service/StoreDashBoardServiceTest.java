package com.simpleapp.Service;

import com.simpleapp.Model.Item;
import com.simpleapp.Repository.ShoppingRepository;
import com.simpleapp.ServiceImpl.ShoppingAppServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amuzanenhamo on 17/05/2017.
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StoreDashBoardServiceTest {

    @TestConfiguration
    static class ShoppingAppServiceImplTestContextConfiguration {

        @Bean
        public ShoppingAppService shoppingAppServiceImpl() {
            return new ShoppingAppServiceImpl();
        }

    }

    @Autowired
    private ShoppingAppService shoppingAppService;

    @MockBean
    private ShoppingRepository shoppingRepository;

    @Before
    public void setUp(){

        Item fruit = new Item("orange", "Orange", "Citric Fruit", "Fruit");
        Item shoe = new Item("jordan5", "Nike Air Jordan V5", "Basketball shoes", "Footwear");

        List<Item> list = new ArrayList<>();
        list.add(fruit);
        list.add(shoe);

        int listSize = list.size();

        Mockito.when(shoppingRepository.findOne(fruit.getId())).thenReturn(fruit);
        Mockito.when(shoppingRepository.findOne(shoe.getId())).thenReturn(shoe);
        Mockito.when(shoppingRepository.count()).thenReturn(2L);

        shoppingRepository.save(list.get(0));
        shoppingRepository.save(list.get(1));
    }

    @Test
    public void whenANullListIsPassedInThenGETBasketPassedWillNotAddIt() throws Exception{

        Item item = null;

        shoppingAppService.addItemToBasket(item);
        assertTrue(shoppingAppService.getBasket().size() == 0);
    }


    @Test
    public void whenAnEmptyItemPassedThenDoNotAddToList() throws Exception{

        Item item = new Item("", "", "", "");

        shoppingAppService.addItemToBasket(item);

        assertEquals(0, shoppingAppService.getBasket().size());
    }

    @Test
    public void whenAValidListItemIsPassedThenAddToTheList() throws Exception {

        Item item = new Item("apples", "Apples", "another fruit", "Fruit");

        shoppingAppService.addItemToBasket(item);

        assertEquals(2, shoppingRepository.count());
    }

    @Test
    public void whenANullIdValueIsPassedInThenGETBasketByIdWillNotDoReturnAnything() throws Exception {

        assertEquals("", shoppingAppService.getBasketById(null).getId());

        assertNotNull(shoppingAppService.getBasketById(null));

    }

    @Test
    public void whenAnEmptyIdValueIsPassedInThenGETBasketByIdWillNotDoReturnAnything() throws Exception {

        assertEquals("", shoppingAppService.getBasketById("").getId());

        assertNotNull(shoppingAppService.getBasketById(""));
    }

//    @Test
//    public void whenAValidIdIsPassedInThenGETBasketByIdWillReturnAnItem() throws Exception {
//
//        assertEquals("Orange", shoppingAppService.getBasketById("orange").getName());
//    }

    @Test
    public void whenAListItemIsDeletedFromTheListThenReturnTheListMinusTheItem() throws Exception {

        String id = "orange";

        shoppingAppService.deleteItem(id);

        assertEquals(2, shoppingRepository.count());

    }


}
