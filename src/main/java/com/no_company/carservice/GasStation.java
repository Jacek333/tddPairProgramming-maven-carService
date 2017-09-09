package com.no_company.carservice;

public class GasStation {

    //FIELDS
    private int stationFuelLevel = 0;

    //CONSTRUCTORS

    //METHODS
    public void refuelCar(Car carToRefuel, String fuelType) {

        if ( !fuelType.equalsIgnoreCase(carToRefuel.getFuelType()) ) {
            throw new RuntimeException("Wrong fuel type!");
        }

        int requiredFuel = carToRefuel.getMaximumFuelLevel()-carToRefuel.getFuelLevel();
        if (stationFuelLevel<requiredFuel) {
            throw new RuntimeException("Station have not enough fuel");
        }

        stationFuelLevel -= requiredFuel;
        carToRefuel.setFuelLevel( carToRefuel.getMaximumFuelLevel() );

    }

    public void washCar(Car carToWash) {
        carToWash.setDirty(false);
    }

    public void convertToGas(Car carToGas){
        if ( carToGas.getFuelType().equalsIgnoreCase("Gas") ) {
            throw new RuntimeException("Your car is using gas already!");
        } else {
            carToGas.setFuelType("Gas");
        }
    }

    //GETTERS, SETTERS
    public int getStationFuelLevel() {
        return stationFuelLevel;
    }

    public void setStationFuelLevel(int stationFuelLevel) {
        this.stationFuelLevel = stationFuelLevel;
    }
}
