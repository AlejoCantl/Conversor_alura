package conversor_de_monedas_v2;

import java.util.Random;

public class LibraEsterlina extends Dinero {
	public LibraEsterlina(Number moneda, Number tasa) {
		super(moneda,tasa);
		
	}
public LibraEsterlina(){
super();
super.tasa= 1.20+(1.40-1.20)*new Random().nextDouble();
}
    @Override
    public String getSimbolo() {
       return "£";
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
