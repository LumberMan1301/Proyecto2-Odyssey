package Odyssey.Estructuras.Arboles.AVL;

public class AVLNode<T extends Comparable<T>>
{
  public T data;
  public int balanceFactor;
  public AVLNode<T> left;
  public AVLNode<T> right;
  
  public AVLNode() {}
  
  public AVLNode(T data)
  {
    this.data = data;
    balanceFactor = 0;
    left = null;
    right = null;
  }
  
  public T getData() {
    return data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public int getBalanceFactor() {
    return balanceFactor;
  }
  
  public void setBalanceFactor(int balanceFactor) {
    this.balanceFactor = balanceFactor;
  }
  
  public AVLNode<T> getLeft() {
    return left;
  }
  
  public void setLeft(AVLNode<T> left) {
    this.left = left;
  }
  
  public AVLNode<T> getRight() {
    return right;
  }
  
  public void setRight(AVLNode<T> right) {
    this.right = right;
  }
}