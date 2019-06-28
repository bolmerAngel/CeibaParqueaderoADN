package co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServisioCrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;;
public class RegistroControl {

	 private final ServisioCrearRegistro  repositorioRegistro;

	 public RegistroControl(ServisioCrearRegistro  repositorioRegistro){
	        this.repositorioRegistro = repositorioRegistro;
	    }
	  
	  public  void Registrar(RegistroComando registrocomando){

		  this.repositorioRegistro.registrar(new Registro(registrocomando.getIdvehiculo(), registrocomando.getPlaca(),
				  registrocomando.getDiallegada(),registrocomando.getDiasalida(),registrocomando.getCilindraje(),
				  registrocomando.getValor(),registrocomando.getTipovehiculo(),registrocomando.getDesplasamineto()));
   }	  
}

