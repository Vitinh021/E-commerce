package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.FluxoCaixa;
import modelo.vo.ItemVenda;
import modelo.vo.Usuario;
import modelo.vo.Venda;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class ListarVenda extends javax.swing.JPanel {

    TelaInicial telaInicial;
    GenericoDAO<Venda> genericoVen;
    ArrayList<Venda> vendas;
    ArrayList<Usuario> usuarios;

    public ListarVenda(TelaInicial telaInicial) {
        initComponents();
        this.telaInicial = telaInicial;
        this.carregarVendas();
        this.carregarUsuarios();

        this.setBackground(Color.blue);
        this.remover.setOpaque(true);
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);

        this.listarItens.setOpaque(true);
        this.listarItens.setBackground(Color.white);
        this.listarItens.setForeground(Color.black);

        this.valorTotal.setOpaque(true);
        this.valorTotal.setBackground(Color.white);
        this.valorTotal.setForeground(Color.black);

        this.setVisible(true);
    }

    public void carregarVendas() {
        String sql_Pagamento, sql_Local, sql_usuario;

        if (pagamento.getSelectedItem().equals("Todos")) {
            sql_Pagamento = "";
        } else {
            sql_Pagamento = pagamento.getSelectedItem() + "";
        }

        if (local.getSelectedItem().equals("Todos")) {
            sql_Local = "";
        } else {
            sql_Local = local.getSelectedItem() + "";
        }

        if (usuario.getSelectedItem().equals("Todos")) {
            sql_usuario = "";
        } else {
            sql_usuario = "";
            for (Usuario usu : this.usuarios) {
                if (usu.getNome().equals(usuario.getSelectedItem())) {
                    sql_usuario = usu.getId() + "";
                    break;
                }
            }
        }
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoVen = new GenericoDAO(Venda.class, sessao);

        String sql = "select * from Venda where data like ? and opcaoVenda like ? "
                + "and local like ? and usuario_id like ? order by data asc";
        String[] atributos = new String[]{"data", "opcaoVenda", "local", "usuario_id"};
        String[] valores = new String[]{this.data.getText() + "%", sql_Pagamento + "%",
            sql_Local + "%", sql_usuario + "%"};

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
            this.valorTotal.setText(totalFLOAT + "");
        }
    }

    public void carregarUsuarios() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        GenericoDAO genericoUsu = new GenericoDAO(Usuario.class, sessao);

        String sql = "select * from Usuario where nome like ? order by nome asc";
        String[] atributos = new String[]{"nome"};
        String[] valores = new String[]{"" + "%"};
        this.usuarios = (ArrayList<Usuario>) genericoUsu.getListBySQL(sql, atributos, valores);
        sessao.close();

        for (Usuario usu : this.usuarios) {
            this.usuario.addItem(usu.getNome());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listarItens = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        remover = new javax.swing.JButton();
        pagamento = new javax.swing.JComboBox<>();
        local = new javax.swing.JComboBox<>();
        valorTotal = new javax.swing.JLabel();
        usuario = new javax.swing.JComboBox<>();
        data = new javax.swing.JTextField();

        listarItens.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        listarItens.setText("Ver Itens");
        listarItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listarItensMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listarItensMouseEntered(evt);
            }
        });
        listarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarItensActionPerformed(evt);
            }
        });

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Local", "Usúario", "Valor", "Desconto", "Pagamento", "Id_v"
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
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(25);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(4).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(5).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(6).setPreferredWidth(40);
            tabela1.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        remover.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        remover.setText("Remover");
        remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removerMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removerMouseEntered(evt);
            }
        });
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        pagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Dinheiro", "Debito", "Credito" }));
        pagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoActionPerformed(evt);
            }
        });

        local.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Afogados", "Carnaiba", "Flores" }));
        local.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Local", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localActionPerformed(evt);
            }
        });

        valorTotal.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        valorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));
        usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        data.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(listarItens, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remover)
                    .addComponent(listarItens))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarItensActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            //sessao venda
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoVen = new GenericoDAO(Venda.class, sessao);
            int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 6));

            //pegando a venda
            Venda venda = this.genericoVen.getEntity(id);
            sessao.close();

            JInternalFrame tela = new JInternalFrame("Itens da venda");
            ListarItens painel = new ListarItens(venda, this, tela);
            tela.setSize(600, 340);
            tela.setVisible(true);
            tela.add(painel);
            tela.setClosable(true);
            tela.setLocation(telaInicial.getPainel().getWidth() / 2 - 300, telaInicial.getPainel().getHeight() / 2 - 170);
            this.telaInicial.getPainel().add(tela);
            tela.moveToFront();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_listarItensActionPerformed
    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (tabela1.getSelectedRow() >= 0) {

            DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

            //sessao fluxo caixa
            Session sessao_fluxo = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<FluxoCaixa> generico_fluxo = new GenericoDAO<FluxoCaixa>(FluxoCaixa.class, sessao_fluxo);

            //sessao item
            Session sessao_Item = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO generico_Item = new GenericoDAO(ItemVenda.class, sessao_Item);

            //sessao venda
            Session sessao_Venda = HibernateUtil.getSessionFactory().openSession();
            this.genericoVen = new GenericoDAO(Venda.class, sessao_Venda);
            
            //apagando venda do fluxo
            String sql_venda = "delete from FluxoCaixa where venda_id = ?";
            String[] atributos_venda = new String[]{"venda_id"};
            String[] valores_venda = new String[]{"" + (tabela.getValueAt(tabela1.getSelectedRow(), 6))};
            generico_fluxo.getDeleteBySQL(sql_venda, atributos_venda, valores_venda);

            //apagando itens da venda
            String sql_Item = "delete from ItemVenda where venda_id = ?";
            String[] atributos_Item = new String[]{"venda_id"};
            String[] valores_Item = new String[]{"" + (tabela.getValueAt(tabela1.getSelectedRow(), 6))};
            generico_Item.getDeleteBySQL(sql_Item, atributos_Item, valores_Item);

            //apagando venda
            String sql_Venda = "delete from Venda where id = ?";
            String[] atributos_Venda = new String[]{"id"};
            String[] valores_Venda = new String[]{"" + (tabela.getValueAt(tabela1.getSelectedRow(), 6))};
            genericoVen.getDeleteBySQL(sql_Venda, atributos_Venda, valores_Venda);

            sessao_fluxo.close();
            sessao_Item.close();
            sessao_Venda.close();
            JOptionPane.showMessageDialog(null, "Removido", "Informação", JOptionPane.INFORMATION_MESSAGE);
            carregarVendas();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_removerActionPerformed

    private void dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataKeyReleased
        carregarVendas();
    }//GEN-LAST:event_dataKeyReleased

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        carregarVendas();
    }//GEN-LAST:event_usuarioActionPerformed

    private void localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localActionPerformed
        carregarVendas();
    }//GEN-LAST:event_localActionPerformed

    private void pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoActionPerformed
        carregarVendas();
    }//GEN-LAST:event_pagamentoActionPerformed

    private void removerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseExited
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);
    }//GEN-LAST:event_removerMouseExited

    private void removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseEntered
        this.remover.setBackground(Color.red);
        this.remover.setForeground(Color.white);
    }//GEN-LAST:event_removerMouseEntered

    private void listarItensMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarItensMouseExited
        this.listarItens.setBackground(Color.white);
        this.listarItens.setForeground(Color.black);
    }//GEN-LAST:event_listarItensMouseExited

    private void listarItensMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listarItensMouseEntered
        this.listarItens.setBackground(Color.red);
        this.listarItens.setForeground(Color.white);
    }//GEN-LAST:event_listarItensMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField data;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton listarItens;
    private javax.swing.JComboBox<String> local;
    private javax.swing.JComboBox<String> pagamento;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela1;
    private javax.swing.JComboBox<String> usuario;
    private javax.swing.JLabel valorTotal;
    // End of variables declaration//GEN-END:variables
}
