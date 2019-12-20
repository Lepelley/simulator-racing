package tools;

import java.awt.Color;

import Circuit.Circuit;
import Circuit.Terrain;
import Circuit.TerrainException;

public class TerrainTools {

	public static Terrain terrainFromChar(char c) throws TerrainException{
		
		switch(c){
		case '.' :
			return Terrain.Route;
		case 'g' :
			return Terrain.Herbe;
		case 'b' :
			return Terrain.Eau;
		case 'o' :
			return Terrain.Obstacle;
		case 'r' :
			return Terrain.BandeRouge;
		case 'w' :
			return Terrain.BandeBlanche;
		case '*' :
			return Terrain.StartPoint;
		case '!' :
			return Terrain.EndLine;
		case 'm' :
			return Terrain.Boue;
		default:
			throw new TerrainException("Terrain inconnu");
		}
	}
		
	public static char charFromTerrain(Terrain c){
		int x = 42;

		switch(c){
		case Route :
			x = 0;
			break;
		case Herbe :
			x = 1;
			break;
		case Eau :
			x = 2;
			break;
		case Obstacle :
			x = 3;
			break;
		case BandeRouge :
			x = 4;
			break;
		case BandeBlanche :
			x = 5;
			break;
		case StartPoint :
			x = 6;
			break;
		case EndLine :
			x = 7;
			break;
		case Boue :
			x = 8;
			break;
		}
		
		return Terrain.conversion[x];
	}
	
	public static Color terrainToRGB (Terrain c) {
		
		int x = 42;
		
		switch(c){
		case Route :
			x = 0;
			break;
		case Herbe :
			x = 1;
			break;
		case Eau :
			x = 2;
			break;
		case Obstacle :
			x = 3;
			break;
		case BandeRouge :
			x = 4;
			break;
		case BandeBlanche :
			x = 5;
			break;
		case StartPoint :
			x = 6;
			break;
		case EndLine :
			x = 7;
			break;
		case Boue :
			x = 8;
			break;
		}
		
		return Terrain.convColor[x];
	}
	
	public static boolean isRunnable(Terrain t){
		Boolean x = true;
		switch(t){
		case Route :
			x = true;
			break;
		case Herbe :
			x = false;
			break;
		case Eau :
			x = false;
			break;
		case Obstacle :
			x = false;
			break;
		case BandeRouge :
			x = true;
			break;
		case BandeBlanche :
			x = true;
			break;
		case StartPoint :
			x = true;
			break;
		case EndLine :
			x = true;
			break;
		case Boue :
			x = true;
			break;
		}
		
		return x;
	}

	public static Terrain[][] ajouterCarreRoute(Circuit c,int i, int j, int k, int l) {
		Terrain[][] tab = new Terrain[c.getHeight()][c.getWidth()];
		for(int x = 0 ; x < c.getHeight() ; x++){
			for(int y=0 ; y < c.getWidth() ; y ++){
				tab[x][y] = c.getTerrain(x, y);
			}
			
		}
		for(int a = i; a <= k ; a++){
			for(int b = j ; b <= l ; b++){
				tab[a][b] = Terrain.Route;
			}
		}
		return tab;
	}
		
}
