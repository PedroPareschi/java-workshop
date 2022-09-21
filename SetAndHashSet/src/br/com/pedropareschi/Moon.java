package br.com.pedropareschi;

public class Moon extends HeavenlyBody{
    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.MOON);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        return false;
    }
}
