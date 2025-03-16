package SmartHomeControlSystem;

import java.util.ArrayList;
import java.util.List;

// composite class for grouping devices
public class DeviceGroup implements Device {
    // group name
    private String name;
    // list of devices
    private List<Device> devices = new ArrayList<>();

    public DeviceGroup(String name) {
        this.name = name;
    }

    // add device to group
    public void add(Device device) {
        devices.add(device);
    }

    // remove device from group
    public void remove(Device device) {
        devices.remove(device);
    }

    @Override
    // turn on all devices in group
    public void turnOn() {
        System.out.println("Turning ON " + name);
        for (Device device : devices) {
            device.turnOn();
        }
    }

    @Override
    // turn off all devices
    public void turnOff() {
        System.out.println("Turning OFF " + name);
        for (Device device : devices) {
            device.turnOff();
        }
    }

    @Override
    // get status of all devices
    public String getStatus() {
        StringBuilder status = new StringBuilder(name + " status:\n");
        for (Device device : devices) {
            status.append("  ").append(device.getStatus()).append("\n");
        }
        return status.toString();
    }
}