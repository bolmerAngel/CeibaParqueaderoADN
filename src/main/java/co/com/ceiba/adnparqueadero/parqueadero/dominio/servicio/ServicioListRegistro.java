package co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio;

import java.util.List;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;


public class ServicioListRegistro {
	
	 private IRepositorioRegistro  registraRepopsitorio;
	

	 public ServicioListRegistro ( IRepositorioRegistro  registraRepopsitorio){
	        this.registraRepopsitorio = registraRepopsitorio;
	    }
	 
	 public List<Registro> listRegister() {
	        return registraRepopsitorio.list();
	    }
}
