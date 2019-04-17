package ac.za.cput.factory;

import ac.za.cput.domain.Location;

public class LocationFactory {


    public static Location getLocation(String locationName,String id) {
        return new Location.Builder().locationId(id)
                .locationName(locationName)
                .build();
    }
}

