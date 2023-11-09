/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conversor_de_temperaturas;

/**
 *
 * @author Alejo
 */
public interface Temperaturas {
    Number getTemperatura();
    void setTemperatura(Number temperatura);
    Number getCambio();
    void setCambio(Number cambio);
    String getSimbolo();
    default Number convertToCelsius() {
        // Implementación por defecto para convertir a Celsius
        return getTemperatura().doubleValue();
    }

    default Number convertToFahrenheit() {
        // Implementación por defecto para convertir a Fahrenheit
        return (getTemperatura().doubleValue() * 9 / 5) + 32 + getCambio().doubleValue();
    }

    default Number convertToKelvin() {
        // Implementación por defecto para convertir a Kelvin
        return getTemperatura().doubleValue() + 273.15 + getCambio().doubleValue();
    }
}
