package optimisation;

import java.awt.Color;

import dijkstra.Dijkstra;
import Radar.Radar;
import Radar.RadarDijkstra;
import Voiture.Voiture;
import Voiture.VoitureException;
import Voiture.VoitureFactory;
import simulation.Simulation;
import strategy.Strategy;
import strategy.StrategyGenome;
import tools.DessinTools;
import Circuit.Circuit;

public class FitnessOperatorImpl implements FitnessOperator<Double> {

	private Circuit c;
	private Simulation sim;
	Dijkstra dij;
	String str;
	
	public FitnessOperatorImpl (Circuit c, String str){
		this.c = c;
		 dij =  new Dijkstra(c) ;
		this.str = str;
		
		
	}
	public double fit(Genome<Double> g) {
		try {
			Voiture v = VoitureFactory.build(c.getPointDepart(), c.getDirectionDepart());
			Radar r = new RadarDijkstra(v, c, dij.getMatrice());
			Strategy s = new StrategyGenome(v,r,g,dij,str);
			
			sim = new Simulation (c, v, s);
			sim.setAnimated(true);
			int iterations = (sim.play());
			DessinTools.dessinerTrajet("bob", c, sim.getList() , Color.black);
			if(sim.isReussi()){
				return -iterations;
			}
			else
				return -1000000+dij.getMatrice()[(int) sim.getLastDij().getX()][(int) sim.getLastDij().getY()];
		} catch (VoitureException e) {
			e.printStackTrace();
		}
		
		return -1000002;
	}
}
