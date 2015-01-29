/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.DevolucaoDao;
import java.util.List;
import model.Devolucao;
import model.Devolucaoproduto;
import model.Fechacaixa;

/**
 *
 * @author Wolverine
 */
public class DevolucaoFacade {

    DevolucaoDao devolucaoDao;

    public void gravarDevolucao(Devolucao devolucao) throws Exception{
        devolucaoDao = new DevolucaoDao();
        devolucaoDao.gravarDevolucao(devolucao);
    }

    public void gravarDevolucaoProduto(Devolucaoproduto devolucaoProduto) throws Exception{
        devolucaoDao = new DevolucaoDao();
        devolucaoDao.gravarDevolucaoProduto(devolucaoProduto);
    }

    public Devolucao ultimaDevolucaoGravada() throws Exception {
        devolucaoDao = new DevolucaoDao();
        int iddevolucao = devolucaoDao.ultimaDevolucaoGravada();
        return devolucaoDao.getDevolucao(iddevolucao);
    }
    
    public List<Devolucao> getDevolucao(Fechacaixa fechaCaixa) throws Exception{
        devolucaoDao = new DevolucaoDao();
        return devolucaoDao.getDevolucao(fechaCaixa);
    }


}