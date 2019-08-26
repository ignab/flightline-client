package com.flightco.flightlineclient;

import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightco.flightlineclient.repository.PassengerRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
public class FlightlineClientApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Autowired WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();

	@MockBean
	PassengerRepository passengerRepository;

	@Before
	private void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getManifestTest(){
		//assengerRepository.findPassengersWithCustomData(name, lastname, seat)
	}


	@Test
	public void contextLoads() {

		Mockito.when(passengerRepository.findAll()).thenReturn(
			Collections.emptyList()
		);
	}

}
