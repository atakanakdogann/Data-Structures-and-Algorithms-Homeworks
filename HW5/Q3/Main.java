public class Main{
    public static void main(String[] args) {
        Comparable int1;
        BinarySearchTree binTree = new BinarySearchTree<Integer>(5);
        System.out.println(binTree.add(3));
        binTree.add(4);
        binTree.add(5);
        int1 = binTree.find(4);
        System.out.println(int1);
        binTree.toString();
    }
}