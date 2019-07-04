package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;


@Component
public class RegistroMapeo {
	
	  public Registro convertToDomain(RegistroEntida registroEntida){
		  Registro registro;

	        if( registroEntida == null){
	        	registro = null;
	        } else {
	        	registro = new Registro(registroEntida.getIdvehiculo(),registroEntida.getPlaca(), registroEntida.getDiallegada(),
	        			registroEntida.getDiasalida(), registroEntida.getCilindraje(), registroEntida.getValor(), registroEntida.getTipovehiculo());
	        }

	        return registro;
	    }
	  
	  public RegistroEntida convertToEntity(Registro registro){
		  RegistroEntida registroEntida;
	        if(registro == null){
	        	registroEntida = null;
	        }else{
	        	registroEntida = new RegistroEntida(registro.getIdvehiculo(), registro.getPlaca(), registro.getDiallegada(), 
	        			registro.getDiasalida(),registro.getCilindraje(), registro.getValor(),registro.getTipovehiculo());
	        }
	        return registroEntida;
	    }
	  
	  public List<Registro> listConvertToDomain(List<RegistroEntida> ListRegistroEntida) {
	        final List<Registro> listRegistro = new ArrayList<>();
	        
	        ListRegistroEntida.forEach(registroEntida -> listRegistro.add(new Registro(registroEntida.getIdvehiculo(),registroEntida.getPlaca(),registroEntida.getDiallegada(),
        			registroEntida.getDiasalida(),registroEntida.getCilindraje(), registroEntida.getValor(),registroEntida.getTipovehiculo())));
	        
			return listRegistro;
	        
	  }
	  
}
