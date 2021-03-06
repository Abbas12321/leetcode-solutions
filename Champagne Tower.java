class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][101];
        tower[0][0] = poured;

        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col <= row; col++) {
                // 计算下一层两个杯子中的注入量
                double leftChampagne = (tower[row][col] - 1) / 2.0;
                if (leftChampagne > 0) {
                    tower[row + 1][col] += leftChampagne;
                    tower[row + 1][col + 1] += leftChampagne;
                }
            }
        }

        return Math.min(1, tower[query_row][query_glass]);
    }
}
