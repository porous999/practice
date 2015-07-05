/* 
 *----------------- Deletion operation in binary search tree ----------------------
 */ 
 
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include<bst.h>

/*
 * ----------- To find the in order successor of the root node-------------------------
 */

BSTREE *find_parent_succ(BSTREE *root_node){
	
	BSTREE *parent_successor = NULL;
	parent_successor = root_node;
	root_node = root_node -> right;
	
	while (root_node -> left){
		parent_successor = root_node;
		root_node = root_node -> left;
	}
	return parent_successor;
}

/* --------- Deletion takes into account 3 conditions :
 * 1. Deleting from root node 2. Deleting from leaf node 3. Deleting from non-leaf nodes
 */


BSTREE* node_delete(BSTREE *parent, BSTREE *root_node){
	
	BSTREE *temp, *in_order_successor;
	
	if (root_node -> left == NULL && root_node -> right == NULL){                                // Deleting leaf nodes 
		
		if (parent -> left == root_node){
			
			parent -> left = NULL;
		}
		
		else{
			parent -> right = NULL;
		}
		free (root_node);
		return parent;
	
	}else if (root_node -> left == NULL || root_node -> right == NULL){                           // Deleting non-leaf nodes
		
		temp = root_node;
		
		if (parent -> left == root_node){
			if (root_node -> left)
				
				parent -> left = root_node -> left;
			else
				parent -> left = root_node -> right;
		
		}else{
			if (root_node -> right)
				parent -> right = root_node -> left;
			else
				parent -> right = root_node -> right;
		}
			free (temp);
			return parent;
	}else{
			in_order_successor = find_parent_succ (root_node);                            // Finding in order successor of the root node
			temp = in_order_successor -> left;
			in_order_successor -> left = temp -> right;
			temp -> left = root_node -> left;
			temp -> right = root_node -> right;
		
			if (parent -> right == root_node)
				parent -> right = temp;
			else
				parent -> left = temp;
				free (root_node);
				return parent;
	}
}

/* 
 * --------------------------------------- Deleting root node -----------------------------------------
 */ 

BSTREE *delete_root(BSTREE *root){
	
	BSTREE *in_order_successor, *temp;
	
	in_order_successor = find_parent_succ (root);
	temp = in_order_successor -> left;
	in_order_successor -> left = temp -> right;
	temp -> left = root -> left;
	temp -> right = root -> right;
	free (root);
	
	return temp;
}

/*
 * -------------------------Checking the existense of the element passed to be deleted in the binary search tree---------------------
 */

BSTREE *delete(BSTREE *root, int element){
	
	int deleted = 0;
	BSTREE *traverse_node, *node_parent, *temp, *original_root ;
	node_parent = NULL;
	original_root = root;
	traverse_node = root;
	
	while (traverse_node){
		if (traverse_node -> data < element){			// data in the node is less than element to be deleted
			if (traverse_node -> right){
				node_parent = traverse_node;
				traverse_node = traverse_node -> right;
				continue;
			}
			break;
		}else if (traverse_node -> data > element){		// data in the node is greater than the element to be deleted
			if (traverse_node -> left){
				node_parent = traverse_node;
				traverse_node = traverse_node -> left;
				continue;
			}
			break;
		}else if (traverse_node -> data == element){		// data in the node is equal to the element to be deleted
			if (node_parent){
				root == node_delete (node_parent, traverse_node);
				deleted = 1;
			}
			else{
				root = delete_root (root);
				deleted = 1;
			}
			break;
		}
	}
	if(deleted == 1){
	    printf( " *********** CONGRATULATIONS ************** \n *********** The element in the tree has been deleted ************* \n" );
		return root;
	}
	else if (deleted != 1 && deleted != 0) {
	    return original_root;
	}
	else if (deleted == 0) {
	        return NULL;
	}
     
}



