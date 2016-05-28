public class GameLife 
{	
	public static void Draw(boolean[][] a, boolean which)
	{
		int N = a.length;
		
		StdDraw.setXscale(-1, N);
		StdDraw.setYscale(-1, N);
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (a[i][j] == which)  StdDraw.filledSquare(j, N-i-1, .5);
				StdDraw.show(125);
				StdDraw.clear();
	}
	
	public static boolean look(boolean[][] post, int i, int j)
	{
		int count = 0;
			for (int k = i-1; k <= i +1; k++)
				{
				if (k < 0 || k == post.length) continue;
					for (int l = j-1; l <= j+1;l++)
					{
						
						if (l < 0 || l == post[0].length) continue;
						if (k == i && l == j) continue;
						if (post[k][l]) count++;
					}
				}
			if (post[i][j])
			{
				return (count == 2 || count == 3);// rules 2 and 3 if true stays alive if false die
			}
			else
			{
					return (count == 3); // when dead rule 1
			}
	}
	
	public static boolean[][] getNextGen(boolean [][] first)
	{
		int N = first.length;
		int M = first[0].length;
		boolean [][] next = new boolean[N][M];
			for (int i = 0; i < N; i++)
				{
				for(int j = 0; j < M; j++)
					{
					next[i][j] = look(first, i , j);
					}	
				}
			return next;
	}
	
	public static void start(boolean[][] current, boolean tfval)
	{
		int T = 256; // number of generations
			for (int i = 0; i < T; i++)
			{ 
				Draw(current , tfval);
				current = getNextGen(current);
			}
	}
	
	public static void main(String[] args)
	{
		int N = Integer.parseInt(args[0]);
		boolean [][] life = new boolean [N][N];
		for (int i = 0; i < N; i++)
			{
			for (int j = 0; j < N; j++)
				{
				life[i][j] = Math.random() < .5;
				}
			}
		StdDraw.setPenColor(0, 80, 180);
		start(life, true);
	}
	
}
