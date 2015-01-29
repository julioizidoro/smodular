/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import dao.MovimentoCaixaDao;
import java.sql.SQLException;
import java.util.List;
import model.Movimentocaixa;


/**
 *
 * @author Wolverine
 */
public class MovimentoCaixaFacade {

    private MovimentoCaixaDao movimentoCaixaDao;

    public Movimentocaixa consultarMovimentoCaixa(int idMovimentoCaixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(idMovimentoCaixa);
    }

    public void salvarCaixa(Movimentocaixa caixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        movimentoCaixaDao.salvarCaixa(caixa);
    }


    public List<Movimentocaixa> conusltarMovimentoCaixas(String descricao) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.conusltarMovimentoCaixas(descricao);
    }

    public List<Movimentocaixa> consutlarMovimentoCaixa(String inicio, String fim) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(inicio, fim);
    }

    public List<Movimentocaixa> MovimentoCaixa(String inicio, String fim, int planoContas) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultarMovimentoCaixa(inicio, fim, planoContas);
    }

    public List<Double> calculaSaldos(String dataCaixa) throws SQLException {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.calculaSaldos(dataCaixa);
    }

    public Movimentocaixa consultaMovimentoCaixa(String sql) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.consultaMovimentoCaixa(sql);
    }

    public double getSaldoAnterior(String dataCaixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.getSaldoAnterior(dataCaixa);
    }

    public List<Double> calculaSaldos(String dataInicio, String dataFinal ) throws SQLException {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.calculaSaldos(dataInicio, dataFinal);
    }
    
    public int ultimaMovimentoCaixaSalvo() throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        return movimentoCaixaDao.ultimaMovimentoCaixaSalvo();
    }
    
    public void excluirCaixa(int idCaixa) throws Exception {
        movimentoCaixaDao = new MovimentoCaixaDao();
        movimentoCaixaDao.excluirCaixa(idCaixa);
    }

}
