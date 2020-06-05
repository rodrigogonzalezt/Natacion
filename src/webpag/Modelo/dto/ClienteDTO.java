package webpag.Modelo.dto;

public class ClienteDTO
{
    String rut;
    String nombre_cliente;
    int id_comuna;
    
    public ClienteDTO() {}
    public ClienteDTO(String nombre_cliente, String rut, int id_comuna) {
    	this.nombre_cliente=nombre_cliente;
    	this.rut=rut;
    	this.id_comuna=id_comuna;
    }
    

	public String getRut() {
        return this.rut;
    }
    
    public void setRut(final String rut) {
        this.rut = rut;
    }
    
    public String getNombre_cliente() {
        return this.nombre_cliente;
    }
    
    public void setNombre_cliente(final String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    
    public int getId_comuna() {
        return this.id_comuna;
    }
    
    public void setId_comuna(final int id_comuna) {
        this.id_comuna = id_comuna;
    }
}
