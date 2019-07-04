package co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.*;



public class ValidarArgumento {

	public ValidarArgumento() {}

	public static void validarPlacaNoNull(String placa, String message) {
		if(placa == null) {
			throw new ExcepcionPlaca(message);
		}
		
	}

	public static void validarTipovehiculoValorNoNull(String tipovehiculo, String message) {
		if(tipovehiculo == null) {
			throw new ExcepcionTipovehiculoValorNoNull(message);
		}

	}
	
	public static void validarTipovehiculoNoNull(String tipovehiculo, String message) {
		if(tipovehiculo == null) {
			throw new ExcepcionTipovehiculoNoNull(message);
		}
	}
	
	public static void validarTipoInformacion( String message) {
		
		throw new ExcepcionTipoInformacion(message);
	}

	

	public static void validarCilindrajeRequired(Integer value, String message) {
        if (value == null) {
            throw new ExceptionCilindraje(message);
        }
    }


	public static void validarLetraPlaca(String placa, String string) {
		// TODO Auto-generated method stub
		
	}
	}

	
	
	
	
	
	
	


