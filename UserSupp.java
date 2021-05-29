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

public class UserSupp extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtAdmin;

	   private static UserSupp frameUserSupp;
	   private static RepertoireUser frameRepertoireUser;
	   
	   private JTextField txtLog;
	     
	   // Ouverture d'une fenêtre de suppression de compte
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
	     
	    // Ouverture du répertoire des utilisateurs
	     public static RepertoireUser getFenetreRepertoireUser() {
             return frameRepertoireUser; 
    }
 
    public static boolean fenetreRepertoireUserEstOuverte() {
             return frameRepertoireUser!=null ; 
    }
    
    public static RepertoireUser ouvrirFenetreRepertoireUser() {
        if ( frameRepertoireUser==null ) {
       	 frameRepertoireUser =new RepertoireUser();
        }
        frameRepertoireUser.setVisible(true);
        return frameRepertoireUser;
}
	     
	     
	/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				UserSupp frame = new UserSupp();
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
public UserSupp() {
	setTitle("Supprimer un compte GSB");
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
			
			JMenuItem mntmNewMenuItem8 = new JMenuItem("Supprimer un autre utilisateur");
			mntmNewMenuItem8.setForeground(SystemColor.white);
			mntmNewMenuItem8.setBackground(Color.black);
			mntmNewMenuItem8.addActionListener(new ActionListener() {
	      
				public void actionPerformed(ActionEvent e) {
					UserSupp.ouvrirFenetreUserSupp();
					
				}
			});
			
			mnNewMenu.add(mntmNewMenuItem8);
	
	JLabel lblNewLabel = new JLabel("Suppression d'un compte ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, contentPane);
	lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 28));
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Num\u00E9ro employ\u00E9(e) : ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 20, SpringLayout.SOUTH, lblNewLabel);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_1);
	
	JLabel txtPass = new JLabel();
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtPass, 9, SpringLayout.SOUTH, lblNewLabel_1);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtPass, 80, SpringLayout.WEST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtPass, -21, SpringLayout.EAST, contentPane);
	txtPass.setForeground(Color.WHITE);
	txtPass.setBackground(Color.DARK_GRAY);
	contentPane.add(txtPass);
	
	DefaultComboBoxModel allRole = new DefaultComboBoxModel();
	         allRole.addElement("admin");
	
	JButton btnNewButton = new JButton("Supprimer le compte");
	sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, txtPass);
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
			// Récupération des données saisies
			 
		     String id = txtLog.getText();
		     
			 	// Connexion à la base de données
				try {
			      
				         Connection conection = DriverManager.getConnection(
				        			// Connexion à la base de données (Supprimée pour des raisons de sécurité)
				         	);
				        
				         // Requête d'insertion
						String insertQuery = "DELETE FROM `utilisateur` WHERE `id` ="+id+"";
						   
				        Statement stat = conection.createStatement();
						int x = stat.executeUpdate(insertQuery);
						System.out.println(x);
				  
				    // Confirmation de la suppression
				   
					Component frame2 = null;
					JOptionPane.showMessageDialog(frame2," Utilisateur supprimé avec succès !");

					// Fin de connexion à la base de données
				      } catch(SQLException ex) {
				    	  System.out.println(ex);
				     } 	
				
				}	
		});
	contentPane.add(btnNewButton);
	
	JList list = new JList();
	sl_contentPane.putConstraint(SpringLayout.NORTH, list, 169, SpringLayout.NORTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.WEST, list, -37, SpringLayout.EAST, contentPane);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -93, SpringLayout.SOUTH, contentPane);
	sl_contentPane.putConstraint(SpringLayout.EAST, list, -37, SpringLayout.EAST, contentPane);
	contentPane.add(list);
	
	JLabel lblNewLabel_2 = new JLabel("IMPORTANT !");
	lblNewLabel_2.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 15));
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 30, SpringLayout.SOUTH, lblNewLabel_1);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("La supression d'un compte est irr\u00E9versible.");
	lblNewLabel_3.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 11));
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("En cas de suppression non souhait\u00E9e, vous devez recr\u00E9er le compte.");
	lblNewLabel_4.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 11));
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, lblNewLabel_3);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Les informations pr\u00E9c\u00E9demment saisies par l'utilisateur seront toujours pr\u00E9sentes.");
	lblNewLabel_5.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 11));
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 6, SpringLayout.SOUTH, lblNewLabel_4);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_5);
	
	JButton btnNewButton_1 = new JButton("Ouvrir le r\u00E9pertoire des utilisateurs");
	sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnNewButton_1);
	sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_1);
	sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, -4, SpringLayout.NORTH, lblNewLabel_1);
	btnNewButton_1.setBackground(Color.WHITE);
	btnNewButton_1.addActionListener(new ActionListener() {
	      
		public void actionPerformed(ActionEvent e) {
			UserSupp.ouvrirFenetreRepertoireUser();
			
		}
	});
	
	contentPane.add(btnNewButton_1);
	
	txtLog = new JTextField();
	sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 9, SpringLayout.EAST, txtLog);
	sl_contentPane.putConstraint(SpringLayout.SOUTH, txtLog, 20, SpringLayout.NORTH, lblNewLabel_1);
	sl_contentPane.putConstraint(SpringLayout.NORTH, txtLog, -3, SpringLayout.NORTH, lblNewLabel_1);
	sl_contentPane.putConstraint(SpringLayout.WEST, txtLog, 6, SpringLayout.EAST, lblNewLabel_1);
	sl_contentPane.putConstraint(SpringLayout.EAST, txtLog, -192, SpringLayout.EAST, lblNewLabel_5);
	contentPane.add(txtLog);
	txtLog.setColumns(10);
	
	JLabel lblNewLabel_6 = new JLabel("Dans le cas d'une supression d'un compte administrateur : ");
	lblNewLabel_6.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 11));
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 7, SpringLayout.SOUTH, lblNewLabel_5);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, lblNewLabel);
	contentPane.add(lblNewLabel_6);
	
	JLabel lblNewLabel_7 = new JLabel("Assurez-vous d'en poss\u00E9der un autre, sinon vous ne pourrez plus ajouter de nouveau compte. ");
	sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 6, SpringLayout.SOUTH, lblNewLabel_6);
	sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 30, SpringLayout.WEST, contentPane);
	lblNewLabel_7.setFont(new Font("Verdana Pro", Font.BOLD | Font.ITALIC, 11));
	contentPane.add(lblNewLabel_7);
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