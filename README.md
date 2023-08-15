[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-8d59dc4de5201274e310e4c54b9627a8934c3b88527886e3b421487c677d23eb.svg)](https://classroom.github.com/a/2vEOoG3r)

# COMP 132: Advanced Programming 

## IMPORTANT NOTE 1 : Pledge of Honor 

For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-5 Prelab: Type Hierarchy for Aircrafts


In this programming assignment, you are asked to build a Java **type hierarchy** aimed to represent types of aircrafts and their up to date conditions using the **inheritance and polymorphism concepts**.

You are provided with a Java project template and you should do your development on this template.

In the given Java project, a main program code **Test.java** in package **work** is provided to test your code. Note that we may test your codes with other test cases as well.

You should create another package named **aircrafts** that should include all the types described below. Based on the descriptions below, **you should decide whether each type should be an abstract class, a concrete class, superclass, subclass, or an interface**.

- **Aircraft**: Refers to the general type entity that can be flown.
- **FueledAircraft**: A kind of aircraft that runs on petroleum.
- **Plane**: A kind of fueled aircraft.  
- **Glider**: A kind of aircraft.
- **Flyable**: All Aircraft objects are flyable objects. They should implement their void fly(double km) method.

**Important Note**:  **For each class implementation, you must decide which access modifiers should be used for instance variables (e.g. private, protected or public). In some of the classes, you may need to decide on which data types and names you should use for those variables as well.** 

The required fields and methods of the types are described below:

### Aircraft 
An Aircraft has the following members:
- A `static` field `aircraftList` of type `ArrayList<Aircraft>`. This field should be initialized once and in such a way that it cannot be altered after that. Holds all aircraft objects generated so far.
- A field `brandAndModel` of type `String` that keeps the brand and model information of the aircraft.
- A field `aircraftPrice` of type `double` that denotes the price of the aircraft in USD. 
- A field `totalFlightDistance` of type 'double' that denotes the total flight distance of the aircraft.
- A `static` method `int getAircraftQuantity()` that returns the total number of aircrafts being held by  `aircraftList`.
- Getter methods for the other non-static fields.
- An `abstract` method `void fly(double km)` that can be implemented differently for different subtypes of Aircrafts.
- A constructor `Aircraft(String brandAndModel, double aircraftPrice)`, initializes `brandAndModel` and `aircraftPrice` fields with input arguments and adds this plane to the `aircraftList`.
  - Make sure you check the input values inside the constructor properly. The constructor should check the input arguments to be reasonable and give values to variables based on how the inputs are. To do so:
    - The `aircraftPrice` cannot be less than zero, If so, set it to zero. 
    - If input of `brandAndModel` is null or empty (you can check String length by calling length() instance method), then set `brandAndModel` to `Anonymous`.
- A method `String toString()` that would print out the information about the aircraft namely `brandAndModel`, `aircraftPrice`, and `totalFlightDistance`. Take a closer look at the sample output to see the method’s behavior in more detail.

### FueledAircraft 
`FueledAircraft` has the following members:
- A field `fuelTankCapacity` of type `double`, signifies the storage capacity of the tank of the `FueledAircraft`,  in terms of liters.
- A field `fuelAmount` of type `double`, denotes the current fuel amount of the tank of the `FueledAircraft`, in terms of liters. 
  - **Bear in mind** that the field `fuelAmount` cannot be less than zero and cannot be greater than `fuelTankCapacity`.
- A field `fueltoRangeRatio` of type `double`, denotes the ratio that is used to convert the current `fuelAmount` (in liters).
    - **Important Note:** For this assignment, we will assume that the relation between the `fuelAmount` and the aircraft’s current range is linear.
i.e., the aircraft’s current range (km) = fuelAmount (lt) * fueltoRangeRatio (km/lt). 
- A constructor `FueledAircraft(String brandAndModel, double aircraftPrice, double fuelTankCapacity, double fuelAmount, double fueltoRangeRatio )` 
    - **Important Note:** Make sure you check the input values inside the constructor properly. The constructor should check the input arguments to be reasonable and give values  to variables based on how the inputs are. To do so:
        - If input of `fuelTankCapacity` is less than 10, then set it to 10.
        - If input of `fuelAmount` is negative, then set it to 0.
        - If input of `fuelAmount` is more than `fuelTankCapacity`, then set it to `fuelTankCapacity`.
        - If input of `fueltoRangeRatio` is less than one, then set it to 1.
- Getter methods for the `fuelAmount`, `fuelTankCapacity`, and `fuelToRangeRatio` fields
- The method `void fly(double km)`. As mentioned previously, all `Aircraft` objects are `Flyable` objects. Since a `FueledAircraft` is a kind of `Aircraft`, it must implement its own `fly(double km)` method. 
    - The method first checks whether the input argument is reasonable, i.e. greater than zero.
        - If it is not, you should print a message as `Fly Fueled Aircraft input is invalid !!` 
        - If it is, then it checks the input argument against the `FueledAircraft`s current range. 
            - If input argument `km` is within `FueledAircraft`s current range, then the method fly the `FueledAircraft`, meaning it updates its `fuelAmount` according to the same criteria outlined during the description of the `fuelToRangeRatio` section. The method should finally print the name of the fueled aircraft, and the fuel amount. Take a closer look at the sample output to get insight. 
            - If input argument `km` is outside of the `FueledAircraft`s current range, you should print a message. Take a closer look at the sample output to get insight.
- A `toString()` method that returns the information about the `FueledAircraft`’s `brandAndModel`,  `price`, `fuelAmount`, aircraft’s maximum range, and aircraft’s current range. Take a closer look at the sample output to see the method’s behavior in more detail.

### Plane 
A `Plane` has the following members:
- A `static` field `planeList` of type `ArrayList<Plane>`. This field should be initialized once and in a way that it cannot be altered after that.
- A constructor `Plane(String brandAndModel, double aircraftPrice, double tank, double fuel, double ratio)` that Initializes necessary fields with the input arguments and adds this plane to the `planeList`.
- A `static` int method `getPlaneQuantity()` that would return the size of `planeList`.
- An `String` method `toString()` that would print out the information about the `Plane`. Take a closer look at the sample output to see the method’s behavior in more detail.

### Glider 
A `Glider` has the following members:
- A `static` field `gliderList` of type `ArrayList<Glider>`. This field should be initialized once and in a way that it cannot be altered after that.
- A field `helperPlane` of type Plane; which helps a glider to fly.
- A constructor `Glider(String brandAndModel, double aircraftPrice, Plane helperPlane)` that initializes necessary fields with the input arguments and adds this glider to the `gliderList`.
- A `static` int method `getGliderQuantity()` that would return the size of `gliderList`.
- A `String` method `toString()` that would print out the information about the `Glider`. Take a closer look at the sample output to see the method’s behavior in more detail.
- The method `void fly(double km)`. As mentioned previously, all `Aircraft` objects are `Flyable` objects. Since a `Glider` is a kind of `Aircraft`, it must implement its own `fly(double km)` method. The method first checks whether the input argument is reasonable, i.e. greater than zero.
    - If it is, then it checks the quarter of the input argument against the `helperPlane`s current range (check FueledAircraft’s fly method on how to calculate). 
        - If the quarter of the input argument `km/4` is within `helperPlane`s current range, then the method will call `helperPlane`s fly method with the quarter of the input argument `km/4` and update the `Glider`s current totalFlightDistance and print information. Take a closer look at the sample output to see the method’s behavior in more detail.

## Sample Output 

```console
Total number of Aircrafts before creating aircrafts: 0

Total number of Aircrafts after creating aircrafts: 5
Total number of Planes after creating aircrafts: 4
Total number of Gliders after creating aircrafts: 1

Aircraft Type: Plane
Name: Anonymous 
Price: 0.0 $ 
Total Flight Distance: 0.0
Max Range: 5.0 kms 
Current Fuel Level: 0.0 liters 
Current Range: 0.0 kms


Aircraft Type: Plane
Name: Boeing 737 
Price: 720000.0 $ 
Total Flight Distance: 0.0
Max Range: 5600.0 kms 
Current Fuel Level: 200.0 liters 
Current Range: 1600.0 kms


Aircraft Type: Plane
Name: Cessna 172 
Price: 50000.0 $ 
Total Flight Distance: 0.0
Max Range: 1350.0 kms 
Current Fuel Level: 50.0 liters 
Current Range: 450.0 kms


Aircraft Type: Plane
Name: Diamond DA42 
Price: 75000.0 $ 
Total Flight Distance: 0.0
Max Range: 3000.0 kms 
Current Fuel Level: 150.0 liters 
Current Range: 750.0 kms

Aircraft Type: Glider
Name: DG Aviation DG1001Club 
Price: 200000.0 $ 
Total Flight Distance: 0.0
Helper Plane: Cessna 172


Fueled Aircraft Boeing 737 flew 250.0 kilometers, 168.75 liters of fuel left. 
Fueled Aircraft Current Range: 1350.00 kilometers 

Fueled Aircraft Cessna 172 flew 50.0 kilometers, 44.44 liters of fuel left. 
Fueled Aircraft Current Range: 400.00 kilometers 

Fueled Aircraft Diamond DA42 flew 240.0 kilometers, 102.00 liters of fuel left. 
Fueled Aircraft Current Range: 510.00 kilometers 

Fueled Aircraft Cessna 172 flew 75.0 kilometers, 36.11 liters of fuel left. 
Fueled Aircraft Current Range: 325.00 kilometers 

Glider DG Aviation DG1001Club flew 300.0 kilometers.

Fueled Aircraft Boeing 737 flew 600.0 kilometers, 93.75 liters of fuel left. 
Fueled Aircraft Current Range: 750.00 kilometers 

Fueled Aircraft Cessna 172 could only fly 325.00 kilometers, 0.00 liters of fuel left. 
Fueled Aircraft Current Range: 0.00 kilometers 

Fueled Aircraft Diamond DA42 flew 300.0 kilometers, 42.00 liters of fuel left. 
Fueled Aircraft Current Range: 210.00 kilometers 

Glider DG Aviation DG1001Club could not fly...

Fueled Aircraft Cessna 172 could not fly...  0.00 liters of fuel left. 
Fueled Aircraft Current Range: 0.00 kilometers 
```
