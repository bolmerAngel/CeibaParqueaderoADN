package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.adaptador;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.puerto.IRepositorioRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.mapper.RegistroMapeo;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.repositorio.IRegistroEntidadRepoSitorio;


@Repository
public class AdactadoresControladores implements IRepositorioRegistro {

	private  IRegistroEntidadRepoSitorio registroEntidadRepositorio;
	
	private RegistroMapeo registroMapeo;
	
	
	public AdactadoresControladores(IRegistroEntidadRepoSitorio registroEntidadRepositorio, RegistroMapeo registroMapeo ){
		this.registroEntidadRepositorio=registroEntidadRepositorio;
		this.registroMapeo=registroMapeo;
	}
	

	@Override
	public Registro Regitrar(Registro registro) {
		RegistroEntida registroEntidad = registroEntidadRepositorio.save(registroMapeo.convertToEntity(registro));
        return registroMapeo.convertToDomain(registroEntidad);
	}

	@Override
	public int cantidadVehiculo(String tipovehiculo) {
		return registroEntidadRepositorio.tipodeVehciculo(tipovehiculo);
	}

	@Override
	public List<Registro> list() {
		 final List<RegistroEntida> listRegistryEntity = registroEntidadRepositorio.listAll();
	        return registroMapeo.listConvertToDomain(listRegistryEntity);
		
	}

	@Override
	public boolean ExisteRegistro(Registro registro) {
		 return registroEntidadRepositorio.ExisteRegistro(registro.getPlaca());
	}

	

	@Override
	public Registro findByPlaca(String placa) {
		 RegistroEntida registroEntida = registroEntidadRepositorio.findByPlaca(placa);
	        return registroMapeo.convertToDomain(registroEntida);
		
	}


	@Override
	public int countVehicleType(String tipovehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
	
	
	


	
	
	 

}
