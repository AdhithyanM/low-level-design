public class Flight {
    private String code;
    private String origin;
    private String destination;

    public Flight(String code, String origin, String destination) {
        this.code = code;
        this.origin = origin;
        this.destination = destination;
    }

    // getter methods for them
    public String getCode() {
        return code;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

}