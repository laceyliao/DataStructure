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
	printf("\t\t����������������");
	scanf("%d",&n);
	printf("\n");
	Joseph Rear;
	Rear = CreatJoseph(n);
	int m;
	printf("�������ʼ���룺");
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
		printf("�������%d���˵����룺",i);
		scanf("%d",&m);
		printf("\n");
		temp=(Joseph)malloc(sizeof(struct Jose));
		temp->num = i;//ʹ��β�巨���������� 
		temp->code = m;
		rear->next=temp;
		rear=temp;
	}
	rear->next=head->next;//������ѭ������ 
	free(head);//ɾ��ͷ��� 
	return rear;
}

void GetNum(Joseph rear,int m,int n)
{
	Joseph temp,node;
	temp = rear;
	int i; 
	printf("���е��˵ı���ǣ�");
	while(n--)
	{
		for(i=0;i<m-1;i++)//����ѭ�������� 
		{
			temp = temp->next;
		}
		node = temp->next;
		printf("%d ",node->num);
		m = node->code; 
		temp->next = node->next;
		free(node);//ɾ���ڵ� 
	}
}

