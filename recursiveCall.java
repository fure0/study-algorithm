import java.util.ArrayList;

public class recursiveCall {
    
    // 일반적인 재귀형태 1
    public static int factorialFunc(int n) {
        if (n > 1) {
            return n * factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    // 일반적인 재귀형태 2
    public static int factorialFunc2(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialFunc2(n - 1);
        }
    }

    public static int factorialFunc3(ArrayList<Integer> dataList) {
        if (dataList.size() <= 0) {
            return 0;
        } 
         return dataList.get(0) + factorialFunc3(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
    }

    //정수 n이 입력으로 주어졌을 때, n을 합으로 나타낼 수 있는 방법의 수
    public static int factorialFunc4(int data) {
        if (data == 1) {
            return 1;
        } else if (data == 2) {
            return 2;
        } else if (data == 3) {
            return 4;
        }
        return factorialFunc4(data - 1) + factorialFunc4(data - 2) + factorialFunc4(data - 3);
        // 4의 경우 3(4) + 2(2) + 1(1) = 7
        // 5의 경우 4(7) + 3(4) + 2(2) = 13 
    }

    public static void main(String[] args) {

        Integer fact = factorialFunc(3); //2 x 3 = 6
        System.out.println(fact);

        Integer fact2 = factorialFunc2(4); //2 x 3 = 6
        System.out.println(fact2);

        ArrayList<Integer> testData = new ArrayList();
        for (int data = 0; data < 10; data++) {
            testData.add(data);
        }

        Integer fact3 = factorialFunc3(testData);
        System.out.println(fact3);

        Integer fact4 = factorialFunc4(5);
        System.out.println(fact4);

    }

    
}
