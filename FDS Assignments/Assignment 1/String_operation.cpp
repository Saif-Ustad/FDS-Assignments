#include<iostream>
using namespace std;

class str_operation
{
    public:
    int str_length( char * p)
    {
        int i=0 ;
        while( *(p + i) != '\0')
        { 
            i++ ;
        }
        
        return i ;
    }

    void str_copy(char * p)
    {
       string str2;
      // char *ptr2 = &str2[0];
       int i=0;
       while(*(p + i) != '\0' )
       {
            (str2[i]) = *(p + i) ;
            i++ ;
       }
       str2[i] = '\0' ;
       
       cout<<"Copy string is :";

       for(int i=0; (str2[i]) != '\0'; i++)
       {
        cout<<(str2[i]);
       }
        cout<<endl;
    }

    void str_concate(char *ptr3 , string surname)
    {
        
        int j = str_length(ptr3) ;
        int i=0;
        while( surname[i] != '\0')
        {  
            *(ptr3 + j)= surname[i]; 
            j++ ;
            i++ ;   
        }
        *(ptr3 + j) = '\0' ;
        
        for(int i=0; *(ptr3 + i) != '\0'; i++)
       {
        cout<<*(ptr3 + i);
       }
       cout<<endl;

    }

    void str_compare(char *ptr4, char *ptr5)
    {
        int i=0;
        bool b =true ;
        while(*(ptr4 + i) != '\0')
        {
            if(*(ptr4 + i) != *(ptr5 + i)) 
            {
                b = false ;
            }
            i++ ;
        }
        if(b==true)
        {
            cout<<"Same"<<endl;
        }
        else
        {
            cout<<"No"<<endl;
        }
           cout<<endl;
    }

    void str_reverse(char *ptr6)
    {
        int l = str_length(ptr6);
        
        cout<<"reverse string :";
        for(int i=l; i>=0; i--)
        {
            
            cout<< *(ptr6 + i);
        }
         cout<<endl;
    }
   
};

int main()
{
    bool t = true ;
    while(t)
    {
    int num;
    str_operation s;

    cout<<"Enter what you want to do :"<<endl;
    cout<<"1.length \n2.copy \n3.concate \n4.compare \n5.reverse"<<endl;
  
    cin>>num;
    
    if(num==1)
    {
        cout<<"enter the string : " ;
        string str1;
        cin>>str1;
        cout<<"length of string is : "<<s.str_length(&str1[0])<<endl;
    }
    else if(num==2)
    {
        cout<<"enter the string : " ;
        string str1;
        cin>>str1;
        s.str_copy(&str1[0]);
    }
    else if(num==3)
    {
        string name, surname;
        char *ptr3 = &name[0];
        cout<<"enter first name : ";
        cin>>name;
        cout<<"enter last name : ";
        cin>>surname;
        
        s.str_concate(ptr3 , surname);
    }
    else if(num==4)
    {
        string str4, str5;
        char *ptr4 = &str4[0];
        char *ptr5 = &str5[0];
        cout<<"enter first string : ";
        cin>>str4;
        cout<<"enter second string : ";
        cin>>str5;
        
        s.str_compare(&str4[0], &str5[0]);
    }
    else if(num==5)
    {
        cout<<"enter the string : " ;
        string str6;
        cin>>str6;
        char *ptr6 = &str6[0];
        s.str_reverse(ptr6);
    }

    int m;
    up:
    cout<<"Are you want to continue? (enter 1 for Yes , enter 2 for No) : ";
    cin>>m;
    if(m==1)
        t = true;
    else if(m==2)
        t = false;
    else
        goto up;    
    }
}