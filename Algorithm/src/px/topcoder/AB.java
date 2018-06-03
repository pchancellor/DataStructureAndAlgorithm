package px.topcoder;

public class AB {
	
	public static void main(String[] args) {
		System.out.println(new AB().createString(3, 2));
	}

	//time: 2s, memory: 256MB
	public String createString(int N, int K) {
		if (K > N/2*(N-N/2)) {
			return "";
		}
		byte[] bytes = new byte[N];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = 'A';
		}
		String target = new String(bytes);
		
		return target;
	}
}
