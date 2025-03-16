package SmartHomeControlSystem;

// facade for controlling smart home system
public class SmartHomeController {
    private DeviceGroup home;

    // constructor takes root device group
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

    // get status report of all devices
    public String getSystemStatus() {
        return "Smart Home Status:\n" + home.getStatus();
    }
}
