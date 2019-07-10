package co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.aplicacion.comando.RegistroComando;




public class RegistroComandoTestDataBuilder {
	private Integer idvehiculo;
	private String placa;
	private Date diallegada;
	private Date diasalida;
	private Integer cilindraje;
	private Integer valor;
	private String tipovehiculo;
	
	
	public RegistroComandoTestDataBuilder() {
		   this.idvehiculo= 1;
		   this.placa="B125";
		   this.diallegada=new Date();
		   this.diasalida=null;
		   this.cilindraje=0;
		   this.valor=0;
		   this.tipovehiculo="CARRO";
	    }
	
	  public RegistroComandoTestDataBuilder withIdvehiculo( Integer idvehiculo) {
	        this.idvehiculo = idvehiculo;
	        return this;
	    }
	  public RegistroComandoTestDataBuilder withPlaca(String placa) {
	        this.placa = placa;
	        return this;
	    }
	  public RegistroComandoTestDataBuilder withDiallegada(Date diallegada) {
	        this.diallegada = diallegada;
	        return this;
	    }
	  public RegistroComandoTestDataBuilder withDiasalida(Date diasalida) {
	        this.diasalida = diasalida;
	        return this;
	    }
	  public RegistroComandoTestDataBuilder withCilindraje( Integer cilindraje ) {
	        this.cilindraje = cilindraje;
	        return this;
	    }
	  public RegistroComandoTestDataBuilder withValor( Integer valor ) {
	        this.valor = valor;
	        return this;
	    }
	  public RegistroComandoTestDataBuilder withTipovehiculo(String tipovehiculo) {
	        this.tipovehiculo = tipovehiculo;
	        return this;
	    }
	  
	  public RegistroComando build(){
		return new RegistroComando(idvehiculo, placa, diallegada, diasalida, cilindraje, valor, tipovehiculo);
	  
		  
	  }
}
