import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);
        
        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();        
        
        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot) {
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }

        System.out.println("===========");
        System.out.println("leftArr " + leftArr);
        System.out.println("pivot " + pivot);
        System.out.println("rightArr " + rightArr);  

        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        mergedArr.addAll(this.sort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(this.sort(rightArr));

        return mergedArr;
    }
    

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 10; index++) {
            testData.add((int)(Math.random() * 100));
        }

        QuickSort qSort = new QuickSort();
        ArrayList<Integer> result = qSort.sort(testData);
        System.out.println(result);
    }
}
