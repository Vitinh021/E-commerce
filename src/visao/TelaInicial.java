package visao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import modelo.vo.Usuario;

public class TelaInicial extends javax.swing.JFrame {

    JInternalFrame tela = new JInternalFrame();

    public TelaInicial(int permissao) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(600, 500);
        switch (permissao) {
            case Usuario.VENDEDOR: {
                this.usuarios.setVisible(false);
                this.financas.setVisible(false);
                //verá as suas vendas, apenas! (modifique)S
                this.vendas.setVisible(true);
                this.painel.setVisible(true);
                this.setVisible(true);
                this.dispose();
                break;
            }
            case Usuario.ADMINISTRADOR: {
                this.financas.setVisible(false);
                this.painel.setVisible(true);
                this.setVisible(true);
                this.dispose();
                break;
            }
            case Usuario.MASTER: {
                this.painel.setVisible(true);
                this.setVisible(true);
                this.dispose();
                break;
            }
            default:
                break;
        }

        this.setVisible(true);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        cadastrar = new javax.swing.JMenu();
        usuario = new javax.swing.JMenuItem();
        produto = new javax.swing.JMenuItem();
        venda = new javax.swing.JMenuItem();
        listar = new javax.swing.JMenu();
        usuarios = new javax.swing.JMenuItem();
        produtos = new javax.swing.JMenuItem();
        vendas = new javax.swing.JMenuItem();
        financas = new javax.swing.JMenu();
        cadastrarContas = new javax.swing.JMenuItem();
        listarContas = new javax.swing.JMenuItem();
        lucros = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");

        painel.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        cadastrar.setText("Cadastrar");

        usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        usuario.setText("Usuario");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        cadastrar.add(usuario);

        produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        produto.setText("Produto");
        produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoActionPerformed(evt);
            }
        });
        cadastrar.add(produto);

        venda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        venda.setText("Venda");
        venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaActionPerformed(evt);
            }
        });
        cadastrar.add(venda);

        jMenuBar1.add(cadastrar);

        listar.setText("listar");

        usuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        usuarios.setText("Usuarios");
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });
        listar.add(usuarios);

        produtos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        produtos.setText("Produtos");
        produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosActionPerformed(evt);
            }
        });
        listar.add(produtos);

        vendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        vendas.setText("Vendas");
        vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasActionPerformed(evt);
            }
        });
        listar.add(vendas);

        jMenuBar1.add(listar);

        financas.setText("Finanças");

        cadastrarContas.setText("Cadastrar conta");
        financas.add(cadastrarContas);

        listarContas.setText("listar contas");
        financas.add(listarContas);

        lucros.setText("lucros");
        financas.add(lucros);

        jMenuBar1.add(financas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        tela.dispose();
        tela = new JInternalFrame("Novo Usuario");
        tela.setSize(400, 400);
        tela.setClosable(true);
        tela.add(new TelaUsuario());
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_usuarioActionPerformed

    private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed
        tela.dispose();
        tela = new JInternalFrame("Novo Produto");
        tela.setSize(400, 400);
        tela.setClosable(true);
//        tela.add(new TelaProduto());
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_produtoActionPerformed

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        tela.dispose();
        tela = new JInternalFrame("Lista de Usuarios");
        tela.setSize(400, 400);
        tela.setClosable(true);
        try {
            tela.add(new TelaListarUsuario(this));
        } catch (Exception ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_usuariosActionPerformed

    private void produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosActionPerformed
        tela.dispose();
        tela = new JInternalFrame("Lista de Produtos");
        tela.setSize(400, 400);
        tela.setClosable(true);
//        tela.add(new TelaListarProduto(this));
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_produtosActionPerformed

    private void vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasActionPerformed
        tela.dispose();
        tela = new JInternalFrame("Lista de Vendas");
        tela.setSize(400, 400);
        tela.setClosable(true);
//        tela.add(new TelaListarVenda());
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_vendasActionPerformed

    private void vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendaActionPerformed
        tela.dispose();
        tela = new JInternalFrame("Nova venda");
        tela.setSize(400, 400);
        tela.setClosable(true);
//        tela.add(new TelaVendaProximo(new Venda(),this));
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_vendaActionPerformed

    public JDesktopPane getPainel() {
        return painel;
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cadastrar;
    private javax.swing.JMenuItem cadastrarContas;
    private javax.swing.JMenu financas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listar;
    private javax.swing.JMenuItem listarContas;
    private javax.swing.JMenuItem lucros;
    private javax.swing.JDesktopPane painel;
    private javax.swing.JMenuItem produto;
    private javax.swing.JMenuItem produtos;
    private javax.swing.JMenuItem usuario;
    private javax.swing.JMenuItem usuarios;
    private javax.swing.JMenuItem venda;
    private javax.swing.JMenuItem vendas;
    // End of variables declaration//GEN-END:variables
}
