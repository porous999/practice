#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include<bst.h>

int main() {
		
		int number_of_nodes ; 
		int save_the_input;
		int iterator, user_input,to_be_searched_item, to_be_deleted_item; 
		BSTREE *root_node,*pre_root,*catch_search_item;
		root_node = NULL;
				
		while(1) {
		
		printf( " \n -------------Enter your choice --------------------------\n ");
		printf("\n 1. Insertion \n 2. Preorder \n 3. Inorder \n 4. Postorder \n 5. Deletion \n 6. Search \n 7. Exit \n ");
		scanf ("%d", &save_the_input );
		
		switch(save_the_input) {
		
		case 1 : 
				printf( " \n......... Please enter the numbers to create the binary tree....... \n");
				scanf ("%d", &number_of_nodes);
						
				printf( "\n...... Please enter the numbers one by one... \n");
				
				for (iterator = 0; iterator < number_of_nodes; iterator++) {
					
					scanf ("%d", &user_input);
										
					if (( user_input < 0 )) {
					        
					        printf( " ------- You have either entered a Character or a Negative number ----- \n ");
					        printf( " ------- Please enter the Positive integer values-------------\n ");
					        main();
					        
					}
										
					else {
					
					    root_node = insert (root_node, user_input);
					    printf("\n");
					    printf("Data element inserted is %d \n ", user_input);					    					
					}
				}
								
					break;
					
		case 2 : 
				
				pre_root = preorder(root_node);
				if (!pre_root){
				   
				    printf("---------- You have not inserted the elements --------- \n --------Please insert--------- \n");
				    break;
				}
				
		case 3 :
				printf("\n---------- The Inorder is as follows for the given tree....... \n ");
				inorder(root_node);
				break;
		
		case 4 :
				printf("\n---------- The Postorder is as follows for the given tree....... \n ");
				postorder(root_node);
				break;	
		
		
		case 5 :	
				printf(" \n please enter number to be deleted from binary tree....\n ");
				scanf("%d",&to_be_deleted_item);
				root_node = delete(root_node, to_be_deleted_item);
				
				if( root_node == NULL){
				
				    printf( " ELEMENT NOT FOUND !!!!!!!! \n *********** OOPS !!! THE TREE IS EMPTY *********** \n");
				}
				//else{
				    
				    //printf( " ELEMENT NOT FOUND !!!!!!!! \n ");
				//}
				break;
		case 6 :
				printf(" \n Please enter the number to be searched in binary tree......\n");
				scanf("%d", &to_be_searched_item);
				catch_search_item == search(root_node, to_be_searched_item);
				
				if( catch_search_item == NULL) {
				
				printf("  ELEMENT NOT FOUND !!!!!!!! \n");
				
				}
				break;
				
		case 7 :		
				exit(0);
				
		default :
				printf( " INVALID CHOICE \n ");
		}
		}
		return SUCCESS;
}

