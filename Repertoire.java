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

public class Repertoire extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {

				try {
					Repertoire frame = new Repertoire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Repertoire() {
		
		setResizable(false);
		setTitle("R�pertoire des saisies");
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
	      String query = "SELECT `id`, `employe`, `region`, `compte` FROM `donnee`";
	    
	      ResultSet res = stmt.executeQuery(query);
	      
	      // R�cup�rations de toutes les donn�es dans un tableau
	      String columns[] = {"N� fiche", "N� d'employ�", "N� de r�gion", "Entreprise cibl�"};
	      String data[][] = new String[200][4];
	    
	      int i = 0;
	      	while (res.next()){
	      		String id = res.getString("id");
	      		String employe = res.getString("employe");
	      		String region = res.getString("region");
	      		String compte = res.getString("compte");
	      			data[i][0] = id + "";
	      			data[i][1] = employe;
	      			data[i][2] = region;
	      			data[i][3] = compte;
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
