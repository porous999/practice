#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>

#define MAX 20

struct infix
{
	char post[MAX] ;
	char stack[MAX] ;
	char *s,*t ;
	int top ;
};

//struct calculate
//{
    // char stack[MAX];
     //int i1,i2,i3;       
//}

void initialize(struct infix *);
void set(struct infix *,char *);
void convert(struct infix *);
int priority (char);
void push(struct infix *,char);
char pop(struct infix *);
void show(struct infix);
void store(struct infix *);

int main()
{
    struct infix in;
    char exp[MAX];
    
    initialize(&in); 
    
    printf ( "\nEnter an expression in infix form: " ) ;
    gets(exp);
       
    set(&in,exp);
    convert(&in);
    
    printf ( "\nThe postfix expression is: " ) ;
	show(in);
	
	store(&in);
	//struct calculate p;
	//evaluate(&in,&p);
	show(in);
	

    getch() ;
    return 0;
}

void initialize(struct infix *i)
{
     i->top=-1;
     strcpy(i->post,"");
     strcpy(i->stack,"");
     i->t=i->post;
     i->s="";     
}

void set(struct infix *i,char *str)
{
     i->s=str;     
}

void convert(struct infix *i)
{
     char op;
     
     while(*(i->s)!=NULL) 
     {
          if(isalpha(*(i->s)))
          {
               *(i->t)=*(i->s);
               i->t++;
               i->s++;                    
          }           
          if(*(i->s)=='(')
          {
                push(i,*(i->s));
                i->s++;                
          }          
          if(*(i->s)=='^'||*(i->s)=='/'||*(i->s)=='*'||*(i->s)=='+'||*(i->s)=='-')
          {
               if(i->top!=-1)
               {
                    op=pop(i);
                    while(priority(op)>=priority(*(i->s))) 
                    {
                         *(i->t)=op;
                         i->t++;
                         op=pop(i);                                       
                    }            
                    push(i,op);
                    push(i,*(i->s));
               }          
               else
                    push(i,*(i->s));
               i->s++;                                                             
          }
          if(*(i->s)==')')
          {
               op=pop(i);
               while(op!='(')
               {
                    *(i->t)=op;
                    i->t++;
                    op=pop(i);              
               }      
               i->s++;          
          }
     }  
     while(i->top!=-1)
     {
          char op=pop(i);
          *(i->t)=op;
          i->t++;                 
     }  
     *(i->t)='\0';
}

int priority (char ch)
{
	if (ch=='^')
		return 3 ;
	if (ch=='*'||ch=='/')
		return 2 ;
	else
	{
		if (ch=='+'||ch=='-')
			return 1 ;
		else
			return 0 ;
	}
}

void push(struct infix *i,char ch)
{
     i->top++;
     i->stack[i->top]=ch;     
}

char pop(struct infix *i)
{
     char ch;
     ch=i->stack[i->top];
     i->top--; 
     return ch;    
}

void show(struct infix in)
{
    printf(" %s",in.post) ;
}

/*void evaluate(struct infix *i,struct calculate *p)
{
     if(isalpha(*(i->t)))
     {
          printf("Enter value of %c");                    
     }     
}*/

void store(struct infix *i)
{
     i->t=i->post;
     char val[max];
     int j;
     j=0;
     while(*(i->t)!=NULL)
     {
          if(isalpha(*(i->t)))
          {
               printf("\nValue of %c:",*(i->t));
               scanf("%c",&val[j]);
               i->t++;                    
          }           
          if(*(i->t)=='^'||*(i->t)=='/'||*(i->t)=='*'||*(i->t)=='+'||*(i->t)=='-')
               i->t++; 
          val++;        
     }     
}
