package visao;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Usuario;
import org.hibernate.Session;

public class EditarUsuario extends javax.swing.JPanel {

    Usuario usuario;
    ListarUsuario telaListar;
    JInternalFrame frameEditarUsuario;
    GenericoDAO<Usuario> genericoUsu;

    public EditarUsuario(Usuario usu, ListarUsuario telaListar, JInternalFrame frameEditarUsuario) {
        initComponents();
        this.usuario = usu;
        this.telaListar = telaListar;
        this.frameEditarUsuario = frameEditarUsuario;
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
        this.verNovaSenha.setEnabled(false);
        this.verConfirmarSenha.setEnabled(false);

        this.verSenhaAtual.setSize(40, 25);
        this.verSenhaAtual.setOpaque(true);
        this.verSenhaAtual.setBackground(Color.white);
        this.verSenhaAtual.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.verNovaSenha.setSize(40, 25);
        this.verNovaSenha.setOpaque(true);
        this.verNovaSenha.setBackground(Color.white);
        this.verNovaSenha.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.verConfirmarSenha.setSize(40, 25);
        this.verConfirmarSenha.setOpaque(true);
        this.verConfirmarSenha.setBackground(Color.white);
        this.verConfirmarSenha.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.atualizar.setOpaque(true);
        this.atualizar.setBackground(Color.white);
        this.atualizar.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verSenhaAtual = new javax.swing.JButton();
        verNovaSenha = new javax.swing.JButton();
        verConfirmarSenha = new javax.swing.JButton();
        confirmarSenha = new javax.swing.JPasswordField();
        nome = new javax.swing.JTextField();
        permissao = new javax.swing.JComboBox<>();
        atualizar = new javax.swing.JButton();
        senhaAtual = new javax.swing.JPasswordField();
        senhaNova = new javax.swing.JPasswordField();

        verSenhaAtual.setFocusPainted(false);
        verSenhaAtual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verSenhaAtualMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verSenhaAtualMouseEntered(evt);
            }
        });
        verSenhaAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verSenhaAtualActionPerformed(evt);
            }
        });

        verNovaSenha.setFocusPainted(false);
        verNovaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verNovaSenhaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verNovaSenhaMouseEntered(evt);
            }
        });
        verNovaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verNovaSenhaActionPerformed(evt);
            }
        });

        verConfirmarSenha.setFocusPainted(false);
        verConfirmarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verConfirmarSenhaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verConfirmarSenhaMouseEntered(evt);
            }
        });
        verConfirmarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verConfirmarSenhaActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(senhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(senhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senhaNova, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verNovaSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verConfirmarSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizar)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (this.nome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete o campo 'Nome' ", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            this.usuario.setNome(nome.getText());
            this.usuario.setPermissao(permissao.getSelectedIndex());

            if (this.senhaNova.isEnabled()) {
                String senhaNovaSTR = new String(this.senhaNova.getPassword());
                String confirmarSenhaSTR = new String(this.confirmarSenha.getPassword());

                if (senhaNovaSTR.equals("") || confirmarSenhaSTR.equals("") || !senhaNovaSTR.equals(confirmarSenhaSTR)) {
                    JOptionPane.showMessageDialog(null, "Sua senha não foi alterada", "Atenção", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.usuario.setSenha(senhaNovaSTR);
                    JOptionPane.showMessageDialog(null, "Sua senha foi alterada", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sua senha não foi alterada", "Atenção", JOptionPane.WARNING_MESSAGE);
            }

            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoUsu = new GenericoDAO<Usuario>(Usuario.class, sessao);

            this.genericoUsu.update(usuario);
            sessao.close();
            JOptionPane.showMessageDialog(null, "Atualizado", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.telaListar.carregarUsuarios();
            this.frameEditarUsuario.dispose();

        }

    }//GEN-LAST:event_atualizarActionPerformed

    private void verSenhaAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verSenhaAtualActionPerformed
        this.ver(this.senhaAtual);
    }//GEN-LAST:event_verSenhaAtualActionPerformed

    private void verConfirmarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verConfirmarSenhaActionPerformed
        this.ver(this.senhaNova);
    }//GEN-LAST:event_verConfirmarSenhaActionPerformed

    private void verNovaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verNovaSenhaActionPerformed
        this.ver(this.confirmarSenha);
    }//GEN-LAST:event_verNovaSenhaActionPerformed

    private void senhaAtualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaAtualKeyReleased
        String senhaa = new String(this.senhaAtual.getPassword());
        if (this.usuario.getSenha().equals(senhaa)) {
            this.senhaNova.setEnabled(true);
            this.confirmarSenha.setEnabled(true);
            this.verNovaSenha.setEnabled(true);
            this.verConfirmarSenha.setEnabled(true);
        } else {
            this.senhaNova.setText("");
            this.confirmarSenha.setText("");
            this.senhaNova.setEnabled(false);
            this.confirmarSenha.setEnabled(false);
            this.verNovaSenha.setEnabled(false);
            this.verConfirmarSenha.setEnabled(false);
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

    private void verSenhaAtualMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verSenhaAtualMouseEntered
        this.verSenhaAtual.setBackground(Color.red);
        this.verSenhaAtual.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        senhaAtual.setEchoChar((char) 0);
    }//GEN-LAST:event_verSenhaAtualMouseEntered

    private void verSenhaAtualMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verSenhaAtualMouseExited
        this.verSenhaAtual.setBackground(Color.white);
        this.verSenhaAtual.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        senhaAtual.setEchoChar('•');
    }//GEN-LAST:event_verSenhaAtualMouseExited

    private void verNovaSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verNovaSenhaMouseEntered
        this.verNovaSenha.setBackground(Color.red);
        this.verNovaSenha.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        senhaNova.setEchoChar((char) 0);
    }//GEN-LAST:event_verNovaSenhaMouseEntered

    private void verNovaSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verNovaSenhaMouseExited
        this.verNovaSenha.setBackground(Color.white);
        this.verNovaSenha.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        senhaNova.setEchoChar('•');
    }//GEN-LAST:event_verNovaSenhaMouseExited

    private void verConfirmarSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verConfirmarSenhaMouseEntered
        this.verConfirmarSenha.setBackground(Color.red);
        this.verConfirmarSenha.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        confirmarSenha.setEchoChar((char) 0);
    }//GEN-LAST:event_verConfirmarSenhaMouseEntered

    private void verConfirmarSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verConfirmarSenhaMouseExited
        this.verConfirmarSenha.setBackground(Color.white);
        this.verConfirmarSenha.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        confirmarSenha.setEchoChar('•');
    }//GEN-LAST:event_verConfirmarSenhaMouseExited

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
    private javax.swing.JButton verConfirmarSenha;
    private javax.swing.JButton verNovaSenha;
    private javax.swing.JButton verSenhaAtual;
    // End of variables declaration//GEN-END:variables

}
