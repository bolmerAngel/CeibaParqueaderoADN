package co.com.ceiba.adnparqueadero.parqueadero.testdatabuilder;

import java.util.Date;

import co.com.ceiba.adnparqueadero.parqueadero.dominio.modelo.Registro;



public class RegistroTestDataBuilder {

	private Integer idvehiculo;
	private String placa;
	private Date diallegada;
	private Date diasalida;
	private Integer cilindraje;
	private Integer valor;
	private String tipovehiculo;
	
	public RegistroTestDataBuilder() {

		this.idvehiculo = 1;
		this.placa = "123";
		this.diallegada = new Date();
		this.diasalida = null;
		this.cilindraje = 500;
		this.valor = 0;
		this.tipovehiculo = "CARRO";
	}
	
	  public RegistroTestDataBuilder withID(Integer idvehiculo) {
	        this.idvehiculo = idvehiculo;
	        return this;
	    }

	  public RegistroTestDataBuilder withPlaca(String placa) {
	        this.placa = placa;
	        return this;
	    }
	public RegistroTestDataBuilder withDiallegada(Date diallegada) {
	        this.diallegada = diallegada;
	        return this;
	    }
	
	public RegistroTestDataBuilder withDiasalida(Date diasalida) {
        this.diasalida = diasalida;
        return this;
    }
	
	public RegistroTestDataBuilder withCilindraje(Integer cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }
	

	public RegistroTestDataBuilder withValor(Integer valor) {
        this.valor= valor;
        return this;
    }
	
	public RegistroTestDataBuilder withTipovehiculo(String tipovehiculo) {
        this.tipovehiculo= tipovehiculo;
        return this;
    }
	
	
	
	 public Registro build(){
	        return new Registro ( idvehiculo,  placa,  diallegada, diasalida, cilindraje,  valor,  tipovehiculo);
	    }
	
	
	
}
