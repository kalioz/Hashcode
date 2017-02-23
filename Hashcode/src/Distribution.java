
public class Distribution {
	
	EndPoint [] endPoints;
	Cache [] caches;
	Requete [] requetes;
	Video [] videos;
	int cacheCapacity;
	
	Distribution(EndPoint [] endPoints,
				Cache [] caches,
				Requete [] requetes,
				Video [] videos,
				int cacheCapacity){
		
		this.endPoints=endPoints;
		this.caches=caches;
		this.requetes=requetes;
		this.videos=videos;
		this.cacheCapacity=cacheCapacity;
	}
	

	void attributionVideos(){
		
		int i,j,k;
		int comparaisonVideo;
		boolean remplace;
		
		for (j=0;j<this.caches.length;j++) //premi�re vid�o va forcement dans le cache
			caches[j].setCacheVideo(caches[j].getListeVideo()[0]);
		
		
		for (k=1;k<this.videos.length;k++){ //Pour toutes les vid�o potentielles
			
			for (i=0;i<this.caches.length;i++){ //on parcours chaque caches
				 remplace=false;
				 				 
				 comparaisonVideo = caches[i].getListeVideo()[k][0]; //on prend la vid�o de rang o� l'on se trouve
				 
				 for (j=0;j<this.caches.length;j++){ //on regarde si il n'y a pas deux vid�os au m�me rang
					//SI on est sur 2 m�me vid�os sur 2 caches diff�rent au m�mme rang
					 if(comparaisonVideo == caches[j].getListeVideo()[k][0] && j!=i){	 
						 //On compare leurs rapports
						 if(caches[j].getListeVideo()[k][2] > caches[i].getListeVideo()[k][1]){
							//Si l'autre cache � un rapport plus �lev� on regarde si il a la capacit� pour l'accueillir
							 if(caches[j].getCapacite() >= videos[caches[i].getListeVideo()[k][0]].getTaille()){
								 remplace=true;
							 }
						 }
					 }
					 
					 //SINON on attibut au cache sa vid�o si il a la capacit� n�c�ssaire si personne ne l'a ou ne peut l'accueillir
					 else if (remplace==false){
						 if (caches[i].getCapacite() >= videos[caches[i].getListeVideo()[k][0]].getTaille()){
							 caches[i].getCacheVideoFin()[k] = caches[i].getListeVideo()[k][0];
							 caches[i].decCapacite(videos[caches[i].getListeVideo()[k][0]].getTaille());
						 }
					 }
				}	
			}
		}
		
	}


	public EndPoint[] getEndPoints() {
		return endPoints;
	}


	public void setEndPoints(EndPoint[] endPoints) {
		this.endPoints = endPoints;
	}


	public Cache[] getCaches() {
		return caches;
	}


	public void setCaches(Cache[] caches) {
		this.caches = caches;
	}


	public Requete[] getRequetes() {
		return requetes;
	}


	public void setRequetes(Requete[] requetes) {
		this.requetes = requetes;
	}


	public Video[] getVideos() {
		return videos;
	}


	public void setVideos(Video[] videos) {
		this.videos = videos;
	}


	public int getCacheCapacity() {
		return cacheCapacity;
	}


	public void setCacheCapacity(int cacheCapacity) {
		this.cacheCapacity = cacheCapacity;
	}
	
}
