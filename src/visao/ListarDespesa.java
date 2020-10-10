package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.FluxoCaixa;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class ListarDespesa extends javax.swing.JPanel {

    private ArrayList<FluxoCaixa> despesas;
    private GenericoDAO<FluxoCaixa> generico_fluxo;
    private TelaInicial telaInicial;

    public ListarDespesa(TelaInicial telaInicial) {
        initComponents();
        despesas = new ArrayList<>();
        this.telaInicial = telaInicial;
        this.carregarDespesas();
        this.setBackground(Color.blue);

        this.valorTotal.setOpaque(true);
        this.valorTotal.setBackground(Color.white);
        this.valorTotal.setForeground(Color.black);

        this.remover.setOpaque(true);
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);

        this.pagar.setOpaque(true);
        this.pagar.setBackground(Color.white);
        this.pagar.setForeground(Color.black);
    }

    public void carregarDespesas() {
        String sql_situacao;
        if (situacao.getSelectedItem().equals("Todos")) {
            sql_situacao = "";
        } else {
            sql_situacao = situacao.getSelectedItem() + "";
        }

        //sessao fluxo
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.generico_fluxo = new GenericoDAO(FluxoCaixa.class, sessao);

        String sql = "select * from FluxoCaixa where venda_id is NULL and descricao like ? and dataEmissao like ? "
                + "and dataVencimento like ? and situacao like ? order by descricao asc";
        String[] atributos = new String[]{"descricao", "dataEmissao", "dataVencimento", "situacao"};
        String[] valores = new String[]{this.descricao.getText() + "%", this.dataEmissao.getText() + "%",
            this.dataVencimento.getText() + "%", sql_situacao + "%"};

        this.despesas = (ArrayList<FluxoCaixa>) this.generico_fluxo.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel modelo_tabela = ((DefaultTableModel) tabela.getModel());

        while (modelo_tabela.getRowCount() > 0) {
            modelo_tabela.removeRow(0);
        }
        float totalFLOAT = 0;
        for (FluxoCaixa fluxo : this.despesas) {
            modelo_tabela.addRow(new Object[]{fluxo.getDescricao(), fluxo.getValor(),
                fluxo.getSituacao(), fluxo.getDataEmissao(), fluxo.getDataVencimento(),
                fluxo.getDataPagamento(), fluxo.getId()});

            totalFLOAT += fluxo.getValor();
            this.valorTotal.setText(totalFLOAT + "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descricao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        situacao = new javax.swing.JComboBox<>();
        dataEmissao = new javax.swing.JTextField();
        dataVencimento = new javax.swing.JTextField();
        pagar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        valorTotal = new javax.swing.JLabel();

        descricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descricaoKeyReleased(evt);
            }
        });

        tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Situação", "Data Emissão", "Data Vencimento", "Data Pagamento", "Id_d"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(6).setPreferredWidth(40);
            tabela.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Aberta", "Fechada", "Atrasada" }));
        situacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Situação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                situacaoActionPerformed(evt);
            }
        });

        dataEmissao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data emissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        dataEmissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataEmissaoKeyReleased(evt);
            }
        });

        dataVencimento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Vencimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        dataVencimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataVencimentoKeyReleased(evt);
            }
        });

        pagar.setText("Pagar");
        pagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagarMouseEntered(evt);
            }
        });
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

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

        valorTotal.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        valorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remover)
                    .addComponent(pagar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaoKeyReleased
        this.carregarDespesas();
    }//GEN-LAST:event_descricaoKeyReleased

    private void situacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_situacaoActionPerformed
        this.carregarDespesas();
    }//GEN-LAST:event_situacaoActionPerformed

    private void dataEmissaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataEmissaoKeyReleased
        this.carregarDespesas();
    }//GEN-LAST:event_dataEmissaoKeyReleased

    private void dataVencimentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataVencimentoKeyReleased
        this.carregarDespesas();
    }//GEN-LAST:event_dataVencimentoKeyReleased

    private void pagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarMouseEntered
        this.pagar.setBackground(Color.red);
        this.pagar.setForeground(Color.white);
    }//GEN-LAST:event_pagarMouseEntered

    private void pagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarMouseExited
        this.pagar.setBackground(Color.white);
        this.pagar.setForeground(Color.black);
    }//GEN-LAST:event_pagarMouseExited

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (tabela.getSelectedRow() >= 0) {
            //sessao fluxo
            Session sessao_fluxo = HibernateUtil.getSessionFactory().openSession();
            this.generico_fluxo = new GenericoDAO(FluxoCaixa.class, sessao_fluxo);

            //remover fluxo
            String sql_fluxo_del = "delete from FluxoCaixa where id = ?";
            String[] atributos_fluxo_del = new String[]{"id"};
            String[] valores_fluxo_del = new String[]{tabela.getValueAt(tabela.getSelectedRow(), 6) + ""};
            this.generico_fluxo.getDeleteBySQL(sql_fluxo_del, atributos_fluxo_del, valores_fluxo_del);
            sessao_fluxo.close();
            this.carregarDespesas();
            JOptionPane.showMessageDialog(null, "Removido", "Informação", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removerActionPerformed

    private void removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseEntered
        this.remover.setBackground(Color.red);
        this.remover.setForeground(Color.white);
    }//GEN-LAST:event_removerMouseEntered

    private void removerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseExited
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);
    }//GEN-LAST:event_removerMouseExited

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        if (tabela.getSelectedRow() >= 0) {
            //sessao fluxo
            Session sessao_fluxo = HibernateUtil.getSessionFactory().openSession();
            this.generico_fluxo = new GenericoDAO(FluxoCaixa.class, sessao_fluxo);

            //pegar fluxo            
            int id = Integer.parseInt("" + tabela.getValueAt(tabela.getSelectedRow(), 6));
            FluxoCaixa fluxo = this.generico_fluxo.getEntity(id);
            sessao_fluxo.close();

            if (fluxo.getSituacao().equals("Aberta")) {
                JInternalFrame tela = new JInternalFrame("Pagar Despesa");
                PagarDespesa painel = new PagarDespesa(fluxo, this, tela);
                tela.setSize(300, 150);
                tela.setClosable(false);
                tela.add(painel);
                tela.setVisible(true);
                tela.setLocation(telaInicial.getPainel().getWidth() / 2 - 150, telaInicial.getPainel().getHeight() / 2 - 75);
                this.telaInicial.getPainel().add(tela);
                tela.moveToFront();
            } else {
                JOptionPane.showMessageDialog(null, "Despesa fechada", "Atenção", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_pagarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dataEmissao;
    private javax.swing.JTextField dataVencimento;
    private javax.swing.JTextField descricao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pagar;
    private javax.swing.JButton remover;
    private javax.swing.JComboBox<String> situacao;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel valorTotal;
    // End of variables declaration//GEN-END:variables
}
