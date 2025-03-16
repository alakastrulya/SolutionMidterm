package SmartHomeControlSystem;

// factory for basic devices
public class BasicSmartHomeFactory implements SmartHomeFactory {
    @Override
    public Device createLight() {
        return new VerySmartDevice("Basic Light");
    }

    @Override
    public Device createThermostat() {
        return new VerySmartDevice("Basic Thermostat");
    }

    @Override
    public Device createCamera() {
        return new VerySmartDevice("Basic Camera");
    }
}