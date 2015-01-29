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
    private double valorTributo;
    private double aliquotoImposto;
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

    public double getValorTributo() {
        return valorTributo;
    }

    public void setValorTributo(double valorTributo) {
        this.valorTributo = valorTributo;
    }

    public double getAliquotoImposto() {
        return aliquotoImposto;
    }

    public void setAliquotoImposto(double aliquotoImposto) {
        this.aliquotoImposto = aliquotoImposto;
    }
   
    
}
