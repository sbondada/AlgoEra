package lecture;

public class BST 
{
    public class BinarySearchTree
	{
		public Node root;
		public BinarySearchTree(int val)
		{
			this.root=new Node(val,null);
		}
		public void addNode(int val)
		{
			Node temp=null;
			Node loc=this.root;
			while(loc!=null)
			{
                loc.size++;
				if(val>loc.val)
				{
					temp=loc;
					loc=loc.right;
				}
				else
				{
					temp=loc;
					loc=loc.left;
				}
			}
//			System.out.println(temp.val);
			if(temp.val<val)
			{
				temp.right=new Node(val,temp);
			}
			else
			{
				temp.left=new Node(val,temp);
			}
		}
		public void printDFSTree(Node loc)
		{
			if(loc==null)
			{
				System.out.println("_\t");
				return;
			}
			else
			{
				System.out.print(loc.val+" \t");
				System.out.println(loc.size);
				printDFSTree(loc.left);
				printDFSTree(loc.right); 
			}
		}
		public void printTree(String type)
		{
			Node loc=this.root;
			if(type=="DFS")
			{
				printDFSTree(loc);
			}
		}
	}
	public class Node
	{
		public int val;
		public Node Parent;
		public Node left;
		public Node right;
		public int size;
		public Node(int val,Node Parent) 
		{
			this.val=val;
			this.Parent=Parent;
			this.left=null;
			this.right=null;
			this.size=1;
		}
	}
	public Node getNode(Node loc,int num)
	{
	    Node res;
		if(loc==null)
		{
			return null;
		}
		if(loc.val==num)
		{
			return loc;
		}
		else
		{
			res=getNode(loc.left, num);
			if(res==null)
			{
                res=getNode(loc.right,num);
			}
			else
			{
				return res;
			}
		}
		return res;
	}
	public int getMinOrMax(BinarySearchTree tree,String flag)
	{
		Node loc=tree.root;
		if(flag=="min")
		{
			while(loc.left!=null)
			{
				loc=loc.left;
			}
			return loc.val;
		}
		else if(flag=="max")
		{
			while(loc.right!=null)
			{
				loc=loc.right;
			}
			return loc.val;
		}
		else
		{
			System.out.println("enter valid flag: max or min");
			return -1;
		}
	}
	public int getPred(BinarySearchTree tree,int num)
	{
		Node loc=getNode(tree.root,num);
		if (loc.left==null && loc.Parent.right==loc) 
		{
			return loc.Parent.val;
		}
		if(loc.left!=null)
		{
			loc=loc.left;
			while(loc.right!=null)
			{
				loc=loc.right;
			}
			return loc.val;
		}
		else
		{
			return -1;
		}
	}
	public int getSucc(BinarySearchTree tree,int num)
	{
		Node loc=getNode(tree.root,num);
		if(loc.right==null && loc.Parent.left==loc)
		{
			return loc.Parent.val;  
		}
		if(loc.right!=null)
		{
			loc=loc.right;
			while(loc.left!=null)
			{
				loc=loc.left;
			}
			return loc.val;
		}
		else
		{
			return -1;
		}
	}
	public static void main(String args[])
	{
		BST bs=new BST();
		BST.BinarySearchTree tree= bs.new BinarySearchTree(6);
		tree.addNode(3);
		tree.addNode(9);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(8);
		tree.addNode(10);
		tree.addNode(1);
		tree.addNode(5);
		tree.addNode(7);
		tree.addNode(11);
		tree.printTree("DFS");
		System.out.println(bs.getPred(tree, 1));
		System.out.println(bs.getMinOrMax(tree, "max"));
	}
}
