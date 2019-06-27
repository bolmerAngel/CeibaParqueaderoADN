package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.*;

public class ValidatorAgument extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ValidatorAgument (String message) {
        super(message);
    }

	public static void validarCilindrajeRequired(Object value, Integer cilindraje) {
        if (value == null) {
            throw new ExcepcionCilindraje(cilindraje);
        }
    }

	
}
