package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.consulta.RegistroServicioLista;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol.ControlCrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol.ControlExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.CrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioListRegistro;


@Configuration
public class ConfiguracionBean {

	
	
	 @Bean
	    public CrearRegistro crearRegistro(IRepositorioRegistro registraRepopsitorio){
	        return new CrearRegistro(registraRepopsitorio);
	    }

	 @Bean
	    public ServicioListRegistro servicioListRegistro(IRepositorioRegistro registraRepopsitorio){
	        return new  ServicioListRegistro(registraRepopsitorio);
	    }
	 
	    @Bean
	    public ServicioExisteRegistro servicioExisteRegistro(IRepositorioRegistro registroRepositorio){
	        return new ServicioExisteRegistro(registroRepositorio);
	    }

	    @Bean
	    public RegistroServicioLista registroServicioLista(ServicioListRegistro repositorioRegistro) {
	    	return new RegistroServicioLista(repositorioRegistro);
	    }
	    
	    @Bean
	    public  ControlCrearRegistro  controlCrearRegistro(CrearRegistro crearRegistro) {
	    	return new  ControlCrearRegistro(crearRegistro);
	    }
	
	    @Bean
	    public  ControlExisteRegistro  controlExisteRegistro(ServicioExisteRegistro servicioExisteRegistro) {
	    	return new  ControlExisteRegistro(servicioExisteRegistro);
	    }
	
	
	
	
}
