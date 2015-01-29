/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Chequefechacaixa;
import model.Chequemovbanco;
import model.Chequemovcaixa;
import model.Contolechequefornecedor;
import model.Controlecheques;

/**
 *
 * @author Wolverine
 */
public class ControleChequeDao {
    
    private EntityManager manager;
    
    public Controlecheques salvarCehque(Controlecheques cheque) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        cheque = manager.merge(cheque);
        //fechando uma transação
        manager.getTransaction().commit();
        return cheque;
    }
    
    public List<Controlecheques> listarCheques(String sql) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Controlecheques> listaCheques = new ArrayList<Controlecheques>();
        Query q = manager.createQuery(sql);
        if (q.getResultList().size()>0){
            listaCheques = q.getResultList();
            return listaCheques;
        }else return null;
    }
    
    public Controlecheques listarChequesid(int idCheque) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Controlecheques c where c.situacao='CAIXA' and c.idControleCheques=" +
                idCheque);
        if (q.getResultList().size()>0){
            return (Controlecheques) q.getResultList().get(0);
        }
        return null;
    }
    
    public List<Contolechequefornecedor> consultarFornecedor(int idFornecedor) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        String data = "";
        try {
            data ="";// Formatacao.SubtarirDatas(new Date(), 90, "yyyy/MM/dd");
        } catch (Exception ex) {
            Logger.getLogger(ControleChequeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Query q = manager.createQuery("Select c from Contolechequefornecedor c where c.fornecedor=" + idFornecedor +
                " and dataFornecedor>='" + data + "'");
        if (q.getResultList().size()>0){
            return   q.getResultList();
        }else return null;
    }
    
    public Contolechequefornecedor consultarFornecedorCheque(int idControleCheques) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Contolechequefornecedor c where c.controlecheques=" + idControleCheques);
        if (q.getResultList().size()>0){
            return   (Contolechequefornecedor) q.getSingleResult();
        }else return null;
    }
    
    public void salvarFornecedor(Contolechequefornecedor fornecedor) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        manager.merge(fornecedor);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public Controlecheques consultarCheque(int idControleCheques) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        List<Controlecheques> listaCheques = new ArrayList<Controlecheques>();
        Query q = manager.createQuery("Select c from Controlecheques c where c.idControleCheques=" + idControleCheques);
        if (q.getResultList().size()>0){
            return (Controlecheques) q.getSingleResult();
        }else return null;
    }
    
    public Chequefechacaixa salvarCehqueFechaCaixa(Chequefechacaixa cheque) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        cheque = manager.merge(cheque);
        //fechando uma transação
        manager.getTransaction().commit();
        return cheque;
    }
    
    public Chequemovbanco salvarChequeMovBanco(Chequemovbanco chequeMovBanco) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        chequeMovBanco = manager.merge(chequeMovBanco);
        //fechando uma transação
        manager.getTransaction().commit();
        return chequeMovBanco;
    }
    
    public Chequemovcaixa salvarChequeMovCaixa(Chequemovcaixa chequeMovCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        chequeMovCaixa = manager.merge(chequeMovCaixa);
        //fechando uma transação
        manager.getTransaction().commit();
        return chequeMovCaixa;
    }
    
    public List<Chequefechacaixa>  ListaChequesCaixa(int idFechaCaixa) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from Chequefechacaixa c where c.fechacaixa=" + idFechaCaixa);
        if (q.getResultList().size()>0){
            return   q.getResultList();
        }
        return null;
    }
    
    public void excluirControleCheque(Controlecheques controlecheques) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        controlecheques = manager.find(Controlecheques.class, controlecheques.getIdControleCheques());
        manager.remove(controlecheques);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public void excluirControleChequeFechaCaixa(Chequefechacaixa chequefechacaixa) throws Exception {
        manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        chequefechacaixa = manager.find(Chequefechacaixa.class, chequefechacaixa.getIdchequefechacaixa());
        manager.remove(chequefechacaixa);
        //fechando uma transação
        manager.getTransaction().commit();
    }
    
    public Chequefechacaixa  ListaChequesCaixaid(int idControleCheque) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        Query q = manager.createQuery("Select c from chequefechacaixa c where c.controlecheques" + idControleCheque);
        if (q.getResultList().size()>0){
            return   (Chequefechacaixa) q.getResultList().get(0);
        }
        return null;
    }
}
