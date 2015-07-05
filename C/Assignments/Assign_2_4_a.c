#include<stdio.h>
#include<conio.h>

#define MAX 20

int item[MAX],priority[MAX],len;

void insert();
void display();
void delete();

int main()
{
    len=0;
    int choice;
    while(1)
    {
            printf("\nPress 1 or 2 or 3:");
            scanf("%d",&choice);
            switch(choice)
            {
              case 1:
                   {
                          insert();
                          break;
                   }
              case 2:
                   {
                          display();
                          break;
                   }
              case 3:
                   {
                          delete(); 
                          break;
                   }
              default:
                   printf("Entered wrong choice\n"); 
         }             
    } 
    return 0; 
}

void insert()
{
     printf("\nEnter item value:");
     scanf("%d",&item[len]);
     printf("\nEnter priority:");
     scanf("%d",&priority[len]);
     len++;
}

void display()
{
     int i;
     for(i=0;i<len;i++)
     {
           printf("%d(%d)",item[i],priority[i]);                  
     }     
}

void delete()
{
     int i,j,k;
     i=0;
     j=0;
     k=0;
     while(i<len)
     {//printf("\naaaaa");
           if(priority[i]>=priority[j])
           {
                 i++;              
           }
           else if(priority[j]>priority[i])
           {
                 j=i; 
                 k=i;printf("\n%d",k);
                 i++;          
           }                
     }  
     while(k<len)
     {
           priority[k]=priority[k+1];
           item[k]=item[k+1];
           k++;
     }
     len--;     
}
