/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;


import cadastros.agendamentoPanel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import mysql.conexao;

/**
 *
 * @author Alan
 */
public class relServPeriodo extends javax.swing.JFrame {

    
    private conexao conexao_servicos;
     MaskFormatter  ftmData,ftmData2;
    /**
     * Creates new form relServicos
     */
    public relServPeriodo() {
        initComponents();
        setLocationRelativeTo(null);//localiza onde irá aparecer a tela
        setResizable(false);//proibido redimensionar ou naum
        
      
    }

    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        try {    ftmData = new MaskFormatter("##/##/####"); } catch (ParseException e) {     e.printStackTrace(); }
        periodoInicio = new javax.swing.JFormattedTextField();
        periodoInicio = new JFormattedTextField(ftmData);
        try {    ftmData2 = new MaskFormatter("##/##/####"); } catch (ParseException e) {     e.printStackTrace(); }
        periodoFim = new javax.swing.JFormattedTextField();
        periodoFim = new JFormattedTextField(ftmData);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatorio de Serviços");

        jButton1.setText("Gerar");
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
                .addGap(18, 18, 18)
                .addComponent(periodoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(periodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(periodoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        SalvDiretorio();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void SalvDiretorio(){
        String caminhoArquivo = "";
        JFileChooser arquivo = new JFileChooser();
        int retorno = arquivo.showSaveDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
        caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
            try {
               gerarPdfCliente(caminhoArquivo);
               visualisarPdfCliente(caminhoArquivo+".pdf");
            } catch (Exception ex) {
                Logger.getLogger(relServPeriodo.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        //JOptionPane.showMessageDialog(null, caminhoArquivo);
        }else{
        //não abriu
        }
    }
    public void visualisarPdfCliente(String url){
         
                File pdf = new File(url);  
                try {  
                Desktop.getDesktop().open(pdf);  
                } catch(Exception ex) {  
                ex.printStackTrace();  
                JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
                } 
     }
    
    public void gerarPdfCliente(String url) throws Exception {
                 double valorTotalCartao=0,valorTotalDinheiro=0;
		 Document documento = new Document ();
		 PdfWriter pdf = null;
                 pdf.getInstance (documento, new FileOutputStream (url+".pdf"));
		 documento.open ();
                 //onStartPage(pdf, documento);
                 Image img1 = Image.getInstance("imagens/logo.jpg");
                 documento.add(img1);
                 Date hoje = new Date();
                 SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                 
                 
                 String linha01="Tipo do Relatorio: Serviços por período               Retirado na data: "+formatador.format(hoje);
                 Paragraph p1 = new Paragraph(linha01);
                 documento.add(p1);
                 
                 String linha02="Relatório do dia "+periodoInicio.getText()+" até o dia "+periodoFim.getText();
                 Paragraph p2 = new Paragraph(linha02);
                 documento.add(p2);
                 
                 Paragraph p3 = new Paragraph(" ");// para dar espaço para tabela
                 documento.add(p3);
 //--------------------------------Tabela  Cartão -------------------------------------------------------------
                 Paragraph esp1 = new Paragraph("    ");// para dar espaço para tabela
                 documento.add(esp1);
                 Paragraph cart = new Paragraph("Pagamento com Cartão: ");// para dar espaço para tabela
                 documento.add(cart);
                 Paragraph esp2 = new Paragraph("    ");// para dar espaço para tabela
                 documento.add(esp2);
                 
             PdfPTable tabela = new PdfPTable (4); 
             
             PdfPCell cell = new PdfPCell(new Paragraph(String.valueOf(4)));
             
                 /*cell = new PdfPCell(new Paragraph("Código do Serviço"));   
                 tabela.addCell(cell);*/
                 cell = new PdfPCell(new Paragraph("Serviço"));
                 tabela.addCell(cell);
                 cell = new PdfPCell(new Paragraph("Valor Unitário"));
                 tabela.addCell(cell);
                 cell = new PdfPCell(new Paragraph("Quantidade"));
                 tabela.addCell(cell);
                 cell = new PdfPCell(new Paragraph("Valor Total por Serviço"));
                 tabela.addCell(cell);
               String inicio=periodoInicio.getText().substring(6, 10)+"-"+periodoInicio.getText().substring(3, 5)+"-"+periodoInicio.getText().substring(0, 2);
           
               String fim=periodoFim.getText().substring(6, 10)+"-"+periodoFim.getText().substring(3, 5)+"-"+periodoFim.getText().substring(0, 2);
               //RIGHT(dtVencimento,10) BETWEEN '"+periodoInicio+"' AND '"+periodoFim+"'"
  //----------------------------gerar celulas da tabela-----------------------------------------------   
                conexaoServicos();
                        String sql="SELECT nome,preco,data,count(nome)as total FROM servicos WHERE formaPagamento = 'Cartão' and RIGHT(data,10) BETWEEN '"+inicio+"' AND '"+fim+"' group by nome having(count(nome))";
                        conexao_servicos.executaSQL(sql);
                        
                  try
                {            
                   while (conexao_servicos.resultset.next()){ 
                       
                       //codigo
                         /*cell = new PdfPCell(new Paragraph(conexao_agendamento.resultset.getString("cod")));   
                         tabela.addCell(cell);*/
                         //nome
                         String nome=conexao_servicos.resultset.getString("nome");
                         cell = new PdfPCell(new Paragraph(nome));   
                         tabela.addCell(cell);
                         
                         //preço
                        double preco = Double.parseDouble(conexao_servicos.resultset.getString("preco")) ;
                         cell = new PdfPCell(new Paragraph("R$"+preco));   
                         tabela.addCell(cell);
                      
                         //quantidade
                        //Double qntd = (double)qntdServiço(nome);
                         int qntd = Integer.parseInt(conexao_servicos.resultset.getString("total"));
                         cell = new PdfPCell(new Paragraph(""+qntd));   
                         tabela.addCell(cell);
                         //valor
                         double valor= qntd*preco;
                         cell = new PdfPCell(new Paragraph("R$ "+valor));   
                         tabela.addCell(cell);
                         valorTotalCartao=valorTotalCartao+valor ;
                         
                         
                   }conexao_servicos.resultset.first();

                 }  

                 catch (SQLException erro){
                     JOptionPane.showMessageDialog(null,"Erro ao listar no JTable "+erro);
                }  
                
                 documento.add (tabela);
                 Paragraph p4 = new Paragraph("Total: "+ valorTotalCartao);// para dar espaço para tabela
                 documento.add(p4);
                 
                 
                 
//-----------------------------------------------Tabela  Dinheiro -------------------------------------------------------------
                 Paragraph esp3 = new Paragraph("    ");// para dar espaço para tabela
                 documento.add(esp3);
                 Paragraph din = new Paragraph("Pagamento com Dinheiro: ");// para dar espaço para tabela
                 documento.add(din);
                 Paragraph esp4 = new Paragraph("    ");// para dar espaço para tabela
                 documento.add(esp4);
                 
             PdfPTable tabela2 = new PdfPTable (4); 
             
             PdfPCell cell2 = new PdfPCell(new Paragraph(String.valueOf(4)));
             
                 /*cell = new PdfPCell(new Paragraph("Código do Serviço"));   
                 tabela.addCell(cell);*/
                 cell2 = new PdfPCell(new Paragraph("Serviço"));
                 tabela2.addCell(cell2);
                 cell2 = new PdfPCell(new Paragraph("Valor Unitário"));
                 tabela2.addCell(cell2);
                 cell2 = new PdfPCell(new Paragraph("Quantidade"));
                 tabela2.addCell(cell2);
                 cell2 = new PdfPCell(new Paragraph("Valor Total por Serviço"));
                 tabela2.addCell(cell2);
             
               //RIGHT(dtVencimento,10) BETWEEN '"+periodoInicio+"' AND '"+periodoFim+"'"
  //----------------------------gerar celulas da tabela-----------------------------------------------   
                conexaoServicos();
                        String sql2="SELECT nome,preco,data,count(nome)as total FROM servicos WHERE formaPagamento = 'Dinheiro' and RIGHT(data,10) BETWEEN '"+inicio+"' AND '"+fim+"' group by nome having(count(nome))";
                        conexao_servicos.executaSQL(sql2);
                        
                  try
                {            
                   while (conexao_servicos.resultset.next()){ 
                       
                       //codigo
                         /*cell = new PdfPCell(new Paragraph(conexao_agendamento.resultset.getString("cod")));   
                         tabela.addCell(cell);*/
                         //nome
                         String nome=conexao_servicos.resultset.getString("nome");
                         cell2 = new PdfPCell(new Paragraph(nome));   
                         tabela2.addCell(cell2);
                         
                         //preço
                        double preco = Double.parseDouble(conexao_servicos.resultset.getString("preco")) ;
                         cell2 = new PdfPCell(new Paragraph("R$"+preco));   
                         tabela2.addCell(cell2);
                      
                         //quantidade
                        //Double qntd = (double)qntdServiço(nome);
                         int qntd = Integer.parseInt(conexao_servicos.resultset.getString("total"));
                         cell2 = new PdfPCell(new Paragraph(""+qntd));   
                         tabela2.addCell(cell2);
                         //valor
                         double valor= qntd*preco;
                         cell2 = new PdfPCell(new Paragraph("R$ "+valor));   
                         tabela2.addCell(cell2);
                         valorTotalDinheiro=valorTotalDinheiro+valor ;
                         
                         
                   }conexao_servicos.resultset.first();

                 }  

                 catch (SQLException erro){
                     JOptionPane.showMessageDialog(null,"Erro ao listar no JTable "+erro);
                }  
                
                 documento.add (tabela2);
                 Paragraph p5 = new Paragraph("Total: "+ valorTotalDinheiro);// para dar espaço para tabela
                 documento.add(p5);
                 documento.close ();
               
                
                 
     }  
    
    
    
    
    /**
     * @param args the command line arguments
     */
   
    private void conexaoServicos(){
         conexao_servicos= new conexao();
         conexao_servicos.conecta();
         
         
    }
   
    
 
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
            java.util.logging.Logger.getLogger(relServPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relServPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relServPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relServPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relServPeriodo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField periodoFim;
    private javax.swing.JFormattedTextField periodoInicio;
    // End of variables declaration//GEN-END:variables
}
