/* 
 *----------------- Binary tree traversal based on postorder fashion----------------------
 */
  
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include<bst.h>

BSTREE* postorder(BSTREE *root){
	if (!root){
		return NULL;
	}
	else{
		
	    postorder(root -> left);
	    postorder(root -> right);
	    printf ("%d ", root -> data);
	    return root;
	}
}

