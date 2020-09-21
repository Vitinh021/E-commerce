/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.GenericoDAO;
import modelo.dao.HibernateUtil;
import modelo.vo.ItemVenda;
import modelo.vo.Produto;
import modelo.vo.Usuario;
import org.hibernate.Session;

/**
 *
 * @author marcos-victor
 */
public class VendaProximo extends javax.swing.JPanel {

    private Usuario usuarioOBJ;
    private JInternalFrame frameInternoProximo;
    private ArrayList<ItemVenda> itens;
    private ArrayList<Produto> produtos;
    private TelaInicial telaInicial;
    private int contaItens;
    private float totalFLOAT;

    public VendaProximo(TelaInicial telaInicial, Usuario usuario, JInternalFrame frameInternoProximo) {
        initComponents();
        this.frameInternoProximo = frameInternoProximo;
        this.usuarioOBJ = usuario;
        this.telaInicial = telaInicial;
        this.itens = new ArrayList<>();
        this.contaItens = 0;
        this.totalFLOAT = 0;

        this.codigo.setText("");
        this.nome.setText("");
        this.total.setText("0");
        this.qtdItens.setText("0");

        this.setBackground(Color.blue);

        this.nome.setOpaque(true);
        this.nome.setBackground(Color.white);
        this.nome.setForeground(Color.black);

        this.total.setOpaque(true);
        this.total.setBackground(Color.white);
        this.total.setForeground(Color.black);

        this.qtdItens.setOpaque(true);
        this.qtdItens.setBackground(Color.white);
        this.qtdItens.setForeground(Color.black);

        this.removerItem.setOpaque(true);
        this.removerItem.setBackground(Color.white);
        this.removerItem.setForeground(Color.black);

        this.cancelar.setOpaque(true);
        this.cancelar.setBackground(Color.white);
        this.cancelar.setForeground(Color.black);

        this.proximo.setOpaque(true);
        this.proximo.setBackground(Color.white);
        this.proximo.setForeground(Color.black);
    }

    public void carregarTabela() {
        DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());
        this.totalFLOAT = 0;
        this.contaItens = 0;

        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        for (ItemVenda item : this.itens) {
            tabela.addRow(new Object[]{item.getProduto().getNome(),
                item.getQuantidade(), item.getProduto().getPreco(),
                item.getPrecoTotal(), item.getProduto().getId()});

            this.totalFLOAT += item.getPrecoTotal();
            this.contaItens++;
        }
//        NumberFormat nf = NumberFormat.getInstance();//formata o total
//        nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2
//        this.total.setText(nf.format(this.totalFLOAT));
        this.total.setText(this.totalFLOAT +"");
        this.qtdItens.setText(this.contaItens + "");
    }

    public void nota() {
        String[] listaCod;
        String novoCod;
        float qtd;

        //analise de quantidade
        String cod = codigo.getText();
        if (cod.contains("*") && cod.contains(",")) {
            cod = cod.replace("*", "-");
            cod = cod.replace(",", ".");
            listaCod = cod.split("-");
            qtd = Float.parseFloat(listaCod[0]);
            novoCod = listaCod[1];
        } else if (cod.contains("*")) {
            cod = cod.replace("*", "-");
            listaCod = cod.split("-");
            qtd = Float.parseFloat(listaCod[0]);
            novoCod = listaCod[1];
        } else {
            qtd = 1;
            novoCod = codigo.getText();
        }

        //procurando produto....
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        GenericoDAO<Produto> genericoProd = new GenericoDAO(Produto.class, sessao);

        String sql = "select * from Produto where codigo = ? ";
        String[] atributos = new String[]{"codigo"};
        String[] valores = new String[]{novoCod + "%"};

        //retorno da procura
        this.produtos = (ArrayList<Produto>) genericoProd.getListBySQL(sql, atributos, valores);
        sessao.close();

        //cria o itemVenda e salva no array
        if (this.produtos.size() > 0) {
            NumberFormat nf = NumberFormat.getInstance();//formata o total
            nf.setMaximumFractionDigits(2);//seto o máximo de casas decimais para 2

            float subTotalFLOAT = qtd * this.produtos.get(0).getPreco();
            subTotalFLOAT = Float.parseFloat(nf.format(subTotalFLOAT).replace(",", "."));

            this.nome.setText(this.produtos.get(0).getNome());

            ItemVenda item = new ItemVenda();
            item.setPrecoTotal(subTotalFLOAT);
            item.setQuantidade(qtd);
            item.setProduto(this.produtos.get(0));
            this.itens.add(item);
            this.codigo.setText("");
            this.carregarTabela();

        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado", "Atenção", JOptionPane.WARNING_MESSAGE);
            codigo.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        codigo = new javax.swing.JFormattedTextField();
        nome = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        proximo = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        qtdItens = new javax.swing.JLabel();
        removerItem = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        codigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoKeyReleased(evt);
            }
        });

        nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        total.setFont(new java.awt.Font("Noto Sans", 0, 20)); // NOI18N
        total.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Qtd", "valor Uni.", "SubTotal", "Id"
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
            tabela1.getColumnModel().getColumn(0).setPreferredWidth(300);
            tabela1.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabela1.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabela1.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabela1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        proximo.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        proximo.setText("Próximo");
        proximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                proximoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                proximoMouseEntered(evt);
            }
        });
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        cancelar.setText("Calcelar");
        cancelar.setToolTipText("Cancelar Venda");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarMouseEntered(evt);
            }
        });
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        qtdItens.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        qtdItens.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Qtd. itens", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        removerItem.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        removerItem.setText("Remover");
        removerItem.setToolTipText("Remover Item");
        removerItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removerItemMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removerItemMouseEntered(evt);
            }
        });
        removerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qtdItens, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(removerItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(qtdItens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removerItem)
                    .addComponent(cancelar)
                    .addComponent(proximo)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        if (this.itens.size() > 0) {
            JInternalFrame tela = new JInternalFrame("Finalizar Venda");
            tela.setSize(550, 320);
            tela.setClosable(true);
            try {
                tela.setLocation(this.telaInicial.getPainel().getWidth() / 2 - 275, this.telaInicial.getPainel().getHeight() / 2 - 160);
                this.setEnabled(false);
                tela.add(new VendaFinalizar(this, this.usuarioOBJ, tela, this.frameInternoProximo));
                this.frameInternoProximo.setVisible(false);
                tela.setVisible(true);
                this.telaInicial.getPainel().add(tela);
            } catch (InterruptedException ex) {
                System.out.println("erro: classe: VendaProximo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum item adicionado", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        if (itens.size() > 0) {
            Object[] options = {"Sim", "Não"};
            int opcao = JOptionPane.showOptionDialog(null, "Cancelar venda?", "Atenção", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, options, options[0]);

            if (opcao == 0) {
                itens.clear();
                nome.setText("");
                codigo.setText("");
                qtdItens.setText("0");
                total.setText("0");

                DefaultTableModel tabela = ((DefaultTableModel) tabela1.getModel());
                while (tabela.getRowCount() > 0) {
                    tabela.removeRow(0);
                }

                JOptionPane.showMessageDialog(null, "Venda cancelada", "Informação", JOptionPane.INFORMATION_MESSAGE);
                this.frameInternoProximo.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Venda cancelada", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.frameInternoProximo.dispose();
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.nota();
        }
    }//GEN-LAST:event_codigoKeyReleased

    private void removerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerItemActionPerformed
        if (tabela1.getSelectedRow() >= 0) {
            int id = Integer.parseInt("" + tabela1.getValueAt(tabela1.getSelectedRow(), 4));

            for (ItemVenda item : this.itens) {
                if (item.getProduto().getId() == id) {
                    this.itens.remove(item);
                    JOptionPane.showMessageDialog(null, "Item removido", "Informação", JOptionPane.INFORMATION_MESSAGE);
                    carregarTabela();
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_removerItemActionPerformed

    private void removerItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerItemMouseEntered
        this.removerItem.setBackground(Color.red);
        this.removerItem.setForeground(Color.white);
    }//GEN-LAST:event_removerItemMouseEntered

    private void removerItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removerItemMouseExited
        this.removerItem.setBackground(Color.white);
        this.removerItem.setForeground(Color.black);
    }//GEN-LAST:event_removerItemMouseExited

    private void cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseEntered
        this.cancelar.setBackground(Color.red);
        this.cancelar.setForeground(Color.white);
    }//GEN-LAST:event_cancelarMouseEntered

    private void cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseExited
        this.cancelar.setBackground(Color.white);
        this.cancelar.setForeground(Color.black);
    }//GEN-LAST:event_cancelarMouseExited

    private void proximoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximoMouseEntered
        this.proximo.setBackground(Color.red);
        this.proximo.setForeground(Color.white);
    }//GEN-LAST:event_proximoMouseEntered

    private void proximoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximoMouseExited
        this.proximo.setBackground(Color.white);
        this.proximo.setForeground(Color.black);
    }//GEN-LAST:event_proximoMouseExited

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField codigo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nome;
    private javax.swing.JButton proximo;
    private javax.swing.JLabel qtdItens;
    private javax.swing.JButton removerItem;
    private javax.swing.JTable tabela1;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
