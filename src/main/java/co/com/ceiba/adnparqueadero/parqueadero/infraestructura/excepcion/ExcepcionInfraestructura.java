package co.com.ceiba.adnparqueadero.parqueadero.infraestructura.excepcion;



public class ExcepcionInfraestructura {
	
	 private String nombre;
	    private String mensages;
	
	    
	    public ExcepcionInfraestructura(String nombre, String mensages ) {
	    	this.nombre= nombre;
	    	this.mensages=mensages;
	    	
	    }
	    
	    public String getNombre() {
	        return nombre;
	    }
	    
	    public String getMensages() {
	        return mensages;
	    }


	

}
