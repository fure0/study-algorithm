public class Edge implements Comparable<Edge> {
    public String vertex;
    public int distance;
    
    public Edge(String vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
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