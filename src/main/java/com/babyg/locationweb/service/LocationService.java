package com.babyg.locationweb.service;

import com.babyg.locationweb.entities.Location;

import java.util.List;

public interface LocationService {
    Location saveLocation(Location location);
    Location updateLocation(Location location);
    void deleteLocation(Location location);
    Location getLocation(int id);
    List<Location> getAllLocations();
}
