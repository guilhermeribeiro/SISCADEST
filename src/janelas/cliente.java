/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import cadastros.agendamentoPanel;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mysql.conexao;

/**
 *
 * @author Alan
 */
public class cliente extends javax.swing.JFrame {
      private conexao conexao_cliente;
     private DefaultTableModel modelocliente;
    /**
     * Creates new form cliente
     */
    public cliente() {
        initComponents();
        conexaoCliente();
        preencherJTabelCliente();
    }
    private void conexaoCliente(){
         conexao_cliente= new conexao();
         conexao_cliente.conecta();
         conexao_cliente.executaSQL("select * from clientes " );
         
    }
    private void desconexaoCliente(){
        conexao_cliente.desconecta();
    }     

    public void preencherJTabelCliente() {        
        tableCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
      
        
       
        modelocliente = (DefaultTableModel) tableCliente.getModel();
        modelocliente.setNumRows(0);
        
        DefaultTableCellRenderer numeros =
                new DefaultTableCellRenderer() {
                    
                    public void setValue(Object value) {
                        //setBackground(new Color(238, 238, 238));
                        setFont(new Font("Arial", Font.BOLD /*+ Font.ITALIC*/, 12));
                        super.setValue(value);
                    }
                };
        tableCliente.getColumnModel().getColumn(1).setCellRenderer(numeros);
        try {            
            while (conexao_cliente.resultset.next()) {
               
                    modelocliente.addRow(new Object[]{
                    conexao_cliente.resultset.getString("id"),
                    conexao_cliente.resultset.getString("nome")});
            }
           
            conexao_cliente.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar no JTable " + erro);
        }
                
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        tLocalizar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCliente);

        tLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tLocalizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar");

        jButton1.setText("Adcionar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 141, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(tLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Object obj =tableCliente.getValueAt(tableCliente.getSelectedRow(),1);
        String celula=String.valueOf(obj);
        agendamentoPanel.jcbCliente.setText(celula);
        
       // venda.jt_codigoBarra.setText(celula);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tLocalizarActionPerformed
        conexao_cliente.executaSQL("select * from clientes where nome like '"+tLocalizar.getText()+"%' order by nome"); 
        preencherJTabelCliente();
    }//GEN-LAST:event_tLocalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tLocalizar;
    private javax.swing.JTable tableCliente;
    // End of variables declaration//GEN-END:variables
}
