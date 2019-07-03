package co.com.ceiba.adnparqueadero.parqueadero.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.controlador.ControladoParqueadero;
import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.excepcion.ManejadorExcepcion;



@SpringBootTest
@RunWith(SpringRunner.class)
public class ControladorParqueaderoTest {
	
	private ManejadorExcepcion manejadorExcepcion;
	private ControladoParqueadero controladoParqueadero;
	private MockMvc mockMvc;
	
	 @Before
	    public void setupMock() {
	        mockMvc = MockMvcBuilders.standaloneSetup(controladoParqueadero, manejadorExcepcion).build();
	    }

	 @Test
	    public  void listaRegistroTest() throws Exception{
	        // Arrange , Act y Assert
	      mockMvc.perform(get("/Parqueadero").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	    }
	 
	 private String jsonToString(RegistroComando json) throws JsonProcessingException {
	        return new ObjectMapper().writeValueAsString(json);
	    }
}
