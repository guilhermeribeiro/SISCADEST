/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import java.awt.Font;
import java.awt.Point;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import mysql.conexao;

/**
 *
 * @author guilhermeribeiro
 */
public class itensPanel extends javax.swing.JPanel {

    private MaskFormatter ftmData;
    private  conexao conexao_itens;
    private conexao conexao_unidade_medida;
    private conexao conexao_tp_item;
    private JFormattedTextField jt_dtNasc1;
    private DefaultTableModel modeloitens;

    /**
     * Creates new form itensPanel
     */
    public itensPanel() throws SQLException {
        initComponents();
        salvarItens.setEnabled(false);
        removerItem.setEnabled(false);
        atualizaItens.setEnabled(false);
        jt_Cod.setEditable(false);
        jt_Cod.setEnabled(false);
        
        conexaoItens();
        preencherJTabelItens();
        
        try{
            ArrayList<String> groupNames = new ArrayList<String>();
            conexaoUnidadeMedida();
            while (conexao_unidade_medida.resultset.next()) { 
                String groupName = conexao_unidade_medida.resultset.getString("unidade_medida_descricao"); 
                groupNames.add(groupName);
            } 
            // Populate the combo box
            DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
            cmbUnidMed.setModel(model);
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a combo Uni. de Medida, erro = " + erro);
        }
        
        
        try{
            ArrayList<String> groupNames = new ArrayList<String>();
            conexaoTpItem();
            while (conexao_tp_item.resultset.next()) { 
                String groupName = conexao_tp_item.resultset.getString("tipo_item_desc"); 
                groupNames.add(groupName);
            } 
            // Populate the combo box
            DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
            cmbTpItem.setModel(model);
        }
        catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar a combo Tipo de Item, erro = " + erro);
        }
    }
    
    private void conexaoUnidadeMedida(){
        conexao_unidade_medida= new conexao();
        conexao_unidade_medida.conecta();
        conexao_unidade_medida.executaSQL("select unidade_medida_descricao from unidade_medida order by unidade_medida_id" );

    }
    
    private void conexaoTpItem(){
        conexao_tp_item= new conexao();
        conexao_tp_item.conecta();
        conexao_tp_item.executaSQL("select tipo_item_desc from tipo_de_item order by tipo_item_id" );

    }
    
    private void conexaoItens(){
         conexao_itens= new conexao();
         conexao_itens.conecta();
         conexao_itens.executaSQL("select * from itens" );
         
    }
    private void desconexaoItens(){
        conexao_itens.desconecta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jt_nomePesquisar = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jt_codPesquisar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jt_Cod = new javax.swing.JTextField();
        jt_Prod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jt_Desc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        try {    ftmData = new MaskFormatter("##/##/####"); } catch (ParseException e) {     e.printStackTrace(); }
        jt_dtNasc1 = new javax.swing.JFormattedTextField();
        jt_dtNasc1 = new JFormattedTextField(ftmData);
        jLabel12 = new javax.swing.JLabel();
        jt_Qtde = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbUnidMed = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbTpItem = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        salvarItens = new javax.swing.JButton();
        atualizaItens = new javax.swing.JButton();
        removerItem = new javax.swing.JButton();

        jPanel6.setBackground(new java.awt.Color(51, 51, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar por:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nome:");

        jt_nomePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_nomePesquisarActionPerformed(evt);
            }
        });

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Codigo:");

        jt_codPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_codPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(jt_nomePesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_codPesquisar)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jt_nomePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jt_codPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens Cadastrados"));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tableItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Descrição", "Quantidade Mínima", "Validade", "Unidade de Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Item"));

        jLabel14.setText("Código do Produto:");

        jt_Cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_CodActionPerformed(evt);
            }
        });

        jt_Prod.setText(" ");

        jLabel4.setText("Nome do Produto:");

        jt_Desc.setText(" ");

        jLabel15.setText("Descrição do Produto:");

        jLabel12.setText("Data de Validade:");

        jt_Qtde.setText(" ");

        jLabel6.setText("Quantidade Mínima:");

        jLabel7.setText("Unidade de Medida:");

        //cmbUnidMed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Tipo de Item:");

        //cmbTpItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jt_Qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbUnidMed, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTpItem, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jt_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jt_dtNasc1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jt_Desc)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_Prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_dtNasc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jt_Desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt_Qtde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbUnidMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTpItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        salvarItens.setText("Salvar");
        salvarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarItensActionPerformed(evt);
            }
        });

        atualizaItens.setText("Editar");
        atualizaItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizaItensActionPerformed(evt);
            }
        });

        removerItem.setText("Remover");
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
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salvarItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atualizaItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removerItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salvarItens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atualizaItens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerItem)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jt_nomePesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_nomePesquisarActionPerformed
        conexao_itens.executaSQL("select * from itens where item_nome like '" + jt_nomePesquisar.getText() + "%' order by item_nome");
        preencherJTabelItens();
    }//GEN-LAST:event_jt_nomePesquisarActionPerformed

    private void jt_codPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_codPesquisarActionPerformed
        conexao_itens.executaSQL("select * from itens where item_id like '" + jt_codPesquisar.getText() + "%' order by item_id");
        preencherJTabelItens();
    }//GEN-LAST:event_jt_codPesquisarActionPerformed

    private void tableItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemMouseClicked
        removerItem.setEnabled(true);
        atualizaItens.setEnabled(true);
        salvarItens.setEnabled(false);
        jt_Cod.setEditable(false);
        jt_Cod.setEnabled(false);
        
        //salvarLancamentoProducao.setEnabled(false);
        
        Point click = new Point(evt.getX(), evt.getY());

        int column = tableItem.columnAtPoint(click);
        int row = tableItem.rowAtPoint(click);
        String value = String.valueOf(tableItem.getValueAt(row, 0));

        try {
            conexao_itens.resultset.first();
            String igual = "n";
            while (igual == "n") {
                String pesquisado = conexao_itens.resultset.getString("item_id");//.substring(0,(tamanho_pesquisa));
                if (pesquisado.equals(value)) {
                    igual = "s";
                } else {
                    conexao_itens.resultset.next();
                }
            }
            
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            
            String dbData = sdf.format(conexao_itens.resultset.getTimestamp(5));
            
            
            jt_Cod.setText(conexao_itens.resultset.getString("item_id"));
            jt_Prod.setText(conexao_itens.resultset.getString("item_nome"));
            jt_Desc.setText(conexao_itens.resultset.getString("item_descricao"));
            jt_Qtde.setText(conexao_itens.resultset.getString("quantidade_minima"));
            
            //System.out.println(conexao_itens.resultset.getString("unidade_medida_id"));
            cmbTpItem.setSelectedIndex(conexao_itens.resultset.getInt("tipo_item_id")-1);
            cmbUnidMed.setSelectedIndex(conexao_itens.resultset.getInt("unidade_medida_id")-1);
            jt_dtNasc1.setText(dbData);
            
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu localizar via digitação, erro = " + erro);
        }
        //jt_Cod.setEditable(true);
    }//GEN-LAST:event_tableItemMouseClicked

    private void jt_CodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_CodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_CodActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        salvarItens.setEnabled(true);
        removerItem.setEnabled(false);
        atualizaItens.setEnabled(false);
        jt_Cod.setEditable(true);
        jt_Cod.setEnabled(true);
        
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

        String currentTime = sdf.format(dt);

        jt_Cod.setText("");
        jt_Desc.setText("");
        jt_Qtde.setText("");
        jt_Prod.setText("");
        jt_dtNasc1.setText(currentTime);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salvarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarItensActionPerformed
        inserirItens();
        conexaoItens();
        preencherJTabelItens();
    }//GEN-LAST:event_salvarItensActionPerformed

    private void atualizaItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizaItensActionPerformed
        try {
            
            //# ATUALIZAR DATA CONFORME DATA ATUAL
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

            String currentTime = sdf.format(dt);  

            java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = sdf1.parse(jt_dtNasc1.getText());

            java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String date = sdf2.format(currentDate);
            
            long cmbValue = cmbUnidMed.getSelectedIndex()+1;
            
            long cmbValueTp = cmbTpItem.getSelectedIndex()+1;

            String sql = "UPDATE itens SET item_nome ='" + jt_Prod.getText() + "',"
            + "item_descricao = '" + jt_Desc.getText() + "',"
            + "quantidade_minima = '" + jt_Qtde.getText() + "',"
            + "validade = '" + date + "',"
            + "tipo_item_id = '" + cmbValueTp + "',"
            + "unidade_medida_id = '" + cmbValue
            + "' WHERE item_id = '" + jt_Cod.getText() + "'";
            conexao_itens.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");

            //atualiza o ResultSet
            conexao_itens.executaSQL("Select * from itens");

            conexao_itens.resultset.next(); //posiciona no primeiro registro
            // mostrar_dados(); //irá chamar a função em que irá mstrar os dados no form
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro a tentar Alterar o registro..." + erro);
        } catch (ParseException ex) {
            Logger.getLogger(itensPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //inicioPanel.preencherJTabelAniver();
        conexaoItens();
        preencherJTabelItens();
    }//GEN-LAST:event_atualizaItensActionPerformed

    private void inserirItens() {
            try{
                java.util.Date dt = new java.util.Date();
                
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

                String currentTime = sdf.format(dt);  
                
                long cmbValue = cmbUnidMed.getSelectedIndex()+1;
                
                long cmbValueTp = cmbTpItem.getSelectedIndex()+1;
                
                //System.out.println(cmbValue);
                
                String sqlinsert ="insert into itens (item_id," +
                "item_nome," +
                "item_descricao," +
                "quantidade_minima," +
                "validade," +
                "tipo_item_id," +
                "unidade_medida_id"
                        + ") values ('"+
                            jt_Cod.getText()+"','"+
                            jt_Prod.getText()+"','"+
                            jt_Desc.getText()+"','"+
                            jt_Qtde.getText()+"','"+
                            currentTime+"','"+
                            cmbValueTp+"','"+
                            cmbValue +"')";

                conexao_itens.statement.executeUpdate(sqlinsert);
               
                JOptionPane.showMessageDialog(null, "Gravação Realizada com sucesso");

            } 
            catch(SQLException erro){
                //System.out.println(erro);
                JOptionPane.showMessageDialog(null,"A gravação não foi realizada. Motivo: " + erro);

            }
        jt_Cod.setEditable(false);
        jt_Cod.setEnabled(false);
    }
    
    public void preencherJTabelItens() {
        tableItem.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableItem.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableItem.getColumnModel().getColumn(2).setPreferredWidth(100);
        tableItem.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableItem.getColumnModel().getColumn(4).setPreferredWidth(100);
        tableItem.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        modeloitens = (DefaultTableModel) tableItem.getModel();
        modeloitens.setNumRows(0);
        
        DefaultTableCellRenderer numeros =
                new DefaultTableCellRenderer() {
                    
                    public void setValue(Object value) {
                        //setBackground(new Color(238, 238, 238));
                        setFont(new Font("Arial", Font.BOLD /*+ Font.ITALIC*/, 12));
                        super.setValue(value);
                    }
                };
        tableItem.getColumnModel().getColumn(1).setCellRenderer(numeros);
        try {            
            while (conexao_itens.resultset.next()) {
                    modeloitens.addRow(new Object[]{
                    conexao_itens.resultset.getString("item_id"),
                    conexao_itens.resultset.getString("item_nome"),
                    conexao_itens.resultset.getString("item_descricao"),
                    conexao_itens.resultset.getString("quantidade_minima"),
                    conexao_itens.resultset.getString("validade"),
                    conexao_itens.resultset.getString("unidade_medida_id")});
            }
            
            conexao_itens.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar no JTable " + erro);
        }
    }
    
    
    private void removerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerItemActionPerformed
        try {
            int row = tableItem.getSelectedRow();

            String sql = "select * from itens Where item_id = '" + jt_Cod.getText() + "'";
            conexao_itens.executaSQL(sql);
            conexao_itens.resultset.first();
            String nome = "Deletar o Item : " + conexao_itens.resultset.getString("item_nome") + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "Exclusão ", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                sql = "DELETE FROM itens Where item_id ='" + jt_Cod.getText() + "'";
                int conseguiu_excluir = conexao_itens.statement.executeUpdate(sql);
                if (conseguiu_excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
                    //atualiza o ResultSet
                    conexaoItens();
                    preencherJTabelItens();

                    java.util.Date dt = new java.util.Date();

                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

                    String currentTime = sdf.format(dt);

                    jt_Cod.setText("");
                    jt_Desc.setText("");
                    jt_Qtde.setText("");
                    jt_Prod.setText("");
                    jt_dtNasc1.setText(currentTime);
                }
            } else {
                return;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro a tentar excluir o registro: " + erro);
        }
    }//GEN-LAST:event_removerItemActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizaItens;
    private javax.swing.JComboBox<String> cmbTpItem;
    private javax.swing.JComboBox<String> cmbUnidMed;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jt_Cod;
    private javax.swing.JTextField jt_Desc;
    private javax.swing.JTextField jt_Prod;
    private javax.swing.JTextField jt_Qtde;
    private javax.swing.JTextField jt_codPesquisar;
    //private javax.swing.JFormattedTextField jt_dtNasc1;
    private javax.swing.JTextField jt_nomePesquisar;
    private javax.swing.JButton removerItem;
    private javax.swing.JButton salvarItens;
    private javax.swing.JTable tableItem;
    // End of variables declaration//GEN-END:variables
}
