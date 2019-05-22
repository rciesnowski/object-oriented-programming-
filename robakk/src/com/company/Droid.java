package com.company;

public class Droid {
    int batteryLevel;
    String name;
    public Droid() {
        batteryLevel = 100;
    }
    public void setName(String newName) {
        name = newName;
        System.out.println("robak nazywa sb " + name);
    }
    public int checkBatteryLevel() {
        System.out.println("poziom zycka wynosi " + batteryLevel);
        if (batteryLevel <= 0) System.out.println("robak " + name + " zdech");
        return batteryLevel;
    }

    public void activate() {
        System.out.println("robak fruwa i jest to meczace");
        batteryLevel -= 5;
        checkBatteryLevel();
    }
    public void chargeBattery(int hours) {
        System.out.println("robak zre " + hours + " liscie i jest ok");
        batteryLevel += 5*hours;
        if (batteryLevel > 100) batteryLevel = 100;
        else checkBatteryLevel();
    }

    public void hover (int feet) {
        if (feet > 20) System.out.println("upsi odlatuje - nie wolno mu tak daleko!!");
        else {
            System.out.println("robak lata " + feet + " metrow nad tb . . .");
            batteryLevel -= 3*feet;
            checkBatteryLevel();
        }
    }
    public void ruchanko() {
        System.out.println("robak robi ruchanko i jest to meczace");
        batteryLevel -= 30;
        checkBatteryLevel();
        Droid junior = new Droid();
        System.out.println("urodzil sb robak");
        junior.setName(name + " junior");
        junior.checkBatteryLevel();
    }
    public static void main(String[] args) {

        Droid trzmiel = new Droid();
        trzmiel.setName("Wojtek");
        trzmiel.activate();
        trzmiel.hover(13);
        trzmiel.hover(47);
        trzmiel.chargeBattery(4);
        trzmiel.ruchanko();
        trzmiel.hover(19);
    }
}