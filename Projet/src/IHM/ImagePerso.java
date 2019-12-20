package IHM;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import tools.DessinTools;
import tools.ToolsFichiers;
import Circuit.Circuit;
import Circuit.Terrain;

public class ImagePerso implements MouseListener,MouseMotionListener{
	
	private BufferedImage im;
	Circuit c;
	private int width;
	private int height;
	Terrain[][] terrain;
	Terrain[][] terrainTMP;
	private int choix = 0;
	
	public ImagePerso(Circuit c){
		this.c = c;
		width = c.getHeight();
		height = c.getWidth();
		terrain = new Terrain[width][height];
		im = DessinTools.imageFromCircuit(c);
//		this.setPreferredSize(new Dimension(im.getWidth(),im.getHeight()));
		for(int i=0; i< width;i++){
			for(int j=0 ; j < height ; j++){
				terrain[i][j] = c.getTerrain(i, j);
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		int a = 5;
		int b = 10;
		
		switch(choix){
		case 0 :
			a = 5;
			b = 10;
			break;
		case 1 :
			a = 12;
			b = 25;
			break;
		case 2 :
			a = 20;
			b = 40;
			break;
		default :
			a = 5 ;
			b = 10;
		}
		Graphics2D g = (Graphics2D)im.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(arg0.getX()-a, arg0.getY()-a, b,b);
		for(int i = arg0.getX()-a ; i < arg0.getX()+a; i++){
			for(int j = arg0.getY()-a ; j < arg0.getY()+a ; j++){
				terrain[i][j] = Terrain.Herbe;
			}
		}
		arg0.getComponent().repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void save(String file){
		ToolsFichiers.fichierFromTerrain(terrain, file);
	}
	
	public BufferedImage getImage(){
		return im;
	}
	
	public void Reset(){
		im = DessinTools.imageFromCircuit(c);
		for(int i=0; i< width;i++){
			for(int j=0 ; j < height ; j++){
				terrain[i][j] = c.getTerrain(i, j);
			}
		}
		
	}
	public void setImage(Circuit c){
		this.c = c;
		width = c.getHeight();
		height = c.getWidth();
		terrain = new Terrain[width][height];
		Reset();
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		int a = 5;
		int b = 10;
		
		switch(choix){
		case 0 :
			a = 5;
			b = 10;
			break;
		case 1 :
			a = 12;
			b = 25;
			break;
		case 2 :
			a = 20;
			b = 40;
			break;
		default :
			a = 5 ;
			b = 10;
		}
		Graphics2D g = (Graphics2D)im.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(arg0.getX()-a, arg0.getY()-a, b,b);
		for(int i = arg0.getX()-a ; i < arg0.getX()+a; i++){
			for(int j = arg0.getY()-a ; j < arg0.getY()+a ; j++){
				terrain[i][j] = Terrain.Herbe;
			}
		}
		arg0.getComponent().repaint();
		
	}


	public void mouseMoved(MouseEvent arg0) {	
	}
	
	public void setChoix(int i){
		choix = i;
	}
}
