package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.consulta.RegistroServicioLista;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol.ControlCrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.contol.ControlExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionLicenciaLugarFecha;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionNoEspacioTipoVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.Excepciones.ExcepcionNoExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.CrearRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioExisteRegistro;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioListRegistro;

@RestController
@RequestMapping("/Parqueadero")
public class ControladoParqueadero {
	
	private ControlCrearRegistro crearRegistro;
	private ControlExisteRegistro controlExisteRegistro;
	private ServicioListRegistro servicioListRegistro;

	@Autowired
	public ControladoParqueadero(ControlCrearRegistro crearRegistro, ControlExisteRegistro controlExisteRegistro,
			ServicioListRegistro servicioListRegistro) {
		this.crearRegistro = crearRegistro;
		this.controlExisteRegistro = controlExisteRegistro;
		this.servicioListRegistro = servicioListRegistro;
	}

	@GetMapping
	public List<Registro> List() {
		return this.servicioListRegistro.listRegister();

	}

	@PostMapping
	public Registro getInformacion(@RequestBody RegistroComando registroComando) {
		return this.crearRegistro.EntradaEstabelcida(registroComando);
	}

	@PutMapping("/{placa}")
	public void getOut(@PathVariable("placa") String placa) {
		this.controlExisteRegistro.salida(placa);
	}

}
