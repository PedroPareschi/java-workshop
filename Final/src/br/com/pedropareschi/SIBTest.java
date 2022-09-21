package br.com.pedropareschi;

public class SIBTest {
    public static final String owner;

    static{
        owner = "tim";
        System.out.println("SIBTest static initialization clock called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static{
        System.out.println("2nd initialization block called");
    }

    public void someMethod(){
        System.out.println("someMethod called");
    }
}
