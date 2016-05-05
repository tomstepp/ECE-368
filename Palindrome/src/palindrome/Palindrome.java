package palindrome;

import java.util.Scanner;

public class Palindrome implements IListCharacter{
		DNode header;
		DNode trailer;

		public Palindrome() {
			header = new DNode(null);
			trailer = new DNode(null);
			header.next = trailer;
			trailer.prev= header;
		}
		
		public boolean isPalindrome(){
			DNode front = header.next;
			DNode back = trailer.prev;
			
			while (front != back && front.prev != back.next){
				if (front.elem != back.elem){
					System.out.println("Not a palindrome.");
					 return false;
				 }
				front = front.next;
				back = back.prev;
			}
			System.out.println("This is a palindrome.");
			return true;
		}
		
		public void addFirst(Character elem) {
			DNode newNode = new DNode(elem);
			newNode.next = header.next;
			newNode.prev= header;
			header.next.prev= newNode;
			header.next = newNode;
		}

		
		public void addLast(Character elem) {
			DNode newNode = new DNode(elem);
			newNode.next = trailer;
			newNode.prev= trailer.prev;
			trailer.prev.next = newNode;
			trailer.prev= newNode;
		}

		
		public void insertAt(int index, Character elem) {
			DNode newNode = new DNode(elem);
			int i = 0;
			for (DNode nodeIt = header; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (i == index) {
					newNode.next = nodeIt.next;
					newNode.prev= nodeIt;
					nodeIt.next.prev= newNode;
					nodeIt.next = newNode;
					return;
				}
				++i;
			}
			System.out.println("DList: Insertion out of bounds");
		}


		
		public boolean isEmpty() {
			return (header.next == trailer);
		}

		
		public boolean contains(Character elem) {
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (nodeIt.elem.equals(elem)) {
					return true;
				}
			}
			return false;
		}

		
		public int getIndexOf(Character elem) {
			int index = 0;
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (nodeIt.elem.equals(elem)) {
					return index;
				}
				++index;
			}
			return -1;
		}

		
		public void removeFirst() {
			if (isEmpty()) {
				System.out.println("DList: List is empty");
				return;
			}
			header.next = header.next.next;
			header.next.prev= header;
		}

		
		public void removeLast() {
			if (isEmpty()) {
				System.out.println("DList: List is empty");
				return;
			}
			trailer.prev= trailer.prev.prev;
			trailer.prev.next = trailer;
		}

		
		public void removeAll(Character elem) {
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (nodeIt.elem.equals(elem)) {
					nodeIt.prev.next = nodeIt.next;
					nodeIt.next.prev= nodeIt.prev;
				}
			}
		}

		
		
		public void removeAt(int index) {
			int i = 0;
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (i == index) {
					nodeIt.prev.next = nodeIt.next;
					nodeIt.next.prev= nodeIt.prev;
					return;
				}
				++i;
			}
			System.out.println("DList: Deletion out of bounds");
		}

		
		public int getSize() {
			int size = 0;
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				++size;
			}
			return size;
		}

		
		public Character getFirst() {
			if (isEmpty()) {
				System.out.println("DList: List is empty");
				return null;
			}
			return header.next.elem;
		}

		public Character getLast() {
			if (isEmpty()) {
				System.out.println("DList: List is empty");
				return null;
			}
			return trailer.prev.elem;
		}

		
		public Character getAt(int index) {
			int i = 0;
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (i == index) {
					return nodeIt.elem;
				}
				++i;
			}
			System.out.println("DList: Get out of bounds");
			return null;
		}

		public String toString() {
			String result = null;
			for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
				if (result == null) {
					result = String.valueOf(nodeIt.elem);
				} else {
					result += "," + String.valueOf(nodeIt.elem);
				}
			}
			return result == null ? "empty" : result;
		}

		

		public static void main(String[] args) {
			// incomplete test
			Scanner input;
			String in;
				
				input = new Scanner(System.in);
				System.out.println("Enter a string: ");
				in = input.nextLine();
				input.close();
				System.out.println("Testing for palindrome...");
				
				Palindrome list = new Palindrome();
				
				int i;
				for (i=0;i<in.length();i++){
					list.addLast(in.charAt(i));
				}

				list.isPalindrome();

				System.out.println("");
		}
	}
