package sample.DB;

public class NodeAPI {
    public static void setup()
    {
        // Create DB
        // Create Node table
        // Create Edges table
    }

    public static void addNode(Node node)
    {
        // add row to node table with node data
        // add rows to edges with all edge relations from node object
    }

    public static void deleteNode(Node node)
    {
        // find node in nodetable using node id and delete it.
        // Go through all edges in edge table and remove them
    }
    public static void deleteNode(int id){}
    public static void deleteNode(String name){}

    public static void replaceNode(Node newNode, Node oldNode)
    {
        //find node using
    }
    public static void replaceNode(Node newNode, int id){}
    public static void replaceNode(Node newNode, String name){}

    public static void updateNode(Node newNode, Node oldNode){replaceNode(newNode, oldNode);}
    public static void updateNode(Node newNode, int id){replaceNode(newNode, id);}
    public static void updateNode(Node newNode, String name){replaceNode(newNode, name);}

    public static Node getNode(int id)
    {
        return new Node();
    }
    public static Node getNode(String name)
    {
        return new Node();
    }
}
