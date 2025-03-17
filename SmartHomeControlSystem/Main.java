package SmartHomeControlSystem;
import SmartHomeControlSystem.abstractfactory.AdvancedSmartHomeFactory;
import SmartHomeControlSystem.abstractfactory.BasicSmartHomeFactory;
import SmartHomeControlSystem.abstractfactory.SmartHomeFactory;
import SmartHomeControlSystem.adapter.DoorLockAdapter;
import SmartHomeControlSystem.adapter.LegacyDoorLock;
import SmartHomeControlSystem.composite.Device;
import SmartHomeControlSystem.composite.DeviceGroup;
import SmartHomeControlSystem.facade.SmartHomeController;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create factories
        SmartHomeFactory basicFactory = new BasicSmartHomeFactory();
        SmartHomeFactory advancedFactory = new AdvancedSmartHomeFactory();

        // create composite structure
        DeviceGroup home = new DeviceGroup("Home");
        DeviceGroup livingRoom = new DeviceGroup("Living Room");
        DeviceGroup bedroom = new DeviceGroup("Bedroom");

        // add basic devices to living room
        livingRoom.add(basicFactory.createLight());
        livingRoom.add(basicFactory.createThermostat());

        // add advanced devices to bedroom
        bedroom.add(advancedFactory.createLight());
        bedroom.add(advancedFactory.createCamera());

        // add legacy door lock via adapter
        Device doorLock = new DoorLockAdapter(new LegacyDoorLock());
        home.add(doorLock);

        // build hierarchy
        home.add(livingRoom);
        home.add(bedroom);

        // create facade with room access
        SmartHomeController controller = new SmartHomeController(home);

        // start interactive demo
        System.out.println(" Smart Home Control System ");
        System.out.println("commands: 'allon' (all on), 'alloff' (all off), 'status' (get status),");
        System.out.println("         'livingon' (living room on), 'livingoff' (living room off),");
        System.out.println("         'bedroomon' (bedroom on), 'bedroomoff' (bedroom off), 'exit'");

        while (true) {
            System.out.print("enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();


            switch (command) {
                case "allon":
                    controller.turnAllOn();
                    break;
                case "alloff":
                    controller.turnAllOff();
                    break;
                case "status":
                    System.out.println(controller.getSystemStatus());
                    break;
                case "livingon":
                    livingRoom.turnOn();
                    break;
                case "livingoff":
                    livingRoom.turnOff();
                    break;
                case "bedroomon":
                    bedroom.turnOn();
                    break;
                case "bedroomoff":
                    bedroom.turnOff();
                    break;
                case "exit":
                    System.out.println(" Exiting from home");
                    scanner.close();
                    return;
                default:
                    System.out.println("invalid command! check available commands above");
            }
        }
    }
}