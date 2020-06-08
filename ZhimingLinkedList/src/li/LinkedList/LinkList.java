package li.LinkedList;

import java.util.Scanner;

public class LinkList {

	private Node head;
	private int size;
	
	public LinkList() {

		this.head = null;
		this.size = 0;
	}
	
	public LinkList(Node head) {
		this.head = head;
		this.size = 1;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void add() {
		
		Scanner kb = new Scanner(System.in);
		String name = "";
		Node first = this.getHead();
		

		System.out.println("What is the name of the new shareholder? (First Name, Last Name)");
		name = kb.nextLine() + " ";//Added space because the names in the file end with space
		
		Node append_node = new Node(name);

		insert(append_node, first);
	}
	
	public void insert(Node new_node, Node first) {
		
		

		String name = new_node.getValue();
		Node temp = new Node("", null);
		

		new_node.setValue(flippedName(name));
		
		if(first == null) {
			this.head = new_node;
			size++;
			return;
		}
		
		while(first.getValue().compareTo(new_node.getValue()) < 0 && first.getNext() != null) {
			first = first.getNext();
		}
		
		
		if(first.getNext() == null) {
			first.setNext(new_node);
			size++;
		}else {
			temp.setValue(first.getValue());
			temp.setNext(first.getNext());
			first.setValue(new_node.getValue());

			
			new_node.setValue(temp.getValue());
			new_node.setNext(temp.getNext());
			
			first.setNext(new_node);

			size++;	
		}

	}
	
	public void delete (String name, Node first) {
		
		name = name + " ";//Added space to match with the format
		
		String arrangedName = flippedName(name);
		
		//If the list is empty
		if(first == null) {
			System.out.print("The Linked List is empty");
			return;
		}
		
		//If the first node of the list is the desired node
		if(first.getValue() == arrangedName) {
			first = first.getNext();
			size--;
			return;
		}
		
		while(first.getNext() != null) {
			if(first.getNext().getValue().equals(arrangedName)) {
				first.setNext(first.getNext().getNext());
				size--;
			}
			
			first = first.getNext();
		}
		
		
	}
	
	public String flippedName(String name) {
		
		String firstname = "";
		String lastname = "";
		
		firstname = name.substring(0, name.indexOf(" "));
		lastname = name.substring(name.indexOf(" "));
		name = lastname + firstname;
		
		return name;
	}
	
}
