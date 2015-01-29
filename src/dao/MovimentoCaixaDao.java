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
import model.Movimentocaixa;

/**
 *
 * @author Wolverine
 */
public class MovimentoCaixaDao {
    
    private EntityManager manager;

    public Movimentocaixa consultarMovimentoCaixa(int idMovimentoCaixa) throws Exception {
        Query query = manager.createQuery("Select c From Caixa c where idMovimentocaixa=" + idMovimentoCaixa);
        return (Movimentocaixa) query.getSingleResult();
    }

    public void salvarCaixa(Movimentocaixa caixa) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            manager.getTransaction().begin();
            manager.merge(caixa);
            manager.getTransaction().commit();
          }catch(Exception ex){
              if (manager.getTransaction().isActive()){
                  manager.getTransaction().rollback();
              }
              throw new Exception("Erro ao Salvar no Banco de Dados", ex);
          }
    }


    public List<Movimentocaixa> conusltarMovimentoCaixas(String descricao) throws Exception {
        manager = ConexaoSingleton.getConexao();
        try{
            Query q = manager.createQuery("SELECT c FROM Movimentocaixa c WHERE c.descricao Like '%" + descricao + "%' order by c.descricao");
            return q.getResultList();
        }catch(Exception ex){
            throw new Exception("Erro de consulta", ex);
        }


    }

    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select c  From Movimentocaixa c");
                //manager.createQuery("Select c from Movimentocaixa c where (c.data>='" + inicio +
             //   "')  and (c.data<='" + fim + "') order by c.data" );
        List<Movimentocaixa> listaCaixa = new ArrayList<Movimentocaixa>();
        listaCaixa = query.getResultList();
        return listaCaixa;
    }

    public List<Movimentocaixa> consultarMovimentoCaixa(String inicio, String fim, int planoContas) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery("Select c From Movimentocaixa c Where (c.data>='" + inicio +
                "')  and (c.data<='" + fim + "')  and (c.conta=" + planoContas + ")  order by c.data");
        return query.getResultList();
    }

    public List<Double> calculaSaldos(String dataCaixa) throws SQLException {
        double valor= 0;
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From Movimentocaixa where(dataMovimento='" + dataCaixa + "')");
        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From Movimentocaixa where(dataMovimento='" + dataCaixa + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From Movimentocaixa where(dataMovimento<'" + dataCaixa + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From Movimentocaixa where(dataMovimento<'" + dataCaixa + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);
        return saldo;
    }

    public Movimentocaixa consultaMovimentoCaixa(String sql) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createQuery(sql);
        return (Movimentocaixa) query.getResultList().get(0);
    }

    public double getSaldoAnterior(String dataCaixa) throws Exception {
        manager = ConexaoSingleton.getConexao();
        Query query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From Movimentocaixa where(data<'" + dataCaixa + "')");
        double valor = 0;
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
        }
        return valor;
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal ) throws SQLException {
        manager = ConexaoSingleton.getConexao();
        double valor= 0;
        Query query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From Movimentocaixa where(data<'" + dataInicio + "')");

        List<Double> saldo = new ArrayList<Double>();
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);


        query = manager.createNativeQuery("Select distinct sum(valorSaida) as saida " +
                "From Movimentocaixa where(data<'" + dataInicio + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorEntrada) as entrada " +
                "From Movimentocaixa where(data>='" + dataInicio + "') and  (data<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);

        query = manager.createNativeQuery("Select distinct sum(valorSaida) as entrada " +
                "From Movimentocaixa where(data>='" + dataInicio + "') and  (data<='" + dataFinal + "')");
        if (query.getSingleResult()!=null){
            valor = (Double) query.getSingleResult();
            saldo.add(valor);
        }else saldo.add(0.0);
        return saldo;
    }
    
    public int ultimaMovimentoCaixaSalvo() throws Exception {
        manager = ConexaoSingleton.getConexao();
        //verificar last insert id
        Query q = manager.createNativeQuery("Select MAX(idMovimentocaixa) From Movimentocaixa");
        int id = (Integer)q.getSingleResult();
        manager.close();
        return id;
    }
    
    public void excluirCaixa(int idCaixa) throws Exception {
        Movimentocaixa caixa = new Movimentocaixa();
        manager = ConexaoSingleton.getConexao();
        try{
            manager.getTransaction().begin();
            caixa = manager.find(Movimentocaixa.class, idCaixa);
            manager.remove(caixa);
            manager.getTransaction().commit();
          }catch(Exception ex){
              if (manager.getTransaction().isActive()){
                  manager.getTransaction().rollback();
              }
              throw new Exception("Erro ao Salvar no Banco de Dados", ex);
          }
    }

}
