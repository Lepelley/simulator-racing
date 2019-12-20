package strategy;

import Radar.Radar;
import Voiture.Commande;
import Voiture.Voiture;

public class StrategyRadarDijkstra implements Strategy{


	private Voiture v;
	private Radar r;
	
	public StrategyRadarDijkstra(Voiture v, Radar r){
		this.v = v;
		this.r = r;
	}
	
	public Commande getCommande() {
		r.scores();
		double turn = r.thetas()[r.getBestIndex()] / v.getBraquage(); 		
		double angle = turn;
		
		if(turn < -v.getMaxTurn())
			angle = -v.getMaxTurn();
		if(turn > v.getMaxTurn())
			angle = v.getMaxTurn();

		return new Commande(1,angle);

	}
}
