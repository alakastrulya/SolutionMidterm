# Midterm projects

this repository contains three projects demonstrating various design patterns in Java: **Smart Home Control System**, **Coffee Shop Simulator**, and **Online Payment System**. each project showcases different patterns to solve problems like device management, coffee customization, and payment processing.

---

## Smart Home Control System

### Overview
the Smart Home Control System simulates managing smart devices (lights, thermostats, cameras) in a home. it uses multiple design patterns to create a flexible and scalable system.

### Design Patterns Used

#### Composite Pattern
- **purpose**: organizes devices into a hierarchy of individual devices (leaves) and groups (composites) like rooms or floors.
- **implementation**:
  - `Device` interface: defines `turnOn()`, `turnOff()`, `getStatus()`.
  - `SmartDevice`: leaf class for individual devices (e.g., "Basic Light").
  - `DeviceGroup`: composite class to group devices (e.g., "Living Room").
- **example**: a `DeviceGroup` named "Home" contains "Living Room" (with a light and thermostat) and "Bedroom" (with a light and camera).

#### Decorator Pattern
- **purpose**: adds dynamic behaviors to devices, like scheduling or logging.
- **implementation**:
  - `DeviceDecorator`: abstract decorator class wrapping a `Device`.
  - `ScheduledDevice`: adds scheduling (e.g., "turn on at 18:00").
  - `LoggingDevice`: logs actions (e.g., "Turning on device").
- **example**: an advanced camera is decorated with both logging and scheduling.

#### Abstract Factory Pattern
- **purpose**: creates families of related devices (basic vs. advanced).
- **implementation**:
  - `SmartHomeFactory` interface: defines `createLight()`, `createThermostat()`, `createCamera()`.
  - `BasicSmartHomeFactory`: creates basic devices.
  - `AdvancedSmartHomeFactory`: creates advanced devices with decorators.
- **example**: `AdvancedSmartHomeFactory` creates a "Logging Advanced Light".

#### Facade Pattern
- **purpose**: provides a simple interface to control the system.
- **implementation**:
  - `SmartHomeController`: offers methods like `turnAllOn()`, `getSystemStatusReport()`.
- **example**: `turnAllOn()` activates all devices in the home hierarchy.

#### Adapter Pattern
- **purpose**: integrates a legacy system into the smart home.
- **implementation**:
  - `LegacyDoorLock`: external system with `activate()` and `deactivate()`.
  - `DoorLockAdapter`: adapts `LegacyDoorLock` to the `Device` interface.
- **example**: a legacy door lock is controlled like other smart devices.

### Demo Output
the CLI demo shows:
- turning all devices on/off.
- status report of the home hierarchy.
- decorated devices with scheduling and logging.
- adapted legacy door lock in action.

---

## Coffee Shop Simulator

### Overview
the Coffee Shop Simulator allows users to create and customize coffee types (Cappuccino, Espresso, Latte) with syrups. it focuses on object creation and dynamic enhancement.

### Design Patterns Used

#### Abstract Factory Pattern
- **purpose**: creates different coffee types without hardcoding their classes.
- **implementation**:
  - `Coffee` interface: defines `getName()`, `getPrice()`, `getDescription()`, `makeCoffee()`, `pourIntoGlasses()`.
  - `CoffeeFactory` interface: declares `chooseCoffee()`.
  - `CappuccinoFactory`, `EspressoFactory`, `LatteFactory`: create respective coffee objects.
- **example**: `chooseCoffeeFactory("latte")` returns a `LatteFactory` that creates `LatteCoffee`.

#### Decorator Pattern
- **purpose**: customizes coffee with syrups, adding cost and description.
- **implementation**:
  - `SyrupDecorator`: abstract decorator wrapping a `Coffee` object.
  - `ChocolateSyrup`: adds 150 to price, " with Chocolate Syrup" to description.
  - `VanillaSyrup`: adds 100, " with Vanilla Syrup".
  - `SaltedCaramelSyrup`: adds 200, " with Salted caramel Syrup".
- **example**: `new ChocolateSyrup(new LatteCoffee())` creates a latte with chocolate syrup (price 1350).

### Demo Output
the `Main` class demonstrates:
- latte with chocolate syrup: price 1350, "favourite Latte Coffee with Chocolate Syrup".
- cappuccino with vanilla syrup: price 1100, "tasty Cappuccino Coffee with Vanilla Syrup".
- espresso with salted caramel syrup: price 700, "Super puper espresso coffee with Salted caramel Syrup".

---

## Online Payment System

### Overview
the Online Payment System simulates processing payments via Credit Card, PayPal, and Crypto. it handles transactions, transfers, and utility payments with a factory and adapter approach.

### Design Patterns

#### Abstract Factory Pattern
- **purpose**: creates payment methods (Credit Card, PayPal, Crypto) consistently.
- **implementation**:
  - `PaymentMethod` interface: defines `processPayment()`, `transferMoneyToAnotherClient()`, `paymentOfApartmentUtilities()`.
  - `PaymentFactory` interface: declares `createTransaction()`.
  - `CreditCardPaymentFactory`: creates `CreditCardPayment` with balance 20000.
  - `PayPalPaymentFactory`: creates `PayPalAdapter` or `PayPalPayment`.
  - `CryptoPaymentFactory`: creates `CryptoPayment`.
- **example**: `choosePaymentFactory("creditcard")` returns a `CreditCardPaymentFactory`.

#### Adapter Pattern
- **purpose**: integrates an external PayPal API into the system.
- **implementation**:
  - `PayPalAPI`: mock external API with `executeTransaction()`, `transferMoneyToAnotherClient()`, `paymentOfApartmentUtilities()`.
  - `PayPalAdapter`: adapts `PayPalAPI` to the `PaymentMethod` interface.
- **example**: `PayPalAdapter` processes a 10000 payment via `PayPalAPI`.

### Demo Output
the CLI demo in `Main` shows:
- credit card with insufficient funds: all transactions fail.
- paypal with adapter: processes 10000, transfers 5000, pays utilities 7500.
- crypto: processes payments and transfers successfully.

---

## Themes

### Abstract Factory Across Projects
- **smart home**: creates basic/advanced devices.
- **coffee shop**: creates coffee types.
- **payment system**: creates payment methods.
- **benefit**: ensures consistent object creation and easy extension.

### Decorator in Smart Home and Coffee Shop
- **smart home**: adds scheduling/logging to devices.
- **coffee shop**: adds syrups to coffee.
- **benefit**: dynamic behavior addition without modifying base classes.

### Adapter in Smart Home and Payment System
- **smart home**: integrates legacy door lock.
- **payment system**: integrates PayPal API.
- **benefit**: seamless inclusion of external systems.

---

## Conclusion

these projects demonstrate:
- **modularity**: patterns separate concerns (creation, enhancement, integration).
- **scalability**: new devices, coffees, or payment methods can be added easily.
- **real-world applicability**: mimics smart homes, coffee shops, and payment systems.

---

*student of 2nd year, Narxoz University, Akhmetova Aisha*
