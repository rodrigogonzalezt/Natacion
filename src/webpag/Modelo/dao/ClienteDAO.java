package webpag.Modelo.dao;

import webpag.Modelo.DAOException;
import java.sql.SQLException;
import webpag.Modelo.dto.ClienteDTO;
import java.util.List;

public interface ClienteDAO
{
    List<ClienteDTO> list() throws SQLException, DAOException;
    
    void insert(final ClienteDTO p0) throws SQLException, DAOException;
    
    void update(final ClienteDTO p0) throws SQLException, DAOException;
    
    void delete(final ClienteDTO p0) throws SQLException, DAOException;
    
    ClienteDTO get(final String p0) throws SQLException, DAOException;
}
