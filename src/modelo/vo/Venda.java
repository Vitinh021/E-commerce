package modelo.vo;                

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String opcaoVenda, local;
    private String data;
    private float valor, desconto;
    @OneToOne
    private Usuario usuario;
    private ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", opcaoVenda=" + opcaoVenda + ", local=" + local + ", data=" + data + ", valorTotal=" + valor + ", desconto=" + desconto + ", itens=" + itens + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpcaoVenda() {
        return opcaoVenda;
    }

    public void setOpcaoVenda(String opcaoVenda) {
        this.opcaoVenda = opcaoVenda;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
