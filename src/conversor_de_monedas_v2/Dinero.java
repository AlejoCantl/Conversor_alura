package conversor_de_monedas_v2;


import java.util.Arrays;

public abstract class Dinero{
private Number dinero;
Number tasa;

public abstract Number getTasa();

public abstract String getSimbolo();



public static String tip [] = {"PesoColombiano","Dolar", "LibraEsterlina","Euro"};

public static boolean getTip(Object o) {
    if (o instanceof String str) {
      return  Arrays.asList(tip).contains(str);
        
    }
    return false;
}




public Dinero() {
}

public abstract Number convertir(Number cantidad, Dinero moneda);

public Dinero(Number dinero, Number tasa) {
	this.dinero = dinero;
	this.tasa = tasa;
}

public Number getMoneda() {
	return dinero;
}

public void setMoneda(Number dinero) {
	this.dinero = dinero;
}

}
