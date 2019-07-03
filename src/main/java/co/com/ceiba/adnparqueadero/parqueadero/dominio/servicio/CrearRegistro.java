package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionDuplicada;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionLicenciaLugarFecha;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionNoEspacioTipoVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.mensajes.MensageSistema;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;

public class CrearRegistro {

	private static final boolean ExisteRegistro = false;
	private IRepositorioRegistro registroRepositorio;

	public CrearRegistro(IRepositorioRegistro registroRepositorio) {
		this.registroRepositorio = registroRepositorio;
	}

	public Registro EntradaEstabelcida(Registro registro) {
		System.out.println("HOLAAAAAAAAAAAAA" + registro.getPlaca() + " " + registro.getTipovehiculo() + " "
				+ registro.getDiallegada());
		validacionAnterior(registro);
		validacinCantidadTipoVehiculo(registro.getTipovehiculo());
		validarLicenciaLugarFechaDia(registro.getPlaca(), registro.getDiallegada());
	return registroRepositorio.Regitrar(registro);

	}

	private void validarLicenciaLugarFechaDia(String placa, Date diallegada) {

		System.out.println(diallegada);
		// TODO Auto-generated method stub
		Calendar calen = Calendar.getInstance();
		calen.setTime(diallegada);

		if ((placa.toUpperCase().startsWith(MensageSistema.MENSAJES_PLACAS_RESTRINGIDAS_QUE_COMENZAN_CON_LA_LETRA))
				&& (calen.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY)) {
			throw new ExcepcionLicenciaLugarFecha(MensageSistema.MENSAJES_DIAS_NO_PERMITIDO);
		}
	}

	private void validacinCantidadTipoVehiculo(String tipovehiculo) {
		// TODO Auto-generated method stub
		int cantidadTipoVehiculo = registroRepositorio.cantidadVehiculo(tipovehiculo);

		if ((tipovehiculo.contentEquals(MensageSistema.TIPO_VEHICULO_VALUE_CARRO)
				&& MensageSistema.TIPO_VEHICULO_MAXIMO_CARRO == cantidadTipoVehiculo)
				|| (tipovehiculo.contentEquals(MensageSistema.TIPO_VEHICULO_VALUE_CARRO)
						&& MensageSistema.TIPO_VEHICULO_MAXIMO_MOTO == cantidadTipoVehiculo)) {
			throw new ExcepcionNoEspacioTipoVehiculo(
					String.format(MensageSistema.MESAJES_NO_HAY_ESPACIO_DISPONIBLE, tipovehiculo));
		}

	}

	private void validacionAnterior(Registro registro) {
		boolean exists = registroRepositorio.ExisteRegistro(registro);
		if (ExisteRegistro) {
			throw new ExcepcionDuplicada(MensageSistema.MENSAJE_YA_EXISTE_VEHICULO);
		}
	}
}
