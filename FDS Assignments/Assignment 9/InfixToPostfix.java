import java.util.* ;

class Node
{
    public char data;
    public Node next;
};

class stack
{
    private Node top;


    stack()
    {
        top = null;
    }

    public void push(char x)
    {
        Node t;
        t = new Node();
        t.data = x;
        t.next = top;
        top = t;

    }

    public char pop()
    {
        if(top==null)
        {
           System.out.println("stack is empty");
           return 0;
        }
        else
        {
            Node p;
            char x;
            p = top;
            x = p.data;
            top = top.next;
            return x;
        }
    }

    public char stackTop()
    {
        if(top==null)
        {
            return '0';
        }
        else
        {
            return top.data ;
        }
    }

    public int isEmpty()
    {
        if(top==null)
        {
            return 1;
        }   
        else
        {
            return 0;
        }
    }

    public void display()
    {
        Node p;
        p = top;
        while(p!=null)
        {
            System.out.println(p.data); 
            p = p.next;
        }
        //System.out.println("\n"); 
    }

    // this for all type of operators
    public boolean isOparand(char x)
    {
        if(x=='+' || x=='-' || x=='*' || x=='/' || x=='^' || x=='(' || x==')' )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

//this for universal operator precident
    public int In_Stack_Pre(char x)
    {
        if(x=='+' || x=='-')
        {
            return 2;
        }
        else if(x=='*' || x=='/')
        {
            return 4;
        }
        else if(x=='^')
        {
            return 5;
        }
        else if(x=='(')
        {
            return 0;
        }
        else if(x==')')
        {
            return 0;
        }
        else 
        {
            return -1;
        }

       
      
    }

//this for universal operator precident
    public int Out_Stack_Pre(char x)
    {
        if(x=='+' || x=='-')
        {
            return 1;
        }
        else if(x=='*' || x=='/')
        {
            return 3;
        }
        else if(x=='^')
        {
            return 6;
        }
        else if(x=='(')
        {
            return 7;
        }
        else if(x==')')
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

//this for infix to postfix for universal operators
    public String  InfixToPostfix_Conversion(String infix)
    {
        String postfix = new String();
        int i=0;

        for(int m=0; m<infix.length()+2; m++)
        //while(infix.charAt(i)!= '\0')
        {
            if(isOparand(infix.charAt(i)))
            {
                postfix += infix.charAt(i++);
            }
            else
            {
                if(Out_Stack_Pre(infix.charAt(i))>In_Stack_Pre(top.data))
                {
                    push(infix.charAt(i++));
                }
                else if(Out_Stack_Pre(infix.charAt(i)) == In_Stack_Pre(top.data))
                {
                    pop();
                    i++ ;
                }
                else
                {
                    postfix += pop();
                } 
            }
            
        }
    
        while(top!=null)
        {
            postfix += pop();
        }
        postfix += '\0';

        return postfix;
    }
}

class InfixToPostfix
{
    public static void main(String []args)
    {
        stack stk = new stack();
        stk.push('#');

        String infix = "((a+b)*c)-d^e^f^g^h" ;
        String postfix = stk.InfixToPostfix_Conversion(infix);
    
        
        System.out.println(postfix);   
        
     
    } 

}