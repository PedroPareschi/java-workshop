package br.com.pedropareschi;

import static br.com.pedropareschi.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from Runnable's implementation of run'");
    }
}
