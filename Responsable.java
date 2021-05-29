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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Responsable extends JFrame {

	//Début des procédures
	// procédure d'ouverture de "First"
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
    
    private static UserAdd frameUserAdd;
    
    public static UserAdd getFenetreUserAdd() {
             return frameUserAdd; 
    }
 
    public static boolean fenetreUserAddEstOuverte() {
             return frameUserAdd!=null ; 
    }
    
    public static UserAdd ouvrirFenetreUserAdd() {
        if ( frameUserAdd==null ) {
       	 frameUserAdd =new UserAdd();
        }
        frameUserAdd.setVisible(true);
        return frameUserAdd;
}
    
    private static UserSupp frameUserSupp;
    
    public static UserSupp getFenetreUserSupp() {
             return frameUserSupp; 
    }
 
    public static boolean fenetreUserSuppEstOuverte() {
             return frameUserSupp!=null ; 
    }
    
    public static UserSupp ouvrirFenetreUserSupp() {
        if ( frameUserSupp==null ) {
       	 frameUserSupp =new UserSupp();
        }
        frameUserSupp.setVisible(true);
        return frameUserSupp;
}
 // Fin des procédures d'ouvertures
    
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
		JLabel lblGalaxySwissBourdin = new JLabel("Espace Responsable ");
		lblGalaxySwissBourdin.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblGalaxySwissBourdin, BorderLayout.NORTH);
		
		// Menu
				JMenuBar menuBar = new JMenuBar();
				menuBar.setForeground(SystemColor.white);
				menuBar.setBackground(Color.white);
				setJMenuBar(menuBar);
				
				JMenu mnNewMenu = new JMenu("Autres actions ");
				mnNewMenu.setForeground(Color.black);
				mnNewMenu.setBackground(Color.white);
				menuBar.add(mnNewMenu);
				
				JMenuItem mntmNewMenuItem8 = new JMenuItem("Ajouter un nouveau compte utilisateur");
				mntmNewMenuItem8.setForeground(SystemColor.white);
				mntmNewMenuItem8.setBackground(Color.black);
				mntmNewMenuItem8.addActionListener(new ActionListener() {
		      
					public void actionPerformed(ActionEvent e) {
						Responsable.ouvrirFenetreUserAdd();
					}
				});
				
				mnNewMenu.add(mntmNewMenuItem8);
				
				JMenuItem mntmNewMenuItem19 = new JMenuItem("Supprimer un compte utilisateur");
				mntmNewMenuItem19.setForeground(SystemColor.white);
				mntmNewMenuItem19.setBackground(Color.black);
				mntmNewMenuItem19.addActionListener(new ActionListener() {
		      
					public void actionPerformed(ActionEvent e) {
						Responsable.ouvrirFenetreUserSupp();
					}
				});
				
				mnNewMenu.add(mntmNewMenuItem19);
				
				JMenuItem mntmNewMenuItem9 = new JMenuItem("Supprimer une fiche saisie");
				mntmNewMenuItem9.setForeground(SystemColor.white);
				mntmNewMenuItem9.setBackground(Color.black);
				mntmNewMenuItem9.addActionListener(new ActionListener() {
		      
					public void actionPerformed(ActionEvent e) {
						
						// Demande du numéro de la fiche pour la suprimer de la base de données
						 ImageIcon icon = new ImageIcon("");
				         Object anchor = null;
				         Object[] eventCache = null;
				         String numero = (String) JOptionPane.showInputDialog(null, "Entrer le numéro de fiche à supprimer (Utilisez le \"Repertoire des saisies\" (Accueil > Réglages > Repertoire des saisies) :", 
				                 "GSB", JOptionPane.QUESTION_MESSAGE, icon, eventCache, anchor);
				         
				         	// Connexion à la base de données
							try {
					
							         Connection conn = DriverManager.getConnection(
							        			// Connexion à la base de données (Supprimée pour des raisons de sécurité)
				         						);
							         
							         java.sql.Statement stmt = conn.createStatement();
						 
							 // Requête
									String insertQuery = "DELETE FROM `donnee` WHERE id='"+numero+"'";
									   
							       
									int x = stmt.executeUpdate(insertQuery);
									System.out.println(x);
							  
							 // Confirmation de la supression de la fiche 
							    Component frame = null;
								JOptionPane.showMessageDialog(frame,"Votre fiche "+numero+" à bien été suprimer !");
								
							 // Fin de la connexion à la base de données  
						      } catch(SQLException ex) {
						    	  System.out.println(ex);
						      } 
					}
				});
				
				mnNewMenu.add(mntmNewMenuItem9);
				
		JButton btnNewButton_1 = new JButton("Analyse sous forme de graphique en fonction d'une région");
		btnNewButton_1.setForeground(SystemColor.black);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Responsable.ouvrirFenetreFirst(currentUser);
					}
				});
		contentPane.add(btnNewButton_1, BorderLayout.CENTER);
		
	}

}

