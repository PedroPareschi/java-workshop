package br.com.pedropareschi;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
//	    StaticTest firstInstance = new StaticTest("First Instance");
//        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest secondInstance = new StaticTest("Second Instance");
//        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());
//
//        StaticTest thirdInstance = new StaticTest("Third Instance");
//        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        // java com.company._static.Main

        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier);

    }

    public static int multiply(int number){
        return number * multiplier;
    }
}
