package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.fabrica;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionTipovehiculoValorNoNull;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.protocolorespuestassistemas.RespuestaSistema;


public final  class CargaFabrica {
	
	private CargaFabrica() {}
	
	 public static CargarCarro getInstance(String tipovehiculo) {
		 if(tipovehiculo.equalsIgnoreCase("carro")){
	            return  new CargarCarro();
	        }
		 else if(tipovehiculo.equalsIgnoreCase("moto") ){
	            return  new CargarMoto();
	        }
		 else{
	            throw new ExcepcionTipovehiculoValorNoNull(String.format(RespuestaSistema.MENSAGE_TIPO_VEHICULO_INFORMACION_INCORRECTA, tipovehiculo));
	        }
		
		
	 }
	 

}
