package SmartHomeControlSystem;


// abstract decorator class
public abstract class DeviceDecorator implements Device {
    Device decoratedDevice;

    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
    }

    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return decoratedDevice.getStatus();
    }
}