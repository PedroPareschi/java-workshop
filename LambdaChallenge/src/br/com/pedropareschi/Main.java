package br.com.pedropareschi;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> orderedNames = topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());



//        long beginsWithA = topNames2015.stream()
//                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
//                .filter(s-> s.startsWith("A"))
//                .count();
//
//        System.out.println(beginsWithA);


        Function<String, String> getSecondChar = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(everySecondChar("1234567890", getSecondChar));

        Supplier<String> iLoveJava = () -> "I love Java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

    }

    public static String everySecondChar(String source, Function<String, String> function){
         return function.apply(source);
    }

}


