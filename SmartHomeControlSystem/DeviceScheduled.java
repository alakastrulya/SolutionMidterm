package SmartHomeControlSystem;

// decorator for scheduling device operations
public class DeviceScheduled extends DeviceDecorator{
    private String scheduleTime;

    // constructor with schedule time
    public DeviceScheduled(Device device, String scheduleTime) {
       super(device);
       this.scheduleTime = scheduleTime;
    }

    @Override
    // turn on with schedule info
    public void turnOn() {
        System.out.println("Scheduled to turn ON at " + scheduleTime);
        decoratedDevice.turnOn();
    }

    @Override
    // turn off with schedule info
    public void turnOff() {
        System.out.println("Scheduled to turn OFF at " + scheduleTime);
        decoratedDevice.turnOff();
    }

}
