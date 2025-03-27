package tp1;

public class Imc {
	private double taille;
    public double getTaille() {
		return taille;
	}


	public void setTaille(double taille) {
		this.taille = taille;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


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
