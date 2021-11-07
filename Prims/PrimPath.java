import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {

    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        Edge currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge> priorityQueue;
        
        ArrayList<String> connectedNodes = new ArrayList<String>(); //연결된 노드들
        ArrayList<Edge> mst = new ArrayList<Edge>(); // 결과 정보
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>(); // 노드에 연결된 간선 정보
        
        // 전체 엣지를 반복하며 초기화 시킨다, 중복되지 않게 adjacentEdges 해시맵에 노드 정보를 담는다.
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge>()); //노드와 빈해시 맵 삽입
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge>());
            }
        }
        System.out.println("초기화");
        System.out.println(adjacentEdges);

        // 한번더 반복하며 이번엔 
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            System.out.println("===========================");
            System.out.println("currentEdge : "+currentEdge);
            // 첫번째 것을 예를 들면 간선길이는7, currentEdge.node1 = A, currentEdge.node2 = B 다
            currentEdgeList = adjacentEdges.get(currentEdge.node1); //currentEdgeList 는 현재 A
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node1, currentEdge.node2)); // adjacentEdges.add 를 하고 있는거다
            currentEdgeList = adjacentEdges.get(currentEdge.node2); //currentEdgeList 는 현재 B
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
            System.out.println("currentEdgeList : "+currentEdgeList);
            //첫번째 것을 처리한 결과 {A=[(7, A, B), (5, A, D)] 와 같이 된다
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(adjacentEdges);

        connectedNodes.add(startNode); // String
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>()); // getOrDefault는 연결된 노드가 없을 경우 에러를 방지 하기 위해
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("candidateEdgeList : "+candidateEdgeList);
        priorityQueue = new PriorityQueue<Edge>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        System.out.println("priorityQueue : "+priorityQueue);
        
        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                // 해당 edge 를 mst 에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));
                
                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
        
    }
 
    public static void main(String[] args) {
        // 임의의 정점을 선택, '연결된 노드 집합'에 삽입
        ArrayList<Edge> myedges = new ArrayList<Edge>();
        myedges.add(new Edge(7, "A", "B"));
        myedges.add(new Edge(5, "A", "D"));
        myedges.add(new Edge(8, "B", "C"));
        myedges.add(new Edge(9, "B", "D"));
        myedges.add(new Edge(7, "D", "E"));
        myedges.add(new Edge(5, "C", "E"));
        myedges.add(new Edge(7, "B", "E"));
        myedges.add(new Edge(6, "D", "F"));
        myedges.add(new Edge(8, "E", "F"));
        myedges.add(new Edge(9, "E", "G"));
        myedges.add(new Edge(11, "F", "G"));

        System.out.println("이미지");
        System.out.println(myedges);

        PrimPath pObject = new PrimPath();
        ArrayList<Edge> result = pObject.primFunc("A", myedges);
        System.out.println(result);
    }
}
