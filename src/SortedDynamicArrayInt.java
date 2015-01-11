
public class SortedDynamicArrayInt {

	private int[] array;
	private int counter;
	private final int DEFAULT_SIZE = 5;
	
	public SortedDynamicArrayInt()
	{
		this.array = new int[DEFAULT_SIZE];
		this.counter = 0;
	}
	
	public SortedDynamicArrayInt(int size)
	{
		this.array = new int[size];
		this.counter = 0;
	}
	
	private void sortArray()
	{
		for (int i=0; i<counter; i++)
		{
			int index = i;
			while (index > 0 && array[index] < array[index-1])
			{
				int temp = array[index-1];
				array[index-1] = array[index];
				array[index] = temp;
				index--;
			}
				
		}
	}
	
	public void add(int value)
	{
		if (counter == array.length)
		{
			resize();
		}
		array[counter] = value;
		this.counter++;
		sortArray();
	}
	
	public void addAt(int value, int index)
	{
		if (index < 0 || index >= counter)
		{
			throw new IndexOutOfBoundsException("Index is not valid!");
		}
		if (counter == array.length)
		{
			resize();
		}
		this.counter++;
		for (int i=index; i<counter; i++)
		{
			array[i+1] = array[i]; 
		}
		array[index] = value;
		
	}
	
	public void removeAt(int index)
	{
		if (index < 0 || index >= counter)
		{
			throw new IndexOutOfBoundsException("Index is not valid!");
		}
		
		for (int i=index; i<counter; i++)
		{
			array[i-1] = array[i];
		}
		counter--;
	}
	
	public int getAt(int index)
	{
		if (index < 0 || index >= counter)
		{
			throw new IndexOutOfBoundsException("Index is not valid!");
		}
		return array[index];
	}
	
	public int getSize()
	{
		return counter;
	}
	
	public int[] toArray()
	{
		int[] newArray = new int[counter];
		for (int i=0; i<counter; i++)
		{
			newArray[i] = array[i];
		}
		array = newArray;
 		return array;
	}
	
	public String toString()
	{
		String str="";
		for (int i=0; i<counter; i++)
		{
			str += array[i] + " ";
		}
		return str;
	}
	
	public boolean contains(int value)
	{
		for (int i=0; i<counter; i++)
		{
			if (array[i] == value)
			{
				return true;
			}
		}
		return false;
	}
	
	public void resize()
	{
		int[] newArray = new int[array.length*2];
		for (int i=0; i<array.length; i++)
		{
			newArray[i] = array[i];
		}
		array = newArray;
	}
}