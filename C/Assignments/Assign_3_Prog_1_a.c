#include<stdio.h>
#include<malloc.h>

char in[20],out[20];
struct node
{
	int val;
	struct node *lc;
	struct node *rc;
}*root=NULL;

struct node *stack[10];
int top;

void read_file();
void set_node(int );
void outfile();
void push(struct node *);
struct node* pop();

int main()
{
	top=-1;
	printf("\nEnter input file name:");
	scanf("%s",in);
	//printf("\nEnter output file name:");
	//scanf("%s",out);
	read_file() ;
	outfile();
}

void read_file()
{
	int i,len;
	len=0;
	FILE *fp;
	fp=fopen(in,"r");
	//printf("\nAAAA\n");
	while(len<11)
	{
		fscanf(fp,"%d",&i);
		//if(i==EOF)
		//	break;
		//else
		//{
			//printf("\n%d\n",i);
			set_node(i);	
			//printf("\nAAAA\n");
		//}
	len++;
	}
}

void set_node(int i)
{
	struct node *p,*q,*tmp;
	tmp=(struct node *)malloc(sizeof(struct node ));
	tmp->val=i;
	tmp->lc=NULL;
	tmp->rc=NULL;
	//printf("\nBBBBB\n");
	if(root==NULL)
	{
		root=tmp;
		//root->lc=NULL;
		//root->rc=NULL;
	}
	else
	{
		q=root;
		while(q!=NULL)
		{
			p=q;
			if(i>p->val)
				q=q->rc;
			else
				q=q->lc;
		}
		//printf("\nBBBBB\n");
		if(i>p->val)
			p->rc=tmp;
		else
			p->lc=tmp;
		printf("%d",p->val);
	}
}

void outfile()
{
	struct node *p,*q,*r;
	p=root;
	q=p;
	push(root);
	do
	{//printf("\nccccccc");
		if(q->lc!=NULL)
		{printf("\nccccccc");
			r=q;
			q=q->lc;
			printf("%d--%d",r->val,q->val);
			push(q);
		}
		if(q->lc==NULL)
		{
			q=pop();
			if(q->rc!=NULL)
			{printf("\ndddddddd");
				r=q;
				q=q->rc;
				printf("%d--%d",r->val,q->val);
				push(q);
			}
		}
	}while(top!=-1);
}

void push(struct node *r)
{
	top++;
	stack[top]=r;
}

struct node* pop()
{
	struct node *j;
	j=stack[top];
	top--;
	return j;
}
