import java.util.ArrayList;

public class SequentialSearch {

    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }
 
    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            testData.add((int)(Math.random() * 100));
        }

        SequentialSearch sSearch = new SequentialSearch();
        int result = sSearch.searchFunc(testData, 12);

        System.out.println(testData + " / " + result);

    }
}
