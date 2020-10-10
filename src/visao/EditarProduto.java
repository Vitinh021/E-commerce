package visao;

import java.awt.Color;
import javax.swing.JInternalFrame;
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
    JInternalFrame frameEditarProduto;
    GenericoDAO<Produto> genericoProd;

    public EditarProduto(Produto prod, ListarProduto listarProduto, JInternalFrame frameEditarProduto) {
        initComponents();
        this.produto = prod;
        this.frameEditarProduto = frameEditarProduto;
        this.listarProduto = listarProduto;
        
        this.nome.setText(produto.getNome());
        this.codigo.setText(produto.getCodigo());
        String precoSTR = produto.getPreco()+"";
        this.preco.setText(precoSTR.replace(".", ","));
        String qtdSTR = produto.getQuantidade()+"";
        this.qtd.setText(qtdSTR.replace(".", ","));
        
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
        preco = new javax.swing.JFormattedTextField();
        qtd = new javax.swing.JFormattedTextField();
        codigo = new javax.swing.JFormattedTextField();

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

        preco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        qtd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qtd", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        qtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        codigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Codigo de barras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        codigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(codigo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(qtd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(preco, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(atualizar)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (this.nome.getText().equals("") || this.codigo.getText().equals("") || this.preco.getText().equals("") || this.qtd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (this.codigo.getText().length() > 13) {
            JOptionPane.showMessageDialog(null, "Campo 'Codigo' errado (max = 13)", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            this.produto.setCodigo(codigo.getText());
            this.produto.setNome(nome.getText());
            this.produto.setPreco(Float.parseFloat(preco.getText().replace(",", ".")));
            this.produto.setQuantidade(Float.parseFloat(qtd.getText().replace(",", ".")));

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoProd = new GenericoDAO<Produto>(Produto.class, sessao);

            this.genericoProd.update(produto);
            sessao.close();
            listarProduto.carregarProdutos();
            JOptionPane.showMessageDialog(null, "Atualizado", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.frameEditarProduto.dispose();
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
    private javax.swing.JFormattedTextField codigo;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField preco;
    private javax.swing.JFormattedTextField qtd;
    // End of variables declaration//GEN-END:variables
}
