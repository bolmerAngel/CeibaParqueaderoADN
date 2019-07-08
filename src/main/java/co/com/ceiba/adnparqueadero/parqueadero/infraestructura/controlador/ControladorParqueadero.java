package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.manejadores.RegistroVehiculoManejador;
import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.manejadores.SalidaVehiculoManejador;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.RegistroVehiculo;
import co.com.ceiba.adnparqueadero.parqueadero.dominio.servicio.ServicioListRegistro;

@RestController
@RequestMapping("/parqueadero")
public class ControladorParqueadero {
	
	private RegistroVehiculoManejador registroVehiculoManejador;
	private SalidaVehiculoManejador salidaVehiculoManejador;
	private ServicioListRegistro servicioListRegistro;

	@Autowired
	public ControladorParqueadero(RegistroVehiculoManejador registroVehiculoManejador, SalidaVehiculoManejador salidaVehiculoManejador,
			ServicioListRegistro servicioListRegistro) {
		this.registroVehiculoManejador = registroVehiculoManejador;
		this.salidaVehiculoManejador = salidaVehiculoManejador;
		this.servicioListRegistro = servicioListRegistro;
	}

	@GetMapping
	public List<RegistroVehiculo> List() {
		return this.servicioListRegistro.listRegister();

	}

	@PostMapping
	public RegistroVehiculo getInformacion(@RequestBody RegistroComando registroComando) {
		return this.registroVehiculoManejador.EntradaEstabelcida(registroComando);
	}

	@PutMapping("/{placa}")
	public void getOut(@PathVariable("placa") String placa) {
		this.salidaVehiculoManejador.salida(placa);
	}

}
