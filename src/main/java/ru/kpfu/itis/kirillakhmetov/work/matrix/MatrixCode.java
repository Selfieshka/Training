package ru.kpfu.itis.kirillakhmetov.work.matrix;

public class MatrixCode {
    private int n;
    private MyLinkedList<NodeMatrix> list;
    public MatrixCode(int[][] arr) {
        this.n = arr.length;
        remake(arr);
    }

    public int[][] decode() {
        int[][] arr = new int[n][n];
        for (int i = 0; i < list.size; i++) {
            NodeMatrix nodeMatrix = list.get(i);
            arr[nodeMatrix.getI()][nodeMatrix.getJ()] = nodeMatrix.getValue();
        }
        return arr;
    }

    private void remake(int[][] arr) {
        this.list = new MyLinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    list.add(new NodeMatrix(i, j, arr[i][j]));
                }
            }
        }
    }

    public void insert(int i, int j, int value) {
        NodeMatrix nodeMatrix;
        for (int k = 0; k < list.size; k++) {
            nodeMatrix = list.get(k);
            if (nodeMatrix.getI() == i && nodeMatrix.getJ() == j) {
                list.get(k).setValue(value);
                return;
            }
        }
        nodeMatrix = new NodeMatrix(i, j, value);
        list.add(nodeMatrix);
    }

    public void delete(int i, int j) {
        NodeMatrix nodeMatrix;
        for (int k = 0; k < list.size; k++) {
            nodeMatrix = list.get(k);
            if (nodeMatrix.getI() == i && nodeMatrix.getJ() == j) {
                list.delete(k);
                break;
            }
        }
    }

    public int sum() {
        int sum = 0;
        for (int k = 0; k < list.size; k++) {
            NodeMatrix nodeMatrix = list.get(k);
            if (nodeMatrix.getI() == nodeMatrix.getJ()) {
                sum += nodeMatrix.getValue();
            }
        }
        return sum;
    }
}
