package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioExisteRegistro;

public class ControlExisteRegistro {
	
	private ServicioExisteRegistro servicioExisteRegistro;
	
	public ControlExisteRegistro(ServicioExisteRegistro servicioExisteRegistro) {
		this.servicioExisteRegistro = servicioExisteRegistro;
	}
	
	public void  salida(String placa) {
		this.servicioExisteRegistro.salida(placa);
		
	}

}
