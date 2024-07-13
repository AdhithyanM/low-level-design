package interfacesegregation.notfollowed;

/*
    Interface Segregation Principle
        states that client should not implement unnecessary functions that they don't need
 */
public interface RestaurantEmployee {
    void washDishes();
    void serverCustomers();
    void cookFood();
}
