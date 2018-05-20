package Odyssey.Estructuras.Arboles.BTree;
/**
 * Clase del Nodo perteneciente al arbol B
 * 
 * @author 13mariano
 */
public class BNode
{
	static int t;  //variable to determine order of tree
	int count; // number of keys in node
	int key[];  // array of key values
	BNode child[]; //array of references
	boolean leaf; //is node a leaf or not
	BNode parent;  //parent of current node.

/**
 * constructor de la clase
 */
	public BNode()
	{}

/**
 * metodo para inicializar un nodo
 * @param t
 * @param parent 
 */
	public BNode(int t, BNode parent)
	{
		this.t = t;  //assign size
		this.parent = parent; //assign parent
		key = new int[2*t - 1];  // array of proper size
		child = new BNode[2*t]; // array of refs proper size
		leaf = true; // everynode is leaf at first;
		count = 0; //until we add keys later.
	}
/**
 * metodo para obtener el valor de una llave
 * @param index
 * @return 
 */
	public int getValue(int index)
	{
		return key[index];
	}

/**
 * metodo para retornar un hijo
 * @param index
 * @return 
 */

	public BNode getChild(int index)
	{
		return child[index];
	}


}
