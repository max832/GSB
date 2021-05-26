package InterfaceG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

public class ConnectionBdd extends Observable{
    private static Connection conn;
    private static  Statement statement;


        public static void openConnection() throws SQLException {
           // Connexion à la base de données (Supprimée pour des raisons de sécurité)
      
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } 
            catch (ClassNotFoundException ex) {
                System.out.println("Connexion �chou�e");
                System.out.println(ex.getMessage());
            }

            try {
                conn = DriverManager.getConnection(url, username, password);

                // Cr�ation de l'objet g�rant les requ�tes 
                statement = conn.createStatement();

            } catch (SQLException ex) {
                System.out.println("Failed To Connect To Server Successfully");
                System.out.println(ex.getMessage());
            }
        }
        //*******************************************************************************************************************
        public static ObjtVisiteur ConnectionVisiteur(String login, String password) throws SQLException {
        	openConnection();
        	
        	String checkUser = "SELECT * FROM utilisateur WHERE login = '"+login+"' AND mdp = '"+password+"'";
        	ResultSet rset = statement.executeQuery(checkUser);

            ObjtVisiteur currentUser = new ObjtVisiteur();

                while(rset.next()) {

                        String id = rset.getString("id");
                        String resultLogin = rset.getString("login");
                        String mdp = rset.getString("mdp");
                        String statut = rset.getString("fonction");
                        String region = rset.getString("region");
                        
                        currentUser = new ObjtVisiteur(id, resultLogin, mdp, statut, region);
                     }
             
                return currentUser;
        }
        //*******************************************************************************************************************

}
