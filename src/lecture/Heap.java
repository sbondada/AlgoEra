package lecture;

import java.util.ArrayList;

// points to remember.
//since we have implemented heap in an arraylist so swapping values are not possible unless we remove and add the new value
// in the list. so we need to keep in mind that the when you remove the index value changes so implement the heap remembering 
//that fact.
// the only efficient way to implement heap is like this if we try to construct a tree then searching the spot to insert is going
// to take o(n) time.
public class Heap 
{
	public ArrayList<Integer> heapstruct;
	
	public Heap(int val)
	{
		this.heapstruct=new ArrayList<>();
		this.heapstruct.add(val);
	}
	
	public void insertNode(int val)
	{
		this.heapstruct.add(val);
		int index=this.heapstruct.size()-1;
		int parent=-1;
        if(index%2==0)
		{
			parent=index/2-1;
		}
		else
		{
			parent=index/2;
		}
//        this.printHeap();
//        System.out.println("parent "+parent);
		while(this.heapstruct.get(index)<this.heapstruct.get(parent))
		{
				int temp=this.heapstruct.get(index);
				this.heapstruct.remove(index);
//				System.out.println("insert node");
//				this.printHeap();
				this.heapstruct.add(index,this.heapstruct.get(parent));
				this.heapstruct.remove(parent);
				this.heapstruct.add(parent,temp);
                index=parent;
                if(index%2==0)
                {
                        parent=index/2-1;
                }
                else
                {
                        parent=index/2;
                }
		}
	}
	public int extractMin() 
	{
		int parent=0;
		int min=this.heapstruct.get(parent);
		this.heapstruct.remove(parent);
		this.heapstruct.add(parent,this.heapstruct.get(this.heapstruct.size()-1));
		this.heapstruct.remove(this.heapstruct.size()-1);
        int leftchild=2*parent+1;
        if(leftchild>(this.heapstruct.size()-1))
        {
        	leftchild=-1;
        }
        int rightchild=2*parent+2;
        if(rightchild>(this.heapstruct.size()-1))
        {
        	rightchild=-1;
        }
        int minchild=-1;
        while(!(leftchild==-1 && rightchild==-1))
        {
        	if(rightchild==-1)
        	{
        		minchild=leftchild;
        	}
        	else if (this.heapstruct.get(rightchild)<this.heapstruct.get(leftchild))
        	{
        		minchild=rightchild;
        	}
        	else
        	{
        		minchild=leftchild;
        	}
        	
        	if(this.heapstruct.get(parent)>this.heapstruct.get(minchild))
        	{
        		int temp=this.heapstruct.get(parent);
        		this.heapstruct.remove(parent);
        		this.heapstruct.add(parent,this.heapstruct.get(minchild-1));
        		this.heapstruct.remove(minchild);
        		this.heapstruct.add(minchild,temp);
        		parent=minchild;
                leftchild=2*parent+1;
                if(leftchild>(this.heapstruct.size()-1))
                {
                        leftchild=-1;
                }
                rightchild=2*parent+2;
                if(rightchild>(this.heapstruct.size()-1))
                {
                        rightchild=-1;
                }	
        	}
        	else
        	{
        		break;
        	}
        }
		return min;
	}
	public void printHeap()
	{
		for (int temp:heapstruct) 
		{
			System.out.print(temp+" ");
		}
		System.out.println();
	}
	
	
    public static void main(String args[])
	{
    	Heap hp = new Heap(0);
    	hp.insertNode(1);
    	hp.insertNode(2);
    	hp.insertNode(12);
    	hp.insertNode(14);
    	hp.insertNode(5);
    	hp.insertNode(6);
    	hp.insertNode(7);
    	hp.insertNode(8);
    	hp.insertNode(9);
    	hp.printHeap();
    	hp.extractMin();
    	hp.printHeap();
	}
}
