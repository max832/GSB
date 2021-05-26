package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;

public class Synth extends JFrame {
	//D�but des proc�dures
	// proc�dure d'ouverture de "Synth"
	  private static Synth frameSynth;
	    
	    public static Synth getFenetreSynth() {
	             return frameSynth; 
	    }
	 
	    public static boolean fenetreSynthEstOuverte() {
	             return frameSynth!=null ; 
	    }
	    
	    public static Synth ouvrirFenetreSynth(ObjtVisiteur currentUser) {
	        if ( frameSynth==null ) {
	        	try {
					frameSynth =new Synth(currentUser);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        frameSynth.setVisible(true);
	        return frameSynth;
	}

	 // Proc�dure d'ouverture de "Editor"
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
		
	// Fin des proc�dures d'ouverture
	private JPanel contentPane;

	public Synth(ObjtVisiteur currentUser) throws IOException {
		
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
		JMenuItem mntmNewMenuItemLog = new JMenuItem("Nouvelle analyse");
		mntmNewMenuItemLog.setForeground(SystemColor.white);
		mntmNewMenuItemLog.setBackground(Color.black);
		mntmNewMenuItemLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Synth.ouvrirFenetreSynth(currentUser);
					}
				});
		mnNewMenu.add(mntmNewMenuItemLog);
		
		JMenuItem mntmNewMenuItemLog7 = new JMenuItem("R�aliser une impression");
		mntmNewMenuItemLog7.setForeground(SystemColor.white);
		mntmNewMenuItemLog7.setBackground(Color.black);
		mntmNewMenuItemLog7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Synth.ouvrirFenetreEditor();
					}
				});
		mnNewMenu.add(mntmNewMenuItemLog7);
	
		
		ImageIcon icon = new ImageIcon("");
        Object anchor = null;
        Object[] eventCache = null;
        String numero = (String) JOptionPane.showInputDialog(null, "Entrer le num�ro de l'employ�(e) � analyser (Utilisez le \"Repertoire des saisies\" (Accueil > R�glages > Repertoire des saisies) :", 
                "GSB", JOptionPane.QUESTION_MESSAGE, icon, eventCache, anchor);
        		
        		// Connexion � la base de donn�es
				try (
			     
				   Connection conn = DriverManager.getConnection(
				        		// Connexion à la base de données (Supprimée pour des raisons de sécurité)
				  Statement stmt = conn.createStatement();
				     ) {
					
				 // Requ�te
		         String strSelectt = "SELECT `comm` FROM `donnee` WHERE employe="+numero+"";
		         
		         ResultSet rset = stmt.executeQuery(strSelectt);

		         while(rset.next()) {  
		        	 String comm = rset.getString("comm"); 

		setTitle("Synth�se");
		setBounds(100, 100, 962, 545);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\gsb.png"));
		setResizable(false);
		setSize(1200,600);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Commentaire r�dig� par l'employ�(e) "+numero+" :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_1);

		TextArea textArea = new TextArea(""+comm+"");
		textArea.setForeground(Color.black);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, -15, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, 1169, SpringLayout.WEST, contentPane);
		textArea.setBackground(SystemColor.white);
		contentPane.add(textArea);
		
		      } 
		    // Fin de connexion � la base de donn�es
	      } catch(SQLException ex) {
	         ex.printStackTrace();
	      } 
	}
}
