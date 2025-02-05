// find itinerary from a given list of tickets

import java.util.HashMap;

public class itineraryTicket {

    public String getStart(HashMap<String, String> tick) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tick.keySet()) {
            revMap.put(tick.get(key), key); //put values of original map in reverse

        }
        for (String key : tick.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }

        }
        return null;
    }

    public void printItinerary(HashMap<String, String> tick) {
        String start = getStart(tick);
        if (start == null) {
            System.out.println("Invalid Input");
            return;
        }
        String to = tick.get(start);
        while (to != null) {
            System.out.print(start + " -> " + to + ", ");
            start = to;
            to = tick.get(start);
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> tick = new HashMap<>();
        tick.put("Chennai", "Banglore");
        tick.put("Bombay", "Delhi");
        tick.put("Goa", "Chennai");
        tick.put("Delhi", "Goa");

        itineraryTicket it = new itineraryTicket();
        it.printItinerary(tick);
    }
}
