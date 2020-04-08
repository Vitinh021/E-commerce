package modelo.vo;

public class ItemVenda {
    private int id;
    private int quantidade;
    private Produto produto;
    private Venda venda;
    
    @Override
    public String toString() {
        return "ItemVenda{" + "quantidade=" + quantidade + ", produto=" + produto + '}';
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

 
}
