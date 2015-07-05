/* 
 *----------------- Binary tree traversal based on preorder fashion----------------------
 */ 
#include <stdio.h>
#include<bst.h>

BSTREE* preorder(BSTREE *root){
	if (!root){
		return NULL;
	}
	
	else 	
	        printf ("%d ", root -> data);
	        preorder (root -> left);
	        preorder (root -> right);
	        return root;
}
    
