class Super{
	public void print(){
		System.out.println("Super class method");
	}
}

class Sub extends Super{
	public void print(){
		System.out.println("Sub class method");
	}
	
}


public class Polymorphism{

	public static void main(String args[]){
		Super obj = new Super();
		obj.print();
	}	
}
