package InterfaceG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Analyse extends JFrame {
	
	//Début des procédures
	// procédure d'ouverture de "Activiteemploye" correspondant au graphique en fonction de l'employé(e) sélectionné(e) 
    private static Activiteemploye frameActiviteemployee;
    
    public static Activiteemploye getFenetreActiviteemploye() {
             return frameActiviteemployee; 
    }
 
    public static boolean fenetreActiviteemployeEstOuverte() {
             return frameActiviteemployee!=null ; 
    }
    
    public static Activiteemploye ouvrirFenetreActiviteemploye(ObjtVisiteur currentUser){
        if ( frameActiviteemployee==null ) {
        	try {
				frameActiviteemployee =new Activiteemploye(currentUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        frameActiviteemployee.setVisible(true);
        return frameActiviteemployee;
}
//Fin des procédures
    
	private JPanel contentPane;

	public Analyse(ObjtVisiteur currentUser) throws IOException{
		
		setResizable(false);
		setTitle("Analyse");
		setBounds(100, 100, 450, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(1190,615);
		setResizable(false);
		
		JButton btnNewButton = new JButton("Graphiques en fonction d'un(e) l'employé(e) ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setForeground(SystemColor.black);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Analyse.ouvrirFenetreActiviteemploye(currentUser);
			}
		});
		
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 566, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 1160, SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(btnNewButton);
		
		JLabel lblGalaxySwissBourdin = new JLabel("Galaxy Swiss Bourdin");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGalaxySwissBourdin, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblGalaxySwissBourdin, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGalaxySwissBourdin, 1189, SpringLayout.WEST, contentPane);
		lblGalaxySwissBourdin.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblGalaxySwissBourdin);
	}

}
