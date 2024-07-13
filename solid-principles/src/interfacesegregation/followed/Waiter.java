package interfacesegregation.followed;

public class Waiter implements WaiterInterface {
    @Override
    public void serveCustomers() {
        System.out.println("Serving Customers");
    }

    @Override
    public void takeOrder() {
        System.out.println("Taking Order");
    }
}
