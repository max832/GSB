package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import java.awt.Canvas;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Visiteur extends JFrame {
  
	private JPanel contentPane;

	public Visiteur(ObjtVisiteur currentUser) throws IOException {

		setBackground(Color.WHITE);
		setTitle("Visiteur");
		setBounds(100, 100, 730, 178);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(1460,600);
		setResizable(false);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblGalaxySwissBourdin = new JLabel("Galaxy Swiss Bourdin");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGalaxySwissBourdin, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGalaxySwissBourdin, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGalaxySwissBourdin, 1189, SpringLayout.WEST, contentPane);
		contentPane.add(lblGalaxySwissBourdin);
		lblGalaxySwissBourdin.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btnNewButton_1 = new JButton("Saisie un compte rendu");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -466, SpringLayout.EAST, contentPane);
		btnNewButton_1.setForeground(SystemColor.black);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 566, SpringLayout.NORTH, contentPane);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjtVisiteur currentUser = new ObjtVisiteur();
				Visiteur.ouvrirFenetreSaisiecptrendu(currentUser);
					}
				});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Consultation des donn�es saisies");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, -5, SpringLayout.EAST, contentPane);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_3.setForeground(SystemColor.black);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 566, SpringLayout.NORTH, contentPane);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjtVisiteur currentUser = new ObjtVisiteur();
				Visiteur.ouvrirFenetreConsult(currentUser);
					}
				});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Synth�se du travail saisie");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, 418, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, contentPane);
		btnNewButton_4.setForeground(SystemColor.black);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 566, SpringLayout.NORTH, contentPane);
		btnNewButton_4.setBackground(Color.white);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjtVisiteur currentUser = new ObjtVisiteur();
				Visiteur.ouvrirFenetreSynth(currentUser);
					}
				});
		contentPane.add(btnNewButton_4);
		
	}
	//D�but des proc�dures
	// proc�dure d'ouverture de "Saisiecptrendu"
    private static Saisiecptrendu frameSaisiecptrendu;
    
    public static Saisiecptrendu getFenetreSaisiecptrendu() {
             return frameSaisiecptrendu; 
    }
 
    public static boolean fenetreSaisiecptrenduEstOuverte() {
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

 // proc�dure d'ouverture de "Consult"
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
			frameSynth = new Synth(currentUser);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
        }
        frameSynth.setVisible(true);
        return frameSynth;
}
  // Fin des proc�dures
    
}
