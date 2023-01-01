import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of maximum orders: ");
		int m = sc.nextInt();
		sc.nextLine();
		CirqularQueue c1 = new CirqularQueue(m);
		boolean cont = true;
		while(cont) {
			int choice;
			System.out.println("1.Place Order: ");
			System.out.println("2.Execute next Order: ");
			System.out.println("3.Display Order: ");
			System.out.println("4.Exit: ");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.print("Enter Quantity: ");
				int quantity = sc.nextInt();
				sc.nextLine();
				c1.add(quantity);
				break;
			case 2:
				c1.delete();
				break;
			case 3:
				c1.display();
				break;
			case 4:
				cont = false;
				break;
			default:
				System.out.println("Enter valid choice!");
			}
		}

	}

}


class CirqularQueue {
	node front;
	node rear;
	int max;
	int count;
	
	CirqularQueue(int m) {
		this.max = m;
		this.count = 0;
		this.front = null;
		this.rear = null;
	}
	
	class node {
		int data;
		node next;
		node(int d){
			this.data = d;
		}
	}
	
	void add(int d) {
		if(this.count != this.max) {
			node temp = new node(d);
			if(this.front == null)
				front = temp;
			else 
				this.rear.next = temp;
			
			rear = temp;
			this.rear.next = this.front;
			this.count++;
		}
		else
			System.out.println("Max order limit reached");
	}
	
	void delete() {
		if(this.front == null) 
			System.out.println("Queue is Empty!!");
		else {
			if(this.front == this.rear) {
				this.front = null;
				this.rear = null;
				System.out.println("Order Executed Successfully");
				this.count--;
			}
			else {
				this.front = this.front.next;
				this.rear.next = this.front;
				this.count--;
				System.out.println("Order Executed Successfully");
			}
		}
	}
	
	void display() {
		node temp = this.front;
		System.out.println("Current Orders: ");
		while(temp.next != this.front) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
		System.out.println();
	}
}