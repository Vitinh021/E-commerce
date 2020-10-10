package visao;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.FluxoCaixa;
import org.hibernate.Session;
import util.Data;

/**
 *
 * @author marcos-victor
 */
public class NovaDespesa extends javax.swing.JPanel {

    public NovaDespesa() {
        initComponents();
        this.setVisible(true);
        this.setBackground(Color.blue);

        this.cadastrar.setOpaque(true);
        this.cadastrar.setBackground(Color.white);
        this.cadastrar.setForeground(Color.black);

        this.dataVencimento.setEnabled(false);

        this.dataEmissao.setText(Data.getData());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descricao = new javax.swing.JTextField();
        valor = new javax.swing.JFormattedTextField();
        dataVencimento = new javax.swing.JFormattedTextField();
        dataEmissao = new javax.swing.JFormattedTextField();
        cadastrar = new javax.swing.JButton();
        tipoDespesa = new javax.swing.JComboBox<>();

        descricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        valor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        dataVencimento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de vencimento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        dataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        dataEmissao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data de Emissao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        dataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        cadastrar.setText("Cadastrar");
        cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cadastrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cadastrarMouseEntered(evt);
            }
        });
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        tipoDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoal", "Empresarial" }));
        tipoDespesa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Despesa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        tipoDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDespesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        if (this.descricao.getText().equals("") || this.valor.getText().equals("") || this.dataEmissao.getText().equals("") || (this.tipoDespesa.getSelectedItem().equals("Empresarial") && dataVencimento.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            FluxoCaixa fluxo = new FluxoCaixa();
            fluxo.setDescricao(descricao.getText());
            fluxo.setValor(Float.parseFloat(valor.getText().replace(",", ".")));

            String[] dataFormatadaEmissao = dataEmissao.getText().split("/");
            String novaDataEmissao = dataFormatadaEmissao[2] + "/" + dataFormatadaEmissao[1] + "/" + dataFormatadaEmissao[0];
            
            fluxo.setDataEmissao(novaDataEmissao);

            if (tipoDespesa.getSelectedItem().equals("Empresarial")) {
                String[] dataFormatadaPagar = dataVencimento.getText().split("/");
                String novaDataVencimento = dataFormatadaPagar[2] + "/" + dataFormatadaPagar[1] + "/" + dataFormatadaPagar[0];
                fluxo.setDataVencimento(novaDataVencimento);
                fluxo.setSituacao("Aberta");
            } else {
                fluxo.setDataVencimento("Sem");
                fluxo.setDataPagamento("Sem");
                fluxo.setSituacao("Fechada");
            }

            fluxo.setTipo("Saida");

            //sessao fluxo
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<FluxoCaixa> generico_fluxo = new GenericoDAO<FluxoCaixa>(FluxoCaixa.class, sessao);
            generico_fluxo.save(fluxo);
            sessao.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.descricao.setText("");
            this.valor.setText("");
            this.dataEmissao.setText(Data.getData());
            this.dataVencimento.setText("");
        }
    }//GEN-LAST:event_cadastrarActionPerformed

    private void cadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarMouseEntered
        this.cadastrar.setBackground(Color.red);
        this.cadastrar.setForeground(Color.white);
    }//GEN-LAST:event_cadastrarMouseEntered

    private void cadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarMouseExited
        this.cadastrar.setBackground(Color.white);
        this.cadastrar.setForeground(Color.black);
    }//GEN-LAST:event_cadastrarMouseExited

    private void tipoDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDespesaActionPerformed
        if (tipoDespesa.getSelectedItem().equals("Empresarial")) {
            this.dataVencimento.setEnabled(true);
        } else {
            this.dataVencimento.setEnabled(false);
            this.dataVencimento.setText("");
        }
    }//GEN-LAST:event_tipoDespesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JFormattedTextField dataEmissao;
    private javax.swing.JFormattedTextField dataVencimento;
    private javax.swing.JTextField descricao;
    private javax.swing.JComboBox<String> tipoDespesa;
    private javax.swing.JFormattedTextField valor;
    // End of variables declaration//GEN-END:variables
}
