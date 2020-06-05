package webpag.Modelo.dao;


import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import webpag.Modelo.DAOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import webpag.Modelo.dto.ClienteDTO;
import java.sql.Connection;

public class OracleClienteDAO implements ClienteDAO
{
    private Connection conn;
    final String insert = "INSERT INTO cliente VALUES (?,?,?)";
    final String update = "UPDATE cliente SET rut=?, nombre_cliente=?, id_comuna=? WHERE rut=?";
    final String delete = "DELETE cliente WHERE rut=?";
    final String getone = "SELECT * FROM cliente WHERE rut=?";
    final String getall = "SELECT * FROM cliente";
    
    public OracleClienteDAO(final Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insert(final ClienteDTO c) throws SQLException {
        PreparedStatement stm = null;
        stm = this.conn.prepareStatement("INSERT INTO cliente VALUES (?,?,?)");
        stm.setString(1, c.getRut());
        stm.setString(2, c.getNombre_cliente());
        stm.setInt(3, c.getId_comuna());
        System.out.println(stm.executeUpdate());
    }
    
    @Override
    public void update(final ClienteDTO c) throws DAOException, SQLException {
        PreparedStatement stm = null;
        stm = this.conn.prepareStatement(update);
        stm.setString(1, c.getRut());
        stm.setString(2, c.getNombre_cliente());
        stm.setInt(3, c.getId_comuna());
        stm.setString(4, c.getRut());
        System.out.println(c.getRut());
        System.out.println("llega antes del execute");
        stm.executeUpdate();
        System.out.println(stm.executeUpdate());
    }
    
    @Override
    public void delete(final ClienteDTO c) throws SQLException {
        PreparedStatement stm = null;
        stm = this.conn.prepareStatement("DELETE cliente WHERE rut=?");
        stm.setString(1, c.getRut());
        System.out.println("llega antes del execute del delete");
        stm.executeUpdate();
        System.out.println("EJECTUA LA WEA ");
    }
    
    @Override
    public ClienteDTO get(final String rut) throws SQLException {
        PreparedStatement stm = null;
        ResultSet rs = null;
        ClienteDTO dto = new ClienteDTO();
        stm = this.conn.prepareStatement("SELECT * FROM cliente WHERE rut=?");
        stm.setString(1, rut);
        rs = stm.executeQuery();
        if (rs.next()) {
        	dto.setRut(rut);
        	dto.setNombre_cliente(rs.getString("nombre_cliente"));
        	dto.setId_comuna(rs.getInt("id_comuna"));
        }
        return dto;
    }
    
    @Override
    public List<ClienteDTO> list() throws SQLException {
    	
    	ResultSet rs = null;
    	List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
    	Statement stm = conn.createStatement();
    	rs= stm.executeQuery(getall);
    	while (rs.next()) {
    		String nombre_cliente = rs.getString("nombre_cliente");
    		String rut = rs.getString("rut");
    		int id_comuna = rs.getInt("id_comuna");
    		ClienteDTO dto = new ClienteDTO(nombre_cliente,rut,id_comuna);
    		lista.add(dto);
    		
		}
        return lista;
    }
}
