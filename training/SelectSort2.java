import java.util.ArrayList;
import java.util.Collections;

public class SelectSort2 {

    ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int stand = 0; stand < dataList.size()-1; stand++) {
            int lowest = stand;
            for (int index = stand + 1; index < dataList.size(); index++) {
                if (dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;

    }
    
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();
        for (int i=0; i<30; i++) {
            testData.add((int)(Math.random()*100));
        }
        SelectSort2 sSort = new SelectSort2();
        ArrayList<Integer> result = sSort.sort(testData);
        System.out.println(result);
    }
}
