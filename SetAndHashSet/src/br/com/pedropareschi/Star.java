package br.com.pedropareschi;

public class Star extends HeavenlyBody{
    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.STAR);
    }
}
