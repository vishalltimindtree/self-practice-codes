// Vehicle.java

package main.java.vehicle;

public class Vehicle {
    protected String name;
    protected double speed;

    public Vehicle(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public void move() {
        System.out.println(this.name + " is moving at a speed of " + this.speed + " km/h.");
    }
}