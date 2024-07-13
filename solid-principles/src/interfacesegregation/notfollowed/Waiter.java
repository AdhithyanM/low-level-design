package interfacesegregation.notfollowed;

/*
    This RestaurantEmployee Interface violates Interface Segregation Principle of SOLID
 */
public class Waiter implements RestaurantEmployee {
    @Override
    public void washDishes() {
        // not my job
    }

    @Override
    public void serverCustomers() {
        // my job. here is my implementations
        System.out.println("Serving the customer");
    }

    @Override
    public void cookFood() {
        // not my job
    }
}
