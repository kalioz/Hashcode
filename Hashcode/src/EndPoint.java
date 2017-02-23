
public class EndPoint {
	int latencyToDataCenter;
	int [] cachesConnectesID;
	Requete [] videosDemandes;
	
	
	Cache [] cachesConnectes;//a impl�menter APRES l'ID;
	int UID;
	
	static int nbCreated;
	
	EndPoint(int latencyToDataCenter, int [] cachesConnectesID){
		this.latencyToDataCenter = latencyToDataCenter;
		this.cachesConnectesID = cachesConnectesID;
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
