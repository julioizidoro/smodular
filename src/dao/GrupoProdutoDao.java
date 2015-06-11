/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Grupoproduto;
import model.Subgrupoproduto;

/**
 *
 * @author wolverine
 */
public class GrupoProdutoDao {

    private EntityManager manager;

    public List<Grupoproduto> listarGrupoProduto() throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        List<Grupoproduto> listaGrupoProdutos = new ArrayList<Grupoproduto>();
        Query q = manager.createQuery("select g from Grupoproduto g order by g.descricao");
        listaGrupoProdutos = q.getResultList();
        manager.getTransaction().commit();
        return listaGrupoProdutos;
    }

    public List<Subgrupoproduto> listSubGrupoProduto(int idGrupo) throws Exception{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        List<Subgrupoproduto> listaSubGrupoProduto = new ArrayList<Subgrupoproduto>();
        Query q = manager.createQuery("select s from Subgrupoproduto s where s.grupoproduto=" + idGrupo + " order by s.descricao");
        listaSubGrupoProduto = q.getResultList();
        manager.getTransaction().commit();
        return listaSubGrupoProduto;
    }
    
    public Subgrupoproduto consultarSubGrupoProduto(int idSubGrupo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Subgrupoproduto subGrupoProduto = new Subgrupoproduto();
        Query q = manager.createQuery("select s from Subgrupoproduto s where s.idsubGrupoProduto=" + idSubGrupo);
        subGrupoProduto = (Subgrupoproduto) q.getSingleResult();
        manager.getTransaction().commit();
        return subGrupoProduto;
    }
    
    public Grupoproduto consultarGrupoProduto(int idGrupo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Grupoproduto grupoProduto = new Grupoproduto();
        Query q = manager.createQuery("select g from Grupoproduto g where g.idgrupoProduto=" + idGrupo);
        grupoProduto =  (Grupoproduto) q.getSingleResult();
        manager.getTransaction().commit();
        return grupoProduto;
    }
            
    



}
