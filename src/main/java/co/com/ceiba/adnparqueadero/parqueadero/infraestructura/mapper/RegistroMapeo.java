package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;


@Component
public class RegistroMapeo {
	
	  public RegistroVehiculo convertToDomain(RegistroEntida registroEntida){
		  RegistroVehiculo registroVehiculo;

	        if( registroEntida == null){
	        	registroVehiculo = null;
	        } else {
	        	registroVehiculo = new RegistroVehiculo(registroEntida.getIdvehiculo(),registroEntida.getPlaca(), registroEntida.getDiallegada(),
	        			registroEntida.getDiasalida(), registroEntida.getCilindraje(), registroEntida.getValor(), registroEntida.getTipovehiculo());
	        }

	        return registroVehiculo;
	    }
	  
	  public RegistroEntida convertToEntity(RegistroVehiculo registroVehiculo){
		  RegistroEntida registroEntida;
	        if(registroVehiculo == null){
	        	registroEntida = null;
	        }else{
	        	registroEntida = new RegistroEntida(registroVehiculo.getIdvehiculo(), registroVehiculo.getPlaca(), registroVehiculo.getDiallegada(), 
	        			registroVehiculo.getDiasalida(),registroVehiculo.getCilindraje(), registroVehiculo.getValor(),registroVehiculo.getTipovehiculo());
	        }
	        return registroEntida;
	    }
	  
	  public List<RegistroVehiculo> listConvertToDomain(List<RegistroEntida> listRegistroEntida) {
	        final List<RegistroVehiculo> listRegistro = new ArrayList<>();
	        
	        listRegistroEntida.forEach(registroEntida -> listRegistro.add(new RegistroVehiculo(registroEntida.getIdvehiculo(),registroEntida.getPlaca(),registroEntida.getDiallegada(),
        			registroEntida.getDiasalida(),registroEntida.getCilindraje(), registroEntida.getValor(),registroEntida.getTipovehiculo())));
	        
			return listRegistro;
	        
	  }
	  
}
