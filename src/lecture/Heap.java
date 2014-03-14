package lecture;

import java.util.ArrayList;

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
		while(this.heapstruct.get(index)<this.heapstruct.get(parent))
		{
				int temp=this.heapstruct.get(index);
				this.heapstruct.remove(index);
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
		int minindex=0;
		int min=this.heapstruct.get(minindex);
		this.heapstruct.remove(minindex);
		int index=this.heapstruct.size()-1;
		this.heapstruct.add(minindex,this.heapstruct.get(index));
		this.heapstruct.remove(index);
        int leftchild=2*minindex+1;
        int rightchild=2*minindex+2;
		while(this.heapstruct.get(minindex)>this.heapstruct.get(rightchild) || this.heapstruct.get(minindex)>this.heapstruct.get(leftchild))
		{
			int minchild=-1;
			if(rightchild!=-1 && this.heapstruct.get(rightchild)>this.heapstruct.get(leftchild))
			{
				minchild=leftchild;
			}
			else
			{
				minchild=rightchild;
			}
				int temp=this.heapstruct.get(minindex);
				this.heapstruct.remove(minindex);
				this.heapstruct.add(minindex,this.heapstruct.get(minchild));
				this.heapstruct.remove(minchild);
				this.heapstruct.add(minchild,temp);
				minindex=minchild;
                leftchild=2*minindex+1;
                rightchild=2*minindex+2;
                if(leftchild>=this.heapstruct.size())
                {
                	break;
                }
                if(rightchild>=this.heapstruct.size())
                {
                	rightchild=-1;
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
