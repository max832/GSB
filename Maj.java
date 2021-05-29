package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;

public class Maj extends JFrame {

	private JPanel contentPane;

	public Maj(ObjtVisiteur currentUser) throws IOException {
		
		// Connexion base de données
		try (			     
		         Connection conn = DriverManager.getConnection(
		        			// Connexion à la base de données (Supprimée pour des raisons de sécurité)
				         	);
		         Statement stmt = conn.createStatement();
		      ) { 
				
				// Requête de récupération des données en fonction du système d'exploitation de l'utilisateur
			
				//String strSelect = "SELECT `id`, `num_disp`, `new`, `date` FROM `maj` WHERE `os` = 'macos'";
		        String strSelect = "SELECT `id`, `num_disp`, `new`, `date` FROM `maj` WHERE `os` = 'windows'";
		 
		         ResultSet rset = stmt.executeQuery(strSelect);

		         while(rset.next()) {  
		        	
		            String id = rset.getString("id"); // id de la mise à jour
		            String num_disp = rset.getString("num_disp"); // Numéro de mise à jour disponible sur les serveurs
		            String news = rset.getString("new"); // Détails de la dernière mise à jour
		            String date = rset.getString("date"); // Date de sortie de la maj

		            System.out.println("* Données récupérées Succès !*");
		            
		// Récupération des données de l'utilisateurs connectés pour un affichage
		String login = currentUser.getLogin();
		String fonction = currentUser.getFonction();
	    
		setTitle("Connecter en tant que : '"+login+"' avec le statut de : '"+fonction+"'.");
		setResizable(false);
		setBounds(100, 100, 966, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("A propos de Galaxy Swiss Bourdin   ");
		lblNewLabel.setFont(new Font("Verdana Pro Black", Font.ITALIC, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Vérifier les mises à jour disponibles pour le progiciel");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, lblNewLabel);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Ajout de la date et de l'heure de vérification de la dernière mise à jour disponible.
				 */
				 DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		         Calendar calendar = Calendar.getInstance();
		         System.out.println(format.format(calendar.getTime()));
		         
		         JLabel dateVerif = new JLabel("Dernière vérification le "+format.format(calendar.getTime())+"");
		 		sl_contentPane.putConstraint(SpringLayout.NORTH, dateVerif, 15, SpringLayout.SOUTH, btnNewButton);
				sl_contentPane.putConstraint(SpringLayout.WEST, dateVerif, 0, SpringLayout.WEST, lblNewLabel);
		 		contentPane.add(dateVerif);
		 		
		 		// Numéro de version de l'application
				final String num = "2.0.3";
				
				// Si les numéros sont égals alors message
				if(num.equals(num_disp)) {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Aucune mise à jour disponible ! ", "Update GSB", JOptionPane.WARNING_MESSAGE);
					
				// Si les numéros ne sont pas égaux alors : message + ouverture de la page de téléchargement
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Une mise à jour est disponible !", "Update GSB", JOptionPane.WARNING_MESSAGE);
				
					try {
					    Desktop.getDesktop().browse(new URL("URL").toURI());
					} catch (Exception err) {}
				}
			}
		});
		contentPane.add(btnNewButton);
		
		// Informations sur la version actuel (visible par l'utilisateur)
		
		//JLabel lblNewLabel_1 = new JLabel("Galaxy Swiss Bourdin Version 2.0.3 For macOS");
		JLabel lblNewLabel_1 = new JLabel("Galaxy Swiss Bourdin Version 2.0.3 For Microsoft Windows");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 45, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 446, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyright 2021 ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, 216, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMiseJour = new JLabel("Mise à jour   ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMiseJour, 29, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 16, SpringLayout.SOUTH, lblMiseJour);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMiseJour, 0, SpringLayout.WEST, lblNewLabel);
		lblMiseJour.setFont(new Font("Verdana Pro Black", Font.ITALIC, 20));
		contentPane.add(lblMiseJour);
		
		JLabel lblNewLabel_3 = new JLabel("Dernière mise à jour disponible : "+num_disp+" du "+date+"");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 40, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Détails : "+news+"");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_4);
		      	  }
		// Fin de connexion à la base de données    	 
	    } catch(SQLException ex) {
	       ex.printStackTrace();
	    } 
	}
}
    
	
