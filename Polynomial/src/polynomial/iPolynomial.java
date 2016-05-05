package polynomial;
public interface iPolynomial {
	public int getDegree();
	public int getCoefficient(int n);
	public void setCoefficient(int n, int newValue);
	public int getValue(int x);
	public iPolynomial suma(iPolynomial p);
	public void show();
}