package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExcepcionDuplicada extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionDuplicada(String message) {
        super( message);
    }
}