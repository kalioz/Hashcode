
public class Video {
	int UID;
	static int nb;
	int taille;
	
	Video(int taille){
		this.taille = taille;
		this.UID = Video.nb;
		Video.nb++;
	}
	
}
