public class Main {
	EndPoint [] endPoints;
	Cache [] caches;
	Requete [] requetes;
	Video [] videos;
	
	int cacheCapacity;
	
	public static void main(String[] args){
		Main game = new Main();
		game.load("C:/Users/truc/Downloads/me_at_the_zoo.in");
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
		
		//Requetes
		for (int i = 0; i < this.requetes.length; i++){
			String [] line = texte[j].split(" ");
			j++;
			requetes[i] = new Requete(videos[Integer.parseInt(line[0])],endPoints[Integer.parseInt(line[1])],Integer.parseInt(line[2]));
		}
		
		System.out.println("requete 0 : video "+requetes[0].getVideo().getUID() + " - endpoint "+requetes[0].getEndPoint().getUID()+" - nb connexions "+requetes[0].getNbRequetes());
		
	
	}
	
}
