import java.util.LinkedList;
import java.util.Queue;

public class BFS_TEST1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < check.length; i++) {
			System.arraycopy(arr[i], 0, check[i], 0, check[0].length);
		}
		
		System.out.println("Start");
		BFS(0,0); 
		System.out.println(check[arr.length - 1][arr[0].length - 1]);
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int[][] arr = {
			 {1,0,1,1,1,1},
			 {1,0,1,0,1,0},
			 {1,0,1,0,1,1},
			 {1,1,1,0,1,1}};
	static boolean[][] vistied = new boolean[arr.length][arr[0].length];
	static Queue<int[]> q = new LinkedList<>();
	static int[][] check = new int[arr.length][arr[0].length]; 
	
	public static void BFS(int x, int y) {
		q.offer(new int[] {x,y});
		vistied[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			System.out.println("x ÁÂÇ¥ = " + now[0] + " y ÁÂÇ¥ = " + now[1]);
			int nowx = now[0];
			int nowy = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowx + dx[i];
				int nextY = nowy + dy[i];
				
				if(nextX < 0 || nextX >= 4 || nextY < 0 || nextY >= 6) {
					continue;
				}
				if(vistied[nextX][nextY] || arr[nextX][nextY] == 0) {
					continue;
				}
				
				q.offer(new int[] {nextX, nextY});
				check[nextX][nextY] = check[nowx][nowy] + 1;
				vistied[nextX][nextY] = true;
			}
		}
	}
}
