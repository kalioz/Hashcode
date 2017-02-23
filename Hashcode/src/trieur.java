
public class trieur {
	static public int [] trieurDecroissant(int [] tableau ){
		int [] tableau2 = new int[tableau.length];
		
		for (int k = 0; k < tableau.length; k++){
			int max = -Integer.MIN_VALUE;
			int maxPosition = 0;
			for (int j = 0; j < tableau.length; j++){
				max = (max>tableau[j])?max:tableau[j];
				maxPosition = (max>tableau[j])?maxPosition:j;
			}
			tableau2[k] = max;
			tableau[maxPosition] = -Integer.MIN_VALUE;
		}
		
		return tableau2;
	}
}
