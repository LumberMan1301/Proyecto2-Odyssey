
/**
package Odyssey.Estructuras.Arboles.Splay;

import java.io.PrintStream;

public class SplayTree<Key extends Comparable<Key>, Value> { public SplayTree<Key, Value>.Node root;
  public SplayTree() {}
  
  private class Node { 
	public Key key;
    public Value value;
    public SplayTree<Key, Value>.Node left;
    public SplayTree<Key, Value>.Node right;
    
    public Node(Key key,Value value) { 
    	this.key = key;
    	this.value = value;
    }
  }
  

  public boolean contains(Key key)
  {
    return getElement(key) != null;
  }
  
  public Value getElement(Key key) {
    root = splay(root, key);
    int cmp = key.compareTo(root.key);
    if (cmp == 0) return root.value;
    return null;
  }
  
  public void insert(Key key, Value value) {
    if (root == null) {
      root = new Node(key, value);
      return;
    }
    
    root = splay(root, key);
    
    int cmp = key.compareTo(root.key);
    
    if (cmp < 0) {
      SplayTree<Key, Value>.Node n = new Node(key, value);
      left = root.left;
      right = root;
      root.left = null;
      root = n;

    }
    else if (cmp > 0) {
      SplayTree<Key, Value>.Node n = new Node(key, value);
      right = root.right;
      left = root;
      root.right = null;
      root = n;
    }
    else
    {
      root.value = value;
    }
  }
  
  public void remove(Key key)
  {
    if (root == null) { return;
    }
    root = splay(root, key);
    
    int cmp = key.compareTo(root.key);
    
    if (cmp == 0) {
      if (root.left == null) {
        root = root.right;
      }
      else {
        SplayTree<Key, Value>.Node x = root.right;
        root = root.left;
        splay(root, key);
        root.right = x;
      }
    }
  }
  

  private SplayTree<Key, Value>.Node splay(SplayTree<Key, Value>.Node h, Key key)
  {
    if (h == null) { return null;
    }
    int cmp1 = key.compareTo(key);
    
    if (cmp1 < 0) {
      if (left == null) {
        return h;
      }
      int cmp2 = key.compareTo(left.key);
      if (cmp2 < 0) {
        left.left = splay(left.left, key);
        h = rotateRight(h);
      }
      else if (cmp2 > 0) {
        left.right = splay(left.right, key);
        if (left.right != null) {
          left = rotateLeft(left);
        }
      }
      if (left == null) return h;
      return rotateRight(h);
    }
    
    if (cmp1 > 0) {
      if (right == null) {
        return h;
      }
      
      int cmp2 = key.compareTo(right.key);
      if (cmp2 < 0) {
        right.left = splay(right.left, key);
        if (right.left != null) {
          right = rotateRight(right);
        }
      } else if (cmp2 > 0) {
        right.right = splay(right.right, key);
        h = rotateLeft(h);
      }
      
      if (right == null) return h;
      return rotateLeft(h);
    }
    
    return h;
  }
  
  public int height()
  {
    return height(root);
  }
  
  private int height(SplayTree<Key, Value>.Node x)
  {
    if (x == null) return -1;
    return 1 + Math.max(height(left), height(right));
  }
  
  public int size()
  {
    return size(root);
  }
  
  public boolean isEmpty() {
    return size() == 0;
  }
  
  private int size(SplayTree<Key, Value>.Node x) {
    if (x == null) return 0;
    return 1 + size(left) + size(right);
  }
  
  private SplayTree<Key, Value>.Node rotateRight(SplayTree<Key, Value>.Node h) {
    SplayTree<Key, Value>.Node x = left;
    left = right;
    right = h;
    return x;
  }
  
  private SplayTree<Key, Value>.Node rotateLeft(SplayTree<Key, Value>.Node h) {
    SplayTree<Key, Value>.Node x = right;
    right = left;
    left = h;
    return x;
  }
  
  public void print() {
    print(root);
  }
  
  private void print(SplayTree<Key, Value>.Node node)
  {
    if (node != null) {
      print(left);
      System.out.print(value + ", ");
      print(right);
    }
  }
}
* **/