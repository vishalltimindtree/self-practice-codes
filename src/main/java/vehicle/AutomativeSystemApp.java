// AutomativeSystemApp.java

package main.java.vehicle;

public class AutomativeSystemApp {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Vehicle1", 60.0);
        Car car1 = new Car("Car1", 80.0, 4);

        vehicle1.move();
        car1.move();
    }
}