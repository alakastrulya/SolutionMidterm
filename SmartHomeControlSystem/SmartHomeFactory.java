package SmartHomeControlSystem;

// abstract factory
public interface SmartHomeFactory {
    // create light device
    Device createLight();
    // create thermostat device
    Device createThermostat();
    // create camera device
    Device createCamera();
}