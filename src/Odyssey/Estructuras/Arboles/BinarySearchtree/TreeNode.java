package Odyssey.Estructuras.Arboles.BinarySearchTree;
/**
 * Clase que contiene el Nodo del ABB
 * @author 13mariano
 * @param <T> 
 */
public class TreeNode<T extends Comparable<T>> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
/**
 * Constructores de la clase
 * @param data 
 */
    public TreeNode(T data) {
        this(data, (TreeNode)null, (TreeNode)null);
    }

    public TreeNode() {
        this((T) null, (TreeNode)null, (TreeNode)null);
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
/**
 * metodo para obtener la informacion del nodo
 * @return 
 */
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
