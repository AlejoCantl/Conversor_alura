package conversor_de_monedas_v2;

import java.util.Random;

public class PesoColombiano extends Dinero {
	public PesoColombiano(Number moneda, Number tasa) {
		super(moneda,tasa);
		
	}
public PesoColombiano(){
super();
super.tasa=2000+(3000-2000)*new Random().nextDouble();
}
    @Override
    public String getSimbolo() {
     return "$";
    }

    @Override
    public Number getTasa() {
        return this.tasa.doubleValue();
    }

   @Override
    public Number convertir(Number cantidad, Dinero moneda) {
        if((double) this.getTasa()==0.0 || (double) moneda.getTasa()==0.0){
        throw new IllegalArgumentException("Las tasas de cambio no pueden ser cero.");
        }
       return cantidad.doubleValue()*(ConversorUtil.convertirMoneda(this.getTasa(),moneda.getTasa()));
    }
}
