package br.com.pedropareschi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	     String string = "I am a string. Yes, I am";
	     System.out.println(string);
	     String yourString = string.replaceAll("I", "You");
         System.out.println(yourString);

         String alphaNumeric = "abcDeeef12Ghhiiiijkl99z";
         System.out.println(alphaNumeric.replaceAll(".", "Y"));

         System.out.println(alphaNumeric.replaceAll("^abcDeee", "YYY"));

         String secondString= "abcDeeef12GabcDeeehhiiiijkl99z";
         System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphaNumeric.matches("^abcDeee"));
        System.out.println(alphaNumeric.matches("abcDeeef12Ghhiiiijkl99z"));

        System.out.println(alphaNumeric.replaceAll("ijkl99z$", "The End"));

        System.out.println(alphaNumeric.replaceAll("[aei]", "X"));
        System.out.println(alphaNumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphaNumeric = "abcDeeF12Ghhiiiijkl99z";
        System.out.println(newAlphaNumeric.replaceAll("[^ej]", "x"));
        System.out.println(newAlphaNumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("(?i)[a-f3-8]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I hava blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S", "X"));
        System.out.println(newAlphaNumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));

        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p>This is a paragraph about something</p>");
        htmlText.append("<p>This is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);

        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()){
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        String tvTest = "tstvtkt";
        String tNotVRegExp = "t(?!v)";

        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()){
            count++;
            System.out.println("Ocurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        //^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }
}
