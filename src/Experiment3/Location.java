import java.util.Scanner;

public class Location {
    public int row, column;
    public double maxValue;

    public static Location locateLargetst(double[][] a) {
        Location location = new Location();
        int row = a.length;
        int column = a[0].length;
        int maxrow = 0;
        int maxcolumn = 0;
        double maxValue = a[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (maxValue < a[i][j]) {
                    maxValue = a[i][j];
                    maxrow = i;
                    maxcolumn = j;
                }
            }
        }
        location.setRow(maxrow);
        location.setColumn(maxcolumn);
        location.setMaxValue(maxValue);
        return location;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入二维数组的行数和列数:");
        int row, column;
        row = scanner.nextInt();
        column = scanner.nextInt();
        System.out.println("输入数组:");
        double[][] list = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double value = scanner.nextDouble();
                list[i][j] = value;
            }
        }
        Location location = locateLargetst(list);
        System.out.println("最大元素及其下标是:" + location.getMaxValue() + "在" + "(" + location.getRow() + "," + location.getColumn() + ")");
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }


}
