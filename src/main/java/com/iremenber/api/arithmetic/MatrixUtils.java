package com.iremenber.api.arithmetic;

import java.util.Arrays;

/**
 * 旋转矩阵
 * @Author: zm
 * @Date: 2019/9/17 11:43
 * @Version: 1.0
 */
public class MatrixUtils {
    public static int[][] rotate(int[][] matrix){
        int N = matrix.length;
        int N_INDEX = N - 1;
        int tmp = 0;
        for (int layer = 0;layer < N/2; layer ++){
            for (int offset = 1;offset < N - layer*2 ;offset ++){
                tmp = matrix[layer][layer + offset];//up
//                up = left
                matrix[layer][layer + offset] = matrix[N_INDEX-(layer + offset)][layer];
//                left = down
                matrix[N_INDEX -(layer + offset)][layer] = matrix[N_INDEX - layer][N_INDEX-(layer + offset)];
//                down = right
                matrix[N_INDEX - layer][N_INDEX-(layer + offset)] = matrix[layer + offset][N_INDEX - layer];
//                right = tmp
                matrix[layer + offset][N_INDEX - layer] = tmp;
//                matrix[layer + offset][N_INDEX - layer];//right
//                matrix[layer][layer + offset] //up
//                matrix[N_INDEX - layer][N_INDEX-(layer + offset)];//down
//                matrix[N_INDEX - (layer + offset)][layer];//left
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
