package modelo.vo;                

import java.util.ArrayList;


public class Venda{

    private int id;
    private String opcao_venda;
    private String data;
    private float valor, desconto;
    
    private ArrayList<ItemVenda> itens = new ArrayList();

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Venda{" + "opcao_venda=" + opcao_venda + ", data=" + data + ", valor=" + valor + '}';
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String opcao_venda() {
        return opcao_venda;
    }

    public void setOpcao_venda(String opcao_venda) {
        this.opcao_venda = opcao_venda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    
}
