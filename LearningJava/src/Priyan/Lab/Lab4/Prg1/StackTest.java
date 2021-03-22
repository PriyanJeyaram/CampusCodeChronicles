package Priyan.Lab.Lab4.Prg1;
import java.util.Scanner;
import java.util.Arrays;

interface Stack {
	void push(int x );
	int pop();
	boolean isEmpty();
	boolean isFull();
	void displayStack();
}

public class StackTest implements Stack {

	int top, capacity;
	int [] arr;
	Scanner t = new Scanner(System.in);

	/* Default Constructor */
	StackTest() {
		top = -1;
		System.out.print("Enter Stack Capacity: ");
		capacity = t.nextInt();
		arr = new int[capacity];
	}

	@Override
	public void push(int x) {
		if ( isFull() ) {
			System.out.println("....Stack is Full....");
			capacity *= 2;
			arr = Arrays.copyOf(arr, capacity);
			displayStack();
		}
		arr[++top] = x;
		displayStack();
	}

	@Override
	public int pop() {
		int temp;
		if ( isEmpty() ) {
			System.out.println("Stack is Empty");
			java.lang.System.exit(1);
		}
		temp = arr[top];
		top--;
		return temp;
	}

	@Override
	public boolean isEmpty() { return top == -1; }

	@Override
	public boolean isFull() { return top == capacity - 1; }

	@Override
	public void displayStack() {
		System.out.println("\nCapacity is: " + capacity);
		System.out.print("Contents are... ");
		for (int i = 0; i < capacity; i++)
		System.out.print( arr[i] + " ");
	}

	public static void main(String[] args) {
		Stack s = new StackTest();
		Scanner t = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n...Menu...");
			System.out.print("1) Push\n2) Pop\n3) Is Full\n4) Is Empty\n5) Display Stack \nEnter your Choice:");
			choice = t.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter Element to be Pushed: ");
					int x = t.nextInt();
					s.push(x);
					break;
				case 2:
					System.out.println("The popped element is : " + s.pop());
					break;
				case 3:
					if ((s.isFull())) {
						System.out.println("Yes, Stack is Full");
					} else {
						System.out.println("No, Stack is not Full");
					}
					break;
				case 4:
					if ((s.isEmpty())) {
						System.out.println("Yes, Stack is Empty");
					} else {
						System.out.println("No, Stack is not Empty");
					}
					break;
				case 5:
					s.displayStack();
					break;
				default:
					System.out.println("Enter a valid Option!!");
			}
		}while(choice <= 5);
	}
}