package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import logic.BCM;
import logic.Individual;



public class DrawingPanel extends JPanel {

	private int i;
	private BCM bcm;
	
	public DrawingPanel() {
		setPreferredSize(new Dimension(400, 400));
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		double scale = calculateScale(bcm);
		
		
		if(bcm != null){
            Individual tmp = bcm.getBestIndividualInEachIterationPopulation().getIndividualsPopulation().get(i);
            
            int shopX = 50 + (int) ((int) tmp.getShop().getX() * scale);
            int shopY = 50 + (int) ((int) tmp.getShop().getY() * scale);
            int shopLengthX = (int) (tmp.getShop().getLengthX() * scale);
            int shopLengthY = (int) (tmp.getShop().getLengthY()  * scale);
            //draw shop at coordinates (x,y) with shopLengthX, shopLengthY
            g.setColor(new Color(180, 0, 0));
            g.fillRect(shopX, shopY, shopLengthX, shopLengthY);
            
            for (int j = 0; j < tmp.getSeatsCoordinates().size(); j++) {
            	int x = 50 + (int) ((tmp.getSeatsCoordinates().get(j).getX() + 0.2) * scale);
            	int y = 50 + (int) ((tmp.getSeatsCoordinates().get(j).getY() + 0.2) * scale);
            	int lengthX = (int) (scale * 0.6);
            	int lengthY = (int) (scale * 0.6);
            	g.setColor(new Color(80, 80, 80));
            	g.fillRect(x, y, lengthX, lengthY);
            	g.fillRect(x + 2, y + 2, 10 - 4, 10 - 4);
            }
            
            for (int j = 0; j < tmp.getTablesCoordinates().size(); j++) {
            	int x = 50 + (int) ((int) tmp.getTablesCoordinates().get(j).getX() * scale);
            	int y = 50 + (int) ((int) tmp.getTablesCoordinates().get(j).getY() * scale);
            	int lengthX = (int) (tmp.getTablesCoordinates().get(j).getLengthX() * scale);
            	int lengthY = (int) (tmp.getTablesCoordinates().get(j).getLengthY() * scale);
            	g.setColor(new Color(150, 150, 150));
            	g.fillRect(x, y, lengthX, lengthY);
            }     
            
            for (int j = 0; j < tmp.getLampsCoordinates().size(); j++) {
                int x = 50 + (int) ((int) tmp.getLampsCoordinates().get(j).getX()* scale);
                int y = 50 + (int) ((int) tmp.getLampsCoordinates().get(j).getY()* scale);
                g.setColor(Color.YELLOW);
                g.fillOval(x, 5 + y, (int)(0.3 * scale), (int)(0.3 * scale));
            }
            
            
            g.setColor(Color.BLACK);
            g.drawLine(50,50,50+ (int)(bcm.getB() * scale),50);
            g.drawLine(50+ (int)(bcm.getB() * scale),50,50+ (int)(bcm.getB() * scale),50+ (int)(bcm.getC() * scale));
            g.drawLine(50+ (int)(bcm.getB() * scale),50+ (int)(bcm.getC() * scale),50+ (int)(bcm.getF() * scale),50+ (int)(bcm.getC() * scale));
            g.drawLine(50+ (int)(bcm.getF() * scale),50+ (int)(bcm.getC() * scale),50+ (int)(bcm.getF() * scale),50+ (int)(bcm.getA() * scale));
            g.drawLine(50+ (int)(bcm.getF() * scale),50+ (int)(bcm.getA() * scale),50,50+ (int)(bcm.getA() * scale));
            g.drawLine(50,50+ (int)(bcm.getA() * scale),50,50);
            
            
            
            for (int j = 0; j < tmp.getWindowsCoordinates().size(); j++) {
            	int x = 50 + (int) (tmp.getWindowsCoordinates().get(j).getX() * scale);
            	int y = 50 + (int) (tmp.getWindowsCoordinates().get(j).getY() * scale);
            	int length = (int) (tmp.getWindowsCoordinates().get(j).getLength() * scale);
                int position = tmp.getWindowsCoordinates().get(j).getPosition();
                //draw window at coordinates (x,y) with length and position(pozioma - 0, pionowa - 1)
                if(position == 1){
                	g.setColor(new Color(220, 220, 220));
                	g.drawLine(x, y, x, y + length);
                }else{
                	g.setColor(new Color(220, 220, 220));
                	g.drawLine(x, y, x + length, y);
                }
            } 
                 
            int doorX = 50 + (int) (tmp.getDoor().getX() * scale);
            int doorY = 50 + (int) (tmp.getDoor().getY() * scale);
            int doorLength = (int) (tmp.getDoor().getLength() * scale);
            int position = tmp.getDoor().getPosition();
            g.setColor(Color.RED);
            if(position == 1){
                g.drawLine(doorX, doorY, doorX, (doorY + doorLength));
            }else if(position == 0){
                g.drawLine(doorX, doorY, (doorX + doorLength), doorY );
            }
		}
	}
	
	public DrawingPanel(BCM bcm, int i){
		setPreferredSize(new Dimension(400, 400));
		this.bcm = bcm;
		this.i = i;
	}
	
	public double calculateScale(BCM bcm){
		double scale = 0;
		int tmp = 0;
		if(bcm.getA() >= bcm.getF()){
			tmp = (int) bcm.getA();
			scale = 500 / tmp;
		}
		else{
			tmp = (int) bcm.getF();
			scale =  800 / tmp;
		}
		
		return scale;
	}
}
