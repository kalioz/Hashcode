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
	int construitRapport(int numVideo, Video [] listeVideo){
		int somme=0;
		for (int i=0;i<this.listeEndPoints.length;i++){
			if(this.listeEndPoints[i].aLaVideo(numVideo)){
				somme+=this.listeEndPoints[i].getRequeteFromVideo(listeVideo[numVideo]);
			}
		}
		return somme;
	}
	void construitListe(int nombreVideos,Video [] listeVideoEntree){
		
		int [] listeNumeros=new int [nombreVideos];
		listeNumeros[0]=-1;
		for (int i=0;i<this.listeEndPoints.length;i++){
			for(int j=0;j<this.listeEndPoints[i].getVideoRequest().length;i++){
				listeNumeros[this.listeEndPoints[i].getVideoRequest()[j][0]]=this.listeEndPoints[i].getVideoRequest()[j][0];
			} 
		}
		int compteur=-1;
		for (int i=0;i<nombreVideos;i++){
			if (listeNumeros[i]!=0||listeNumeros[i]!=-1){
				compteur++;
			}
		}
		int savecompteur=compteur+1;
		int [] listeNumerosfinale = new int [savecompteur];
		
		for (int i=0;i<nombreVideos;i++){
			if (listeNumeros[i]!=0||listeNumeros[i]!=-1){
				listeNumerosfinale[compteur]=listeNumeros[i];
				compteur--;
			}
		}
			
		if(savecompteur!=0){
			int [][]listeVideo=new int [savecompteur][2];
			for (int i=0;i<savecompteur;i++){
				int numero=listeNumerosfinale[i];
				listeVideo[i][0]=numero;
				listeVideo[i][1]=construitRapport(numero,listeVideoEntree);
			}
			this.listevideo=listeVideo;
		}
		
		
		
	}
}
