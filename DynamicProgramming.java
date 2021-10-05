public class DynamicProgramming {
    
    // 재귀함수 (recursive call)
    // 데이터를 저장하지 않음
    public static int factorialFunc(int data) {
        if (data <= 1) {
            return data;
        }
        return factorialFunc(data - 1) + factorialFunc(data - 2);
    }

    // 동적계획법 (dynamic programming)
    // Memoization 기법 사용 (부분 문제의 해답을 저장해서 재활용하는 최적화 기법으로 사용)
    public static int dynamicFunc(int data) {
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < data + 1; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[data];
    }

    public static void main(String[] args) {
        int fact = factorialFunc(10);
        System.out.println(fact);

        int dynamic = dynamicFunc(10);
        System.out.println(dynamic);
    }

}

/*
fibonacci

if (n == 0) = 0
if (n == 1) = 1
if (n > 1) = n-1 + n-2 

fibonacci(0):0
fibonacci(1):1
fibonacci(2):1
fibonacci(3):2
fibonacci(4):3
fibonacci(5):5
fibonacci(6):8
fibonacci(7):13
fibonacci(8):21
fibonacci(9):34
*/
