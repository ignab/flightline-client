package com.flightco.flightlineclient.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.validation.Valid;

import com.flightco.flightlineclient.model.Passenger;
import com.flightco.flightlineclient.payload.FlightResponse;
import com.flightco.flightlineclient.payload.PassengerRequest;
import com.flightco.flightlineclient.payload.PassengerResponse;
import com.flightco.flightlineclient.repository.PassengerRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController {

    public final String API = "http://localhost:8080";
    public final String MANIFEST = "/manifest";

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping("/manifest/update/{flightCode}")
    public String getManifest(@PathVariable String flightCode)/* throws Exception */ {
        String urlString = API + MANIFEST + "/" + flightCode;
        
        URLConnection conn = null;
        try {
            URL url = new URL(urlString);
            conn = url.openConnection();

        } // catch(MalformedURLException | IOException e){}
        catch (MalformedURLException e) {
            System.out.println("Bad URL");
            return "Bad Url...";
        } catch (IOException e) {
            System.out.println("Bad Connection");
            return "Bad Conection...";
        }
        
        try (InputStream is = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                StringWriter sw = new StringWriter();
                BufferedInputStream bis = new BufferedInputStream(is);) {
            int charSize = 100;
            char[] charBuffer = new char[charSize];
            int len;
            while ((len = isr.read(charBuffer, 0, charSize)) > -1) {
                sw.write(charBuffer, 0, len);
            }

            Gson gson = new Gson();   
            FlightResponse flightResponse = gson.fromJson(sw.toString(), FlightResponse.class);
            for (PassengerResponse passengerResponse : flightResponse.getPassengers()) {
                List<Passenger> existingPassenger = passengerRepository.findPassengersWithCustomData(passengerResponse.getName(), 
                                                                                                    passengerResponse.getLastname(),
                                                                                                    passengerResponse.getSeat());
                if(existingPassenger.size()==0){
                    Passenger passenger = new Passenger();
                    passenger.setName(passengerResponse.getName());
                    passenger.setLastname(passengerResponse.getLastname());
                    passenger.setSeat(passengerResponse.getSeat());
                    passenger.setFlightCode(flightResponse.getFlight());                    
                    passengerRepository.save(passenger);
                    System.out.println("Saved passenger: " + passenger);
                }
            }
            System.out.println("Flight Manifest: " + sw.toString());
            return sw.toString();

        } catch (Exception e) {
            return "Error on saving manifest file " + e.getMessage();
        }
    }
    
    @GetMapping("/manifest/search")
    public List<Passenger> getPassengersWithCustomData(@Valid @RequestBody PassengerRequest passengerRequest) {
        
        return passengerRepository.findPassengersWithCustomData(passengerRequest.getName(),
                                                            passengerRequest.getLastname(),
                                                            passengerRequest.getSeat());
    } 


    
}