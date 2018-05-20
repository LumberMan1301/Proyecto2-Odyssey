package Odyssey.Estructuras.Arboles.AVL;

/**
 * Arbol AVL
 * @author HP_15
 * @param <T> 
 */
public class AVLTree<T extends Comparable<T>> {
  public AVLNode<T> root;
  
  public AVLTree() { root = null; }
  

  public AVLNode<T> getRoot()
  {
    return root;
  }
  /**
   * Metodo publico de Contains, manda al metodo privado que contiene 
   * la logica el nodo a buscar junto con la raiz del arbol
   * @param data
   * @return 
   */
  public boolean contains(T data)
  {
    return contains(data, root);
  }
  /**
   * Metodo privado de contains, hace comparaciones con los nodos del arbol,
   * va viendo si no es el nodo, si son sus hijos
   * @param element
   * @param node
   * @return 
   */
  private boolean contains(T element, AVLNode<T> node)
  {
    if (node == null)
      return false;
    if (node.getData().compareTo(element) == 0)
      return true;
    if (node.getData().compareTo(element) > 0)
      return contains(element, node.getLeft());
    if (node.getData().compareTo(element) < 0) {
      return contains(element, node.getRight());
    }
    return false;
  }
  

  public AVLNode<T> getElement(T element)
  {
    return getElement(element, root);
  }
  
  private AVLNode<T> getElement(T element, AVLNode<T> node)
  {
    if (node == null)
      return null;
    if (node.getData().compareTo(element) == 0)
      return node;
    if (node.getData().compareTo(element) < 0) {
      return getElement(element, node.getRight());
    }
    return getElement(element, node.getLeft());
  }
  
/**
 * Calcula el facto de balanceo de los nodos
 * @param node
 * @return 
 */
  private int getBalanceFactor(AVLNode<T> node)
  {
    if (node == null) {
      return -1;
    }
    return node.getBalanceFactor();
  }
  
/**
 * Cuando un nodo es agregado si se desbalancea el arbol depende, hace
 * rotacion izquierda
 * @param node
 * @return 
 */
  private AVLNode<T> leftRotation(AVLNode<T> node)
  {
    AVLNode<T> aux = node.getLeft();
    
    node.setLeft(aux.getRight());
    aux.setRight(node);
    node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
    aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);
    
    return aux;
  }
  /**
 * Cuando un nodo es agregado si se desbalancea el arbol depende, hace
 * rotacion derecha
 * @param node
 * @return 
 */
  private AVLNode<T> rightRotation(AVLNode<T> node)
  {
    AVLNode<T> aux = node.getRight();
    
    node.setRight(aux.getLeft());
    aux.setLeft(node);
    node.setBalanceFactor(Math.max(getBalanceFactor(node.getLeft()), getBalanceFactor(node.getRight())) + 1);
    aux.setBalanceFactor(Math.max(getBalanceFactor(aux.getLeft()), getBalanceFactor(aux.getRight())) + 1);
    
    return aux;
  }
  

/**
 * Rotacion doble izquierda
 * @param node
 * @return 
 */
  private AVLNode<T> doubleLeftRotation(AVLNode<T> node)
  {
    node.setLeft(rightRotation(node.getLeft()));
    AVLNode<T> aux = leftRotation(node);
    return aux;
  }
  

/**
 * Rotacion doble derecha
 * @param node
 * @return 
 */
  private AVLNode<T> doubleRightRotation(AVLNode<T> node)
  {
    node.setRight(leftRotation(node.getRight()));
    AVLNode<T> aux = rightRotation(node);
    return aux;
  }
 /**
  * Metodo para insertar un nodo
  * @param data para indicar el valor del nodo nuevo a agregar
  * pregunta si no hay raiz la crea, si no llama al metodo privado
  */ 
  public void insert(T data)
  {
    AVLNode<T> newNode = new AVLNode(data);
    
    if (root == null) {
      root = newNode;
    } else {
      root = insert(newNode, root);
    }
  }
  /**
   * Logica de insertar nodo, hace comparaciones para ver donde se va ubicando y calcula
   * de una vez el factor de balanceo
   * @param newNode
   * @param subTree
   * @return 
   */
  private AVLNode insert(AVLNode newNode, AVLNode subTree)
  {
    AVLNode<T> newFather = subTree;
    
    if (newNode.getData().compareTo(subTree.getData()) < 0) {
      if (subTree.getLeft() == null) {
        subTree.setLeft(newNode);
      } else {
        subTree.setLeft(insert(newNode, subTree.getLeft()));
        if (getBalanceFactor(subTree.getLeft()) - getBalanceFactor(subTree.getRight()) == 2) {
          if (newNode.getData().compareTo(subTree.getLeft().getData()) < 0) {
            newFather = leftRotation(subTree);
          } else {
            newFather = doubleLeftRotation(subTree);
          }
        }
      }
    } else if (newNode.getData().compareTo(subTree.getData()) > 0) {
      if (subTree.getRight() == null) {
        subTree.setRight(newNode);
      } else {
        subTree.setRight(insert(newNode, subTree.getRight()));
        if (getBalanceFactor(subTree.getRight()) - getBalanceFactor(subTree.getLeft()) == 2) {
          if (newNode.getData().compareTo(subTree.getRight().getData()) > 0) {
            newFather = rightRotation(subTree);
          } else {
            newFather = doubleRightRotation(subTree);
          }
        }
      }
    } else {
      System.out.println("BNode3 duplicado");
    }
    
    if ((subTree.getLeft() == null) && (subTree.getRight() != null)) {
      subTree.setBalanceFactor(subTree.getRight().getBalanceFactor() + 1);
    } else if ((subTree.getRight() == null) && (subTree.getLeft() != null)) {
      subTree.setBalanceFactor(subTree.getLeft().getBalanceFactor() + 1);
    } else {
      subTree.setBalanceFactor(Math.max(getBalanceFactor(subTree.getLeft()), getBalanceFactor(subTree.getRight())) + 1);
    }
    return newFather;
  }
  /**
   * Metodo publico de eliminar, se manda el elemento a eliminar
   * junto con la raiz al metodo privado que contiene la logica
   * @param element 
   */
  public void remove(T element)
  {
    root = remove(element, root);
  }
 /**
  * Metodo privado de eliminar, lo busca, lo elimina y calcula el factor de 
  * balanceo para ver si necesita hacer algun tipo de rotacion
  * @param element
  * @param node
  * @return 
  */ 
  private AVLNode<T> remove(T element, AVLNode<T> node)
  {
    if (node == null) {
      return null;
    }
    if (node.getData().compareTo(element) < 0) {
      node.setRight(remove(element, node.getRight()));
    } else if (node.getData().compareTo(element) > 0) {
      node.setLeft(remove(element, node.getLeft()));
    } else if (node.getLeft() == null) {
      node = node.getRight();
    } else if (node.getRight() == null) {
      node = node.getLeft();
    } else if (getBalanceFactor(node.getLeft()) > getBalanceFactor(node.getRight())) {
      node = rightRotation(node);
      node.setLeft(remove(element, node.getLeft()));
    } else {
      node = leftRotation(node);
      node.setRight(remove(element, node.getRight()));
    }
    if (node != null) {
      node.setBalanceFactor(getBalanceFactor(node.getLeft()) + getBalanceFactor(node.getRight()));
    }
    
    return node;
  }
 /**
  * Manda a llamar al metodo privado print con la raiz
  */ 
  public void print()
  {
    print(root);
  }
/**
 * Metodo privado de print, imprime el arbol, mientras lo va recorriendo
 * @param node 
 */  
  private void print(AVLNode<T> node)
  {
    if (node != null) {
      print(node.getLeft());
      System.out.print(node.getData() + ", ");
      print(node.getRight());
    }
  }
}