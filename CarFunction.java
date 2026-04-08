class Vehicle {
    void start() {
        System.out.println("Car started");
    }
    void start(String a) {
        System.out.println("Start the car with " + a);
    }
    void fuel(String b) {
        System.out.println("Vehicle runs on " + b);
    }
}
class Car extends Vehicle {
    void fuel(String b) {
        System.out.println("Car runs on" + b);
    }
}
public class CarFunction {
    public static void main(String[] args) {
        Vehicle m = new Car();

        m.start();                     
        m.start("Key");                  
        m.fuel("Petrol and Diesel");      

    }
}