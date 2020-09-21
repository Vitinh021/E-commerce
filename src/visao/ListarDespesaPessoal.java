/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.DespesaPessoal;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class ListarDespesaPessoal extends javax.swing.JPanel {

    /**
     * Creates new form ListarDespesaPessoal
     */
    TelaInicial telaInicial;
    private GenericoDAO<DespesaPessoal> genericoDes;
    private ArrayList<DespesaPessoal> despesas;

    public ListarDespesaPessoal(TelaInicial telaInicial) {
        initComponents();
        this.telaInicial = telaInicial;
        this.setVisible(true);
        this.setToolTipText("Listagem de despesas pessoais");
        this.filtrarPorDescricao();

        this.setBackground(Color.blue);
        this.editar.setOpaque(true);
        this.editar.setBackground(Color.white);
        this.editar.setForeground(Color.black);

        this.remover.setOpaque(true);
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);

        //tabela1.setDefaultRenderer(Object.class, new PintaTabela());
    }

    public void filtrarPorData() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoDes = new GenericoDAO(DespesaPessoal.class, sessao);

        //sql que filtra os dados da base
        String sql = "select * from DespesaPessoal where dataEmissao like ? order by dataEmissao asc";
        String[] atributos = new String[]{"dataEmissao"};
        String[] valores = new String[]{data.getText() + "%"};

        this.despesas = (ArrayList<DespesaPessoal>) this.genericoDes.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        for (DespesaPessoal despesa : despesas) {
            tabela.addRow(new Object[]{despesa.getDescricao(), despesa.getValor(),
                despesa.getDataEmissao(), despesa.getId()});
        }

    }

    public void filtrarPorDescricao() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoDes = new GenericoDAO(DespesaPessoal.class, sessao);

        //sql que filtra os dados da base
        String sql = "select * from DespesaPessoal where descricao like ? order by descricao asc";
        String[] atributos = new String[]{"descricao"};
        String[] valores = new String[]{descricao.getText() + "%"};

        this.despesas = (ArrayList<DespesaPessoal>) this.genericoDes.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        for (DespesaPessoal despesa : despesas) {
            tabela.addRow(new Object[]{despesa.getDescricao(), despesa.getValor(),
                despesa.getDataEmissao(), despesa.getId()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        data = new javax.swing.JFormattedTextField();
        remover = new javax.swing.JButton();
        descricao = new javax.swing.JTextField();

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Data Emissão", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela1);
        if (tabela1.getColumnModel().getColumnCount() > 0) {
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        editar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        editar.setText("Editar");
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarMouseEntered(evt);
            }
        });
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        data.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dataKeyReleased(evt);
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

        descricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descricaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(221, Short.MAX_VALUE)
                        .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(descricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(remover))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseExited
        this.editar.setBackground(Color.white);
        this.editar.setForeground(Color.black);
    }//GEN-LAST:event_editarMouseExited

    private void editarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseEntered
        this.editar.setBackground(Color.red);
        this.editar.setForeground(Color.white);
    }//GEN-LAST:event_editarMouseEntered

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoDes = new GenericoDAO(DespesaPessoal.class, sessao);

            int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 5));
            DespesaPessoal despesa = this.genericoDes.getEntity(id);
            sessao.close();

            JInternalFrame tela = new JInternalFrame("Atualizar Despesa pessoal");
            EditarDespesaPessoal painel = new EditarDespesaPessoal(despesa, this);
            tela.setSize(350, 400);
            tela.setClosable(true);
            tela.add(painel);
            tela.setVisible(true);
            tela.setLocation(telaInicial.getPainel().getWidth() / 2 - 150, telaInicial.getPainel().getHeight() / 2 - 150);
            this.telaInicial.getPainel().add(tela);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dataKeyReleased
        filtrarPorData();
    }//GEN-LAST:event_dataKeyReleased

    private void removerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseExited
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);
    }//GEN-LAST:event_removerMouseExited

    private void removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseEntered
        this.remover.setBackground(Color.red);
        this.remover.setForeground(Color.white);
    }//GEN-LAST:event_removerMouseEntered

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (tabela1.getSelectedRow() >= 0) {

            DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoDes = new GenericoDAO(DespesaPessoal.class, sessao);

            String sql = "delete from DespesaPessoal where id = ?";
            String[] atributos = new String[]{"id"};
            String[] valores = new String[]{"" + (tabela.getValueAt(tabela1.getSelectedRow(), 5))};

            this.genericoDes.getDeleteBySQL(sql, atributos, valores);
            sessao.close();
            JOptionPane.showMessageDialog(null, "Removido", "Informação", JOptionPane.INFORMATION_MESSAGE);
            filtrarPorDescricao();

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removerActionPerformed

    private void descricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaoKeyReleased
        filtrarPorDescricao();
    }//GEN-LAST:event_descricaoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data;
    private javax.swing.JTextField descricao;
    private javax.swing.JButton editar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
