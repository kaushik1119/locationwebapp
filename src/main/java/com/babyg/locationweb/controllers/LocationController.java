package com.babyg.locationweb.controllers;

import com.babyg.locationweb.Utils.EmailUtil;
import com.babyg.locationweb.entities.Location;
import com.babyg.locationweb.repositories.LocationRepository;
import com.babyg.locationweb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private EmailUtil emailUtil;

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createLocation";
    }

    //saveLoc is under actions in jsp. it takes in location object and we have to use spring annotation @ModelAttribute
    //@ModelAttribute for getting values from request
    //ModelMap to send information to response in form of key value pairs
    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location")Location location, ModelMap modelMap){
        Location savedLocation = locationService.saveLocation(location);
        String msg = "Location saved with id: " + savedLocation.getId();
        modelMap.addAttribute("msg",msg);
        emailUtil.sendMail("babygspring@gmail.com","My subject", "Success!!!!!!");
        return "createLocation";
    }

    @RequestMapping("/displayLoc")
    public String displayLocation(ModelMap modelMap){
        List<Location> locationList = locationService.getAllLocations();
        modelMap.addAttribute("locationList",locationList);
        return "displayLocation";
    }

    @RequestMapping("/deleteLoc")
    public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap){
        locationService.deleteLocation(locationService.getLocation(id));
        List<Location> locationList = locationService.getAllLocations();
        modelMap.addAttribute("locationList",locationList);
        return "displayLocation";
    }

    @RequestMapping("/showUpdateLoc")
    public String updateLocation(@RequestParam("id") int id,ModelMap modelMap){
        Location location = locationService.getLocation(id);
        modelMap.addAttribute("location",location);
        return "editLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location")Location location, ModelMap modelMap){
        locationService.updateLocation(location);
        List<Location> locationList = locationService.getAllLocations();
        modelMap.addAttribute("locationList",locationList);
        return "displayLocation";
    }
}
