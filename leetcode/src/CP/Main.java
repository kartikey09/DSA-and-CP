package CP;


/*
    Author : Kartikey Rana
    from IIIT-B '27
    
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static class FR {
		//USE BUFFEREDREADER FOR ALL KINDS OF INPUTS AND MANUALLY PARSE THE STRING INTO DESIRED DATA TYPES.
		//USE BUFFEREDWRITER FOR PRINTING LARGE DATA
		BufferedReader br;	//BufferedReader reads everything as strings, so you need to manually parse them. 
		StringTokenizer st;		// used to read string as tokens which can be delimited by commas or space, if no token is specified then space is considered as a token.   

		public FR() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		// NEXT INT ARRAY

		int[] NIA(int n) {
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

		// NEXT DOUBLE ARRAY

		double[] NDA(int n) {
			double arr[] = new double[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextDouble();
			return arr;
		}

		// NEXT LONG ARRAY

		long[] NLA(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextLong();
			return arr;
		}

		// NEXT STRING ARRAY

		String[] NSA(int n) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++)
				arr[i] = next();
			return arr;
		}

		// NEXT CHARACTER ARRAY

		char[] NCA(int n) {
			char[] arr = new char[n];
			String s = sc.nextLine();

			for (int i = 0; i < n; i++)
				arr[i] = s.charAt(i);
			return arr;
		}

	}

//*************************  FR CLASS ENDS **********************************

	static long mod = (long) (1e9 + 7);

	public static int[] sieve(int n) {

		int[] primes = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			primes[i] = i;
		}

		for (int i = 2; i < n; i++) {
			if (primes[i] < 0)
				continue;
			if ((long) i * (long) i > n)
				break;
			for (int j = i * i; j < n; j++) {
				if (primes[j] > 0 && primes[j] % primes[i] == 0)
					primes[j] = -primes[j];
			}
		}
		return primes;
	}

	static int lcm(int a, int b) {
		return (int) ((a / gcd(a, b)) * b);
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	static long[][] ncr(int n, int k) {
		long C[][] = new long[n + 1][k + 1];
		int i, j;

		// Calculate value of Binomial
		// Coefficient in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using
				// previously stored values
				else
					C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % mod;
			}
		}

		return C;
	}

	static long modInverse(long a, long m) {
		long g = gcd(a, m);

		return power(a, m - 2, m);

	}

	static long power(long x, long y, long m) {
		if (y == 0)
			return 1;
		long p = power(x, y / 2, m) % m;
		p = (int) ((p * (long) p) % m);
		if (y % 2 == 0)
			return p;
		else
			return (int) ((x * (long) p) % m);
	}

	static int XOR(int n) {
		if (n % 4 == 0)
			return n;

		if (n % 4 == 1)
			return 1;

		if (n % 4 == 2)
			return n + 1;

		return 0;
	}

	/* ***************************************************************************************************************************************************/


	static class Pair implements Comparable<Pair> {

		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			return this.x - o.x;
		}

	}
	
	static int[] fact;
	static void factorial(int n) {
		fact = new int[n+1];
		generateFactArray(n+1);
	}
	
	static int generateFactArray(int n) {
		if(n < 2) {
			fact[n] = 1;
			return fact[n];
		}
		
		fact[n] = generateFactArray(n-1);
		return fact[n];
			
	}
	
	static FR sc = new FR();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		System.out.println("enter an size");
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		System.out.println("enter array elements");
		String[] s = br.readLine().split(",");
		
		

		bw.write(n + "hello");
		bw.flush();
		
//		rec(0, s, new StringBuilder(""), 0);
		
		
		
		
		
//		int tc = sc.nextInt();
//
//		while (tc-- > 0) {
//			TEST_CASE();
//		}
//		sb.setLength(sb.length() - 1);
//		System.out.println(sb);
	}

	private static void rec(int idx, String s, StringBuilder str, int sumSoFar) {
		if(idx == s.length()) {
			if(sumSoFar > 0)
				System.out.println(str.toString() + sumSoFar);
			else
				System.out.println(str.toString());
			return;
		}
		if(sumSoFar != 0) {
			rec(idx+1, s, new StringBuilder(str.toString() + (String.valueOf(sumSoFar) + s.charAt(idx))), 0); //char taken
			rec(idx+1, s, new StringBuilder(str), sumSoFar+1); //char left
		} else {
			rec(idx+1, s, new StringBuilder(str.toString() + (s.charAt(idx))), 0); //char Taken
			rec(idx+1, s, new StringBuilder(str), sumSoFar+1); //char left
			
		}
	}

	static void TEST_CASE() throws IOException {
		
		
	}
	
}


















