package algorithm;

// Target Tree
//
//            15
//         /     \
//        6       18
//      / \      /  \
//     3   7    17   20
//    /  \   \   
//   2   4    13
//            /
//           9
// 
//	parent	(0..n, from 0)
//	left	(2n + 1)
//	right	(2n + 2)


// Time Complexity O(n)
public class Tree_traverse_array {
	
	public static void main(String[] args) {
		
		// Construct tree
		int[] tree = new int[25];
		tree[0] = 15;
		tree[1] = 6;
		tree[2] = 18;
		tree[3] = 3;
		tree[4] = 7;
		tree[5] = 17;
		tree[6] = 20;
		tree[7] = 2;
		tree[8] = 4;
		tree[10] = 13;
		tree[21] = 9;
		
		Tree_traverse_array algorithm = new Tree_traverse_array();

		// InOrder Traverse
		// algorithm.inOrderTraverse(tree, 0);
		
		// PreOrder Traverse
		// algorithm.preOrderTraverse(tree, 0);
		
		// PostOrder Traverse
		algorithm.postOrder(tree, 0);
	}
	
	// InOder traverse => left -> parent -> right
	public void inOrderTraverse(int[] tree, int parent) {
		// if left child exists
		if(2 * parent + 1 <= tree.length && tree[2 * parent + 1] != 0)
			inOrderTraverse(tree, 2 * parent + 1);
		System.out.print(tree[parent] + " ");
		// if right child exists
		if(2 * parent + 2 <= tree.length && tree[2 * parent + 2] != 0)
			inOrderTraverse(tree, 2 * parent + 2);
	}
	
	// PreOrder traverse => parent -> left -> right
	public void preOrderTraverse(int[] tree, int parent) {
		System.out.print(tree[parent] + " ");
		// if left child exists
		if(2 * parent + 1 <= tree.length && tree[2 * parent + 1] != 0)
			preOrderTraverse(tree, 2 * parent + 1);
		// if right child exists
		if(2 * parent + 2 <= tree.length && tree[2 * parent + 2] != 0)
			preOrderTraverse(tree, 2 * parent + 2);
	}
	
	// PostOder traverse => left -> right -> parent
	public void postOrder(int[] tree, int parent) {
		if(2 * parent + 1 <= tree.length && tree[2 * parent + 1] != 0)
			postOrder(tree, 2 * parent + 1);
		if(2 * parent + 2 <= tree.length && tree[2 * parent + 2] != 0)
			postOrder(tree, 2 * parent + 2);
		System.out.print(tree[parent] + " ");
	}

}
