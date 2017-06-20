/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.List;
import java.util.StringTokenizer;
import javafx.scene.control.Cell;
//
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.swing.JFileChooser;
import mysql.conexao;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author guilhermeribeiro
 */
public class relItensPreco {
     private static conexao database;
    
    public void expExcel(String nomeArquivo) throws FileNotFoundException, IOException {

        database = new conexao();
        database.conecta();
        
        
        FileInputStream fsIP= new FileInputStream(new File(nomeArquivo)); 
        
        XSSFWorkbook workbook = new XSSFWorkbook(fsIP);
        XSSFSheet firstSheet = workbook.getSheetAt(0);

        FileOutputStream fos = null;
        XSSFCell cell = null;

        try {
            

// Este trecho obtem uma lista de objetos do tipo CD
// do banco de dados através de um DAO e itera sobre a lista
// criando linhas e colunas em um arquivo Excel com o conteúdo
// dos objetos.
        
            String sql = "select item_id, preco_item, numero_nota_fiscal from entrada_estoque";
            database.executaSQL(sql);
            
            ResultSet result = database.resultset;
            
            
            String soma =  "select sum(preco_item) as Soma_total from entrada_estoque";
            database.executaSQL(soma);
            
            ResultSet result_soma = database.resultset;
            
            int r = 7;
            
            
            
            
            

            /*row.createCell(0).setCellValue("cod".toUpperCase());
            row.createCell(1).setCellValue("nome".toUpperCase());
            row.createCell(2).setCellValue("preco".toUpperCase());
            row.createCell(3).setCellValue("nomecliente".toUpperCase());
            row.createCell(4).setCellValue("formaPagamento".toUpperCase());
            row.createCell(5).setCellValue("data".toUpperCase());*/
            
            
            result_soma.first();
            XSSFRow x = firstSheet.getRow(4);
            cell = x.getCell(7);
            
            
            
            cell.setCellValue(result_soma.getDouble("Soma_total"));
            
            
            
            int i = 1;
            while(result.next())
            {
                //row = firstSheet.createRow(i++);

                XSSFRow sheetrow = firstSheet.getRow(r);
                if(sheetrow == null){
                    sheetrow = firstSheet.createRow(r);
                }
                //Update the value of cell
                cell = sheetrow.getCell(7);
                if(cell == null){
                    cell = sheetrow.createCell(7);
                }
                cell.setCellValue(result.getString("item_id"));
                
                cell = sheetrow.getCell(8);
                if(cell == null){
                    cell = sheetrow.createCell(8);
                }
                cell.setCellValue(result.getInt("numero_nota_fiscal"));
                
                cell = sheetrow.getCell(9);
                if(cell == null){
                    cell = sheetrow.createCell(9);
                }
                cell.setCellValue(result.getDouble("preco_item"));
                
                
                
                r++;
                
                
                //row.createCell(5).setCellValue(result.getString("data"));
                
            }
            
            fsIP.close(); 
            
            JFileChooser arquivo2 = new JFileChooser("E:/");
            int retorno = arquivo2.showSaveDialog(null);
                if(retorno == JFileChooser.APPROVE_OPTION){
                String url = arquivo2.getSelectedFile().getAbsolutePath(); 
                
                
                //File diretorio = new File(url);  
                //File arquivo = new File(url+".sql"); 
                
                //fos = new FileOutputStream(nomeArquivo);
                
                fos = new FileOutputStream(url+".xlsx");
                workbook.write(fos);
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao exportar arquivo");
        } finally {
            try {
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // fim do metodo exp
}
