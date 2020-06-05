package webpag.View;

public class Formato {

	public String FormatoSelectOne(String p_nombre, String p_rut, int p_comuna) {
		String cabecera = "<table class='table'><th>Nombre Cliente</th><th>RUT</th><th>Comuna</th>";
		String cuerpo ="<tr><td>"+p_nombre+"</td><td>"+p_rut+"</td><td>"+p_comuna+"</td></tr>";
		return cabecera+cuerpo+"</table>";
	}
	public String FormatoRow(String p_nombre, String p_rut, int p_comuna) {
		String fila ="<tr><td>"+p_nombre+"</td><td>"+p_rut+"</td><td>"+p_comuna+"</td>";
		return fila;
				
	}	
	public String FormatoSelectAll(String row) {
		String cabecera = "<table class='table'><th>Nombre Cliente</th><th>RUT</th><th>Comuna</th>";
		String cuerpa = row+"</tr></table>";
		return cabecera+cuerpa;
	}
}

