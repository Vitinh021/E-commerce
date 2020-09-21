/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Usuario;
import modelo.vo.Venda;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class ListarVenda extends javax.swing.JPanel {

    /**
     * Creates new form ListarVenda
     */
    GenericoDAO<Venda> genericoVen;
    ArrayList<Venda> vendas;

    public ListarVenda() {
        initComponents();
        
        carregarUsuarios();

        this.setVisible(true);
    }

    public void carregarTabela() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoVen = new GenericoDAO(Venda.class, sessao);

        //sql responsavel por pegar os dados na base
        //sempre modificar quando mudar de objeto 
        String sql = "select * from Venda where data like ? order by data asc";
        String[] atributos = new String[]{"data"};
        String[] valores = new String[]{datainicial.getText() + "%"};

        this.vendas = (ArrayList<Venda>) this.genericoVen.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        float totalFLOAT = 0;
        for (Venda venda : this.vendas) {
            tabela.addRow(new Object[]{venda.getData(), venda.getLocal(),
                venda.getUsuario().getNome(), venda.getValor(), venda.getDesconto(),
                venda.getOpcaoVenda(), venda.getId()});
            totalFLOAT += venda.getValor();
            this.total.setText(totalFLOAT + "");
        }
    }

    public void carregarUsuarios() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        GenericoDAO genericoUsu = new GenericoDAO(Usuario.class, sessao);

        String sql = "select * from Usuario where nome like ? order by nome asc";
        String[] atributos = new String[]{"nome"};
        String[] valores = new String[]{"" + "%"};
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) genericoUsu.getListBySQL(sql, atributos, valores);
        sessao.close();

        for (Usuario usu : usuarios) {
            this.usuario.addItem(usu.getNome());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itens = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        remover = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        pagamento = new javax.swing.JComboBox<>();
        local = new javax.swing.JComboBox<>();
        total = new javax.swing.JLabel();
        filtrar = new javax.swing.JButton();
        datainicial = new javax.swing.JFormattedTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        dataFinal = new javax.swing.JFormattedTextField();
        usuario = new javax.swing.JComboBox<>();

        itens.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        itens.setText("Ver Itens");
        itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itensActionPerformed(evt);
            }
        });

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Local", "Usúario", "Valor", "Desconto", "Pagamento", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela1);
        if (tabela1.getColumnModel().getColumnCount() > 0) {
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(4).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(5).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        remover.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        Editar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "A vista", "Débito", "Crédito" }));
        pagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        local.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Afogados", "Carnaiba", "Flores" }));
        local.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Local", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        total.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        filtrar.setText("Filtrar");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        datainicial.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desde o dia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        datainicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        datainicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datainicialActionPerformed(evt);
            }
        });
        datainicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datainicialKeyReleased(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jRadioButton1.setText("Data");

        dataFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Até o dia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jRadioButton1))
                    .addComponent(datainicial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(itens, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRadioButton1)
                        .addGap(6, 6, 6)
                        .addComponent(datainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(filtrar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remover)
                            .addComponent(itens)
                            .addComponent(Editar))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void itensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itensActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            //TelaListarItem painel = new TelaListarItem(this, listaVenda.get(0));
        }
    }//GEN-LAST:event_itensActionPerformed
    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
    }//GEN-LAST:event_removerActionPerformed
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
    }//GEN-LAST:event_EditarActionPerformed
    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed

    }//GEN-LAST:event_filtrarActionPerformed

    private void datainicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datainicialKeyReleased
        carregarTabela();
    }//GEN-LAST:event_datainicialKeyReleased

    private void datainicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datainicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datainicialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField datainicial;
    private javax.swing.JButton filtrar;
    private javax.swing.JButton itens;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> local;
    private javax.swing.JComboBox<String> pagamento;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela1;
    private javax.swing.JLabel total;
    private javax.swing.JComboBox<String> usuario;
    // End of variables declaration//GEN-END:variables
}
