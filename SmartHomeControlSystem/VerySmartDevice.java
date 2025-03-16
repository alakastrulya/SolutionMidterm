package SmartHomeControlSystem;


// leaf class for individual devices
public class VerySmartDevice implements Device {
    private String name;
    private boolean isOn;

    public VerySmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    @Override
    // turn device on
    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }

    @Override
    // turn device off
    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    @Override
    // get device status
    public String getStatus() {
        return name + " is " + (isOn ? "ON" : "OFF");
    }
}
