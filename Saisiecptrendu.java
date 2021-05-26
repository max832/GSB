package InterfaceG;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Saisiecptrendu extends JFrame {
	
	//D�but de la proc�dure
	// proc�dure d'ouverture de "Saisiecptrendu" 
	  private static Saisiecptrendu frameSaisiecptrendu;
	    
	    public static Saisiecptrendu getFenetreSaisiecptrendu() {
	             return frameSaisiecptrendu; 
	    }
	 
	    public static boolean fenetreSaisiecptrendutEstOuverte() {
	             return frameSaisiecptrendu!=null ; 
	    }
	    
	    public static Saisiecptrendu ouvrirFenetreSaisiecptrendu(ObjtVisiteur currentUser) {
	        if ( frameSaisiecptrendu==null ) {
	        	try {
					frameSaisiecptrendu =new Saisiecptrendu(currentUser);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        frameSaisiecptrendu.setVisible(true);
	        return frameSaisiecptrendu;
	}
	//Fin de procedure
	    
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

	public Saisiecptrendu(ObjtVisiteur currentUser) throws IOException {
		
		        // Menu
				JMenuBar menuBar = new JMenuBar();
				menuBar.setForeground(SystemColor.white);
				menuBar.setBackground(Color.white);
				setJMenuBar(menuBar);
				// Sous-menu 1
				JMenu mnNewMenu = new JMenu("Actions");
				mnNewMenu.setForeground(Color.black);
				mnNewMenu.setBackground(Color.white);
				menuBar.add(mnNewMenu);
				// Sous-menu 2
				JMenuItem mntmNewMenuItemLog = new JMenuItem("Nouvelle saisie");
				mntmNewMenuItemLog.setForeground(SystemColor.white);
				mntmNewMenuItemLog.setBackground(Color.black);
				mntmNewMenuItemLog.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Saisiecptrendu.ouvrirFenetreSaisiecptrendu(currentUser);
							}
						});
				
				mnNewMenu.add(mntmNewMenuItemLog);
				
		setResizable(false);
		setTitle("Visiteur | Compte rendu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\gsb.png"));
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
		textField = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -235, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Entreprise cibl�
		textField_1 = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblNewLabel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 6, SpringLayout.EAST, lblNewLabel_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, -409, SpringLayout.EAST, contentPane);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		// Adresse
		txtAdresseComplte = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 1, SpringLayout.SOUTH, txtAdresseComplte);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAdresseComplte, 6, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAdresseComplte, 26, SpringLayout.EAST, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAdresseComplte, 0, SpringLayout.EAST, textField_1);
		contentPane.add(txtAdresseComplte);
		txtAdresseComplte.setColumns(10);
		
		// Produits pr�sent�s
		textField_3 = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblNewLabel_5);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_3, -31, SpringLayout.EAST, contentPane);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		// Echantillon offert
		textField_4 = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_4, -3, SpringLayout.NORTH, lblNewLabel_6);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_4, 145, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_4, 0, SpringLayout.EAST, textField_3);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		// Nombre de don
		textField_5 = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_5, -3, SpringLayout.NORTH, lblNewLabel_7);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_5, 6, SpringLayout.EAST, lblNewLabel_7);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Derni�re date de rendez -vous  :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 10, SpringLayout.SOUTH, textField_5);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_11, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_11);
		
		// Date du RDV
		txtJourMoisAnne = new JTextField("AAAA-MM-JJ");
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, txtJourMoisAnne);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtJourMoisAnne, -3, SpringLayout.NORTH, lblNewLabel_11);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtJourMoisAnne, 11, SpringLayout.EAST, lblNewLabel_11);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtJourMoisAnne, -769, SpringLayout.EAST, contentPane);
		contentPane.add(txtJourMoisAnne);
		txtJourMoisAnne.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Num�ro de contact :");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_12, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_12);
		
		// Num�ro de contact
		textField_8 = new JTextField("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 6, SpringLayout.SOUTH, textField_8);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_8, -3, SpringLayout.NORTH, lblNewLabel_12);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_8, 19, SpringLayout.EAST, lblNewLabel_12);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_8, -872, SpringLayout.EAST, contentPane);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		// Commentaire
		TextArea textArea = new TextArea("");
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 12, SpringLayout.EAST, lblNewLabel_9);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -25, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -26, SpringLayout.EAST, contentPane);
		textArea.setBackground(SystemColor.activeCaption);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_4_1 = new JLabel("Lieux de rendez-vous :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1, 11, SpringLayout.SOUTH, lblNewLabel_11);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_4_1);
		
		// Lieux du RDV
		txtExemple = new JTextField("");
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
		
		// Enregistrement des donn�es 
		Button buttonEn = new Button("Enregistrer");
		sl_contentPane.putConstraint(SpringLayout.WEST, buttonEn, 20, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, buttonEn, 1, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, buttonEn, -890, SpringLayout.EAST, contentPane);
		buttonEn.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonEn.setBackground(Color.WHITE);
		buttonEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// R�cup�ration des donn�es saisies
				 String contact = textField_8.getText();
				 String produit = textField_3.getText(); 
	             String present = textField.getText(); 
	             String compte = textField_1.getText();
	             String adresse = txtAdresseComplte.getText(); 
	             String echantillon = textField_4.getText(); 
	             String nbdon = textArea.getText();
	             String rdv = textField_5.getText();
	             String lieu = txtJourMoisAnne.getText();
	             String comm = txtExemple.getText();
	 
	             // Compl�ment d'information
	             ImageIcon icon1 = new ImageIcon("");
	             Object anchor1 = null;
	     		 Object[] eventCache1 = null;
	     		 String employe = (String) JOptionPane.showInputDialog(null, "Votre num�ro d'employ�(e) (Disponible dans l'onglet \"R�glages\" du menu principal) :", 
	                     "GSB", JOptionPane.QUESTION_MESSAGE, icon1, eventCache1, anchor1);
	     		
	     		 ImageIcon icon11 = new ImageIcon("");
	             Object anchor11 = null;
	     		 Object[] eventCache11 = null;
	     		 String region = (String) JOptionPane.showInputDialog(null, "Votre num�ro de r�gion (Disponible dans l'onglet \"R�glages\" du menu principal) :", 
	                     "GSB", JOptionPane.QUESTION_MESSAGE, icon11, eventCache11, anchor11);
	     		 
	     		 	// Connexion � la base de donn�es
					try {
				      
					         Connection conection = DriverManager.getConnection(
					        		 // Connexion à la base de données (Supprimée pour des raisons de sécurité)
				
					         // Elaboration du num�ro de fiche
					         int min = 100;
					         int max = 100000;
					         Random random = new Random();
					         int numero = random.nextInt(max + min) + min;
					        
					         // Requ�te d'insertion
							String insertQuery = "INSERT INTO `donnee` VALUES ('"+numero+"','"+employe+"','"+region+"','"+contact+"','"+present+"','"+compte+"','"+adresse+"','"+produit+"','"+echantillon+"','"+rdv+"','"+lieu+"','"+comm+"','"+nbdon+"')";
							   
					        Statement stat = conection.createStatement();
							int x = stat.executeUpdate(insertQuery);
							System.out.println(x);
					  
					    // Confirmation de l'enregistrement
					    Component frame = null;
						JOptionPane.showMessageDialog(frame,"Votre saisie a bien �t� enregistrer sous la r�f�rence "+numero+" !");
						
						// Fin de connexion � la base de donn�es
				      } catch(SQLException ex) {
				    	  System.out.println(ex);
				     } 
				}	
			
			});
		contentPane.add(buttonEn);       
		}
	}






