package tp1;

public class Imc {
	private double taille;
    private double poids;


    public Imc(double taille, double poids) {
        this.taille = taille;
        this.poids = poids;
    }

  
    public double calcul() {
        if (taille > 0) {
            return poids / (taille * taille);
        }
        return 0; 
    }
}
