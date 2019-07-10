package co.com.ceiba.adnparqueadero.parqueadero.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;

import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.controlador.ControladorParqueadero;

import co.com.ceiba.adnparqueadero.parqueadero.infraestructura.excepcion.ManejadorExcepcion;
import co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder.RegistroComandoTestDataBuilder;






@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration(value ="")
public class ControladorParqueaderoTest {
	
	@Autowired
	private ManejadorExcepcion manejadorExcepcion;
	@Autowired
	private ControladorParqueadero controladorParqueadero;
	

	
	private MockMvc mockMvc;
	private static final  String REQUESTMAPPING = "/parqueadero";
	private static final String PLACA_CARRO = "URG-586";
	private static final String PLACA_MOTO="URG-588";
	private static final String FALLO_PLACA="URG-58p";
	private static final String FALLO_PLACA_ENTRADA="URG-58p";
	private static final String CARRO="CARRO";
	private static final String MOTO="MOTO";
	private static final Integer CILINDRAJE=400;
	private static final String PRECIO_CARRO="1000";
	private static final String PRECIO_MOTO="800";
	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR="Ocurrió un error favor contactar al administrador.";
	private static final String INGRESOS_NO_PERMITIDOS= "No esta autorizado a ingresar un dia distinto a domingo o lunes";
	private JSONObject jsonsolucionComando;
	
	 @Before
	    public void setupMock() {
	        mockMvc = MockMvcBuilders.standaloneSetup(controladorParqueadero, manejadorExcepcion).build();
	    }


	 
	    @Test
	    public  void listaRegistoTest() throws Exception{
	        // Arrange , Act y Assert
	      mockMvc.perform(get(REQUESTMAPPING).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	      //Assert.assertNotNull(servletContext);
	    }
	    
	    
	   
	    @Test
	    public void obtenerVehiculoPrueba() throws Exception {
	        // Arrange
	    	RegistroComandoTestDataBuilder registroComandoTestDataBuilder  = new RegistroComandoTestDataBuilder();
	    	RegistroComando registroComando =registroComandoTestDataBuilder.build();

	        // Act y Assert
	        mockMvc.perform(post(REQUESTMAPPING).contentType(MediaType.APPLICATION_JSON)
	                .content(jsonToString(registroComando))).andExpect(status().isOk())	
	        		.andExpect(content().contentType("application/json;charset=UTF-8"))
	        			.andExpect(jsonPath("$.placa").value("B125"))
	        			.andExpect(jsonPath("$.tipovehiculo").value("CARRO"));
	        
	    }

	    
	    @Test
	    public void registarCarroPrueba() throws Exception {
	    	RegistroComandoTestDataBuilder registroComandoTestDataBuilder  = new RegistroComandoTestDataBuilder();
	    			 registroComandoTestDataBuilder.withPlaca(PLACA_CARRO).withTipovehiculo(CARRO);
	    			 RegistroComando registroComando =registroComandoTestDataBuilder.build();
	    			 mockMvc.perform(post(REQUESTMAPPING).contentType(MediaType.APPLICATION_JSON)
	    		                .content(jsonToString(registroComando))).andExpect(status().isOk());
	    }
	    
	    
				
	   /* @Test
	    public void  registrarErrorSalidaVehiculoMoto() throws Exception {
	    	RegistroComandoTestDataBuilder registroComandoTestDataBuilder  = new RegistroComandoTestDataBuilder();
	    	registroComandoTestDataBuilder.withPlaca(FALLO_PLACA_ENTRADA);
	    	RegistroComando registroComando =registroComandoTestDataBuilder.build();
	    	String excepcionNombre = NullPointerException.class.getSimpleName();
	    	ExcepcionInfraestructura excepcionInfraestructura = new ExcepcionInfraestructura(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);    	
	    	mockMvc.perform((RequestBuilder) ((MockHttpServletRequestBuilder) post(REQUESTMAPPING).contentType(MediaType.APPLICATION_JSON))
	    			.content(jsonToString(registroComando))).andExpect(status().isOk())
	    			.andExpect(status().is5xxServerError()).andExpect((content().json(excepcionInfraestructura.toString())));
	    
	    }*/
	    
	    
		   @Test
		    public void salidaVehiculoTest() throws Exception{
		        // Arrange
			   String  placa = "123456";
			   String tipovehiculo="MOTO";
			   RegistroComandoTestDataBuilder registroComandoTestDataBuilder  = new RegistroComandoTestDataBuilder();
			   registroComandoTestDataBuilder.withPlaca(placa).withTipovehiculo(tipovehiculo);
		    	RegistroComando registroComando = registroComandoTestDataBuilder.build();
		        // Act y Assert
		        mockMvc.perform(post(REQUESTMAPPING).contentType(MediaType.APPLICATION_JSON)
		                .content(jsonToString(registroComando))).andExpect(status().isOk())
		        			.andExpect(jsonPath("$.placa").value("123456"))
		        			.andExpect(jsonPath("$.tipovehiculo").value("MOTO"))
		        			.andExpect(content().contentType("application/json;charset=UTF-8"));
		        	
			   
		        
		        // Act y Assert
		        mockMvc.perform(put(REQUESTMAPPING+"/" + placa).contentType(MediaType.APPLICATION_JSON))
		                .andExpect(status().isOk());
		    }


		   
		    private String jsonToString(RegistroComando json) throws JsonProcessingException {
		        return new ObjectMapper().writeValueAsString(json);
		    }
		    
		    
		    
		    
		    
		    
		   
		
}

