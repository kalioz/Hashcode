public class Main {
	EndPoint [] endPoints;
	Cache [] caches;
	Requete [] requetes;
	Video [] videos;
	
	int cacheCapacity;
	
	public static void main(String[] args){
		Main game = new Main();
		game.load("C:/Users/truc/Downloads/me_at_the_zoo.in");
		System.out.println("Score initial = "+game.calculateScore());
	}
	
	void load(String pathToSource){
		System.out.println("reading");
		String [] texte = gestionIO.read(pathToSource);
		System.out.println("reading ended");
		
		//décryptage des données
		//line 0 = V E R C X
		String [] line0 = texte[0].split(" ");		
		videos = new Video[Integer.parseInt(line0[0])];
		endPoints = new EndPoint[Integer.parseInt(line0[1])];
		requetes = new Requete[Integer.parseInt(line0[2])];
		caches = new Cache[Integer.parseInt(line0[3])];
		for (int i = 0; i < caches.length; i++){
			caches[i] = new Cache();
		}
		cacheCapacity = Integer.parseInt(line0[4]);
		
		// taille des videos
		String [] line1 = texte[1].split(" ");
		for (int i = 0; i < videos.length; i++){
			videos[i] = new Video(Integer.parseInt(line1[i]));
		}
		System.out.println("vidéo "+videos[0].UID+" - taille = "+videos[0].taille);
		
		//EndPoints
		int j = 2;
		for (int i = 0; i < endPoints.length; i++){
			String [] lineI0 = texte[j].split(" ");
			j++;
			int latency = Integer.parseInt(lineI0[0]);
			int nbCaches = Integer.parseInt(lineI0[1]);
			int [] c = new int[nbCaches];
			Cache[] c2 = new Cache[nbCaches];
			int [] la = new int[nbCaches];
			for (int k = 0; k < nbCaches; k++){
				String[] lineIk = texte[j].split(" ");
				j++;
				c[k] = Integer.parseInt(lineIk[0]);
				c2[k] = this.caches[c[k]];
				la[k] =Integer.parseInt(lineIk[1]);
			}
			endPoints[i] = new EndPoint(latency,c,la);
			endPoints[i].setCachesConnectes(c2);
		}
		System.out.println("endPoint "+endPoints[0].UID +" - nb Caches : "+endPoints[0].getCachesConnectesID().length + "caches 0 : "+endPoints[0].getCachesConnectesID()[0] );
		System.out.println("latency to DC : "+endPoints[0].getLatencyToDataCenter());
		
		//ajout Endpoints dans cache
		int [] cNum = new int[this.caches.length];
		for (int i = 0; i < this.endPoints.length; i++){
			for (int k = 0; k < this.endPoints[i].getCachesConnectesID().length; k++){
				cNum[this.endPoints[i].getCachesConnectesID()[k]]++;
			}
		}
		for (int i = 0; i < cNum.length; i++){
			int []listeEndPoints = new int[cNum[i]];
			int k = 0;
			for (int h = 0; h < this.endPoints.length; h++){
				for (int g = 0; g < this.endPoints[h].getCachesConnectes().length; g++){
					if (i == this.endPoints[h].getCachesConnectesID()[g]){
						listeEndPoints[k] = h;
						k++;
					}
				}
			}
			this.caches[i].setlisteEndPoints(listeEndPoints);
		}
		System.out.println("cache 0 est connecté à "+this.caches[0].getlisteEndPoints().length+" EP"); 
		
		//Requetes
		int [] requetesParEndPoint = new int[endPoints.length];
		for (int i = 0; i < this.requetes.length; i++){
			String [] line = texte[j].split(" ");
			j++;
			requetesParEndPoint[Integer.parseInt(line[1])]++;
			requetes[i] = new Requete(videos[Integer.parseInt(line[0])],endPoints[Integer.parseInt(line[1])],Integer.parseInt(line[2]));
		}
		for (int i = 0; i < this.endPoints.length; i++){
			Requete [] reqs = new Requete[requetesParEndPoint[i]];
			j = 0;
			for (int k = 0; k < this.requetes.length; k++){
				if (this.requetes[k].getEndPoint().getUID() == i){
					reqs[j] = this.requetes[k];
					j++;
				}
			}
			this.endPoints[i].setVideosDemandes(reqs);
		}
		
		System.out.println("EnDPoint 0 : "+this.endPoints[0].getVideosDemandes().length+" videos demandées");
		System.out.println("requete 0 : video "+requetes[0].getVideo().getUID() + " - endpoint "+requetes[0].getEndPoint().getUID()+" - nb connexions "+requetes[0].getNbRequetes());
		
		System.out.println(">> End of load");
	}
	
	int calculateScore(){
		int score = 0;
		for (int iEnd = 0; iEnd < this.endPoints.length; iEnd++){
			for (int iVid = 0; iVid < this.endPoints[iEnd].getVideosDemandes().length; iVid++){
				int vid = this.endPoints[iEnd].getVideosDemandes()[iVid].getVideo().getUID();
				int minimalTime = this.endPoints[iEnd].getLatencyToDataCenter();
				for (int iCache = 0; iCache < this.endPoints[iEnd].getCachesConnectes().length; iCache++){
					if (this.endPoints[iEnd].getCachesConnectes()[iCache].possedeVideo(vid)){
						minimalTime = Math.min(minimalTime, this.endPoints[iEnd].getLatencies()[iCache]);
					}
				}
				score += (this.endPoints[iEnd].getLatencyToDataCenter() - minimalTime)*this.endPoints[iEnd].getRequeteFromVideo(this.endPoints[iEnd].getVideosDemandes()[iVid].getVideo());
			}
		}
		
		return score;
	}
	
}
