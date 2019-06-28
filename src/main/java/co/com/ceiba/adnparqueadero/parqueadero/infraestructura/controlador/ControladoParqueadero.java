package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.consulta.RegistroServicioLista;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol.RegistroControl;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;

@RestController
@RequestMapping("/Parking")
@CrossOrigin("*")
public class ControladoParqueadero {
	
	 private  RegistroControl registroControl;
	 private RegistroServicioLista RegistroServicoLista;
  /*
	   @Autowired
	 public ControladoParqueadero(RegistroControl registroControl,RegistroServicioLista RegistroServicoLista) {
		 this.registroControl=registroControl;
		 this.RegistroServicoLista=RegistroServicoLista;
	 }
	
	   @RequestMapping(method= RequestMethod.GET)
	   public List<Registro> listRegister() {
	        return RegistroServicoLista.listRegister();
	    }
	 */
	 
	 
}
