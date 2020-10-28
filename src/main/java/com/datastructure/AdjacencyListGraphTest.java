package com.datastructure;

import java.util.*;

/**
 * Find shortest path from starting vertex (say A) to all other vertices (B,C,D,E) using Greedy method.
 * The vertex weight must be positive number.
 */
public class AdjacencyListGraphTest {

    Graph<Vertex> graph = new Graph<Vertex>();

    public AdjacencyListGraphTest() {
        initGraph();

    }

    private void initGraph() {



        //A to D 1
        graph.addVertexEdges(new Vertex("A"), new Vertex("D"));
        //A to B 6
        graph.addVertexEdges(new Vertex("A"), new Vertex("B"));
        //B to D 2
        graph.addVertexEdges(new Vertex("B"), new Vertex("D"));
        //B to E 2
        graph.addVertexEdges(new Vertex("B"), new Vertex("E"));
        //B to C 1
        graph.addVertexEdges(new Vertex("B"), new Vertex("C"));
        //C to E 6
        graph.addVertexEdges(new Vertex("C"), new Vertex("E"));
        //D to E 6
        graph.addVertexEdges(new Vertex("D"), new Vertex("E"));


    }


    public static void main(String args[]){

        AdjacencyListGraphTest main = new AdjacencyListGraphTest();
        System.out.println(main.graph.toString());








    }

    private static class Vertex {

        private String name = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Vertex(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(name, vertex.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Vertex= " + name;

        }
    }

}
