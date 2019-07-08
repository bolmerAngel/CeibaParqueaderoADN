package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.manejadores.RegistroVehiculoManejador;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.manejadores.SalidaVehiculoManejador;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.consulta.RegistroServicioLista;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.PuertoRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioCrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioSalidaRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioListRegistro;


@Configuration
public class ConfiguracionBean {

	
	
	 @Bean
	    public ServicioCrearRegistro servicioCrearRegistro(PuertoRepositorioRegistro registraRepopsitorio){
	        return new ServicioCrearRegistro(registraRepopsitorio);
	    }

	 @Bean
	    public ServicioListRegistro servicioListRegistro(PuertoRepositorioRegistro registraRepopsitorio){
	        return new  ServicioListRegistro(registraRepopsitorio);
	    }
	 
	    @Bean
	    public ServicioSalidaRegistro servicioSalidaRegistro(PuertoRepositorioRegistro registroRepositorio){
	        return new ServicioSalidaRegistro(registroRepositorio);
	    }

	    @Bean
	    public RegistroServicioLista registroServicioLista(ServicioListRegistro repositorioRegistro) {
	    	return new RegistroServicioLista(repositorioRegistro);
	    }
	    
	    @Bean
	    public  RegistroVehiculoManejador  registroVehiculoManejador(ServicioCrearRegistro servicioCrearRegistro) {
	    	return new  RegistroVehiculoManejador(servicioCrearRegistro);
	    }
	
	    @Bean
	    public  SalidaVehiculoManejador  salidaVehiculoManejador(ServicioSalidaRegistro servicioSalidaRegistro) {
	    	return new  SalidaVehiculoManejador(servicioSalidaRegistro);
	    }
	
	
	
	
}
