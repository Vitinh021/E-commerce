package visao;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.FluxoCaixa;
import modelo.vo.ItemVenda;
import modelo.vo.Produto;
import modelo.vo.Venda;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class ListarItens extends javax.swing.JPanel {

    private GenericoDAO<ItemVenda> generico_Item;
    private ListarVenda listarVenda;
    private ArrayList<ItemVenda> itens;
    private Venda venda;

    public ListarItens(Venda venda, ListarVenda listarVenda, JInternalFrame frameListarItens) {
        initComponents();
        this.venda = venda;
        this.listarVenda = listarVenda;

        this.setBackground(Color.blue);
        this.remover.setOpaque(true);
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);

        carregarItens();
    }

    public void carregarItens() {
        //sessao de item
        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());
        Session sessao_Item = HibernateUtil.getSessionFactory().openSession();
        this.generico_Item = new GenericoDAO(ItemVenda.class, sessao_Item);

        String sql_Item = "select * from ItemVenda WHERE venda_id like ?";
        String[] atributos_Item = new String[]{"Venda_id"};
        String[] valores_Item = new String[]{this.venda.getId() + ""};
        this.itens = (ArrayList<ItemVenda>) generico_Item.getListBySQL(sql_Item, atributos_Item, valores_Item);

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        for (ItemVenda item : this.itens) {

            tabela.addRow(new Object[]{item.getProduto().getNome(), item.getProduto().getPreco(),
                item.getQuantidade(), item.getPrecoTotal(), item.getId()});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        remover = new javax.swing.JButton();

        tabela1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço", "Qtd", "total", "Id_Item"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela1);
        if (tabela1.getColumnModel().getColumnCount() > 0) {
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabela1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(remover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseExited
        this.remover.setBackground(Color.white);
        this.remover.setForeground(Color.black);
    }//GEN-LAST:event_removerMouseExited

    private void removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerMouseEntered
        this.remover.setBackground(Color.red);
        this.remover.setForeground(Color.white);
    }//GEN-LAST:event_removerMouseEntered

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            //sessao de produtos
            Session sessao_Prod = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<Produto> genericoProd = new GenericoDAO<Produto>(Produto.class, sessao_Prod);

            //sessao venda
            Session sessao_Venda = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<Venda> generico_venda = new GenericoDAO(Venda.class, sessao_Venda);

            //sessao fluxo caixa
            Session sessao_fluxo = HibernateUtil.getSessionFactory().openSession();
            GenericoDAO<FluxoCaixa> generico_fluxo = new GenericoDAO<FluxoCaixa>(FluxoCaixa.class, sessao_fluxo);

            //pegando o item
            String sql_Item = "select * from ItemVenda where id = ?";
            String[] atributos_Item = new String[]{"id"};
            String[] valores_Item = new String[]{tabela1.getValueAt(tabela1.getSelectedRow(), 4) + ""};
            this.itens = (ArrayList<ItemVenda>) generico_Item.getListBySQL(sql_Item, atributos_Item, valores_Item);

            ItemVenda item = this.itens.get(0);
            Produto produto = item.getProduto();

            //atualizando produto e venda
            produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
            genericoProd.update(produto);
            this.venda.setValor(venda.getValor() - item.getPrecoTotal());
            generico_venda.update(this.venda);

            //pegando o fluxo referente a venda
            String sql_fluxo = "select * from FluxoCaixa where venda_id = ?";
            String[] atributos_fluxo = new String[]{"venda_id"};
            String[] valores_fluxo = new String[]{this.venda.getId() + ""};
            ArrayList<FluxoCaixa> lista_fluxo = (ArrayList<FluxoCaixa>) generico_fluxo.getListBySQL(sql_fluxo, atributos_fluxo, valores_fluxo);
            
            //atualizando o fluxo
            FluxoCaixa fluxo = lista_fluxo.get(0);
            fluxo.setValor(this.venda.getValor());
            generico_fluxo.update(fluxo);
            
            //apagando item
            String sql_item_del = "delete from ItemVenda where id = ?";
            String[] atributos_item_del = new String[]{"id"};
            String[] valores_item_del = new String[]{"" + (tabela1.getValueAt(tabela1.getSelectedRow(), 4))};
            generico_Item.getDeleteBySQL(sql_item_del, atributos_item_del, valores_item_del);
            
            sessao_Prod.close();
            sessao_Venda.close();
            sessao_fluxo.close();

            JOptionPane.showMessageDialog(null, "Removido", "Informação", JOptionPane.INFORMATION_MESSAGE);
            carregarItens();
            this.listarVenda.carregarVendas();

        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton remover;
    private javax.swing.JTable tabela1;
    // End of variables declaration//GEN-END:variables
}
