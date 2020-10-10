package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.Produto;
import modelo.vo.Usuario;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class ListarProduto extends javax.swing.JPanel {

    TelaInicial telaInicial;
    GenericoDAO<Produto> genericoProd;
    ArrayList<Produto> produtos;
    Usuario usuario;

    public ListarProduto(TelaInicial tela, Usuario usuario) {
        initComponents();
        this.telaInicial = tela;
        this.produtos = new ArrayList<>();

        this.carregarProdutos();

        this.setBackground(Color.blue);

        this.editar.setOpaque(true);
        this.editar.setBackground(Color.white);
        this.editar.setForeground(Color.black);

        this.valorTotal.setOpaque(true);
        this.valorTotal.setBackground(Color.white);
        this.valorTotal.setForeground(Color.black);

        if (this.usuario.getPermissao() == Usuario.MASTER) {
            this.valorTotal.setVisible(true);
        } else {
            this.valorTotal.setVisible(false);
        }
    }

    public void carregarProdutos() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        this.genericoProd = new GenericoDAO(Produto.class, sessao);

        //sql que filtra os dados da base
        String sql = "select * from Produto where nome like ? and codigo like ? order by nome asc";
        String[] atributos = new String[]{"nome", "codigo"};
        String[] valores = new String[]{nome.getText() + "%", codigo.getText() + "%"};

        this.produtos = (ArrayList<Produto>) this.genericoProd.getListBySQL(sql, atributos, valores);
        sessao.close();

        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }

        float valorFLOAT = 0;
        for (Produto produto : this.produtos) {
            tabela.addRow(new Object[]{produto.getCodigo(), produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getId()});
            valorFLOAT += produto.getPreco() * produto.getQuantidade();
        }

        this.valorTotal.setText(valorFLOAT + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        nome = new javax.swing.JTextField();
        editar = new javax.swing.JButton();
        codigo = new javax.swing.JTextField();
        valorTotal = new javax.swing.JLabel();

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "Nome", "Preço", "Qtd", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela1);
        if (tabela1.getColumnModel().getColumnCount() > 0) {
            tabela1.getColumnModel().getColumn(0).setResizable(false);
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela1.getColumnModel().getColumn(1).setResizable(false);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabela1.getColumnModel().getColumn(2).setResizable(false);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(3).setResizable(false);
            tabela1.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabela1.getColumnModel().getColumn(4).setResizable(false);
            tabela1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
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

        codigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoKeyReleased(evt);
            }
        });

        valorTotal.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        valorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editar)
                    .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        carregarProdutos();
    }//GEN-LAST:event_nomeKeyReleased

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            this.genericoProd = new GenericoDAO(Produto.class, sessao);

            int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 4));
            Produto produto = this.genericoProd.getEntity(id);

            JInternalFrame tela = new JInternalFrame("Atualizar Produto");
            EditarProduto painel = new EditarProduto(produto, this, tela);
            tela.setSize(300, 300);
            tela.setVisible(true);
            tela.add(painel);
            tela.setClosable(true);
            tela.setLocation(telaInicial.getPainel().getWidth() / 2 - 150, telaInicial.getPainel().getHeight() / 2 - 150);
            this.telaInicial.getPainel().add(tela);
            tela.moveToFront();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void editarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseEntered
        this.editar.setBackground(Color.red);
        this.editar.setForeground(Color.white);
    }//GEN-LAST:event_editarMouseEntered

    private void editarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseExited
        this.editar.setBackground(Color.white);
        this.editar.setForeground(Color.black);
    }//GEN-LAST:event_editarMouseExited

    private void codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyReleased
        carregarProdutos();
    }//GEN-LAST:event_codigoKeyReleased

    public GenericoDAO getGenericoProd() {
        return genericoProd;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JButton editar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    private javax.swing.JTable tabela1;
    private javax.swing.JLabel valorTotal;
    // End of variables declaration//GEN-END:variables
}
