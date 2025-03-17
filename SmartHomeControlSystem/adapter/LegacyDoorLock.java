package SmartHomeControlSystem.adapter;

//door lock system with incompatible interface
public class LegacyDoorLock {
    public void activate() {
        System.out.println("Legacy Door Lock activated");
    }

    public void deactivate() {
        System.out.println("Legacy Door Lock deactivated");
    }

    public String checkStatus() {
        return "Legacy Door Lock status unknown";
    }
}