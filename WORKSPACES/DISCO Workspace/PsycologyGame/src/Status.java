import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ramadan
 */
public class Status extends javax.swing.JFrame {

    /**
     * Creates new form PilotTask
     */
    public Status() {
        initComponents();
    }

    public static int statusClosedButtonPressed=0;
    
    
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
             java.util.logging.Logger.getLogger(PilotTaskMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(PilotTaskMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(PilotTaskMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(PilotTaskMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //</editor-fold>

        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Current Game Status");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        taskTextArea.setColumns(20);
        taskTextArea.setRows(5);
        String briefingText="";
        briefingText = briefingText + "Task To Perform \n";
        briefingText=briefingText + "Number of Targets Available - "+ Load.targetList.size()+ " \n";
        for(int i=0;i<Load.targetList.size();i++){
        	briefingText=briefingText + String.valueOf(i+1) +  " - " + Load.targetList.get(i).imageLocation.substring(1,Load.targetList.get(i).imageLocation.length()-4) + " -  A " + Load.targetList.get(i).priority.toUpperCase() + " priority target" + "\n";
        }
        
        int blueGroupSize=0;
        int redGroupSize=0;
        
        for(int i=0;i<Load.unitList.size();i++){
        	if(Load.unitList.get(i).colorID==1){
        		blueGroupSize=blueGroupSize+1;
        	}else{
        		redGroupSize = redGroupSize+1;
        	}
        }
        
        briefingText=briefingText+"Number of Blue Units Avaliable - " + blueGroupSize+" \n";
        int counter =1;
        for(int i=0;i<Load.unitList.size();i++){
        	if(Load.unitList.get(i).colorID==1){
        	
        	briefingText=briefingText + String.valueOf(counter) +  " - " + "Blue "+ Load.unitList.get(i).id+ "\n";
        	counter=counter+1;
        	}
        }
        counter=1;
        briefingText=briefingText+"Number of Red Units Avaliable - " + redGroupSize+" \n";
        for(int i=0;i<Load.unitList.size();i++){
        	if(Load.unitList.get(i).colorID==2){
        	briefingText=briefingText + String.valueOf(counter) +  " - " + "Red "+ Load.unitList.get(i).id+ "\n";
        	counter=counter+1;
        	}
        }
        
        
        taskTextArea.setEditable(false);
        taskTextArea.setText(briefingText);
        taskTextArea.setCaretPosition(0);
        
        
        jScrollPane1.setViewportView(taskTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(closeButton)
                .addContainerGap(155, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(closeButton)
                .addGap(5, 5, 5))
        );

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    	
    	statusClosedButtonPressed+=1;
		
		
		
		
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
         Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
         If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
       

         Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PilotTask().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taskTextArea;
    // End of variables declaration//GEN-END:variables
}
