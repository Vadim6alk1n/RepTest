package Lesson_7;
import java.util.ArrayList;
import java.util.List;

class RentalGeneric<T> {  // "T" is for the type
    // parameter
    private List<T> rentalPool;   // Use the class type for the
    // List type
    private int maxNum;
    public RentalGeneric(
            int maxNum, List<T> rentalPool) { // constructor takes a
        // List of the class type
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }

    public T getRental() {                    // we rent out a T
        // blocks until there's something available
        return rentalPool.get(0);
    }
    public void returnRental(T returnedThing) { // and the renter
        rentalPool.add(returnedThing);
    }
}

class Car
{
    Car(String id)
    {
        CarID = id;
    }
    String CarID;
}

public class Generic_example {
    public static void main(String[] args)
    {
        RentalGeneric<Car> carRental = new RentalGeneric<Car>(10, new ArrayList<>());
        carRental.returnRental(new Car("AA0000"));
        carRental.returnRental(new Car("AA0001"));
        carRental.returnRental(new Car("ZZ9999"));
        System.out.println(carRental.getRental().CarID);
    }
}
