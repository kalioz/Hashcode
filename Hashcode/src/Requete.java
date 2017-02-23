
public class Requete {
	Video video;
	EndPoint endPoint;
	int nbRequetes;
	
	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public EndPoint getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(EndPoint endPoint) {
		this.endPoint = endPoint;
	}

	public int getNbRequetes() {
		return nbRequetes;
	}

	public void setNbRequetes(int nbRequetes) {
		this.nbRequetes = nbRequetes;
	}

	Requete(Video video,EndPoint endPoint,int nbRequetes){
		this.nbRequetes = nbRequetes;
		this.video = video;
		this.endPoint = endPoint;
	}
	
}
