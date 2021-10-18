import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
 
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> needVisit = new ArrayList<String>();        
        
        needVisit.add(startNode);
        System.out.println("start needVisit" + " " + needVisit); //needVisit = [A]
        int count = 0;
        
        while (needVisit.size() > 0) {
            count += 1;
            String node = needVisit.remove(needVisit.size() - 1); // BFS와 이 부분만 다름 (큐 -> 스택)
            System.out.println("node" + " " + node); //node 

            if (!visited.contains(node)) { //visited = [];
                visited.add(node); //visited =[A];
                System.out.println("add visited" + " " + visited);
                needVisit.addAll(graph.get(node));
                System.out.println("add needVisit" + " " + needVisit);
            }
        }
        System.out.println("count = " + count);
        return visited;
    }
    
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        System.out.println(graph);

        DFS dObject = new DFS();
        ArrayList<String> result = dObject.dfsFunc(graph, "A");
        System.out.println(result);
    }
}
