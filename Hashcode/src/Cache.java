import java.util.List;
public class Cache {
	int UID;
	int capacite;
	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public void decCapacite(int nombreDec){
		this.capacite-=nombreDec;
	}
	
	static int nbCreated;
	int [][] listevideo;
	int [] cacheVideo;
	int [] cacheVideoFin;
	//getters and setters
	public int[] getCacheVideoFin() {
		return cacheVideoFin;
	}

	public void setCacheVideoFin(int[] cacheVideoFin) {
		this.cacheVideoFin = cacheVideoFin;
	}

	EndPoint [] listeEndPoints;
	
	public EndPoint[] getlisteEndPoints() {
		return this.listeEndPoints;
	}

	public void setlisteEndPoints(EndPoint[] listeEP) {
		this.listeEndPoints = listeEP;
	}
	
	
	public int[][] getListeVideo() {
		return listevideo;
	}

	public void setListeVideo(int[][] video) {
		this.listevideo = video;
	}
	public int[] getCacheVideo() {
		return this.cacheVideo;
	}

	public void setCacheVideo(int[] cache) {
		this.cacheVideo = cache;
	}
	
	
	//constructeur
	Cache(){
		this.UID = Cache.nbCreated;
		Cache.nbCreated++;
		
	}
	
	int getUID(){return this.UID;}
	
	boolean possedeVideo(int numeroVideo){
		boolean retour = false;
		for (int i=0;i<this.getListeVideo().length;i++){
			if(this.getListeVideo()[i][0]==numeroVideo){
				retour = true;
			}
		}
		return retour;
	}
	void construitListe(int nombreVideos){
		
	
		for (int i=0;i<this.listeEndPoints.length;i++){
			for(int j=0;j<this.listeEndPoints[i].getVideoRequest().length;i++){
			
			} 
		}
		
	}
	
	
	int construitRapport(int numVideo){
		for (int i=0;i<this.listeEndPoints.length;i++){
			
		}
		return 0;
	}
	
	void classeVideos(){
		
	}
}
