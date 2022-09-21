package br.com.pedropareschi;

public class Asteroid extends HeavenlyBody{
    public Asteroid(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.ASTEROID);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        return false;
    }
}
