package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExcepcionPlaca extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionPlaca(String message) {
        super(message);
    }
}