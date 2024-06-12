package Theme4_2;

public class Node {
    int parent;
    int rank;
    public Node(int newparent, int newrank) {
        parent = newparent;
        rank = newrank;
    }
    public int getParent() {return parent;}
    public int getRank() {return rank;}
    public void setParent(int newparent) {parent = newparent;}
    public void setRank(int newrank) {rank = newrank;}
}
