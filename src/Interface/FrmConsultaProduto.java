/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConsultaProduto.java
 *
 * Created on 08/11/2010, 09:44:15
 */

package Interface;

import Regras.Config;
import facade.ConsultaProdutoFacade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import view.Viewconsultaprodutoestoque;


/**
 *
 * @author Woverine
 */
public class FrmConsultaProduto extends javax.swing.JFrame {

    private List<Viewconsultaprodutoestoque> listaProdutoEstoque;
    private ConsultaProdutoTableModel model;
    private JTextField codigoProdutojText;
    private Config config;

    /** Creates new form FrmConsultaProduto */
    public FrmConsultaProduto(JTextField codigoProdutojText, Config config) throws SQLException {
       this.config = config;
        listaProdutoEstoque = new ArrayList<Viewconsultaprodutoestoque>();
        listaProdutoEstoque = new ConsultaProdutoFacade().consultaEstoque(config.getEmpresa().getIdempresa());
        model = new ConsultaProdutoTableModel(listaProdutoEstoque);
        initComponents();
        this.setLocationRelativeTo(null);
        gerarJTable();
        this.codigoProdutojText = codigoProdutojText;
        DescricaojTextField.requestFocus();
        this.setVisible(true);
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutojTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        confirnajButton = new javax.swing.JButton();
        cancelajButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CodigojTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DescricaojTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Produtos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaProdutojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Unidade", "Quantidade", "Valor Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaProdutojTable.setColumnSelectionAllowed(true);
        listaProdutojTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaProdutojTable.getTableHeader().setReorderingAllowed(false);
        listaProdutojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProdutojTableMouseClicked(evt);
            }
        });
        listaProdutojTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaProdutojTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listaProdutojTable);
        listaProdutojTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaProdutojTable.getColumnModel().getColumn(0).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(1).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        listaProdutojTable.getColumnModel().getColumn(2).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(3).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(4).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(5);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 380));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 820, 400));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        confirnajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tick.png"))); // NOI18N
        confirnajButton.setText("Confirmar");
        confirnajButton.setToolTipText("Comfirma produto selecionado");
        confirnajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirnajButtonActionPerformed(evt);
            }
        });
        jPanel4.add(confirnajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        cancelajButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cross.png"))); // NOI18N
        cancelajButton.setText("Cancelar");
        cancelajButton.setToolTipText("Cancela consulta de Produto");
        cancelajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelajButtonActionPerformed(evt);
            }
        });
        jPanel4.add(cancelajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 820, 40));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Código");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        CodigojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CodigojTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodigojTextFieldKeyReleased(evt);
            }
        });
        jPanel5.add(CodigojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 90, -1));

        jLabel2.setText("Descrição");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        DescricaojTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DescricaojTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescricaojTextFieldKeyReleased(evt);
            }
        });
        jPanel5.add(DescricaojTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 25, 460, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaProdutojTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaProdutojTableKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            int linha = listaProdutojTable.getSelectedRow();
            if (linha>=0){
                codigoProdutojText.setText(codigoProdutojText.getText() + String.valueOf(listaProdutoEstoque.get(linha).getReferencia()));
                this.dispose();
            }
        }
    }//GEN-LAST:event_listaProdutojTableKeyPressed

    private void CodigojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigojTextFieldKeyPressed
        
    }//GEN-LAST:event_CodigojTextFieldKeyPressed


    private void DescricaojTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescricaojTextFieldKeyPressed

       if ((evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) || (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP)){
           listaProdutojTable.requestFocus();
       }
    }//GEN-LAST:event_DescricaojTextFieldKeyPressed

    private void confirnajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirnajButtonActionPerformed
        int linha = listaProdutojTable.getSelectedRow();
        if (linha >= 0) {
            codigoProdutojText.setText(codigoProdutojText.getText() + String.valueOf(listaProdutoEstoque.get(linha).getReferencia()));
            this.dispose();
        }
}//GEN-LAST:event_confirnajButtonActionPerformed

    private void cancelajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelajButtonActionPerformed
       this.dispose();
}//GEN-LAST:event_cancelajButtonActionPerformed

    private void DescricaojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescricaojTextFieldKeyReleased
        if (DescricaojTextField.getText().length() > 0) {
            try {
                listaProdutoEstoque = new ConsultaProdutoFacade().consultaEstoque(DescricaojTextField.getText(), config.getEmpresa().getIdempresa());
                model = new ConsultaProdutoTableModel(listaProdutoEstoque);
                gerarJTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro Consultar Descrição Produto");
                Logger.getLogger(FrmConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                listaProdutoEstoque = new ConsultaProdutoFacade().consultaEstoque(config.getEmpresa().getIdempresa());
                model = new ConsultaProdutoTableModel(listaProdutoEstoque);
                gerarJTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro Consultar Descrição Produto");
                Logger.getLogger(FrmConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_DescricaojTextFieldKeyReleased

    private void CodigojTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigojTextFieldKeyReleased
        if (evt.getKeyCode() != java.awt.event.KeyEvent.VK_ENTER) {
            if (CodigojTextField.getText().length() > 0) {
                try {
                    listaProdutoEstoque = new ConsultaProdutoFacade().consultaEstoque(Integer.parseInt(CodigojTextField.getText()), config.getEmpresa().getIdempresa());
                    model = new ConsultaProdutoTableModel(listaProdutoEstoque);
                    gerarJTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro Consultar Código Produto");
                    Logger.getLogger(FrmConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    listaProdutoEstoque = new ConsultaProdutoFacade().consultaEstoque(config.getEmpresa().getIdempresa());
                    model = new ConsultaProdutoTableModel(listaProdutoEstoque);
                    gerarJTable();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro Consultar Código Produto");
                    Logger.getLogger(FrmConsultaProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_CodigojTextFieldKeyReleased

    private void listaProdutojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProdutojTableMouseClicked
        
    }//GEN-LAST:event_listaProdutojTableMouseClicked

    /**
    * @param args the command line arguments
    */


     public void gerarJTable(){
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        listaProdutojTable.setModel(model);
        listaProdutojTable.setColumnSelectionAllowed(true);
        listaProdutojTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaProdutojTable.setShowVerticalLines(false);
        listaProdutojTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(listaProdutojTable);
        listaProdutojTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaProdutojTable.getColumnModel().getColumn(0).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(1).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(2).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        listaProdutojTable.getColumnModel().getColumn(3).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        listaProdutojTable.getColumnModel().getColumn(4).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(5);
        listaProdutojTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        listaProdutojTable.getColumnModel().getColumn(5).setResizable(false);
        listaProdutojTable.getColumnModel().getColumn(5).setPreferredWidth(5);
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodigojTextField;
    private javax.swing.JTextField DescricaojTextField;
    private javax.swing.JButton cancelajButton;
    private javax.swing.JButton confirnajButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProdutojTable;
    // End of variables declaration//GEN-END:variables

}
