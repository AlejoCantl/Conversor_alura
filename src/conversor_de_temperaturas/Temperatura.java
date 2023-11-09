/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor_de_temperaturas;

/**
 *
 * @author Alejo
 */
public abstract class Temperatura implements Temperaturas{
  private Number temperatura;
  private Number cambio;
  
  public static String tip [] = {"TemperaturaCelsius","TemperaturaFahrenheit","TemperaturaKelvin"};

  @Override
    public Number getTemperatura() {
        return this.temperatura;
    }

  @Override
    public void setTemperatura(Number temperatura) {
        this.temperatura = temperatura;
        this.cambio=0;
    }

  @Override
    public Number getCambio() {
        return cambio;
    }

  @Override
    public void setCambio(Number cambio) {
        this.cambio = cambio;
    }

    public Temperatura() {
        this.temperatura=0;
        this.cambio=0;
    }

    public Temperatura(Number temperatura, Number cambio) {
        this.temperatura = temperatura;
        this.cambio = cambio;
    }
  
}