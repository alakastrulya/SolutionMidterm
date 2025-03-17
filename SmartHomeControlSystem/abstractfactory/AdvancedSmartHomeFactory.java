package SmartHomeControlSystem.abstractfactory;

import SmartHomeControlSystem.composite.Device;
import SmartHomeControlSystem.composite.VerySmartDevice;
import SmartHomeControlSystem.decorator.DeviceLog;
import SmartHomeControlSystem.decorator.DeviceScheduled;

// factory for advanced devices with extra features
public class AdvancedSmartHomeFactory implements SmartHomeFactory {
    @Override
    // create light with logging
    public Device createLight() {
        return new DeviceLog(new VerySmartDevice("Advanced Light"));
    }

    @Override
    // create thermostat with scheduling
    public Device createThermostat() {
        return new DeviceScheduled(new VerySmartDevice("Advanced Thermostat"), "12:00");
    }

    @Override
    // create advanced camera with both logging and scheduling
    public Device createCamera() {
        return new DeviceLog(new DeviceScheduled(new VerySmartDevice("Advanced Camera"), "20:00"));
    }
}
