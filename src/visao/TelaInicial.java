package visao;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import modelo.vo.Usuario;
import util.Data;

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
                this.novoUsuario.setVisible(false);
                this.listarUsuarios.setVisible(false);
                this.novoProduto.setVisible(false);
                this.financas.setVisible(false);
                this.listarVendas.setVisible(true);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        painel = new javax.swing.JDesktopPane();
        barraMenu = new javax.swing.JMenuBar();
        cadastrar = new javax.swing.JMenu();
        novoUsuario = new javax.swing.JMenuItem();
        novoProduto = new javax.swing.JMenuItem();
        novaVenda = new javax.swing.JMenuItem();
        listar = new javax.swing.JMenu();
        listarUsuarios = new javax.swing.JMenuItem();
        listarProdutos = new javax.swing.JMenuItem();
        listarVendas = new javax.swing.JMenuItem();
        financas = new javax.swing.JMenu();
        novaDespesa = new javax.swing.JMenuItem();
        listarDespesas = new javax.swing.JMenuItem();
        fecharCaixa = new javax.swing.JMenu();
        fecharCaixaHoje = new javax.swing.JMenuItem();
        fecharCaixaData = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

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

        novoUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        novoUsuario.setText("Usuário");
        novoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoUsuarioActionPerformed(evt);
            }
        });
        cadastrar.add(novoUsuario);

        novoProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        novoProduto.setText("Produto");
        novoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoProdutoActionPerformed(evt);
            }
        });
        cadastrar.add(novoProduto);

        novaVenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        novaVenda.setText("Venda");
        novaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaVendaActionPerformed(evt);
            }
        });
        cadastrar.add(novaVenda);

        barraMenu.add(cadastrar);

        listar.setBackground(java.awt.Color.white);
        listar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listar.setForeground(java.awt.Color.black);
        listar.setText("listar  ");
        listar.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        listarUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        listarUsuarios.setText("Usuários");
        listarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarUsuariosActionPerformed(evt);
            }
        });
        listar.add(listarUsuarios);

        listarProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        listarProdutos.setText("Produtos");
        listarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarProdutosActionPerformed(evt);
            }
        });
        listar.add(listarProdutos);

        listarVendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        listarVendas.setText("Vendas");
        listarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarVendasActionPerformed(evt);
            }
        });
        listar.add(listarVendas);

        barraMenu.add(listar);

        financas.setBackground(java.awt.Color.white);
        financas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        financas.setForeground(java.awt.Color.black);
        financas.setText("Finanças");
        financas.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        novaDespesa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        novaDespesa.setText("Cadastrar Despesa");
        novaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaDespesaActionPerformed(evt);
            }
        });
        financas.add(novaDespesa);

        listarDespesas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        listarDespesas.setText("listar Despesas");
        listarDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarDespesasActionPerformed(evt);
            }
        });
        financas.add(listarDespesas);

        fecharCaixa.setText("Fechar Caixa");

        fecharCaixaHoje.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        fecharCaixaHoje.setText("Hoje");
        fecharCaixaHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharCaixaHojeActionPerformed(evt);
            }
        });
        fecharCaixa.add(fecharCaixaHoje);

        fecharCaixaData.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        fecharCaixaData.setText("Por data");
        fecharCaixaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharCaixaDataActionPerformed(evt);
            }
        });
        fecharCaixa.add(fecharCaixaData);

        financas.add(fecharCaixa);

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

    private void novoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoUsuarioActionPerformed
        JInternalFrame tela = new JInternalFrame("Novo usuario");
        tela.setClosable(true);
        tela.add(new NovoUsuario());
        tela.setSize(260, 250);
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 130, painel.getHeight() / 2 - 125);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_novoUsuarioActionPerformed

    private void novoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoProdutoActionPerformed
        JInternalFrame tela = new JInternalFrame("Novo produto");
        tela.setSize(260, 280);
        tela.setClosable(true);
        tela.add(new NovoProduto());
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 130, painel.getHeight() / 2 - 140);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_novoProdutoActionPerformed

    private void listarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarUsuariosActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de usuarios");
        tela.setSize(520, 385);
        tela.setClosable(true);
        tela.add(new ListarUsuario(this));
        tela.setLocation(painel.getWidth() / 2 - 260, painel.getHeight() / 2 - 190);
        tela.setVisible(true);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_listarUsuariosActionPerformed

    private void listarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarProdutosActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de produtos");
        tela.setSize(600, 410);
        tela.setClosable(true);
        tela.add(new ListarProduto(this, this.usuarioOBJ));
        tela.setLocation(painel.getWidth() / 2 - 300, painel.getHeight() / 2 - 205);
        tela.setVisible(true);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_listarProdutosActionPerformed

    private void listarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarVendasActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de vendas");
        tela.setSize(850, 485);
        tela.setClosable(true);
        tela.add(new ListarVenda(this));
        tela.setLocation(painel.getWidth() / 2 - 425, painel.getHeight() / 2 - 240);
        tela.setVisible(true);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_listarVendasActionPerformed

    private void novaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaVendaActionPerformed
        JInternalFrame tela = new JInternalFrame("Nova venda");  
        tela.setSize(800, 430);
        tela.setClosable(false);
        tela.add(new VendaProximo(this, this.usuarioOBJ, tela));
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 400, painel.getHeight() / 2 - 215);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_novaVendaActionPerformed

    private void novaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaDespesaActionPerformed
        JInternalFrame tela = new JInternalFrame("Nova Despesa");
        tela.setSize(260, 350);
        tela.setClosable(true);
        tela.add(new NovaDespesa());
        tela.setVisible(true);
        tela.setLocation(painel.getWidth() / 2 - 130, painel.getHeight() / 2 - 175);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_novaDespesaActionPerformed

    private void listarDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarDespesasActionPerformed
        JInternalFrame tela = new JInternalFrame("Listagem de Despesas ");
        tela.setSize(850, 485);
        tela.setClosable(true);
        tela.add(new ListarDespesa(this));
        tela.setLocation(painel.getWidth() / 2 - 425, painel.getHeight() / 2 - 240);
        tela.setVisible(true);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_listarDespesasActionPerformed

    private void fecharCaixaHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharCaixaHojeActionPerformed
        JInternalFrame tela = new JInternalFrame("Fechamento de caixa                                     Data: " + Data.getData());
        tela.setSize(830, 400);
        tela.setClosable(true);
        tela.add(new FecharCaixaHoje());
        tela.setLocation(painel.getWidth() / 2 - 415, painel.getHeight() / 2 - 200);
        tela.setVisible(true);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_fecharCaixaHojeActionPerformed

    private void fecharCaixaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharCaixaDataActionPerformed
        JInternalFrame tela = new JInternalFrame("Fechamento de caixa por data");
        tela.setSize(830, 400);
        tela.setClosable(true);
        tela.add(new FecharCaixaData());
        tela.setLocation(painel.getWidth() / 2 - 415, painel.getHeight() / 2 - 200);
        tela.setVisible(true);
        painel.add(tela);
        tela.moveToFront();
    }//GEN-LAST:event_fecharCaixaDataActionPerformed

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
    private javax.swing.JMenu fecharCaixa;
    private javax.swing.JMenuItem fecharCaixaData;
    private javax.swing.JMenuItem fecharCaixaHoje;
    private javax.swing.JMenu financas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu listar;
    private javax.swing.JMenuItem listarDespesas;
    private javax.swing.JMenuItem listarProdutos;
    private javax.swing.JMenuItem listarUsuarios;
    private javax.swing.JMenuItem listarVendas;
    private javax.swing.JMenuItem novaDespesa;
    private javax.swing.JMenuItem novaVenda;
    private javax.swing.JMenuItem novoProduto;
    private javax.swing.JMenuItem novoUsuario;
    private javax.swing.JDesktopPane painel;
    // End of variables declaration//GEN-END:variables
}
