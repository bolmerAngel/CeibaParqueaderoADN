package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.manejadores;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioCrearRegistro;

public class RegistroVehiculoManejador {

	private ServicioCrearRegistro servicioCrearRegistro;

	public RegistroVehiculoManejador(ServicioCrearRegistro servicioCrearRegistro) {
		this.servicioCrearRegistro = servicioCrearRegistro;
	}

	public RegistroVehiculo entradaEstabelcida(RegistroComando registroComando) {
		RegistroVehiculo registroVehiculo = new RegistroVehiculo(registroComando.getIdvehiculo(), registroComando.getPlaca(),
				registroComando.getDiallegada(), registroComando.getDiasalida(), registroComando.getCilindraje(),
				registroComando.getValor(), registroComando.getTipovehiculo());
		registroVehiculo.setDiallegada(new Date());
		return this.servicioCrearRegistro.entradaEstabelcida(registroVehiculo);
	}
}

