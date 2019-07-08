package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.PuertoRepositorioRegistro;


public class ServicioListRegistro {
	
	 private PuertoRepositorioRegistro  registraRepopsitorio;
	

	 public ServicioListRegistro ( PuertoRepositorioRegistro  registraRepopsitorio){
	        this.registraRepopsitorio = registraRepopsitorio;
	    }
	 
	 public List<RegistroVehiculo> listRegister() {
	        return registraRepopsitorio.list();
	    }
}
