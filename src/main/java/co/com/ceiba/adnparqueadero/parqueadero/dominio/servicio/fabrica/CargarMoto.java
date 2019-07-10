package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;

public class CargarMoto extends CargarCarro {

	 private static final int HORA_EFECTIVO_POR_DIA_MOTO = 9;
	    private static final int VALOR_POR_HORA_MOTO = 500;
	    private static final int VALOR_POR_DIA_MOTO = 4000;
	    private static final int MILISEGUNDO_POR_HORA_MOTO = 3600000;
	    private static final int MILISEGUNDO_POR_MINUTO_MOTO = 60000;
	    private static final int MINUTO_A_MINUTO_MOTO = 10;
	    private static final int HORAS_DEL_DIA_MOTO = 24;
	    private static final int VALOR_ADICIONAL_MOTO=2000;
	    private static final int CILINDRAJE_MAXIMO_MOTO = 500;
	    
	    
	    @Override
	    public void establecerCarga(RegistroVehiculo registroVehiculo) {
	    	Integer valorMoto = 0;
	    	 double milisegundoMoto = (registroVehiculo.getDiasalida().getTime() - registroVehiculo.getDiallegada().getTime());
	         double horaMoto = (milisegundoMoto/MILISEGUNDO_POR_HORA_MOTO);
	         double minutoMoto = (milisegundoMoto/ MILISEGUNDO_POR_MINUTO_MOTO);
	         double totalHoraMoto = (horaMoto);
	         double totalMinutoMoto = (minutoMoto);
	         int totalDiaMoto = (int)  totalHoraMoto /  HORAS_DEL_DIA_MOTO;
	         int  totalHoranuevadiaMoto = (int) totalHoraMoto %  HORAS_DEL_DIA_MOTO;
	    	 
	         if(totalHoraMoto <HORA_EFECTIVO_POR_DIA_MOTO){
	             if((totalMinutoMoto >= MINUTO_A_MINUTO_MOTO) && (totalHoraMoto == 0)){
	                 valorMoto = VALOR_POR_HORA_MOTO;
	             }else{
	                 valorMoto = (int) (totalHoraMoto * VALOR_POR_HORA_MOTO) ;
	             }

	         }else if(totalHoranuevadiaMoto == 0 || (totalHoranuevadiaMoto >= HORA_EFECTIVO_POR_DIA_MOTO && totalHoranuevadiaMoto< HORAS_DEL_DIA_MOTO)){
	             valorMoto = (VALOR_POR_DIA_MOTO  * (totalDiaMoto == 0 ? 1:totalDiaMoto));
	         }else{
	             valorMoto = ((VALOR_POR_DIA_MOTO  * totalDiaMoto) + (totalHoranuevadiaMoto * VALOR_POR_HORA_MOTO));
	         }
	         if(Integer.valueOf(registroVehiculo.getCilindraje()) >  CILINDRAJE_MAXIMO_MOTO){
	             valorMoto = valorMoto + VALOR_ADICIONAL_MOTO;
	         }
	        
	         registroVehiculo.setValor(valorMoto);
	    }
}
