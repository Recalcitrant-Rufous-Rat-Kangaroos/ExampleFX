package sample.DB;

public class Node {
    private int id;
    private String name;
    private int xcoord;
    private int ycoord;
    private int[] edges;

    public Node(){};
    public Node(int id, String name, int xcoord, int ycoord, int[] edges) {
        this.id = id;
        this.name = name;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.edges = edges;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getXcoord() {
        return xcoord;
    }
    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }
    public void setYcoord(int ycoord) {
        this.ycoord = ycoord;
    }

    public int[] getEdges() {
        return edges;
    }
    public void setEdges(int[] edges) {
        this.edges = edges;
    }

}
