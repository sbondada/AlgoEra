package arrays;

public class RandomizedSearch 
{
    // general swap functionality on a default array
	public void swap(int[] array,int pos1,int pos2)
	{
		int temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;
	}
    //same partition function as quick sort
	public int partition(int[] array,int start,int end)
	{
		int i=start+1,j=start+1;
		int pivot=start;
		while(j<=end)
		{
			if(array[j]<array[pivot])
			{
				swap(array, j, i);
				i++;
				j++;
			}
			else
			{
				j++;
			}
		}
		swap(array, i-1, pivot);
		return i-1;
	}
    //search function accepts array, start and end of the array with the ith order statistic needed
	public int search(int[] array,int start,int end,int ith)
	{
		int pos=-1;
        //checking if the ith order statistic is less than the size of array and return -1 if it is
		if(ith>array.length)
		{
			return -1;
		}
        //the condition to break the  recursion is exactly similar to the quick sort
		if(start<end)
		{
            //applying the partition method to find the pivots original position in sorted array
			int ithpos=partition(array, start, end);
            //checking if the obtained position from pivot is what the ith order we wanted
			if(ithpos==ith-1)
			{
                //if so then return the value
				return ithpos;
			}
            //if the ith order we wanted is more then recursing on 2nd part
			if(ithpos<ith-1)
			{
				pos=search(array, ithpos+1, end, ith);
			}
            //if less recursing on the first part
			else
			{
				pos=search(array,start,ithpos-1,ith);
			}	
		}
        //returning the value of the ith order statistic if found or else returning -1
		return pos;
	}
	public static void main(String args[])
	{
		int[] array={2,5,6,7,2,8,1,0,4};
		RandomizedSearch rs=new RandomizedSearch();
		int ith=6;
		int element=rs.search(array, 0, array.length-1,ith);
		if (element==-1)
		{
                System.out.println("improper ith order statistic entered");
		}
		else
		{
                System.out.println("the "+ith+"th no is "+element);
		}

	}
}
