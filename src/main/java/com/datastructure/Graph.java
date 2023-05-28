package com.datastructure;


import java.util.*;

public class Graph<T> {

    Map<T, List<T>> vertices = new HashMap<>();

    public void addVertex(T t) {
        vertices.put(t, new ArrayList<T>());
    }

    public void addVertexEdges(T source, T destination){
        if(!vertices.containsKey(source)){
            addVertex(source);
        }

        if (!vertices.containsKey(destination)){
            addVertex(destination);
        }

        vertices.get(source).add(destination);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("");

        for(T t : vertices.keySet()){
            sb.append(t.toString()).append(" : ");

            for (T w : vertices.get(t)){
                sb.append(w.toString()).append(",");
            }
            sb.append("\n");

        }
        return sb.toString();
    }

    public Map<T, List<T>> getVertices() {
        return vertices;
    }

    public void setVertices(Map<T, List<T>> vertices) {
        this.vertices = vertices;
    }

}
