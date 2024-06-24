public class Assignment2_Q2
 {
	 int top;
	 int size;
	 int[] stack;
	 boolean Empty = false;
	 boolean Full = false;
	 
	 
public Assignment2_Q2()//create and initialize empty stack array with capacity of 6
	 {
		 top = 0;
		 size = 8;
		 stack = new int[size];
				 
	 }
////////////////////////////////////////////
 public boolean isEmpty()    // method to check if stack array is empty
 {	
 if 
 (this.top == 0) 
 { 

	Empty = true;
 }
 	return Empty;
 }
 ///////////////////////////////////////////
 public boolean isFull()     // method to check if stack array is full
 {	
 if (this.top == this.size) 
 {
	Full = true;
 }
 	return Full;
 }
 ////////////////////////////////////////////
 public int push (int x)      // method to push elements into stack array
 {
	 if(isFull())
	   {
		   System.out.println("overflow!");
	   }
	 else
	 	{
	 this.top = this.top+1;
	 	}
	 return stack[this.top] = x;
 }
 /////////////////////////////////////////////
 public int pop()             // method to pop stack array's top by set top -1
 {
	   if(isEmpty())
	   {
		   System.out.println("undeflow!");
	   }
	   else
	   {
		   this.top  = this.top- 1;
	   }
		   return stack [this.top+1];   
 }
 ///////////////////////////////////////////////
 public int peek()				// method to check the element value of the stack array's top 
 {
	 return stack [this.top];
 }
 ////////////////////////////////////////////////
 public void display() 			// method to display all elements in que
 {
 	System.out.println("Elements : ");
 	
 	for(int i = 0;i<size;i++)
 	{
 	     System.out.println("Slot "+(i)+" " +stack[i]);
 	}
 }
/////////////////////////////////////////////////
 public static void main(String[] args) 
 {
	 Assignment2_Q2 stack = new Assignment2_Q2();

		 stack.push(15);
		 stack.push(6);
		 stack.push(2);
		 stack.push(9);
		 stack.push(17);
		 stack.push(3);
	
     System.out.println("Is Stack Empty? "+ stack.isEmpty());
     System.out.println("Is Stack Full? "+ stack.isFull());
     System.out.println("What is Stack Size? "+ stack.size);
     System.out.println("What is current Stack top's value? "+ stack.peek());
     System.out.println("What is Stack pop? "+ stack.pop());
     System.out.println("What is current Stack top's value after pop? "+stack.peek());
     stack.display();

  }
 }