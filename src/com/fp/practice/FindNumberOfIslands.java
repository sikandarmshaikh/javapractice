package com.fp.practice;

import java.util.ArrayList;

/**
 *  https://www.codingninjas.com/codestudio/problems/find-number-of-islands_630512?topList=top-array-coding-interview-questions&leftPanelTab=2
 *  Time Complexity: O(N * M)
 *  Space Complexity: O(N * M)
 *  Where N and M are the number of rows and columns of the 2D array, respectively.
*/
public class FindNumberOfIslands {
	
	private static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

    /*
        dx[] and dy[] are the arrays that define each of the eight directions.

        dx[0], dy[0] : West
        dx[1], dy[1] : North-West
        dx[2], dy[2] : North
        dx[3], dy[3] : North-East
        dx[4], dy[4] : East
        dx[5], dy[5] : South-East
        dx[6], dy[6] : South
        dx[7], dy[7] : South-West

    */

    private static ArrayList<ArrayList<Boolean>> vis = new ArrayList<>();

    private static void getTotalIslandsHelper(int[][] mat, int n, int m, int x, int y) 
	{

        // Check if this cell is valid.
        if(!(x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1 && !vis.get(x).get(y))) 
		{
            return; 
        }

        vis.get(x).set(y, true);

        for(int i = 0; i < 8; i++) 
		{
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            getTotalIslandsHelper(mat, n, m, nextX, nextY);
        }
    }

    public static int getTotalIslands(int[][] mat) 
	{
        int n = mat.length;
        if (n == 0) 
		{
            return 0;
        }
        int m = mat[0].length;
        for (int i = 0; i < n; i++) 
		{    
            vis.add(new ArrayList<>());
            ArrayList<Boolean> list = vis.get(i);
            for(int j = 0; j < m; j++) 
			{
                list.add(false);
            }
        }

        int islands = 0;

        for(int i = 0; i < n; i++) 
		{
            for(int j = 0; j < m; j++) 
			{
                if(mat[i][j] == 1 && !vis.get(i).get(j)) 
				{
                    // We have found an undiscovered island.
                    islands++;
                    getTotalIslandsHelper(mat, n, m, i, j);
                }
            }
        }

        return islands;
    }

}

/*  Problem Statement
 You are given a 2-dimensional array/list having N rows and M columns, which is filled with ones(1) and zeroes(0). 1 signifies land, and 0 signifies water.
A cell is said to be connected to another cell, if one cell lies immediately next to the other cell, in any of the eight directions (two vertical, two horizontal, and four diagonals).
A group of connected cells having value 1 is called an island. Your task is to find the number of such islands present in the matrix.
Input Format :
The first line of input contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

The second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the i-th row constitutes 'M' column values separated by a single space.
Output Format :
The only line of output prints the number of islands present in the 2-dimensional array.
Note :
You are not required to print anything explicitly, it has already been taken care of. Implement the function and return the desired output.
Constraints :
1 <= N <= 10^3 
1 <= M <= 10^3
0 <= ARR[i][j] <= 1

Time limit: 1sec
Sample Input 1 :
4 5
0 1 1 0 0
1 0 0 1 0
0 0 1 0 0
1 0 0 0 1
Sample Output 1 :
3
Explanation For Sample Input 1 :
The first island of connected 1s is signified by: {0, 1}, {0, 2}, {1, 0}, {1, 3}, {2, 2}.

The second island being: {3, 0}.

The third island being: {3, 4}.
Sample Input 2 :
4 4
1 0 0 1
0 1 1 0
0 1 1 0
1 0 0 1
Sample Output 2 :
1
*/
