/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor_de_temperaturas;

/**
 *
 * @author Alejo
 */
public class TemperaturaFahrenheit extends Temperatura{
    
    public TemperaturaFahrenheit(Number temperatura, Number cambio) {
        super(temperatura, cambio);
    }
    
    public TemperaturaFahrenheit(){
    super();
    }
    
    @Override
    public Number convertToKelvin() {
        return  ((super.getTemperatura().doubleValue()- 32) * 5 / 9 + 273.15)+super.getCambio().doubleValue();
    }

    @Override
    public Number convertToFahrenheit() {
        return  super.getTemperatura();
    }

    @Override
    public Number convertToCelsius() {
        return ((super.getTemperatura().doubleValue()- 32)* 5 / 9)+super.getCambio().doubleValue();
    }

    @Override
    public String getSimbolo() {
       return "°F";
    }
    
}
