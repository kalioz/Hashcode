
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
		
		for (j=0;j<this.caches.length;j++) //première vidéo va forcement dans le cache
			caches[j].getCacheVideoFin()[0] = caches[j].getListeVideo()[0][0];
		
		
		for (k=1;k<this.videos.length;k++){ //Pour toutes les vidéo potentielles
			
			for (i=0;i<this.caches.length;i++){ //on parcours chaque caches
				 remplace=false;
				 comparaisonVideo = caches[i].getListeVideo()[k][0]; //on prend la vidéo de rang où l'on se trouve
				 
				 for (j=0;j<this.caches.length;j++){ //on regarde si il n'y a pas deux vidéos au même rang
					//SI on est sur 2 même vidéos sur 2 caches différent au mêmme rang
					 if(comparaisonVideo == caches[j].getListeVideo()[k][0] && j!=i){	 
						 //On compare leurs rapports
						 if(caches[j].getListeVideo()[k][2] > caches[i].getListeVideo()[k][1]){
							//Si l'autre cache à un rapport plus élevé on regarde si il a la capacité pour l'accueillir
							 if(caches[j].getCapacite() >= videos[caches[i].getListeVideo()[k][0]].getTaille()){
								 remplace=true;
							 }
						 }
					 }
					 
					 //SINON on attibut au cache sa vidéo si il a la capacité nécéssaire si personne ne l'a ou ne peut l'accueillir
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
	
}
