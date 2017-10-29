#include<stdio.h>
#include<stdlib.h>

typedef struct Jose *Joseph;
struct Jose{
	int num;
	int code;
	Joseph next; 
};

Joseph CreatJoseph(int n);
void GetNum(Joseph rear,int m,int n);

int main()
{
	int n;
	printf("\t\t请输入人数个数：");
	scanf("%d",&n);
	printf("\n");
	Joseph Rear;
	Rear = CreatJoseph(n);
	int m;
	printf("请输入初始密码：");
	scanf("%d",&m);
	printf("\n"); 
	GetNum(Rear,m,n); 
}

Joseph CreatJoseph(int n)
{
	int i,m;
	Joseph temp,rear,head;
	head=(Joseph)malloc(sizeof(struct Jose));
	rear=head;
	for(i=1;i<=n;i++)
	{
		printf("请输入第%d个人的密码：",i);
		scanf("%d",&m);
		printf("\n");
		temp=(Joseph)malloc(sizeof(struct Jose));
		temp->num = i;//使用尾插法建立单链表 
		temp->code = m;
		rear->next=temp;
		rear=temp;
	}
	rear->next=head->next;//建立单循环链表 
	free(head);//删除头结点 
	return rear;
}

void GetNum(Joseph rear,int m,int n)
{
	Joseph temp,node;
	temp = rear;
	int i; 
	printf("出列的人的编号是：");
	while(n--)
	{
		for(i=0;i<m-1;i++)//遍历循环单链表 
		{
			temp = temp->next;
		}
		node = temp->next;
		printf("%d ",node->num);
		m = node->code; 
		temp->next = node->next;
		free(node);//删除节点 
	}
}

