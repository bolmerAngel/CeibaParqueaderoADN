package co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones;

public class ExcepcionTipovehiculoValorNoNull extends RuntimeException {
	
	private static final long serialVersionUID = 6759407566706191023L;
	
    public ExcepcionTipovehiculoValorNoNull(String message) {
        super(message);
    }
    
} 