package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionTipovehiculoValorNoNull;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.mensajes.MensageSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;


public class CargaFabrica {
	
	private CargaFabrica() {}
	
	 public static CargarCarro getInstance(String tipovehiculo) {
		 if(tipovehiculo.equalsIgnoreCase("CARRO")){
	            return  new CargarCarro();
	        }
		 else if(tipovehiculo.equalsIgnoreCase("MOTO") ){
	            return  new CargarMoto();
	        }
		 else{
	            throw new ExcepcionTipovehiculoValorNoNull(String.format(MensageSistema.MENSAGE_TIPO_VEHICULO_INFORMACION_INCORRECTA, tipovehiculo));
	        }
		
		
	 }
	 

}
