package Map;

import java.util.ArrayList;

public class HashMap implements IHashMap {
	private ArrayList<Node> table = new ArrayList<>(0);
	private double loadFactor = 0.78; 
	private int threshold = 12;
	private int Size = 0;
	private int capacity = 16;
	private static final int MAX_lenght = 2000000000;
	private void nulltable(int n) {
		for (int i = 0; i < n; i++) {
			table.add(null);
		}
	}
	
	public HashMap(){
		nulltable(16);
	}
	public HashMap(int sizeTable){
		nulltable(sizeTable);
		capacity = sizeTable;
		threshold = (int) (loadFactor * capacity);
	}
	
	private static int hashFunction(int key) {
		key ^= (key >>> 20) ^ (key >>> 12);
	    return key ^ (key >>> 7) ^ (key >>> 4);
	}
	
	private static int indexFor(int hash, int length) {
		return Math.abs(hash % length);
	}
	
	private Node FindMatchByIndex(int index, int key) {
		Node node = table.get(index);
		while (node != null && node.getKey() != key)
			node = node.getNextNode();
		return node;
	}
	
	private void addNodeToTable(ArrayList<Node> Table, Node newnode, int index) {
		Node node = Table.get(index);
		newnode.setNextNode(node);
		Table.set(index, newnode);		
	}
	
	private void addNewNode(int Hash,int key,long value,int index) {
		Node newnode = new Node(Hash, key,value, null);
		Size++;
		if (table.get(index) == null) {
			table.set(index, newnode);
		}
		else {
			addNodeToTable(table, newnode, index);
		}
	}
	
	private void transferNode(ArrayList<Node> newTable, Node node) {
		while (node != null) {
			Node nextNode = node.getNextNode();
			node.setNextNode(null);
			int Hash = node.getHash();
			int index = indexFor(Hash, capacity);
			addNodeToTable(newTable, node, index);
			node = nextNode;
		}
		
	}
	
	private void transfer(ArrayList<Node> newTable) {
		for (int i = 0; i < table.size(); i++) {
			transferNode(newTable, table.get(i));
		}
	}
	
	private void resize(int newCapacity)
	{
		ArrayList<Node> newTable = new ArrayList<Node>(24);
		for (int i = 0; i < newCapacity; i++) {
			newTable.add(null);
		}
	    capacity = newCapacity;
	    transfer(newTable);
	    table = newTable;
	    threshold = (int)(newCapacity * loadFactor);
	    loadFactor = loadFactor *0.97;
	}

	private void AdaptSize() {
		if (Size >= threshold && capacity != MAX_lenght) {
			if (MAX_lenght/2 > capacity) 
				resize(2*capacity);
			else resize(MAX_lenght);
		}		
	}
	
	//@SuppressWarnings("null")
	public void put(int key, long value) {
		int Hash = hashFunction(key);
		int index = indexFor(Hash, capacity);
		Node node = FindMatchByIndex(index, key);
		if (node != null) node.setValue(value);
		else addNewNode(Hash, key, value, index);
		AdaptSize();
	};
	public long get(int key) {
		int Hash = hashFunction(key);
		int index = indexFor(Hash, capacity);
		Node node = FindMatchByIndex(index, key);
		if (node != null)
			return node.getValue();
		else return 0;
	};
	public int size() {
		return Size;
	}
}

class Node{
	private int hash;
	private int key;
	private long value;
	private Node NextNode;
	public int getHash() {
		return hash;
	}
	public int getKey() {
		return key;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public Node getNextNode() {
		return NextNode;
	}
	public void setNextNode(Node NextNode) {
		this.NextNode = NextNode;
	}
		
	Node(int hash, int key, long value, Node NextNode) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.NextNode = NextNode;
	}
}
