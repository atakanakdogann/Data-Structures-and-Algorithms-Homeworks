public class Vertex{
    String label;
    int id;
    double weight;
    int value = 12345;

    public Vertex(){
        id = value;
        weight = 1.0;
    }

    public Vertex(int id, String label, double weight){
        this.id = id;
        this.label = label;
        this.weight = weight;
    }

    public int getID(){
        return id;
    }

    public String getLabel(){
        return label;
    }

    public double getWeight(){
        return weight;
    }
}
