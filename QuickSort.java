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
        
        for (int index = 1; index < dataList.size(); index++) { //index 1부터인거 주의
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
        mergedArr.addAll(Arrays.asList(pivot)); //array를 arrayList로 변환 
        mergedArr.addAll(this.sort(rightArr));

        System.out.println("mergedArr " + mergedArr);

        return mergedArr;
    }
    

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 6; index++) {
            testData.add((int)(Math.random() * 100));
        }
        System.out.println("start array " + testData);

        QuickSort qSort = new QuickSort();
        ArrayList<Integer> result = qSort.sort(testData);
        System.out.println(result);
    }
}

/*
1. 배열 생성
2. sort 함수 정의
2-1. 배열기준 get(0)를 pivot으로 둔뒤에 작은수를 leftArr, 큰수를 rightArr로 분류
2-2. 배열 내부 값이 모두 나둬 질 때 까지 재귀호출 한다. dataList.size() <= 1
*/