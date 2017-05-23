package com.simpleapp.Service;

import com.simpleapp.Model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by amuzanenhamo on 17/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoreDashBoardServiceTest {

    @InjectMocks
    private StoreDashBoardService dashBoardService;

    private Item item;

    @Test
    public void whenANullListIsPassedInThenGETBasketPassedWillNotAddIt() throws Exception{
        dashBoardService.addItemToBasket(item);
        assertTrue(dashBoardService.getBasket().size() == 2);
    }


    @Test
    public void whenAnEmptyItemPassedThenDoNotAddToList() throws Exception{
        item = new Item("", "", "", "");

        dashBoardService.addItemToBasket(item);

        assertTrue(dashBoardService.getBasket().size() == 2);
    }

    @Test
    public void whenAValidListItemIsPassedThenAddToTheList() throws Exception {

        item = new Item("apples", "Apples", "another fruit", "Fruit");

        dashBoardService.addItemToBasket(item);

        assertTrue(dashBoardService.getBasket().size() == 3);
    }

    @Test
    public void whenANullIdValueIsPassedInThenGETBasketByIdWillNotDoReturnAnything() throws Exception {

        assertEquals("", dashBoardService.getBasketById(null).getId());

        assertNotNull(dashBoardService.getBasketById(null));

    }

    @Test
    public void whenAnEmptyIdValueIsPassedInThenGETBasketByIdWillNotDoReturnAnything() throws Exception {

        assertEquals("", dashBoardService.getBasketById("").getId());

        assertNotNull(dashBoardService.getBasketById(""));
    }

    @Test
    public void whenAValidIdIsPassedInThenGETBasketByIdWillReturnAnItem() throws Exception {

        assertEquals("Orange", dashBoardService.getBasketById("orange").getName());
    }

    @Test
    public void whenAListIsDeletedFromTheListThenReturnTheListMinusTheItem() throws Exception {

        String id = "orange";

        dashBoardService.deleteItem(id);

        assertEquals(1, dashBoardService.getBasket().size());

    }


}
