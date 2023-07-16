package Priyan.Lab.Lab4.Prg2;
import java.util.Scanner;
import java.util.Arrays;

interface Queue {
	boolean isFull();
	boolean isEmpty();
	void enqueue(int x);
	int dequeue();
	void displayQueue();
}

public class QueueTest implements Queue{

	int rear, front, capacity;
	int [] arr;
	Scanner t = new Scanner(System.in);

	QueueTest() {
		rear = front = 0;
		System.out.println("Enter the Capacity of Queue: ");
		capacity = t.nextInt();
		arr = new int[capacity];
	}

	@Override
	public boolean isFull() { return rear == capacity; }

	@Override
	public boolean isEmpty() { return rear == front; }

	@Override
	public void enqueue(int x) {
		if ( isFull() ) {
			System.out.println("Queue is Full");
			capacity *= 2;
			arr = Arrays.copyOf(arr, capacity);
			displayQueue();
		} else {
			arr[rear] = x;
			rear++;
		}
	}

	@Override
	public int dequeue() {
		int temp;
		if ( isEmpty() ) {
			System.out.println("Queue is Empty");
			java.lang.System.exit(1);
		}
		temp = arr[front];
		front++;
		return temp;
	}

	@Override
	public void displayQueue() {
		System.out.println("...Displaying Queue...");
		System.out.println("\nCapacity is: " + capacity);
		System.out.print("Contents are... ");
		for (int i = 0 ; i < capacity; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		Queue q = new QueueTest();
		Scanner t = new Scanner(System.in);
		int choice;
		do {
			System.out.println("...Menu...");
			System.out.print("1) Enqueue\n2) DeQueue\n3) Is Full\n4) Is Empty\n5) Display Queue \nEnter your Choice:");
			choice = t.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter Element to be Enqueued: ");
					int x = t.nextInt();
					q.enqueue(x);
					break;
				case 2:
					System.out.println("The Dequeued element is : " + q.dequeue());
					break;
				case 3:
					if ((q.isFull())) {
						System.out.println("Yes, Stack is Full");
					} else {
						System.out.println("No, Stack is not Full");
					}
					break;
				case 4:
					if ((q.isEmpty())) {
						System.out.println("Yes, Stack is Empty");
					} else {
						System.out.println("No, Stack is not Empty");
					}
					break;
				case 5:
					q.displayQueue();
					break;
				default:
					System.out.println("Enter a valid Option!!");
			}
		}while(choice <= 5);
	}
}
