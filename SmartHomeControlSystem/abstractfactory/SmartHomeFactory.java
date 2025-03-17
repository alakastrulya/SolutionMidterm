package SmartHomeControlSystem.abstractfactory;

import SmartHomeControlSystem.composite.Device;

// abstract factory
public interface SmartHomeFactory {
    // create light
    Device createLight();
    // create thermostat
    Device createThermostat();
    // create camera
    Device createCamera();
}