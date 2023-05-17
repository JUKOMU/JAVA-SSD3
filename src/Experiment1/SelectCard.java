public class SelectCard {
    public static String getDecor(int num) {
        String[] decor_list = {"黑桃","红桃","梅花","方片",};
        String decor;
        if (num == 13) {
            return decor_list[0];
        }
        else if (num == 26){
            return decor_list[1];
        }
        else if (num == 39) {
            return decor_list[2];
        }
        else if (num == 52) {
            return decor_list[3];
        }
        else {
            decor = decor_list[num / 13];
            return decor;
        }

    }
    public static String getIndex(int num) {
        String[] index_list = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String index;
        index = index_list[(int)num%13 == 0 ? 12 : num%13-1];
        return index;
    }
    public static void main(String[] args) {
        int i;
        i = (int)(1+Math.random()*52);
//        for (int i=1; i<53; i++) {
//            String kind = getDecor(i);
//            String index = getIndex(i);
//            System.out.println("生成的随机数为："+i);
//            System.out.println("抽取的牌为："+kind+index);
//        }
        String kind = getDecor(i);
        String index = getIndex(i);
        System.out.println("生成的随机数为："+i);
        System.out.println("抽取的牌为："+kind+index);

    }
}
