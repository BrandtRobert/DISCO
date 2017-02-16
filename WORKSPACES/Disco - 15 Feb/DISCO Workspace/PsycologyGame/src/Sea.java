import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ramadan
 */



public class Sea extends javax.swing.JPanel {
	
	
	 
	
	private static final long serialVersionUID = 1L;
	  private static Color BACKGROUND  ;
	     private static Color BACKGROUND_2 ;
   public  String path = "";
    
    
    
	
    public static boolean stop = false;
    public Track track;
    public static UnitsController blueUnits, redUnits;
    public Swap swapUnit;
    static Timer timer;
    static int interval=0;
    static boolean isCompleted=false;
    private String unitsToMove = "";
    
    static String scenarioName="";
    
    //BufferedImage bufferedImage ;
    
    protected final Color BLUE_COLOUR = Color.BLUE;
    protected final Color RED_COLOUR = Color.RED;
    protected final Color WHITE_COLOUR = Color.WHITE;
    
    BufferedImage image;
    
    
 // Variables declaration - do not modify//GEN-BEGIN:variables
   protected javax.swing.JLabel ALabel;
    protected javax.swing.JLabel BLabel;
    protected javax.swing.JLabel CLabel;
    protected javax.swing.JLabel DLabel;
    protected javax.swing.JLabel ELabel;
    protected javax.swing.JLabel FLabel;
    protected javax.swing.JLabel FLabel1;
    protected javax.swing.JLabel FiveLabel;
    public static javax.swing.JButton FlightPathButton;
    protected javax.swing.JLabel FourLabel;
    protected javax.swing.JLabel OneLable;
    protected javax.swing.JPanel PilotPanel;
    protected javax.swing.JLabel SevenLabel;
    protected javax.swing.JLabel SixLabel;
    protected javax.swing.JLabel EightLabel;
    public static javax.swing.JLabel TargetDetectTitleLabel;
    protected javax.swing.JLabel ThreeLabel;
    protected javax.swing.JLabel TwoLabel;
    public static javax.swing.JLabel blueArrowLabel;
    public static javax.swing.JButton blueAutoModeButton;
    protected javax.swing.JComboBox blueComboBox;
    public static javax.swing.JButton blueGroupButton;
    protected javax.swing.JLabel blueGroupTitleLabel;
    public static javax.swing.JButton blueSeekModeButton;
    public static javax.swing.JButton blueTrackModeButton;
    protected javax.swing.JLabel blueUnitLabel;
    protected static javax.swing.JTextField blueUnitsTextField;
    public static javax.swing.JButton briefingButton;
    public static javax.swing.JButton statusButton;
    public static javax.swing.JSlider cohesionSlider;
    public static javax.swing.JLabel chohesionTitleLabel;
    protected javax.swing.JLabel closeLable;
    protected javax.swing.JLabel groundLabel;
    public static javax.swing.JComboBox groupCohComboBox;
    public static javax.swing.JComboBox groupProxComboBox;
    protected javax.swing.JLabel groupTitleLabel;
    public static javax.swing.JLabel launchUnitLabel;
    protected javax.swing.JLabel jLabel20;
    protected javax.swing.JLabel jLabel21;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JSeparator jSeparator1;
    protected javax.swing.JSeparator jSeparator2;
    protected javax.swing.JSeparator jSeparator3;
    protected javax.swing.JSeparator jSeparator4;
    protected javax.swing.JSeparator jSeparator5;
    protected javax.swing.JSeparator jSeparator6;
    //protected javax.swing.JPanel pirateSeaPanel;
    public static javax.swing.JLabel playSTopLable;
    public static javax.swing.JSlider proximitySlider;
    public static javax.swing.JLabel proximityTitleLabel;
    public static javax.swing.JLabel redArrowabel;
    public static javax.swing.JButton redAutoModeButton;
    protected javax.swing.JComboBox redComboBox;
    public static javax.swing.JButton redGroupButton;
    protected javax.swing.JLabel redGroupTitleLabel;
    public static javax.swing.JButton redSeekModeButton;
    public static javax.swing.JButton redTrackModeButton;
    protected javax.swing.JLabel redUnitLabel;
    protected javax.swing.JTextField redUnitsTextField;
    protected javax.swing.JLabel statusDetectedLabel;
    protected javax.swing.JPanel statusPanel;
    public static javax.swing.JLabel statusViewLabel;
    protected javax.swing.JLabel targetDetectedLabel;
    protected javax.swing.JLabel targetInterceptedLabel;
    public static javax.swing.JLabel targetInterceptedTitleLabel;
    public static javax.swing.JLabel resourcePoolAvailableLimit;
    protected javax.swing.JLabel unitNumberLable;
    protected javax.swing.JLabel unitTitleLabel;
    protected static javax.swing.JTextArea updatesTextArea;
    public static String[] arrInActiveUnits ={"Select Unit","Blue 1","Blue 2"};
    public static JComboBox inActiveUnitsComboBox = new JComboBox(arrInActiveUnits);
    public static JButton launchUnitButton = new JButton("Launch Unit");
    protected javax.swing.JLabel unitPriceLabel = new JLabel("");
    
    public static int launchButtonPressed=0;
    public static int briefingButtonPressed=0;
    public static int statusButtonPressed=0;
    public static int overlayButtonPressed=0;
    public static int viewTargetButtonPressed=0;
    public static int redToBlueSwitchButtonPressed=0;
    public static int blueToRedSwitchButtonPressed=0;
    
    public static int blueGroupAutoModeButtonPressed=0;
    public static int blueGroupButtonPressed=0;
    public static int blueGroupSeekModeButtonPressed=0;
    public static int blueGroupTrackModeButtonPressed=0;
    
    public static int redGroupAutoModeButtonPressed=0;
    public static int redGroupButtonPressed=0;
    public static int redGroupSeekModeButtonPressed=0;
    public static int redGroupTrackModeButtonPressed=0;
    
    
    
    
    protected javax.swing.JLabel mapLabel;
// End of variables declaration//GEN-END:variables


    /**
     * Creates new form UI
     */

    public Sea() {
     
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //javPiratePanellogging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    	//Initializing data 
    	//bufferedImage = null;
    	blueUnits = new UnitsController(this, "Blue");
    	redUnits =  new UnitsController(this, "Red");
    	
    	 
    	initComponents();
    	

        
    
        
       
    
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    protected void initComponents() {

    	
        
       
    	
        //pirateSeaPanel = new javax.swing.JPanel();
        JFrame gue = new JFrame();
        ALabel = new javax.swing.JLabel();
        BLabel = new javax.swing.JLabel();
        CLabel = new javax.swing.JLabel();
        DLabel = new javax.swing.JLabel();
        ELabel = new javax.swing.JLabel();
        FLabel = new javax.swing.JLabel();
        OneLable = new javax.swing.JLabel();
        TwoLabel = new javax.swing.JLabel();
        ThreeLabel = new javax.swing.JLabel();
        FourLabel = new javax.swing.JLabel();
        FiveLabel = new javax.swing.JLabel();
        SixLabel = new javax.swing.JLabel();
        SevenLabel = new javax.swing.JLabel();
        EightLabel = new javax.swing.JLabel();
        groundLabel = new javax.swing.JLabel();
        FLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        redGroupTitleLabel = new javax.swing.JLabel();
        blueGroupTitleLabel = new javax.swing.JLabel();
        TargetDetectTitleLabel = new javax.swing.JLabel();
        targetInterceptedTitleLabel = new javax.swing.JLabel();
        resourcePoolAvailableLimit = new javax.swing.JLabel();
        targetDetectedLabel = new javax.swing.JLabel();
        targetInterceptedLabel = new javax.swing.JLabel();
        cohesionSlider = new javax.swing.JSlider();
        chohesionTitleLabel = new javax.swing.JLabel();
        proximityTitleLabel = new javax.swing.JLabel();
        proximitySlider = new javax.swing.JSlider();
        statusPanel = new javax.swing.JPanel();
        statusDetectedLabel = new javax.swing.JLabel();
        statusViewLabel = new javax.swing.JLabel();
        unitTitleLabel = new javax.swing.JLabel();
        unitNumberLable = new javax.swing.JLabel();
        groupTitleLabel = new javax.swing.JLabel();
        launchUnitLabel = new javax.swing.JLabel();
        redGroupButton = new javax.swing.JButton();
        blueGroupButton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        redSeekModeButton = new javax.swing.JButton();
        redTrackModeButton = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        blueSeekModeButton = new javax.swing.JButton();
        blueAutoModeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        redAutoModeButton = new javax.swing.JButton();
        blueTrackModeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        updatesTextArea = new javax.swing.JTextArea();
        redUnitLabel = new javax.swing.JLabel();
        redUnitsTextField = new javax.swing.JTextField();
        blueUnitLabel = new javax.swing.JLabel();
        blueUnitsTextField = new javax.swing.JTextField();
        playSTopLable = new javax.swing.JLabel();
        closeLable = new javax.swing.JLabel();
        redComboBox = new javax.swing.JComboBox();
        blueComboBox = new javax.swing.JComboBox();
        redArrowabel = new javax.swing.JLabel();
        blueArrowLabel = new javax.swing.JLabel();
        groupProxComboBox = new javax.swing.JComboBox();
        groupCohComboBox = new javax.swing.JComboBox();
        PilotPanel = new javax.swing.JPanel();
        briefingButton = new javax.swing.JButton();
        statusButton = new javax.swing.JButton();
        FlightPathButton = new javax.swing.JButton();
        
        inActiveUnitsComboBox.setPreferredSize(new Dimension(100,25));
        mapLabel = new javax.swing.JLabel();

        swapUnit = new Swap ((Load) this);
        
        gue.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gue.setTitle("PsyGame");
        gue.setBackground(null);
        gue.setResizable(false);

        
        this.setBackground(new java.awt.Color(100, 250, 255));
       // this.setBackground(new java.awt.Color(204, 204, 225));
     //  gue.setContentPane(new javax.swing.JLabelfon(getImage("/usa_map.png")));
      //  mapLabel.setText("in herererererrerererererererrereerrererererrerrerererererer");
      //  gue.add(new javax.swing.JButton("new"));
        
        this.setBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 2, true));
       
        
        ALabel.setBackground(new java.awt.Color(153, 153, 153));
        ALabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ALabel.setForeground(new java.awt.Color(153, 153, 153));
        ALabel.setText("A");

        BLabel.setBackground(new java.awt.Color(153, 153, 153));
        BLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BLabel.setForeground(new java.awt.Color(153, 153, 153));
        BLabel.setText("B");

        CLabel.setBackground(new java.awt.Color(153, 153, 153));
        CLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CLabel.setForeground(new java.awt.Color(153, 153, 153));
        CLabel.setText("C");

        DLabel.setBackground(new java.awt.Color(153, 153, 153));
        DLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DLabel.setForeground(new java.awt.Color(153, 153, 153));
        DLabel.setText("D");

        ELabel.setBackground(new java.awt.Color(153, 153, 153));
        ELabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ELabel.setForeground(new java.awt.Color(153, 153, 153));
        ELabel.setText("E");

        FLabel.setBackground(new java.awt.Color(153, 153, 153));
        FLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        FLabel.setForeground(new java.awt.Color(153, 153, 153));
        FLabel.setText("F");

        OneLable.setBackground(new java.awt.Color(153, 153, 153));
        OneLable.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        OneLable.setForeground(new java.awt.Color(153, 153, 153));
        OneLable.setText("1");

        TwoLabel.setBackground(new java.awt.Color(153, 153, 153));
        TwoLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TwoLabel.setForeground(new java.awt.Color(153, 153, 153));
        TwoLabel.setText("2");

        ThreeLabel.setBackground(new java.awt.Color(153, 153, 153));
        ThreeLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ThreeLabel.setForeground(new java.awt.Color(153, 153, 153));
        ThreeLabel.setText("3");

        FourLabel.setBackground(new java.awt.Color(153, 153, 153));
        FourLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        FourLabel.setForeground(new java.awt.Color(153, 153, 153));
        FourLabel.setText("4");

        FiveLabel.setBackground(new java.awt.Color(153, 153, 153));
        FiveLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        FiveLabel.setForeground(new java.awt.Color(153, 153, 153));
        FiveLabel.setText("5");

        SixLabel.setBackground(new java.awt.Color(153, 153, 153));
        SixLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SixLabel.setForeground(new java.awt.Color(153, 153, 153));
        SixLabel.setText("6");

        SevenLabel.setBackground(new java.awt.Color(153, 153, 153));
        SevenLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SevenLabel.setForeground(new java.awt.Color(153, 153, 153));
        SevenLabel.setText("7");
        
        EightLabel.setBackground(new java.awt.Color(153, 153, 153));
        EightLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        EightLabel.setForeground(new java.awt.Color(153, 153, 153));
        EightLabel.setText("8");

        
      /*  try {
			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/GroundUpdate.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
       
        
      //  groundLabel.setIcon(new javax.swing.ImageIcon(getImage("/usa_map.png").getScaledInstance(1027, 700, java.awt.Image.SCALE_SMOOTH))); // NOI18N
        
       groundLabel.setIcon(new javax.swing.ImageIcon(getImage("/GroundUpdate.png"))); // NOI18N
        
        FLabel1.setBackground(new java.awt.Color(153, 153, 153));
        FLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        FLabel1.setForeground(new java.awt.Color(153, 153, 153));
        FLabel1.setText("G");

        javax.swing.GroupLayout pirateSeaPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(pirateSeaPanelLayout);
        
        pirateSeaPanelLayout.setHorizontalGroup(
            pirateSeaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(ALabel)
                .addGap(120, 120, 120)
                .addComponent(BLabel)
                .addGap(120, 120, 120)
                .addComponent(CLabel)
                .addGap(120, 120, 120)
                .addComponent(DLabel)
                .addGap(120, 120, 120)
                .addComponent(ELabel)
                .addGap(120, 120, 120)
                .addComponent(FLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(FLabel1)
                .addGap(70, 70, 70))
            .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pirateSeaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                        .addComponent(SevenLabel)
                        .addGap(82, 969, Short.MAX_VALUE))
                    .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                        .addGroup(pirateSeaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SixLabel)
                            .addComponent(OneLable)
                            .addComponent(FiveLabel)
                            .addComponent(FourLabel)
                            .addComponent(ThreeLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                        .addComponent(TwoLabel)
                       .addGap(149, 969, Short.MAX_VALUE))))
                       .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pirateSeaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                        .addComponent(EightLabel)
                        .addGap(82, 969, Short.MAX_VALUE))))
        );
        pirateSeaPanelLayout.setVerticalGroup(
            pirateSeaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pirateSeaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pirateSeaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ALabel)
                    .addComponent(BLabel)
                    .addComponent(CLabel)
                    .addComponent(DLabel)
                    .addComponent(ELabel)
                    .addComponent(FLabel)
                    .addComponent(FLabel1))
                .addGap(40, 40, 40)
                .addComponent(OneLable)
                .addGap(50, 50, 50)
                .addComponent(TwoLabel)
                .addGap(49, 49, 49)
                .addComponent(ThreeLabel)
                .addGap(50, 50, 50)
                .addComponent(FourLabel)
                .addGap(50, 50, 50)
                .addComponent(FiveLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(SixLabel)
                .addGap(60, 60, 60)
                .addComponent(SevenLabel)
                .addGap(60, 60, 60)
                .addComponent(EightLabel)
                .addGap(27, 27, 27)
                )
        );

        jSeparator2.setBackground(new java.awt.Color(0, 51, 204));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 15));

        jSeparator3.setBackground(new java.awt.Color(0, 51, 204));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 255));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setMinimumSize(new java.awt.Dimension(50, 15));

        jSeparator4.setBackground(new java.awt.Color(0, 51, 204));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 255));
        jSeparator4.setMinimumSize(new java.awt.Dimension(50, 15));

        redGroupTitleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        redGroupTitleLabel.setForeground(new java.awt.Color(255, 10, 13));
        redGroupTitleLabel.setText("Red Group");

        blueGroupTitleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        blueGroupTitleLabel.setForeground(new java.awt.Color(0, 0, 255));
        blueGroupTitleLabel.setText("Blue Group");

        TargetDetectTitleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        TargetDetectTitleLabel.setText("Time:");

        targetInterceptedTitleLabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        targetInterceptedTitleLabel.setText("Score:0");

        targetDetectedLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        targetDetectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        targetDetectedLabel.setText("");
        
        resourcePoolAvailableLimit.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        resourcePoolAvailableLimit.setText("Available Credit Limit: ");

      

        targetInterceptedLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        targetInterceptedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        targetInterceptedLabel.setText("");

        cohesionSlider.setBackground(new java.awt.Color(204, 204, 255));
        cohesionSlider.setForeground(new java.awt.Color(51, 51, 255));
        cohesionSlider.setMajorTickSpacing(20);
        cohesionSlider.setMinorTickSpacing(5);
        cohesionSlider.setPaintLabels(true);
        cohesionSlider.setPaintTicks(true);
        cohesionSlider.setToolTipText("Slide left to right to increase search area");
        cohesionSlider.setValue(0);
        cohesionSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cohesionSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cohesionSliderStateChanged(evt);
            }
        });
        cohesionSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
               // cohesionSliderMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cohesionSliderMouseMoved(evt);
            }
        });
        cohesionSlider.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                cohesionSliderAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        chohesionTitleLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        chohesionTitleLabel.setText("Search Area");

        proximityTitleLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        proximityTitleLabel.setText("Proximity");

        proximitySlider.setBackground(new java.awt.Color(204, 204, 255));
        proximitySlider.setForeground(java.awt.Color.blue);
        proximitySlider.setMajorTickSpacing(20);
        proximitySlider.setMinorTickSpacing(5);
        proximitySlider.setPaintLabels(true);
        proximitySlider.setPaintTicks(true);
        proximitySlider.setValue(0);
        proximitySlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                proximitySliderMouseReleased(evt);
            }
        });
        proximitySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                proximitySliderStateChanged(evt);
            }
        });
        proximitySlider.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                //proximitySliderAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        proximitySlider.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                //proximitySliderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                //proximitySliderFocusLost(evt);
            }
        });
        proximitySlider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //proximitySliderKeyReleased(evt);
            }
        });

        statusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 2, true), "Status", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        statusPanel.setForeground(new java.awt.Color(204, 204, 255));

        statusDetectedLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        statusDetectedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusDetectedLabel.setText("Target Detected");
        statusDetectedLabel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        statusDetectedLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statusDetectedLabelMouseClicked(evt);
            }
        });

        statusViewLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        statusViewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusViewLabel.setText("View Target");
        statusViewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));
        statusViewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statusViewLabelMouseClicked(evt);
            }
        });

        unitTitleLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        unitTitleLabel.setText("Unit:");

        unitNumberLable.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        unitNumberLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitNumberLable.setText("");

        groupTitleLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        groupTitleLabel.setText("Current Group: ");
        groupTitleLabel.setAlignmentY(0.0F);
        
        launchUnitLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        launchUnitLabel.setText("Launch Unit: ");
        launchUnitLabel.setAlignmentY(1.0F);

        redGroupButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        redGroupButton.setForeground(java.awt.Color.red);
        redGroupButton.setText("Red");
        redGroupButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.red, 1, true));
        redGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redGroupButtonActionPerformed(evt);
            }
        });
        
        inActiveUnitsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	
            	if(inActiveUnitsComboBox.getSelectedIndex()!=0){
            		String unit = inActiveUnitsComboBox.getSelectedItem().toString();
            		unitPriceLabel.setFont(new Font("Serif", Font.PLAIN, 19));
            		String arrUnit[] = unit.split(" ");
            		

        			unit = arrUnit[1];
        			
        			for(int i=0;i<Load.inActiveUnits.size();i++){
        				
        				if(unit.equals(Load.inActiveUnits.get(i).id)){
        					
        					String unitPrice = Load.inActiveUnits.get(i).price;
        					String totalCreditLimit = Load.totalAvailableCreditLimit;
        					
        					if(Double.parseDouble(totalCreditLimit)- Double.parseDouble(unitPrice)>=0){
        						unitPriceLabel.setText("Unit Price is $" +unitPrice  + " Available " + Sea.resourcePoolAvailableLimit.getText());
        						Color myColor = Color.decode("#006400");
        						unitPriceLabel.setForeground(myColor);
        					}else{
        						unitPriceLabel.setText("Unit Price is $" +unitPrice  + " Available " + Sea.resourcePoolAvailableLimit.getText());
        						unitPriceLabel.setForeground(Color.RED);
        					}
        				}
        			}
        		
        			
            	}
            	
            }
        });
        
        launchUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	launchUnitButtonActionPerformed(evt);
            	
            }

			private void launchUnitButtonActionPerformed(ActionEvent evt) {
				
				launchButtonPressed=launchButtonPressed+1;
				
				
				if(inActiveUnitsComboBox.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please select unit to launch");
				} else{

					

            		String unit = inActiveUnitsComboBox.getSelectedItem().toString();
            		unitPriceLabel.setFont(new Font("Serif", Font.PLAIN, 19));
            		String arrUnit[] = unit.split(" ");
            		
            		
        			unit = arrUnit[1];
        			
        			for(int i=0;i<Load.inActiveUnits.size();i++){
        				
        				if(unit.equals(Load.inActiveUnits.get(i).id)){
        					
        					String unitPrice = Load.inActiveUnits.get(i).price;
        					String totalCreditLimit = Load.totalAvailableCreditLimit;
        					
        					if(Double.parseDouble(totalCreditLimit)- Double.parseDouble(unitPrice)<0){
        						JOptionPane.showMessageDialog(null, "You do not have sufficient funds to launch the unit");
        					}else{
        						
        						double price = Double.parseDouble(totalCreditLimit)- Double.parseDouble(unitPrice);
        						
        						Sea.resourcePoolAvailableLimit.setText("Credit Limit : $" +price);
        						Color myColor = Color.decode("#006400");
        						ConfigProps.TOTAL_CREDIT_LIMIT = String.valueOf(price);

        						if(Double.parseDouble(ConfigProps.TOTAL_CREDIT_LIMIT)>0){
        							Sea.resourcePoolAvailableLimit.setForeground(myColor);
        						}else{
        							Sea.resourcePoolAvailableLimit.setForeground(Color.RED);
        						}
        						Load.totalAvailableCreditLimit=ConfigProps.TOTAL_CREDIT_LIMIT;
        						
        						unitPriceLabel.setText("");
        						
        						String unitComboselectedValue = inActiveUnitsComboBox.getSelectedItem().toString();
        						
        						String arrSplit[] = unitComboselectedValue.split(" ");
        						String color=arrSplit[0];
        						int colorid=0;
        						if(color.equalsIgnoreCase("Blue")){
        							colorid=1;
        						}else{
        							colorid=2;
        						}
        						String unitToLaunch = arrSplit[1];
        						
        						for(int y=0;y<Load.inActiveUnits.size();y++){
        				    		
        				    		if(Load.inActiveUnits.get(y).id.equals(unitToLaunch) && colorid==Load.inActiveUnits.get(y).colorID ){
        				    		
        				    	//		Load.unitList.add(Load.inActiveUnits.get(y));
        				    			if(Load.inActiveUnits.get(y).colorID==1){
        				    					Load.inActiveUnits.get(y).positionX=490;
        				    					Load.inActiveUnits.get(y).positionY=510;
        				    					swapUnit.updateUnit(Load.inActiveUnits.get(y), blueUnits,"Launch");
        				    					//blueUnits.list.add(Load.inActiveUnits.get(i));
        				    			}
        				    			else{
        				    				Load.inActiveUnits.get(y).positionX=490;
        			    					Load.inActiveUnits.get(y).positionY=510;
        				    				swapUnit.updateUnit(Load.inActiveUnits.get(y), redUnits,"Launch");
        				    				//redUnits.list.add(Load.inActiveUnits.get(i));
        				    			}
        				    			
        				    			Load.unitList.add(Load.inActiveUnits.get(y));
        				    			
        				    			
        				    			swapUnit.updateComboBox(blueComboBox, blueUnits);
        				    	    	swapUnit.updateComboBox(redComboBox,redUnits);
        				    	    	swapUnit.updateStatus(redUnits.list,blueUnits.list);
        				    	       	redComboBox.setSelectedIndex(0);
        				    	       	
        				    	       	
        				    	       	
        				    	       	
        				    	       	Load.inActiveUnits.remove(y);
        				    	       	
        				    	       	
        				    	      String[] arrInActiveUnits = new String[Load.inActiveUnits.size() +1];
        				    			  arrInActiveUnits[0] ="Select Unit";
        				    			  
        				    			  for(int x=0;x<Load.inActiveUnits.size();x++){
        				    				  
        				    				  
        				    				  if(Load.inActiveUnits.get(x).colorID==1){
        				    					  arrInActiveUnits[x+1] = "Blue " + Load.inActiveUnits.get(x).id;
        				    				  }else{
        				    					  arrInActiveUnits[x+1] = "Red " + Load.inActiveUnits.get(x).id;
        				    				  }
        				    				  
        				    			  }
        				    			  
        				    			DefaultComboBoxModel model = new DefaultComboBoxModel(arrInActiveUnits);
        				    			Sea.inActiveUnitsComboBox.setModel(model);
        				    			  
        				    			
        				    			String blueUnitsLabel="";
        				    			String redUnitsLabel="";
        				    			int blueUnitsCount=0;
        				    			int redUnitsCount=0;
        				    			
        				    			for(int x=0;x<Load.unitList.size();x++){
        				    				if(Load.unitList.get(x).colorID==1){
        				    				blueUnitsLabel+=Load.unitList.get(x).id+",";
        				    				blueUnitsCount=blueUnitsCount+1;
        				    				}
        				    				else{
        				    				redUnitsLabel+=Load.unitList.get(x).id+",";
        				    				redUnitsCount = redUnitsCount +1;
        				    				}
        				    			}
        				    			
        				    	       	
        				    	       	repaint();
        				    	       	blueUnitsTextField.setText("[" + blueUnitsCount + "]" + " Blue Units:  " + blueUnitsLabel);
        				    	       	redUnitsTextField.setText("[" + redUnitsCount + "]" + " Red Units:  " + redUnitsLabel);
        				    	       	
        				    	       	
        				    			break;
        				    		}
        				    	}
        						
        					
        					
        					}
        				}
        			}
        		
        			
            	
        			
					
					
				
				}
				
				
				
				
			}

			
        });
        
        blueGroupButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        blueGroupButton.setForeground(java.awt.Color.blue);
        blueGroupButton.setText("Blue");
        blueGroupButton.setBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 1, true));
        blueGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueGroupButtonActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel20.setText("Mode: ");

        redSeekModeButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        redSeekModeButton.setForeground(java.awt.Color.red);
        redSeekModeButton.setText("Seek");
        redSeekModeButton.setToolTipText("Seek for a Target");
        redSeekModeButton.setBorder(null);
        redSeekModeButton.setBorderPainted(false);
        redSeekModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        redSeekModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redSeekModeButtonActionPerformed(evt);
            }
        });

        redTrackModeButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        redTrackModeButton.setForeground(java.awt.Color.red);
        redTrackModeButton.setText("Track");
        redTrackModeButton.setToolTipText("Track a Target");
        redTrackModeButton.setAlignmentY(0.0F);
        redTrackModeButton.setBorder(null);
        redTrackModeButton.setBorderPainted(false);
        redTrackModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        redTrackModeButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        redTrackModeButton.setMaximumSize(new java.awt.Dimension(31, 10));
        redTrackModeButton.setMinimumSize(new java.awt.Dimension(31, 10));
        redTrackModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redTrackModeButtonActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jLabel21.setText("Mode: ");

        blueSeekModeButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        blueSeekModeButton.setForeground(java.awt.Color.blue);
        blueSeekModeButton.setText("Seek");
        blueSeekModeButton.setToolTipText("Seek for a Target");
        blueSeekModeButton.setBorder(null);
        blueSeekModeButton.setBorderPainted(false);
        blueSeekModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        blueSeekModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueSeekModeButtonActionPerformed(evt);
            }
        });

        blueAutoModeButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        blueAutoModeButton.setForeground(java.awt.Color.blue);
        blueAutoModeButton.setText("Auto");
        blueAutoModeButton.setToolTipText("Track a Target");
        blueAutoModeButton.setAlignmentY(0.0F);
        blueAutoModeButton.setBorder(null);
        blueAutoModeButton.setBorderPainted(false);
        blueAutoModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        blueAutoModeButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        blueAutoModeButton.setMaximumSize(new java.awt.Dimension(31, 10));
        blueAutoModeButton.setMinimumSize(new java.awt.Dimension(31, 10));
        blueAutoModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueAutoModeButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setRequestFocusEnabled(false);
        jSeparator5.setVerifyInputWhenFocusTarget(false);

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        redAutoModeButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        redAutoModeButton.setForeground(java.awt.Color.red);
        redAutoModeButton.setText("Auto");
        redAutoModeButton.setToolTipText("Track a Target");
        redAutoModeButton.setAlignmentY(0.0F);
        redAutoModeButton.setBorder(null);
        redAutoModeButton.setBorderPainted(false);
        redAutoModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        redAutoModeButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        redAutoModeButton.setMaximumSize(new java.awt.Dimension(31, 10));
        redAutoModeButton.setMinimumSize(new java.awt.Dimension(31, 10));
        redAutoModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redAutoModeButtonActionPerformed(evt);
            }
        });

        blueTrackModeButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        blueTrackModeButton.setForeground(java.awt.Color.blue);
        blueTrackModeButton.setText("Track");
        blueTrackModeButton.setToolTipText("Track a Target");
        blueTrackModeButton.setAlignmentY(0.0F);
        blueTrackModeButton.setBorder(null);
        blueTrackModeButton.setBorderPainted(false);
        blueTrackModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        blueTrackModeButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        blueTrackModeButton.setMaximumSize(new java.awt.Dimension(31, 10));
        blueTrackModeButton.setMinimumSize(new java.awt.Dimension(31, 10));
        blueTrackModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueTrackModeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
         //      next line is used to add "Seek" button for the red unit
             //           .addComponent(redSeekModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                   //    .addGap(3, 3, 3)
                        //next lline used to add more gap when seek button is disabled
                        .addGap(40,40,40)
                        .addComponent(redTrackModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(redAutoModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                           
                        		
                                //      next line is used to add "Seek" button for the red unit
                        	//	.addComponent(blueSeekModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //  .addGap(3, 3, 3)
                        		//next lline used to add more gap when seek button is disabled
                        		.addGap(40,40,40)
                            .addComponent(blueTrackModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(blueAutoModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                            .addComponent(blueGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)))))
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(unitTitleLabel)
                        .addGap(1, 1, 1)
                        .addComponent(unitNumberLable)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statusPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(statusDetectedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(statusPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(statusViewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                           
                            .addGroup(statusPanelLayout.createSequentialGroup()
                            .addComponent(launchUnitLabel)
                            .addComponent(inActiveUnitsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(1, 1, 1)
                            .addComponent(unitPriceLabel)
                            .addGap(42, 42, 42)
                            .addComponent(launchUnitButton)
                        
                           
                            
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(groupTitleLabel)
                            .addComponent(redGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusDetectedLabel)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(unitNumberLable)
                                .addComponent(unitTitleLabel))
                            .addGroup(statusPanelLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(statusViewLabel)))))
                .addGap(10, 10, 10)
                .addComponent(launchUnitLabel)
                .addComponent(inActiveUnitsComboBox)
                .addComponent(unitPriceLabel)
                .addComponent(launchUnitButton)
                .addComponent(groupTitleLabel)
               
                
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statusPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(statusPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blueGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(statusPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       
                                		//      next line is used to add "Seek" button for the red unit	
                               //    .addComponent(blueSeekModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blueAutoModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blueTrackModeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                             //      next line is used to add "Seek" button for the red unit

                     //       .addComponent(redSeekModeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(redTrackModeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(redAutoModeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        updatesTextArea.setEditable(false);
        updatesTextArea.setColumns(20);
        updatesTextArea.setRows(5);
     //   updatesTextArea.setText("Unit 1: Auto target assessment - low value target\nUnit 1: Target detected [A,4]\nUnit 3: Auto target assessment - high value target\nUnit 3: Target detected [D,6]\nCenteral  Command: Assist in search and rescue for \ndowned aircrow [C,2]\n\nUnit 5: Auto target assessment - low value target\n");
        updatesTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 2, true), "Activity Feed", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane2.setViewportView(updatesTextArea);

        redUnitLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        redUnitLabel.setForeground(java.awt.Color.red);
        redUnitLabel.setText("Red Units:");

        redUnitsTextField.setEditable(false);
        redUnitsTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        redUnitsTextField.setForeground(java.awt.Color.red);
        redUnitsTextField.setFocusable(false);
        redUnitsTextField.setRequestFocusEnabled(false);
        redUnitsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redUnitsTextFieldActionPerformed(evt);
            }
        });

        blueUnitLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        blueUnitLabel.setForeground(java.awt.Color.blue);
        blueUnitLabel.setText("Red Units:");

        blueUnitsTextField.setEditable(false);
        blueUnitsTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        blueUnitsTextField.setForeground(java.awt.Color.blue);
        blueUnitsTextField.setFocusable(false);
        blueUnitsTextField.setRequestFocusEnabled(false);
        blueUnitsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueUnitsTextFieldActionPerformed(evt);
            }
        });

       /* try {
			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/play.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        playSTopLable.setIcon(new javax.swing.ImageIcon(getImage("/play.png"))); // NOI18N
        playSTopLable.setToolTipText("Play and Stop The Game");
        playSTopLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playSTopLableMouseClicked(evt);
            }
        });

        /*try {
     			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/close.png"));
     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}*/
             
        closeLable.setIcon(new javax.swing.ImageIcon(getImage("/close.png"))); // NOI18N
        closeLable.setToolTipText("Close and Exit The Game");
        closeLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLableMouseClicked(evt);
            }
        });
        
        

///////////////////////////////////////////////////////
        blueComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        blueComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueComboBoxActionPerformed(evt);
            }
        });
        
        blueComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                blueComboBoxFocusGained(evt);
            }
        });
        
        
 ////////////////////////////////////////////////////////////////////////////
        redComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        redComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redComboBoxActionPerformed(evt);
            }
        });
        
        redComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                redComboBoxFocusGained(evt);
            }
        });
        
        
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
      /*  try {
			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/right-red-arrow.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        redArrowabel.setIcon(new javax.swing.ImageIcon(getImage("/right-red-arrow.png"))); // NOI18N
        
        redArrowabel.setToolTipText("Move a Red Unit to a Blue Group");
        redArrowabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redArrowabelMouseClicked(evt);
            }
        });

       /* try {
			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/left-blue-arrow.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        blueArrowLabel.setIcon(new javax.swing.ImageIcon(getImage("/left-blue-arrow.png"))); // NOI18N
        
        blueArrowLabel.setToolTipText("Move a Blue Unit to a Red Group");
        blueArrowLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blueArrowLabelMouseClicked(evt);
            }
        });
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        groupProxComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Blue", "Red" }));
        groupProxComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                //groupProxComboBoxMouseReleased(evt);
            }
        });
        groupProxComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupProxComboBoxActionPerformed(evt);
            }
        });

        groupCohComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Blue", "Red" }));
        groupCohComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupCohComboBoxActionPerformed(evt);
            }
        });

        //PilotPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 2, true), "Pilot Task", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        PilotPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 2, true), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        PilotPanel.setForeground(java.awt.Color.darkGray);

        briefingButton.setBackground(new java.awt.Color(102, 153, 255));
        briefingButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        briefingButton.setText("Briefing");
        briefingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                briefingButtonActionPerformed(evt);
            }
        });

        
        statusButton.setBackground(new java.awt.Color(102, 153, 255));
        statusButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusButton.setText("Status");
        statusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusButtonActionPerformed(evt);
            }
        });

        FlightPathButton.setBackground(new java.awt.Color(102, 153, 255));
        FlightPathButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FlightPathButton.setText("Overlay");
        FlightPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightPathButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PilotPanelLayout = new javax.swing.GroupLayout(PilotPanel);
        PilotPanel.setLayout(PilotPanelLayout);
        PilotPanelLayout.setHorizontalGroup(
            PilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilotPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(briefingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(statusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FlightPathButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        PilotPanelLayout.setVerticalGroup(
            PilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilotPanelLayout.createSequentialGroup()
                .addGroup(PilotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FlightPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(briefingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                   
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(gue.getContentPane());
        gue.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(redUnitLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(closeLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playSTopLable)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redUnitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(redGroupTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redArrowabel)))
                        .addGap(30, 30, 30)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(blueUnitLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(blueUnitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blueArrowLabel)
                                .addGap(5, 5, 5)
                                .addComponent(blueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(blueGroupTitleLabel)
                                .addGap(165, 165, 165)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(TargetDetectTitleLabel)
                                        .addGap(5, 5, 5)
                                        .addComponent(targetDetectedLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(targetInterceptedTitleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(targetInterceptedLabel)
                                        .addComponent(resourcePoolAvailableLimit))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(chohesionTitleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(groupCohComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PilotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cohesionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proximitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(proximityTitleLabel)
                                .addGap(8, 8, 8)
                                .addComponent(groupProxComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TargetDetectTitleLabel)
                                            .addComponent(targetDetectedLabel))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(targetInterceptedTitleLabel)
                                            .addComponent(targetInterceptedLabel)
                                            .addComponent(resourcePoolAvailableLimit))
                                        .addGap(5, 5, 5)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(playSTopLable)
                                        .addComponent(closeLable)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(chohesionTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(groupCohComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(blueArrowLabel)
                                                .addGap(2, 2, 2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(blueGroupTitleLabel)
                                                    .addComponent(blueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(1, 1, 1)))
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(blueUnitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(blueUnitLabel)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(redArrowabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(redComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(redGroupTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(redUnitsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(redUnitLabel))))
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cohesionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(proximityTitleLabel)
                                    .addComponent(groupProxComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(proximitySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(PilotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(this, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2))
        );
        
        
        redUnitsTextField.setText("0 Red Units:       ");
        redUnitsTextField.setBackground(RED_COLOUR);
        redUnitsTextField.setForeground(WHITE_COLOUR);
        
             
        blueUnitsTextField.setText("0 Blue Units:       ");
        blueUnitsTextField.setBackground(BLUE_COLOUR);
        blueUnitsTextField.setForeground(WHITE_COLOUR);
        
        Font font = new Font("Tahoma", Font.BOLD,12);
        redUnitsTextField.setFont(font);
        blueUnitsTextField.setFont(font);
        
        //redUnitsTextField.enable(false);
        //blueUnitsTextField.enable(false);
        redUnitsTextField.setEditable(false);
        blueUnitsTextField.setEditable(false);
        
        //statusViewLabel.setBackground(Color.yellow);
        
        //cohesionSlider.setValue(0);
        //proximitySlider.setValue(0);
        
        
        // Initialize red and blue combo box
        blueComboBox.setSelectedIndex(0);
        redComboBox.setSelectedIndex(0);
        
        // Update status
        statusDetectedLabel.setEnabled(false);
        statusViewLabel.setEnabled(false);
        
        
        //proximity initialization
        groupProxComboBox.setSelectedIndex(0);
        groupCohComboBox.setSelectedIndex(0);
        
        // Red Group Buttons
        redSeekModeButton.setEnabled(false);
        redTrackModeButton.setEnabled(false);
        redAutoModeButton.setEnabled(false);
        
        //Blue Group Buttons
        blueSeekModeButton.setEnabled(false);
        blueTrackModeButton.setEnabled(false);
        blueAutoModeButton.setEnabled(false);
        
        // Pilot task
        //FlightPathButton.setEnabled(false);
        briefingButton.setEnabled(false);
        
       
        controlDisabling();
        
        gue.pack();
        gue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gue.setLocationRelativeTo(null);
        gue.setVisible(true);
        
        
        
  
        
        
      //  gue.setSize( 1024, 768 );
        
        
        /*Load.loadActivityFeed(AdminMain.scenarioName);
        
        int seconds = Integer.parseInt(ConfigProps.DISCO_TIMER);
        seconds=seconds-1;
        String timertype = ConfigProps.DISCO_TIMER_TYPE;
        String displaytype = ConfigProps.DISCO_TIMER_DISPLAY;
        if(timertype.equals("UPWARDS")){
        	
        	if(displaytype.equals("MINUTES"))
        	startUpTimerMinutes(seconds);
        	else
        	startUpTimerSeconds(seconds);
        }else{
        	//Code for timer to d
        }*/
       
        

    }// </editor-fold>//GEN-END:initComponents

    
///////////////////////////////////////// Timer Controlled Methods /////////////////////////////////////////////////////////////////
    
  

	private void startUpTimerSeconds(final int seconds) {
    	

    	int delay = 1000;
        int period = 1000;
        timer = new java.util.Timer("GameTimer");
    	 timer.scheduleAtFixedRate(new TimerTask() {

    	        public void run() {
    	        	setInterval(seconds);
    	        	TargetDetectTitleLabel.setText("Time: " + interval +"");
    	        	if(isCompleted){
    	        		JOptionPane.showMessageDialog(null, "Time Limit Over.\nPlease Click OK to Exit from the Game");
    	        		isCompleted=false;
    	            	System.exit(0);
    	        	}
    	        	
    	        	}
    	    }, delay, period);
		
	
    }

	private void startUpTimerMinutes(final int seconds) {
    	int delay = 1000;
        int period = 1000;
        timer = new java.util.Timer();
    	 timer.scheduleAtFixedRate(new TimerTask() {

    	        public void run() {
    	        	setInterval(seconds);
    	        	if(interval%60==0){
    	        		int min = interval/60;
    	        		TargetDetectTitleLabel.setText("Time Elapsed: " + min + " min " + "0" + " sec");
    	        	} else{
    	        		
    	        		int min = interval/60;
    	        		if(min>0){
    	        			int sec = interval - (min*60);
    	        			TargetDetectTitleLabel.setText("Time Elapsed: " + min + " min " + sec +  " sec");
    	        		}else{
    	        			TargetDetectTitleLabel.setText("Time Elapsed: 0 min " + interval + " sec");
    	        		}
    	        		
    	        	}
    	        	if(isCompleted){
    	        		JOptionPane.showMessageDialog(null, "Time Limit Over.\nPlease Click OK to Exit from the Game");
    	        		isCompleted=false;
    	            	System.exit(0);
    	        	}
    	        	
    	        	}
    	    }, delay, period);
		
	}
    
    
    private static final int setInterval(int limit) {
        if (interval == limit){
        	timer.cancel();
        	isCompleted=true;
        	
        }
        interval = interval +1;
        return interval;
    }
    
    
    

///////////////////////////////////////// Action Performed Methods /////////////////////////////////////////////////////////////////

    

	protected void statusDetectedLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusDetectedLabelMouseClicked
       //System.out.println(" ************************************ ");        // TODO add your handling code here:
    }//GEN-LAST:event_statusDetectedLabelMouseClicked

   
       
    protected void playSTopLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playSTopLableMouseClicked
        //System.out.println(" ####### Muse clickec and should change icon ####### " );
    	playSTop_clicked();
    }//GEN-LAST:event_playSTopLableMouseClicked

    
    void playSTop_clicked(){
    	
    	if (!stop) {
    		
    		controlEnabling();
    		
    		if ( blueUnits.list.size() !=0 ) {
    			blueUnits.groupButton_clicked();
    			
    	 	} 
    		
    		if (redUnits.list.size() !=0 ) {
    			
    			redUnits.groupButton_clicked();
    			
    	 	}
    		
    		/*try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	  	*/playSTopLable.setIcon(new javax.swing.ImageIcon
    	  			(getImage("/stop.png")));
    	  	stop = true;
    	} else {
    		
    		if ( blueUnits.isActive ) {
    			blueUnits.groupButton_clicked();
    			//blueSeekButton_clicked();
    	 	} 
    		
    		if (redUnits.isActive ) {
    			redUnits.groupButton_clicked();
    			//redSeekButton_clicked();
    	 	}
    		
    		controlDisabling();
    		
    		/*try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/play.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		*/playSTopLable.setIcon(new javax.swing.ImageIcon
    	  			(getImage("/play.png")));
    		stop = false;
    	}
   }
    
    
    protected void closeLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLableMouseClicked
                   System.exit(0);
// TODO add your handling code here:
    }//GEN-LAST:event_closeLableMouseClicked
    
    
   
    
    
    // ************Red Unit ACtions Start here*********** ///////////////////////////
    
    
    
    protected void redGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redGroupButtonActionPerformed
    	
    	
    	redGroupButtonPressed+=1;
    	
    	//System.out.println("siz eof target list is " + ((Load) this).targetList.size());
		
		for (int i = 0; i< ((Load) this).targetList.size(); i++){
			//((Load) this).targetList
			
		}
		
		
    	if ( !redUnits.list.isEmpty() ) {
    		redUnits.groupButton_clicked();
        	
    	}
    	
    	
    }//GEN-LAST:event_redGroupButtonActionPerformed
    
    /*public void redGroupButton_clicked() {
        //on button clicked
        if(!redUnits.isActive)
        {
        	redUnits.setTrackedTagrgetID(0); 
        	//logic here
        	redSeekButton_clicked();
        	redUnits.setActive(true); 
        	redGroupButton.setForeground(java.awt.Color.red);
        	((Load) this).mFactory.createMessage(((Load) this).redUnitList.get(0), 1);
        	
        	// Red Group Buttons
            redSeekModeButton.setEnabled(true);
            redTrackModeButton.setEnabled(true);
            redAutoModeButton.setEnabled(true);
            
            if(blueUnits.isActive)
            	blueGroupButton_clicked();
            
            //Blue Group Buttons
            blueSeekModeButton.setEnabled(false);
            blueTrackModeButton.setEnabled(false);
            blueAutoModeButton.setEnabled(false);
            
        } //!redGroup option
        
        //off button clicked
        else if(redUnits.isActive)
        { 
        	
        	if (redUnits.onAutoMode)
        		redAutoMode_clicked();
        	
        	if (redUnits.isTracking  ){
        		redTrackButton_clicked();
            }
        	
        	if (redUnits.isSeeking ){
        		redSeekButton_clicked();
            }
        	
        	
        	redUnits.setActive(false);
        	redGroupButton.setForeground(java.awt.Color.GRAY);
        	
        	// Red Group Buttons
            redSeekModeButton.setEnabled(false);
            redTrackModeButton.setEnabled(false);
            redAutoModeButton.setEnabled(false);
            
            //Blue Group Buttons
            blueSeekModeButton.setEnabled(false);
            blueTrackModeButton.setEnabled(false);
            blueAutoModeButton.setEnabled(false);
            
        	
        }
    } // end seek action method

    
    
*/    protected void redSeekModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redSeekModeButtonActionPerformed
    
	redGroupSeekModeButtonPressed+=1;
	
	
	
	
    	if (!redUnits.isActive) { // cannot track as all units are inactive
    		
    		return;
    	}
    	
    	if (redUnits.isTracking) { // stop tracking
        	
    		redUnits.trackButton_clicked();
        	
    	}
    	
    	redUnits.seekButton_clicked();
        ((Load)this).render();  //call render in the child object load
    	// TODO add your handling code here:
    }//GEN-LAST:event_seekModeButtonActionPerformed

    
    /*public void redSeekButton_clicked()
    {
        //on button clicked
        if(!redUnits.isSeeking)
        {
            //logic here
        	redUnits.setSeeking(true); 
            redSeekModeButton.setText("");
            try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/red-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            redSeekModeButton.setIcon(new javax.swing.ImageIcon
            		(bufferedImage));
            ((Load) this).mFactory.createMessage(((Load) this).redUnitList.get(0), 2);
            
            for(Unit unit: ((Load) this).redUnitList)  
            	unit.startSeeking((Load) this, redUnits, ((Load) this).redUnitList, ((Load) this).redSearchRedius);
       }
        
        //off button clicked
        else if(redUnits.isSeeking )  
        {
            //logic here
        	redUnits.setSeeking(false);
            redSeekModeButton.setIcon(null);
            redSeekModeButton.setText("Seek");
        }
    } // end seek action method
*/    
    
    // Tracking
    protected void redTrackModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redTrackModeButtonActionPerformed
       
    	
    	redGroupTrackModeButtonPressed+=1;
		
		
		
		
    	if ( !redUnits.isActive || 
    			(!redUnits.isReLocating && !redUnits.isSeeking && !redUnits.isTracking)) { // no target to track, no unit are active
    		
    		return;
    	
    	} else if ((redUnits.isReLocating || redUnits.isSeeking) && redUnits.trackedTargetID != null) { // stop seeking and start tracking
    		   redSeekModeButton.setEnabled(false);	
    		
    		if (redUnits.isSeeking)
    		   redUnits.seekButton_clicked();
    	}
    	
    	redUnits.trackButton_clicked();
    	((Load)this).render();  //call render in the child object load
    	
    		    	
    	// TODO add your handling code here:
    }//GEN-LAST:event_trackModeButtonActionPerformed
    
    
    /*public void redTrackButton_clicked()
    {
        //on button clicked
        if(!redUnits.isTracking && redUnits.trackedTargetID != 0 ) {
            
        	//logic here
        	redUnits.setTracking(true); 
            
            // start tracking
            track = new Track();
            //track.makeFrame ();
            track.start ((Load) this, redUnits);
            
            redTrackModeButton.setText("");
            
            try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/red-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            redTrackModeButton.setText("");
            redTrackModeButton.setIcon(new javax.swing.ImageIcon
            		(bufferedImage));
        }
        //off button clicked
        else if (redUnits.isTracking) {
            //logic here
        	redUnits.setTracking(false);
            track.stop(); // delete the object
            track = null;
            
            // reload the units in their orginal locations, need fix
            //((Load) this).loadUnits(((Load) this).scenarioFileName);
            
            //((Load) this).trackedTargetID = 0 ;
            
            redTrackModeButton.setIcon(null);
            redTrackModeButton.setText("");
            redTrackModeButton.setText("Track");
            redSeekModeButton.setEnabled(true);
            redSeekButton_clicked();
            ((Load)this).render(); 
        }
    
    }*/
    
protected void redAutoModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redAutoModeButtonActionPerformed
        
	
	redGroupAutoModeButtonPressed+=1;
	

	
	
    	redUnits.autoMode_clicked();
    	
    }//GEN-LAST:event_redAutoModeButtonActionPerformed
    
   /* void redAutoMode_clicked(){
    	
    	if (!redUnits.onAutoMode) {
    		
    		
    		redUnits.setOnAutoMode(true); 
    		
    		redAutoModeButton.setText("");
    		try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/red-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		redAutoModeButton.setIcon(new javax.swing.ImageIcon
    	  			(bufferedImage));
    		
    		    	  	
    	  	if(!redUnits.isSeeking)
    	  	   redSeekButton_clicked();
    	  	
    	  	//disable seek/track buttons
    	  	redSeekModeButton.setEnabled(false);
    	  	redTrackModeButton.setEnabled(false);
    	  	
    	} else {
    		
    		redUnits.setOnAutoMode(false);
    		
    		redAutoModeButton.setIcon(null);
    		redAutoModeButton.setText("Auto");
    		
    		    		
    		if(!redUnits.isSeeking)
     	  	   redSeekButton_clicked();
    		
    		if(redUnits.isTracking) {
        	  	   redTrackButton_clicked();
        	  	   redSeekButton_clicked();
    		}
    		
    		for(Target target: ((Load) this).targetList)
   			 target.loadImage(target.imageType);
    		
    		//enable seek/track buttons
    		redSeekModeButton.setEnabled(true);
    	  	redTrackModeButton.setEnabled(true);
    	}
      
    }
*/

    
    ////////////////////////////////// End of Red Group Tracking ////////////////////////////////////////////////////
    
    
    
    // /////////////////// **** Blue Group Actions Start Here ******* //////////////////////////////////////////////////
    
    protected void blueGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueGroupButtonActionPerformed
        // TODO add your handling code here:
    	
    	
    	blueGroupButtonPressed+=1;
		
		
    //	System.out.println("siz eof target list is " + ((Load) this).targetList.size());

		
    	
    	if ( !blueUnits.list.isEmpty() ) {
    	blueUnits.groupButton_clicked();
    	}
    
    }//GEN-LAST:event_blueGroupButtonActionPerformed
    
    
    /*public void blueGroupButton_clicked() {
        //on button clicked
        if(!blueUnits.isActive)
        {
            
        	blueUnits.setTrackedTagrgetID(0);
        	//logic here
        	blueSeekButton_clicked();
        	blueUnits.setActive(true);
        	//blueGroupButton.setText("Active");
        	blueGroupButton.setForeground(java.awt.Color.blue);
        	((Load) this).mFactory.createMessage(((Load) this).blueUnitList.get(0), 1);
        	
        	//Blue Group Buttons
            blueSeekModeButton.setEnabled(true);
            blueTrackModeButton.setEnabled(true);
            blueAutoModeButton.setEnabled(true);
        	
        	// Red Group Buttons
            redSeekModeButton.setEnabled(false);
            redTrackModeButton.setEnabled(false);
            redAutoModeButton.setEnabled(false);
            
            if(redGroup)
            	redGroupButton_clicked();
            
                       	
            //Blue Group Buttons
            blueSeekModeButton.setEnabled(true);
            blueTrackModeButton.setEnabled(true);
            blueAutoModeButton.setEnabled(true);
            
        }
        //off button clicked
        else if(blueUnits.isActive)  {
            
        	if (blueUnits.onAutoMode)
        		blueAutoMode_clicked();
        	
        	if (blueUnits.isTracking ){
        		blueTrackButton_clicked();
            }
        	
        	if (blueUnits.isSeeking ){
        		
        		blueSeekButton_clicked();
        		
            }
        	
        	
        	      	
        	
        	blueUnits.setActive(false);
            blueGroupButton.setForeground(java.awt.Color.GRAY);
        	
        	// Red Group Buttons
            redSeekModeButton.setEnabled(false);
            redTrackModeButton.setEnabled(false);
            redAutoModeButton.setEnabled(false);
            
            //Blue Group Buttons
            blueSeekModeButton.setEnabled(false);
            blueTrackModeButton.setEnabled(false);
            blueAutoModeButton.setEnabled(false);
            
        	
        	
        }// end of else if statement
    } // end seek action method
*/    
    // Seeking 
    protected void blueSeekModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seekModeButtonActionPerformed
    	
    	
    	blueGroupSeekModeButtonPressed+=1;
		
		
    	
    	if (!blueUnits.isActive) { // cannot track as all units are inactive
    		
    		return;
    	}
    	
    	if (blueUnits.isTracking) { // stop tracking
    		blueSeekModeButton.setEnabled(true);
    		blueUnits.trackButton_clicked();
      	}
    	
    	//System.out.println("Is it seeking"+ blueUnits.isSeeking);    	
    	blueUnits.seekButton_clicked();
        ((Load)this).render();  //call render in the child object load
    	// TODO add your handling code here:
    }//GEN-LAST:event_seekModeButtonActionPerformed

   
   /* public void blueSeekButton_clicked()
    {
        //on button clicked
        if(!blueUnits.isSeeking)
        {
            
        	   	
        	//logic here
        	blueUnits.setSeeking(true);
        	
            blueSeekModeButton.setText("");
            try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/blue-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            blueSeekModeButton.setIcon(new javax.swing.ImageIcon(bufferedImage));
            ((Load) this).mFactory.createMessage(((Load) this).blueUnitList.get(0), 2);
            
            for(Unit unit: ((Load) this).blueUnitList)  
            	unit.startSeeking((Load) this, blueUnits, ((Load) this).blueUnitList, ((Load) this).blueSearchRedius);
            
            //System.out.println("Blue Status: " + blueUnits.isSeeking);
        }        //off button clicked
        else if(blueUnits.isSeeking )
        {
            //logic here
        	blueUnits.setSeeking(false); 
            blueSeekModeButton.setIcon(null);
            blueSeekModeButton.setText("");
            blueSeekModeButton.setText("Seek");
        }
    } // end seek action method
    
*/    // Tracking
    protected void blueTrackModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackModeButtonActionPerformed
        
    	
    	blueGroupTrackModeButtonPressed+=1;
		
	
		
		
    	if ( !blueUnits.isActive || 
    			(!blueUnits.isReLocating && !blueUnits.isSeeking && !blueUnits.isTracking) ) { // no target to track, no unit are active
    		    //System.out.println("Seeking: "+ blueUnits.isSeeking + " And Tracking: " + blueUnits.isSeeking); 
    	 	return;
    	
    	}  else if ((blueUnits.isReLocating || blueUnits.isSeeking) && blueUnits.trackedTargetID != null) { // stop seeking and start tracking
    	
    		blueSeekModeButton.setEnabled(false); 
    		
    		if (blueUnits.isSeeking)
    		  blueUnits.seekButton_clicked();
    	} 
    	
    	
    	blueUnits.trackButton_clicked();
        ((Load)this).render();  //call render in the child object load
  		
        // TODO add your handling code here:
    }//GEN-LAST:event_trackModeButtonActionPerformed
    
    
    /*public void blueTrackButton_clicked()
    {
        //on button clicked
        if(!blueUnits.isTracking && blueUnits.trackedTargetID != 0) {
            //logic here
        	blueUnits.setTracking(true);
        	
            
            // start tracking
            track = new Track();
            //track.makeFrame ();
            track.start ((Load) this, blueUnits);
            
            blueTrackModeButton.setText("");
            try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/blue-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            blueTrackModeButton.setText("");
            blueTrackModeButton.setIcon(new javax.swing.ImageIcon
            		      (bufferedImage));
            
            
        }
        //off button clicked
        else if(blueUnits.isTracking ) {
            //logic here
        	blueUnits.setTracking(false); 
            track.stop(); // delete the object
            track = null;
            
            // reload the units in their orginal locations, need fix
            //((Load) this).loadUnits(((Load) this).scenarioFileName);
            
            //((Load) this).trackedTargetID = 0 ;
            
            blueTrackModeButton.setIcon(null);
            blueTrackModeButton.setText("");
            blueTrackModeButton.setText("Track");
            blueSeekModeButton.setEnabled(true);
            blueSeekButton_clicked();
            ((Load)this).render(); 
        }
    
    }
*/    
protected void blueAutoModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueAutoModeButtonActionPerformed
        
	
	blueGroupAutoModeButtonPressed+=1;
	

	
	
    	blueUnits.autoMode_clicked();
    	// TODO add your handling code here:
    }//GEN-LAST:event_blueAutoModeButtonActionPerformed
    
    
/*void blueAutoMode_clicked() {
    	
    	if (!blueUnits.onAutoMode) {
    		blueAutoModeButton.setText("");
    		try {
    			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream("/blue-stop.png"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		blueAutoModeButton.setIcon(new javax.swing.ImageIcon
    	  			(bufferedImage));
    	  	
    		// update auto mode staus
    		blueUnits.setOnAutoMode(true); 
    	  	
    	  	if(!blueUnits.isSeeking)
      	  	   blueSeekButton_clicked();
    	    
    	    //disable seek/track buttons
    	  	blueSeekModeButton.setEnabled(false);
    	  	blueTrackModeButton.setEnabled(false); 	
    	  	
    	} else {
    		blueAutoModeButton.setIcon(null);
    		blueAutoModeButton.setText("Auto");
    		
    		blueUnits.setOnAutoMode(false); 
    		
    		if(!blueUnits.isSeeking)
      	  	   blueSeekButton_clicked();
    		
    		if(blueUnits.isTracking) {
       	  	   blueTrackButton_clicked();
       	  	   blueSeekButton_clicked();
    		}
    		
    		for(Target target: ((Load) this).targetList)
    			 target.loadImage(target.imageType);
    		
    		//enable seek/track buttons
    		blueSeekModeButton.setEnabled(true);
    	  	blueTrackModeButton.setEnabled(true);
    	}
    	
    }
*/

   
    // //////////////// ******End of Blue Group Action********* ///////////////////////////////
    
    
    

    
    
    protected void cohesionSliderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cohesionSliderMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_cohesionSliderMouseMoved

    protected void cohesionSliderAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_cohesionSliderAncestorMoved
          // TODO add your handling code here:
    }//GEN-LAST:event_cohesionSliderAncestorMoved

    
    protected void cohesionSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cohesionSliderStateChanged
        
    	//System.out.println("Chohesion Slider Is Changed " + (double) cohesionSlider.getValue()/100.0);
    	
    	//((Load)this). cohesion = (double) ( cohesionSlider.getValue() / 100.0);
    	
    
    	if (groupCohComboBox.getSelectedIndex() != 0) {
        	
    		if (groupCohComboBox.getSelectedIndex() == 1) {
    		
    			blueUnits.searchRadius = (double) ( cohesionSlider.getValue() / 100.0);
    			//System.out.println("-- radius -- " + ((Load)this). blueSearchRedius);
    			
    	 } 
    	
    	 
    		if (groupCohComboBox.getSelectedIndex() == 2) {
    		
    			redUnits.searchRadius = (double) ( cohesionSlider.getValue() / 100.0);
    	
    	 }
    	 
    	}
    	
    	
    	
    	// TODO add your handling code here:
    }//GEN-LAST:event_cohesionSliderStateChanged

    protected void proximitySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_proximitySliderStateChanged
    
    	if (groupProxComboBox.getSelectedIndex() != 0) {
    	
    		if (groupProxComboBox.getSelectedIndex() == 1) {
    		
    		blueUnits.proximity = (double) ( proximitySlider.getValue() / 100.0);
    		//for(Unit unit:((Load)this).blueUnitList )
    		
    		for (Unit u:  blueUnits.list) 
            	u.flyTowardsCenterOfMass( blueUnits.list);
    	   	    ((Load)this). keep.groupDistance( blueUnits);
    	    
    	    try {
                Thread.sleep (200);
            }
            catch (InterruptedException e) {
               
            }
    	    
    	    ((Load)this).render();
    	
    	 } 
    	
    	 
    		if (groupProxComboBox.getSelectedIndex() == 2) {
    		
    		redUnits.proximity = (double) ( proximitySlider.getValue() / 100.0);
    		
    		for (Unit u:  redUnits.list) 
            	u.flyTowardsCenterOfMass( redUnits.list);
    		((Load)this). keep.groupDistance(redUnits);
    		
    		 try {
                 Thread.sleep (200);
             }
             catch (InterruptedException e) {
                
             }
    		 
    		 ((Load)this).render();
    	
    	 }
    	 
    	}
    	    	    
    }//GEN-LAST:event_proximitySliderStateChanged
    
    protected void proximitySliderMouseReleased(java.awt.event.MouseEvent evt) {                                              
        
        //groupProxComboBox.setSelectedIndex(0); 
        
    }        
    
    protected void groupProxComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupProxComboBoxActionPerformed
    	

    switch (groupProxComboBox.getSelectedIndex()) {
		
		case 0: proximitySlider.setValue(0);
			    proximitySlider.setEnabled(false);
		        break;
		
		case 1: proximitySlider.setEnabled(true);
		        proximitySlider.setValue((int) (blueUnits.proximity * 100.0));
			    break;
		
		case 2:	proximitySlider.setEnabled(true);
				proximitySlider.setValue((int) (redUnits.proximity * 100.0));
	            break;
			
		default: break;
		
		}
    	
    	// TODO add your handling code here:
    }//GEN-LAST:event_groupProxComboBoxActionPerformed
    
    protected void groupCohComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupCohComboBoxActionPerformed

    	switch (groupCohComboBox.getSelectedIndex()) {
		
		case 0: cohesionSlider.setValue(0);
		        cohesionSlider.setEnabled(false);
		        break;
		
		case 1: cohesionSlider.setEnabled(true);
		        cohesionSlider.setValue( (int) ( blueUnits.searchRadius * 100.0));
			    break;
		
		case 2:	cohesionSlider.setEnabled(true);
		        cohesionSlider.setValue((int) (redUnits.searchRadius * 100.0));
	            break;
			
		default: break;
		
		}
    	
    }//GEN-LAST:event_groupCohComboBoxActionPerformed


    protected void statusDetectedLabelMouseClicked1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusDetectedLabelMouseClicked
       //System.out.println(" ************************************ ");        // TODO add your handling code here:
    }//GEN-LAST:event_statusDetectedLabelMouseClicked

    protected void statusViewLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusViewLabelMouseClicked
        
    	viewTargetButtonPressed+=1;
	
		
    	//if (blueUnits.trackedTargetID !=0 && blueUnits.targetView == null)
    	if (blueUnits.trackedTargetID !=null )
    		//blueUnits.targetView = new TargetView((Load) this, blueUnits);
    		TargetView.loadTargetView((Load) this, blueUnits);
    	
    	//if (redUnits.trackedTargetID !=0 && redUnits.targetView == null)
    	if (redUnits.trackedTargetID !=null )
    		TargetView.loadTargetView((Load) this, redUnits);
    	
    	/*
    	final Load load = (Load) this;
    	java.awt.EventQueue.invokeLater(new Runnable() {
    		
    		
            public void run() {
            	targetView = new TargetView(load);
                                
            }
        });
    	*/
    	
    	//targetView = new TargetView((Load) this);
    	
    	
    	
    	// TODO add your handling code here:
    }//GEN-LAST:event_statusViewLabelMouseClicked

    protected void outShipLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outShipLabelKeyPressed
        // TODO add your handling code here:
        //System.out.println(" ****************************** " );
    }//GEN-LAST:event_outShipLabelKeyPressed

    protected void outShipLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outShipLabelMouseClicked
        // TODO add your handling code here:
        java.awt.event.KeyEvent e = null;
        outShipLabelKeyPressed(e);
    }//GEN-LAST:event_outShipLabelMouseClicked

    protected void inShipLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inShipLabelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_inShipLabelKeyPressed

    protected void inShipLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inShipLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_inShipLabelMouseClicked

    protected void redUnitsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redUnitsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redUnitsTextFieldActionPerformed

    protected void blueUnitsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueUnitsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blueUnitsTextFieldActionPerformed
    
    protected void redArrowabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redArrowabelMouseClicked
        
    	redToBlueSwitchButtonPressed+=1;
		
		
    	
    	// return/stop if there is a unit under move
    	/*if (!blueUnits.inTransitList.isEmpty())
    		return;*/
    	
    	//Load.redUnitList.add(Load.blueUnitList.get(0));
    	
    	String unitid = redComboBox.getSelectedItem().toString();
    	
    	
    	Unit unitToTransfer = null;
    	
    	for(int i=0;i<redUnits.inTransitList.size();i++){
    		
    		if(redUnits.inTransitList.get(i).id.equals(Integer.parseInt(unitid))){
    			unitToTransfer =redUnits.inTransitList.get(i);
    			break;
    		}
    	}
    	
    	
    	Unit unit=null;
    	
    	if(unitToTransfer!=null){
    		redUnits.list.add(unitToTransfer);
    	}
    	
    	
    	
    	if(unitToTransfer==null){
    	
    	
    	unit = new Unit (redUnits.list.get(redComboBox.getSelectedIndex()-1).id, 
    			redUnits.list.get(redComboBox.getSelectedIndex()-1).positionX, 
    			redUnits.list.get(redComboBox.getSelectedIndex()-1).positionY, 
    			redUnits.list.get(redComboBox.getSelectedIndex()-1).speed, 
    			redUnits.list.get(redComboBox.getSelectedIndex()-1).fuelpoints, 
				1,	redUnits.list.get(redComboBox.getSelectedIndex()-1).detectionRadius,"ACTIVE",redUnits.list.get(redComboBox.getSelectedIndex()-1).price,redUnits.list.get(redComboBox.getSelectedIndex()-1).relocationDetectRadius, redUnits.list.get(redComboBox.getSelectedIndex()-1).relocationSpeed);
    	
    	unit.colorID=1;
    			
    	   	
    	Load.unitList.remove(redUnits.list.get(redComboBox.getSelectedIndex()-1));
    	redUnits.list.remove(redComboBox.getSelectedIndex()-1);
    	
    	
    	
    	
    	
    	swapUnit.updateUnit(unit, blueUnits,"BlueSwitch");
    	//blueUnits.list.add(unit);
    	Load.unitList.add(unit);
    	//blueUnits.inTransitList.add(unit);
    	
    	
    	swapUnit.updateComboBox(blueComboBox, blueUnits);
    	swapUnit.updateComboBox(redComboBox,redUnits);
    	swapUnit.updateStatus(redUnits.list,blueUnits.list);
       	redComboBox.setSelectedIndex(0);
    	}else{
    		

        	
        	
        	unit = new Unit (redUnits.list.get(redUnits.list.size()-1).id, 
        			redUnits.list.get(redUnits.list.size()-1).positionX, 
        			redUnits.list.get(redUnits.list.size()-1).positionY, 
        			redUnits.list.get(redUnits.list.size()-1).speed, 
        			redUnits.list.get(redUnits.list.size()-1).fuelpoints, 
    				1,	redUnits.list.get(redUnits.list.size()-1).detectionRadius,"ACTIVE",redUnits.list.get(redUnits.list.size()-1).price,redUnits.list.get(redUnits.list.size()-1).relocationDetectRadius,redUnits.list.get(redUnits.list.size()-1).relocationSpeed);
        	
        	unit.colorID=1;
        			
        	   	
        	Load.unitList.remove(redUnits.list.get(redUnits.list.size()-1));
        	redUnits.list.remove(redUnits.list.size()-1);
        	
        	
        	
        	
        	
        	swapUnit.updateUnit(unit, blueUnits,"BlueSwitch");
        	//blueUnits.list.add(unit);
        	Load.unitList.add(unit);
        	//blueUnits.inTransitList.add(unit);
        	
        	
        	swapUnit.updateComboBox(blueComboBox, blueUnits);
        	swapUnit.updateComboBox(redComboBox,redUnits);
        	swapUnit.updateStatus(redUnits.list,blueUnits.list);
           	redComboBox.setSelectedIndex(0);
        	
           	
           	
    		
    	}
       	
       	// update the list
       	//((Load) this).popUpMenueUpdate();
       	
       	
     	String blueUnitsLabel="";
    		String redUnitsLabel="";	
           	int blueUnitsCount=0;
    		int redUnitsCount=0;
    		
    		for(int x=0;x<Load.unitList.size();x++){
    			if(Load.unitList.get(x).colorID==1){
    			blueUnitsLabel+=Load.unitList.get(x).id+",";
    			blueUnitsCount=blueUnitsCount+1;
    			}
    			else{
    			redUnitsLabel+=Load.unitList.get(x).id+",";
    			redUnitsCount = redUnitsCount +1;
    			}
    		}
    		
           	
           //	repaint();
           	blueUnitsTextField.setText("[" + blueUnitsCount + "]" + " Blue Units:  " + blueUnitsLabel);
           	redUnitsTextField.setText("[" + redUnitsCount + "]" + " Red Units:  " + redUnitsLabel);
           	
           	
       	
       	repaint();

    	        
    	// TODO add your handling code here:
    }//GEN-LAST:event_redArrowabelMouseClicked

    protected void blueArrowLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blueArrowLabelMouseClicked
    	
    	blueToRedSwitchButtonPressed+=1;
		
		
		
    	
    	// return if there is a unit under move
    	/*if (!redUnits.inTransitList.isEmpty())
    		return;*/
    	
    	//Load.redUnitList.add(Load.blueUnitList.get(0));
    	//get the unit id from the selector
    	
    	//check if it is in the transit list
    	//if it is in the transit list, remove it
    	//do not re initialize a new unit, instead use the unit specifications from the transit list
    	//stop the launch thread for the transit unit
    	
    	String unitid = blueComboBox.getSelectedItem().toString();
    	
    	Unit unitToTransfer = null;
    	
    	for(int i=0;i<blueUnits.inTransitList.size();i++){
    		
    		if(blueUnits.inTransitList.get(i).id.equals(unitid)){
    			unitToTransfer =blueUnits.inTransitList.get(i);
    			break;
    		}
    	}
    	
    	
    	Unit unit=null;
    	
    	if(unitToTransfer!=null){
    		blueUnits.list.add(unitToTransfer);
    	}
    	
    	if(unitToTransfer==null)
    	{
    	
    	unit = new Unit (blueUnits.list.get(blueComboBox.getSelectedIndex()-1).id, 
    			blueUnits.list.get(blueComboBox.getSelectedIndex()-1).positionX, 
    			blueUnits.list.get(blueComboBox.getSelectedIndex()-1).positionY, 
    			blueUnits.list.get(blueComboBox.getSelectedIndex()-1).speed, 
    			blueUnits.list.get(blueComboBox.getSelectedIndex()-1).fuelpoints, 
				0, 	blueUnits.list.get(blueComboBox.getSelectedIndex()-1).detectionRadius,"ACTIVE",blueUnits.list.get(blueComboBox.getSelectedIndex()-1).price,blueUnits.list.get(blueComboBox.getSelectedIndex()-1).relocationDetectRadius,blueUnits.list.get(blueComboBox.getSelectedIndex()-1).relocationSpeed);
   
    	unit.colorID=2;
    			
    	
    	
    	Load.unitList.remove(blueUnits.list.get(blueComboBox.getSelectedIndex()-1));
    	blueUnits.list.remove(blueComboBox.getSelectedIndex()-1);
    	
    	
    	swapUnit.updateUnit(unit, redUnits,"RedSwitch");
    	//redUnits.list.add(unit);
    	Load.unitList.add(unit);
    	
    	
    	swapUnit.updateComboBox(blueComboBox, blueUnits);
    	swapUnit.updateComboBox(redComboBox,redUnits);
    	swapUnit.updateStatus(blueUnits.list, redUnits.list);
       	blueComboBox.setSelectedIndex(0);
    	}else{
    		
    		
    		unit = new Unit (blueUnits.list.get(blueUnits.list.size()-1).id, 
        			blueUnits.list.get(blueUnits.list.size()-1).positionX, 
        			blueUnits.list.get(blueUnits.list.size()-1).positionY, 
        			blueUnits.list.get(blueUnits.list.size()-1).speed, 
        			blueUnits.list.get(blueUnits.list.size()-1).fuelpoints, 
    				0, 	blueUnits.list.get(blueUnits.list.size()-1).detectionRadius,"ACTIVE",blueUnits.list.get(blueComboBox.getSelectedIndex()-1).price,blueUnits.list.get(blueUnits.list.size()-1).relocationDetectRadius, blueUnits.list.get(blueUnits.list.size()-1).relocationSpeed);
       
        	unit.colorID=2;
        			
        	
        	
        	Load.unitList.remove(blueUnits.list.get(blueUnits.list.size()-1));
        	blueUnits.list.remove(blueUnits.list.size()-1);
        	
        	
        	swapUnit.updateUnit(unit, redUnits,"RedSwitch");
        	//redUnits.list.add(unit);
        	Load.unitList.add(unit);
        	
        	
        	swapUnit.updateComboBox(blueComboBox, blueUnits);
        	swapUnit.updateComboBox(redComboBox,redUnits);
        	swapUnit.updateStatus(blueUnits.list, redUnits.list);
           	blueComboBox.setSelectedIndex(0);
           	
           	
           	
    	}
       	//((Load) this).popUpMenueUpdate();
       	
       	String blueUnitsLabel="";
		String redUnitsLabel="";	
       	int blueUnitsCount=0;
		int redUnitsCount=0;
		
		for(int x=0;x<Load.unitList.size();x++){
			if(Load.unitList.get(x).colorID==1){
			blueUnitsLabel+=Load.unitList.get(x).id+",";
			blueUnitsCount=blueUnitsCount+1;
			}
			else{
			redUnitsLabel+=Load.unitList.get(x).id+",";
			redUnitsCount = redUnitsCount +1;
			}
		}
		
       	
       //	repaint();
       	blueUnitsTextField.setText("[" + blueUnitsCount + "]" + " Blue Units:  " + blueUnitsLabel);
       	redUnitsTextField.setText("[" + redUnitsCount + "]" + " Red Units:  " + redUnitsLabel);
       	
       	
       	
       	
       	repaint();
       	
    }//GEN-LAST:event_blueArrowLabelMouseClicked

    
    protected void blueComboBoxFocusGained(java.awt.event.FocusEvent evt) {                                         
    	swapUnit.updateComboBox(blueComboBox, blueUnits);
    }   
        
    protected void blueComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueComboBoxActionPerformed
        
    	
    	if ( blueComboBox.getSelectedIndex() != 0 ) {
    		blueArrowLabel.setEnabled(true);
    		    		
    	} else {
    		blueArrowLabel.setEnabled(false);
    	}
    	// TODO add your handling code here:
    }//GEN-LAST:event_blueComboBoxActionPerformed

   
    protected void redComboBoxFocusGained(java.awt.event.FocusEvent evt) {                                         
    	swapUnit.updateComboBox(redComboBox,redUnits);
    	//swapUnit.updateComboBox(blueComboBox,blueUnits);
    	
    } 
    
    protected void redComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redComboBoxActionPerformed
        
    	if ( redComboBox.getSelectedIndex() != 0 ) {
    		redArrowabel.setEnabled(true);
    		
    	} else {
    		redArrowabel.setEnabled(false);
    	}
    		
    	
    }//GEN-LAST:event_redComboBoxActionPerformed
    
       
    
    protected void briefingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briefingButtonActionPerformed
        //System.out.println("Ohhhhhhhh");// TODO add your handling code here:
    	
    	briefingButtonPressed+=1;
		
	
		
		
        final PilotTaskMessage task = new PilotTaskMessage();
        FlightPathButton.setEnabled(true);
        
        //Commented by Praveen
      /*  new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	task.dispose();
            	
            }
        }).start();*/
        
    }//GEN-LAST:event_briefingButtonActionPerformed
    
    protected void statusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_briefingButtonActionPerformed
        //System.out.println("Ohhhhhhhh");// TODO add your handling code here:
    	
    	statusButtonPressed+=1;
		
		
		
		
        final Status task = new Status();
        FlightPathButton.setEnabled(true);
        
        //Commented by Praveen
      /*  new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	task.dispose();
            	
            }
        }).start();*/
        
    }

    
    protected void FlightPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightPathButtonActionPerformed
        
    	
    	
    	overlayButtonPressed+=1;
		
		
        
    	Load.showOverlay();
        
    	
    }//GEN-LAST:event_FlightPathButtonActionPerformed

    
    void updateLableColor(javax.swing.JLabel lable, int red, int green, int blue){
    	
    	Color myColor = new Color(red, green, blue);
    	lable.setBackground(myColor);
    	lable.setOpaque(true);
    	
    }

    void controlDisabling(){
    	
    	//disable game controls
    	TargetDetectTitleLabel.setEnabled(false);
    	targetDetectedLabel.setEnabled(false);
    	targetInterceptedTitleLabel.setEnabled(false);
    	targetInterceptedLabel.setEnabled(false);
    	chohesionTitleLabel.setEnabled(false);
    	groupCohComboBox.setEnabled(false);
    	cohesionSlider.setEnabled(false);
    	proximityTitleLabel.setEnabled(false);
    	groupProxComboBox.setEnabled(false);
    	proximitySlider.setEnabled(false);
    	unitTitleLabel.setEnabled(false);
    	unitNumberLable.setEnabled(false);
    	//statusDetectedLabel.setEnabled(false);
    	//statusViewLabel.setEnabled(false);
    	redGroupButton.setEnabled(false);
    	blueGroupButton.setEnabled(false);
    	updatesTextArea.setEnabled(false);
    	redGroupTitleLabel.setEnabled(false);
    	redComboBox.setEnabled(false);
    	redArrowabel.setEnabled(false);
    	blueGroupTitleLabel.setEnabled(false);
    	blueComboBox.setEnabled(false);
    	blueArrowLabel.setEnabled(false);
    	briefingButton.setEnabled(false);
    	
    	
    }
    
 
    void controlEnabling(){
    	
    	//enable game controls
    	TargetDetectTitleLabel.setEnabled(true);
    	targetDetectedLabel.setEnabled(true);
    	targetInterceptedTitleLabel.setEnabled(true);
    	targetInterceptedLabel.setEnabled(true);
    	chohesionTitleLabel.setEnabled(true);
    	groupCohComboBox.setEnabled(true);
    	cohesionSlider.setEnabled(true);
    	proximityTitleLabel.setEnabled(true);
    	groupProxComboBox.setEnabled(true);
    	proximitySlider.setEnabled(true);
    	unitTitleLabel.setEnabled(true);
    	unitNumberLable.setEnabled(true);
    	statusDetectedLabel.setEnabled(true);
    	statusViewLabel.setEnabled(true);
    	redGroupButton.setEnabled(true);
    	blueGroupButton.setEnabled(true);
    	updatesTextArea.setEnabled(true);
    	redGroupTitleLabel.setEnabled(true);
    	redComboBox.setEnabled(true);
    	redArrowabel.setEnabled(true);
    	blueGroupTitleLabel.setEnabled(true);
    	blueComboBox.setEnabled(true);
    	blueArrowLabel.setEnabled(true);
    	briefingButton.setEnabled(true);
    	
    }
    
    
    
   
    BufferedImage   getImage (String imageName) {
    	
    	BufferedImage bufferedImage = null;
    	
    	  try {
  			bufferedImage = ImageIO.read(UserMain.class.getResourceAsStream(imageName));
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    	  
		return bufferedImage;
	
}
    
    
    ArrayList<String> loadimagedata (String scenarioFileName){
	
	
	ArrayList<String> imagedata = new ArrayList<String>();
	
	String imagepath="";
	
	String backbottomcolor="";
	String backtopcolor="";
	
	try {

		//JarPath.getClassPath().replace('\', '\\');
				
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(scenarioFileName);
		document.getDocumentElement().normalize();
		
		NodeList nList = document.getElementsByTagName("mapimage");

		for (int i = 0; i < nList.getLength(); i++) {

			
			Node nNode = nList.item(i);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
					
			imagepath = eElement.getAttribute("src");
			backbottomcolor = eElement.getAttribute("bottombackgroundcolor");
			backtopcolor=eElement.getAttribute("topbackgroundcolor");
			//System.out.println(imagepath);
			
			imagedata.add(imagepath);
			imagedata.add(backbottomcolor);
			imagedata.add(backtopcolor);
			//System.out.println("data in get(0) of image data"+imagedata.get(0));

    	 
	    	}
		} // finish looping on node list
		
		
	} catch (Exception pce) {
		pce.printStackTrace();
	}
	return imagedata; 
	}
    
  

    @Override
    protected void paintComponent(Graphics g) {
    	 String scenarioPath = JarPath.getClassPath() +"scenarios//";
         //	        ArrayList<String> briefing= loadBriefing(scenarioPath+Sea.scenarioName);

         ArrayList<String> imagedata= loadimagedata(scenarioPath+Sea.scenarioName) ;
         path = imagedata.get(0);
     //    System.out.println("here"+ imagedata.get(0));
         try {
        	    Field field = Class.forName("java.awt.Color").getField(imagedata.get(1));
        	    BACKGROUND = (Color)field.get(null);
        	} catch (Exception e) {
        		BACKGROUND = null; // Not defined
        	}
        
         try {
     	    Field field = Class.forName("java.awt.Color").getField(imagedata.get(2));
     	    BACKGROUND_2 = (Color)field.get(null);
     	} catch (Exception e) {
     		BACKGROUND_2 = null; // Not defined
     	}
        
   /*
         Dimension abc ;
        abc = this.getSize();
        System.out.println("the diemensions are" +abc.toString());
         int h = this.getHeight();
         int w = this.getWidth();
         System.out.println("height is : "+h +"width is : "+w);
         */
         
         
        Graphics2D graphics = (Graphics2D) g.create();        
        int midY = 100;
        Paint topPaint = new GradientPaint(0, 0, BACKGROUND,0, midY, BACKGROUND_2);
        graphics.setPaint(topPaint);
        graphics.fillRect(0, 0, getWidth(), midY);        
        Paint bottomPaint = new GradientPaint(0, midY + 1, BACKGROUND_2,0, getHeight(), BACKGROUND);
        graphics.setPaint(bottomPaint);
        graphics.fillRect(0, midY, getWidth(), getHeight());
        //Image img = new ImageIcon(getClass().getResource(path)).getImage();
        Image img = null;
        if(path != null){
        	
        	try{
         img = new ImageIcon(getClass().getResource(path)).getImage();
         int imgX = this.getWidth();
         int imgY = this.getHeight();
         graphics.drawImage(img, 0, 0, imgX, imgY, null);
        	}catch(NullPointerException e){
        		
        	}
       
        }
      //  graphics.dispose();
  
    }
}

    

