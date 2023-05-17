import java.util.Scanner;

public class Calendar {
    public static boolean LeapYear(int year) {
        if (year % 100 == 0) {
            // 整百年份，被400整除是闰年
            if (year % 400 == 0) {
                return true;
            }
        }
        else {
            // 非整百年份，被4整除是闰年
            if (year % 4 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void printDate(int year,int day) {
        String[] month_list = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] day_list = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] month_days = {31,28,31,30,31,30,31,31,30,31,30,31};

        // 全历遍，满足条件输出
        day = day - 1;
        if (LeapYear(year)) {
            month_days[1] = 29;
            for (int i = 0; i<12;i++) {
                for (int o = 0; o<month_days[i];o++) {
                    if (o == 0) {
                        System.out.print(month_list[i]+" "+1+","+year+" is ");
                        System.out.println(day_list[day]);
                    }
                    day ++;
                    if (day == 7) {
                        day = 0;
                    }
                }
            }
        }
        else {
            for (int i = 0; i<12;i++) {
                for (int o = 0; o<month_days[i];o++) {
                    if (o == 0) {
                        System.out.print(month_list[i]+" "+1+","+year+" is ");
                        System.out.println(day_list[day]);
                    }
                    day ++;
                    if (day == 7) {
                        day = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int year;
        int day;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份：");
        year = scanner.nextInt();
        System.out.print("请输入这一年第一天的星期：");
        day = scanner.nextInt();
        printDate(year, day);
    }
}
