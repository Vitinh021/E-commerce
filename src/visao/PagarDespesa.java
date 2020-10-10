package visao;

import java.awt.Color;
import javax.swing.JInternalFrame;
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
public class PagarDespesa extends javax.swing.JPanel {

    private FluxoCaixa fluxo;
    private ListarDespesa listarDespesa;
    private JInternalFrame framePagar;

    public PagarDespesa(FluxoCaixa fluxo, ListarDespesa listarDespesa, JInternalFrame framePagar) {
        initComponents();

        this.fluxo = fluxo;
        this.listarDespesa = listarDespesa;
        this.framePagar = framePagar;
        this.dataPagamento.setText(Data.getData());

        this.setBackground(Color.blue);
        this.pagar.setOpaque(true);
        this.pagar.setBackground(Color.white);
        this.pagar.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPagamento = new javax.swing.JFormattedTextField();
        pagar = new javax.swing.JButton();

        dataPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        dataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pagar)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarMouseExited
        this.pagar.setBackground(Color.white);
        this.pagar.setForeground(Color.black);
    }//GEN-LAST:event_pagarMouseExited

    private void pagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarMouseEntered
        this.pagar.setBackground(Color.red);
        this.pagar.setForeground(Color.white);
    }//GEN-LAST:event_pagarMouseEntered

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        if (this.dataPagamento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete o campo corretamente", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            String[] dataFormatada = dataPagamento.getText().split("/");
            String novaData = dataFormatada[2] + "/" + dataFormatada[1] + "/" + dataFormatada[0];
            this.fluxo.setDataPagamento(novaData);
            this.fluxo.setSituacao("Fechada");

            //sessao fluxo
            Session sessao_fluxo = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<FluxoCaixa> generico_fluxo = new GenericoDAO(FluxoCaixa.class, sessao_fluxo);

            generico_fluxo.update(fluxo);
            sessao_fluxo.close();
            JOptionPane.showMessageDialog(null, "Atualizado", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.listarDespesa.carregarDespesas();
            this.framePagar.dispose();
        }
    }//GEN-LAST:event_pagarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataPagamento;
    private javax.swing.JButton pagar;
    // End of variables declaration//GEN-END:variables
}
