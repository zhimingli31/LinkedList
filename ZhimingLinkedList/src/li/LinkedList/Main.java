package li.LinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		
		LinkList list = new LinkList();
		
		list = read_file();
		
		
		list.add();
		list.add();
		list.add();
		
		list.delete("William Paca", list.getHead());
		list.delete("William Whipple", list.getHead());
		
		print_file(list);

	}
	
	public static LinkList read_file() throws FileNotFoundException {
		LinkList list = new LinkList();
		Node node;
		String line = "";

		
		File file = new File("share.dat");
		Scanner scan = new Scanner(file);
		
		
		while(scan.hasNext()) {
			line = scan.nextLine();
			node = new Node(line);
			list.insert(node, list.getHead());
		}
		
		return list;
	}
	
	public static void print_file(LinkList list) {
		Node first = list.getHead();
		for(int i = 0; i < list.getSize(); i++) {
			
			System.out.println(first.getValue());
			
			if(first.getNext() != null) {
				first = first.getNext();
			}
			
		}
	}

}
