import java.util.ArrayList;
import java.util.List;

public class MyGraph implements DynamicGraph {
    
    
    static int graphSize = 0;
    
    List<Vertex> vList = new List<Vertex>();
    ArrayList<ArrayList<Integer>> adjacencyArrayList = new ArrayList<ArrayList<Integer>>();
    
    
    public Vertex newVertex (String label, double weight){
        graphSize++;
        return new Vertex(graphSize,label,weight);
    }

    public void addVertex (Vertex new_vertex){
        vList.add(new_vertex);
    }

    public void addEdge (int vertexID1, int vertexID2, double weight){
        new Edge(vertexID1, vertexID2, weight);
        adjacencyArrayList.get(vertexID1).add(vertexID2);
        adjacencyArrayList.get(vertexID2).add(vertexID1);
    }

    public void removeEdge (int vertexID1, int vertexID2){
        adjacencyArrayList.get(vertexID1).remove(vertexID2);
        adjacencyArrayList.get(vertexID2).remove(vertexID1);
    }

    public void removeVertex (int vertexID){
        for(int i = 0; i < vList.size();i++){
            if(vList.get(i).getID() == vertexID){
                vList.get(i).remove();
            }
        }
    }

    public void removeVertex (String label){
        for(int i = 0; i < vList.size();i++){
            if(vList.get(i).getLabel().equalsIgnoreCase(label)){
                vList.get(i).remove();
            }
        }
    }

    public void filterVertices (String key, String filter){
        return;
    }

    public void exportMatrix(){
        for (int i = 0; i < adjacencyArrayList.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                               + i);
            System.out.print("head");
            for (int j = 0; j < adjacencyArrayList.get(i).size(); j++) {
                System.out.print(" -> "
                                 + adjacencyArrayList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void printGraph(){
        toString();
    }


    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < vList.size();i++){
            sb.append("[");
            sb.append(vList.get(i).getLabel());
            sb.append(", ");
            sb.append(Integer.toString(vList.get(i).getID()));
            sb.append("]\n");
        }
        return sb.toString();
    }
}


