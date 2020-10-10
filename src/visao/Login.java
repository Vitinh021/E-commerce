package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Usuario;
import org.hibernate.Session;

public class Login extends javax.swing.JFrame {

    private ArrayList<Usuario> usuarios;
    private GenericoDAO genericoUsu;

    public Login() {
        initComponents();
        this.setTitle("Login");
        this.getContentPane().setBackground(Color.blue);

        this.nome.setForeground(Color.black);
        this.senha.setForeground(Color.black);

        this.verSenha.setSize(40, 25);
        this.verSenha.setOpaque(true);
        this.verSenha.setBackground(Color.white);
        this.verSenha.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));

        this.botaoEntrar.setOpaque(true);
        this.botaoEntrar.setBackground(Color.white);
        this.botaoEntrar.setForeground(Color.black);

        this.setSize(280, 180);
        this.setLocationRelativeTo(null);
        this.senha.setEchoChar('•');
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        botaoEntrar = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();
        verSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        botaoEntrar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        botaoEntrar.setText("Entrar");
        botaoEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoEntrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoEntrarMouseEntered(evt);
            }
        });
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        senha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        verSenha.setFocusPainted(false);
        verSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verSenhaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verSenhaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(verSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(botaoEntrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(botaoEntrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoUsu = new GenericoDAO(Usuario.class, sessao);

        //sql responsavel por pegar os dados na base
        String sql = "select * from Usuario where nome = ? and senha = ?";
        String[] atributos = new String[]{"nome", "senha"};
        String[] valores = new String[]{nome.getText(), senha.getText()};

        this.usuarios = (ArrayList<Usuario>) this.genericoUsu.getListBySQL(sql, atributos, valores);

        if (this.usuarios.size() > 0) {
            Usuario usuario = this.usuarios.get(0);
            new TelaInicial(usuario);
            this.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            nome.setText("");
            senha.setText("");
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEntrarMouseEntered
        this.botaoEntrar.setBackground(Color.red);
        this.botaoEntrar.setForeground(Color.white);
    }//GEN-LAST:event_botaoEntrarMouseEntered

    private void botaoEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEntrarMouseExited
        this.botaoEntrar.setBackground(Color.white);
        this.botaoEntrar.setForeground(Color.black);
    }//GEN-LAST:event_botaoEntrarMouseExited

    private void verSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verSenhaMouseEntered
        this.verSenha.setBackground(Color.red);
        this.verSenha.setIcon(new ImageIcon("src/imagens/eyeWhite.png"));
        senha.setEchoChar((char) 0);
    }//GEN-LAST:event_verSenhaMouseEntered

    private void verSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verSenhaMouseExited
        this.verSenha.setBackground(Color.white);
        this.verSenha.setIcon(new ImageIcon("src/imagens/eyeBlack.png"));
        senha.setEchoChar('•');
    }//GEN-LAST:event_verSenhaMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (Exception ex) {
                    System.err.println("erro ao iniciar a classe" + ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField senha;
    private javax.swing.JButton verSenha;
    // End of variables declaration//GEN-END:variables
}
