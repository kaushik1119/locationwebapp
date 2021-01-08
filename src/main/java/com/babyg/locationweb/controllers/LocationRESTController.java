package com.babyg.locationweb.controllers;

import com.babyg.locationweb.entities.Location;
import com.babyg.locationweb.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController  {

    //Use service if any business logic operations need to be performed..Here just performing crud operations
    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    @PostMapping
    public Location addLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id){
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable int id){
        return locationRepository.findById(id)
                .get();
    }
}
