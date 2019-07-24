package com.jianghoy.cybercity2;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public static List<Event> getEventData(){
        List<Event> eventData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            eventData.add(new Event(
                    "Event",
                    "1184 W valley Blvd, CA 90101",
                    "this is a huge event"
            ));
        }
        return eventData;
    }
}
