package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.SystemColor;

public class Consult extends JFrame {
	//D�but des proc�dures
	// proc�dure d'ouverture de "Consult" permet une nouvelle analyse 
	
  private static Consult frameConsult;
    
    public static Consult getFenetreConsult() {
             return frameConsult; 
    }
 
    public static boolean fenetreConsultEstOuverte() {
             return frameConsult!=null ; 
    }
    
    public static Consult ouvrirFenetreConsult(ObjtVisiteur currentUser) {
        if ( frameConsult==null ) {
       	 try {
			frameConsult =new Consult(currentUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
        frameConsult.setVisible(true);
        return frameConsult;
}

 // proc�dure d'ouverture de "Editor" correspondant au traitement de texte inclus dans GSB
    
	  private static Editor frameEditor;
	    
	    public static Editor getFenetreEditor() {
	             return frameEditor; 
	    }
	 
	    public static boolean fenetreEditorEstOuverte() {
	             return frameEditor!=null ; 
	    }
	    
	    public static Editor ouvrirFenetreEditor() {
	        if ( frameEditor==null ) {
	        	frameEditor =new Editor();
	        }
	        frameEditor.setVisible(true);
	        return frameEditor;
	}
//fin des proc�dures
	    
private JPanel contentPane;
private JTextField textField;
private JTextField textField_1;
private JTextField txtAdresseComplte;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField txtJourMoisAnne;
private JTextField textField_8;
private JTextField txtExemple;

public Consult(ObjtVisiteur currentUser) throws IOException {

	JMenuBar menuBar = new JMenuBar();
	menuBar.setForeground(SystemColor.white);
	menuBar.setBackground(Color.white);
	setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("Actions");
	mnNewMenu.setForeground(Color.black);
	mnNewMenu.setBackground(Color.white);
	menuBar.add(mnNewMenu);
	
	JMenuItem mntmNewMenuItemLog = new JMenuItem("Ouvrir une autre fiche");
	mntmNewMenuItemLog.setForeground(SystemColor.white);
	mntmNewMenuItemLog.setBackground(Color.black);
	mntmNewMenuItemLog.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Deleguer.ouvrirFenetreConsult(currentUser);
		}
	});
	 
	mnNewMenu.add(mntmNewMenuItemLog);
	JMenuItem mntmNewMenuItemLog7 = new JMenuItem("R�aliser une impression");
	mntmNewMenuItemLog7.setForeground(SystemColor.white);
	mntmNewMenuItemLog7.setBackground(Color.black);
	mntmNewMenuItemLog7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Consult.ouvrirFenetreEditor();
		}
	});

	mnNewMenu.add(mntmNewMenuItemLog7);
	
	//Demande � l'utilisateur du num�ro de fiche � consulter
	ImageIcon icon = new ImageIcon("");
    Object anchor = null;
    Object[] eventCache = null;
    String numero = (String) JOptionPane.showInputDialog(null, "Entrer le num�ro de fiche � consulter (Utilisez le \"Repertoire des saisies\" (Accueil > R�glages > Repertoire des saisies) :", 
            "GSB", JOptionPane.QUESTION_MESSAGE, icon, eventCache, anchor);
    
    //Connexion � la base de donn�e
		try (
			     
		   Connection conn = DriverManager.getConnection(
		        		// Connexion à la base de données (Supprimée pour des raisons de sécurité)
		  Statement stmt = conn.createStatement();
		     ) {
			
		 // requ�te
			String strSelectt = "SELECT `contact`, `present`, `compte`, `adresse`, `produit`, `echantillon`, `nbdon`, `rdv`, `lieu`, `comm` FROM `donnee` WHERE id="+numero+"";//String strSelectt = "SELECT `contact`, `present`, `compte`, `adresse`, `produit`, `echantillon`, `nbdon`, `rdv`, `lieu`, `comm` FROM `donnee` WHERE id="+numero+" AND employe="+employe+" AND region="+region+"";
			 
	         ResultSet rset = stmt.executeQuery(strSelectt);
	         
	         //R�cup�ration des donn�es
	         while(rset.next()) {  
	        	
	            String contact = rset.getString("contact");
	            String present = rset.getString("present");
	            String compte = rset.getString("compte");
	            String adresse = rset.getString("adresse");
	            String produit = rset.getString("produit");
	            String echantillon = rset.getString("echantillon");
	            String nbdon = rset.getString("nbdon");
	            String rdv = rset.getString("rdv");
	            String lieu = rset.getString("lieu");
	            String comm = rset.getString("comm");

	setResizable(false);
	setTitle("Visiteur");
	setBounds(100, 100, 883, 519);
	setSize(1200,600);
	setResizable(false);

	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	SpringLayout sl_contentPane = new SpringLayout();
	contentPane.setLayout(sl_contentPane);
	
	JLabel lblNewLabel = new JLabel("                               ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
	contentPane.add(lblNewLabel);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
	
	JLabel lblNewLabel_2 = new JLabel("Nom du ou des client(s) repr�sentant l'entreprise :\r\n");
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Entreprise :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Adresse :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 15, SpringLayout.SOUTH, lblNewLabel_3);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("produit(s) pr�sent�(s) :\r\n");
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("Echantillon(s) offert(s) :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 15, SpringLayout.SOUTH, lblNewLabel_5);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_6);
	
	JLabel lblNewLabel_7 = new JLabel("Nombre de don :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 15, SpringLayout.SOUTH, lblNewLabel_6);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, contentPane);
	contentPane.add(lblNewLabel_7);
	
	JLabel lblNewLabel_8 = new JLabel("D�tails du dernier �change");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 14, SpringLayout.SOUTH, lblNewLabel_8);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, lblNewLabel);
	lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
	contentPane.add(lblNewLabel_8);
	
	JLabel lblNewLabel_9 = new JLabel("Commentaire(s) / remarque(s)  :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 365, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_9, 10, SpringLayout.WEST, contentPane);
	contentPane.add(lblNewLabel_9);
	
	// Nom des personnes pr�sentes
	textField = new JTextField(""+present+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.EAST, textField, -235, SpringLayout.EAST, contentPane);
	contentPane.add(textField);
	textField.setColumns(10);
	
	//Entreprise
	textField_1 = new JTextField(""+compte+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblNewLabel_3);
	sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -409, SpringLayout.EAST, contentPane);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
	
	// Adresse
	txtAdresseComplte = new JTextField(""+adresse+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 1, SpringLayout.SOUTH, txtAdresseComplte);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtAdresseComplte, 6, SpringLayout.SOUTH, textField_1);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtAdresseComplte, 26, SpringLayout.EAST, lblNewLabel_4);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtAdresseComplte, 0, SpringLayout.EAST, textField_1);
	contentPane.add(txtAdresseComplte);
	txtAdresseComplte.setColumns(10);
	
	// Produits pr�sent�s
	textField_3 = new JTextField(""+produit+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_5);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblNewLabel_5);
	sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, -31, SpringLayout.EAST, contentPane);
	contentPane.add(textField_3);
	textField_3.setColumns(10);
	
	// Echantillon offert
	textField_4 = new JTextField(""+echantillon+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, -3, SpringLayout.NORTH, lblNewLabel_6);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField_4, 145, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField_3);
	contentPane.add(textField_4);
	textField_4.setColumns(10);
	
	// Nombre de don
	textField_5 = new JTextField(""+nbdon+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField_5, -3, SpringLayout.NORTH, lblNewLabel_7);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField_5, 6, SpringLayout.EAST, lblNewLabel_7);
	contentPane.add(textField_5);
	textField_5.setColumns(10);
	
	JLabel lblNewLabel_11 = new JLabel("Derni�re date de rendez -vous  :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 10, SpringLayout.SOUTH, textField_5);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_11, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_11);
	
	// Date du dernier RDV
	txtJourMoisAnne = new JTextField(""+rdv+"");
	sl_contentPane.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, txtJourMoisAnne);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtJourMoisAnne, -3, SpringLayout.NORTH, lblNewLabel_11);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtJourMoisAnne, 11, SpringLayout.EAST, lblNewLabel_11);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtJourMoisAnne, -769, SpringLayout.EAST, contentPane);
	contentPane.add(txtJourMoisAnne);
	txtJourMoisAnne.setColumns(10);
	
	JLabel lblNewLabel_12 = new JLabel("Num�ro du contact :");
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_12, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_12);
	
	// Contact
	textField_8 = new JTextField(""+contact+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_8);
	sl_contentPane.putConstraint(SpringLayout.NORTH, textField_8, -3, SpringLayout.NORTH, lblNewLabel_12);
	sl_contentPane.putConstraint(SpringLayout.WEST, textField_8, 19, SpringLayout.EAST, lblNewLabel_12);
	sl_contentPane.putConstraint(SpringLayout.EAST, textField_8, -872, SpringLayout.EAST, contentPane);
	contentPane.add(textField_8);
	textField_8.setColumns(10);
	
	// Commentaire
	TextArea textArea = new TextArea(""+comm+"");
	sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 12, SpringLayout.EAST, lblNewLabel_9);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -15, SpringLayout.SOUTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -26, SpringLayout.EAST, contentPane);
	textArea.setBackground(SystemColor.activeCaption);
	contentPane.add(textArea);
	
	JLabel lblNewLabel_4_1 = new JLabel("Lieux de rendez-vous :");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1, 11, SpringLayout.SOUTH, lblNewLabel_11);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4_1, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_4_1);
	
	// Lieu du RDV
	txtExemple = new JTextField(""+lieu+"");
	sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 28, SpringLayout.SOUTH, txtExemple);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtExemple, 0, SpringLayout.EAST, textField_1);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtExemple, -3, SpringLayout.NORTH, lblNewLabel_4_1);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtExemple, 8, SpringLayout.EAST, lblNewLabel_4_1);
	txtExemple.setColumns(10);
	contentPane.add(txtExemple);
	
	JLabel lblNewLabel_8_1 = new JLabel("Informations sur le repr�sentant");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 9, SpringLayout.SOUTH, lblNewLabel_8_1);
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8_1, 6, SpringLayout.SOUTH, lblNewLabel);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_8_1, 0, SpringLayout.WEST, lblNewLabel);
	lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	contentPane.add(lblNewLabel_8_1);
		
		         }
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      } 
	}
}
