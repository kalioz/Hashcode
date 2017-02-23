public class EndPoint {
	int latencyToDataCenter;
	int [] cachesConnectesID;
	int [] latencies;
	Requete [] videosDemandes;
	Cache [] cachesConnectes;//a implémenter APRES l'ID;
	int UID;
	int [][] videoRequest;
	
	
	public int[][] getVideoRequest() {
		return videoRequest;
	}

	public void setVideoRequest(int[][] videoRequest) {
		this.videoRequest = videoRequest;
	}

	public int[] getLatencies() {
		return latencies;
	}

	public void setLatencies(int[] latencies) {
		this.latencies = latencies;
	}

	public int getRequeteFromVideo(Video vid){
		int retour = 0;
		for (int i = 0; i < this.getVideosDemandes().length; i++){
			if (this.getVideosDemandes()[i].getVideo() == vid){
				retour += this.getVideosDemandes()[i].getNbRequetes();
			}
		}
		return retour;
	}
	
	static int nbCreated;
	
	EndPoint(int latencyToDataCenter, int [] cachesConnectesID, int [] latencies){
		this.latencyToDataCenter = latencyToDataCenter;
		this.cachesConnectesID = cachesConnectesID;
		this.latencies = latencies;
		this.UID = EndPoint.nbCreated;
		
		EndPoint.nbCreated++;		
	}

	public int getLatencyToDataCenter() {
		return latencyToDataCenter;
	}

	public void setLatencyToDataCenter(int latencyToDataCenter) {
		this.latencyToDataCenter = latencyToDataCenter;
	}

	public int[] getCachesConnectesID() {
		return cachesConnectesID;
	}

	public void setCachesConnectesID(int[] cachesConnectesID) {
		this.cachesConnectesID = cachesConnectesID;
	}

	public Requete[] getVideosDemandes() {
		return videosDemandes;
	}

	public void setVideosDemandes(Requete[] videosDemandes) {
		this.videosDemandes = videosDemandes;
	}

	public Cache[] getCachesConnectes() {
		return cachesConnectes;
	}

	public void setCachesConnectes(Cache[] cachesConnectes) {
		this.cachesConnectes = cachesConnectes;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public static int getNbCreated() {
		return nbCreated;
	}

	public static void setNbCreated(int nbCreated) {
		EndPoint.nbCreated = nbCreated;
	}
	
	
}
