package liskovsubstitution.notfollowed;

public class MotorCycle implements Bike {
    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        // turns on the engine
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        // turn on the engine
        speed += 10;
    }
}
