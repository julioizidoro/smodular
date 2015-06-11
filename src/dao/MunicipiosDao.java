/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Municipios;

/**
 *
 * @author wolverine
 */
public class MunicipiosDao {
    
    private EntityManager manager;
    
    public List<Municipios> listarMunicipios() throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT m FROM Municipios m order by m.nomeMunicipio");
        manager.getTransaction().commit();
        return q.getResultList();
    }
    
    public List<Municipios> listarMunicipios(String nomeMunicipio) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT m FROM Municipios m where m.nomeMunicipio like '%" + nomeMunicipio + "%' order by m.nomeMunicipio");
        manager.getTransaction().commit();
        return q.getResultList();
    }
    
    public Municipios getMunicipio(int idMunicipio) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT m FROM Municipios m where m.idmunicipios=" + idMunicipio);
        if (q.getResultList().size()>0){
            manager.getTransaction().commit();
            return (Municipios) q.getResultList().get(0);
        }else {
            manager.getTransaction().commit();
            return null;
        }
    }
    
}
