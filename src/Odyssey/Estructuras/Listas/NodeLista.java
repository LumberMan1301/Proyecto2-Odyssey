package Odyssey.Estructuras.Listas;

public class NodeLista<T> {
	  private NodeLista<T> next;
	  private T data;
	 
	  
	  public NodeLista(T dato) {
	    data = dato;
	    next = null;
	  }
	  
	  public T getData() {
	    return data;
	  }
	  
	  public void setData(T data) {
	    this.data = data;
	  }
	  
	  public NodeLista<T> getNext() {
	    return next;
	  }
	  
	  public void setNext(NodeLista<T> next) {
	    this.next = next;
	  }
	  
	  
	}