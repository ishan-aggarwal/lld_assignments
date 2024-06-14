package com.assignment.question;

// The WeatherMonitoringApplication class extends the Publisher abstract class and represents a subject in the Observer Pattern.
public class WeatherMonitoringApplication extends Publisher {

    private double temperature; // The current temperature
    private double humidity; // The current humidity
    private double pressure; // The current pressure
    private double temperatureThreshold; // The temperature threshold for sending notifications
    private double humidityThreshold; // The humidity threshold for sending notifications
    private double pressureThreshold; // The pressure threshold for sending notifications

    public WeatherMonitoringApplication(double initialTemperature, double initialHumidity, double initialPressure,
                                        double temperatureThreshold, double humidityThreshold, double pressureThreshold) {
        this.temperature = initialTemperature;
        this.humidity = initialHumidity;
        this.pressure = initialPressure;
        this.temperatureThreshold = temperatureThreshold;
        this.humidityThreshold = humidityThreshold;
        this.pressureThreshold = pressureThreshold;
    }

    public void updateWeatherConditions(double newTemperature, double newHumidity, double newPressure) {
        temperature = newTemperature;
        humidity = newHumidity;
        pressure = newPressure;

        if (temperature > temperatureThreshold) {
            notifyObservers(temperature); // If the temperature is greater than the temperature threshold, notifies all observers
        }

        if (humidity > humidityThreshold) {
            notifyObservers(humidity); // If the humidity is greater than the humidity threshold, notifies all observers
        }

        if (pressure > pressureThreshold) {
            notifyObservers(pressure); // If the pressure is greater than the pressure threshold, notifies all observers
        }
    }
}

/*
    In this code, the Observer interface defines operations that all concrete observers must implement.
    The HumidityService, PressureService, and TemperatureService classes are concrete observers that send notifications when the humidity, pressure, and temperature change, respectively.
    They implement the Observer interface and provide their own implementations of the notifyObserver method.
    The ObserverRegistry interface defines operations for managing observers.
    The Publisher abstract class implements the ObserverRegistry interface and provides a default implementation for managing observers.
    The WeatherMonitoringApplication class extends the Publisher abstract class and represents a subject in the Observer Pattern.
    It maintains a list of observers and notifies them when the weather conditions change.

    This is a classic implementation of the Observer Pattern.
    It is a behavioral design pattern that enables an object, called the subject, to maintain a list of its dependents, called observers, and notify them automatically of any state changes.

 */