public class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex;
    
    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }
    
    // System.out.println() 으로 객체 자체 출력시, 
    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }
    
    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}