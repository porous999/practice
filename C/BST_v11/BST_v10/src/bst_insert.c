/* 
 *----------------- Insertion otraverse_nodeeration in binary search tree ----------------------
 */ 
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include<bst.h>

BSTREE *insert(BSTREE *root, int element)
{
	BSTREE *traverse_node;
	if (!root){
	
		root = create_node(element);
		
		if (root == NULL) {
		        printf( " \n ----------------- MEMORY NOT AVAILABLE ---------------- \n ");
		        return FAILURE;
		    }
    }
    
	else
	{
		traverse_node = root;
		
		while (traverse_node) {
			
			if (traverse_node->data < element) {		// check if the element passed is greater than the element at root
				
				if (traverse_node -> right) {
					
					traverse_node = traverse_node -> right;
					continue;
				}
				else {
				
                    traverse_node -> right = create_node(element);
				    break;
				    }
			}
			else if (traverse_node -> data > element) {	// check if the element is less than the element at the root node

				if (traverse_node -> left){
					
					traverse_node = traverse_node -> left;
					continue;
				}
				else {
					
					traverse_node -> left = create_node (element);
					break;
				}
			}
			else //if (traverse_node -> data == element) 
			{	// check if the element is equal to the element at the root node	

				printf ("\n ------REJECTION OF DUPLICATE ELEMENT ------\n");
				break;
			}
		}
	}
	return root;
}

