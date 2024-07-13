package liskovsubstitution.notfollowed;

public class Bicycle implements Bike {

    /*
        Liskov Substitution Principle:
            If Class B is subtype of Class A
            then we should be able to replace Object of A with B without breaking the behaviour of the program.

        Simply, Subclass should extend the capability of parent class not narrow it down
     */

    /*
        As you notice in the below method, turnOnEngine is a feature not at all related to Bike Interface.
        Due to that it simply don't provide implementation for it but without choice throws exception.

        As a caller,
        Bike obj = new MotorCycle(...);
        Bike obj = new Bicycle(...);

        both should have proper implementation of methods from Bike
        here Bicycle breaks the behaviour of the program if caller calls
     */

    @Override
    public void turnOnEngine() {
        throw new AssertionError("there is no engine");
    }

    @Override
    public void accelerate() {
        // do something
    }
}
