package strategy;

import dijkstra.Dijkstra;
import optimisation.Genome;
import Radar.Radar;
import Voiture.Commande;
import Voiture.Voiture;

public class StrategyGenome implements Strategy {
	private Voiture v;
	private double[] param;
	private Strategy s;
	private double[][] tab;
	String str;
	
	public StrategyGenome(Voiture v, Radar r, Genome<Double> gen, Dijkstra dij, String str){	
		this.v = v;	
		this.str = str;
		s = new StrategyRadarDijkstra(v, r);
		param = new double[gen.size()];
	
		for(int i = 0 ; i < gen.size(); i++){
			param[i] = gen.get(i);
		}
		tab = dij.getMatrice();
	}
	
	public Commande getCommande() {

		int i = (int)v.getPosition().getX();
		int j = (int)v.getPosition().getY();
		double acc = 1;
		if(v.getVitesse() == 0){
			return new Commande(1,s.getCommande().getTurn());
		}
		
		for(int n = 0; n < param.length; n+=3){
			if(tab[i][j] > param[n] && tab[i][j] < param[n+1]){
				if(v.getVitesse() < param[n+2]){
					acc = 1;
				}
				else
					acc = -1;
				break;
			}
		}

//		return new Commande(acc, s.getCommande().getTurn());
		return finDeCourse(i,j,acc);
	}
	
	
	private Commande finDeCourse(int i, int j, double acc){
		switch(str){
		case "1_safe.trk" :
			if(tab[i][j] < 250 && v.getDirection().getX() < 0){
				return new Commande(1,-v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "1_safe.trk-perso" :
			if(tab[i][j] < 250 && v.getDirection().getX() < 0){
				return new Commande(1,-v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "2_safe.trk" :
			if(tab[i][j] < 200 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "2_safe.trk-perso" :
			if(tab[i][j] < 336 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "3_safe.trk" :
			if(tab[i][j] < 130 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "3_safe.trk-perso" :
			if(tab[i][j] < 130 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "4_safe.trk" :
			if(tab[i][j] < 50 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "4_safe.trk-perso" :
			if(tab[i][j] < 1900 && tab[i][j] >1885)
				   return new Commande(acc,v.getMaxTurn());
				  if(tab[i][j] < 1045 && tab[i][j] >985)
				   return new Commande(acc,-v.getMaxTurn());
			if(tab[i][j] < 50 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "5_safe.trk" :
			if(tab[i][j] < 170 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "5_safe.trk-perso" :
			if(tab[i][j] < 170 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "6_safe.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "6_safe.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
				
		case "7_safe.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "7_safe.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
				
		case "8_safe.trk" :
			if(tab[i][j] < 30 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "8_safe.trk-perso" :
			if(tab[i][j] < 30 && v.getDirection().getX() > 0){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "aufeu.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "aufeu.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
			
		case "bond_safe.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "bond_safe.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
			
		case "Een2.trk" :
			if(tab[i][j] < 65 && v.getDirection().getX() > -0.75){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
		case "Een2.trk-perso" :
			if(tab[i][j] < 65 && v.getDirection().getX() > -0.75){
				return new Commande(1,v.getMaxTurn());
			}
			else
				return new Commande(acc,s.getCommande().getTurn());
			
		case "labymod.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "laybmod.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
			
		case "labyperso.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "labyperso.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
			
		case "perso.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "perso.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
			
		case "t2009.trk" :
				return new Commande(acc,s.getCommande().getTurn());
		case "t2009.trk-perso" :
				return new Commande(acc,s.getCommande().getTurn());
			
		case "t260_safe.trk" :
	        if(tab[i][j] < 20 && (v.getDirection().getX() < 0)){
	        	if(v.getVitesse() > 0.2)
	        		return new Commande(-1,-v.getMaxTurn());
	        	else
	        		return new Commande(1,-v.getMaxTurn());
	        	
	        }
	        else
	        	return new Commande(acc,s.getCommande().getTurn());
		case "t260_safe.trk-perso" :
	        if(tab[i][j] < 20 && (v.getDirection().getX() < 0)){
	        	if(v.getVitesse() > 0.2)
	        		return new Commande(-1,-v.getMaxTurn());
	        	else
	        		return new Commande(1,-v.getMaxTurn());
	        	
	        }
	        else
	        	return new Commande(acc,s.getCommande().getTurn());
	    default :
	    		return new Commande(acc,s.getCommande().getTurn());
		}
		
	}
}