package lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

import lecture.BFS.Node;

public class BFS 
{
	public class Graph
	{
		ArrayList<Node> nodeList;
		public Graph()
		{
			this.nodeList=new ArrayList<BFS.Node>();
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
		HashSet<Node> visitedSet= new HashSet<>();
		ArrayList<Node> queue= new ArrayList<>();
		Node start=g.nodeList.get(0);
		for (Node temp : start.list)
		{
			queue.add(temp);
		}
		while(!queue.isEmpty())
		{
			Node temp=queue.get(0);
			queue.remove(0);
			if(!visitedSet.contains(temp))
			{
				System.out.print(temp.val+" ");
				visitedSet.add(temp);
				for (Node rep: temp.list)
				{
					queue.add(rep);
				}
			}
		}
	}
	public static void main(String argsp[])
	{
		BFS bfs= new BFS();
		BFS.Graph graph= bfs.new Graph();
		Node node1= bfs.new Node(1);
		Node node2= bfs.new Node(2);
		Node node3= bfs.new Node(3);
		Node node4= bfs.new Node(4);
		Node node5= bfs.new Node(5);
		Node node6= bfs.new Node(6);
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

		bfs.search(graph);
	}
}
