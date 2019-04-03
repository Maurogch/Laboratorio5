package com.company;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Event> events = Arrays.asList(
                new Event(5, "Event 5",
                        new Location(1, "Argentina",
                                new City(1, "Buenos Aires"))),
                new Event(7, "Event 7",
                        new Location(1, "Argentina",
                                new City(2, "Mar del Plata"))),
                new Event(2, "Event 2",
                        new Location(1, "Argentina",
                                new City(1, "Buenos Aires"))),
                new Event(1, "Event 1",
                        new Location(2, "Mexico",
                                new City(3, "Monterey"))),
                new Event(3, "Event 3",
                        new Location(1, "Argentina",
                                new City(2, "Mar del Plata"))),
                new Event(10, "Event 10",
                        new Location(2, "Mexico",
                                new City(3, "Monterey"))),
                new Event(8, "Event 8",
                        new Location(1, "Argentina",
                                new City(1, "Buenos Aires"))),
                new Event(4, "Event 4",
                        new Location(3, "Francia",
                                new City(4, "Paris"))),
                new Event(6, "Event 6",
                        new Location(1, "Argentina",
                                new City(1, "Buenos Aires"))),
                new Event(9, "Event 9",
                        new Location(3, "Francia",
                                new City(1, "Paris"))),
                new Event(11, "Event 11", null) //for testing optional

        );

        //System.out.println(Arrays.toString(events.toArray()));

        //System.out.println(getCityNameFromEvent(events,11));

        //---Get first Five---//
        /*List<Event> events2 = getFiveFistIds(events);

        for(Event event: events2){
            System.out.println(event.toString());
        }*/

        //---Sort Alphabetically then print---//
        sortAlphabetically(events);

        for(Event event: events){
            System.out.println(event.toString());
        }

    }

    public static Event getEventById(List<Event> list, Integer id){
        return list.stream()
                .filter(o -> id.equals(o.getId()))
                .findFirst()
                .get();
    }

    public static String getCityNameFromEvent(List<Event> list, Integer id){
        return Optional.ofNullable(getEventById(list, id))
                .map(Event::getLocation)
                .map(Location::getCity)
                .map(City::getName)
                .orElse("Sin Ciudad");
    }

    public static List<Event> getFiveFistIds(List<Event> list){
        /*Comparator<Event> byId                                   //Using comparator without the static import
                = Comparator.comparing(Event::getId);
        list.sort(byId);*/

        list.sort(comparing(Event::getId));                        //needs static import of comparing

        return list.stream()                                       //use stream filter to limit to 5
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void sortAlphabetically(List<Event> list){
        list.sort(comparing(Event::getName));                      //How do I sort by city name??

    }
}
