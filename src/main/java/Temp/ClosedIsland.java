package Temp;

public class ClosedIsland {

    public static void main(String args[]){

        int [][] grid = {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};

        System.out.println("Final result: " + cIsland(grid));
    }

    public static int cIsland(int[][] grid) {
        if(grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int [][]visited = new int[n][m];
        int count =0;

        for(int i =0 ; i< n ; i++){
            for(int j =0 ; j< m ; j++){

                if(visited[i][j] != 1 && grid[i][j] == 0){

                    boolean result = dfs(i, j, grid, visited);
                    System.out.println(i +" , "+ j + "  : " + result);
                    if(result){
                        count++;
                    }
                }
            }
        }

        return count;

    }


    public static boolean dfs(int x, int y, int[][]grid, int [][] visited){
        boolean isClosed = true;
        visited[x][y] = 1;
        int n = grid.length;
        int m = grid[0].length;

        int[] delx = new int[]{1,0,-1,0};
        int[] dely = new int[]{0,1,0,-1};

        for(int i=0; i<4 ; i++){
            if(x + delx[i] <0
                    || x + delx[i] >=n
                    || y + dely[i] <0
                    || y + dely[i] >=m){
                isClosed =false;
            }
        }


        for(int i=0; i<4 ; i++){
            if(x + delx[i] >=0
                    && x + delx[i] <n
                    && y + dely[i] >=0
                    && y + dely[i] <m
                    && visited[x + delx[i]][y + dely[i]] !=1
                    && grid[x + delx[i]][y + dely[i]] == 0){
                isClosed = dfs(x + delx[i], y + dely[i], grid, visited) && isClosed;
            }
        }

        return isClosed;

    }
}
