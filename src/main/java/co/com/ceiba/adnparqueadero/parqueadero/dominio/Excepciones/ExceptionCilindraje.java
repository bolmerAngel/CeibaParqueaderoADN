package co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones;

public class ExceptionCilindraje extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExceptionCilindraje(String cilindraje) {
    	super(cilindraje);
        }
    }
