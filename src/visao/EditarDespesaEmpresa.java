/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.DespesaEmpresa;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class EditarDespesaEmpresa extends javax.swing.JPanel {

    private DespesaEmpresa despesa;
    private ListarDespesaEmpresa listarDespesa;
    private GenericoDAO<DespesaEmpresa> genericoDes;

    public EditarDespesaEmpresa(DespesaEmpresa despesa, ListarDespesaEmpresa listarDespesa) {
        initComponents();
        this.despesa = despesa;
        this.listarDespesa = listarDespesa;

        this.atualizar.setOpaque(true);
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descricao = new javax.swing.JTextField();
        valor = new javax.swing.JFormattedTextField();
        dataPagar = new javax.swing.JFormattedTextField();
        dataEmissao = new javax.swing.JFormattedTextField();
        status = new javax.swing.JComboBox<>();
        atualizar3 = new javax.swing.JButton();

        descricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        valor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        dataPagar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de pagar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        dataPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        dataEmissao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Emissao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        dataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago", "Falta Pagar" }));
        status.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        atualizar3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        atualizar3.setText("Atualizar");
        atualizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                atualizar3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atualizar3MouseEntered(evt);
            }
        });
        atualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(valor)
                            .addComponent(dataPagar)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataEmissao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(atualizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dataPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizar3)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizar3MouseExited
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);
    }//GEN-LAST:event_atualizar3MouseExited

    private void atualizar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizar3MouseEntered
        this.atualizar.setBackground(Color.red);
        this.atualizar.setForeground(Color.white);
    }//GEN-LAST:event_atualizar3MouseEntered

    private void atualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizar3ActionPerformed
        if (this.descricao.equals("") || this.valor.equals("") || this.dataEmissao.equals("") || this.dataPagar.equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            this.despesa.setDescricao(descricao.getText());
            this.despesa.setValor(Float.parseFloat(valor.getText().replace(",", ".")));
            this.despesa.setDataEmissao(dataEmissao.getText());
            this.despesa.setDataPagar(dataPagar.getText());
            this.despesa.setStatus(status.getSelectedItem() + "");

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoDes = new GenericoDAO<DespesaEmpresa>(DespesaEmpresa.class, sessao);

            this.genericoDes.update(despesa);
            sessao.close();
            listarDespesa.filtrarPorDescricao();
            JOptionPane.showMessageDialog(null, "Atualizado", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_atualizar3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton atualizar1;
    private javax.swing.JButton atualizar2;
    private javax.swing.JButton atualizar3;
    private javax.swing.JFormattedTextField dataEmissao;
    private javax.swing.JFormattedTextField dataPagar;
    private javax.swing.JTextField descricao;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JFormattedTextField valor;
    // End of variables declaration//GEN-END:variables
}
