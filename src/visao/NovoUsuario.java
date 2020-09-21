package visao;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Usuario;
import org.hibernate.Session;

public class NovoUsuario extends javax.swing.JPanel {

    public NovoUsuario() {
        initComponents();
        this.setVisible(true);
        this.setBackground(Color.blue);
        
        this.cadastrar.setOpaque(true);
        this.cadastrar.setBackground(Color.white);
        this.cadastrar.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        permissao = new javax.swing.JComboBox<>();
        cadastrar = new javax.swing.JButton();
        senha = new javax.swing.JTextField();

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        permissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Administrador", "Master" }));
        permissao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

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

        senha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senha)
                            .addComponent(permissao, 0, 220, Short.MAX_VALUE)
                            .addComponent(nome)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(cadastrar)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        if (this.nome.getText().equals("") || this.senha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Usuario usuario = new Usuario();
            usuario.setNome(nome.getText());
            usuario.setSenha(senha.getText());
            usuario.setPermissao(permissao.getSelectedIndex());

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<Usuario> genericoUsu = new GenericoDAO<Usuario>(Usuario.class, sessao);
            genericoUsu.save(usuario);
            sessao.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
            nome.setText("");
            senha.setText("");
            permissao.setSelectedIndex(0);
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
    private javax.swing.JTextField nome;
    private javax.swing.JComboBox<String> permissao;
    private javax.swing.JTextField senha;
    // End of variables declaration//GEN-END:variables
}
