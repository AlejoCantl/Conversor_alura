package conversor_de_monedas_v2;

public class ConversorUtil {
	
	    public static double convertirMoneda(Number tasa1, Number tasa2) {
                try{
	        return tasa2.doubleValue()/tasa1.doubleValue();
                }
                catch(Exception e){
                e.printStackTrace();
                }
                return 0;
	    }
	

}
