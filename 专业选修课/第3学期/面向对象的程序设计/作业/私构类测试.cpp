/**********************************************
˵����
��������1��2��3��4ѡ���ѡһ��ȥ��ע�ͣ��ɷֱ����
���Կ�ָ��������ɷ�����Ԫ�����������ɷ���˽�����������
�Լ�����˽�����Ա�����������Ĳ��ԣ���ҿ������Լ���
ƽ̨�ͻ����²���һ�£�vs2010����������û������ġ�
***********************************************/
#include <iostream>
using namespace std;
class A{
private:
    int a;
	A(int aa):a(aa)	{	cout<<"A��һ�㹹��������"<<endl; }
	A(const A& m) 
	{  
		cout<<"A�ĸ��ƹ���������"<<endl;  
		a=m.a; 
	}
public:	
	void show( )	  { 	cout<<"a="<<a<<endl;	}
	friend A* create_1(int m);
	A* create_2(int m);
	friend class C;
	friend class B;
	~A(){ cout<<"A������������"<<endl; }
};

A* create_1(int m)
{
	A* pa=new A(m);
	return pa;
}

A* A::create_2(int m)  
{
	A* pa=new A(m);
	return pa;
}

class B:public A//˽��������
{
	int b;
public:
	B(int aa,int bb):A(aa),b(bb) {    }
	void show( )	{ 	cout<<"a="<<a<<endl<<"b="<<b<<endl;	}
};

class C     //˽��������Ա����
{
	int c;
	A m_c;
public:
	C(int aa,int cc):c(cc),m_c(aa) {      }
	void show( ) {cout<<m_c.a<<endl<<c<<endl;}
};

void main(void)
{  
///*//��1����ָ����ó�Ա��������
	A* pa=NULL;
	pa=pa->create_2(2);
	pa->show();
	delete pa;
//*/
/*/////(2) ��Ԫ�������÷�
    A* pa=create_1(1);
	pa->show();
	delete pa;
*/
/*/////(3)������ʵ�����������
	C m(1,2);
	m.show();
*/
/*////(4)������ʵ�����������
	B n(3,4);
	n.show();
*/
}
