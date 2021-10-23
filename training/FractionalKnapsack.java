import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] objectItem1, Integer[] obejctItem2) {
                return (obejctItem2[1] / obejctItem2[0]) - (objectItem1[1] / objectItem1[0]);
            }
        });
        System.out.println("허용적재량:"+capacity);
        for (int index = 0; index < objectList.length; index++) {
            if( (capacity - (double)objectList[index][0]) > 0 ) {
                capacity -= (double)objectList[index][0];
                totalValue += (double)objectList[index][1];
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1] + ", 남은적재량:" + capacity);                
            } else {
                fraction = capacity / (double)objectList[index][0];
                totalValue += (double)objectList[index][1] * fraction;
                System.out.println("무게:" + objectList[index][0] + ", 가치:" + objectList[index][1] + ", 비율:" + fraction);
                System.out.println("가치:" + (double)objectList[index][1] + " x 비율:" + fraction + " = " + (double)objectList[index][1] * fraction);
                break;
            }
        }
        System.out.println("총 담을 수 있는 가치" + totalValue);
    }
    
    public static void main(String[] args) {
        FractionalKnapsack gObject = new FractionalKnapsack();
        Integer[][] objectList = { {10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5} };
        gObject.knapsackFunc(objectList, 30.0);
    }
}
