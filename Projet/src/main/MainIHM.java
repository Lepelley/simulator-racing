package main;

import java.io.IOException;

import optimisation.GenereGenome;
import optimisation.Genome;
import dijkstra.Dijkstra;
import simulation.Simulation;
import strategy.*;
import IHM.Fenetre;
import Circuit.Circuit;
import Circuit.CircuitFactoryFromFile;
import IHM.Swing.IHMSwing;
import IHM.Swing.ManageIHM;
import Radar.Radar;
import Radar.RadarDijkstra;
import Voiture.Voiture;
import Voiture.VoitureException;
import Voiture.VoitureFactory;

public class MainIHM {
	public static void main(String[] args) throws VoitureException, IOException {

		String file = "1_safe.trk";
		Circuit  circuit = CircuitFactoryFromFile.build("Tracks/"+file);
		
		Voiture v = VoitureFactory.build(circuit.getPointDepart(), circuit.getDirectionDepart());
		
		
		Dijkstra dij =  new Dijkstra(circuit) ;
//		DessinTools.dessinerDijkstra("labymod-dij", circuit, dij.getMax(), Color.magenta);
		Radar r = new RadarDijkstra(v, circuit, dij.getMatrice());
		GenereGenome gen = new GenereGenome(file);
		Genome<Double> g = new Genome<Double>();
		for(double x:gen.getDefault()){
			g.add(x);
		}
		Strategy s = new StrategyGenome(v, r, g,dij,file);		
//		Strategy s = new StrategyDebile(new StrategyRadarDijkstra(v, r), v, dij);
		Simulation sim = new Simulation (circuit, v, s);

		IHMSwing ihm = new IHMSwing();
		ManageIHM.manageIHM(ihm, circuit, v,r);
		sim.add(ihm);
		
		@SuppressWarnings("unused")
		Fenetre fen = new Fenetre(sim, ihm);

	}
}