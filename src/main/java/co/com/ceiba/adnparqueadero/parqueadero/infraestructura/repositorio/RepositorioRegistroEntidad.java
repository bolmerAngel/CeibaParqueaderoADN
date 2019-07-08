package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;



public interface RepositorioRegistroEntidad extends  CrudRepository<RegistroEntida, Integer>{
	
	
	@Query("SELECT COUNT(idvehiculo) FROM RegistroEntida r WHERE r.tipovehiculo = :tipovehiculo AND r.diasalida IS NULL")
	int tipodeVehciculo(@Param("tipovehiculo") String tipovehiculo);
	
	@Query("SELECT r FROM RegistroEntida r WHERE r.placa = :placa AND r.diasalida IS NULL")
	RegistroEntida findByPlaca(@Param("placa") String placa);
	
	   @Query("SELECT r FROM RegistroEntida r")
	    List<RegistroEntida> listAll();
	   
	   @Query("SELECT CASE WHEN COUNT(r.idvehiculo) > 0 THEN true ELSE false END FROM RegistroEntida r WHERE r.placa = :placa AND r.diasalida IS NULL")
	    boolean ExisteRegistro(@Param("placa") String placa);


}
