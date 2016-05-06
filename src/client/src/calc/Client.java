package calc;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

/**
 * @author Hagen Aad Fock <hagen.fock@gmail.com>
 * @version 13.03.2015
 *
 * Ruft die Echo Methode des C++ Servers auf und gibt einen String auf der Konsole aus.
 * Sollte ein Fehler aufgetreten sein, so wird eine Exception geworfen und eine Fehlermeldung zusammen mit dem Stracktrace auf der Konsole ausgegeben.
 */
public class Client {

    public static int addition(Calculator calculator, int number1, int number2) {
        return calculator.addition(number1, number2);
    }

    public static int subtraction(Calculator calculator, int number1, int number2) {
        return calculator.subtraction(number1,number2);
    }

    public static int multiplication(Calculator calculator, int number1, int number2) {
        return calculator.multiplication(number1,number2);
    }

    public static int division(Calculator calculator, int number1, int number2) {
        return calculator.division(number1,number2);
    }

    public static void main(String[] args)  {

        Calculator calculator;

        try {
			
			/* Erstellen und intialisieren des ORB */
            ORB orb = ORB.init(args, null);
			
			/* Erhalten des RootContext des angegebenen Namingservices */
            Object o = orb.resolve_initial_references("NameService");
			
			/* Verwenden von NamingContextExt */
            NamingContextExt rootContext = NamingContextExtHelper.narrow(o);
			
			/* Angeben des Pfades zum Echo Objekt */
            NameComponent[] name = new NameComponent[2];
            name[0] = new NameComponent("test","my_context");
            name[1] = new NameComponent("Calculator", "Object");
			
			/* Aufloesen der Objektreferenzen  */
            calculator = CalculatorHelper.narrow(rootContext.resolve(name));

            int number1 = 4;
            int number2 = 3;

            System.out.println("Addition von " + number1 + " und " + number2 + ":" + addition(calculator, number1, number2));
            System.out.println("Subtraktion von " + number1 + " und " + number2 + ":" + subtraction(calculator, number1, number2));
            System.out.println("Multiplikation von " + number1 + " und " + number2 + ":" + multiplication(calculator, number1, number2));
            System.out.println("Division von " + number1 + " und " + number2 + ":" + division(calculator, number1, number2));

        }	catch (Exception e)	{
            System.err.println("Es ist ein Fehler aufgetreten: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
