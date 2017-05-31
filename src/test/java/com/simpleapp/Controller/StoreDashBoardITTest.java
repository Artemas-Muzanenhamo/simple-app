package com.simpleapp.Controller;

import com.simpleapp.Service.StoreDashBoardService;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by amuzanenhamo on 10/05/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoreDashBoardITTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private StoreDashBoardService dashBoardService;

    /**
     * GET
     */

    @Test
    public void getBasketReturningStatus200()throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/basket"))
                .andExpect(status().isOk());
    }

    @Test
    public void getBasketReturningStatusWithJSONResult()throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/basket"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void getBasketByIdReturningStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/basket/item/orange"))
                .andExpect(status().isOk());
    }

    @Test
    public void getBasketByIdReturningStatus200WithJSONResult() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("id", "orange");
        map.put("name", "Orange");
        map.put("description", "Citric Fruit");
        map.put("category", "Fruit");

        JSONObject jsonObject = new JSONObject(map);

        mockMvc.perform(MockMvcRequestBuilders.get("/basket/item/orange"))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonObject.toJSONString()));
    }

    /**
     * POST
     */

    @Test
    public void postBasketWithEmptyItemReturningStatus400IsOk() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/addItems"))
        .andExpect(status().isBadRequest());

    }

    @Test
    public void postBasketItemReturningStatus200IsOk() throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("id", "jordan6");
        map.put("name", "Air Jordans 6");
        map.put("description", "Michael Jordan Sneakers");
        map.put("category", "Footwear");

        JSONObject jsonObject = new JSONObject(map);

        mockMvc.perform(MockMvcRequestBuilders.post("/addItems").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonObject.toJSONString()))
        .andExpect(status().isOk());
    }

    @Test
    public void removeItemInBasketReturningStatus200IsOk() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteItem/orange"))
                .andExpect(status().isOk());

    }

}
