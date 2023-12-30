import java.util.Scanner;
public class AsigCuadratica {

	static Scanner input = new Scanner(System.in);
	
	static double a,
				  b,
				  c;
	
	static void entradaDeDatos() //Se leen los coeficientes
	{
		System.out.println("Entre los valores para los coeficientes de la funci�n"
				+ "cuadr�tica ");
		System.out.print("a = ");
		a = input.nextDouble();
		
		System.out.print("b = ");
		b = input.nextDouble();
		
		System.out.print("c = ");
		c = input.nextDouble();
	}
	
	static boolean esLineal (double coeficienteCuadratico)  //Se determina si la funci�n es lineal o no
															// se verifica si coeficiente correspondiete al componente cuadritico
															// es o no es cero (0).
	{
		boolean result;
		
		if (coeficienteCuadratico == 0)
		{
			result = true;
		}
		
		else
		{
			result = false;
		}
		return (result);
	}
	
	static double discriminante(double a, double b, double c) // determina el valor del disciminante
															
	{
		return(Math.pow(b,2)-4*a*c);
	}
	
	static double raiz1(double a, double b, double c) //Determina las ra�ces de la funci�n
	{
		double raiz;
		
		raiz = (-b - Math.sqrt(discriminante(a,b,c)))/(2*a);
		
		return(raiz);
	}
	
	static double raiz2(double a, double b, double c) //Determina las ra�ces de la funci�n
	 {
	 double raiz;

	 raiz = (-b - Math.sqrt(discriminante(a,b,c)))/(2*a);

	 return(raiz);
	 }

	
	//Imprime los resultados del programa
	static void muestraResultados(boolean lineal, boolean compleja, double r1, double r2)
	{
		System.out.println("La funci�n " + a + "x^2 + " + b + " x + " + c);
		if (lineal == true)
		{
			System.out.println("es una funci�n lineal");
		}
		
		else if (compleja == true)
		{
			System.out.println("tiene ra�ces complejas");
		}
		
		else
		{
			System.out.println("tiene ra�ces reales cuyos valores son: ");
			System.out.println("x = " + r1 +", x = "+ r2);
		}
	}
	
	public static void main(String [] args)
	{
		boolean esLineal = false,
				raicesComplejas = false;
		
		double raizMas = 0,
				raizMenos = 0;
		
		entradaDeDatos(); //invoca el m�todo que lee los coeficientes
		
		if (esLineal(a))  //para determinar si la funci�n es o no lineal
		{
			esLineal = true;
		}
		else if (discriminante(a,b,c) < 0) //si el discriminante es negativo
		{
			raicesComplejas = true;
		}
		
		else
		{
			raizMas = raiz1(a,b,c);		//si la funci�n no es lineal ni tiene ra�ces
			raizMenos = raiz2(a,b,c);	//complejas se buscan las ra�ces rales
		}
		
		muestraResultados (esLineal, raicesComplejas, raizMas, raizMenos);
	
	}
}
