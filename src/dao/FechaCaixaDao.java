/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Fechacaixa;

/**
 *
 * @author Woverine
 */
public class FechaCaixaDao {

    private EntityManager manager;

    public Fechacaixa salvar(Fechacaixa fechaCaixa) throws  Exception{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        fechaCaixa = manager.merge(fechaCaixa);
        //fechando uma transação
        manager.getTransaction().commit();
        return fechaCaixa;
    }

    public Fechacaixa getFechaCaixa(String caixa, int idUsuario) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Fechacaixa fechaCaixa = new Fechacaixa();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String data = df.format(new Date());
        Query q = manager.createQuery("select f from Fechacaixa f where f.dataFechamento='" + data + "' and f.caixa='"+ caixa + "' and f.usuarios=" +
                idUsuario + " and  f.valorFechamento=0 and f.situacao='ABERTO'");
        if (q.getResultList().size()>0){
            fechaCaixa=  (Fechacaixa) q.getResultList().get(0);
            return fechaCaixa;
                    
        }
        return null;
    }
    
    
    public Fechacaixa getFechaCaixa(int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Fechacaixa fechaCaixa = new Fechacaixa();
        Query q = manager.createQuery("select f from Fechacaixa f where f.idfechaCaixa=" + idFechaCaixa);
        if (q.getResultList().size()>0){
            fechaCaixa=  (Fechacaixa) q.getResultList().get(0);
            return fechaCaixa;
        }
        return null;
    }
    
  
    

}
