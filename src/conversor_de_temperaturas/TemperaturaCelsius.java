/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor_de_temperaturas;

/**
 *
 * @author Alejo
 */
public class TemperaturaCelsius extends Temperatura {
    public TemperaturaCelsius(Number temperatura, Number cambio) {
        super(temperatura, cambio);
    }
    
    public TemperaturaCelsius(){
    super();
    }
    @Override
    public Number convertToCelsius() {
       return super.convertToCelsius();
    }
    @Override
    public Number convertToFahrenheit() {
       return super.convertToFahrenheit();
    }
    @Override
    public Number convertToKelvin() {
      return super.convertToKelvin();
    }

    @Override
    public String getSimbolo() {
        return "°C";
    }
}
