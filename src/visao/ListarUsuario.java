package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Usuario;
import org.hibernate.Session;

public class ListarUsuario extends javax.swing.JPanel {

    private TelaInicial telaInicial;
    private GenericoDAO<Usuario> genericoUsu;
    private ArrayList<Usuario> usuarios;

    public ListarUsuario(TelaInicial tela) {
        initComponents();
        this.telaInicial = tela;
        this.usuarios = new ArrayList<>();
        this.setVisible(true);
        this.setToolTipText("Listagem de usuarios");
        this.carregartabela();

        this.setBackground(Color.blue);
        this.remover.setOpaque(true);
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);

        this.editar.setOpaque(true);
        this.editar.setBackground(Color.white);
        this.editar.setForeground(Color.black);
    }

    public void carregartabela() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoUsu = new GenericoDAO(Usuario.class, sessao);

        //sql que filtra os dados da base
        String sql = "select * from Usuario where nome like ? order by nome asc";
        String[] atributos = new String[]{"nome"};
        String[] valores = new String[]{nome.getText() + "%"};

        this.usuarios = (ArrayList<Usuario>) this.genericoUsu.getListBySQL(sql, atributos, valores);
        sessao.close();

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

            tabela.addRow(new Object[]{uso.getId(), uso.getNome(), permissao});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        nome = new javax.swing.JTextField();
        remover = new javax.swing.JButton();
        editar = new javax.swing.JButton();

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Permissão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela1);
        if (tabela1.getColumnModel().getColumnCount() > 0) {
            tabela1.getColumnModel().getColumn(0).setResizable(false);
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(1).setResizable(false);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabela1.getColumnModel().getColumn(2).setResizable(false);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });

        remover.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        remover.setText("Remover");
        remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removerMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removerMouseEntered(evt);
            }
        });
        remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerActionPerformed(evt);
            }
        });

        editar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        editar.setText("Editar");
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarMouseEntered(evt);
            }
        });
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remover)
                    .addComponent(editar))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        carregartabela();
    }//GEN-LAST:event_nomeKeyReleased

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (tabela1.getSelectedRow() >= 0) {

            DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoUsu = new GenericoDAO(Usuario.class, sessao);

            String sql = "delete from Usuario where id = ?";
            String[] atributos = new String[]{"id"};
            String[] valores = new String[]{"" + (tabela.getValueAt(tabela1.getSelectedRow(), 0))};

            this.genericoUsu.getDeleteBySQL(sql, atributos, valores);
            sessao.close();
            JOptionPane.showMessageDialog(null, "Removido", "Informação", JOptionPane.INFORMATION_MESSAGE);
            carregartabela();

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removerActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoUsu = new GenericoDAO(Usuario.class, sessao);

            int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 0));
            Usuario usuario = this.genericoUsu.getEntity(id);
            sessao.close();

            JInternalFrame tela = new JInternalFrame("Atualizar Usuario");
            EditarUsuario painel = new EditarUsuario(usuario, telaInicial, this);
            tela.setSize(350, 400);
            tela.setClosable(true);
            tela.add(painel);
            tela.setVisible(true);
            tela.setLocation(telaInicial.getPainel().getWidth() / 2 - 150, telaInicial.getPainel().getHeight() / 2 - 150);
            this.telaInicial.getPainel().add(tela);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseEntered
        this.remover.setBackground(Color.red);
        this.remover.setForeground(Color.white);
    }//GEN-LAST:event_removerMouseEntered

    private void removerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseExited
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);
    }//GEN-LAST:event_removerMouseExited

    private void editarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseEntered
        this.editar.setBackground(Color.red);
        this.editar.setForeground(Color.white);
    }//GEN-LAST:event_editarMouseEntered

    private void editarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseExited
        this.editar.setBackground(Color.white);
        this.editar.setForeground(Color.black);
    }//GEN-LAST:event_editarMouseExited

    public GenericoDAO<Usuario> getGenericoUsu() {
        return genericoUsu;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
