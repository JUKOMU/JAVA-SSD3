public class LeapYear {
    public static void main(String[] args) {
        int row = 0;
        int years = 0;
        System.out.println("101年到2100年的闰年为：");
        for (int i = 101; i <2101;i++) {
            if (i % 100 == 0) {
                // 整百年份，被400整除是闰年
                if (i % 400 == 0) {
                    if (row == 10) {
                        System.out.println("");
                        row = 0;
                    }
                    System.out.print(i+" ");
                    years++;
                    row++;
                }
            }
            else {
                // 非整百年份，被4整除是闰年
                if (i % 4 == 0) {
                    if (row == 10) {
                        System.out.println("");
                        row = 0;
                    }
                    System.out.print(i+" ");
                    years++;
                    row++;
                }
            }
        }
        System.out.println("");
        System.out.println("这期间的闰年数为："+years+"年");
    }
}
