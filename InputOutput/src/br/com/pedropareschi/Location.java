package br.com.pedropareschi;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable {
    private final int locationId;
    private final String description;
    private final LinkedHashMap<String, Integer> exits;

    private long serialVersionUID = 1l;

    public Location(int locationId, String description, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.description = description;
        if(exits!=null) {
            this.exits = new LinkedHashMap<>(exits);
            if(!exits.containsKey("Q")) {
                this.exits.put("Q", 0);
            }
        } else {
            this.exits = new LinkedHashMap<>();
        }
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }
    protected void addExit(String direction, int location){
        exits.put(direction, location);
    }
}
