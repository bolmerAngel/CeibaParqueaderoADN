package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.adaptador;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.PuertoRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.mapper.RegistroMapeo;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.repositorio.RepositorioRegistroEntidad;


@Repository
public class AdactadoresControladores implements PuertoRepositorioRegistro {

	private  RepositorioRegistroEntidad registroEntidadRepositorio;
	
	private RegistroMapeo registroMapeo;
	
	
	public AdactadoresControladores(RepositorioRegistroEntidad registroEntidadRepositorio, RegistroMapeo registroMapeo ){
		this.registroEntidadRepositorio=registroEntidadRepositorio;
		this.registroMapeo=registroMapeo;
	}
	

	@Override
	public RegistroVehiculo Regitrar(RegistroVehiculo registroVehiculo) {
		RegistroEntida registroEntidad = registroEntidadRepositorio.save(registroMapeo.convertToEntity(registroVehiculo));
        return registroMapeo.convertToDomain(registroEntidad);
	}

	@Override
	public int cantidadVehiculo(String tipovehiculo) {
		return registroEntidadRepositorio.tipodeVehciculo(tipovehiculo);
	}

	@Override
	public List<RegistroVehiculo> list() {
		 final List<RegistroEntida> listRegistryEntity = registroEntidadRepositorio.listAll();
	        return registroMapeo.listConvertToDomain(listRegistryEntity);
		
	}

	@Override
	public boolean ExisteRegistro(RegistroVehiculo registroVehiculo) {
		 return registroEntidadRepositorio.ExisteRegistro(registroVehiculo.getPlaca());
	}

	

	@Override
	public RegistroVehiculo findByPlaca(String placa) {
		 RegistroEntida registroEntida = registroEntidadRepositorio.findByPlaca(placa);
	        return registroMapeo.convertToDomain(registroEntida);
		
	}


	@Override
	public int countVehicleType(String tipovehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
	
	
	


	
	
	 

}
