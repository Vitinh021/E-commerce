package visao;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Usuario;
import org.hibernate.Session;

public class EditarUsuario extends javax.swing.JPanel {

    Usuario usuario;
    ListarUsuario telaListar;
    GenericoDAO<Usuario> genericoUsu;

    public EditarUsuario(Usuario usu, TelaInicial tela, ListarUsuario telaListar) {
        initComponents();
        this.usuario = usu;
        this.telaListar = telaListar;
        this.setBackground(Color.blue);
        this.nome.setText(this.usuario.getNome());

        this.senhaAtual.setEchoChar('•');
        this.senhaNova.setEchoChar('•');
        this.confirmarSenha.setEchoChar('•');

        switch (usuario.getPermissao()) {
            case Usuario.VENDEDOR:
                this.permissao.setSelectedIndex(0);
                break;
            case Usuario.ADMINISTRADOR:
                this.permissao.setSelectedIndex(1);
                break;
            default:
                this.permissao.setSelectedIndex(2);
                break;
        }

        this.senhaNova.setEnabled(false);
        this.confirmarSenha.setEnabled(false);
        this.ver1.setEnabled(false);
        this.ver2.setEnabled(false);

        this.ver0.setSize(40, 25);
        this.ver0.setOpaque(true);
        this.ver0.setBackground(Color.white);
        this.ver0.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.ver1.setSize(40, 25);
        this.ver1.setOpaque(true);
        this.ver1.setBackground(Color.white);
        this.ver1.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.ver2.setSize(40, 25);
        this.ver2.setOpaque(true);
        this.ver2.setBackground(Color.white);
        this.ver2.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.atualizar.setOpaque(true);
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ver0 = new javax.swing.JButton();
        ver1 = new javax.swing.JButton();
        ver2 = new javax.swing.JButton();
        confirmarSenha = new javax.swing.JPasswordField();
        nome = new javax.swing.JTextField();
        permissao = new javax.swing.JComboBox<>();
        atualizar = new javax.swing.JButton();
        senhaAtual = new javax.swing.JPasswordField();
        senhaNova = new javax.swing.JPasswordField();

        ver0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ver0MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ver0MouseEntered(evt);
            }
        });
        ver0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver0ActionPerformed(evt);
            }
        });

        ver1.setEnabled(false);
        ver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ver1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ver1MouseEntered(evt);
            }
        });
        ver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver1ActionPerformed(evt);
            }
        });

        ver2.setEnabled(false);
        ver2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ver2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ver2MouseEntered(evt);
            }
        });
        ver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver2ActionPerformed(evt);
            }
        });

        confirmarSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirmar Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        permissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Administrador", "Master" }));
        permissao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permissão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

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

        senhaAtual.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha Atual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        senhaAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                senhaAtualKeyReleased(evt);
            }
        });

        senhaNova.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha Nova", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(permissao, 0, 212, Short.MAX_VALUE)
                    .addComponent(confirmarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(nome)
                    .addComponent(senhaAtual)
                    .addComponent(senhaNova))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ver0, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(ver1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ver2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(ver0, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(senhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ver1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(senhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ver2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(atualizar)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (this.nome.equals("")) {
            JOptionPane.showMessageDialog(null, "Complete o campo 'Nome' ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {

            this.usuario.setNome(nome.getText());
            this.usuario.setPermissao(permissao.getSelectedIndex());

            if (this.usuario.getSenha().equals(this.senhaAtual.getPassword())) {
                if (!this.senhaNova.equals("") && !this.confirmarSenha.equals("") && this.senhaNova.equals(this.confirmarSenha)) {
                    String senhaN = new String(this.senhaNova.getPassword());
                    this.usuario.setSenha(senhaN);
                } else {
                    JOptionPane.showMessageDialog(null, "Sua senha não foi alterada", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoUsu = new GenericoDAO<Usuario>(Usuario.class, sessao);

            this.genericoUsu.update(usuario);
            sessao.close();
            JOptionPane.showMessageDialog(null, "Atualizado", "Informação", JOptionPane.INFORMATION_MESSAGE);
            telaListar.carregartabela();
        }

    }//GEN-LAST:event_atualizarActionPerformed

    private void ver0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver0ActionPerformed
        this.ver(this.senhaAtual);
    }//GEN-LAST:event_ver0ActionPerformed

    private void ver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver2ActionPerformed
        this.ver(this.senhaNova);
    }//GEN-LAST:event_ver2ActionPerformed

    private void ver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver1ActionPerformed
        this.ver(this.confirmarSenha);
    }//GEN-LAST:event_ver1ActionPerformed

    private void senhaAtualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaAtualKeyReleased
        if (this.usuario.getSenha().equals(this.senhaAtual.getPassword() + "")) {
            this.senhaNova.setEnabled(true);
            this.confirmarSenha.setEnabled(true);
            this.ver1.setEnabled(true);
            this.ver2.setEnabled(true);
        } else {
            this.senhaNova.setEnabled(false);
            this.confirmarSenha.setEnabled(false);
            this.ver1.setEnabled(false);
            this.ver2.setEnabled(false);
        }
    }//GEN-LAST:event_senhaAtualKeyReleased

    private void atualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarMouseEntered
        this.atualizar.setBackground(Color.red);
        this.atualizar.setForeground(Color.white);
    }//GEN-LAST:event_atualizarMouseEntered

    private void atualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atualizarMouseExited
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);
    }//GEN-LAST:event_atualizarMouseExited

    private void ver0MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver0MouseEntered
        this.ver0.setBackground(Color.red);
        this.ver0.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        senhaAtual.setEchoChar((char) 0);
    }//GEN-LAST:event_ver0MouseEntered

    private void ver0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver0MouseExited
        this.ver0.setBackground(Color.white);
        this.ver0.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        senhaAtual.setEchoChar('•');
    }//GEN-LAST:event_ver0MouseExited

    private void ver1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver1MouseEntered
        this.ver1.setBackground(Color.red);
        this.ver1.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        senhaNova.setEchoChar((char) 0);
    }//GEN-LAST:event_ver1MouseEntered

    private void ver1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver1MouseExited
        this.ver1.setBackground(Color.white);
        this.ver1.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        senhaNova.setEchoChar('•');
    }//GEN-LAST:event_ver1MouseExited

    private void ver2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver2MouseEntered
        this.ver2.setBackground(Color.red);
        this.ver2.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        confirmarSenha.setEchoChar((char) 0);
    }//GEN-LAST:event_ver2MouseEntered

    private void ver2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ver2MouseExited
        this.ver2.setBackground(Color.white);
        this.ver2.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        confirmarSenha.setEchoChar('•');
    }//GEN-LAST:event_ver2MouseExited

    public void ver(JPasswordField senha) {
        if (senha.getEchoChar() == 0) {
            senha.setEchoChar('•');
        } else {
            senha.setEchoChar((char) 0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JPasswordField confirmarSenha;
    private javax.swing.JTextField nome;
    private javax.swing.JComboBox<String> permissao;
    private javax.swing.JPasswordField senhaAtual;
    private javax.swing.JPasswordField senhaNova;
    private javax.swing.JButton ver0;
    private javax.swing.JButton ver1;
    private javax.swing.JButton ver2;
    // End of variables declaration//GEN-END:variables

}
