package Voiture;

import geometrie.Vecteur;

public class VoitureImpl implements Voiture{
	
	private double vmax;
	private double alpha_c;
	private double braquage;
	private double alpha_f;
	private double beta_f;
	
	private double vitesse;
	
    private double[] tabVitesse     = {0.1, 0.2,  0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.};
    private double[] tabTurn        = {1.,  0.9, 0.75, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05};
	
	private Vecteur position;
	private Vecteur direction;
	
	
	
    public VoitureImpl(Vecteur p, Vecteur d, double vmax, double alpha_c, double braquage, double alpha_f, double beta_f){
    	
		position = p;
		direction = d;
	
		this.vmax = vmax;
		this.alpha_c = alpha_c;
		this.braquage = braquage;
		this.alpha_f = alpha_f;
		this.beta_f = beta_f;
		
		vitesse = 0;
		
	}
    
    
	public void drive(Commande c) throws VoitureException{
		double t = c.getTurn();
		
		if(getMaxTurn() < Math.abs((c.getTurn())))
			throw new VoitureException(getMaxTurn()+" "+c.getTurn());
		
		// approche normale
        // 1) gestion du volant
        direction.rotation(t * braquage); // modif de direction
       
        // 2.1) gestion des frottements
        vitesse -= alpha_f;
        vitesse -= beta_f*vitesse;

        // 2.2) gestion de l'acceleration/freinage
        vitesse += c.getAcc() * alpha_c;

        // 2.3) garanties, bornes...
        direction.normalisation(); // modif de direction
        vitesse = Math.max(0., vitesse); // pas de vitesse négative
        vitesse = Math.min(vmax, vitesse);

        // 3) mise à jour de la position
        position.additionVoid(direction.multiplicationReturn(vitesse));
		
	}
	
	
	
   //  private double[] tabVitesse     = {0.1, 0.2,  0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.};
   //  private double[] tabTurn        = {1.,  0.9, 0.75, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.05};
	
    public double getMaxTurn(){
//		int i=0;
//		while(i < 9 && vitesse > tabVitesse[i]*vmax){
//			i++;
//		}
    	for(int i=0; i<tabVitesse.length; i++)
    		if(vitesse <= tabVitesse[i]*vmax)
    			return tabTurn[i];
    	
    	return -100;
    }
		

    // pour l'observation
	public double getBraquage() {
		return braquage;
	}


	public double getVitesse() {
		return vitesse;
	}


	public Vecteur getPosition() {
		return new Vecteur(position.getX(),position.getY());
	}


	public Vecteur getDirection() {
		return new Vecteur(direction.getX(),direction.getY());
	}
    
    
    
    
    


	
}
