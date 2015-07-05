#include<stdio.h>
#include<stdlib.h>


int top;

struct stack
{
       int val;
       int link;       
}*front=NULL;

int main()
{
    top=-1;
    initialize();
    int n;
    printf("Enter no of n:");
    scanf("%d",&n);
    fibonacci(n);    
}

void initialize()
{
     struct stack *temp;
     temp=(struct stack *)malloc(sizeof(struct stack));
     temp->val=1;
     temp->link=NULL;               
     front=temp;
     top++;
     temp=(struct stack *)malloc(sizeof(struct stack));
     temp->val=1;
     temp->link=NULL;               
     front->link=temp;
     top++;
}

void fibonacci(int n)
{
     int i,n1,n2,n3;
     for(i=0;i<n-2;i++)
     {
           n2=pop();
           n1=pop();
           n3=n1+n2;
	   printf("%d ",n3);
           push(n2);
           push(n3);                  
     }
}

int pop(struct stack *p)
{
     struct stack *p,*q;
     p=front;
     int j;
     if(top==1)
     {
          q=p->link;        
     }    
     else if(top==0)
     {
          q=p;     
     }
     j=q->link;
     top--;
}

void push(int i)
{
     struct stack *p;
     p=front;
     if(top==0)
     {
	  p->val=i;
     }	
     else if(top==1)
     {
	  p=p->link;
	  p->val=i;	
     }
}
