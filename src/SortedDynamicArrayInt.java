
public class SortedDynamicArrayInt {

	private int[] array;
	private int counter;
	private final int DEFAULT_SIZE = 5;
	
	/**
	 * Konstruktor bez parametara
	 */
	
	public SortedDynamicArrayInt()
	{
		this.array = new int[DEFAULT_SIZE];
		this.counter = 0;
	}
	
	/**
	 * Konstruktor sa jednim parametrom
	 * @param size
	 */
	
	public SortedDynamicArrayInt(int size)
	{
		this.array = new int[size];
		this.counter = 0;
	}
	
	/**
	 * Metoda koja sortira èlanove niza (insertion sort)
	 */
	
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
	
	/**
	 * Metoda koja dodaje èlanove niza
	 * @param value
	 */
	
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
	
	/**
	 * Metoda koja dodaje èlanove niza na mjesto odreðeno indeksom
	 * @param value
	 * @param index
	 */
	
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
	
	/**
	 * Metoda koja uklanja jedan element niza odreðen indeksom
	 * @param index
	 */
	
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
	
	/**
	 * Metoda koja vraæa jedan element niza odreðen indeksom
	 * @param index
	 * @return
	 */
	
	public int getAt(int index)
	{
		if (index < 0 || index >= counter)
		{
			throw new IndexOutOfBoundsException("Index is not valid!");
		}
		return array[index];
	}
	
	/**
	 * Metoda koja vraæa velièinu niza, tj. broj popunjenih mjesta u nizu
	 * @return
	 */
	
	public int getSize()
	{
		return counter;
	}
	
	/**
	 * Metoda koja vraæa niz sa taèno onoliko elemenata koliko smo unijeli
	 * @return array
	 */
	
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
	
	/**
	 * Metoda koja vraæa string sa svim èlanovima niza
	 */
	
	public String toString()
	{
		String str="";
		for (int i=0; i<counter; i++)
		{
			str += array[i] + " ";
		}
		return str;
	}
	
	/**
	 * Metoda koja provjerava da li postoji èlan niza koji ima odreðenu vrijednost
	 * @param value
	 * @return boolean
	 */
	
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
	
	/**
	 * Metoda koja poveæava dužinu niza dva puta, kada je niz popunjen 
	 */
	
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