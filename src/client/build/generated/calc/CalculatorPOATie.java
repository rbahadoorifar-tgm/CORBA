package calc;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "Calculator".
 *
 * @author JacORB IDL compiler V 3.7
 * @version generated at May 6, 2016 11:24:36 PM
 */

public class CalculatorPOATie
	extends CalculatorPOA
{
	private CalculatorOperations _delegate;

	private POA _poa;
	public CalculatorPOATie(CalculatorOperations delegate)
	{
		_delegate = delegate;
	}
	public CalculatorPOATie(CalculatorOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public calc.Calculator _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		calc.Calculator __r = calc.CalculatorHelper.narrow(__o);
		return __r;
	}
	public calc.Calculator _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		calc.Calculator __r = calc.CalculatorHelper.narrow(__o);
		return __r;
	}
	public CalculatorOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(CalculatorOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public int multiplication(int number1, int number2)
	{
		return _delegate.multiplication(number1,number2);
	}

	public int addition(int number1, int number2)
	{
		return _delegate.addition(number1,number2);
	}

	public int division(int number1, int number2)
	{
		return _delegate.division(number1,number2);
	}

	public int subtraction(int number1, int number2)
	{
		return _delegate.subtraction(number1,number2);
	}

}
