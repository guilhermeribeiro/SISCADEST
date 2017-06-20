/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan
 */
public class fazBackup{  
       public fazBackup(){  
        Date data = new Date();
         String url="";//C:/Users/Loja Vision/Dropbox/vision          
        int dia = data.getDate(); 
        int mes = data.getMonth(); 
        int ano = (1900+data.getYear());  
        mes = mes + 1;  
         
       JFileChooser arquivo2 = new JFileChooser("E:/");
        int retorno = arquivo2.showSaveDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
        url = arquivo2.getSelectedFile().getAbsolutePath(); 
        
        String ip = "127.0.0.1";  
        String snh = "";  
        String banco = "salaoteste";  
        File diretorio = new File(url);  
        File arquivo = new File(url+".sql");  
        Boolean snbkp = true;  
         // Cria diretório  
        if(!diretorio.isDirectory())  
            new File("vision").mkdir();  
        // Cria Arquivo de Backup  
        try {  
            if (arquivo.isFile()){  
                if(JOptionPane.showConfirmDialog(null, "Ja foi criado backup hoje, deseja substituir ?","Backup ja existe", JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){  
                    arquivo.delete();  
                    snbkp = true;  
                }  
                else{  
                    snbkp = false;  
                }  
            }  
            if(snbkp==true){  
                Process proc = Runtime.getRuntime().exec("C:/Program Files (x86)/EasyPHP-5.3.8.0/mysql/bin/mysqldump -uroot -p"+snh+" -h"+ip+" "+banco+" --result-file="+url+".sql");  
                proc.waitFor();  
                int res = proc.exitValue();  
                if (res == 0)  
                    JOptionPane.showMessageDialog(null, "Backup criado com Sucesso !");  
                else{  
                    JOptionPane.showMessageDialog(null, "Falha ao criar Backup. \n Verifique as configurações ou entre em contato com o suporte !","Erro ao criar backup", JOptionPane.ERROR_MESSAGE);  
                }  
            }  
        }  
        catch (IOException ex) {  
            ex.printStackTrace();  
            System.out.println(ex);  
            JOptionPane.showMessageDialog(null, "Erro na criação do Backup !");  
        }  
        catch(Exception err){  
            System.out.println(err);  
            JOptionPane.showMessageDialog(null, "Erro na criação do Backup !");  
        } 
       }
       }
} 