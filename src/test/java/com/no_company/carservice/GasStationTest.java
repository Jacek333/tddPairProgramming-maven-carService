package com.no_company.carservice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class GasStationTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    Car fueledImpala;
    GasStation gasStation;
    @Before
    public void before() {
        fueledImpala = new Car("gas");
        gasStation = new GasStation();
        gasStation.setStationFuelLevel(1100);
        gasStation.refuelCar(fueledImpala,"gas");
    }

    @Test
    public void givenFueledCarWhenGetFuelLevelThen100() {
        assertEquals(100, fueledImpala.getFuelLevel());
    }

    @Test
    public void givenIsDirtyTrueWhenWashCarThenIsDirtyFalse() {
        gasStation.washCar(fueledImpala);
        assertEquals(false, fueledImpala.getIsDirty());
    }

    @Test
    public void givenFuelLevel100WhenDrive100ThenFuelLevel0() {
        fueledImpala.drive(100);
        assertEquals(0, fueledImpala.getFuelLevel());
    }

    @Test
    public void givenBurningFactor1WhenDrive100KphThenBurningFactor2() {
        fueledImpala.setKph(100);
        assertEquals(2, fueledImpala.getBurningFactor());
    }

    @Test
    public void givenBurningFactor2WhenDrive50KphThenBurningFactor1() {
        fueledImpala.setKph(100);
        fueledImpala.setKph(50);
        assertEquals(1, fueledImpala.getBurningFactor());
    }

    @Test
    public void givenKph0WhenDriveThenKph50(){
        fueledImpala.drive(10);
        assertEquals(50, fueledImpala.getKph());
    }

    @Test
    public void givenBurningFactor2whenDrive50KmThenFuelLevel0(){
        fueledImpala.setKph(150);
        fueledImpala.drive(50);
        assertEquals(0, fueledImpala.getFuelLevel());
    }

    @Test
    public void givenIsDirtyFalseWhenDrive30KmThenIsDirtyTrue(){
        gasStation.washCar(fueledImpala);
        fueledImpala.drive(10);
        fueledImpala.drive(10);
        fueledImpala.drive(10);
        assertEquals(true, fueledImpala.getIsDirty());
    }

    @Test
    public void givenFuelLevel100WhenDrive150ThenRuntimeException() {
        exception.expect(RuntimeException.class);
        fueledImpala.drive(150);
    }

    @Test
    public void givenFuelTypeGasWhenRefuelDieselThenRuntimeException(){
        exception.expect(RuntimeException.class);
        gasStation.refuelCar(fueledImpala,"Diesel");
    }

    @Test
    public void givenFuelTypeDieselWhenConvertToGasThenFuelTypeGas() {
        Car dieselImpala = new Car("Diesel");
        gasStation.convertToGas(dieselImpala);
        assertEquals("Gas", dieselImpala.getFuelType());
    }

    @Test
    public void givenFuelTypeToGasWhenConvertToGasThenRuntimeException(){
        exception.expect(RuntimeException.class);
        Car gasImpala = new Car("Gas");
        gasStation.convertToGas(gasImpala);
    }

    @Test
    public void givenFuelLevel0AndStationFuelLevel0WhenRefuelCarThenRuntimeException() {
        exception.expect(RuntimeException.class);

        Car noFuelImpala = new Car("Diesel");
        gasStation.setStationFuelLevel(0);

        gasStation.refuelCar(noFuelImpala, noFuelImpala.getFuelType());
    }

    @Test
    public void givenFuelLevel0AndStationFuelLevel1000WhenRefuelCarThenStationFuelLevel900() {
        Car noFuelImpala = new Car("Diesel");
        gasStation.setStationFuelLevel(1000);

        gasStation.refuelCar(noFuelImpala, noFuelImpala.getFuelType());
        assertEquals(900, gasStation.getStationFuelLevel());
    }



}
