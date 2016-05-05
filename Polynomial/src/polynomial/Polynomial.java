package polynomial;
public class Polynomial implements iPolynomial {
	//---Attributes---
	int[] array;  //integer array to store coefficients
		
	//---Constructor Class---
	//create a polynomial
	//arg[0] is the degree of the polynomial
	//the remaining arguments are initializations for the coefficients
	//if there are no arguments, a poly of degree 0 is created
	//if one argument, a poly of size arg[0] is made, initialized to zeros
	public Polynomial(int...args){
		if (args.length == 0){
			this.array = new int[1];
			return;
		}
		//validate that the degree of the polynomial is zero or greater
		if (args[0]<0) {
			System.out.println("Error: Invalid array size.");
			return; //return if degree is invalid
		}
		this.array = new int[args[0]+1]; //initialize an array of size (degree+1)
		// set coefficients
		int i;
		for (i=1;i<args.length;i++){
			this.setCoefficient(i-1, args[i]);
		}
	}	
	
	//---Methods---
	//	return the polynomial degree
	public int getDegree(){
		if (this.array[this.array.length -1] != 0){
			System.out.println("Polynomial degree: " + (this.array.length-1));
			return (this.array.length - 1);
		} else{
			for (int i = this.array.length-1 ; i > 0 ; i--){
				if (this.array[i] != 0){
					System.out.println("Polynomial degree: " + (i));
					return i;
				}
			}
		} 
		System.out.println("Polynomial degree: " + 0);
		return 0;
	}
	
	//	return the coefficient for term 'n'
	public int getCoefficient(int n){
		if ((n > this.array.length) || (n < 0)){
			System.out.println("Error: Invalid coefficient input.");
			return 0;
		} else{
			System.out.println("Coeff for index " + n + ": " + this.array[n]);
			return this.array[n];
		}
	}
	
	//	set coefficient as 'newValue' for term 'n'
	public void setCoefficient(int n, int newValue){
		if ((this.array.length > n) && (n >= 0)){
			this.array[n] = newValue;	
			System.out.println("Coeff for index " + n + ": " + this.array[n]);
		}
		else{
			System.out.println("Error: Invalid coefficient index.");
		}
		return;
	}
	
	//	get value of polynomial for integer 'x'
	public int getValue(int x){
		int i;//index
		int val=this.array[0];//total value
		for(i=1;i<this.array.length;i++){
			val += this.array[i] * Math.pow(x,i);
		}
		System.out.println("Get value for x = " +x+ " : " + val + "\n");
		return val;
	}
	
	//	return the sum of the polynomial object and the polynomial p
	public iPolynomial suma(iPolynomial p){
		Polynomial x = (Polynomial) p;
		//determine the max polynomial size
		int size = Math.max(this.array.length, x.array.length);
		// create polynomial of for the correct size
		Polynomial z = new Polynomial(size-1);
		int i;
		for(i=0;i<size;i++){
			if ((i<this.array.length) && (i<x.array.length)){
				z.array[i] = this.array[i] + x.array[i];
			} else if ( i < this.array.length){
				z.array[i] = this.array[i];
			}
			else{
				z.array[i] = x.array[i];
			}
		}
		return (iPolynomial) z;
	}
	
	//	display the polynomial
	public void show(){
		int i;
		System.out.print("P(x) = " + this.array[0]);
		for(i=1;i<this.array.length;i++){
			if (this.array[i]!=0){
			System.out.print(" + " + this.array[i] + "*x^" + i);
			}
		}
		System.out.println("");
		return;
	}
}