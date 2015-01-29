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
        List<Grupoproduto> listaGrupoProdutos = new ArrayList<Grupoproduto>();
        Query q = manager.createQuery("select g from Grupoproduto g order by g.descricao");
        listaGrupoProdutos = q.getResultList();
        return listaGrupoProdutos;
    }

    public List<Subgrupoproduto> listSubGrupoProduto(int idGrupo) throws Exception{
        manager = ConexaoSingleton.getConexao();
        List<Subgrupoproduto> listaSubGrupoProduto = new ArrayList<Subgrupoproduto>();
        Query q = manager.createQuery("select s from Subgrupoproduto s where s.grupoproduto=" + idGrupo + " order by s.descricao");
        listaSubGrupoProduto = q.getResultList();
        return listaSubGrupoProduto;
    }
    
    public Subgrupoproduto consultarSubGrupoProduto(int idSubGrupo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Subgrupoproduto subGrupoProduto = new Subgrupoproduto();
        Query q = manager.createQuery("select s from Subgrupoproduto s where s.idsubGrupoProduto=" + idSubGrupo);
        subGrupoProduto = (Subgrupoproduto) q.getSingleResult();
        return subGrupoProduto;
    }
    
    public Grupoproduto consultarGrupoProduto(int idGrupo) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Grupoproduto grupoProduto = new Grupoproduto();
        Query q = manager.createQuery("select g from Grupoproduto g where g.idgrupoProduto=" + idGrupo);
        grupoProduto =  (Grupoproduto) q.getSingleResult();
        return grupoProduto;
    }
            
    



}
