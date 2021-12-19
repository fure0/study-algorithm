import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

// 최단 경로 구하기(다익스트라)
public class DijkstraPath {

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode; //현재 조작 노드
        Edge adjacentNode; //인접 노드
        ArrayList<Edge> adjacentNodeList; //인접 노드 리스트
        int currentDistance, adjacentDistance, sumDistance;
        String currentNode, adjacentKey;

        HashMap<String, Integer> distances = new HashMap<String, Integer>(); //거리 임시저장 맵
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE); // {A=0, B=2147483647, C=2147483647, D=2147483647, E=2147483647, F=2147483647}
        }
        distances.put(start, 0); // 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장함
        
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(); //우선 순위 큐
        priorityQueue.add(new Edge(start, distances.get(start)));
        
        // 알고리즘 작성
        while (priorityQueue.size() > 0) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("priorityQueue : " + priorityQueue);
            edgeNode = priorityQueue.poll(); //항상 최소 거리를 뽑는다.
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;
            System.out.println("edgeNode : " + edgeNode + " ||| distances.get(currentNode) : " + distances.get(currentNode) + " currentDistance : " + currentDistance);
            if (distances.get(currentNode) < currentDistance) { //현재 까지의 최단 거리보다 지금 노드의 최단 거리가 길면 이후 처리는 하지 않는다.
                continue;
            }
            
            adjacentNodeList = graph.get(currentNode);
            System.out.println("adjacentNodeList : " + adjacentNodeList);
            for (int index = 0; index < adjacentNodeList.size(); index++) { //대상 노드가 인접 노드를 가지고 있다면 인접노드 순회
                adjacentNode = adjacentNodeList.get(index); //인접한 노드
                adjacentKey = adjacentNode.vertex; // 노드
                adjacentDistance = adjacentNode.distance; // 거리
                sumDistance = currentDistance + adjacentDistance;
                System.out.println("\nadjacentNode : " + adjacentNode + ", sum distance : " + sumDistance);
                
                //현재 까지의 최단 거리보다 지금 노드의 최단 거리가 짧으면 최단 거리를 갱신 한다.
                System.out.println("sumDistance: "+sumDistance + " < " + "임시거리: "+distances.get(adjacentKey));
                if (sumDistance < distances.get(adjacentKey)) {
                    distances.put(adjacentKey, sumDistance); //임시저장 맵 갱신
                    System.out.println("updated distances : " + distances);
                    priorityQueue.add(new Edge(adjacentKey, sumDistance));
                    System.out.println("added priorityQueue : " + priorityQueue);
                }
            }
        }
        return distances;
    }
    
    public static void main(String[] args) {
        // 간선의 거리와 노드를 가진 해시 맵 생성
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge("A", 5))));

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


/*
PriorityQueue
일반적인 큐의 구조 FIFO(First In First Out)를 가지면서, 데이터가 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고 그 우선순위가 높은 데이터가 먼저 나가는 자료구조
PriorityQueue를 사용하기 위해선 우선순위 큐에 저장할 객체는 필수적으로 Comparable Interface를 구현해야한다.
Comparable Interface를 구현하면 compareTo method를 override 하게 되고 해당 객체에서 처리할 우선순위 조건을 리턴해주면 PriorityQueue 가 알아서 우선순위가 높은 객체를 추출 해준다.
*/