package strategy;

import geometrie.Vecteur;
import tools.TerrainTools;
import Circuit.Circuit;
import Circuit.Terrain;
import Voiture.Commande;
import Voiture.Voiture;

public class StrategyArrivee implements Strategy {
	
	private double[] thetas = {0,-Math.PI/8,Math.PI/8};
	private Circuit c;
	private Voiture v;
	private int index;
	
	public StrategyArrivee(Circuit c, Voiture v){
		this.c = c;
		this.v = v;
	}
	
	
	private void scores(){
		Vecteur dir;
		Vecteur pos;
		for(int i=0 ; i < thetas.length ; i++){
			pos = v.getPosition();
			dir= v.getDirection();
			
			dir.rotation(thetas[i]);
			while(TerrainTools.isRunnable(c.getTerrain(pos)) && c.getTerrain(pos) != Terrain.EndLine){
				pos.additionVoid(dir.multiplicationReturn(0.1));
			}
			if(c.getTerrain(pos) == Terrain.EndLine){
				index = i;
				break;
			}
			else
				index = 0;
		}
	}
	public Commande getCommande() {
		scores();
		double an;
		if(thetas[index] == 0)
			an =0;
		else
			an = Math.signum(thetas[index])*v.getMaxTurn();
		return new Commande(1,an);
	}

}
