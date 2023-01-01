import java.util.Scanner;

class Node {
    int data;
    Node next;
}

class Stact_Operation {
    Node top=null;

    void push(int x) {
        Node t = new Node();

        if (t == null) {
            System.out.println("Stack is overflow");
        }

        t.data = x;
        t.next = top;
        top = t;

    }

    void display() {
        Node p;
        p = top;

        if (p == null) {
            System.out.print("stack is empty ");
        }

        while (p != null) {
            System.out.print(p.data + "\t");
            p = p.next;
        }
        System.out.println();
    }

    int pop() {
        int x = 0;
        if (top == null) {
            System.out.print("stack is underflow");
        } else {

            Node t;
            t = top;
            x = t.data;
            top = t.next;
        }
        return x;
    }

}

public class Stack_Using_LinkedList {

    public static void main(String[] args) {

        Stact_Operation st = new Stact_Operation();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcom User!");

        boolean flag = true;
        while (flag) {

            System.out.println("1.Push \n2.Pop \n3.Display");
            System.out.print("Enter Operation number you want to perform : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the data : ");
                    int item_data = sc.nextInt();
                    st.push(item_data);
                    break;

                case 2:
                    int poped_item = st.pop();
                    System.out.println("deleted item : " + poped_item);
                    break;

                case 3:
                    st.display();
                    break;

            }

            System.out.println("Do you want to continue (1.yes OR 2.no): ");
            int ans = sc.nextInt();
            if (ans == 1) {
                flag = true;
            } else {
                flag = false;
            }

        }

    }

}
