package InterfaceG;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Responsable extends JFrame {

	//D�but des proc�dures
	// proc�dure d'ouverture de "First"
    private static First frameFirst;
    
    public static First getFenetreFirst() {
             return frameFirst; 
    }
 
    public static boolean fenetreFirstEstOuverte() {
             return frameFirst!=null ; 
    }
    
    public static First ouvrirFenetreFirst(ObjtVisiteur currentUser) {
        if ( frameFirst==null ) {
       	 try {
			frameFirst =new First(currentUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        frameFirst.setVisible(true);
        return frameFirst;
}
 // Fin des proc�dures d'ouvertures
    
	private JPanel contentPane;
     
	public Responsable(ObjtVisiteur currentUser) throws IOException {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\gsb.png"));
		setTitle("Responsable");
		setBounds(100, 100, 458, 300);
		setSize(1200,600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		JLabel lblGalaxySwissBourdin = new JLabel("Galaxy Swiss Bourdin");
		lblGalaxySwissBourdin.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblGalaxySwissBourdin, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Analyse sous forme de graphique en fonction d'une r�gion");
		btnNewButton_1.setForeground(SystemColor.black);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Responsable.ouvrirFenetreFirst(currentUser);
					}
				});
		contentPane.add(btnNewButton_1, BorderLayout.CENTER);
		
		JButton btnNewButton_10 = new JButton("Suprimer un fiche saisie");
		btnNewButton_10.setForeground(SystemColor.black);
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					// Demande du num�ro de la fiche pour la suprimer de la base de donn�es
					 ImageIcon icon = new ImageIcon("");
			         Object anchor = null;
			         Object[] eventCache = null;
			         String numero = (String) JOptionPane.showInputDialog(null, "Entrer le num�ro de fiche � supprimer (Utilisez le \"Repertoire des saisies\" (Accueil > R�glages > Repertoire des saisies) :", 
			                 "GSB", JOptionPane.QUESTION_MESSAGE, icon, eventCache, anchor);
			         
			         	// Connexion � la base de donn�es
						try {
				
						         Connection conn = DriverManager.getConnection(
						        		// Connexion à la base de données (Supprimée pour des raisons de sécurité)
						         
						         java.sql.Statement stmt = conn.createStatement();
					 
						 // Requ�te
								String insertQuery = "DELETE FROM `donnee` WHERE id='"+numero+"'";
								   
						       
								int x = stmt.executeUpdate(insertQuery);
								System.out.println(x);
						  
						 // Confirmation de la supression de la fiche 
						    Component frame = null;
							JOptionPane.showMessageDialog(frame,"Votre fiche "+numero+" � bien �t� suprimer !");
							
						 // Fin de la connexion � la base de donn�es  
					      } catch(SQLException ex) {
					    	  System.out.println(ex);
					      } 
					}
			});

		contentPane.add(btnNewButton_10, BorderLayout.NORTH);
		
	}

}

