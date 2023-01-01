import java.util.*;

class LL {

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void insertion() {
        String d;
        Scanner sd = new Scanner(System.in);
        System.out.println("Enter the employee name");
        d = sd.nextLine();
        Node newNode = new Node(d);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;

            tail = newNode;
        }
    }

    void deleteNode() {
        System.out.println("Enter the position of the number to be deleted");
        int position;
        Scanner sc = new Scanner(System.in);
        position = sc.nextInt();

        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next;
    }

    public void display() {

        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // System.out.println("Nodes of singly linked list: ");
        System.out.println("Employs are :");
        while (current != null) {

            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void search() {
        String key;
        Scanner df = new Scanner(System.in);
        System.out.println("Enter the name of the employee do you want to search.");
        key = df.nextLine();
        Node crrnt;
        crrnt = head;
        crrnt.next = head.next;

        while (crrnt != null) {
            if (crrnt.data == key) {
                System.out.println("Data found");

            } else {
                System.out.println("No data found!!!");
            }
            crrnt = crrnt.next;

        }
    }
}

public class Main {

    public static void main(String[] args) {
        char ch;
        int choice;
        LL obj = new LL();
        do {
            Scanner d = new Scanner(System.in);
            System.out.println("Enter your choice ");
            System.out.println("1)insert employee data");
            System.out.println("2)delete data");
            System.out.println("3)search data");
            System.out.println("4)display record");
            choice = d.nextInt();
            switch (choice) {
                case 1:
                    obj.insertion();
                    break;
                case 2:
                    obj.deleteNode();
                    break;
                case 3:
                    obj.search();
                    break;
                case 4:
                    obj.display();
                    break;
            }
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = d.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}