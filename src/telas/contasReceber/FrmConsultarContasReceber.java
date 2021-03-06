/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.contasReceber;

import Controller.ContasReceberController;
import Controller.CreditoReceberController;
import Controller.VendaController;
import Interface.FrmCadastrarClienteTerminal;
import Regras.Config;
import Regras.Formatacao;
import controler.ItelaVenda;
import facade.TerminalVendasFacade;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Cliente;
import model.Contasreceber;
import model.Contasreceberprodutos;
import model.Creditosreceber;
import model.Faturasreceberparcelas;
import model.Saida;
import model.Terminalcliente;
import model.Terminalproduto;
import negocios.Vendas;

/**
 *
 * @author Wolverine
 */
public class FrmConsultarContasReceber extends javax.swing.JFrame implements IContasReceber{
    
    private List<ContasReceberBean> listaContas;
    private List<ContasReceberBean> listaReceber;
    private Cliente cliente;
    private ItelaVenda telaVenda;
    private List<CreditoBean> listaCreditos;
    private List<CreditoBean> listaCreditosReceber;
    private Config config;
    private double valorContas;
    private double valorCreditos;
    private ConsultaContasReceberTableModel modelContas;
    private  DefaultTableCellRenderer rendererCor;
    private List<Contasreceberprodutos> listaProdutosConta;

    /**
     * Creates new form FrmConsultarContasReceber
     */
    public FrmConsultarContasReceber(Cliente cliente, ItelaVenda telaVenda, Config config) {
        this.telaVenda = telaVenda;
        this.config = config;
        listaCreditosReceber  = new ArrayList<CreditoBean>();
        listaReceber = new ArrayList<ContasReceberBean>();
        this.cliente = cliente;
        this.valorContas =0;
        this.valorCreditos =0;
        initComponents();
        URL url = this.getClass().getResource("/imagens/logo_mini.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        this.setLocationRelativeTo(null);
        carregarListaContasReceber();
        listarCreditos();
        calculcarValorTotais();
        this.rendererCor = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component comp = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                    if (value.equals("SIM")){
                        comp.setBackground(Color.red);
                    }else {
                        comp.setBackground(Color.white);
                    }
                    return comp;
                }
        };
        carregarModelContasReceber();
        this.setTitle("Contas Recber - " + cliente.getNome());
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contasjTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        valorContajLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        valorCreditosjLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        valorPagarjLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        valorReceberjLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas a Receber");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        contasjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº Documento", "Data Lançamento", "Valor R$", "Data Vencimento", "Pagto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contasjTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contasjTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(contasjTable);
        if (contasjTable.getColumnModel().getColumnCount() > 0) {
            contasjTable.getColumnModel().getColumn(0).setResizable(false);
            contasjTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            contasjTable.getColumnModel().getColumn(1).setResizable(false);
            contasjTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            contasjTable.getColumnModel().getColumn(2).setResizable(false);
            contasjTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            contasjTable.getColumnModel().getColumn(3).setResizable(false);
            contasjTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            contasjTable.getColumnModel().getColumn(4).setResizable(false);
            contasjTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        valorContajLabel.setBackground(new java.awt.Color(0, 0, 255));
        valorContajLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        valorContajLabel.setForeground(new java.awt.Color(51, 51, 255));
        valorContajLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valorContajLabel.setText("0,00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valorContajLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valorContajLabel)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Total das Contas");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        valorCreditosjLabel.setBackground(new java.awt.Color(0, 0, 255));
        valorCreditosjLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        valorCreditosjLabel.setForeground(new java.awt.Color(255, 0, 0));
        valorCreditosjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valorCreditosjLabel.setText("0,00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valorCreditosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valorCreditosjLabel)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Total dos Créditos");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        valorPagarjLabel.setBackground(new java.awt.Color(0, 0, 255));
        valorPagarjLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        valorPagarjLabel.setForeground(new java.awt.Color(0, 102, 0));
        valorPagarjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valorPagarjLabel.setText("0,00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valorPagarjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valorPagarjLabel)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Total a Pagar");

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        valorReceberjLabel.setBackground(new java.awt.Color(0, 0, 0));
        valorReceberjLabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        valorReceberjLabel.setForeground(new java.awt.Color(102, 0, 102));
        valorReceberjLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        valorReceberjLabel.setText("0,00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valorReceberjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valorReceberjLabel)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Total Receber");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Pagar Total");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pagar Parcial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Creditos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Receber contas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Terminal");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int linha = contasjTable.getSelectedRow();
        if (linha>=0){
            listaContas.get(linha).setPagamento("SIM");
            if (listaContas.get(linha).getTipo().equalsIgnoreCase("conta")){
                listaContas.get(linha).setValorReceber(listaContas.get(linha).getContaReceber().getValorConta());
            }else {
                listaContas.get(linha).setValorReceber(listaContas.get(linha).getFaturaParcela().getValorParcela());
            }
            listaContas.get(linha).setPagtoParcial(false);
            listaReceber.add(listaContas.get(linha));
            carregarModelContasReceber();
            calcularTotalSelecionado();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linha = contasjTable.getSelectedRow();
        if (linha>=0){
            String svalorParcial = JOptionPane.showInputDialog("Informe valor Parcial para Pagto ex. 10,00" );
            Double valorParcial = Formatacao.formatarStringDouble(svalorParcial);
            if (valorParcial < listaContas.get(linha).getValorConta()){
                listaContas.get(linha).setPagamento("SIM");
                listaContas.get(linha).setValorReceber(valorParcial);
                listaContas.get(linha).setPagtoParcial(true);
                listaReceber.add(listaContas.get(linha));
                calcularTotalSelecionado();
                carregarModelContasReceber();
            }else JOptionPane.showMessageDialog(rootPane, "Valor Parcial não pode ser maior ou igual a VALOR DA CONTA");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        telaVenda.cancelarOperacaoContasReeber();
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (listaReceber.size()>0){
            this.telaVenda.consultarListarContasReceber(this.listaReceber, this.listaCreditosReceber, this.cliente);
            this.dispose();
        }else JOptionPane.showMessageDialog(rootPane, "Não existem contas selecionadas");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listarCreditos();
        if (listaCreditos!=null){
            new FrmConsultaCreditosReceber(listaCreditos, 2, this);
        }else { 
            JOptionPane.showMessageDialog(rootPane, " Cliente não possui creditos");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void contasjTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contasjTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int linha = contasjTable.getSelectedRow();
            if (linha >= 0) {
                listaContas.get(linha).setPagamento("SIM");
                if (listaContas.get(linha).getTipo().equalsIgnoreCase("conta")){
                    listaContas.get(linha).setValorReceber(listaContas.get(linha).getContaReceber().getValorConta());
                }else {
                    listaContas.get(linha).setValorReceber(listaContas.get(linha).getFaturaParcela().getValorParcela());
                }
                listaReceber.add(listaContas.get(linha));
                calcularTotalSelecionado();
            }
        }
    }//GEN-LAST:event_contasjTableKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int linha = contasjTable.getSelectedRow();
        ContasReceberController contasReceberController = new ContasReceberController();
        if (linha >= 0) {
            if (listaContas.get(linha).isTerminal()) {
                JOptionPane.showMessageDialog(rootPane, "Produto já Gerador Terminal");
            } else {
                int id = listaContas.get(linha).getContaReceber().getIdcontasReceber();
                listaProdutosConta = contasReceberController.listaContasReceberProdutos(id);
                lancarTerminalCliente();
                listaContas.get(linha).setTerminal(true);
                JOptionPane.showMessageDialog(rootPane, "Produtos Gerados");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable contasjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel valorContajLabel;
    private javax.swing.JLabel valorCreditosjLabel;
    private javax.swing.JLabel valorPagarjLabel;
    private javax.swing.JLabel valorReceberjLabel;
    // End of variables declaration//GEN-END:variables
    public void carregarListaContasReceber(){
        listaContas = new ArrayList<ContasReceberBean>();
        ContasReceberController contasReceberController = new ContasReceberController();
        String sql = "Select r From Contasreceber r where r.contasreceberpagamento=1 and r.cliente=" + cliente.getIdcliente() + "  and r.empresa=" + this.config.getEmpresa().getIdempresa() + " order by r.dataLancamento";
        List<Contasreceber> listaReceber = contasReceberController.listarContas(sql);
        if (listaReceber!=null){
            for(int i=0;i<listaReceber.size();i++){
                ContasReceberBean contasReceberBean = new ContasReceberBean(listaReceber.get(i));
                listaContas.add(contasReceberBean);
            }
        }
        sql = "Select r From Faturasreceberparcelas r where r.contasreceberpagamento=1 and r.cliente=" + cliente.getIdcliente() + " and r.empresa=" + this.config.getEmpresa().getIdempresa() + " order by r.dataLancamento";
        List<Faturasreceberparcelas> listaFatura = contasReceberController.listarFaturasParcelas(sql);
        if (listaFatura!=null){
            for(int i=0;i<listaFatura.size();i++){
                ContasReceberBean contasReceberBean = new ContasReceberBean(listaFatura.get(i));
                listaContas.add(contasReceberBean);
            }
        }
    }
    
    public void listarCreditos(){
        listaCreditos = new ArrayList<CreditoBean>();
        String sqlCreditos = "select c from Creditosreceber c where c.contasreceberpagamento=1 and c.empresa=" + this.config.getEmpresa().getIdempresa() + 
                " and c.cliente=" + cliente.getIdcliente() + " and c.empresa=" + this.config.getEmpresa().getIdempresa() + " order by c.dataLancamento";
        CreditoReceberController creditoReceberController = new CreditoReceberController();
        List<Creditosreceber> listaCreditosReceber = creditoReceberController.listarCreditos(sqlCreditos);
        List<CreditoBean> listaCreditoBean = new ArrayList<CreditoBean>();
        if (listaCreditosReceber!=null){
            for(int i=0;i<listaCreditosReceber.size();i++){
                CreditoBean creditoBean = new CreditoBean(listaCreditosReceber.get(i));
                this.listaCreditos.add(creditoBean);
            }
        }
    }
    
    public void calculcarValorTotais(){
        if (listaCreditos!=null){
            valorCreditos=0;
            for(int i=0;i<listaCreditos.size();i++){
                valorCreditos = valorCreditos + listaCreditos.get(i).getCredito().getValorCredito();
            }
        }
        
        if (listaContas!=null){
            valorContas = 0;
            for(int i=0;i<listaContas.size();i++){
                valorContas = valorContas + listaContas.get(i).getValorConta();
            }
        }
        valorContajLabel.setText(Formatacao.foramtarDoubleString(valorContas));
        valorCreditosjLabel.setText(Formatacao.foramtarDoubleString(valorCreditos));
        valorPagarjLabel.setText(Formatacao.foramtarDoubleString(valorContas - valorCreditos));
    }
    
    public void carregarModelContasReceber(){
        modelContas = new ConsultaContasReceberTableModel(listaContas);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        
        contasjTable.setModel(modelContas);
        contasjTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        contasjTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        contasjTable.getColumnModel().getColumn(2).setCellRenderer(renderer);
        contasjTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        contasjTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        contasjTable.getColumnModel().getColumn(4).setCellRenderer(rendererCor);
        contasjTable.getColumnModel().getColumn(4).setPreferredWidth(10);
        contasjTable.repaint();
    }

    public void pagarCreditos(List<CreditoBean> listaCreditos) {
        if (listaCreditos!=null){
           for (int i=0;i<listaCreditos.size();i++){
               if (listaCreditos.get(i).getUtilizar().equalsIgnoreCase("SIM")){
                   listaCreditosReceber.add(listaCreditos.get(i));
               }
           }
        }
    }
    
    public void calcularTotalSelecionado(){
        if (listaContas!=null){
            double valor =0;
            for(int i=0;i<listaContas.size();i++){
                if (listaContas.get(i).getPagamento().equalsIgnoreCase("SIM")){
                    valor = valor + listaContas.get(i).getValorReceber();
                }
            }
            valorReceberjLabel.setText(Formatacao.foramtarDoubleString(valor));
        }
    }
    
    public void lancarTerminalCliente() {
        TerminalVendasFacade terminalVendasFacade = new TerminalVendasFacade();
        Terminalcliente terminalCliente = null;
        try {
            terminalCliente = terminalVendasFacade.getTerminalCliente(String.valueOf(cliente.getIdcliente()));
        } catch (Exception ex) {
            Logger.getLogger(FrmConsultarContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro Consultar terminal cliente " + ex);
        }
        if (terminalCliente == null) {
            terminalCliente = new Terminalcliente();
            terminalCliente.setEmpresa(config.getEmpresa().getIdempresa());
            terminalCliente.setNome(String.valueOf(cliente.getIdcliente()));
            terminalCliente.setFormapagamento(1);
            terminalCliente.setVendedor(1);
            terminalCliente.setValorDesconto(0.0f);
            terminalCliente.setAcrescimo(0.0f);
            terminalCliente.setValorCompra(0.0f);
            terminalCliente.setPercDesconto(0.0f);
            terminalCliente.setCondicaoPagamento("A Vista");
            terminalCliente.setIdCliente(0);
            terminalCliente.setIdContasReceber(0);
            try {
                terminalCliente = terminalVendasFacade.salvarCliente(terminalCliente);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultarContasReceber.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Salvar Cliente Terminal " + ex);
            }
        }
        VendaController vendaController = new VendaController();
        for (int i = 0; i < listaProdutosConta.size(); i++) {
            Terminalproduto terminalProduto = new Terminalproduto();
            List<Saida> listaSaida = vendaController.listarSaidaVenda(listaProdutosConta.get(i).getVenda());
            if (listaSaida != null) {
                for (int c = 0; c < listaSaida.size(); c++) {
                    terminalProduto.setProduto(listaSaida.get(c).getProduto());
                    terminalProduto.setQuantidade((listaSaida.get(c).getQuantidade()));
                    Double quantidade = listaSaida.get(c).getQuantidade();
                    Float valorUnitario = listaSaida.get(c).getValorVenda() / quantidade.floatValue();
                    terminalProduto.setValorUnitario(valorUnitario);
                    terminalProduto.setTerminalcliente(terminalCliente.getIdterminalCliente());
                    terminalProduto.setVendedor(1);
                    terminalProduto.setValorColorante(0.0);
                    try {
                        terminalVendasFacade.salvarProduto(terminalProduto);
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmConsultarContasReceber.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro Salvar Produto Terminal " + ex);
                    }
                }

            }
        }
    }
}
