package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.entida.RegistroEntida;

public interface IRegistroEntidadRepoSitorio extends JpaRepository<RegistroEntida, Integer>{

}
