package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.manejadores;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioSalidaRegistro;

public class SalidaVehiculoManejador {
	
	private ServicioSalidaRegistro servicioSalidaRegistro;
	
	public SalidaVehiculoManejador(ServicioSalidaRegistro servicioSalidaRegistro) {
		this.servicioSalidaRegistro = servicioSalidaRegistro;
	}
	
	public void  salida(String placa) {
		this.servicioSalidaRegistro.salida(placa);
		
	}

}
