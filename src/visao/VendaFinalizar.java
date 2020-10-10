package visao;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.FluxoCaixa;
import modelo.vo.Venda;
import org.hibernate.Session;
import util.Data;

/**
 *
 * @author marcos-victor
 */
public class VendaFinalizar extends javax.swing.JPanel {

    private GenericoDAO<Venda> genericoVenda;
    private VendaProximo vendaProximo;
    JInternalFrame frameInternoFinalizar, frameInternoProximo;

    public VendaFinalizar(VendaProximo vendaProximo, JInternalFrame frameInternoFinalizar, JInternalFrame frameInternoProximo) {
        initComponents();
        this.vendaProximo = vendaProximo;
        this.frameInternoFinalizar = frameInternoFinalizar;
        this.frameInternoProximo = frameInternoProximo;

        this.data.setText(Data.getData());

        this.usuario.setText(vendaProximo.getUsuarioOBJ().getNome());
        this.subTotal.setText(vendaProximo.getTotal().getText());
        this.troco.setText("");
        this.total.setText("");
        this.dinheiro.setText("");
        this.desconto.setText("0,0");

        this.setBackground(Color.blue);

        this.usuario.setOpaque(true);
        this.usuario.setBackground(Color.white);
        this.usuario.setForeground(Color.black);

        this.data.setOpaque(true);
        this.data.setBackground(Color.white);
        this.data.setForeground(Color.black);

        this.subTotal.setOpaque(true);
        this.subTotal.setBackground(Color.white);
        this.subTotal.setForeground(Color.black);

        this.troco.setOpaque(true);
        this.troco.setBackground(Color.white);
        this.troco.setForeground(Color.black);

        this.total.setOpaque(true);
        this.total.setBackground(Color.white);
        this.total.setForeground(Color.black);

        this.finalizar.setOpaque(true);
        this.finalizar.setBackground(Color.white);
        this.finalizar.setForeground(Color.black);

        this.voltar.setOpaque(true);
        this.voltar.setBackground(Color.white);
        this.voltar.setForeground(Color.black);
    }

    private boolean validarCampos() {
        float dinheiroFLOAT = 0, descontoFLOAT = 0, subTotalFLOAT = 0, totalVendaFLOAT = 0, trocoFLOAT = 0;

        if (this.desconto.getText().equals("") || this.dinheiro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            NumberFormat nf = NumberFormat.getInstance();//formata o total
            nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2

            dinheiroFLOAT = Float.parseFloat(this.dinheiro.getText().replace(",", "."));
            descontoFLOAT = Float.parseFloat(this.desconto.getText().replace(",", "."));
            subTotalFLOAT = Float.parseFloat(this.subTotal.getText());
            totalVendaFLOAT = subTotalFLOAT - descontoFLOAT;
            trocoFLOAT = dinheiroFLOAT - totalVendaFLOAT;

            this.troco.setText(trocoFLOAT + "");
            this.total.setText(totalVendaFLOAT + "");

            if (trocoFLOAT < 0) {
                JOptionPane.showMessageDialog(null, "Valor insuficiente", "Atenção", JOptionPane.WARNING_MESSAGE);
                this.desconto.setText("0");
                this.troco.setText("");
                this.dinheiro.setText("");
                this.total.setText("");
                return false;

            } else if (descontoFLOAT > subTotalFLOAT) {
                JOptionPane.showMessageDialog(null, "Desconto exagerado", "Atenção", JOptionPane.WARNING_MESSAGE);
                this.desconto.setText("0");
                this.troco.setText("");
                this.dinheiro.setText("");
                this.total.setText("");
                return false;
            } else {
                return true;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        total = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        local = new javax.swing.JComboBox<>();
        opcaoVenda = new javax.swing.JComboBox<>();
        finalizar = new javax.swing.JButton();
        troco = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        desconto = new javax.swing.JFormattedTextField();
        dinheiro = new javax.swing.JFormattedTextField();
        data = new javax.swing.JFormattedTextField();

        total.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        subTotal.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        subTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SubTotal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14), java.awt.Color.red)); // NOI18N

        usuario.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14), java.awt.Color.red)); // NOI18N

        local.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afogados", "Carnaiba", "Flores" }));
        local.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        opcaoVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Debito", "Credito" }));
        opcaoVenda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagamento", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        finalizar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        finalizar.setText("Finalizar");
        finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizarMouseEntered(evt);
            }
        });
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        troco.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        troco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        troco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Troco", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        voltar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        voltar.setText("Voltar");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltarMouseEntered(evt);
            }
        });
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        desconto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desconto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        desconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        desconto.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N

        dinheiro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dinheiro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        dinheiro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        dinheiro.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        dinheiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dinheiroKeyReleased(evt);
            }
        });

        data.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opcaoVenda, 0, 132, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(subTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(238, 238, 238)
                                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(troco, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(local)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(troco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizar)
                    .addComponent(voltar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        if (validarCampos() == true) {
            Venda venda = this.vendaProximo.getVenda();

            //colocano dados na venda
            venda.setUsuario(this.vendaProximo.getUsuarioOBJ());
            venda.setValor(Float.parseFloat(this.total.getText().replace(",", ".")));
            venda.setDesconto(Float.parseFloat(this.desconto.getText().replace(",", ".")));
            venda.setLocal(local.getSelectedItem() + "");
            venda.setOpcaoVenda(opcaoVenda.getSelectedItem() + "");

            String[] dataFormatada = data.getText().split("/");
            String novaData = dataFormatada[2] + "/" + dataFormatada[1] + "/" + dataFormatada[0];

            venda.setData(novaData);

            //sessao venda
            Session sessao_venda = HibernateUtil.getSessionFactory().openSession();
            this.genericoVenda = new GenericoDAO<Venda>(Venda.class, sessao_venda);

            this.genericoVenda.update(venda);
            sessao_venda.close();

            //sessao fluxo caixa
            Session sessao_fluxo = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<FluxoCaixa> generico_fluxo = new GenericoDAO<FluxoCaixa>(FluxoCaixa.class, sessao_fluxo);

            FluxoCaixa fluxo = new FluxoCaixa();
            fluxo.setVenda(venda);
            fluxo.setDescricao("Venda");
            fluxo.setDataEmissao(novaData);
            fluxo.setDataVencimento("sem");
            fluxo.setDataPagamento("sem");
            fluxo.setValor(venda.getValor());
            fluxo.setTipo("Entrada");
            fluxo.setSituacao("Fechada");

            //salvando fluxo
            generico_fluxo.save(fluxo);
            sessao_fluxo.close();

            JOptionPane.showMessageDialog(null, "Venda finalizada", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.frameInternoFinalizar.dispose();
            this.frameInternoProximo.dispose();
        }
    }//GEN-LAST:event_finalizarActionPerformed

    private void finalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseEntered
        this.finalizar.setBackground(Color.red);
        this.finalizar.setForeground(Color.white);
    }//GEN-LAST:event_finalizarMouseEntered

    private void finalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseExited
        this.finalizar.setBackground(Color.white);
        this.finalizar.setForeground(Color.black);
    }//GEN-LAST:event_finalizarMouseExited

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.frameInternoFinalizar.dispose();
        this.frameInternoProximo.setVisible(true);
    }//GEN-LAST:event_voltarActionPerformed

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        this.voltar.setBackground(Color.red);
        this.voltar.setForeground(Color.white);
    }//GEN-LAST:event_voltarMouseEntered

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        this.voltar.setBackground(Color.white);
        this.voltar.setForeground(Color.black);
    }//GEN-LAST:event_voltarMouseExited

    private void dinheiroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dinheiroKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            validarCampos();
        }
    }//GEN-LAST:event_dinheiroKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data;
    private javax.swing.JFormattedTextField desconto;
    private javax.swing.JFormattedTextField dinheiro;
    private javax.swing.JButton finalizar;
    private javax.swing.JComboBox<String> local;
    private javax.swing.JComboBox<String> opcaoVenda;
    private javax.swing.JLabel subTotal;
    private javax.swing.JLabel total;
    private javax.swing.JLabel troco;
    private javax.swing.JLabel usuario;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
