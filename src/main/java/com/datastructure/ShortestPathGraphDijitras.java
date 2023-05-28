package com.datastructure;


import java.util.*;

/**
 * Not completed.  Need to review dijiktras algorithm
 */
public class ShortestPathGraphDijitras {

    WeightedGraph graph = new WeightedGraph();

    public static void main(String args[]){

        ShortestPathGraphDijitras test = new ShortestPathGraphDijitras();
        String start = "A";
        test.load();

        test.graph.print();

        test.prepareShortestPath(start);


    }

    private void prepareShortestPath(String start) {

        List<String> visited = new ArrayList<>(5);
        List<String> unvisited = new ArrayList<>(5);

        Map<String, List<VertexEdge>> myvertices = graph.getVertices();


        for (String s : myvertices.keySet()){
            unvisited.add(s);
        }

        System.out.println("unvisited = " + unvisited);
        System.out.println("start vertex = " + start);




        }

    private void load() {

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 1);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 2);
        graph.addEdge("B", "E", 2);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 1);
        graph.addEdge("E", "", 0);




    }


    private class WeightedGraph{

        Map<String, List<VertexEdge>> vertices = new HashMap<>();


        public void addEdge(String source, String destination, int weight){

            if (!vertices.keySet().contains(source)){
                vertices.put(source, new LinkedList<VertexEdge>());
            }
            VertexEdge edge = new VertexEdge(source, destination, weight);
            vertices.get(source).add(edge);
        }

        public void print(){
            StringBuilder sb = new StringBuilder("");

            for (String s : vertices.keySet()){
                sb.append(s).append( "->" );

                for (VertexEdge edge : vertices.get(s)){
                    sb.append("[").append(edge.getDestination()).append(", ").append(edge.getWeight()).append("]");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
        }




        public Map<String, List<VertexEdge>> getVertices() {
            return vertices;
        }

        public void setVertices(Map<String, List<VertexEdge>> vertices) {
            this.vertices = vertices;
        }
    }


    private class VertexEdge {
        String source;
        String destination;
        int weight;

        public VertexEdge(String source, String destination, int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;

        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
