/*
������ֻ�ܵ��ó���Ա����
����Ա����ֻ�ܵ��ó���Ա����
��ͨ�������ͨ��Ա�������Ե��ó�����
*/
#include <iostream>
using namespace std;
class Test
{
public:
	int a;

	void Show() const
	{
		cout << "Hello,Const!" << endl;
		print();
	}
	void Show()
	{
		cout << "Hello!" << endl;
		print();
	}
	void print() const 
	{

	}
};
int main()
{
	Test t1;
	t1.Show();
	Test  t2;
	t2.Show();
	return 0;
}