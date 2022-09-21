package br.com.pedropareschi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String challenge1 = "I want a bike.";
	    String challenge2 = "I want a ball.";
        Pattern pattern = Pattern.compile("^I want a b\\w+.");
        Matcher matcher1 = pattern.matcher(challenge1);
        Matcher matcher2 = pattern.matcher(challenge2);

        System.out.println(matcher1.matches());
        System.out.println(matcher2.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("\\w+"));
        System.out.println(challenge5.matches("^[a]{3}[b][c]{8}[d]{3}[e][f]{3}[g]$"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("[a-z A-Z]+\\.\\d+"));
        System.out.println("f5.12a".matches("^[a-z A-Z]+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern digits = Pattern.compile("[a-z A-Z]+\\.(\\d+)");
        Matcher matcherDigits = digits.matcher(challenge8);
        while (matcherDigits.find()){
            System.out.println(matcherDigits.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern digits2 = Pattern.compile("[a-z A-Z]+\\.(\\d+)\\s");
        Matcher matcherDigits2 = digits2.matcher(challenge9);
        while (matcherDigits2.find()) {
            System.out.println(matcherDigits2.group(1));
        }
        //Challenge 10
        matcherDigits2.reset();
        while(matcherDigits2.find()){
            System.out.println("Start: " + matcherDigits2.start(1) + " ****** End: " + (matcherDigits2.end(1) - 1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("\\{(\\d+, \\d+)\\},");
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()){
            System.out.println(matcher11.group(1));
        }

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        Pattern usZipCode = Pattern.compile("^\\d{5}($|-\\d{4}$)");
        Matcher fiveDigitsMatcher = usZipCode.matcher(challenge12);
        Matcher tenDigitsMatcher = usZipCode.matcher(challenge13);
        System.out.println(fiveDigitsMatcher.matches());
        System.out.println(tenDigitsMatcher.matches());

    }
}
