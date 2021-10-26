import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

// 최단 경로 구하기(다익스트라)
public class DijkstraPath {

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE); // {A=0, B=2147483647, C=2147483647, D=2147483647, E=2147483647, F=2147483647}
        }
        distances.put(start, 0); // 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장함
        
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(distances.get(start), start));
        
        // 알고리즘 작성
        System.out.println("priorityQueue : " + priorityQueue);
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;
            System.out.println("----------------------------------------------------------------");
            System.out.println("edgeNode : " + edgeNode + " ||| distances.get(currentNode) : " + distances.get(currentNode) + " currentDistance : " + currentDistance);
            if (distances.get(currentNode) < currentDistance) {
                continue;
            }
            
            nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index); //인접한 노드
                adjacent = adjacentNode.vertex; // 노드
                weight = adjacentNode.distance; // 거리
                distance = currentDistance + weight;
                System.out.println("adjacentNode : " + adjacentNode + " To distance : " + distance);
                
                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }
    
    public static void main(String[] args) {
        // 간선의 거리와 노드를 가진 해시 맵 생성
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        for (String key : graph.keySet()) {
            System.out.println(key);
            System.out.println(graph.get(key));    
        }

        DijkstraPath dObject = new DijkstraPath();
        HashMap<String, Integer> result = dObject.dijkstraFunc(graph, "A");

        System.out.println("--------------------------------------------");
        System.out.println(result);


    }
}
