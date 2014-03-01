package lecture;

public class QuickSort 
{
	public void swap(int[] array,int pos1,int pos2)
	{
		//a simple value based sorting
		int temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;
	}
	public int partition(int[] array,int start,int end)
	{
//        System.out.println("partition");
//        System.out.println(start+" "+end);
		//here i represent the pointer to the element which is just after the elements less than the pivot
		int i=start+1,j=start+1;
		//choosing the starting element as the pivot
		int pivot=start;
		//loop until we move through the list from start to end 
		while(j<=end)
		{
			if(array[j]<array[pivot])
			{
				swap(array,i,j);
				i++;
				j++;
			}
			else
			{
				j++;
			}
		}
		//swap the pivot with the last least element than pivot in pos
		swap(array,pivot,i-1);
		return i-1;
	}
	public void sort(int[] array, int start, int end)
	{
		// the condition is so because we need to allow the array of size two for partition
		//and in return we may get the pos as the same as start which leads to the next statement to form a condition
		// where start is greater than end
		if(start<end)
        {
			int pos=partition(array,start,end);
			System.out.println(start+" "+end+" "+pos);
			sort(array, start, pos-1);
			sort(array, pos+1, end);
        }
	}
	public static void main(String args[])
	{
		int[] array={2,4,1,3,5,6,3,6,43,22,5};
		QuickSort qs = new QuickSort();
		qs.sort(array, 0, array.length-1);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
	}
}
