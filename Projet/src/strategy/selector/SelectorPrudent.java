package strategy.selector;

import geometrie.Vecteur;
import tools.TerrainTools;
import Circuit.Circuit;
import Voiture.Voiture;

public class SelectorPrudent implements Selector {

	private double dist;
	private Voiture v;
	private Circuit c;
	
	
	public SelectorPrudent(Voiture v,Circuit c){
		this.v = v;
		this.c = c;
	}

	
	public void distance(){
		Vecteur dir = v.getDirection();
		Vecteur pos = v.getPosition();
		
			while(TerrainTools.isRunnable(c.getTerrain(pos))){
				pos.additionVoid(dir.multiplicationReturn(0.1));
			}
			dist = (Math.sqrt( Math.pow( pos.getX() - v.getPosition().getX() , 2) + Math.pow( pos.getY() - v.getPosition().getY() , 2)));
	}
	
	
	public boolean isSelected() {
		distance();
		boolean bool = false;
		if(dist < 150 && v.getVitesse() > 0.3)
			bool = true;
		else
			bool = false;
		if(v.getVitesse() < 0.3)
			bool = false;
		return bool;
	}





//--------------------------------------------------------------RECORDS-------------------------------------------------------

//---------------------------------------------------------------LABYMOD-----------------------------------------------------
//public boolean isSelected() {
//	distance();
//	if(dist < 84.9 && v.getVitesse() > 0.6)
//		return true;
//	else if(dist < 47 && v.getVitesse() > 0.455)
//		return true;
//	else
//		return false;
////
	




}