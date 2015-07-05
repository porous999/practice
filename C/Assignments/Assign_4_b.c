#include<stdio.h>
#include<conio.h>

void insert();
void display();
void delete();

struct node
{
       int priority;
       int val;
       struct node *link;       
}*front=NULL;

int main()
{
    int choice;
    while(1)
    {
         printf("Insert(1):\n");     
         printf("Insert(2):\n");  
         printf("Insert(3):\n");  
         printf("Insert(4):\n"); 
         printf("Enter your choice:");
         scanf("%d",&choice);
         switch(choice)
         {
              case 1:
                   insert();
              case 2:
                   display();
              //case 3:
                   //delete();
              case 4:
                   exit(1); 
              default:
                   printf("Entered wrong choice\n"); 
         }      
    }
    getch();
    return(0);    
}

void insert()
{
        struct node *temp,*q;
        int i,i_priority;
        temp=(struct node *)malloc(sizeof(struct node)) ;
        printf("\nEnter item value:");
        scanf("%d",&i);
        printf("\nEnter item priority:");  
        scanf("%d",&i_priority);
        temp->val=i;
        temp->priority=i_priority;
        if(front==NULL)
        {
             front=temp;
        }
        else
        {
            q=front;
            while(q->link!=NULL)
                  q=q->link;
            q->link=temp;
            temp->link=NULL;
        }    
}

void display()
{
     struct node *ptr;
     ptr=front;
     if(front==NULL)
           printf("Queue is empty\n");
     else
     {
           printf("Queue is:\n");
           while(ptr->link!=NULL)
           {
                printf("%d(%d)",ptr->val,ptr->priority);
                ptr=ptr->link;                      
           }    
     }     
}
