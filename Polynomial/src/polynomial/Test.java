package polynomial;
public class Test {
	public static void main(String[] args) {
		//Test construct
		Polynomial poly1 = new Polynomial(); 
		Polynomial poly2 = new Polynomial(0,5); 
		Polynomial poly3 = new Polynomial(1,1,1); 
		Polynomial poly4 = new Polynomial(4,1,3,3,1,1); 
		Polynomial poly5 = new Polynomial(5,1,1);
		System.out.println("");
		
		//Test for print of polynomial
		poly1.show();
		poly2.show();
		poly3.show();
		poly4.show();
		poly5.show();
		System.out.println("");

		//Test for receiving the degree of polynomial
		poly1.getDegree(); 
		poly2.getDegree();
		poly3.getDegree();
		poly4.getDegree();
		poly5.getDegree();
		System.out.println("");
		
		//Test to set the coefficients
		//Test error checking for poly1
		poly1.setCoefficient(99, 9); 
		poly2.setCoefficient(0, 9);
		poly3.setCoefficient(1, 9);
		poly4.setCoefficient(3, 9);
		poly5.setCoefficient(2, 9);
		System.out.println("");
		
		//Test to get coefficient
		//Test error checking for poly1
		poly1.getCoefficient(99); 
		poly2.getCoefficient(0);
		poly3.getCoefficient(1);
		poly4.getCoefficient(3);
		poly5.getCoefficient(2);
		System.out.println("");
		
		//Test get value of polynomial
		//Test larg value for poly1
		poly1.getValue(99); 
		poly2.getValue(1);
		poly3.getValue(5);
		poly4.getValue(1);
		poly5.getValue(3);
		
		//Add poly4 and poly5 to create polynomial 'x'
		poly4.show();
		poly5.show();
		iPolynomial x = poly4.suma(poly5); //sum polynomial
		x.show(); //show polynomial
	}
}

