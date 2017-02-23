
public class Cache {
	int UID;
	static int nbCreated;
	int [][] video;
	
	public int[][] getVideo() {
		return video;
	}

	public void setVideo(int[][] video) {
		this.video = video;
	}

	Cache(){
		this.UID = Cache.nbCreated;
		Cache.nbCreated++;
	}
	
	int getUID(){return this.UID;}
	
}
