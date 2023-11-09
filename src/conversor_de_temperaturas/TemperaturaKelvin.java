/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor_de_temperaturas;

/**
 *
 * @author Alejo
 */
public class TemperaturaKelvin extends Temperatura {
    
    public TemperaturaKelvin(Number temperatura, Number cambio) {
        super(temperatura, cambio);
    }
    
    public TemperaturaKelvin(){
    super();
    }

    @Override
    public Number convertToKelvin() {
        return super.getTemperatura(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Number convertToFahrenheit() {
        return super.getCambio().doubleValue() + ((super.getTemperatura().doubleValue() - 273.15) * 9 / 5) + 32; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Number convertToCelsius() {
        return super.getTemperatura().doubleValue()-273.15 + super.getCambio().doubleValue(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getSimbolo() {
        return "K";
    }
    
    
}
