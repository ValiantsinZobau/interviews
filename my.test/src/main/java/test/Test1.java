package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {
	private static class Node {
		
		public Node(Node left, Node right, String value) {
			super();
			this.left = left;
			this.right = right;
			this.value = value;
		}
		Node left;
		Node right;
//		List<Node> nodes;
		String value;
		
//		public void add(Node node) {
//			if(node == null) {
//				return;
//			}
//			if(node.value < this.value) {
//				if(this.left == null) {
//					node.left = node;
//				}
//				else {
//					this.left.add(node);
//				}
//			}
//			
//			if(node.value > this.value) {
//				if(this.right == null) {
//					node.right = node;
//				}
//				else {
//					this.right.add(node);
//				}
//			}
//		}
	}
	public static void main(String[] args) {
		
		
		Node rightyRight = new Node(null, null, "I am rightyRight");

		Node rightyLeft  = new Node(null, null, "I am rightyLeft");
		
		
		Node leftyRight = new Node(null, null, "I am leftyRight");

		Node leftyLeft  = new Node(null, null, "I am leftyLeft");
		
		Node right = new Node(rightyLeft, rightyRight, "I am right");
		
		Node left = new Node(leftyLeft, leftyRight, "I am left");
		
		Node tree = new Node(left, right, "I am tree");

		printTreeDFS(tree);
		System.out.println("-----------------------");

		printTreeBFS(tree);
	}
	
	public static void printTreeDFS (Node node) {
		System.out.println(node.value);
		if(node.left != null) {
			printTreeDFS (node.left);
		}
		if(node.right != null) {
			printTreeDFS (node.right);
		}
	}
	
	public static void printTreeBFS (Node node) {
		Queue<Node> queue = new LinkedList<Test1.Node>();
		queue.add(node);
		Node n = null;
		while ((n = queue.poll()) != null) {
			if(n.left != null) {
				queue.add(n.left);
			}
			if(n.right != null) {
				queue.add(n.right);
			}
			System.out.println(n.value);
		}
	}
}
