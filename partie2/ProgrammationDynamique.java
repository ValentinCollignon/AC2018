package AC2018.partie2;

public class ProgrammationDynamique {

	public static int C (int K, int N, int b, int m){
		int res = 0;
		if(N==0 || b==N){
			res = 1;
		}else{
		
			if(b>0){
				res+=C(K-1,N-1,b-1,m);
			}
			if(m>0){
				res+=C(K-1,N-1,b,m-1)*(N-b-1);
			}
			if(b+m<N){
				res+=C(K-1,N-1,b-1,m)*(K-N);
			}
		}
		return res;
	}
	public static void main(String[] args) {
	 	System.out.println("valeur pour N=4, K=6,b=1,m=2 : " +C(6, 4, 1, 2));
	}

}
