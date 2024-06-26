
public class Assignment2_Q3a

{
	 int size;
	 int[]queue;
	 int head;
	 int tail;

	  
public Assignment2_Q3a()//create and initialize empty que with capacity of 8
	 {
		 size = 13	;
		 queue = new int[size];	 
	 }
///////////////////////////////////////////////////////	
public void enQueue (int x)
{
		this.queue[tail] = x;
	if(this.tail == this.size) 
	{
		this.tail = 1;
	}
	else
	{	
		this.tail = this.tail+1;
	}
}
//////////////////////////////////////////////////////

public int deQueue (int x)
{
x = this.queue[head];

if(this.head == this.size) 
{
this.head = 1;
}
else
{
this.head = this.head+1;
}
return x;
}
//////////////////////////////////////////////////////
public void display() 			// method to display all elements in que
{
	System.out.println("Elements : ");
	
	for(int i = 0;i<size;i++)
	{
	     System.out.println("Slot "+(i)+" " +queue[i]);
	}
}
//////////////////////////////////////////////////////		
	public static void main(String[] args) 
	{

		Assignment2_Q3a queue = new Assignment2_Q3a();	
		
		queue.tail = 7;
		queue.head = 7;
		queue.enQueue (15);
		queue.enQueue (6);
		queue.enQueue (9);
		queue.enQueue (8);
		queue.enQueue (4);

		queue.display();
		System.out.println("Head is " +queue.head);
		System.out.println("Tail is " +queue.tail);
	}
}
