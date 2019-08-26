package com.flightco.flightlineclient;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.flightco.flightlineclient.model.Passenger;
import com.flightco.flightlineclient.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest(classes = FlightlineClientApplication.class)
public class  PassengerControllerApplicationTest extends AbstractTest{
   
   @Autowired
   PassengerRepository passengerRepository;

   @Override
   @Before
   public void setUp(){
      super.setUp();

   }

   @Test
   public void testUpdateManifest()throws Exception{
      Passenger passenger = new Passenger();
      passenger.setName("TestName");
      passenger.setLastname("TestLastname");
      passenger.setSeat("t99");
      passenger.setFlightCode("tt9999");      
      
      String url = "/manifest/add";

      String inputJson = super.mapToJson(passenger);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
      int httpStatusCode = mvcResult.getResponse().getStatus();
      assertEquals(httpStatusCode,200);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals("{\"name\":\"TestName\",\"lastname\":\"TestLastname\",\"seat\":\"t99\",\"flightCode\":\"tt9999\"}", content);
   }

   @Test
   public void testSearchPassenger()throws Exception{
   
   }
  
}