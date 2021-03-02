public class IntDataType {
    public static void main(String[] args) {
        int num = (3*23);
        int secondNum = 12, thirdNum = 6;
        int myTotal = num + secondNum + thirdNum;
        int myLastOne = 1000-myTotal;
        System.out.println(myLastOne);
        int maxNum = Integer.MAX_VALUE;
        int minNum = Integer.MIN_VALUE;
        System.out.println("Minimum Int Value: "+minNum);
        System.out.println("Maximum Int Value: "+maxNum);
    }
    
}
