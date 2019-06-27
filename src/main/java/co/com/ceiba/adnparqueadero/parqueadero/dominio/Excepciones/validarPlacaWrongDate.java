package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class validarPlacaWrongDate  extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public validarPlacaWrongDate  (String message) {
        super(message);
    }
}
