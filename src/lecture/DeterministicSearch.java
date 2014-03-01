package lecture;

public class DeterministicSearch 
{
	public void swap(int[] array, int pos1,int pos2)
	{
		int temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;
	}
	public void print(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	public int[] merge(int[] array1,int[] array2)
	{
//		System.out.println("array1");
//		print(array1);
//		System.out.println("array2");
//		print(array2);
		int i=0,j=0,inc=0;
		int[] sortedArray=new int[array1.length+array2.length];
		while(i<array1.length && j<array2.length)
		{
			if(array1[i]<=array2[j])
			{
				sortedArray[inc]=array1[i];
				i++;
				inc++;
			}
			else
			{
				sortedArray[inc]=array2[j];
				j++;
				inc++;
			}
		}
		if(i>=array1.length)
		{
			while(j<array2.length)
			{
				sortedArray[inc]=array2[j];
				j++;
				inc++;
			}
		}
		else
		{
			while(i<array1.length)
			{
                sortedArray[inc]=array1[i];
                i++;
				inc++;
			}
		}
		return sortedArray;
	}
	public int[] copyPartArray(int[] array,int pos1,int pos2)
	{
		int[] partArray=new int[(pos2+1)-pos1];
		int inc=0;
        for(int i=pos1;i<=pos2;i++)
		{
        	partArray[inc]=array[i];
        	inc++;
		}
        return partArray;
	}
	public int[] sort(int[] array)
	{
		int[] sortedArray=new int[array.length];
		int start=0;
		int end=array.length-1;
		if(start<end)
		{
                int mid=(start+end)/2;
                int[] leftarray=copyPartArray(array, start, mid);
                int[] leftsortarray=sort(leftarray);
//                System.out.println("left sorted array");
//                print(leftsortarray);
                int[] rightArray=copyPartArray(array, mid+1, end);
                int[] rightsortArray=sort(rightArray);
                sortedArray=merge(leftsortarray,rightsortArray);
//                System.out.println("sorted array");
//                print(sortedArray);
                return sortedArray;
		}
		else //condition for the value when it return a single value to be returned 
		{	
		sortedArray[0]=array[0];
		return sortedArray;
		}
	}
	public int[] medianOfMedians(int[] array,int split)
	{
		int medianaraylength;
		if(array.length%split>0)
		{
                medianaraylength=(array.length/split)+1;
		}
		else
		{
                medianaraylength=array.length/split;
		}
		int[] medianArray=new int[medianaraylength];
		int inc=0;
		for(int i=0;i<array.length;i=i+split)
		{
//			System.out.println(i);
			int pos1=i;
			int pos2=i+split-1;
			if(i+split-1>=array.length)
			{
				pos2=array.length-1;
			}
			int[] splitarray=copyPartArray(array,pos1,pos2);
			splitarray=sort(splitarray);
			int mid=(splitarray.length-1)/2;
			medianArray[inc]=splitarray[mid];
			inc++;
		}
		return medianArray;
	}
	public int partition(int[] array,int start,int end,int pivotvalue)
	{
		int pivotpos=0;
		for(int q=0;q<array.length;q++)
		{
			if(array[q]==pivotvalue)
			{
				pivotpos=q;
				break;
			}
		}
		int i=start+1,j=start+1;
		swap(array,start,pivotpos);
		int pivot=start;
		while(j<array.length)
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
		swap(array,pivot,i-1);
		return i-1;
	}
	public int dsearch(int[] array,int start,int end, int ithpos)
	{
		int pos=-1;
		if (start<end)
		{
                int split=5;
                int[] medianList=medianOfMedians(array,split);
                int pivotvalue=dsearch(medianList,0,medianList.length-1,(medianList.length-1)/2);
                System.out.println("pivotvalue"+pivotvalue);
                int pivotpos=partition(array,start,end,pivotvalue);
                if (pivotpos==ithpos)
                {
                        return array[pivotpos];
                }
                if (pivotpos>ithpos)
                {
                	pos=dsearch(array, start, pivotpos-1, ithpos);
                }
                if (pivotpos<ithpos)
                {
                	pos=dsearch(array, pivotpos+1, end, ithpos);
                }
		}
		return pos;

	}
	public static void main(String args[])
	{
		int[] array={2,3,8,1,6,2,9,5,12,23,45,25,36,13,11,27,39,28,34,32,31,75};
		DeterministicSearch ds = new DeterministicSearch();
		int pos=3;
		ds.print(ds.sort(array));
		System.out.println(ds.dsearch(array, 0, array.length-1,pos));
//		int searchelement=ds.dsearch(array,0,array.length-1,pos);
//		System.out.println("the "+pos+"th position element is "+searchelement);
	}
}
