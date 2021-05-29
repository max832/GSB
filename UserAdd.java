package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SpringLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserAdd extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtPseudo;
	private JTextField txtReg;
	private JTextField txtMdp;
	private JTextField txtAdmin;

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
	     
	/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				UserAdd frame = new UserAdd();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public UserAdd() {
	setTitle("Ajouter un compte \u00E0 GSB");
	setBounds(100, 100, 796, 528);
	setResizable(false);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	SpringLayout sl_contentPane = new SpringLayout();
	contentPane.setLayout(sl_contentPane);

			// Menu
			JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(SystemColor.white);
			menuBar.setBackground(Color.white);
			setJMenuBar(menuBar);
			
			JMenu mnNewMenu = new JMenu("Autres actions");
			mnNewMenu.setForeground(Color.black);
			mnNewMenu.setBackground(Color.white);
			menuBar.add(mnNewMenu);
			
			JMenuItem mntmNewMenuItem8 = new JMenuItem("Créer un autre utilisateur");
			mntmNewMenuItem8.setForeground(SystemColor.white);
			mntmNewMenuItem8.setBackground(Color.black);
			mntmNewMenuItem8.addActionListener(new ActionListener() {
	      
				public void actionPerformed(ActionEvent e) {
					UserAdd.ouvrirFenetreUserAdd();
					
				}
			});
			
			mnNewMenu.add(mntmNewMenuItem8);
	
	JLabel lblNewLabel = new JLabel("Cr\u00E9ation d'un nouveau compte ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, contentPane);
	lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Pseudo : ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 20, SpringLayout.SOUTH, lblNewLabel);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Mot de passe : ");
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Fonction : ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 20, SpringLayout.SOUTH, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_3);
	
	JLabel txtPass = new JLabel();
	sl_contentPane.putConstraint(SpringLayout.WEST, txtPass, 80, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtPass, -21, SpringLayout.EAST, contentPane);
	txtPass.setForeground(Color.WHITE);
	txtPass.setBackground(Color.DARK_GRAY);
	contentPane.add(txtPass);
	
	DefaultComboBoxModel allRole = new DefaultComboBoxModel();
	         allRole.addElement("admin");
	         allRole.addElement("visiteur");
	         allRole.addElement("deleguer");
	         allRole.addElement("responsable");

	         JComboBox txtrGg = new JComboBox(allRole);
	         sl_contentPane.putConstraint(SpringLayout.NORTH, txtrGg, -4, SpringLayout.NORTH, lblNewLabel_3);
	contentPane.add(txtrGg);   
	
	JButton btnNewButton = new JButton("Enregistrer");
	sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, contentPane);
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
			// Récupération des données saisies
			 
			 String pseudo = txtPseudo.getText();
			 String mdp = txtMdp.getText(); 
		     String status = (String) txtrGg.getSelectedItem();
		     String region = txtReg.getText();
		     
			 	// Connexion à la base de données
				try {
			      
				         Connection conection = DriverManager.getConnection(
				        		// Connexion à la base de données (Supprimée pour des raisons de sécurité)
				         	);
				        
				         // Elaboration du numéro de compte
							         int min = 300;
							         int max = 100000;
							         Random random = new Random();
							         int numero = random.nextInt(max + min) + min;
							         
				         // Requête d'insertion
						String insertQuery = "INSERT INTO `utilisateur` VALUES ('"+numero+"','"+pseudo+"','"+mdp+"','"+status+"','"+region+"')";
						   
				        Statement stat = conection.createStatement();
						int x = stat.executeUpdate(insertQuery);
						System.out.println(x);
				  
				    // Confirmation de l'enregistrement
				    Component frame = null;
					JOptionPane.showMessageDialog(frame,"Nouvel utilisateur enregistré !");
					
					Component frame2 = null;
					JOptionPane.showMessageDialog(frame2," Numéro de compte : "+numero+"\n Pseudo : "+pseudo+"\n Mot de passe : "+mdp+"\n Status : "+status+"\n Région affecté : "+region+"");

					// Fin de connexion à la base de données
				      } catch(SQLException ex) {
				    	  System.out.println(ex);
				     } 	
				
				}	
		});
	contentPane.add(btnNewButton);
	
	JList list = new JList();
	sl_contentPane.putConstraint(SpringLayout.EAST, txtrGg, 0, SpringLayout.EAST, list);
	sl_contentPane.putConstraint(SpringLayout.NORTH, list, 169, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, list, -37, SpringLayout.EAST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -93, SpringLayout.SOUTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, list, -37, SpringLayout.EAST, contentPane);
	contentPane.add(list);
	
	txtPseudo = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtPass, 6, SpringLayout.SOUTH, txtPseudo);
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 14, SpringLayout.SOUTH, txtPseudo);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtPseudo, 0, SpringLayout.EAST, list);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtPseudo, -3, SpringLayout.NORTH, lblNewLabel_1);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtPseudo, 6, SpringLayout.EAST, lblNewLabel_1);
	txtPseudo.setForeground(Color.BLACK);
	txtPseudo.setBackground(Color.WHITE);
	contentPane.add(txtPseudo);
	txtPseudo.setColumns(10);
	
	JLabel lblNewLabel_5 = new JLabel("R\u00E9gion : ");
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
	lblNewLabel_5.setToolTipText("");
	contentPane.add(lblNewLabel_5);
	
	txtReg = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.WEST, txtrGg, 0, SpringLayout.WEST, txtReg);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtReg, 155, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 3, SpringLayout.NORTH, txtReg);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtReg, 10, SpringLayout.WEST, txtPseudo);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtReg, 0, SpringLayout.EAST, list);
	txtReg.setForeground(Color.BLACK);
	txtReg.setBackground(Color.WHITE);
	contentPane.add(txtReg);
	txtReg.setColumns(10);
	
	txtMdp = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.WEST, txtMdp, 11, SpringLayout.EAST, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtMdp, 0, SpringLayout.EAST, list);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtMdp, 5, SpringLayout.SOUTH, txtPass);
	txtMdp.setForeground(Color.BLACK);
	txtMdp.setBackground(Color.WHITE);
	contentPane.add(txtMdp);
	txtMdp.setColumns(10);
	/*
	txtAdmin = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtAdmin, -3, SpringLayout.NORTH, lblNewLabel_3);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtAdmin, 10, SpringLayout.EAST, lblNewLabel_3);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtAdmin, 0, SpringLayout.EAST, list);
	contentPane.add(txtAdmin);
	txtAdmin.setColumns(10);

	*/
	}
}