package modelo.vo;

public class FluxoCaixa {
    private int id;
    private Usuario usuario;
    private Venda venda;
    private float despesas, apurado;
    private String data;

    @Override
    public String toString() {
        return "FluxoCaixa{" + "usuario=" + usuario + ", venda=" + venda + ", despesas=" + despesas + ", apurado=" + apurado + ", data=" + data + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public float getDespesas() {
        return despesas;
    }

    public void setDespesas(float despesas) {
        this.despesas = despesas;
    }

    public float getApurado() {
        return apurado;
    }

    public void setApurado(float apurado) {
        this.apurado = apurado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
