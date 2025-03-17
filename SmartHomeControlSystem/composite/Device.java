package SmartHomeControlSystem.composite;

public interface Device {
    void turnOn(); // turn device on
    void turnOff(); // turn device off
    String getStatus(); // get device status
}
