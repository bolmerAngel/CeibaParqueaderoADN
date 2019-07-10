package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.excepcion;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionCilindrajeNUmerico;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionDuplicada;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionPlaca;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionTipovehiculoNoNull;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExcepcionTipovehiculoValorNoNull;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.excepciones.ExceptionCilindraje;


@ControllerAdvice
public class ManejadorExcepcion {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorExcepcion.class);
	    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
	    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();
	    
	    
	    
	    public ManejadorExcepcion(){
	    	 CODIGOS_ESTADO.put(ExcepcionCilindrajeNUmerico.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	    	  CODIGOS_ESTADO.put(ExceptionCilindraje.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	    	  CODIGOS_ESTADO.put(ExcepcionDuplicada.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	    	  CODIGOS_ESTADO.put(ExcepcionPlaca.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	    	  CODIGOS_ESTADO.put(ExcepcionTipovehiculoNoNull.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	    	  CODIGOS_ESTADO.put(ExcepcionTipovehiculoValorNoNull.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	    }
	    
	    @ExceptionHandler(Exception.class)
	    public final ResponseEntity<ExcepcionInfraestructura> manejarTodasExcepciones(ExcepcionInfraestructura excepcion) {
	    	 ResponseEntity<ExcepcionInfraestructura> responde;
	    	 
	    	 String nombre=excepcion.getClass().getSimpleName();
	    	 String mensages= excepcion.getMensages();
	    	 Integer codigo= CODIGOS_ESTADO.get(nombre);
			

	        if (codigo != null) {
	        	ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, mensages);
	            responde = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
	        } else {
	            LOGGER .error(nombre, excepcion);
	            ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
	            responde = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    	 
			return responde;
	    	
	    }

}
	    
