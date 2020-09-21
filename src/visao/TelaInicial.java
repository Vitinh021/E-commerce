package visao;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import modelo.vo.Usuario;

/**
 *
 * @author marcos-victor
 */
public class TelaInicial extends javax.swing.JFrame {

    private Usuario usuarioOBJ;

    public TelaInicial(Usuario usuario) {
        initComponents();
        this.usuarioOBJ = usuario;
        switch (usuario.getPermissao()) {
            case Usuario.VENDEDOR: {
                this.usuario.setVisible(false);
                this.usuarios.setVisible(false);
                this.produto.setVisible(false);
                this.financas.setVisible(false);
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

        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JMenuBar();
        cadastrar = new javax.swing.JMenu();
        usuario = new javax.swing.JMenuItem();
        produto = new javax.swing.JMenuItem();
        venda = new javax.swing.JMenuItem();
        listar = new javax.swing.JMenu();
        usuarios = new javax.swing.JMenuItem();
        produtos = new javax.swing.JMenuItem();
        vendas = new javax.swing.JMenuItem();
        financas = new javax.swing.JMenu();
        cadastrarDespesaEmpresa = new javax.swing.JMenuItem();
        cadastrarDespesaPessoal = new javax.swing.JMenuItem();
        listarDespesaEmpresa = new javax.swing.JMenuItem();
        listarDespesaPessoal = new javax.swing.JMenuItem();
        relatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");

        painel.setBackground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        barraMenu.setBackground(java.awt.Color.lightGray);

        cadastrar.setBackground(java.awt.Color.white);
        cadastrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cadastrar.setForeground(java.awt.Color.black);
        cadastrar.setText("Cadastrar  ");
        cadastrar.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        usuario.setText("Usuário");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        cadastrar.add(usuario);

        produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        produto.setText("Produto");
        produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoActionPerformed(evt);
            }
        });
        cadastrar.add(produto);

        venda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        venda.setText("Venda");
        venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaActionPerformed(evt);
            }
        });
        cadastrar.add(venda);

        barraMenu.add(cadastrar);

        listar.setBackground(java.awt.Color.white);
        listar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listar.setForeground(java.awt.Color.black);
        listar.setText("listar  ");
        listar.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        usuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        usuarios.setText("Usuários");
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });
        listar.add(usuarios);

        produtos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        produtos.setText("Produtos");
        produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosActionPerformed(evt);
            }
        });
        listar.add(produtos);

        vendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        vendas.setText("Vendas");
        vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasActionPerformed(evt);
            }
        });
        listar.add(vendas);

        barraMenu.add(listar);

        financas.setBackground(java.awt.Color.white);
        financas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        financas.setForeground(java.awt.Color.black);
        financas.setText("Finanças");
        financas.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        cadastrarDespesaEmpresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        cadastrarDespesaEmpresa.setText("Cadastrar despesa empresarial ");
        cadastrarDespesaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarDespesaEmpresaActionPerformed(evt);
            }
        });
        financas.add(cadastrarDespesaEmpresa);

        cadastrarDespesaPessoal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        cadastrarDespesaPessoal.setText("Cadastrar despesa pessoal");
        cadastrarDespesaPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarDespesaPessoalActionPerformed(evt);
            }
        });
        financas.add(cadastrarDespesaPessoal);

        listarDespesaEmpresa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        listarDespesaEmpresa.setText("listar despesa empresarial");
        listarDespesaEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarDespesaEmpresaActionPerformed(evt);
            }
        });
        financas.add(listarDespesaEmpresa);

        listarDespesaPessoal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        listarDespesaPessoal.setText("listar despesa pessoal");
        listarDespesaPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarDespesaPessoalActionPerformed(evt);
            }
        });
        financas.add(listarDespesaPessoal);

        relatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        relatorio.setText("Relatório");
        relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioActionPerformed(evt);
            }
        });
        financas.add(relatorio);

        barraMenu.add(financas);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Usuario getUsuarioOBJ() {
        return usuarioOBJ;
    }

    public void setUsuarioOBJ(Usuario usuarioOBJ) {
        this.usuarioOBJ = usuarioOBJ;
    }

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        JInternalFrame tela = new JInternalFrame("Novo usuario");
        tela.setSize(300, 300);
        tela.setClosable(true);
        tela.add(new NovoUsuario());
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 150, painel.getHeight() / 2 - 150);
        tela.requestFocus();
        painel.add(tela);
    }//GEN-LAST:event_usuarioActionPerformed

    private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed
        JInternalFrame tela = new JInternalFrame("Novo produto");
        tela.setSize(300, 300);
        tela.setClosable(true);
        tela.add(new NovoProduto());
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 150, painel.getHeight() / 2 - 150);
        tela.requestFocus();
        painel.add(tela);
    }//GEN-LAST:event_produtoActionPerformed

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de usuarios");
        tela.setSize(600, 400);
        tela.setClosable(true);
        tela.add(new ListarUsuario(this));
        tela.setLocation(painel.getWidth() / 2 - 300, painel.getHeight() / 2 - 200);
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_usuariosActionPerformed

    private void produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de produtos");
        tela.setSize(600, 400);
        tela.setClosable(true);
        tela.add(new ListarProduto(this));
        tela.setLocation(painel.getWidth() / 2 - 300, painel.getHeight() / 2 - 200);
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_produtosActionPerformed

    private void vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de vendas");
        tela.setSize(750, 500);
        tela.setClosable(true);
        tela.add(new ListarVenda());
        tela.setLocation(painel.getWidth() / 2 - 375, painel.getHeight() / 2 - 250);
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_vendasActionPerformed

    private void vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendaActionPerformed
        JInternalFrame tela = new JInternalFrame("Nova venda");
        tela.setSize(800, 420);
        tela.setClosable(true);
        tela.add(new VendaProximo(this, this.usuarioOBJ, tela));
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 400, painel.getHeight() / 2 - 210);
        painel.add(tela);
    }//GEN-LAST:event_vendaActionPerformed

    private void cadastrarDespesaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarDespesaEmpresaActionPerformed
        JInternalFrame tela = new JInternalFrame("Nova despesa empresa");
        tela.setSize(300, 300);
        tela.setClosable(true);
        tela.add(new NovaDespesaEmpresa());
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 150, painel.getHeight() / 2 - 150);
        painel.add(tela);
    }//GEN-LAST:event_cadastrarDespesaEmpresaActionPerformed

    private void listarDespesaEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarDespesaEmpresaActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de despesas empresarial");
        tela.setSize(700, 400);
        tela.setClosable(true);
        tela.add(new ListarDespesaEmpresa(this));
        tela.setLocation(painel.getWidth() / 2 - 350, painel.getHeight() / 2 - 200);
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_listarDespesaEmpresaActionPerformed

    private void cadastrarDespesaPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarDespesaPessoalActionPerformed
        JInternalFrame tela = new JInternalFrame("Nova despesa pessoal");
        tela.setSize(300, 300);
        tela.setClosable(true);
        tela.add(new NovaDespesaPessoal());
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 150, painel.getHeight() / 2 - 150);
        painel.add(tela);
    }//GEN-LAST:event_cadastrarDespesaPessoalActionPerformed

    private void listarDespesaPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarDespesaPessoalActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de despesas pessoais");
        tela.setSize(700, 400);
        tela.setClosable(true);
        tela.add(new ListarDespesaPessoal(this));
        tela.setLocation(painel.getWidth() / 2 - 350, painel.getHeight() / 2 - 200);
        tela.setVisible(true);
        painel.add(tela);
    }//GEN-LAST:event_listarDespesaPessoalActionPerformed

    private void relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relatorioActionPerformed

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
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu cadastrar;
    private javax.swing.JMenuItem cadastrarDespesaEmpresa;
    private javax.swing.JMenuItem cadastrarDespesaPessoal;
    private javax.swing.JMenu financas;
    private javax.swing.JMenu listar;
    private javax.swing.JMenuItem listarDespesaEmpresa;
    private javax.swing.JMenuItem listarDespesaPessoal;
    private javax.swing.JDesktopPane painel;
    private javax.swing.JMenuItem produto;
    private javax.swing.JMenuItem produtos;
    private javax.swing.JMenuItem relatorio;
    private javax.swing.JMenuItem usuario;
    private javax.swing.JMenuItem usuarios;
    private javax.swing.JMenuItem venda;
    private javax.swing.JMenuItem vendas;
    // End of variables declaration//GEN-END:variables
}
