package openclosed.notfollowed;

public class InvoiceDao {
    private Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        // saves the invoice to db
    }

    /*
        With the above code in production battle tested,
        If suddenly a new requirement comes which lets the invoice save as a file
        Creating new method in this class violates open closed principle of SOLID
     */
    public void saveToFile(String fileName) {
        // saves the invoice in given file
    }
}
