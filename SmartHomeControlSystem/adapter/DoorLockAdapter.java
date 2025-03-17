package SmartHomeControlSystem.adapter;

import SmartHomeControlSystem.composite.Device;

// adapter
public class DoorLockAdapter implements Device {
    private LegacyDoorLock legacyLock;


    public DoorLockAdapter(LegacyDoorLock legacyLock) {
        this.legacyLock = legacyLock;
    }

    @Override
    // adapt turn on to activate
    public void turnOn() {
        legacyLock.activate();
    }

    @Override
    // adapt turn off to deactivate
    public void turnOff() {
        legacyLock.deactivate();
    }

    @Override
    // adapt status retrieval
    public String getStatus() {
        return legacyLock.checkStatus();
    }
}