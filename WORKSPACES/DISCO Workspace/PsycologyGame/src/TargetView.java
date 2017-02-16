
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TargetView extends JPanel {

	GridBagConstraints gbc = new GridBagConstraints();
	private JLabel targetInspectionLabel;
	private JLabel selectIdentity;
	
	private JTextArea targetDescriptionTextArea;
	
	
	private JComboBox trueIdentityComboBox;
	
	private JButton submitButton;
	private JButton closeButton;
	
	Load load;
    UnitsController controller;
    Target target = null;
	public boolean low = false;
	public boolean high = false;
	public BufferedImage image;
	static JFrame f;
	
	public static int targetDetectionSubmitButtonPressed=0;
	public static int targetDetectionCloseButtonPressed=0;
	double markingBonusForHighPriority = Integer.parseInt(ConfigProps.MB_POINTS_HIGH);
	double markingBonusForLowPriority = Integer.parseInt(ConfigProps.MB_POINTS_LOW);
	double firstContactPoints = Integer.parseInt(ConfigProps.FC_POINTS);
	String trueIdentity="";
	
	static ArrayList<String> firstContactArray = new ArrayList<String>();
	static ArrayList<String> markingBonusArray = new ArrayList<String>();
	String targetID="";
	String priority ="";
	
	String description = "";



	public TargetView(Load load, UnitsController controller) {

		
		this.load = load;
		this.controller = controller;
		trueIdentity = this.controller.target.trueIdentity;
		targetID = String.valueOf(this.controller.target.id);

		description = this.controller.target.description;
		priority = this.controller.target.priority;
		this.controller.target.setTargetdetected(true);
		if(!firstContactArray.contains(targetID)){
			if(Load.activityFeed.getNewTargetInspect().equals("Y"))
			Sea.updatesTextArea.append("Target Detection - A New Target ( " + this.controller.target.id + " ) is currently being viewed" + "\n\n");
			
			firstContactArray.add(targetID);
			String label = Sea.targetInterceptedTitleLabel.getText();
			
			String[] arrLabel = label.split(":");
			
			double currentScore = Double.parseDouble(arrLabel[1]);
			
			currentScore = currentScore + firstContactPoints;
			
			for(int i=0;i<Load.targetList.size();i++){
    			if(targetID.equals(Load.targetList.get(i).id)){
    				Load.targetList.get(i).scoreGenerated += firstContactPoints;
    			}
    		}
			
			Sea.targetInterceptedTitleLabel.setText("Score:"+currentScore);
		}else{
			if(Load.activityFeed.getOldTargetInspect().equals("Y"))
			Sea.updatesTextArea.append("Target Detection - A Detected Target ( " + this.controller.target.id + " ) is currently being viewed" + "\n\n");
		}
		
		initGUI();
		doTheLayout();
		
		
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
targetDetectionCloseButtonPressed+=1;
				
			
				
				
                cancelButtonActionPerformed(evt);
            }
            
            
            
            private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
                // TODO add your handling code here:
            	dispose();
            }//GEN-LAST:event_cancelButtonActionPerformed



			
        });
		
		
		
		submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	
            	
targetDetectionSubmitButtonPressed+=1;
				
			
				
				
            	
            	String selectedTrueIdentity= trueIdentityComboBox.getSelectedItem().toString();
            	
            	for(int i=0;i<Load.targetList.size();i++){
        			if(targetID.equals(Load.targetList.get(i).id)){
        				Load.targetList.get(i).markStatus="MARKED";
        				Load.targetList.get(i).markedIdentity=selectedTrueIdentity;
        			}
        		}
            	
            	
            	
            	if(trueIdentity.equals(selectedTrueIdentity)){
            		if(Load.activityFeed.getTargetDetectionSuccess().equals("Y"))
            		Sea.updatesTextArea.append("Target Detection Successful - Target ( " + targetID + " ) has been successfully detected. Track this target to get marking bonus points" + "\n\n");
            		
            		
            		JOptionPane.showMessageDialog(null, "You have got the true identity of the target correct. Your Marking Bonus Points are added to the Score");
            		dispose();
            		if(!markingBonusArray.contains(targetID)){
            		markingBonusArray.add(targetID);
            			if(priority.equals("HIGH")){
            				String label = Sea.targetInterceptedTitleLabel.getText();
            				
            				String[] arrLabel = label.split(":");
            				
            				double currentScore = Double.parseDouble(arrLabel[1]);
            				
            				currentScore = currentScore + markingBonusForHighPriority;
            				
            				for(int i=0;i<Load.targetList.size();i++){
                    			if(targetID.equals(Load.targetList.get(i).id)){
                    				Load.targetList.get(i).scoreGenerated += markingBonusForHighPriority;
                    			}
                    		}
            				
            				
            				Sea.targetInterceptedTitleLabel.setText("Score:"+currentScore);
            			}
            			else
            			{
            				String label = Sea.targetInterceptedTitleLabel.getText();
            				
            				String[] arrLabel = label.split(":");
            				
            				double currentScore = Double.parseDouble(arrLabel[1]);
            				
            				currentScore = currentScore + markingBonusForLowPriority;
            				
            				for(int i=0;i<Load.targetList.size();i++){
                    			if(targetID.equals(Load.targetList.get(i).id)){
                    				Load.targetList.get(i).scoreGenerated += markingBonusForLowPriority;
                    			}
                    		}
            				
            				Sea.targetInterceptedTitleLabel.setText("Score:"+currentScore);
            			}
            		}
            	}else{
            		if(Load.activityFeed.getTargetDetectionFailure().equals("Y"))
            		Sea.updatesTextArea.append("Target Detection UnSuccessful - Target ( " + targetID + " ) has been marked with wrong identity." + "\n\n");
            		JOptionPane.showMessageDialog(null, "You have got the true identity of the target wrong. You will not get your Marking Bonus points");
            		dispose();
            		if(markingBonusArray.contains(selectedTrueIdentity)){
            			try{
                    		markingBonusArray.remove(targetID);
                    		}catch(Exception e ){
                    			
                    		}
            		}
            		
            		
            	}
            	
            	
            }
            
            
            
          


			
        });
		
		


	} // end of constructor
	
	
	

	static void dispose() {
		
		if(f!=null)
		f.dispose();
		
	}

	private void initGUI(){
		
		 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(TargetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(TargetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(TargetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(TargetView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }

		

		 
		targetInspectionLabel = new JLabel("Target Inspection");
		targetInspectionLabel.setFont(new Font("Serif", Font.BOLD, 24));
		
		
		
		targetDescriptionTextArea = new JTextArea(5,15);
		Font font = new Font("Verdana", Font.TYPE1_FONT, 12);
		targetDescriptionTextArea.setFont(font);
		
		targetDescriptionTextArea.setText(description);
		targetDescriptionTextArea.setEditable(false);
		targetDescriptionTextArea.setLineWrap(true);
		
		selectIdentity = new JLabel("Select True Identity of Target");
		
		trueIdentityComboBox = new JComboBox(this.controller.target.arrpriorityLevels);
		
		
		submitButton = new JButton("Submit My Selection");
		closeButton = new JButton("Close");

		
			
			
			
		

		
	}// end of creating objects method


	private void doTheLayout(){

		try{
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);


		gbc.insets=new Insets(10,10,10,10);

			
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.EAST;
		add(targetInspectionLabel,gbc);
		
		
		
		BufferedImage myPicture = ImageIO.read(new File("images" + this.controller.target.inspectionImagePath));
		myPicture = Utilities.getScaledImage(myPicture, 300, 200);
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));


		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.WEST;
		add(picLabel,gbc);

		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.CENTER;
		add(selectIdentity,gbc);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.anchor=GridBagConstraints.CENTER;
		add(trueIdentityComboBox,gbc);

		
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.CENTER;
		add(submitButton,gbc);

		
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.anchor=GridBagConstraints.CENTER;
		add(closeButton,gbc);


		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = 5;
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.NORTH;
		add(targetDescriptionTextArea,gbc);

		JScrollPane spane1 = new JScrollPane(targetDescriptionTextArea);
		spane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gbl.setConstraints(spane1,gbc);
		JPanel pane2 = new JPanel(gbl);     
		pane2.add(spane1);
		add(pane2,gbc);
		
		}catch(Exception e){
			
		}


	}// end of Layout method




	/*public static void main(String[] args) {
		JFrame f = new JFrame("Tech Store");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add( new TargetView(null,null));
		f.pack();
		f.setLocationRelativeTo(null);
		//f.setSize(500, 600);
		f.setVisible(true);


	}*/

	
	public static void loadTargetView(Load load, UnitsController controller) {
		f = new JFrame("Target Inspection");
		Container contentPane = f.getContentPane();
		f.setResizable(false);
		contentPane.add( new TargetView(load,controller));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    f.setResizable(false);
		//f.setSize(500, 600);
		f.setVisible(true);


	}

	

}
