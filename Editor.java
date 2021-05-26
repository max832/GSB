package InterfaceG;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.IOException;
 
public class Editor extends JFrame {
	
	 private static void imprimer(JTextArea zoneDeTexte, MessageFormat entete, MessageFormat basDePage){

      try {
		zoneDeTexte.print(entete, basDePage, true, null, null, true);
      		} catch (PrinterException e) {
		// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
         
         }
         
	 public static void main(String[] args) {
			try {
				Editor frame = new Editor();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 
   public Editor() {
	   
	  // Message
	  Component frame2 = null;
		JOptionPane.showMessageDialog(frame2,"Ecrivez vos textes ou Copier / Coller vos textes ici, puis cliquez sur \"Menu\" puis sur \"imprimer\" !","Bienvenue sur EDITOR !", 1);
	  
	  // Zone de saisie
    final JTextArea zoneText = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane(zoneText);
    final MessageFormat hautDePage = new MessageFormat("Galaxy Swiss Bourdin");
    final MessageFormat basDePage = new MessageFormat("Rapport GSB confidentiel");
    
    // Menu
    JMenuBar menuBar2 = new JMenuBar();
    menuBar2.setForeground(SystemColor.white);
    menuBar2.setBackground(Color.white);

    // Sous-menu 1
    JMenu mnNewMenu2 = new JMenu("Menu");
    mnNewMenu2.setForeground(Color.black);
    mnNewMenu2.setBackground(Color.white);
    menuBar2.add(mnNewMenu2);
    
    // Sous-menu 2
    JMenuItem mntmNewMenuItem3 = new JMenuItem("Imprimer");
    mntmNewMenuItem3.setForeground(SystemColor.white);
    mntmNewMenuItem3.setBackground(Color.black);
    mntmNewMenuItem3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
    	  imprimer(zoneText, hautDePage, basDePage);
      		}
    	});
    mnNewMenu2.add(mntmNewMenuItem3);
    
    // Sous-menu 4
    JMenuItem mntmNewMenuItem4 = new JMenuItem("A Propos");
    mntmNewMenuItem4.setForeground(SystemColor.white);
    mntmNewMenuItem4.setBackground(Color.black);
    mntmNewMenuItem4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 Component frame = null;
				JOptionPane.showMessageDialog(frame,"GSB : Editor 1.0 for Galaxy Swiss Bourdin");
				}
		});
    mnNewMenu2.add(mntmNewMenuItem4);
    
    // Fenêtre
    JPanel contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(jScrollPane, BorderLayout.CENTER);
    contentPane.add(menuBar2, BorderLayout. NORTH);
    setTitle("Editor");
    setSize(800, 800);
    setContentPane(contentPane);
    setVisible(true);
  }
}