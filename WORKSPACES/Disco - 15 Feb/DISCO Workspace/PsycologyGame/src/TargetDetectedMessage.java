import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class TargetDetectedMessage extends javax.swing.JFrame{

    private JOptionPane pane;

    private JDialog dialog;

    private Timer t;
    
    private Target target;
    private Load load;
    private UnitsController controller;
    

    public TargetDetectedMessage(Target target, Load load, UnitsController controller) {
	
	   	this.target = target;
	   	target.showMessage = true;
	   	this.load = load;
	   	this.controller = controller;
	   

        t = new Timer(50000, closeJDialog);

        t.start();
        
    
        int answer;
        pane = new JOptionPane("A New Target Is Dtetected", answer = JOptionPane.showConfirmDialog(this," A New Target With A High Volume Is Detected", "Confirm Dialog", JOptionPane.YES_NO_OPTION));
                
        if (answer == JOptionPane.YES_OPTION) {
        
        	target.tarckThisTarget(load, controller);
        	
        	 new Timer(50000, new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     
                	 disposeDialogMessage();
                 }
             }).start();
        	
        
        } else if (answer == JOptionPane.NO_OPTION){
        
        	new Timer(50000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                	disposeDialogMessage();
                }
            }).start();
        	
        }

    }

     

    private ActionListener closeJDialog = new ActionListener() {

    	  	
    	public void actionPerformed(ActionEvent e) {

                      	
    		disposeDialogMessage();
                

        }

    };

  
    void disposeDialogMessage() {
	  target.showMessage = false;
	  target.dialogBox = null;
	  this.dispose();
	  
  }
  
 
}
