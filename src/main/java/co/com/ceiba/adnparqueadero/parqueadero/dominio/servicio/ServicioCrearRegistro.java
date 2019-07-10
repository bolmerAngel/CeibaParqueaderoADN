package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionDuplicada;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionLicenciaLugarFecha;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionNoEspacioTipoVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.protocoloRespuestasSistemas.RespuestaSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.PuertoRepositorioRegistro;

public class ServicioCrearRegistro {

	private PuertoRepositorioRegistro registroRepositorio;

	public ServicioCrearRegistro(PuertoRepositorioRegistro registroRepositorio) {
		this.registroRepositorio = registroRepositorio;
	}

	public RegistroVehiculo entradaEstabelcida(RegistroVehiculo registroVehiculo) {
		validacionAnterior(registroVehiculo);
		validacinCantidadTipoVehiculo(registroVehiculo.getTipovehiculo());
		validarLicenciaLugarFechaDia(registroVehiculo.getPlaca(), registroVehiculo.getDiallegada());
	    return registroRepositorio.regitrar(registroVehiculo);

	}

	private void validarLicenciaLugarFechaDia(String placa, Date diallegada) {

		Calendar calen = Calendar.getInstance();
		calen.setTime(diallegada);

		if ((placa.toUpperCase().startsWith(RespuestaSistema.MENSAJES_PLACAS_RESTRINGIDAS_QUE_COMENZAN_CON_LA_LETRA))
				&& (calen.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY)) {
			throw new ExcepcionLicenciaLugarFecha(RespuestaSistema.MENSAJES_DIAS_NO_PERMITIDO);
		}
	}

	private void validacinCantidadTipoVehiculo(String tipovehiculo) {
	
		int cantidadTipoVehiculo = registroRepositorio.cantidadVehiculo(tipovehiculo);

		if ((tipovehiculo.contentEquals(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO)
				&& RespuestaSistema.TIPO_VEHICULO_MAXIMO_CARRO == cantidadTipoVehiculo)
				|| (tipovehiculo.contentEquals(RespuestaSistema.TIPO_VEHICULO_VALUE_CARRO)
						&& RespuestaSistema.TIPO_VEHICULO_MAXIMO_MOTO == cantidadTipoVehiculo)) {
			throw new ExcepcionNoEspacioTipoVehiculo(
					String.format(RespuestaSistema.MESAJES_NO_HAY_ESPACIO_DISPONIBLE, tipovehiculo));
		}

	}

	private void validacionAnterior(RegistroVehiculo registroVehiculo) {
		boolean salida = registroRepositorio.salirRegistro(registroVehiculo);
		if (salida) {
			throw new ExcepcionDuplicada(RespuestaSistema.MENSAJE_YA_EXISTE_VEHICULO);
		}
	}
}
