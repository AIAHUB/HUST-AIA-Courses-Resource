#include <iostream>
using namespace std;
class Counter
{
	int count;
public:
	static int num;
	Counter():count(0)   {  };//�����������麯��
	void increment()
	{
		cout<<++count<<endl;
	}
	static void Getnum()//��̬��Ա���������麯��
	{
		cout<<num<<endl;
	}
virtual	void show()//�麯�����ܿ�ָ�����
	{
		cout<<"I am a couter!"<<endl;
	}
	void Readnum()
	{
		cout<<num<<endl;
	}
};
int Counter::num=10; 
void main()
{
	Counter* m=NULL;
	m->show();
}