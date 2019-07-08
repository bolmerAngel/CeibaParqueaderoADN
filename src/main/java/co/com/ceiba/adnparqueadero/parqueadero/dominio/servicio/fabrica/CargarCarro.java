package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;

public class CargarCarro implements CobroEstacionamiento {

	  private static final int HORA_EFECTIVO_POR_DIA = 9;
	    private static final int VALOR_POR_HORA = 1000;
	    private static final int VALOR_POR_DIA = 8000;
	    private static final int MILISEGUNDO_POR_HORA = 3600000;
	    private static final int MILISEGUNDO_POR_MINUTO = 60000;
	    private static final int MINUTO_A_MINUTO = 10;
	    private static final int HORAS_DEL_DIA = 24;
	    
	    
	    @Override
	    public void establecerCarga(RegistroVehiculo registroVehiculo) {
	    	Integer valor = 0;
	    	 double milisegundo = (registroVehiculo.getDiasalida().getTime() - registroVehiculo.getDiallegada().getTime());
	         double hora = (milisegundo/MILISEGUNDO_POR_HORA);
	         double minuto = (milisegundo/ MILISEGUNDO_POR_MINUTO);
	         long totalHora =  Math.round(hora);
	         long totalMinuto = Math.round(minuto);
	         int totalDia = (int)  totalHora /  HORAS_DEL_DIA ;
	         int  totalHoranuevadia = (int) totalHora %  HORAS_DEL_DIA ;
	    	 
	         if(totalHora <HORA_EFECTIVO_POR_DIA){
	             if((totalMinuto >= MINUTO_A_MINUTO) && (totalHora == 0)){
	                 valor = VALOR_POR_HORA ;
	             }else{
	                 valor = (int) (totalHora * VALOR_POR_HORA) ;
	             }

	         }else if(totalHoranuevadia == 0 || (totalHoranuevadia >= HORA_EFECTIVO_POR_DIA && totalHoranuevadia< HORAS_DEL_DIA)){
	             valor = (VALOR_POR_DIA  * (totalDia == 0 ? 1:totalDia));
	         }else{
	             valor = ((VALOR_POR_DIA  * totalDia) + (totalHoranuevadia * VALOR_POR_HORA ));
	         }
	         registroVehiculo.setValor(valor);
	    }
}
