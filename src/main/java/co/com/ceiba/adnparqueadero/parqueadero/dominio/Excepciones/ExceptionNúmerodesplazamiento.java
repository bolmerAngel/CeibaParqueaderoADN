package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExceptionNúmerodesplazamiento  extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExceptionNúmerodesplazamiento(String message) {
        super(message);
    }
    
} 