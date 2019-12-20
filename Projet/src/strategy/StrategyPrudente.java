package strategy;

import Voiture.Commande;

public class StrategyPrudente implements Strategy{

	private Strategy s;
	
	public StrategyPrudente(Strategy s){
		this.s = s;
	}
	@Override
	public Commande getCommande() {
		return new Commande(-1,s.getCommande().getTurn());
	}

}
