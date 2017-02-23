
public class Cache {
	int UID;
	static int nbCreated;
	
	
	Cache(){
		this.UID = Cache.nbCreated;
		Cache.nbCreated++;
	}
	
	int getUID(){return this.UID;}
	
}
