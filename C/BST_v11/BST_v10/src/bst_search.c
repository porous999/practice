/* 
 *----------------- Searching the element in the binary search tree ----------------------
 */ 
#include <stdio.h>
#include <malloc.h>
#include<bst.h>

BSTREE* search(BSTREE *root, int searched_item)
{
	if( root )// == NULL)
	{
		printf(" tree is empty.........");
		return NULL;
	}
	else
	{
		while(root!= NULL)
		{
			if(root->data == searched_item)
			{
				printf("\n ---------------- Item being searched is present in the tree------------------ \n");
				return root;
			}
			else 
			{
				if (root->data > searched_item) 
					root = root->left;
				else
					root = root->right;
	   		}
		}
	}
}

