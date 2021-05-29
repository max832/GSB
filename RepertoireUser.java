package InterfaceG;

import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.jdi.event.EventQueue;

public class RepertoireUser extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {

				try {
					RepertoireUser frame = new RepertoireUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public RepertoireUser() {
		
		setResizable(false);
		setTitle("R�pertoire des utilisateurs");
		setBounds(100, 100, 450, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(501,495);
		setResizable(false);
		
		  // Connexion � la base de donn�es
		  try (			     
			         Connection conn = DriverManager.getConnection(
			        		 	// Connexion � la base de donn�es (Supprim�e pour des raisons de s�curit�)
				         	);
			         Statement stmt = conn.createStatement();
			      ) { 
					
	      // Requ�te
	      String query = "SELECT `id`, `login`, `mdp`, `fonction`, `region` FROM `utilisateur`";
	    
	      ResultSet res = stmt.executeQuery(query);
	      
	      // R�cup�rations de toutes les donn�es dans un tableau
	      String columns[] = {"N� Employ�", "Login", "Mot de passe", "Fonction", "R�gion"};
	      String data[][] = new String[200][5];
	    
	      int i = 0;
	      	while (res.next()){
	      		String id = res.getString("id");
	      		String login = res.getString("login");
	      		String mdp = res.getString("mdp");
	      		String fonction = res.getString("fonction");
	      		String region = res.getString("region");
	      			data[i][0] = id + "";
	      			data[i][1] = login;
	      			data[i][2] = mdp;
	      			data[i][3] = fonction;
	      			data[i][4] = region;
	      			i++;
	      	}
	      
	      // Ajout du tableau � la frame
	      DefaultTableModel model = new DefaultTableModel(data, columns);
	      JTable table = new JTable(model);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      
	      JScrollPane pane = new JScrollPane(table);
	      JPanel panel = new JPanel();
	      panel.add(pane);
	      setContentPane(panel);
	      
	      // Fin de connexion � la base de donn�es
		    } catch(SQLException e) {
		      e.printStackTrace();
		 }
	}
}
