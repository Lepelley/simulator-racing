package tools;

import geometrie.Vecteur;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Circuit.Circuit;
import Circuit.Terrain;

public class DessinTools {

	public static BufferedImage imageFromCircuit(Circuit c){
		
		BufferedImage img = new BufferedImage(c.getHeight(), c.getWidth(), BufferedImage.TYPE_INT_RGB);
		for(int i=0 ; i < c.getHeight() ; i++){
			   for(int j=0; j < c.getWidth() ; j++){
				   img.setRGB(i, j, TerrainTools.terrainToRGB(c.getTerrain(i,j)).getRGB());
			   }
		   }
	return img;
	}
	
	
	public static void dessinerTrajet(String nom , Circuit c, ArrayList<Vecteur> tabP, Color color){
		BufferedImage img = imageFromCircuit(c);
		File monImageTest = new File("Images/"+nom+"-Trajet.png");
		for(int i = 0 ; i < tabP.size() ; i++) {
			img.setRGB((int)tabP.get(i).getX(),(int)tabP.get(i).getY(),color.getRGB());
		}
		try {
			ImageIO.write(img, "PNG", monImageTest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fichier image \""+nom+"-Trajet.png\" créé avec succès.");
		
	}
	
	public static void dessinerDijkstra(String nom, Circuit c, int dMax, Color color) throws IOException{
		File monImage = new File("Images/"+nom+"-Dijkstra.png");
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		
		
		
		BufferedImage img = new BufferedImage(c.getHeight(), c.getWidth(), BufferedImage.TYPE_INT_RGB);
		for(int i=0 ; i < c.getHeight() ; i++){
			   for(int j=0; j < c.getWidth() ; j++){
				   if(!TerrainTools.isRunnable(c.getTerrain(i, j))){
					   img.setRGB(i, j, TerrainTools.terrainToRGB(c.getTerrain(i,j)).getRGB());
				   }
				   else{				   
					   if(c.getDist(i,j) == Double.POSITIVE_INFINITY){
						   img.setRGB(i, j, TerrainTools.terrainToRGB(Terrain.Route).getRGB());
					   }
					   else if(c.getTerrain(i,j) == Terrain.EndLine){
						   img.setRGB(i,j,Color.red.getRGB());
					   }
					   else if(c.getTerrain(i,j) == Terrain.StartPoint){
						   img.setRGB(i,j,Color.orange.getRGB());
					   }
					   else{
						   img.setRGB(i,j,new Color((int) c.getDist(i,j)*r/dMax, (int) c.getDist(i,j)*g/dMax , (int) c.getDist(i,j)*b/dMax).getRGB());		
//						   img.setRGB(i, j, new Color(0,0,(int)(c.getDist(i,j)*2)%255).getRGB());
					   }				   
				   }
				   
			   }
		   }
		ImageIO.write(img, "PNG", monImage);
		System.out.println("Fichier \""+nom+"-Dijkstra.png\" cr�� avec succ�s.");
		
	}
}
