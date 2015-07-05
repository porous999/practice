/* Program to implement various operations done on Binary Search tree which are enlisted as follows
 * Insertion, Preorder, Inorder, Postorder, Deletion and Search 
 * 
 */

#include <stdio.h>
#ifndef _Tree_H
#define _Tree_H

#define SUCCESS 2
#define FAILURE 1

typedef struct{
	int data;
	struct bstree *left, *right;
}BSTREE;

typedef int ElementType;

BSTREE *create_node(ElementType );

BSTREE *inorder(BSTREE *);

BSTREE* postorder(BSTREE *);

BSTREE* preorder(BSTREE *);

BSTREE* search(BSTREE * , ElementType );

BSTREE *insert(BSTREE *, ElementType );

BSTREE *find_parent_succ(BSTREE *);

BSTREE* node_delete(BSTREE *, BSTREE *);

BSTREE *delete_root(BSTREE *);

BSTREE *delete(BSTREE *, ElementType );

#endif


















