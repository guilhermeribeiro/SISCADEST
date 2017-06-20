package mysql;
import java.sql.*;
import javax.swing.*;

public class conexao{

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/salao";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

  public boolean conecta(){
      boolean result = true;
      try{
          Class.forName(driver);
        
          conexao = DriverManager.getConnection(url,usuario,senha);
         // JOptionPane.showMessageDialog(null,"Conectou");
      }
      catch(ClassNotFoundException Driver)
      {
          JOptionPane.showMessageDialog(null, "Driver nao Localizado :"+Driver);
          result = false;
      }
      catch(SQLException Fonte)
      {
          JOptionPane.showMessageDialog(null,"Deu erro na conexão "+" com a fonte de dados: ");//+Fonte);
          result = false;          
      }
      return result;
      
  }
  //classe da desconexão
  public void desconecta(){
     boolean result = true ;
     try{
         conexao.close();
         //JOptionPane.showMessageDialog(null, "Banco de dados Fechado");
     }
     catch(SQLException fecha){
     
      JOptionPane.showMessageDialog(null, "Não foi possivel"+
                          " fechar o banco de dados: " );
      result = false;
     }
  }

  
  public void executaSQL(String sql ){
      try{
           statement = conexao.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          resultset = statement.executeQuery(sql);
      
      }
      catch(SQLException sqlex){
           JOptionPane.showMessageDialog(null,"Não foi possivel " +
                   " executar o comando sql, "+sqlex+ ", o sql passado foi "+sql);
      }
  
  }
}


