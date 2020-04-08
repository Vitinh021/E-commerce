package visao;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import modelo.dao.GenericoDAO;
import modelo.vo.Usuario;

public class TelaEditarUsuario extends javax.swing.JPanel {

    Usuario usuario;
    TelaInicial telainicial;
    TelaListarUsuario tela;
    GenericoDAO genericoDAO;

    public TelaEditarUsuario(Usuario usu, TelaInicial tela, TelaListarUsuario telaa, GenericoDAO generico) {
        initComponents();
        this.telainicial = tela;
        this.usuario = usu;
        this.tela = telaa;
        this.genericoDAO = generico;
        this.nome.setText(this.usuario.getNome());
        this.email.setText(this.usuario.getEmail());
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        permissao = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        labelNS = new javax.swing.JLabel();
        labelCS = new javax.swing.JLabel();
        senhaAtual = new javax.swing.JPasswordField();
        senhaNova = new javax.swing.JPasswordField();
        confirmarSenha = new javax.swing.JPasswordField();
        ver1 = new javax.swing.JButton();
        ver2 = new javax.swing.JButton();
        ver0 = new javax.swing.JButton();

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));

        jLabel1.setText("Nome");

        jLabel2.setText("E-mail");

        jLabel4.setText("Permissao");

        permissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Administrador", "Master" }));

        jLabel3.setText("Senha atual");

        labelNS.setText("Nova senha");
        labelNS.setEnabled(false);

        labelCS.setText("Confirmar senha");
        labelCS.setEnabled(false);

        senhaAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                senhaAtualKeyReleased(evt);
            }
        });

        senhaNova.setEnabled(false);

        confirmarSenha.setEnabled(false);

        ver1.setText("ver");
        ver1.setEnabled(false);
        ver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver1ActionPerformed(evt);
            }
        });

        ver2.setText("ver");
        ver2.setEnabled(false);
        ver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver2ActionPerformed(evt);
            }
        });

        ver0.setText("ver");
        ver0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email)
                                            .addComponent(senhaAtual)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(senhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ver1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(ver0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCS)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ver2)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ver0)
                    .addComponent(senhaAtual))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ver1)
                    .addComponent(labelNS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCS, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ver2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(atualizar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizar))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        this.usuario.setNome(nome.getText());
        this.usuario.setEmail(email.getText());
        this.usuario.setPermissao(permissao.getSelectedIndex());

        String senhaA = new String(this.senhaAtual.getPassword());
        boolean erro = false;

        if (this.senhaNova.isEnabled()) {
            String senhaN = new String(this.senhaNova.getPassword());
            String senhaC = new String(this.confirmarSenha.getPassword());

            if (senhaN.equals(senhaC) && !"".equals(senhaN)) {
                this.usuario.setSenha(senhaC);
            } else if ("".equals(senhaN) && "".equals(senhaC)) {
                this.usuario.setSenha(this.usuario.getSenha());
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os campos de senhas corretamente!");
                erro = true;
            }
        } else {
            this.usuario.setSenha(this.usuario.getSenha());
        }

        try {
            if (erro == false) {
                this.genericoDAO.alterarObj(this.usuario);
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                tela.carregartabela();
            }

        } catch (Exception ex) {
            System.err.println("erro ao salvar:" + ex);
        }
    }//GEN-LAST:event_atualizarActionPerformed

    public void ver(JPasswordField senha) {
        if (senha.getEchoChar() == 0) {
            senha.setEchoChar('•');
        } else {
            senha.setEchoChar((char) 0);
        }
    }

    private void ver0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver0ActionPerformed
        this.ver(this.senhaAtual);
    }//GEN-LAST:event_ver0ActionPerformed

    private void ver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver1ActionPerformed
        this.ver(this.senhaNova);
    }//GEN-LAST:event_ver1ActionPerformed

    private void ver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver2ActionPerformed
        this.ver(this.confirmarSenha);
    }//GEN-LAST:event_ver2ActionPerformed

    private void senhaAtualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaAtualKeyReleased
        String senhaAtualUsuario = new String(this.senhaAtual.getPassword());
        if (this.usuario.getSenha().equals(senhaAtualUsuario)) {
            this.labelNS.setEnabled(true);
            this.labelCS.setEnabled(true);
            this.senhaNova.setEnabled(true);
            this.confirmarSenha.setEnabled(true);
            this.ver1.setEnabled(true);
            this.ver2.setEnabled(true);
        } else {
            this.labelNS.setEnabled(false);
            this.labelCS.setEnabled(false);
            this.senhaNova.setEnabled(false);
            this.confirmarSenha.setEnabled(false);
            this.ver1.setEnabled(false);
            this.ver2.setEnabled(false);
        }
    }//GEN-LAST:event_senhaAtualKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JPasswordField confirmarSenha;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCS;
    private javax.swing.JLabel labelNS;
    private javax.swing.JTextField nome;
    private javax.swing.JComboBox<String> permissao;
    private javax.swing.JPasswordField senhaAtual;
    private javax.swing.JPasswordField senhaNova;
    private javax.swing.JButton ver0;
    private javax.swing.JButton ver1;
    private javax.swing.JButton ver2;
    // End of variables declaration//GEN-END:variables

}
