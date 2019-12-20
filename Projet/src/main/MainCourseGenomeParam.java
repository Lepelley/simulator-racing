package main;

import java.awt.Color;
import java.io.IOException;

import optimisation.GenereGenome;
import optimisation.Genome;
import simulation.Simulation;
import strategy.Strategy;
import strategy.StrategyGenome;
import tools.DessinTools;
import tools.ToolsFichiers;
import dijkstra.Dijkstra;
import Circuit.Circuit;
import Circuit.CircuitFactoryFromFile;
import Radar.Radar;
import Radar.RadarDijkstra;
import Voiture.Voiture;
import Voiture.VoitureException;
import Voiture.VoitureFactory;

public class MainCourseGenomeParam {
	public static void main(String[] args) throws VoitureException, IOException {
		
		String fichier = "1_safe.trk";
		Circuit  circuit = CircuitFactoryFromFile.build("Tracks/"+fichier);
		
		Voiture v = VoitureFactory.build(circuit.getPointDepart(), circuit.getDirectionDepart());
		
		Dijkstra dij =  new Dijkstra(circuit) ;
		Radar r = new RadarDijkstra(v, circuit, dij.getMatrice());
		GenereGenome gen = new GenereGenome(fichier);
		Genome<Double> g = new Genome<Double>();
		for(double x:gen.getDefault()){
			g.add(x);
		}
		Strategy s = new StrategyGenome(v, r, g,dij,fichier);

		
		
	
		Simulation sim = new Simulation (circuit, v, s);
		
		
		
		
		
		
		sim.setAnimated(true);
		sim.play();
		System.out.println(sim.getI());
	
		
		DessinTools.dessinerTrajet(fichier.substring(0,fichier.length()-4), circuit, sim.getList() , Color.black);
		ToolsFichiers.saveListeCommande(sim.getRecord(), "Logs/"+fichier.substring(0,fichier.length()-4)+"-log");
		
		
	
	
	}
}
