/**
package Odyssey.Estructuras.Arboles.BTree;

public class BTree<Key extends Comparable<Key>, Value>
{
  public static final int m = 4;
  public Node root;
  public int height;
  public int n;

  private static final class Node
  {
    public int m;
    public BTree.Entry[] children = new BTree.Entry[4];

    public Node(int k) { m = k; }
  }

  private static class Entry
  {
    public Comparable key;
    public final Object val;
    public BTree.Node next;

    public Entry(Comparable key, Object val, BTree.Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  public BTree()
  {
    root = new Node(0);
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }

  public int size()
  {
    return n;
  }

  public int height()
  {
    return height;
  }


  public Value getElement(Key key)
  {
    if (key == null) throw new IllegalArgumentException("Insertar Elemento");
    return search(root, key, height);
  }
  
  private Value search(Node x, Key key, int ht) {
    Entry[] children = children;

    if (ht == 0) {
      for (int j = 0; j < m; j++) {
        if (eq(key, key)) { return val;
        }

      }
    } else {
      for (int j = 0; j < m; j++) {
        if ((j + 1 == m) || (less(key, key)))
          return search(next, key, ht - 1);
      }
    }
    return null;
  }


  public void insert(Key key, Value val)
  {
    if (key == null) throw new IllegalArgumentException("argument key to put() is null");
    Node u = insert(root, key, val, height);
    n += 1;
    if (u == null) { return;
    }
    Node t = new Node(2);
    children[0] = new Entry(root.children[0].key, null, root);
    children[1] = new Entry(children[0].key, null, u);
    root = t;
    height += 1;
  }

  private Node insert(Node h, Key key, Value val, int ht)
  {
    Entry t = new Entry(key, val, null);
    int j;
    if (ht == 0) {
      for (int j = 0; j < m; j++) {
        if (less(key, children[j].key)) {
          break;
        }
      }
    } else {
      for (j = 0; j < m; j++) {
        if ((j + 1 == m) || (less(key, children[(j + 1)].key))) {
          Node u = insert(children[(j++)].next, key, val, ht - 1);
          if (u == null) return null;
          key = children[0].key;
          next = u;
          break;
        }
      }
    }

    for (int i = m; i > j; i--)
      children[i] = children[(i - 1)];
    children[j] = t;
    m += 1;
    if (m < 4) return null;
    return split(h);
  }

  private Node split(Node h) {
    Node t = new Node(2);
    m = 2;
    for (int j = 0; j < 2; j++)
      children[j] = children[(2 + j)];
    return t;
  }

  public String getStringToPrint() {
    return toString(root, height, "") + "\n";
  }

  private String toString(Node h, int ht, String indent) {
    StringBuilder s = new StringBuilder();
    Entry[] children = children;

    if (ht == 0) {
      for (int j = 0; j < m; j++) {
        s.append(indent + key + " " + val + "\n");
      }

    } else {
      for (int j = 0; j < m; j++) {
        if (j > 0) s.append(indent + "(" + key + ")\n");
        s.append(toString(next, ht - 1, indent + "     "));
      }
    }
    return s.toString();
  }

  private boolean less(Comparable k1, Comparable k2)
  {
    return k1.compareTo(k2) < 0;
  }

  private boolean eq(Comparable k1, Comparable k2) {
    return k1.compareTo(k2) == 0;
  }
 
}
* **/