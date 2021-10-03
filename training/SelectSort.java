import java.util.ArrayList;
import java.util.Collections;

public class SelectSort {
    
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;
        for (int i=0; i<dataList.size()-1; i++) {
            lowest = i;
            for (int j=i+1; j<dataList.size(); j++) {
                if (dataList.get(lowest) > dataList.get(j)) {
                    lowest = j;
                }
            }
            Collections.swap(dataList, lowest, i);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i=0; i<testData.size(); i++) {
            testData.add((int)(Math.random() * 100));
        }
        SelectSort sSort = new SelectSort();
        sSort.sort(testData);

        for (int i=0; i<testData.size(); i++) {
            System.out.println(testData.get(i));
        }
    }
}
