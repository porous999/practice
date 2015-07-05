#include <stdio.h>
#include <conio.h>

#define MAX 10
int rear,front,len;
char ch;
static int q[MAX];

void insert();
void display();
void delete();

int main()
{
     rear=-1;   front=0;     len=0;
     /*while(1)
     {
          printf("\nDo you want to insert(Y/N):");
          scanf("%c",&ch);
          if(ch=='y'||ch=='Y')
                insert(); 
          if(ch=='n'||ch=='N')  
                break;     
     }*/
     loop: ;
     insert();
     printf("\nInsert more(Y/N):");
     scanf("%d",&ch);
     if(ch=='y')
          goto loop;
     display();
     delete();
     printf("\n");
     display();
     getch();
     return(0);
}

void insert()
{
      int val;
      printf("\nGive the value:");
      scanf("%d",&val);
      if(rear==MAX-1)
           rear=0;
      else
           rear=rear+1;
      if(rear==front && q[front]!=NULL)
           printf("\nQueue overflow");
      else
      {
           q[rear]=val;
           len++;
      }           
}

void display()
{
     int i,j;
     j=front;
     for(i=0;i<len;i++)
     {
           printf(" %d ",q[j]);
           j++;                  
     }     
}

void delete()
{
     if(q[front]==NULL)
          printf("\nQueue is empty");
     else
     {
          q[front]=NULL;
          len=len-1;
          if(front==MAX-1)
                front=0;
          else
                front=front+1;     
     }
}
