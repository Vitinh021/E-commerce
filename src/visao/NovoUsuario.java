package visao;

import java.awt.Color;
import java.util.ArrayList;
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

        senha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrar)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        GenericoDAO<Usuario> genericoUsu = new GenericoDAO<Usuario>(Usuario.class, sessao);
        
        String sql = "select * from Usuario where nome like ? order by nome asc";
        String[] atributos = new String[]{"nome"};
        String[] valores = new String[]{"%"};
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) genericoUsu.getListBySQL(sql, atributos, valores);

        boolean existe = false;
        for (Usuario usu : usuarios) {
            if (this.nome.getText().equals(usu.getNome())) {
                JOptionPane.showMessageDialog(null, "Usuário existente", "Atenção", JOptionPane.WARNING_MESSAGE);
                nome.setText("");
                existe = true;
                break;
            }
        }

        if (existe == false) {
            if (this.nome.getText().equals("") || this.senha.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Complete todos os campos", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {
                Usuario usuario = new Usuario();
                usuario.setNome(nome.getText());
                usuario.setSenha(senha.getText());
                usuario.setPermissao(permissao.getSelectedIndex());

                genericoUsu.save(usuario);
                sessao.close();

                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Informação", JOptionPane.INFORMATION_MESSAGE);
                nome.setText("");
                senha.setText("");
                permissao.setSelectedIndex(0);
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
    private javax.swing.JTextField nome;
    private javax.swing.JComboBox<String> permissao;
    private javax.swing.JTextField senha;
    // End of variables declaration//GEN-END:variables
}
