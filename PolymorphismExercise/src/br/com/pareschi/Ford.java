package br.com.pareschi;

public class Ford extends Car{
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford -> starting engine";
    }

    @Override
    public String accelerate() {
        return "Ford -> accelerating";
    }

    @Override
    public String brake() {
        return "Ford -> braking";
    }
}
