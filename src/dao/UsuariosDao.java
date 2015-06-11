/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controler.ConexaoSingleton;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuarios;

/**
 *
 * @author Wolverine
 */
public class UsuariosDao {
    
    EntityManager manager;
    
    public Usuarios consultarUsuario(String login, String senha) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT u FROM Usuarios u WHERE u.login='" + login + "' and u.senha='" + senha + "'");
        if (q.getResultList().size()>0){
            manager.getTransaction().commit();
            return (Usuarios) q.getSingleResult();
        }
        manager.getTransaction().commit();
        return null;
    }
    
    public Usuarios consultarUsuario(int idUsuario) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT u FROM Usuarios u WHERE u.idusuarios=" + idUsuario);
        if (q.getResultList().size()>0){
            manager.getTransaction().commit();
            return (Usuarios) q.getSingleResult();
        }
        manager.getTransaction().commit();
        return null;
    }
    
    public Usuarios salvarUsuario(Usuarios usuario) throws SQLException{
       manager = ConexaoSingleton.getConexao();
        //abrindo uma transação
        manager.getTransaction().begin();
        String senha = null;
        int idFecahCaixa=0;
        if (usuario.getIdusuarios()!=null){
             senha = usuario.getSenha();
             idFecahCaixa = usuario.getIdFechaCaixa();
            usuario = manager.find(Usuarios.class, usuario.getIdusuarios());
            usuario.setSenha(senha);
            usuario.setIdFechaCaixa(idFecahCaixa);
        }
        usuario = manager.merge(usuario);
        //fechando uma transação
        manager.getTransaction().commit();
        return usuario;
    }
    
    public Usuarios consultarUsuario(String senha) throws SQLException{
        manager = ConexaoSingleton.getConexao();
        manager.getTransaction().begin();
        Query q = manager.createQuery("SELECT u FROM Usuarios u WHERE u.senha='" + senha + "'");
        if (q.getResultList().size()>0){
            manager.getTransaction().commit();
            return (Usuarios) q.getSingleResult();
        }
        manager.getTransaction().commit();
        return null;
    }

    
}
