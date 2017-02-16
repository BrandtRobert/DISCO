import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Load extends Sea {
	
	public static ArrayList<Target> targetList;
	public static ArrayList<Unit> unitList = new ArrayList<Unit>();
	public static ArrayList<Unit> inActiveUnits = new ArrayList<Unit>();
	public int timerCounter = 0;
	public static double performance = 1.0;
	static UncertinityDetection prop;
	final JPopupMenu menu;
	public static Graphics LoadGraphics= null;
	public static boolean displayOverlay=false;
	public static boolean isInActiveListLoaded = false;
	
	public static ActivityFeed activityFeed = new ActivityFeed();
	
	public static int overlaycounter=0;
		
	
	String scenarioFileName;
	String path;
	public User user;
	public DataCollection data;
	
	public static RandomMove randomMove;
	public RandomSeeking randomSeeking;
	public ReLocation reLocateBlue, reLocateRed;
	public MoveUnit moveUnit;
	public UnitsDistance keep = new UnitsDistance();
	
	public static VerticalMove verticalMove;
	public static HorizontalMove horizontalMove;
	
	public MessageFactory mFactory = new MessageFactory(this);
	public Scaling scaling = new Scaling();
	
	public static int radius = 0;
	public static Point offset = new Point(0, 0);
	public Point previousOffset = new Point(0, 0);
	private String unitsToMove = "";
	public boolean mousePressed = false;
	
	private static BufferedImage img = null;
	
	public static String totalAvailableCreditLimit="";
	

		
	// constructor
	Load(String scenarioFileName, String participant, String path){
			
		
		this.scenarioFileName = scenarioFileName;
		this.path = path;
		loadConfigFile(scenarioFileName);
		loadUserControls(scenarioFileName);
    	// load target Objects in sea panel
		
		
		
		// unit random seek for targets
		randomSeeking = new RandomSeeking(215463879,this);
		reLocateBlue = new ReLocation(this);
		reLocateRed = new ReLocation(this);
		moveUnit = new MoveUnit(this);
		
    	
		// Uncertinity Class
		prop = new UncertinityDetection();
		
		
    	loadTargets(scenarioFileName);
    	
    	loadActivityFeed(scenarioFileName);
    	// load units in sea panel
    	loadUnits(scenarioFileName);
    	
    	
    	    	
    	menu = new JPopupMenu("Popup");
    	
    	
    	
    	MouseAdapter ma = new MouseAdapter() {
    		
        
    		
    		// current centered point
    	private Point startPoint;
    	
    	    @Override
            public void mousePressed(MouseEvent e) {
            	
            	
            	
            	mousePressed = true;
            	
            	if(e.getButton() == MouseEvent.BUTTON3)
        	    {
            		//popUpMenueUpdate();
            		return;
        	    }
            	
            	           	
            	if (! (redUnits.isTracking || blueUnits.isTracking) ) {
            		
            	
            	startPoint = e.getPoint();
                               
                offset.x = startPoint.x;
                offset.y = startPoint.y;
                
                try {
                	//if (stop) { // check if the game in playing mode.
                	if (unitsToMove.compareTo("Blue")==0) {
                		
                		radius = (int) ((blueUnits.searchRadius * Constants.SEARCH_RADIUS) +
         					   Constants.SEARCH_RADIUS);
                		
                	    img = ImageIO.read(UserMain.class.getResourceAsStream("/Blue_Plus.png"));
                	    
                	    groupCohComboBox.setSelectedIndex(1);
                	    
                	    if (stop) { // check if the game in playing mode.
                	    	
                	       // the are performance or whether condition
                	       performance = prop.areaPerformance();
                	       
                	       if (!blueUnits.isActive)
                 		      blueUnits.groupButton_clicked();
                	    
                	    
                	    	// stop seeking to reposition units
                	    
                	    	if (blueUnits.isActive && blueUnits.isSeeking) 
                	    		 blueUnits.seekButton_clicked();
                	    }// end of stop
                	    
                	} else if (unitsToMove.compareTo("Red")==0) {
                		
                		radius = (int) ((redUnits.searchRadius * Constants.SEARCH_RADIUS) +
         					             Constants.SEARCH_RADIUS);
                		
                		img = ImageIO.read(UserMain.class.getResourceAsStream("/Red_Plus.png"));
                		
                		groupCohComboBox.setSelectedIndex(2);
                		
                		if (stop) { // check if the game in playing mode.
                		    
                			// the are performance or whether condition
                			performance = prop.areaPerformance();
                			
                			if (!redUnits.isActive)
                			  redUnits.groupButton_clicked();
                		
                		
                			// stop seeking to reposition units
                		    if (redUnits.isActive && redUnits.isSeeking)
                	    	redUnits.seekButton_clicked();
                		    
                		}// End of Stop
                		
                	} else {
                		img = null;
                	}
                		
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                           
                
                render();
                
            	}
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            	mousePressed = false;
            	            	
            	if (! (redUnits.isTracking || blueUnits.isTracking) ) {
           		
            		if (e.isPopupTrigger()) {
            	          menu.show(e.getComponent(), e.getX(), e.getY());
            	        }
            		
            	
                img = null;
                int currentGroup = 0;
                            	
                ArrayList<Unit> list = new ArrayList<Unit>(); 
                
                if (unitsToMove.compareTo("Blue")==0 && !blueUnits.list.isEmpty()){
                	list = blueUnits.list;
                	currentGroup = 1 ;
                	
                } else if (unitsToMove.compareTo("Red")==0 && !redUnits.list.isEmpty()){
                	list = redUnits.list;
                	currentGroup = 2 ;
                } 
            	
                
                // the code to move units to the new centered group is here
                // I should replace this code with another class
                
                
                
                if (!list.isEmpty()) {
                    
                	relocateUnit(currentGroup, offset);
                	
            	}
            	
             render();
            	
            	}
            	
            	previousOffset = e.getPoint();
            }

           
        }; // end of mouse adapter

        addMouseListener(ma);
        addMouseMotionListener(ma);
    	
        
        popUpMenueUpdate();
        
      	render();
    	
    	
    	try {
            Thread.sleep (500);
        }
        catch (InterruptedException e) {
        }
    	
     	
    	if (participant.compareTo("") != 0) {		
    	        user = new User(participant, path);
    			data = new DataCollection(this,user);
    	}
    			
    	
    	// start targets object movements
    	targetsMovements();
    	
    	
    	
    	
    }
    
	public static void loadActivityFeed(String scenarioFileName) {

    	try {

					
    		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(scenarioFileName);
			document.getDocumentElement().normalize();
			NodeList nList = document.getElementsByTagName("updates");

			for (int i = 0; i < nList.getLength(); i++) {

				
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
						
				if(eElement.getAttribute("enableAllControls").equals("Y")){
				activityFeed.setNewTargetSpotted(eElement.getAttribute("newTargetSpotted"));
				activityFeed.setOldTargetSpotted(eElement.getAttribute("oldTargetSpotted"));
			    activityFeed.setTargetOutOfRange(eElement.getAttribute("targetOutOfRange"));
		    	activityFeed.setUnitLaunchStart(eElement.getAttribute("unitLaunchStart"));
		    	activityFeed.setUnitLaunchComplete(eElement.getAttribute("unitLaunchComplete"));
		    	activityFeed.setUnitRelocateStart(eElement.getAttribute("unitRelocateStart"));
		    	activityFeed.setUnitRelocateComplete(eElement.getAttribute("unitRelocateComplete"));
		    	activityFeed.setNewTargetView(eElement.getAttribute("newTargetView"));
		    	activityFeed.setOldTargetView(eElement.getAttribute("oldTargetView"));
		    	activityFeed.setTargetDetectionSuccess(eElement.getAttribute("targetDetectionSuccess"));
		    	activityFeed.setTargetDetectionFailure(eElement.getAttribute("targetDetectionFailure"));
		    	activityFeed.setUnitSwitchStart(eElement.getAttribute("unitSwitchStart"));
		    	activityFeed.setUnitSwitchComplete(eElement.getAttribute("unitSwitchComplete"));
		    	activityFeed.setNewTargetInspect(eElement.getAttribute("newTargetInspect"));
		    	activityFeed.setOldTargetInspect(eElement.getAttribute("oldTargetInspect"));
				}
		    	
			} // finish looping on node list
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 


    	
    
    	
		
	}
	
	
	public static void loadConfigFile(String scenarioFileName) {

    	try {

					
    		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(scenarioFileName);
			document.getDocumentElement().normalize();
			NodeList nList = document.getElementsByTagName("properties");

			for (int i = 0; i < nList.getLength(); i++) {

				
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
				ConfigProps.DISCO_TIMER=eElement.getAttribute("DISCO_TIMER");	
				ConfigProps.DISCO_TIMER_TYPE=eElement.getAttribute("DISCO_TIMER_TYPE");
				ConfigProps.DISCO_TIMER_DISPLAY=eElement.getAttribute("DISCO_TIMER_DISPLAY");
				ConfigProps.FC_POINTS=eElement.getAttribute("FC_POINTS");
				ConfigProps.MB_POINTS_HIGH=eElement.getAttribute("MB_POINTS_HIGH");
				ConfigProps.MB_POINTS_LOW=eElement.getAttribute("MB_POINTS_LOW");
				ConfigProps.TB_POINTS_HIGH=eElement.getAttribute("TB_POINTS_HIGH");
				ConfigProps.TB_POINTS_LOW=eElement.getAttribute("TB_POINTS_LOW");
				ConfigProps.TARGET_SCREEN_RES_WIDTH=eElement.getAttribute("TARGET_SCREEN_RES_WIDTH");
				ConfigProps.TARGET_SCREEN_RES_HEIGHT=eElement.getAttribute("TARGET_SCREEN_RES_HEIGHT");
				ConfigProps.BRIEFING_WINDOW_SIZEX=eElement.getAttribute("BRIEFING_WINDOW_SIZEX");
				ConfigProps.BRIEFING_WINDOW_SIZEY=eElement.getAttribute("BRIEFING_WINDOW_SIZEY");
				ConfigProps.TARGET_TIMER_COUNTER=eElement.getAttribute("TARGET_TIMER_COUNTER");
				ConfigProps.TOTAL_CREDIT_LIMIT=eElement.getAttribute("TOTAL_CREDIT_LIMIT");
				ConfigProps.LAUNCH_UNIT=eElement.getAttribute("LAUNCH_UNIT");
				
				Sea.resourcePoolAvailableLimit.setText("Credit Limit : $" +ConfigProps.TOTAL_CREDIT_LIMIT);
				Color myColor = Color.decode("#006400");

				if(Double.parseDouble(ConfigProps.TOTAL_CREDIT_LIMIT)>0){
					Sea.resourcePoolAvailableLimit.setForeground(myColor);
				}else{
					Sea.resourcePoolAvailableLimit.setForeground(Color.RED);
				}
				totalAvailableCreditLimit=ConfigProps.TOTAL_CREDIT_LIMIT;
				
		    	
			} // finish looping on node list
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 


    	
    
    	
		
	}

	
	public static void loadUserControls(String scenarioFileName) {

    	try {

					
    		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(scenarioFileName);
			document.getDocumentElement().normalize();
			NodeList nList = document.getElementsByTagName("usercontols");

			for (int i = 0; i < nList.getLength(); i++) {

				
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
				ConfigProps.LAUNCH_UNIT=eElement.getAttribute("LAUNCH_UNIT");
				ConfigProps.BRIEFING=eElement.getAttribute("BRIEFING");
				ConfigProps.STATUS=eElement.getAttribute("STATUS");
				ConfigProps.OVERLAY=eElement.getAttribute("OVERLAY");
				ConfigProps.RED_TO_BLUE_SWITCH=eElement.getAttribute("RED_TO_BLUE_SWITCH");
				ConfigProps.BLUE_TO_RED_SWITCH=eElement.getAttribute("BLUE_TO_RED_SWITCH");
				ConfigProps.COHESION_SLIDER=eElement.getAttribute("COHESION_SLIDER");
				ConfigProps.PROXIMITY_SLIDER=eElement.getAttribute("PROXIMITY_SLIDER");
				ConfigProps.VIEW_TARGET=eElement.getAttribute("VIEW_TARGET");
				ConfigProps.RED_GROUP=eElement.getAttribute("RED_GROUP");
				ConfigProps.BLUE_GROUP=eElement.getAttribute("BLUE_GROUP");
				ConfigProps.CREDITLIMIT=eElement.getAttribute("CREDITLIMIT");
				
				
				
		    	
			} // finish looping on node list
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 


    	
    
    	
		
	}
	void relocateUnit(int group, Point center){
    	
	   
    	boolean isRelocationExists = false;
    	Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
    	String relocationTimer="";
    	
    	if(group==1){
    		relocationTimer="BlueUnit";
    	}else{
    		relocationTimer="RedUnit";
    	}
    	
    	Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
    	
    	//Loop to stop all the other threads while the unit is relocating
    	
    	for (int i=0;i<threadArray.length;i++){
    		
    		   			
    			if(threadArray[i].toString().contains(relocationTimer) && threadArray[i].toString().contains("RelocationTimer")  ){
    			try{
    			threadArray[i].stop();
    			isRelocationExists=true;
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		
    		}
    	}
    	
    	
    	String launchTimer ="LaunchTimer";
    	
    	
    	if(group == 1){


    		/*for (int i=0;i<threadArray.length;i++){
        		
	   			
    			if(threadArray[i].toString().contains("Blue") && threadArray[i].toString().contains("LaunchTimer")){
    			try{
    			threadArray[i].stop();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		
    		}
    	}*/
    		
    		
for (int i=0;i<threadArray.length;i++){
        		
	   			
    			if(threadArray[i].toString().contains("Blue") && threadArray[i].toString().contains("SeekTimer")){
    			try{
    			threadArray[i].stop();
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		
    		}
    	}
    		
    		
    		
    	}

    	
	   
	   if (group == 1) {
	   
		   if (!blueUnits.inTransitList.isEmpty()) {
			   
		    //   blueUnits.seekButton_clicked();	  
		       
		       //Commented by Praveen
		       /*for(int i=0;i<blueUnits.inTransitList.size();i++){
		    	   
		    	   blueUnits.list.add(blueUnits.inTransitList.get(i));
		    	  blueUnits.inTransitList.remove(i);
		    	   
		    	   
		       }*/
		       
		       
			 // return;
 	  
		   }
		   
		   blueUnits.currentCenter = new Point (center.x , center.y);
		   //Commented for testing purpose by Praveen
		   
		  if(isRelocationExists==false)
			  if(Load.activityFeed.getUnitRelocateStart().equals("Y"))
				  
				  
		   Sea.updatesTextArea.append("Unit Relocation - Blue units are currently relocating" + "\n\n");
		   
		   for (Unit unit: blueUnits.list){
					   unit.startReLocation(this, blueUnits,"BlueUnit");
					   /*try {
						Thread.sleep ((long) 50 );
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		   }
	   
	   } else {
		   if(isRelocationExists==false)
			   if(Load.activityFeed.getUnitRelocateStart().equals("Y"))
		   Sea.updatesTextArea.append("Unit Relocation - Red units are currently relocating " + "\n\n");
		  
		   if (!redUnits.inTransitList.isEmpty())  {/*
			   
		       redUnits.seekButton_clicked();	  
			   return;
 	  
		   */}
		   
		   redUnits.currentCenter = new Point (center.x , center.y);
		   for (Unit unit: redUnits.list) {
			   
				unit.startReLocation(this, redUnits,"RedUnit");
				/*try {
					Thread.sleep ((long) 50 );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/

		   }
      
		   //redUnits.setReLocating(true);
      
   }

   }
   
   void popUpMenueUpdate(){
	   
	   // mouse click.
	   menu.removeAll();
       if (blueUnits.list.size()!=0) {
       JMenuItem item1 = new JMenuItem("Blue Units");
	    item1.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        //System.out.println("Menu item Test1");
	        unitsToMove = "Blue";	        
	      }
	    });
	    	    
	    menu.add(item1);
       }

       if (redUnits.list.size()!=0) {
       JMenuItem item2 = new JMenuItem("Red Units");
	    item2.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        //System.out.println("Menu item Test2");
	        unitsToMove = "Red";
	      }
	    });
	    
	    menu.add(item2);
	    
       }
   }

	void targetsMovements(){
    	
    	for(Target target: targetList)  
        	
    		target.startMoving();
    	    
    	    try {
    	    	Thread.sleep ((long) 50 );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     
	}
    
    
	void loadTargets (String scenarioFileName){
    	
    	String id;
    	int positionX ;
    	int positionY ;
    	int speed ;
    	String imageType = "";
    	String movement = "";
    	String imageLocation ="";
    	String trueIdentity ="";
    	String status="";
    	String identityLevels="";
    	String[] arrpriorityLevels=null;
    	String inspectionImage="";
    	String description="";
    	String priority="";
    	
    	int fulePoints;
    	Target target;
    	
    	targetList= new ArrayList<Target>();
    	
    	try {

			//JarPath.getClassPath().replace('\', '\\');
					
    		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(scenarioFileName);
			document.getDocumentElement().normalize();
			// Get employee by tag name
			//use item(0) to get the first node with tag name "employee"
			Node scenario = document.getElementsByTagName("scenario").item(0);
			Node targets = document.getElementsByTagName("targets").item(0);

						
			// read root scenario attributes
			NamedNodeMap attribute = scenario.getAttributes();
			Node scenarioMovement = attribute.getNamedItem("movement");
			//Node scenarioName = attribute.getNamedItem("name");
			movement = scenarioMovement.getTextContent();
			
			if (movement.compareTo("Random") == 0) {
				Node scenarioSeed = attribute.getNamedItem("seed");
     			randomMove = new RandomMove(Long.parseLong(scenarioSeed.getTextContent()), this);
			}	else if (movement.compareToIgnoreCase("Vertical") == 0) {
				verticalMove = new VerticalMove(this);
			}   else if (movement.compareToIgnoreCase("Horizontal") == 0) {
				horizontalMove = new HorizontalMove(this);
			}
			
			
			// loop the employee node and update salary value, and delete a node
			NodeList nodes = targets.getChildNodes();
			NodeList nList = document.getElementsByTagName("target");

			for (int i = 0; i < nList.getLength(); i++) {

				
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
						
				id = eElement.getAttribute("id");
			    positionX = Integer.parseInt(eElement.getAttribute("positionX"));
		    	positionY = Integer.parseInt(eElement.getAttribute("positionY"));
		    	speed = Integer.parseInt(eElement.getAttribute("speed"));
		    	imageType = "SMALL";
		    	imageLocation = eElement.getAttribute("imagePath");
		    	trueIdentity = eElement.getAttribute("trueIdentity");
		    	status = eElement.getAttribute("status");
		    	identityLevels=eElement.getAttribute("identityLevels");
		    	priority = eElement.getAttribute("priority");
		    	inspectionImage = eElement.getAttribute("inspectionImage");
		    	description = eElement.getAttribute("description");
		    	
		    	StringTokenizer stToken = new StringTokenizer(identityLevels,",");
		    	arrpriorityLevels = new String[stToken.countTokens()];
		    	
		    	int counter=0;
		    	
		    	while(counter<arrpriorityLevels.length){
		    		arrpriorityLevels[counter] = stToken.nextToken();
		    		counter=counter+1;
		    	}
		    	
		    	if(status.equalsIgnoreCase("ACTIVE")){
		    	
		    	// Targets' Random Movements
		    	if (movement.compareTo("Random") == 0) {
		    	
		    	fulePoints = 0;	
		    	target = new Target(id, positionX, positionY, speed, imageType, movement, fulePoints, randomMove,imageLocation,trueIdentity,arrpriorityLevels,priority,description,inspectionImage);
		    	
		    	} //  Targets' Vertical Movements
		    	else if (movement.compareToIgnoreCase("Vertical") == 0) {
		    		Node targetFulePoints = attribute.getNamedItem("fuelPoints");
		    		//this.fulePoints = (Movable.yBORDER / (fulePoints + 1));
		    		fulePoints = Constants.yBORDER / (Integer.parseInt(targetFulePoints.getTextContent()) + 1 );
		    		target = new Target(id, positionX, positionY, speed, imageType, movement, fulePoints, verticalMove,imageLocation,trueIdentity,arrpriorityLevels,priority,description,inspectionImage);
		    		
		    	} // Targets' Horizontal Movements  
		    	else {
		    		Node targetFulePoints = attribute.getNamedItem("fuelPoints");
		    		fulePoints = Constants.xBORDER / (Integer.parseInt(targetFulePoints.getTextContent()) + 1 );
		    		target = new Target(id, positionX, positionY, speed, imageType, movement, fulePoints, horizontalMove,imageLocation,trueIdentity,arrpriorityLevels,priority,description,inspectionImage);
					
				}
		    	 
		    	targetList.add(target);
		    	mFactory.createMessage(target,0);
		    	//Commented By Praveen
		    	//Sea.updatesTextArea.setCaretPosition(0);
		    	Sea.updatesTextArea.setLineWrap(true);
		    	}
			} // finish looping on node list
			}
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}


    	
    }
    
 void loadUnits (String scenarioFileName){
	 
	String id;
 	int positionX ;
 	int positionY ;
 	int speed ;
 	int fulepoints;
 	int colorID;
 	Unit unit;
 	double detectRadius;
 	int countBlue = 0, countRed = 0;
 	String blueID = "" , redID = "";
 	String color;
 	String status="";
 	String price="";
 	double relocationDetectRadius=0;
 	double relocationSpeed=0;
 	
 	
 		
 	
 	try {

		  DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		  Document document = documentBuilder.parse(scenarioFileName);
		  document.getDocumentElement().normalize();

		  // Get employee by tag name
		  //use item(0) to get the first node with tag name "employee"
		  Node scenario = document.getElementsByTagName("scenario").item(0);
		  Node units = document.getElementsByTagName("units").item(0);
		  
		  
		  // read root performance Level attributes
		  NamedNodeMap rootAttribute = scenario.getAttributes();
		  Node performanceLevel = rootAttribute.getNamedItem("performanceLevel");
		  performance = Double.parseDouble(performanceLevel.getTextContent()) / 100;
		  
		  	
			// loop the employee node and update salary value, and delete a node
			NodeList nodes = units.getChildNodes();
			NodeList nList = document.getElementsByTagName("unit");

			for (int i = 0; i < nList.getLength(); i++) {
				
				Node nNode = nList.item(i);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
				
				id = (eElement.getAttribute("id"));
			    positionX = Integer.parseInt((eElement.getAttribute("positionX")));
		    	positionY = Integer.parseInt((eElement.getAttribute("positionY")));
		    	speed = Integer.parseInt((eElement.getAttribute("speed")));
		    	fulepoints = Integer.parseInt((eElement.getAttribute("fuelpoints")));
		    	colorID = Integer.parseInt((eElement.getAttribute("colorID")));
		    	detectRadius = Double.parseDouble((eElement.getAttribute("detectRadius")));
		    	status = (eElement.getAttribute("status"));
		    	price = (eElement.getAttribute("price"));
		    	relocationDetectRadius = Double.parseDouble((eElement.getAttribute("relocationDetectRadius")));
		    	relocationSpeed = Double.parseDouble((eElement.getAttribute("relocationSpeed")));
		    		
		    	unit = new Unit(id, positionX, positionY, speed, fulepoints, colorID, 
		    			                    detectRadius,status,price,relocationDetectRadius,relocationSpeed);
		    	
		    	if(status.equalsIgnoreCase("ACTIVE")){
		    	if (colorID == 1) {
		    		
		    		countBlue++;
		    		blueID+= id + ", ";
		    		blueUnits.list.add(unit);
		    		color = "Blue";
		    			    	
		    	} else {
		    		countRed++;
		    		redID+= id + ", ";
		    		redUnits.list.add(unit);
		    		color = "Red";
		    	  
		    	}
		    	
		    	
		    		unitList.add(unit);
		    	}else{
		    		inActiveUnits.add(unit);
		    		//unitList.add(unit);
		    	}
		    	
		    	
		    	
			
			} 
			}// finish looping on node list

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}

 	       blueUnitsTextField.setText("[" + countBlue + "]" + " Blue Units: " + blueID);
 	       redUnitsTextField.setText("[" + countRed + "]" + " Red Units: " + redID);
 	       
 	      
 	      if (blueUnits.list.size() > 1)  {
 	      
 	    	  for (Unit u:blueUnits.list) {
 	    	  u.flyTowardsCenterOfMass(blueUnits.list);
 	          keep.groupDistance(blueUnits);
 	         
 	      }
 	      }
 	      
 	     mFactory.createMessage(blueUnits,0);
 	      
 	     if (redUnits.list.size() > 1) {
 	      for (Unit u:redUnits.list) {
	    	 // u.flyTowardsCenterOfMass(redUnits.list);
 	          keep.groupDistance(redUnits);
 	          
 	      }
 	          
 	     }
 	     
 	    mFactory.createMessage(redUnits,0);
 	      /*keepUnitDistance(blueUnitList);
 		  keepUnitDistance(redUnitList);*/
 	     	
    }
 
    
   public void render (){
		
		repaint();
	}
    
	
   public void paintComponent(Graphics g) {
	   
	  
	   
	    
	   String[] arrInActiveUnits;
	 
		super.paintComponent(g);
		LoadGraphics = (Graphics)g;
		
		
		 
		for(Target target:targetList) {
			
			boolean blFlag = target.view(this);
			
			
			
			if (blFlag || target.timerCounter<180) {
				
				
				g.drawImage(target.image, target.positionX,target.positionY, this);
				g.setColor (Color.black);
				Font f = new Font ("Serif", Font.BOLD, 11);
				g.setFont (f);
				g.drawString (""+target.id, target.positionX-1, target.positionY-1);
  
				
			}
		}
	
		//for (Unit unit: blueUnitList)
		   keep.groupDistance(blueUnits);
		  
		  
		  //for (Unit unit: redUnitList)1
		  keep.groupDistance(redUnits);
		  
		  
		//for (Unit unit: redUnitList)
		  keep.allUnitsDistance(unitList);
		  
		 
		  // drawing the current units in the list 
		  for(Unit unit:unitList)  {
			  
		
			 //unit.flyTowardsCenterOfMass(unitList);
		 g.drawImage(unit.image, unit.positionX,unit.positionY, this);
		 
		 g.setColor (Color.black);
			Font f = new Font ("Serif", Font.BOLD, 11);
			g.setFont (f);
			g.drawString (""+unit.id, unit.positionX-1, unit.positionY-1);
		
		/* if (unit.colorID == 1 ){
			  Color myColor = new Color(0, 102, 204);
		      g.setColor (myColor);
		 } else {
			 g.setColor (Color.RED);
		 }
		    Font f = new Font ("Serif", Font.BOLD, 12);
		    g.setFont (f);
		    g.drawString (""+unit.id, unit.positionX+12, unit.positionY+20);*/
			 }
			 
			
		 
		  arrInActiveUnits = new String[inActiveUnits.size() +1];
		  arrInActiveUnits[0] ="Select Unit";
		  
		  for(int i=0;i<inActiveUnits.size();i++){
			  
			  
			  if(inActiveUnits.get(i).colorID==1){
				  arrInActiveUnits[i+1] = "Blue " + inActiveUnits.get(i).id;
			  }else{
				  arrInActiveUnits[i+1] = "Red " + inActiveUnits.get(i).id;
			  }
			  
		  }
		  
		  if(!isInActiveListLoaded){
		DefaultComboBoxModel model = new DefaultComboBoxModel(arrInActiveUnits);
		Sea.inActiveUnitsComboBox.setModel(model);
		isInActiveListLoaded = true;
		  }
		  
		if (img != null) {
			
			try{
			if(displayOverlay==true){
				
				if((overlaycounter % 2) ==0){
					
						drawCircle(g, redUnits.currentCenter.x, redUnits.currentCenter.y, 0,"Red"); // center (30,30) r=20
						g.drawImage(null, redUnits.currentCenter.x-12, redUnits.currentCenter.y-12, this);
						
						drawCircle(g, blueUnits.currentCenter.x, blueUnits.currentCenter.y, 0,"Blue"); // center (30,30) r=20
						g.drawImage(null, blueUnits.currentCenter.x-12, blueUnits.currentCenter.y-12, this);
						
				}else{
				int blueradius = (int) ((blueUnits.searchRadius * Constants.SEARCH_RADIUS) +
  					   Constants.SEARCH_RADIUS);
				int redradius = (int) ((redUnits.searchRadius * Constants.SEARCH_RADIUS) +
	  					   Constants.SEARCH_RADIUS);
				//System.out.println(unitList.get(0).id.toString());
				//System.out.println("red radius" + redradius);
				
			//	System.out.println("blue radius" + blueradius);
				
				if(redUnits.isActive){
					drawCircle(g, redUnits.currentCenter.x, redUnits.currentCenter.y, redradius,"Red"); // center (30,30) r=20
					g.drawImage(null, redUnits.currentCenter.x-12, redUnits.currentCenter.y-12, this);
					}
				
				if(blueUnits.isActive){
				drawCircle(g, blueUnits.currentCenter.x, blueUnits.currentCenter.y, blueradius,"Blue"); // center (30,30) r=20
				g.drawImage(null, blueUnits.currentCenter.x-12, blueUnits.currentCenter.y-12, this);
				}
				
			
				
				}
			}else{
			drawCircle(g, offset.x, offset.y, radius,""); // center (30,30) r=20
			g.drawImage(img, offset.x-12, offset.y-12, this);
			}
			}
			catch(Exception e){
			}
		}
		/*try {
			img = ImageIO.read(UserMain.class.getResourceAsStream("/usa_map.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, 0, 100, this);*/
	   
	
		
   } // method end
	
	// Convenience method to draw from center with radius
	public void drawCircle(Graphics cg, int xCenter, int yCenter, int r,String color) {
	 
		//Color lineColor = new Color(255, 255, 52);
		
		if(color.equals("")){
		
		
		if (unitsToMove.compareTo("Blue")==0) {
		  Color lineColor = new Color(0, 102, 204);
		  cg.setColor(lineColor);
			 
		} else {
				 cg.setColor (Color.RED);
		}
		} else{
			
			if(color.equals("Red")){
				cg.setColor (Color.RED);
			}else if (color.equals("Blue")){
				cg.setColor (Color.BLUE);
			}else{
				Color lineColor = new Color(0, 102, 204);
				  cg.setColor(lineColor);
			}
		}
		
		Graphics2D g2 = (Graphics2D) cg;
	    g2.setStroke(new BasicStroke(2));
		cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
		return;
	}//end drawCircle

	public static void showOverlay() {
		
		overlaycounter = overlaycounter +1;
	
				
				
				
				
				
            if(redUnits.isActive){
            	Point startPoint = redUnits.currentCenter;
				offset.x = startPoint.x;
				offset.y = startPoint.y;
            try {
            	//if (stop) { // check if the game in playing mode.
            		
            		radius = (int) ((redUnits.searchRadius * Constants.SEARCH_RADIUS) +
     					   Constants.SEARCH_RADIUS);
            		
            	    img = ImageIO.read(UserMain.class.getResourceAsStream("/Red_Plus.png"));
            	    displayOverlay = true;
            	    
            	//    System.out.println("in red active area");
            	  
            		
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
           if(blueUnits.isActive){
            	Point blueStartPoint = blueUnits.currentCenter;
            	offset.x = blueStartPoint.x;
				offset.y = blueStartPoint.y;
				  try {
		            	//if (stop) { // check if the game in playing mode.
		            		
		            		radius = (int) ((blueUnits.searchRadius * Constants.SEARCH_RADIUS) +
		     					   Constants.SEARCH_RADIUS);
		            		
		            	    img = ImageIO.read(UserMain.class.getResourceAsStream("/Red_Plus.png"));
		            	    displayOverlay = true;
		            	    
		           // 	    System.out.println("in blue active area");
		            	  
		            		
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
            }
            
            
			
			
            
            
          //  render();
            


	}

	
	
	
	
}
