package visao;

import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.vo.Usuario;

public class TelaListarUsuario extends javax.swing.JPanel {

    TelaInicial telainicial;
    GenericoDAO genericoUsu;
    Usuario usuario;

    public TelaListarUsuario(TelaInicial tela) throws Exception {
        initComponents();
        this.telainicial = tela;
        this.genericoUsu = new GenericoDAO(Usuario.class);
        this.usuario = new Usuario();
        this.carregartabela();
    }

    public void carregartabela() throws Exception {
        List<Usuario> usuarios = this.getGenericoUsu().listarObjs();
        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        for (Usuario uso : usuarios) {

            String permissao = "";

            if (uso.getPermissao() == Usuario.ADMINISTRADOR) {
                permissao = "Administrador";
            } else if (uso.getPermissao() == Usuario.MASTER) {
                permissao = "Master";
            } else {
                permissao = "Vendedor";
            }

            tabela.addRow(new Object[]{uso.getId(), uso.getNome(), uso.getEmail(), permissao});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        remover = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();

        label.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        label.setText("Nome");

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "E_mail", "Permissão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela1);

        remover.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        remover.setText("Remover");
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        Editar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(remover)
                .addGap(155, 155, 155)
                .addComponent(Editar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar)
                    .addComponent(remover)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (tabela1.getSelectedRow() >= 0) {

            try {
                int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 0));
                this.getGenericoUsu().deletarObj(this.getGenericoUsu().pegarId(id));
                carregartabela();

            } catch (Exception ex) {
                System.err.println("erro:" + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "favor selecione a linha para remover.");
        }
    }//GEN-LAST:event_removerActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

            int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 0));
            Usuario usu = (Usuario) this.getGenericoUsu().pegarId(id);

            JInternalFrame jif = new JInternalFrame("Atualizar Usuario");
            TelaEditarUsuario painel = new TelaEditarUsuario(usu, telainicial, this, this.getGenericoUsu());
            jif.setSize(400, 400);
            jif.setVisible(true);
            jif.add(painel);
            jif.setClosable(true);
            this.telainicial.getPainel().add(jif);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma coluna selecionada");
        }

    }//GEN-LAST:event_EditarActionPerformed

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        try {
            carregartabela();
        } catch (Exception ex) {
            System.err.println("erro: " + ex);
        }
    }//GEN-LAST:event_nomeKeyReleased
    
    public GenericoDAO getGenericoUsu() {
        return genericoUsu;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Editar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JTextField nome;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
