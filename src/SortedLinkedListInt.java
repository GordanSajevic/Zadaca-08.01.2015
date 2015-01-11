
public class SortedLinkedListInt {


		private int counter;
		private Node head;
		
		/**
		 * Konstruktor bez parametara
		 */
		
		public SortedLinkedListInt()
		{
			this.head = null;
			this.counter = 0;
		}
		
		/**
		 * Metoda koja dodaje jedan element listi, ali tako da lista uvijek bude sortirana
		 * @param value
		 */
		
		public void add(int value)
		{
			Node newNode = new Node(value);
			if (head == null)
			{
				this.head = newNode;
				counter++;
				return;
			}
			Node previous=null;
			Node current = head;
			while (current != null && current.value < newNode.value)
			{ 
				previous = current;
				current = current.next;
			}
			if (previous == null)
			{
				newNode.next = head;
				head = newNode;
			}
			else
			{
				previous.next = newNode;
				newNode.next = current;
			}
			counter++;
			
		}
		
		/**
		 * Metoda koja dodaje element niza na mjesto odreðeno indeksom
		 * @param value
		 * @param index
		 */
		
		public void addAt(int value, int index)
		{
			Node newNode = new Node(value);
			Node current = head;
			Node previous = null;
			if (index < 0 || index >= counter)
			{
				throw new IndexOutOfBoundsException("Index is not valid!");
			}
			if (index == 0)
			{
				this.head = newNode;
				counter++;
				return;
			}
			while (counter < index)
			{
				previous = current;
				current = current.next;
				counter++;
			}
			newNode.next = current.next;
			counter++;
		}
		
		/**
		 * Metoda koja vraæa string sa svim elementima liste
		 */
		
		public String toString()
		{
			String str = "";
			Node current = head;
			for (int i=0; i<counter; i++)
			{
				str += current.value + " ";
				current = current.next;
			}
			return str;
		}
		
		/**
		 * Metoda koja uklanja element liste odreðen indeksom
		 * @param index
		 */
		
		public void removeAt(int index)
		{
			Node previous = head;
			Node current = head.next;
			if (index < 0 || index >= counter)
			{
				throw new IndexOutOfBoundsException("Index is not valid!");
			}
			if (head.next == null)
			{
				head = null;
				counter--;
				return;
			}
			if (index == 0)
			{
				head = head.next;
				counter--;
				return;
			}
			int i=1;
			while (i < index)
			{
				current = current.next;
				previous = previous.next;
				i++;
			}
			previous.next = current.next;
			current.next = null;
			counter--;
		}
		
		/**
		 * Metoda koja vraæa niz sa èlanovima liste
		 * @return array
		 */
		
		public int[] toArray()
		{
			Node current = head;
			int[] array = new int[counter];
			int i=0;
			while (current.next != null)
			{
				array[i] = current.value;
				current = current.next;
				i++;
			}
			return array;
		}
		
		/**
		 * Metoda koja provjerava da li postoji èlan liste koji sadrži odreðenu vrijednost
		 * @param value
		 * @return boolean
		 */
		
		public boolean contains(int value)
		{
			Node current = head;
			while (current.next != null)
			{
				if (current.value == value)
				{
					return true;
				}
				current = current.next;
			}
			return false;
		}
		
		/**
		 * Metoda koja vraæa dužinu liste
		 * @return
		 */
		
		public int getSize()
		{
			return counter;
		}
		
		private class Node{
			
			private int value;
			private Node next;
			private Node previous;
			
			/**
			 * Konstruktor sa jednim parametrom
			 * @param value
			 */
			
			public Node(int value)
			{
				this.value = value;
				this.next = null;
				this.previous = null;
			}
			
			/**
			 * Konstruktor sa tri parametra
			 * @param value
			 * @param next
			 * @param previous
			 */
			
			public Node(int value, Node next, Node previous)
			{
				this.value = value;
				this.next = next;
				this.previous = previous;
			}
			
		}

}
