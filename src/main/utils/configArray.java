package main.utils;

public class configArray {
    public static void reverse(int[] rowIndices) {
        for (int i=0; i<rowIndices.length/2; i++) {
            int temp = rowIndices[0];
            rowIndices[0] = rowIndices[rowIndices.length-1] =temp;
        }
    }
}
