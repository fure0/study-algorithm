import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class KruskalPath {
    HashMap<String, String> parent = new HashMap<String, String>();
    HashMap<String, Integer> rank = new HashMap<String, Integer>();
    
    public String find(String node) {
        // path compresion 기법
        if (this.parent.get(node) != node) { // 현재 parent에 있는 노드가 루트 노드가 아니면
            this.parent.put(node, this.find(this.parent.get(node))); //부모노드를 전부 체크해서 결과적으로는 루트노드로 연결을 하게한 후에
        }
        return this.parent.get(node); //결과적으로 해당 셋에 루트노드를 리턴하게 함
    }
    
    public void union(String nodeV, String nodeU) {
        String root1 = this.find(nodeV); // nodeV의 루트 노드를 가져온다
        String root2 = this.find(nodeU); // nodeU의 루트 노드를 가져온다
        
        // union-by-rank 기법
        if (this.rank.get(root1) > this.rank.get(root2)) { //root1의 랭크가 더 높다면,
            this.parent.put(root2, root1); //root2의 부모노드를 root1로 세팅한다
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) { //랭크가 동일하면 root2의 랭크를 1더 높힌다
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }
    
    // 초기화: 전체 노드를 하나씩 받아서 자신을 루트 노드로 만들고 랭크를 0으로 만든다.
    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }
    
    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<Edge>();
        Edge currentEdge;
        
        // 1. 초기화
        for (int index = 0; index < vertices.size(); index++) {
            this.makeSet(vertices.get(index));
        }
        
        // 2. 간선 weight 기반 sorting
        Collections.sort(edges);
        
        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index); //탐욕 알고리즘 기반으로 소트한 후에
            if (this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)) {
                this.union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        
        return mst;
    }

    public static void main(String[] args) {

        ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        KruskalPath kObject = new KruskalPath();
        ArrayList<Edge> result = kObject.kruskalFunc(vertices, edges);
        System.out.println(result);
    }
}