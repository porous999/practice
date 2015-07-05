#include <stdio.h>
#define MAX 10
#define STACK_SIZE 5

char infix[MAX],postfix[MAX];
char stack[STACK_SIZE];
int len,top;

void in_post();
int priority(char *);
void push(char *);
char pop();

int main()
{    
    top=0;
    printf("\nGive the infix notation:");
    scanf("%s",infix);    
    len=strlen(infix);
    //printf("\nAAAAAA");
    in_post(); 
    return(0); 
}

int priority(char *p)
{
    if(*(p)=='(')
         return(0);   
    if(*(p)==')')
         return(0); 
    if(*(p)=='+'||*(p)=='-')
         return(1);   
    if(*(p)=='*'||*(p)=='/')
         return(2); 
    if(*(p)=='^')
         return(0);   
    return(10); 
         
}

void in_post()
{
     int i,p_new;
     char *expr;
     i=0;
     expr=infix;
     //printf("\nAAAAAA");
     while(*(expr)!=NULL)
     {
          //printf("\nAAAAAA");
          p_new=priority(expr);
          if(p_new==10)
          {
               postfix[i]=infix[i];
               i++;
          }

          else 
          {
               //printf("\nAAAAAA");
               while(p_new<=priority(&stack[top]))
               {
               //printf("\nAAAAAA");
                     postfix[i]=pop();
                     printf("\n%c",postfix[i]);
                     top--;
                     i++;
               }
               push(expr);
          }
          expr++;
     }     
     while(top!=-1)
     {
           postfix[i]=pop();
           top--;
           i++;              
     }
}

void push(char *exp)
{postfix[i];
     top++;
     stack[top]=*(exp);               
}

char pop()
{
     return(stack[top]);
}
