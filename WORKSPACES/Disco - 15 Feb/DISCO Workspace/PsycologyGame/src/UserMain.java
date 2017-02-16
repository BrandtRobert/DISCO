import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.portable.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ramadan
 */
public class UserMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
	public static String scenarioName="";
    public UserMain() {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(UserMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>


    	 jLabel1 = new javax.swing.JLabel();
         scenarioLabel = new javax.swing.JLabel();
         jScrollPane1 = new javax.swing.JScrollPane();
         scenarioList = new javax.swing.JList();
         startButton = new javax.swing.JButton();
         ParticipantLable = new javax.swing.JLabel();
         ParticipantTextField = new javax.swing.JTextField();
        // pathLabel = new javax.swing.JLabel();
        // pathTextField = new javax.swing.JTextField();
         jSeparator1 = new javax.swing.JSeparator();
         backSlashLabel = new javax.swing.JLabel();


         jLabel1.setText("jLabel1");

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
         setTitle("User Menu");
         setName("mainFrame"); // NOI18N
         setResizable(false);

         scenarioLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
         scenarioLabel.setForeground(java.awt.Color.blue);
         scenarioLabel.setText("Use Existing Scenario: ");


        readListFile();
        
        /*scenarioList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });*/
        
        scenarioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scenarioListMouseClicked(evt);
            }
        });
        scenarioList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                scenarioListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(scenarioList);

        startButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        startButton.setForeground(java.awt.Color.blue);
        startButton.setText("Start Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        ParticipantLable.setForeground(java.awt.Color.blue);
        ParticipantLable.setText("Participant NO:");

        ParticipantTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ParticipantTextFieldMouseClicked(evt);
            }
        });
        ParticipantTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticipantTextFieldActionPerformed(evt);
            }
        });
        ParticipantTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ParticipantTextFieldKeyPressed(evt);
            }
        });

        /*pathLabel.setForeground(java.awt.Color.blue);
        pathLabel.setText("File Path - C:/Users/ORN/");

        pathTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTextFieldActionPerformed(evt);
            }
        });*/

        backSlashLabel.setForeground(java.awt.Color.blue);
        //backSlashLabel.setText("/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ParticipantLable)
                        .addGap(8, 8, 8)
                        .addComponent(ParticipantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        //.addComponent(null, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addComponent(backSlashLabel)
                .addGap(15, 15, 15))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scenarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(startButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParticipantLable)
                    .addComponent(ParticipantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    //.addComponent(null)
                   // .addComponent(null, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backSlashLabel))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(scenarioLabel)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(startButton)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }// </editor-fold>//GEN-END:initComponents
    
    private void pathTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathTextFieldActionPerformed


    private void scenarioListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scenarioListMouseClicked
        //System.out.println("Item " + scenarioList.getSelectedIndex());
        // TODO add your handling code here:
    }//GEN-LAST:event_scenarioListMouseClicked

    private void scenarioListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scenarioListKeyPressed
       // System.out.println("Item" + scenarioList.getSelectedIndex());
        // TODO add your handling code here:
        //System.out.println("Item" + scenarioList.getName());
    }//GEN-LAST:event_scenarioListKeyPressed

    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
    	
    	try {
            int input = Integer.parseInt(ParticipantTextField.getText());
            

    		
    		
    		
            
            
    	   //	this.dispose();
    	
            //System.out.println("You've entered number: " + input);
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(null,
     	            "Participant Inpute Must BE Integer!",
     	            "Input Error", JOptionPane.ERROR_MESSAGE);
        	return;
        }
    	
    	
    	if (ParticipantTextField.getText().length() == 0) {
   		 
		    JOptionPane.showMessageDialog(null,
 	            "Participant No is Required!",
 	            "Input Error", JOptionPane.ERROR_MESSAGE);
    	
    		
    	} else if (scenarioList.getSelectedIndex() == -1){
    		
    		JOptionPane.showMessageDialog(null,
     	            "Select A Scenario!",
     	            "Input Error", JOptionPane.ERROR_MESSAGE);
    	
    	} else {
    		
    		// path validation
    		//String path = pathTextField.getText();
    		
    		/*for (int i=0; i < path.length(); i++)
    		if (path.charAt(0) == '/' || path.charAt(0) == '\\') {
    		CharSequence c = String.valueOf(path.charAt(0));
    		path = path.replace(c , "");
    		}
    		
    		path = path.replace("\\", "/"); 
    		path = path.replace(":", "");
    		path = path.replace("'\'", "/");
    		path = path.replace(" ", "/");*/
    		
    		//System.out.println("Path: " + JarPath.getClassPath());
    		// Initiate the load object
    		
    		Load load = new Load(scenarioPath + scenarioNmaes[scenarioList.getSelectedIndex()]+".xml",
    				      ParticipantTextField.getText().toString(), 
    				       ""+ scenarioPath + scenarioNmaes[scenarioList.getSelectedIndex()]+".xml" );
    		load.playSTop_clicked();
    		
    		hideOrShowControls();
    		//System.out.println(ParticipantTextField.getText());
    		
    		scenarioName = scenarioNmaes[scenarioList.getSelectedIndex()]+".xml";
    		Sea.scenarioName = scenarioName;
    		
    		
    		int seconds = Integer.parseInt(ConfigProps.DISCO_TIMER);
            seconds=seconds-1;
            String timertype = ConfigProps.DISCO_TIMER_TYPE;
            String displaytype = ConfigProps.DISCO_TIMER_DISPLAY;
            if(timertype.equals("UPWARDS")){
            	
            	if(displaytype.equals("MINUTES"))
            	startUpTimerMinutes(seconds);
            	else
            	startUpTimerSeconds(seconds);
            }else if(timertype.equals("DOWNWARDS")){
                	
                	if(displaytype.equals("MINUTES"))
                	startDownTimerMinutes(seconds);
                	else
                	startDownTimerSeconds(seconds);
            }
            
            
    	   	this.dispose();
    	}
    	
    
    }//GEN-LAST:event_startButtonActionPerformed

    private void hideOrShowControls() {

    	if(ConfigProps.LAUNCH_UNIT.equals("N")){
    		Load.launchUnitButton.setVisible(false);
    		Load.inActiveUnitsComboBox.setVisible(false);
    		Load.launchUnitLabel.setVisible(false);
    	}else if(ConfigProps.LAUNCH_UNIT.equals("G")){
    		Load.launchUnitButton.setEnabled(false);
    		Load.launchUnitButton.setToolTipText("Launching of units has been disabled for the current scenario");
    	}
    	
    	if(ConfigProps.BRIEFING.equals("N")){
    		Load.briefingButton.setVisible(false);
    	}else if(ConfigProps.BRIEFING.equals("G")){
    		Load.briefingButton.setEnabled(false);
    		Load.briefingButton.setToolTipText("Briefing feature has been disabled for the current scenario");
    		Load.briefingButton.setBackground(Color.GRAY);
    	}
    	
    	if(ConfigProps.CREDITLIMIT.equals("N")){
    		Load.resourcePoolAvailableLimit.setVisible(false);
    	}else if(ConfigProps.OVERLAY.equals("G")){
    		Load.resourcePoolAvailableLimit.setEnabled(false);
    		Load.resourcePoolAvailableLimit.setToolTipText("Credit Limit has been disabled for the current scenario");
    		Load.resourcePoolAvailableLimit.setBackground(Color.GRAY);
    	}
    		
    	if(ConfigProps.STATUS.equals("N")){
    		Load.statusButton.setVisible(false);
    	}else if(ConfigProps.STATUS.equals("G")){
    		Load.statusButton.setEnabled(false);
    		Load.statusButton.setToolTipText("Status feature has been disabled for the current scenario");
    		Load.statusButton.setBackground(Color.GRAY);
    	}
    	
    	if(ConfigProps.OVERLAY.equals("N")){
    		Load.FlightPathButton.setVisible(false);
    	}else if(ConfigProps.OVERLAY.equals("G")){
    		Load.FlightPathButton.setEnabled(false);
    		Load.FlightPathButton.setToolTipText("Overlay feature has been disabled for the current scenario");
    		Load.FlightPathButton.setBackground(Color.GRAY);
    	}
    	
    	if(ConfigProps.RED_TO_BLUE_SWITCH.equals("N")  || ConfigProps.RED_TO_BLUE_SWITCH.equals("G") ){
    		Load.redArrowabel.setVisible(false);
    	}
    	
    	if(ConfigProps.BLUE_TO_RED_SWITCH.equals("N") || ConfigProps.BLUE_TO_RED_SWITCH.equals("G")){
    		Load.blueArrowLabel.setVisible(false);
    	}
    	
    	if(ConfigProps.COHESION_SLIDER.equals("N")){
    		Load.cohesionSlider.setVisible(false);
    		Load.groupCohComboBox.setVisible(false);
    		Load.chohesionTitleLabel.setVisible(false);
    	}
    	
    	if(ConfigProps.PROXIMITY_SLIDER.equals("N")){
    		Load.proximitySlider.setVisible(false);
    		Load.proximityTitleLabel.setVisible(false);
    		Load.groupProxComboBox.setVisible(false);
    	}
    	if(ConfigProps.VIEW_TARGET.equals("N")){
    		Load.statusViewLabel.setVisible(false);
    	}
    	
    	if(ConfigProps.RED_GROUP.equals("N")){
    		Load.redGroupButton.setVisible(false);
    		Load.redAutoModeButton.setVisible(false);
    		Load.redSeekModeButton.setVisible(false);
    		Load.redTrackModeButton.setVisible(false);
    	}
    	
    	if(ConfigProps.BLUE_GROUP.equals("N")){
    		Load.blueGroupButton.setVisible(false);
    		Load.blueAutoModeButton.setVisible(false);
    		Load.blueSeekModeButton.setVisible(false);
    		Load.blueTrackModeButton.setVisible(false);
    	}
    	
    	Load.playSTopLable.setVisible(false);
	}


	private void startUpTimerSeconds(final int seconds) {
    	

    	int delay = 1000;
        int period = 1000;
        Sea.timer = new java.util.Timer("GameTimer");
        Sea.timer.scheduleAtFixedRate(new TimerTask() {

    	        public void run() {
    	        	setInterval(seconds);
    	        	Sea.TargetDetectTitleLabel.setText("Time: " + Sea.interval +"");
    	        	if(Sea.isCompleted){
    	        		JOptionPane.showMessageDialog(null, "Time Limit Over.\nPlease Click OK to Exit from the Game");
    	        		Sea.isCompleted=false;
    	            	System.exit(0);
    	        	}
    	        	
    	        	}
    	    }, delay, period);
		
	
    }

    private void startUpTimerMinutes(final int seconds) {
    	int delay = 1000;
        int period = 1000;
        Sea.timer = new java.util.Timer();
        Sea.timer.scheduleAtFixedRate(new TimerTask() {

    	        public void run() {
    	        	setInterval(seconds);
    	        	if(Sea.interval%60==0){
    	        		int min = Sea.interval/60;
    	        		Sea.TargetDetectTitleLabel.setText("Time Elapsed: " + min + " min " + "0" + " sec");
    	        	} else{
    	        		
    	        		int min = Sea.interval/60;
    	        		if(min>0){
    	        			int sec = Sea.interval - (min*60);
    	        			Sea.TargetDetectTitleLabel.setText("Time Elapsed: " + min + " min " + sec +  " sec");
    	        		}else{
    	        			Sea.TargetDetectTitleLabel.setText("Time Elapsed: 0 min " + Sea.interval + " sec");
    	        		}
    	        		
    	        	}
    	        	if(Sea.isCompleted){
    	        		JOptionPane.showMessageDialog(null, "Time Limit Over.\nPlease Click OK to Exit from the Game");
    	        		Sea.isCompleted=false;
    	            	System.exit(0);
    	        	}
    	        	
    	        	}
    	    }, delay, period);
		
	}
    
    private static final int setInterval(int limit) {
        if (Sea.interval == limit){
        	Sea.timer.cancel();
        	Sea.isCompleted=true;
        	
        }
        Sea.interval = Sea.interval +1;
        return Sea.interval;
    }
       
    
    private void startDownTimerSeconds(final int seconds) {
    	
    	//final int timeValue = 0;
        	int delay = 1000;
            int period = 1000;
            Sea.timer = new java.util.Timer("GameTimer");
            Sea.interval = seconds;
            Sea.timer.scheduleAtFixedRate(new TimerTask() {

        	        public void run() {
        	        	 setIntervalDownwards(seconds);
        	        	Sea.TargetDetectTitleLabel.setText("Time: " + Sea.interval +"");
        	        	if(Sea.isCompleted){
        	        		JOptionPane.showMessageDialog(null, "Time Limit Over.\nPlease Click OK to Exit from the Game");
        	        		Sea.isCompleted=false;
        	            	System.exit(0);
        	        	}
        	        	
        	        	}
        	    }, delay, period);
    		
    	
        }

        private void startDownTimerMinutes(final int seconds) {
        	int delay = 1000;
            int period = 1000;
            Sea.timer = new java.util.Timer();
            Sea.interval = seconds;
            Sea.timer.scheduleAtFixedRate(new TimerTask() {

        	        public void run() {
        	        	setIntervalDownwards(seconds);
        	        	if(Sea.interval%60==0){
        	        		int min = Sea.interval/60;
        	        		Sea.TargetDetectTitleLabel.setText("Time Remaining: " + min + " min " + "0" + " sec");
        	        	} else{
        	        		
        	        		int min = Sea.interval/60;
        	        		if(min>0){
        	        			int sec = Sea.interval - (min*60);
        	        			Sea.TargetDetectTitleLabel.setText("Time Remaining: " + min + " min " + sec +  " sec");
        	        		}else{
        	        			Sea.TargetDetectTitleLabel.setText("Time Remaining: 0 min " + Sea.interval + " sec");
        	        		}
        	        		
        	        	}
        	        	if(Sea.isCompleted){
        	        		JOptionPane.showMessageDialog(null, "Time Limit Over.\nPlease Click OK to Exit from the Game");
        	        		Sea.isCompleted=false;
        	            	System.exit(0);
        	        	}
        	        	
        	        	}
        	    }, delay, period);
    		
    	}
            
        
        
        private static final int setIntervalDownwards(int limit) {
        //	System.out.println("sea interval"+Sea.interval +"  and limit "+limit);
            if (Sea.interval == 1){
            	Sea.timer.cancel();
            	Sea.isCompleted=true;
            	
            }
            
            Sea.interval = Sea.interval-1 ;
            return Sea.interval;
        }

	private void ParticipantTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticipantTextFieldActionPerformed
        // TODO add your handling code here:
        //System.out.println("+++++++++++++++++++++++++++++++");
    }//GEN-LAST:event_ParticipantTextFieldActionPerformed

    private void ParticipantTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ParticipantTextFieldKeyPressed
        
    }//GEN-LAST:event_ParticipantTextFieldKeyPressed

    private void ParticipantTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParticipantTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ParticipantTextFieldMouseClicked

    /**
     * @param args the command line arguments
     */
    
public void readListFile(){
    	
    	String line = null;
    	ArrayList<String> list = new ArrayList<String>();

        try {
            // FileReader reads text files in the default encoding.
           /* FileReader fileReader = 
                new FileReader("files/List.txt");*/
            
            //URL url = this.getClass().getResource("resources/howto.txt");

            // Always wrap FileReader in BufferedReader.
            
            FileInputStream inputStream = new FileInputStream(scenarioPath+"List.txt");
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            
            BufferedReader bufferedReader = 
                new BufferedReader(inputReader);
            
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                list.add(line);
              
            }	

            // Always close files.
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                "List.txt" + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + "List.txt" + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    	
        scenarioNmaes = new String[list.size()];
        scenarioNmaes = list.toArray(scenarioNmaes);
        scenarioList.setModel(new javax.swing.DefaultComboBoxModel(scenarioNmaes));
    }


    public static void main(String args[]) {
    	 UserMain m = new UserMain();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    String [] scenarioNmaes = new String[20];
    String[] s;
    private javax.swing.JLabel ParticipantLable;
    private javax.swing.JTextField ParticipantTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel scenarioLabel;
    private javax.swing.JList scenarioList;
    private javax.swing.JButton startButton;
    private javax.swing.JSeparator jSeparator1;
    //private javax.swing.JLabel pathLabel;
    //private javax.swing.JTextField pathTextField;
    private javax.swing.JLabel backSlashLabel;
    public static String scenarioPath = JarPath.getClassPath() +"scenarios//";

    // End of variables declaration//GEN-END:variables
    
}