package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExcepcionNoExisteRegistro  extends RuntimeException {

private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionNoExisteRegistro(String message) {
        super( message);
    }
}