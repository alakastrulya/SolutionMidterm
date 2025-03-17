package SmartHomeControlSystem.facade;

import SmartHomeControlSystem.composite.DeviceGroup;

// facade for controlling smart home system
public class SmartHomeController {
    private DeviceGroup home;

    public SmartHomeController(DeviceGroup home) {
        this.home = home;
    }

    // turn on all devices in home
    public void turnAllOn() {
        System.out.println("Turning all devices on");
        home.turnOn();
    }

    // turn off all devices in home
    public void turnAllOff() {
        System.out.println("Turning all devices off");
        home.turnOff();
    }

    // get report of all devices
    public String getSystemStatus() {
        return "Smart Home Status:\n" + home.getStatus();
    }
}
