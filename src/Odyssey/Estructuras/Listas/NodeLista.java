package Odyssey.Estructuras.Listas;

public class NodeLista<T> {
    private NodeLista<T> next;
    private T data;

/**
 * Elemento basico para las listas, contiene el dato y referencia al siguiente y anterior
 * segun lista lo requiera
 * @param dato que contiene el objeto a guardar en la lista
 */ 
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