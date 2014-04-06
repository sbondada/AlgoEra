package lecture;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;


public class TopologicalSort 
{
	static int ft=0;
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

	public void topologicalSort(HashMap<Node,Integer> scoremap, HashSet<Node> visitedSet, Node curr)
	{
		if(!visitedSet.contains(curr))
		{
			System.out.print(curr.val+" ");
			visitedSet.add(curr);
			for(Node temp:curr.list)
			{
				topologicalSort(scoremap, visitedSet, temp);
			}
			scoremap.put(curr,ft);
			ft--;
			return;
		}
		else
		{
			return;
		}
	}

	public static void main(String argsp[])
	{
		TopologicalSort ts= new TopologicalSort();
		TopologicalSort.Graph graph= ts.new Graph();
		Node node1= ts.new Node(1);
		Node node2= ts.new Node(2);
		Node node3= ts.new Node(3);
		Node node4= ts.new Node(4);
		Node node5= ts.new Node(5);
		Node node6= ts.new Node(6);
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

		HashSet<Node> visitedSet=new HashSet<Node>();
		HashMap<Node,Integer> scoremap = new HashMap<>();
		TopologicalSort.ft=graph.nodeList.size();
		ts.topologicalSort(scoremap,visitedSet, graph.nodeList.get(0));
		System.out.println();

		SortedSet<Map.Entry<Node,Integer>> sortedset = new TreeSet<Map.Entry<Node,Integer>>(
	            new Comparator<Map.Entry<Node,Integer>>() {
	                @Override
	                public int compare(Map.Entry<Node,Integer> e1,
	                        Map.Entry<Node,Integer> e2) {
	                    return e1.getValue().compareTo(e2.getValue());
	                }
	            });

		sortedset.addAll(scoremap.entrySet());
		for(Entry<Node, Integer> entry:sortedset)
		{
			System.out.print(entry.getKey().val+" ");
			System.out.println(entry.getValue());
		}
	}	
}