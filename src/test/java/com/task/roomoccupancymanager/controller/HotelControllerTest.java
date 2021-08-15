package com.task.roomoccupancymanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.roomoccupancymanager.entity.HotelRequest;
import com.task.roomoccupancymanager.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HotelController.class)
class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HotelService hotelService;

    private final ObjectMapper mapper = new ObjectMapper();

    private final String URI = "/api/v1/rooms/optimize";

    @Test
    public void valid_request_returns_status_code_200() throws Exception{
        HotelRequest request = new HotelRequest();
        request.setPotentialGuests(new Double[]{23d, 45d, 155d, 374d, 22d, 99.99d, 100d, 101d, 115d, 209d});
        request.setFreePremiumRooms(3);
        request.setFreeEconomyRooms(3);
        mockMvc.perform(post(URI)
                .contentType("application/json")
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

}