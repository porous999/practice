/* 
 *----------------- Creation of nodes in the binary search tree ----------------------
 */ 
 
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include<bst.h>

BSTREE *create_node(int element)
{
    BSTREE *node;
	node = (BSTREE *)malloc(sizeof(BSTREE));		// allocating memory dynamically
	
	if (node == NULL)
	{
        return FAILURE;
    }
    else{	      
	node -> data = element;
	node -> left = NULL;
	node -> right = NULL;  
	return node;
	}
}
