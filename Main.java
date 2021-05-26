package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.SystemColor;
import java.io.IOException;

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
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.Component;

public class Main extends JFrame {

	private static Home frameHome;
	public static String statut;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
		JTextField loginField = new JTextField();
		JPasswordField passField = new JPasswordField();
		
		setResizable(false);
		setTitle("Galaxy Swiss Bourdin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 629);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Bienvenue  ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 94, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 78, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -436, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -61, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 48));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Galaxy Swiss Bourdin  ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, contentPane);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setForeground(SystemColor.black);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2.0.1");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_2, -362, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel_2);
		
		Button button = new Button("Se connecter");
		
		sl_contentPane.putConstraint(SpringLayout.NORTH, loginField, 269, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, loginField);
		sl_contentPane.putConstraint(SpringLayout.WEST, loginField, 123, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, loginField, -126, SpringLayout.EAST, contentPane);
		contentPane.add(loginField);
		
	
		sl_contentPane.putConstraint(SpringLayout.NORTH, passField, 357, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, passField, 123, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, passField, -195, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, passField, -126, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 54, SpringLayout.SOUTH, passField);
		contentPane.add(passField);
		
		JLabel lblNewLabel_3 = new JLabel("Login ");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, button);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, loginField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 175, SpringLayout.WEST, button);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(lblNewLabel_3);
		
        JLabel passFiel_Label = new JLabel("Password  ");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, passFiel_Label, -34, SpringLayout.NORTH, passFiel_Label);
		sl_contentPane.putConstraint(SpringLayout.EAST, passFiel_Label, 175, SpringLayout.WEST, button);
		sl_contentPane.putConstraint(SpringLayout.WEST, passFiel_Label, 0, SpringLayout.WEST, button);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, passFiel_Label, -6, SpringLayout.NORTH, passField);
		passFiel_Label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(passFiel_Label);
	      	  
		
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 16, SpringLayout.WEST, button);
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 123, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button, -104, SpringLayout.SOUTH, contentPane);
		button.setForeground(SystemColor.black);
		button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		button.setBackground(SystemColor.white);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String loginG = loginField.getText();
				 String password = passField.getText();
				 
				//System.out.println(loginG + password);
				
				ObjtVisiteur currentUser = new ObjtVisiteur();
				try {
					currentUser = ConnectionBdd.ConnectionVisiteur(loginG, password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(!currentUser.getFonction().isEmpty()) {
							// Ouverture de "Home" si les conditions sont remplies
							Main.ouvrirFenetreHome(currentUser);
				}else{
							// Si les conditions ne sont pas remplies message d'erreur
							Component frame = null;
							JOptionPane.showMessageDialog(frame, "Mot de passe incorrect !", "GSB", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(button);
	}
	
	//Début des procédures
	// procédure d'ouverture de "Home"
	public static Home getFenetreHome() {
         return frameHome; 
	}

	public static boolean fenetreHomeEstOuverte() {
         return frameHome!=null ; 
	}

	public static JFrame ouvrirFenetreHome(ObjtVisiteur currentUser) {
         if ( frameHome==null ) {
        	 try {
				frameHome =new Home(currentUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         frameHome.setVisible(true);
         return frameHome;
	}
	// Fin des procédures
}