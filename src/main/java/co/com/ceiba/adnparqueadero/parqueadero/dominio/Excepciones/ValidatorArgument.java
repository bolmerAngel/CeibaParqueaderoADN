package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;


import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.*;


public class ValidatorArgument extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ValidatorArgument (String message) {
        super(message);
    }

	public static void validarPlacaWrongDate(String message) {
        throw new validarPlacaWrongDate(message);
    }

}