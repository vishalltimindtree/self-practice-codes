// Class.java

package main.java.vehicle;

public class Car extends Vehicle {
    private int doors;

    public Car(String name, double speed, int doors) {
        super(name, speed);
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println(this.name + " is moving at a speed of " + this.speed + " km/h with " + this.doors + " doors.");
    }
}