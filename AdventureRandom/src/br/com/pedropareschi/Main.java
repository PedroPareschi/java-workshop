package br.com.pedropareschi;

/*
    Only add/edit code where it is stated in the description.
*/

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    private static Map<String, String> vocabulary = new HashMap<>();

    public static void main(String[] args) throws IOException{


        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");

        command();

    }

    public static void command() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String quote;
        String[] words;
        Location currentLocation = locations.getLocation(1);
        while(true){
            System.out.println(currentLocation.getDescription());
            if(currentLocation.getLocationID() == 0){
                break;
            }
            Map<String, Integer> exits = currentLocation.getExits();
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();
            quote = scanner.nextLine();
            quote = quote.toUpperCase();
            if(exits.containsKey(quote)){
                currentLocation = locations.getLocation(currentLocation.getExits().get(quote));
            } else {
                boolean flag = false;
                words = quote.split("[:., ]");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        String direction = vocabulary.get(word);
                        if (exits.containsKey(direction)) {
                            currentLocation = locations.getLocation(currentLocation.getExits().get(direction));
                        } else {
                            System.out.println("You cannot go in that direction");
                        }
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println("You cannot go in that direction");
                }
            }
        }
        locations.close();
    }
}
