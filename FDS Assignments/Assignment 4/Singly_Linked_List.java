import java.util.Scanner;

class Node {

    int id;
    String name;
    Node Next;
}

class SLL_op {

    Node Head = null;
    Scanner sc = new Scanner(System.in);

    Node accept() {
        Node a;
        a = new Node();
        System.out.print("Enter Employee id no. : ");
        a.id = sc.nextInt();
        System.out.print("Enter Employee Name : ");
        a.name = sc.next();
        a.Next = null;
        return a;

    }

    void creat_linked_list() {
        int number_of_nodes = 0;

        System.out.print("Enter the total employes that you want to make database : ");
        number_of_nodes = sc.nextInt();

        Node temp = null;
        for (int i = 1; i <= number_of_nodes; i++) {
            Node newnode;

            newnode = accept();

            if (Head == null) {
                Head = newnode;
                temp = Head;
            } else {
                temp.Next = newnode;
                temp = newnode;
            }
        }

    }

    void display_linked_list() {
        Node t;
        t = Head;

        while (t != null) {
            System.out.print("Employee id no. : " + t.id + "\t" + "Employee Name : " + t.name + "\n");
            t = t.Next;
        }
        System.out.println();
    }

    Node insert() {
      

        Node nn;
        nn = accept();

        Node t;
        t = Head;

        nn.Next = t.Next;
        t.Next = nn;

        return Head;
    }

    Node delete() {
        Node t, t1;
        t1 = new Node();
        t = Head;

        int pos;
        System.out.print("enter the Employee id no.  which you want to delete  : ");
        pos = sc.nextInt();

        if (pos == 1) {
            Head = t.Next;

        }

        int i = 1;
        while (i != pos) {
            t1 = t;
            t = t.Next;
            i++;
        }

        t1.Next = t.Next;
        t.Next = null;

        // free(t);

        return Head;
    }

    Node search() {
        Node t;
        t = Head;

        int val;
        System.out.print("Enter the id number which you want to search : ");
        val = sc.nextInt();

        while (t.id != val) {
            t = t.Next;
        }

        return t;

    }

    void Modify(int val, String nam) {
        Node t;
        t = Head;

        while (t.id != val) {
            t = t.Next;
        }

        t.name = nam;

    }

}

public class Singly_Linked_List {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SLL_op sample;
        sample = new SLL_op();

        System.out.println("Employee database ");
        System.out.println("Create Employee database ");

        sample.creat_linked_list();

        boolean c = true;
     
        while(c){
      
            System.out.println("Enter what you want to do : ");
            System.out.println("1.Insert \n2.Delete \n3.Search \n4.Modify \n5.Display");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sample.insert();
                    break;

                case 2:
                    sample.delete();
                    break;

                case 3:
                    Node t = sample.search();
                    System.out.println("Employee id no. : " + t.id + "\t Employee Name : " + t.name);
                    break;

                case 4:
                    System.out.println("Enter the employee id no. which you want to modify : ");
                    int mod = sc.nextInt();
                    System.out.println("Enter the new employee name at this id no. : ");
                    String nam = sc.next();

                    sample.Modify(mod, nam);
                    break;

                case 5:
                    sample.display_linked_list();
                    break;

            }
            System.out.println("type 1 to continue 2 for quit");
            int q = sc.nextInt();
            if(q==2)
            {
                c = false;
            }
        }
    }

}
