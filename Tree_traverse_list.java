package algorithm;

// Target Tree
//
//           15
//         /     \
//        6       18
//      / \      /  \
//     3   7    17   20
//    /  \   \   
//   2   4    13
//            /
//           9
//
//Time Complexity O(n)

public class Tree_traverse_list {

	// Node structure
	class Node {
		Object value;
		Node left;
		Node right;
		
		public Node(Object value) {
			this.value = value;
		}
	}
	
	// Initialize node
	public Node createNode(Object value) {
		Node node = new Node(value);
		node.left = null;
		node.right = null;
		return node;
	}
	
	public static void main(String[] args) {
		Tree_traverse_list algorithm = new Tree_traverse_list();
		
		// Build Tree
		// row 15
		Node root = algorithm.createNode(15);
		//row 6
		Node node6 = algorithm.createNode(6);
		Node node18 = algorithm.createNode(18);
		root.left = node6;
		root.right = node18;
		// row 3
		Node node3 = algorithm.createNode(3);
		Node node7 = algorithm.createNode(7);
		Node node17 = algorithm.createNode(17);
		Node node20 = algorithm.createNode(20);
		node6.left = node3;
		node6.right = node7;
		node18.left = node17;
		node18.right = node20;
		// row 2
		Node node2 = algorithm.createNode(2);
		Node node4 = algorithm.createNode(4);
		Node node13 = algorithm.createNode(13);
		node3.left = node2;
		node3.right = node4;
		node7.right = node13;
		//row 9
		Node node9 = algorithm.createNode(9);
		node13.left = node9;
		
		// PreOrder Traverse => parent -> left -> right
		// algorithm.preOrder(root);
		
		//InOrder Traverse => left -> parent -> right
		// algorithm.inOrder(root);
		
		// PostOrder Traverse => left -> right -> parent
		algorithm.postOrder(root);
	}
	
	// PreOrder Traverse => parent -> left -> right
	public void preOrder(Node parent) {
		System.out.print(parent.value + " ");
		
		// If parent has left child
		if(parent.left != null)
			preOrder(parent.left);
		
		// If parent has right child
		if(parent.right != null)
			preOrder(parent.right);
	}
	
	// InOrder Traverse => left -> parent -> right
	public void inOrder(Node parent) {
		
		// If parent has left child
		if(parent.left != null)
			inOrder(parent.left);
		System.out.print(parent.value + " ");
		// If parent has right child
		if(parent.right != null)
			inOrder(parent.right);
	}
	
	// PostOrder Traverse => left -> right -> parent
	public void postOrder(Node parent) {
		
		// If parent has left child
		if(parent.left != null)
			postOrder(parent.left);
				
		// If parent has right child
		if(parent.right != null)
			postOrder(parent.right);
		System.out.print(parent.value + " ");
	}
}
