package InterfaceG;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;  

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Home extends JFrame {
	
	//Début des procédures partie 1
	// procédure d'ouverture de "Main" correspondant à l'ouverture du menu suite à l'identification de l'utilisateur
   private static Main frameMain;
     
     public static Main getFenetreMain() {
              return frameMain; 
     }
  
     public static boolean fenetreMainEstOuverte() {
              return frameMain!=null ; 
     }
     
     public static Main ouvrirFenetreMain() {
         if ( frameMain==null ) {
        	 frameMain =new Main();
         }
         frameMain.setVisible(true);
         return frameMain;
}

  // procédure d'ouverture de "Repertoire" correspondant au tableau contenant l'ensemble des données nécessaires à l'analyses des données 	
     private static Repertoire frameRepertoire;
       
       public static Repertoire getFenetreRepertoire() {
                return frameRepertoire; 
       }
    
       public static boolean fenetreRepertoireEstOuverte() {
                return frameRepertoire!=null ; 
       }
       
       public static Repertoire ouvrirFenetreRepertoire() {
           if ( frameRepertoire==null ) {
          	 frameRepertoire =new Repertoire();
           }
           frameRepertoire.setVisible(true);
           return frameRepertoire;
  }

    // procédure d'ouverture de "Editor", ouverture de l'editeur de texte inclus dans GSB
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
 	 //Fin des procédures Partie 1
 
	private JPanel contentPane;


	public Home(ObjtVisiteur currentUser) throws IOException {

		setTitle("Galaxy Swiss Bourdin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\gsb.png"));
		setResizable(false);
		setBounds(100, 100, 453, 632);
		
		// récupération des données de ObjtVisiteur
		String login = currentUser.getLogin();
		String id = currentUser.getId();
		String region = currentUser.getRegion();
		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(SystemColor.white);
		menuBar.setBackground(Color.white);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Réglages");
		mnNewMenu.setForeground(Color.black);
		mnNewMenu.setBackground(Color.white);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItemLog = new JMenuItem("Bienvenue "+login+" !");
		mntmNewMenuItemLog.setForeground(SystemColor.white);
		mntmNewMenuItemLog.setBackground(Color.black);
		 
		mnNewMenu.add(mntmNewMenuItemLog);
		
		JMenuItem mntmNewMenuItemLog2 = new JMenuItem("Votre numéro employé(e) : "+id+" ");
		mntmNewMenuItemLog2.setForeground(SystemColor.white);
		mntmNewMenuItemLog2.setBackground(Color.black);
		 
		mnNewMenu.add(mntmNewMenuItemLog2);
		
		JMenuItem mntmNewMenuItemLog3 = new JMenuItem("Votre région : "+region+" ");
		mntmNewMenuItemLog3.setForeground(SystemColor.white);
		mntmNewMenuItemLog3.setBackground(Color.black);
		 
		mnNewMenu.add(mntmNewMenuItemLog3);
		
		JMenuItem mntmNewMenuItem8 = new JMenuItem("Répertoire des saisies");
		mntmNewMenuItem8.setForeground(SystemColor.white);
		mntmNewMenuItem8.setBackground(Color.black);
		mntmNewMenuItem8.addActionListener(new ActionListener() {
      
			public void actionPerformed(ActionEvent e) {
				Home.ouvrirFenetreRepertoire();
				
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem8);
		
		JMenuItem mntmNewMenuItem78 = new JMenuItem("Ouvrir Editor");
		mntmNewMenuItem78.setForeground(SystemColor.white);
		mntmNewMenuItem78.setBackground(Color.black);
		mntmNewMenuItem78.addActionListener(new ActionListener() {
      
			public void actionPerformed(ActionEvent e) {
				Home.ouvrirFenetreEditor();	
					}
				});
		
		mnNewMenu.add(mntmNewMenuItem78);

		mnNewMenu.addSeparator(); // séparateur dans le menu "Réglages"
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A propos | Vérifier les mises à jour");
		 mntmNewMenuItem.setForeground(SystemColor.white);
		 mntmNewMenuItem.setBackground(Color.black);
		mntmNewMenuItem.addActionListener(new ActionListener() {
       
			public void actionPerformed(ActionEvent e) {
				Home.ouvrirFenetreMaj(currentUser);
					}
				});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Déconnexion");
		mntmNewMenuItem_2.setForeground(SystemColor.white);
		mntmNewMenuItem_2.setBackground(Color.black);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							Home.ouvrirFenetreMain();
			}
		});
	        
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quitter l'application");
		mntmNewMenuItem_1.setForeground(SystemColor.white);
		mntmNewMenuItem_1.setBackground(Color.black);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	        
		mnNewMenu.add(mntmNewMenuItem_1);
		
		//Compatibilité pour MACOS
		
		 JLabel lblNewLabel_2 = new JLabel("Galaxy Swiss Bourdin   ");
		menuBar.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(SystemColor.white);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setForeground(SystemColor.white);
		
		// Fin de la compatibilité pour macOS
		 
		
		//Compatibilité pour WINDOWS
		/*
		JLabel lblNewLabel_2 = new JLabel("Galaxy Swiss Bourdin   ");
		menuBar.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(SystemColor.black);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setForeground(SystemColor.black);
		*/
		// Fin de la compatibilité pour Windows
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		// Menu principal avec une condition sur la fonction de l'utilisateur connecté
		JButton btnNewButton_4 = new JButton("Espace Visiteur");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_4, -418, SpringLayout.SOUTH, contentPane);
		btnNewButton_4.setForeground(SystemColor.text);
		btnNewButton_4.setBackground(SystemColor.black);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Condition d'accès
				if(currentUser.getFonction().equals("visiteur")|| currentUser.getFonction().equals("admin") ) {
					// Si OK ouverture de la Frame
				Home.ouvrirFenetreVisiteur(currentUser);
				}else {
					// Si NOK message d'erreur
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Vous n'avez pas les droits d'accès !", "GSB", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("Espace Déléguer");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 163, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -317, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btnNewButton_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, btnNewButton_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, -15, SpringLayout.EAST, contentPane);
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.setBackground(SystemColor.black);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentUser.getFonction().equals("deleguer") || currentUser.getFonction().equals("admin") ) {
				Home.ouvrirFenetreDeleguer(currentUser);
				}else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Vous n'avez pas les droits d'accès !", "GSB", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Espace Responsable");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -205, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -15, SpringLayout.EAST, contentPane);
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(SystemColor.black);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentUser.getFonction().equals("responsable") || currentUser.getFonction().equals("admin") ) {
				Home.ouvrirFenetreResponsable(currentUser);
				}else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Vous n'avez pas les droits d'accès !", "GSB", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Espace Analyse");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 391, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -22, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -15, SpringLayout.EAST, contentPane);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.black);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentUser.getFonction().equals("deleguer") || currentUser.getFonction().equals("admin") ) {
				Home.ouvrirFenetreAnalyse(currentUser);
				}else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Vous n'avez pas les droits d'accès !", "GSB", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		// Titre dans le menu principal
		JLabel lblNewLabel_1_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -232, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, 20, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 10, SpringLayout.NORTH, contentPane);
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Analyses des employés  ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 20, SpringLayout.SOUTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnNewButton_4);
		lblNewLabel.setForeground(SystemColor.black);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saisies et consultations des données ");
		lblNewLabel_1.setForeground(SystemColor.black);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, btnNewButton_4);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Consultations des données  ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 142, SpringLayout.NORTH, contentPane);
		lblNewLabel_3.setForeground(SystemColor.black);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, btnNewButton_4);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gestions des données et analyse d'une région ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 13, SpringLayout.SOUTH, lblNewLabel_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -292, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, btnNewButton_4);
		lblNewLabel_4.setForeground(SystemColor.black);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		contentPane.add(lblNewLabel_4);
		
	}
	
	// Procédure d'ouverture pour "Visiteur"
    private static Visiteur frameVisiteur;
    
    public static Visiteur getFenetreVisiteur() {
             return frameVisiteur; 
    }
 
    public static boolean fenetreVisiteurEstOuverte() {
             return frameVisiteur!=null ; 
    }
 
     public static Visiteur ouvrirFenetreVisiteur(ObjtVisiteur currentUser) {
             if ( frameVisiteur==null ) {
            	 try {
					frameVisiteur =new Visiteur(currentUser);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
             frameVisiteur.setVisible(true);
             return frameVisiteur;
    }
     
     // Procédure d'ouverture pour "Deleguer"
     private static Deleguer frameDeleguer;
     
     public static Deleguer getFenetreDeleguer() {
              return frameDeleguer; 
     }
  
     public static boolean fenetreDeleguerEstOuverte() {
              return frameDeleguer!=null ; 
     }
     
     public static Deleguer ouvrirFenetreDeleguer(ObjtVisiteur currentUser) {
         if ( frameDeleguer==null ) {
        	 try {
				frameDeleguer =new Deleguer(currentUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         frameDeleguer.setVisible(true);
         return frameDeleguer;
}
     
// Début des procédure Partie 2    
// Procédure d'ouverture pour "Analyse"    
 private static Analyse frameAnalyse;
 
 public static Analyse getFenetreAnalyse() {
          return frameAnalyse; 
 }

 public static boolean fenetreAnalyseEstOuverte() {
          return frameAnalyse!=null ; 
 }
 
 public static Analyse ouvrirFenetreAnalyse(ObjtVisiteur currentUser) {
     if ( frameAnalyse==null ) {
    	 try {
			frameAnalyse =new Analyse(currentUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     frameAnalyse.setVisible(true);
     return frameAnalyse;
}
 
 // Procédure d'ouverture pour "Responsable"
 private static Responsable frameResponsable;
 
 public static Responsable getFenetreResponsable() {
          return frameResponsable; 
 }

 public static boolean fenetreResponsableEstOuverte() {
          return frameResponsable!=null ; 
 }
 
 public static Responsable ouvrirFenetreResponsable(ObjtVisiteur currentUser) {
     if ( frameResponsable==null ) {
    	 try {
			frameResponsable =new Responsable(currentUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     frameResponsable.setVisible(true);
     return frameResponsable;
}
 
 // Procédure d'ouverture de la Frame pour les mise à jour de l'application GSB
 private static Maj frameMaj;
    
    public static Maj getFenetreMaj() {
             return frameMaj; 
    }
 
    public static boolean fenetreMajEstOuverte() {
             return frameMaj!=null ; 
    }
    
    public static Maj ouvrirFenetreMaj(ObjtVisiteur currentUser) {
        if ( frameMaj==null ) {
        	 try {
        		 frameMaj =new Maj(currentUser);
     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }
        frameMaj.setVisible(true);
        return frameMaj;
    }
// Fin des procédures Partie 2
}
