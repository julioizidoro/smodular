/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Regras;

import model.Produto;

/**
 *
 * @author Woverine
 */
public class ProdutoVenda {

    private int numeroItem;
    private Produto produto;
    private double quantidade;
    private float valorUnitario;
    private float valorTotal;
    private double valorColorante;
    private float valorCompra;
    private double valorTributoFederal;
    private double aliquotoImpostoFederal;
    private double valorTributoEstadual;
    private double aliquotoImpostoEstadual;
    private int vendedor;

    public int getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorColorante() {
        return valorColorante;
    }

    public void setValorColorante(double valorColorante) {
        this.valorColorante = valorColorante;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorTributoFederal() {
        return valorTributoFederal;
    }

    public void setValorTributoFederal(double valorTributoFederal) {
        this.valorTributoFederal = valorTributoFederal;
    }

    public double getAliquotoImpostoFederal() {
        return aliquotoImpostoFederal;
    }

    public void setAliquotoImpostoFederal(double aliquotoImpostoFederal) {
        this.aliquotoImpostoFederal = aliquotoImpostoFederal;
    }

    public double getValorTributoEstadual() {
        return valorTributoEstadual;
    }

    public void setValorTributoEstadual(double valorTributoEstadual) {
        this.valorTributoEstadual = valorTributoEstadual;
    }

    public double getAliquotoImpostoEstadual() {
        return aliquotoImpostoEstadual;
    }

    public void setAliquotoImpostoEstadual(double aliquotoImpostoEstadual) {
        this.aliquotoImpostoEstadual = aliquotoImpostoEstadual;
    }

    
   
    
}
