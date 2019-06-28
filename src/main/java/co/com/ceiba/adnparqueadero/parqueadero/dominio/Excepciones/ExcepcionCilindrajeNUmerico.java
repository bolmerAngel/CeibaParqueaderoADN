package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExcepcionCilindrajeNUmerico extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionCilindrajeNUmerico(String message) {
        super( message);
    }
}