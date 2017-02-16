import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class PilotTaskMessageNew {
	  public static int briefingCloseButtonPressed=0;
	public static void main(String[] args) {

		initGUI();
		
	}
	private static void initGUI() {
		// TODO Auto-generated method stub
		
		//////***********************************
		
		 String briefingText="";
	        
	        String scenarioPath = JarPath.getClassPath() +"scenarios//";
	        //	        ArrayList<String> briefing= loadBriefing(scenarioPath+Sea.scenarioName);

	        ArrayList<String> briefing= loadBriefing(scenarioPath+"Demo.xml");
	        briefingText = briefingText + briefing.get(1);
	       
	        
	   //     taskTextPane.setEditable(false);
	        
	      
	        BufferedImage image =  null;  
	        try {
				image = Utilities.getScaledImage(ImageIO.read(new File("images/"+briefing.get(0))),Integer.parseInt(briefing.get(2)),Integer.parseInt(briefing.get(3)));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        ImageIcon icon = new ImageIcon(image);
		
		
		
		
	//*******************************************************************************	
		
	JButton close = new JButton("Close");
	JTextArea text= new JTextArea();
	//ImageIcon icon = new ImageIcon("battleship.png");
	//Image image = icon.getImage(); // transform it 
//	Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	//icon = new ImageIcon(newimg); 
	JLabel label = new JLabel(icon);
	text.append(briefingText);
	
	 text.setEditable ( false ); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane ( text );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	JPanel butn = new JPanel();
	butn.setLayout(new FlowLayout());
	butn.add(close);
	
	

	JPanel rightpanel = new JPanel();
	rightpanel.setLayout(new BorderLayout());
	rightpanel.add(scroll,BorderLayout.CENTER);
	rightpanel.add(butn,BorderLayout.SOUTH);
	

	
	 JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	 splitPane.setResizeWeight(0.99);
     splitPane.setEnabled(false);
     splitPane.setDividerSize(0);
     splitPane.setDividerLocation(1010);
     splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
     splitPane.setRightComponent(rightpanel);
     splitPane.setLeftComponent(label);
	
     JPanel content = new JPanel();
	 content.setLayout(new BorderLayout());
     content.add(splitPane, BorderLayout.CENTER);
	
	JFrame f1 = new JFrame();
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	f1.getContentPane();
	
	f1.setContentPane(content);
	f1.pack();
	f1.setSize(1385,765);
	f1.setResizable(false);
	f1.setLocationRelativeTo(null);
	//f1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	//f1.setUndecorated(true);
	f1.setVisible(true);
	f1.setTitle("Pilot Task Instructions");
	
	close.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            closeActionPerformed(evt);
        }
    });

		
		
	}
	private static void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    	briefingCloseButtonPressed+=1;
	
    	System.exit(0);
		
    }
	 static ArrayList<String> loadBriefing (String scenarioFileName){
			
			
			ArrayList<String> briefing = new ArrayList<String>();
			
			String imagepath="";
			String imagetext="";
			String sizeX="";
			String sizeY="";
			
			try {

				//JarPath.getClassPath().replace('\', '\\');
						
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document document = documentBuilder.parse(scenarioFileName);
				document.getDocumentElement().normalize();
				
				NodeList nList = document.getElementsByTagName("img");

				for (int i = 0; i < nList.getLength(); i++) {

					
					Node nNode = nList.item(i);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
							
					imagepath = eElement.getAttribute("src");
					imagetext = eElement.getAttribute("text");
					sizeX=eElement.getAttribute("sizeX");
					sizeY = eElement.getAttribute("sizeY");
					
					briefing.add(imagepath);
					briefing.add(imagetext);
					briefing.add(sizeX);
					briefing.add(sizeY);
			    	
			    	
			    	
			    	 
			    	}
				} // finish looping on node list
	

			
			}catch (Exception pce) {
				pce.printStackTrace();
			}
			return briefing; 
			}
	 }

