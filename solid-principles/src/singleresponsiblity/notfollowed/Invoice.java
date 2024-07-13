package singleresponsiblity.notfollowed;

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return (quantity * marker.price);
    }

    /*
        Below 2 methods residing in this class voilates single responsibility principle

        printInvoice:
            - what if tomorrow there will be requirement to print the invoice that respects GST Format?
            - changes during that time might violate SRP
        saveToDB:
            - Although saving the invoice is related to this class,
                    It's better to have a repository for each model to abstract the Database operations.
     */

    public void printInvoice() {
        // prints the invoice
    }

    public void saveToDB() {
        // saves the invoice to DB
    }
}
