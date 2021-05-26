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
import org.jfree.data.category.DefaultCategoryDataset; 

/*
 * NOTE 
 * 
 * Dans la classe "Frst", les diagrammes sont s�par�s en deux parties.
 * Une partie Echantillon == 0
 * Une autre partie Echantillon != 0
 * 
 * Chaque partie contient sa propre frame
 */

  public class First extends JFrame {
	//D�but des proc�dures
	// proc�dure d'ouverture de "First", permet de r�aliser une nouvelle analyse
	    private static First frameFirst;
	    
	    public static First getFenetreFirst() {
	             return frameFirst; 
	    }
	 
	    public static boolean fenetreFirstEstOuverte() {
	             return frameFirst!=null ; 
	    }
	    
	    public static First ouvrirFenetreFirst(ObjtVisiteur currentUser) {
	        if ( frameFirst==null ) {
	       	 try {
				frameFirst =new First(currentUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	        frameFirst.setVisible(true);
	        return frameFirst;
	}
	    
	 // proc�dure d'ouverture de "Editor", ouvre l'�diteur de texte inclus dans GSB
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
	 // Fin des proc�dures
  private static Component frame;

  public First(ObjtVisiteur currentUser) throws IOException {
	  
      // Message � l'utilisateur
      Component frame = null;
      JOptionPane.showMessageDialog(frame, "Vous retrouverez un graphique par intervention de l'employ�(e) dans sa r�gion !", "GSB", JOptionPane.WARNING_MESSAGE);
       
      // Connexion � la Base de donn�es
        try (
             Connection conn = DriverManager.getConnection(
            		// Connexion à la base de données (Supprimée pour des raisons de sécurité)
    		
    		 Statement stmt = conn.createStatement();
		     ) {
        	
       // Message pour l'utilisateur lui demandant le num�ro de r�gion, qui sera renvoy� dans la requ�te
    	 ImageIcon icon = new ImageIcon("");
         Object anchor = null;
         Object[] eventCache = null;
         String region = (String) JOptionPane.showInputDialog(null, "Entrer le num�ro de r�gion � analyser (Utilisez le \"Repertoire des saisies\" (Accueil > R�glages > Repertoire des saisies) :", 
                 "GSB", JOptionPane.QUESTION_MESSAGE, icon, eventCache, anchor);
	  
           String strSelect = "SELECT `compte`, `echantillon`, `employe`, `nbdon`, `echantillon`, `region` FROM `donnee` WHERE region = "+region+"";
 
         ResultSet rset = stmt.executeQuery(strSelect);

         while(rset.next()) {  
        	 
        	String id = rset.getString("employe");
        	String sos = rset.getString("compte");
        	String echantillon = rset.getString("echantillon");
            String place = rset.getString("nbdon");
            String echan = rset.getString("echantillon");
            String lieu = rset.getString("region");
            
            // Passage d'un String � un Float
            float echant;
            echant=Float.parseFloat(place.toString());
            JFreeChart chart = null;
            
            // Cas �chantillon strictement �gal � 0
            if(echant == 0) {  
            	
            	//Frame
                ChartFrame frame1 = new ChartFrame("Analyse par r�gion", chart);
                frame1.pack();
                frame1.setVisible(true);
                frame1.setResizable(true);
                frame1.setSize(950, 650); 
                frame1.setBackground(Color.WHITE);
                
                // Menu
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
                    First.ouvrirFenetreFirst(currentUser);
                    	}
                	});
                
                mnNewMenu2.add(mntmNewMenuItem2);
                
                JMenuItem mntmNewMenuItem3 = new JMenuItem("R�aliser une impression");
                mntmNewMenuItem3.setForeground(SystemColor.white);
                mntmNewMenuItem3.setBackground(Color.black);
                mntmNewMenuItem3.addActionListener(new ActionListener() {
                 
                  public void actionPerformed(ActionEvent e) {
                	First.ouvrirFenetreEditor();
                  }
                });
                
                mnNewMenu2.add(mntmNewMenuItem3);
                
                // R�alisation du graphique
                DefaultCategoryDataset data = new DefaultCategoryDataset(); 
                data.setValue(0, ""+place+" �chantillon(s) offert(s) pour la r�gion "+lieu+" � la soci�t� : "+sos+"","Agent : "+id+"");

                JFreeChart barChart = ChartFactory.createBarChart("Evolution du nombre d'�chantillon offert par l'employ�(e) : "+id+" dans la r�gion : "+region+"", "Galaxy Swiss Bourdin", 
                  "Quantit�", data, PlotOrientation.VERTICAL, true, true, true); 
                ChartPanel cPanel = new ChartPanel(barChart); 
                frame1.add(cPanel); 
                
                // Cas �chantillon diff�rent de 0
            	}else{ 
            	
                // Passage d'un String � un Float
                float nombre;
                nombre=Float.parseFloat(place.toString());
        // Frame
        ChartFrame frame1 = new ChartFrame("Analyse par r�gion", chart);
        frame1.pack();
        frame1.setVisible(true);
        frame1.setResizable(true);
        frame1.setSize(950, 650);
        frame1.setBackground(Color.WHITE);
        
        // Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(SystemColor.white);
        menuBar.setBackground(Color.white);
        frame1.setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Gestion des analyses");
        mnNewMenu.setForeground(Color.black);
        mnNewMenu.setBackground(Color.white);
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem2 = new JMenuItem("R�aliser une nouvelle analyse");
        mntmNewMenuItem2.setForeground(SystemColor.white);
        mntmNewMenuItem2.setBackground(Color.black);
        mntmNewMenuItem2.addActionListener(new ActionListener() {
         
          public void actionPerformed(ActionEvent e) {
            First.ouvrirFenetreFirst(currentUser);
          		}
        	});
        
        mnNewMenu.add(mntmNewMenuItem2);
        
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
        
        // R�alisation du graphique
        DefaultCategoryDataset data = new DefaultCategoryDataset(); 
        data.setValue(nombre, ""+place+" �chantillon(s) offert(s) dans la r�gion "+lieu+" � la soci�t� : "+sos+"","Agent : "+id+"");

        JFreeChart barChartt = ChartFactory.createBarChart("Evolution du nombre d'�chantillon offert par l'employ�(e) : "+id+" dans la r�gion : "+region+"", "Galaxy Swiss Bourdin", 
          "Quantit�", data, PlotOrientation.VERTICAL, true, true, true); 
        ChartPanel cPanell = new ChartPanel(barChartt); 
        frame1.add(cPanell);  
            	}
         	}
      // Fin de connexion � la base de donn�es
      } catch(SQLException ex) {
         ex.printStackTrace();
      } 

  }

  public void setVisible(boolean b) {
    // TODO Auto-generated method stub
    
  }
}
