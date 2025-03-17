package SmartHomeControlSystem.decorator;

import SmartHomeControlSystem.composite.Device;

public class DeviceLog extends DeviceDecorator {

    public DeviceLog(Device device) {
        super(device);
    }

    @Override
    // log turn on action
    public void turnOn() {
        System.out.println("Logging: Turning on device");
        decoratedDevice.turnOn();
    }

    @Override
    // log turn off action
    public void turnOff() {
        System.out.println("Logging: Turning off device");
        decoratedDevice.turnOff();
    }
}
