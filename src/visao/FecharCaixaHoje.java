package visao;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.FluxoCaixa;
import org.hibernate.Session;
import util.Data;

/**
 *
 * @author marcos-victor
 */
public class FecharCaixaHoje extends javax.swing.JPanel {

    GenericoDAO<FluxoCaixa> generico_fluxo;

    public FecharCaixaHoje() {
        initComponents();
        this.setBackground(Color.blue);

        float saldoFLOAT = 0;

        saldoFLOAT += carregarEntradasHoje();
        saldoFLOAT -= carregarSaidasHoje();

        NumberFormat nf = NumberFormat.getInstance();//formata o total
        nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2

        this.saldo.setText(nf.format(saldoFLOAT).replace(",", "."));

        this.saldo.setText(saldoFLOAT + "");

        this.valorEntrada.setOpaque(true);
        this.valorEntrada.setBackground(Color.white);
        this.valorEntrada.setForeground(Color.black);

        this.valorSaida.setOpaque(true);
        this.valorSaida.setBackground(Color.white);
        this.valorSaida.setForeground(Color.black);

        this.saldo.setOpaque(true);
        this.saldo.setBackground(Color.white);
        this.saldo.setForeground(Color.black);
    }

    public float carregarEntradasHoje() {
        //sessao fluxo
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.generico_fluxo = new GenericoDAO(FluxoCaixa.class, sessao);

        //pegando data atual e formatando
        String[] dataFormatada = Data.getData().split("/");
        String novaData = dataFormatada[2] + "/" + dataFormatada[1] + "/" + dataFormatada[0];

        String sql = "select * from FluxoCaixa where venda_id is not NULL and dataEmissao like ? order by descricao asc";
        String[] atributos = new String[]{"dataEmissao"};
        String[] valores = new String[]{novaData + "%"};

        ArrayList<FluxoCaixa> entradas = (ArrayList<FluxoCaixa>) this.generico_fluxo.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel modelo_tabela = ((DefaultTableModel) tabelaEntrada.getModel());

        while (modelo_tabela.getRowCount() > 0) {
            modelo_tabela.removeRow(0);
        }

        float totalFLOAT = 0;
        for (FluxoCaixa fluxo : entradas) {
            modelo_tabela.addRow(new Object[]{fluxo.getDescricao(), fluxo.getValor(), fluxo.getDataEmissao(), fluxo.getVenda().getOpcaoVenda(), fluxo.getVenda().getId()});
            totalFLOAT += fluxo.getValor();
        }
        NumberFormat nf = NumberFormat.getInstance();//formata o total
        nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2
        this.valorEntrada.setText(nf.format(totalFLOAT).replace(",", "."));
        return totalFLOAT;
    }

    public float carregarSaidasHoje() {
        //sessao fluxo
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.generico_fluxo = new GenericoDAO(FluxoCaixa.class, sessao);

        //pegando data atual e formatando
        String[] dataFormatada = Data.getData().split("/");
        String novaData = dataFormatada[2] + "/" + dataFormatada[1] + "/" + dataFormatada[0];

        String sql = "select * from FluxoCaixa where venda_id is NULL and (dataEmissao like ? and dataVencimento like ?) or dataPagamento like ? order by descricao asc";
        String[] atributos = new String[]{"dataEmissao", "dataVencimento", "dataPagamento"};
        String[] valores = new String[]{novaData + "%", "sem", novaData + "%"};

        ArrayList<FluxoCaixa> saidas = (ArrayList<FluxoCaixa>) this.generico_fluxo.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel modelo_tabela = ((DefaultTableModel) tabelaSaida.getModel());

        while (modelo_tabela.getRowCount() > 0) {
            modelo_tabela.removeRow(0);
        }
        float totalFLOAT = 0;
        for (FluxoCaixa fluxo : saidas) {
            modelo_tabela.addRow(new Object[]{fluxo.getDescricao(), fluxo.getValor(), fluxo.getDataEmissao(), fluxo.getId()});
            totalFLOAT += fluxo.getValor();
        }
        NumberFormat nf = NumberFormat.getInstance();//formata o total
        nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2
        this.valorSaida.setText(nf.format(totalFLOAT).replace(",", "."));
        return totalFLOAT;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valorSaida = new javax.swing.JLabel();
        valorEntrada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEntrada = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSaida = new javax.swing.JTable();
        saldo = new javax.swing.JLabel();

        valorSaida.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        valorSaida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorSaida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor das saida", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        valorEntrada.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        valorEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorEntrada.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor das entradas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tabelaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Data", "Pagamento", "Id_v"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEntrada.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaEntrada);
        if (tabelaEntrada.getColumnModel().getColumnCount() > 0) {
            tabelaEntrada.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaEntrada.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabelaEntrada.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaEntrada.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaEntrada.getColumnModel().getColumn(4).setPreferredWidth(40);
            tabelaEntrada.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        tabelaSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Data", "Id_d"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaSaida.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaSaida);
        if (tabelaSaida.getColumnModel().getColumnCount() > 0) {
            tabelaSaida.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaSaida.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabelaSaida.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaSaida.getColumnModel().getColumn(3).setPreferredWidth(40);
            tabelaSaida.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        saldo.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        saldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saldo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(valorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valorSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel saldo;
    private javax.swing.JTable tabelaEntrada;
    private javax.swing.JTable tabelaSaida;
    private javax.swing.JLabel valorEntrada;
    private javax.swing.JLabel valorSaida;
    // End of variables declaration//GEN-END:variables
}
