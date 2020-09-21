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
import modelo.vo.Produto;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class EditarProduto extends javax.swing.JPanel {

    Produto produto;
    ListarProduto listarProduto;
    GenericoDAO<Produto> genericoProd;

    public EditarProduto(Produto prod, ListarProduto listarProduto) {
        initComponents();
        this.produto = prod;
        this.listarProduto = listarProduto;
        
        this.nome.setText(prod.getNome());
        this.codigo.setText(prod.getCodigo());
        this.preco.setText(prod.getPreco()+"");
        this.qtd.setValue(prod.getQuantidade());
        
        this.setBackground(Color.blue);

        this.atualizar.setOpaque(true);
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atualizar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();
        preco = new javax.swing.JFormattedTextField();
        qtd = new javax.swing.JSpinner();

        atualizar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        atualizar.setText("Atualizar");
        atualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                atualizarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                atualizarMouseEntered(evt);
            }
        });
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        codigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        preco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        qtd.setModel(new javax.swing.SpinnerNumberModel(1.0f, 1.0f, null, 1.0f));
        qtd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qtd", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizar)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (this.nome.equals("") || this.codigo.equals("") || this.preco.equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (this.codigo.getText().length() > 13) {
            JOptionPane.showMessageDialog(null, "Campo 'Codigo' errado (max = 13)", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            this.produto.setCodigo(codigo.getText());
            this.produto.setNome(nome.getText());
            this.produto.setPreco(Float.parseFloat(preco.getText().replace(",", ".")));
            this.produto.setQuantidade(Integer.parseInt(qtd.getValue() + ""));

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoProd = new GenericoDAO<Produto>(Produto.class, sessao);

            this.genericoProd.update(produto);
            sessao.close();
            listarProduto.carregartabela();
            JOptionPane.showMessageDialog(null, "Atualizado", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_atualizarActionPerformed

    private void atualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarMouseEntered
        this.atualizar.setBackground(Color.red);
        this.atualizar.setForeground(Color.white);
    }//GEN-LAST:event_atualizarMouseEntered

    private void atualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarMouseExited
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);
    }//GEN-LAST:event_atualizarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField preco;
    private javax.swing.JSpinner qtd;
    // End of variables declaration//GEN-END:variables
}
