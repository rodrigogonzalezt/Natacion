package webpag.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import webpag.Modelo.DAOException;
import java.sql.SQLException;
import webpag.Modelo.dao.OracleClienteDAO;
import webpag.Modelo.dto.ClienteDTO;
import webpag.View.Formato;
import webpag.Modelo.Conexion;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/CRUD" })
public class CRUD extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        
    }
	       
        

    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
    	String answer = "";
        String answer_nom="";
        String answer_rut="";
        int answer_com=0;
        String answer_row="";
        System.out.println("Entra al Servlet");
        final Conexion conn = new Conexion();
        conn.metodo();
        final ClienteDTO c = new ClienteDTO();
        Formato f =new Formato();
        final OracleClienteDAO oc = new OracleClienteDAO(conn.conn);
        switch (request.getParameter("dataSet").toString()) {
            case "EliminarCliente": {
                System.out.println("Entra el delete :D");
                c.setRut(request.getParameter("dataSet2"));
                try {
                    oc.delete(c);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                answer = "Cliente eliminado correctamente";
                response.getWriter().write(answer);
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                break;
            }
            case "ActualizarCliente": {
                System.out.println("Entra al update <3");
                c.setRut(request.getParameter("dataSet3"));
                c.setNombre_cliente(request.getParameter("dataSet2"));
                c.setId_comuna(Integer.parseInt(request.getParameter("dataSet4")));
                c.setRut(request.getParameter("dataSet3"));
                try {
					oc.update(c);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                answer = "Cliente modificado correctamente";
                response.getWriter().write(answer);
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                return;
            }
            case "InsertCliente": {
                System.out.println("Entra al insert <3");
                c.setRut(request.getParameter("dataSet3"));
                c.setNombre_cliente(request.getParameter("dataSet2"));
                c.setId_comuna(Integer.parseInt(request.getParameter("dataSet4")));
                try {
                    oc.insert(c);
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
                answer = "Cliente agregado correctamente";
                response.getWriter().write(answer);
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                break;
            }
            case "MostrarCliente":
            	System.out.println("entra al Select one");
            	c.setRut(request.getParameter("dataSet2"));
			try {
				answer_rut=oc.get(c.getRut()).getRut();
				answer_nom=oc.get(c.getRut()).getNombre_cliente();
				answer_com=oc.get(c.getRut()).getId_comuna();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	       
			response.getWriter().write(f.FormatoSelectOne(answer_nom,answer_rut,answer_com));
	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        break;
            case "MostrarTodos":
            	System.out.println("Entra el select All");
			try {
				oc.list();
				for(ClienteDTO dto:oc.list()) {
					answer_row=answer_row+f.FormatoRow(dto.getNombre_cliente(),dto.getRut(),dto.getId_comuna());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(f.FormatoSelectAll(answer_row));
	        response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        }

}
}
