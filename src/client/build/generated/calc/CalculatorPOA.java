package calc;


/**
 * Generated from IDL interface "Calculator".
 *
 * @author JacORB IDL compiler V 3.7
 * @version generated at May 6, 2016 11:24:36 PM
 */

public abstract class CalculatorPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, calc.CalculatorOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "multiplication", Integer.valueOf(0));
		m_opsHash.put ( "addition", Integer.valueOf(1));
		m_opsHash.put ( "division", Integer.valueOf(2));
		m_opsHash.put ( "subtraction", Integer.valueOf(3));
	}
	private String[] ids = {"IDL:calc/Calculator:1.0"};
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
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // multiplication
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(multiplication(_arg0,_arg1));
				break;
			}
			case 1: // addition
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(addition(_arg0,_arg1));
				break;
			}
			case 2: // division
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(division(_arg0,_arg1));
				break;
			}
			case 3: // subtraction
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				_out = handler.createReply();
				_out.write_long(subtraction(_arg0,_arg1));
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
