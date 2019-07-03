package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.CrearRegistro;

public class ControlCrearRegistro {

	private CrearRegistro crearRegistro;

	public ControlCrearRegistro(CrearRegistro crearRegistro) {
		this.crearRegistro = crearRegistro;
	}

	public void EntradaEstabelcida(RegistroComando registroComando) {
		Registro registro = new Registro(registroComando.getIdvehiculo(), registroComando.getPlaca(),
				registroComando.getDiallegada(), registroComando.getDiasalida(), registroComando.getCilindraje(),
				registroComando.getValor(), registroComando.getTipovehiculo());
		registro.setDiallegada(new Date());
		this.crearRegistro.EntradaEstabelcida(registro);
	}

}
