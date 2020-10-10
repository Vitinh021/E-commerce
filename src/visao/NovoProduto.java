package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Produto;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class NovoProduto extends javax.swing.JPanel {

    /**
     * Creates new form NovoProduto
     */
    public NovoProduto() {
        initComponents();

        this.setVisible(true);
        this.setBackground(Color.blue);
        System.out.println(this.qtd.getValue() + "");

        this.cadastrar.setOpaque(true);
        this.cadastrar.setBackground(Color.white);
        this.cadastrar.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        preco = new javax.swing.JFormattedTextField();
        codigo = new javax.swing.JFormattedTextField();
        cadastrar = new javax.swing.JButton();
        qtd = new javax.swing.JFormattedTextField();

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        preco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        preco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        codigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo de barras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        codigo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        cadastrar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.setFocusPainted(false);
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

        qtd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qtd", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        qtd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(preco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrar)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        GenericoDAO<Produto> genericoProd = new GenericoDAO(Produto.class, sessao);

        String sql = "select * from Produto where codigo like ?";
        String[] atributos = new String[]{"codigo"};
        String[] valores = new String[]{"%"};
        ArrayList<Produto> produtos = (ArrayList<Produto>) genericoProd.getListBySQL(sql, atributos, valores);

        boolean existe = false;
        for (Produto prod : produtos) {
            if (this.codigo.getText().equals(prod.getCodigo())) {
                JOptionPane.showMessageDialog(null, "Codigo existente", "Atenção", JOptionPane.WARNING_MESSAGE);
                codigo.setText("");
                existe = true;
                break;
            }
        }

        if (existe == false) {

            if (this.nome.getText().equals("") || this.codigo.getText().equals("") || this.preco.getText().equals("") || this.qtd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete todos os campos ", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                Produto produto = new Produto();
                produto.setNome(this.nome.getText());
                produto.setCodigo(this.codigo.getText());
                produto.setPreco(Float.parseFloat(this.preco.getText().replace(",", ".")));
                produto.setQuantidade(Float.parseFloat(this.qtd.getText().replace(",", ".")));

                genericoProd.save(produto);
                sessao.close();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);

                this.nome.setText("");
                this.codigo.setText("");
                this.preco.setText("");
                this.qtd.setText("");
            }
        } else {
            sessao.close();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JFormattedTextField codigo;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField preco;
    private javax.swing.JFormattedTextField qtd;
    // End of variables declaration//GEN-END:variables
}
