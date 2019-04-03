package com.company;

import java.util.List;
import java.util.Optional;

public class Utils {
    public static String getCityNameFromEvent(Event e){ // Using Optionals in case Location or City is null
        return Optional.ofNullable(e)
                .map(Event::getLocation)
                .map(Location::getCity)
                .map(City::getName)
                .orElse("Sin Ciudad"); //if null return this
    }
}
