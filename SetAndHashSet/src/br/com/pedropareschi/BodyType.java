package br.com.pedropareschi;

public enum BodyType {
    MOON("MOON"), PLANET("PLANET"), STAR("STAR"), ASTEROID("Asteroid");
    private final String name;

    BodyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
