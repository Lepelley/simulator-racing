package IHM.Swing;

import java.awt.Dimension;

import Circuit.Circuit;
import IHM.CircuitObserver;
import IHM.TrajetObserver;
import IHM.VoitureObserver;
import Radar.Radar;
import Voiture.Voiture;

public class ManageIHM {
	public static IHMSwing manageIHM(IHMSwing ihm,Circuit c, Voiture v, Radar r){
		ihm.setMinimumSize(new Dimension(768,1024));
		ihm.setPreferredSize(new Dimension(768,1024));
		ihm.reset();
		ihm.add(new CircuitObserver(c));
		ihm.add(new VoitureObserver(v));
		ihm.add(new TrajetObserver(v));
		return ihm;
	}
	
	
}
