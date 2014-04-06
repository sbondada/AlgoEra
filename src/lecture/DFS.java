package lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;


public class DFS 
{
	public class Graph
	{
		ArrayList<Node> nodeList;
		public Graph()
		{
			this.nodeList=new ArrayList<Node>();
		}
	}
	public class Node
	{
		int val;
		int edgewt;
		ArrayList<Node> list;
		public Node(int val)
		{
			this.val=val;
			this.edgewt=1;
			this.list=new ArrayList<Node>();
		}
		public Node(int val,int edgewt)
		{
			this.val=val;
			this.edgewt=edgewt;
			this.list=new ArrayList<Node>();
		}
	}
	public void search(Graph g)
	{
		HashSet<Node> visitedSet = new HashSet<DFS.Node>();
		Stack<Node> stack = new Stack<DFS.Node>();
		Node start=g.nodeList.get(0);
		for( Node temp:start.list)
		{
			stack.push(temp);
		}
		while(!stack.isEmpty())
		{
			Node temp= stack.pop();
			if(!visitedSet.contains(temp))
			{
				System.out.print(temp.val+" ");
				visitedSet.add(temp);
				for(Node rep : temp.list)
				{
					stack.push(rep);
				}
			}
		}
	}
	public void reccursearch( HashSet<Node> visitedSet, Node curr)
	{
		if(!visitedSet.contains(curr))
		{
			System.out.print(curr.val+" ");
			visitedSet.add(curr);
			for(Node temp:curr.list)
			{
				reccursearch(visitedSet,temp);
			}
			return;
		}
		else
		{
			return;
		}
	}
	public static void main(String argsp[])
	{
		DFS dfs= new DFS();
		DFS.Graph graph= dfs.new Graph();
		Node node1= dfs.new Node(1);
		Node node2= dfs.new Node(2);
		Node node3= dfs.new Node(3);
		Node node4= dfs.new Node(4);
		Node node5= dfs.new Node(5);
		Node node6= dfs.new Node(6);
		// adding the connections to the list of the graphs
		node1.list.add(node2);
		node1.list.add(node3);
		node1.list.add(node4);
		node1.list.add(node6);

		node2.list.add(node1);
		node2.list.add(node3);
		node2.list.add(node5);
		
		node3.list.add(node1);
		node3.list.add(node2);
		node3.list.add(node4);

		node4.list.add(node1);
		node4.list.add(node3);
		node4.list.add(node5);

		node5.list.add(node2);
		node5.list.add(node4);

		node6.list.add(node1);

		graph.nodeList.add(node1);
		graph.nodeList.add(node2);
		graph.nodeList.add(node3);
		graph.nodeList.add(node4);
		graph.nodeList.add(node5);
		graph.nodeList.add(node6);

		dfs.search(graph);
//		HashSet<Node> visitedSet=new HashSet<DFS.Node>();
//		dfs.reccursearch(visitedSet, graph.nodeList.get(0));
	}
}