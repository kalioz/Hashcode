
public class Video {
	int UID;
	static int nb;
	int taille;
	EndPoint [] endPoints;
	
	Video(int taille ){
		this.taille = taille;
		this.UID = Video.nb;
		Video.nb++;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		Video.nb = nb;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public EndPoint[] getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(EndPoint[] endPoints) {
		this.endPoints = endPoints;
	}
	
	
}
