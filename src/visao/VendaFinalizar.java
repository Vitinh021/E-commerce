/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.ItemVenda;
import modelo.vo.Usuario;
import modelo.vo.Venda;
import org.hibernate.Session;
import util.DataHora;

/**
 *
 * @author marcos-victor
 */
public class VendaFinalizar extends javax.swing.JPanel {

    private GenericoDAO<Venda> genericoVenda;
    private VendaProximo vendaProximo;
    private Usuario usuarioOBJ;
    JInternalFrame frameInternoFinalizar, frameInternoProximo;

    public VendaFinalizar(VendaProximo vendaProximo, Usuario usu, JInternalFrame frameInternoFinalizar, JInternalFrame frameInternoProximo) throws InterruptedException {
        initComponents();
        this.vendaProximo = vendaProximo;
        this.usuarioOBJ = usu;
        this.frameInternoFinalizar = frameInternoFinalizar;
        this.frameInternoProximo = frameInternoProximo;

        this.data.setText(DataHora.getData());

        this.usuario.setText(usu.getNome());
        this.subTotal.setText(vendaProximo.getTotal().getText());
        this.troco.setText("");
        this.total.setText("");
        this.valor.setText("");
        this.desconto.setText("0,00");

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

        if (this.desconto.getText().equals("") || this.valor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            NumberFormat nf = NumberFormat.getInstance();//formata o total
            nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2

            dinheiroFLOAT = Float.parseFloat(this.valor.getText().replace(",", "."));
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
                this.valor.setText("");
                this.total.setText("");
                return false;

            } else if (descontoFLOAT > subTotalFLOAT) {
                JOptionPane.showMessageDialog(null, "Desconto exagerado", "Atenção", JOptionPane.WARNING_MESSAGE);
                this.desconto.setText("0");
                this.troco.setText("");
                this.valor.setText("");
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
        valor = new javax.swing.JFormattedTextField();
        data = new javax.swing.JFormattedTextField();

        total.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        subTotal.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        subTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SubTotal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        usuario.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        local.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afogados", "Carnaiba", "Flores" }));
        local.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loja", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        opcaoVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Débito", "Crédito" }));
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
        troco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Troco", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

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

        valor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        valor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valor.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valorKeyReleased(evt);
            }
        });

        data.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(troco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(local, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(opcaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(valor))))
                .addGap(12, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(opcaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(data, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(troco, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizar)
                    .addComponent(voltar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        if (validarCampos()) {
            Venda venda = new Venda();

            //colocano dados na venda
            venda.setUsuario(this.usuarioOBJ);
            venda.setValor(Float.parseFloat(this.total.getText().replace(",", ".")));
            venda.setDesconto(Float.parseFloat(this.desconto.getText().replace(",", ".")));
            venda.setLocal(local.getItemAt(0));
            venda.setOpcaoVenda(opcaoVenda.getItemAt(0));
            venda.setData(data.getText());

            //salvando a venda
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoVenda = new GenericoDAO<Venda>(Venda.class, sessao);
            this.genericoVenda.save(venda);
            sessao.close();

            //sessão de itens
            Session sessaoItem = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<ItemVenda> genericoItem = new GenericoDAO<ItemVenda>(ItemVenda.class, sessaoItem);

            //salvando itens na venda e no BD
            for (ItemVenda item : vendaProximo.getItens()) {
                item.setVenda(venda);
                genericoItem.save(item);
            }
            sessaoItem.close();

            JOptionPane.showMessageDialog(null, "Finalizada", "Informação", JOptionPane.INFORMATION_MESSAGE);
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

    private void valorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            validarCampos();
        }
    }//GEN-LAST:event_valorKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data;
    private javax.swing.JFormattedTextField desconto;
    private javax.swing.JButton finalizar;
    private javax.swing.JComboBox<String> local;
    private javax.swing.JComboBox<String> opcaoVenda;
    private javax.swing.JLabel subTotal;
    private javax.swing.JLabel total;
    private javax.swing.JLabel troco;
    private javax.swing.JLabel usuario;
    private javax.swing.JFormattedTextField valor;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
