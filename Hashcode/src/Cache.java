
public class Cache {
	int UID;
	static int nbCreated;
	int [][] listevideo;
	int [] cacheVideo;
	int [] listeEndPoints;
	//getters and setters
	public int[] getlisteEndPoints() {
		return this.listeEndPoints;
	}

	public void setlisteEndPoints(int[] listeEP) {
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
	void construitRapport(){
		
	}
	
	void classeVideos(){
		
	}
}
