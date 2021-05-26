package InterfaceG;

import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*; 
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 
import org.jfree.data.*;
import org.jfree.data.category.DefaultCategoryDataset; 

/*
 * NOTE 
 * 
 * Dans la classe "Activiteemploye", les diagrammes sont s�par�s en deux parties.
 * Une partie Echantillon == 0
 * Une autre partie Echantillon != 0
 * 
 * Chaque partie contient sa propre frame
 */

  public class Activiteemploye extends JFrame {
//D�but des proc�dures
// proc�dure d'ouverture de "Activiteemploye" correspondant au graphique en fonction de l'employ�(e) s�lectionn�(e) 
			  private static Activiteemploye frameActiviteemploye;
			    
			    public static Activiteemploye getFenetreActiviteemploye() {
			             return frameActiviteemploye; 
			    }
			 
			    public static boolean fenetreActiviteemployeEstOuverte() {
			             return frameActiviteemploye!=null ; 
			    }
			    
			    public static Activiteemploye ouvrirFenetreActiviteemploye(ObjtVisiteur currentUser) {
			        if ( frameActiviteemploye==null ) {
			        	try {
							frameActiviteemploye =new Activiteemploye(currentUser);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        frameActiviteemploye.setVisible(true);
			        return frameActiviteemploye;
			}
			    
// proc�dure d'ouverture de "Editor", traitement de texte de GSB, qui permet d'imprimer 
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

  private static Component frame;

  public Activiteemploye(ObjtVisiteur currentUser) throws IOException {

      Component frame = null;
  JOptionPane.showMessageDialog(frame, "Si plusieurs comptes rendus ont �t� saisis par l'employ�(e), vous obtiendrez plusieurs graphiques !", "GSB", JOptionPane.WARNING_MESSAGE);

  // Connexion Base de donn�es
    try (
             Connection conn = DriverManager.getConnection(
            		 // Connexion à la base de données (Supprimée pour des raisons de sécurité)
    		
    		 Statement stmt = conn.createStatement();
		     ) {
    	//Demande � l'utilisateur du num�ro d'employ�(e)
    	 ImageIcon icon = new ImageIcon("");
         Object anchor = null;
         Object[] eventCache = null;
         String employee = (String) JOptionPane.showInputDialog(null, "Entrer le num�ro d'employ�(e) � analyser (Utilisez le \"Repertoire des saisies\" (Accueil > R�glages > Repertoire des saisies) :", 
                "GSB", JOptionPane.QUESTION_MESSAGE, icon, eventCache, anchor);
         // requ�te
         String strSelect = "SELECT `compte`, `echantillon`, `employe`, `nbdon`, `echantillon`, `region` FROM `donnee` WHERE employe = "+employee+"";
 
         ResultSet rset = stmt.executeQuery(strSelect);
         // r�cup�ration des donn�es
         while(rset.next()) {  
        	 
        	String id = rset.getString("employe");
        	String sos = rset.getString("compte");
        	String echantillon = rset.getString("echantillon");
            String place = rset.getString("nbdon");
            String echan = rset.getString("echantillon");
            String lieu = rset.getString("region");
            
            // transformation du String en Float
            float echant;
            echant=Float.parseFloat(place.toString());
            
            //Graphique
            JFreeChart chart = null;
            
            //Cas �chantillon strictement �gal � 0
            if(echant == 0) { 
            	//Frame
                ChartFrame frame1 = new ChartFrame("Analyse par employ�(e)", chart);
                frame1.pack();
                frame1.setVisible(true);
                frame1.setResizable(true);
                frame1.setSize(950, 650); 
                frame1.setBackground(Color.WHITE);
                
                JMenuBar menuBar2 = new JMenuBar();
                menuBar2.setForeground(SystemColor.white);
                menuBar2.setBackground(Color.white);
                frame1.setJMenuBar(menuBar2);
                
                JMenu mnNewMenu2 = new JMenu("Gestion des analyses");
                mnNewMenu2.setForeground(Color.black);
                mnNewMenu2.setBackground(Color.white);
                menuBar2.add(mnNewMenu2);
                
                JMenuItem mntmNewMenuItem2 = new JMenuItem("R�aliser une nouvelle analyse");
                mntmNewMenuItem2.setForeground(SystemColor.white);
                mntmNewMenuItem2.setBackground(Color.black);
                mntmNewMenuItem2.addActionListener(new ActionListener() {
                 
                  public void actionPerformed(ActionEvent e) {
                    Activiteemploye.ouvrirFenetreActiviteemploye(currentUser); 
                  	}
                });
                
                mnNewMenu2.add(mntmNewMenuItem2);
                
                JMenuItem mntmNewMenuItem3 = new JMenuItem("R�aliser une impression");
                mntmNewMenuItem3.setForeground(SystemColor.white);
                mntmNewMenuItem3.setBackground(Color.black);
                mntmNewMenuItem3.addActionListener(new ActionListener() {
                 
                  public void actionPerformed(ActionEvent e) {
                	  Activiteemploye.ouvrirFenetreEditor();
                  }
                });
                
                mnNewMenu2.add(mntmNewMenuItem3);
                
                
                //Mise en place du graphique
                DefaultCategoryDataset data = new DefaultCategoryDataset(); 
                data.setValue(0, ""+place+" �chantillon(s) offert(s) pour la r�gion "+lieu+" � la soci�t� : "+sos+"","Agent : "+id+"");
              

                JFreeChart barChart = ChartFactory.createBarChart("Evolution du nombre d'�chantillon offert par l'employ�(e) : "+id+" � la soci�t� : "+sos+"", "Galaxy Swiss Bourdin", 
                  "Quantit�", data, PlotOrientation.VERTICAL, true, true, true); 
                ChartPanel cPanel = new ChartPanel(barChart); 
                frame1.add(cPanel); 
                
             //Cas �chantillon diff�rent de 0
            }else{   
            	// transformation du String en Float
                float nombre;
                  nombre=Float.parseFloat(place.toString());
        //Frame
        ChartFrame frame1 = new ChartFrame("Analyse par employ�(e)", chart);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setResizable(true);
        frame1.setSize(950, 650);
        frame1.setBackground(Color.WHITE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(SystemColor.white);
        menuBar.setBackground(Color.white);
        frame1.setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Gestion des analyses");
        mnNewMenu.setForeground(Color.black);
        mnNewMenu.setBackground(Color.white);
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("R�aliser une nouvelle analyse");
         mntmNewMenuItem.setForeground(SystemColor.white);
         mntmNewMenuItem.setBackground(Color.black);
        mntmNewMenuItem.addActionListener(new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
            Activiteemploye.ouvrirFenetreActiviteemploye(currentUser);
            
          }
        });
        
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem3 = new JMenuItem("R�aliser une impression");
        mntmNewMenuItem3.setForeground(SystemColor.white);
        mntmNewMenuItem3.setBackground(Color.black);
        mntmNewMenuItem3.addActionListener(new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
        	  Component frame = null;
				JOptionPane.showMessageDialog(frame,"Utilisez le logiciel \"Editor 1.0 de GSB\" pour imprimer !");
          	}
        });
        
        mnNewMenu.add(mntmNewMenuItem3);
        
        //Mise en place du graphique
        DefaultCategoryDataset data = new DefaultCategoryDataset(); 
        data.setValue(nombre, ""+place+" �chantillon(s) offert(s) dans la r�gion "+lieu+" � la soci�t� : "+sos+"","Agent : "+id+"");

        JFreeChart barChartt = ChartFactory.createBarChart("Evolution du nombre d'�chantillon offert par l'employ�(e) : "+id+" � la soci�t� : "+sos+"", "Galaxy Swiss Bourdin", 
          "Quantit�", data, PlotOrientation.VERTICAL, true, true, true); 
        ChartPanel cPanell = new ChartPanel(barChartt); 
        frame1.add(cPanell);  
            }
         }
  
      } catch(SQLException ex) {
         ex.printStackTrace();
      } 
  }

  public void setVisible(boolean b) {
    // TODO Auto-generated method stub
    
  }
}
