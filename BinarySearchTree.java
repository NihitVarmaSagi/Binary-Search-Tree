package assignment;

public class BinarySearchTree {

	public class Node{
		int key;
		Node left,right;
		
		public Node(int key){
			this.key=key;
			right=left=null;
		}
	}
	Node root;
	BinarySearchTree(){
		root=null;
	}
	void insert(int key){
		root = insertrecursive(root,key);
	}
	Node insertrecursive(Node root, int key){
		if (root==null){
			root = new Node(key);
		}
		if (key<root.key){
			root.left = insertrecursive(root.left,key);
		}
		else if(key>root.key){
			root.right = insertrecursive(root.right,key);
		}
		return root;
	}
	void inorder(){
		inorderRecursive(root);
	}
	void inorderRecursive(Node root){
		if (root!=null){
			inorderRecursive(root.left);
			System.out.print(root.key+" ");
			inorderRecursive(root.right);
		}
	}
	void delete(int key){
		root = deletenode(root,key);
	}
	Node deletenode(Node root,int key){
		if(key<root.key){
			root.left = deletenode(root.left, key);
		}
		else if(key>root.key){
			root.right = deletenode(root.right, key);
		}
		else{
			if (root.left==null){return root.right;}
			else if(root.right==null){return root.left;}
			root.key = predessorvalue(root.left);
			root.left = deletenode(root.left,root.key);
		}
		return root;
	}	
	public int predessorvalue(Node root){
		int predessor = root.key;
		while(root.right!=null){
			predessor = root.right.key;
			root = root.right;
		}
		return predessor;
	}	
	
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		//inserting 15 nodes.
		tree.insert(54);tree.insert(29);tree.insert(69);tree.insert(76);tree.insert(50);
		
		tree.insert(32);tree.insert(19);tree.insert(58);tree.insert(45);tree.insert(82);

		tree.insert(55);tree.insert(99);tree.insert(10);tree.insert(100);tree.insert(84);
		
		System.out.println("Inorder traversel of the tree is:");
		tree.inorder(); //in order traversal
		
		//Delete case 1- A node that is leaf.
		System.out.println("\n");
		tree.delete(10);
		System.out.println("Inorder traversel after deleting the leaf node:");
		tree.inorder();
		
		//Delete case 2- A node that is replaced with predecessor that is a leaf.
		System.out.println("\n");
		tree.delete(50);
		System.out.println("Inorder traversel after deleting the node and replacing with "
				+ "predecessor that is a leaf:");
		tree.inorder();
		
		//Delete case 3- A node that is replaced with predecessor that is not leaf.
		System.out.println("\n");
		tree.delete(69);
		System.out.println("Inorder traversel after deleting the node and replacing with "
				+ "predecessor that is not a leaf:");
		tree.inorder();
	}

}
