
public class Test {

	public static void main(String[] args) {
		SortedLinkedListInt llist = new SortedLinkedListInt();
		for (int i=0; i<5; i++)
		{
			int num = 1 + (int)(Math.random()*(100-1));
			llist.add(num);
		}
		System.out.println("Linked list: ");
		System.out.println(llist.toString());
		llist.removeAt(3);
		System.out.println(llist.toString());
		System.out.println(llist.toString());
		System.out.println(llist.contains(22));
		SortedDynamicArrayInt alist = new SortedDynamicArrayInt();
		for (int i=0; i<5; i++)
		{
			int num = 1 + (int)(Math.random()*(100-1));
			alist.add(num);
		}
		System.out.println("Dynamic array list: ");
		System.out.println(alist.toString());
		alist.removeAt(2);
		System.out.println(alist.toString());
		System.out.println(alist.contains(22));
	}

}
