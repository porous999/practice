/* 
 *----------------- Binary tree traversal based on inorder fashion----------------------
 */ 
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include<bst.h>

BSTREE* inorder(BSTREE *root){
	if (!root){
		return NULL;
	}
	else{
		
	inorder (root -> left);
	printf ("%d ", root -> data);
	inorder (root -> right);
	return root;
	}
}

