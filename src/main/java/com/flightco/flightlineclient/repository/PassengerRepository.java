package com.flightco.flightlineclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.flightco.flightlineclient.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query(value = "Select * from passengers where name like :name or lastname like :lastname or seat like :seat", nativeQuery = true)
    List<Passenger> findPassengersWithCustomData(   @Param("name") String name,
                                                    @Param("lastname") String lastname, 
                                                    @Param("seat")String seat);

    @Query(value = "Select * from passengers where name like :name or lastname like :lastname or seat like :seat or flight_code like :flightCode", nativeQuery = true)
    List<Passenger> findPassengersWithCustomData(   @Param("name") String name,
                                                    @Param("lastname") String lastname, 
                                                    @Param("seat")String seat,
                                                    @Param("flightCode")String flightCode);
}