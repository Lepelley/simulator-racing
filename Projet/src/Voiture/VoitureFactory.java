package Voiture;

import geometrie.Vecteur;

public class VoitureFactory {
	public static Voiture build(Vecteur v, Vecteur d){
		//double x, double y, double vmax, double alpha_c, double braquage, double alpha_f, double beta_f
		return new VoitureImpl(v.clone(),d.clone(),0.9,0.005,0.1,0.0002,0.0005);
	}
}
