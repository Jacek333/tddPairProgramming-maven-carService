package com.no_company.carservice;

public class Car {

    //FIELDS
    private int maximumFuelLevel = 100;
    private int fuelLevel = 0;
    private boolean isDirty = true;
    private int burningFactor = 0;
    private int kph = 0;
    private int counter = 0;
    private String fuelType = "";

    //CONSTRUCTORS
    public Car(String fuelType) {
        this.fuelType = fuelType;
    }

    //METHODS
    public void drive(int distanceKm) {
        if (getKph()==0) setKph(50);
        fuelLevel -= distanceKm*burningFactor;
        if (fuelLevel < 0 ) throw new RuntimeException("You cant have less fuel than zero!");

        counter += distanceKm;
        if (counter>=30) isDirty = true;
    }



    //GETTERS, SETTERS
    public int getMaximumFuelLevel() {
        return maximumFuelLevel;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public int getBurningFactor() {
        return burningFactor;
    }

    public void setBurningFactor(int burningFactor) {
        this.burningFactor = burningFactor;
    }

    public int getKph() {
        return kph;
    }

    public void setKph(int kph) {
        this.kph = kph;
        if (kph >= 100) {
            setBurningFactor(2);
        } else if (burningFactor <= 100) {
            setBurningFactor(1);
        }
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean getIsDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

}
