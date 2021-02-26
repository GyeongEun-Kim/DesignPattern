package statePattern;

public class Operator implements State{
	CalcV1 calcv1;
	
	Operator (CalcV1 calcv1) {
		this.calcv1=calcv1;
	}

	@Override
	public void processNumber(char ch) {
		
		
			calcv1.oper2=Integer.parseInt("" + ch);
			calcv1.setState(calcv1.secondOperand);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processOperator(char ch) {
		
		// TODO Auto-generated method stub
		
	}

	

	

}
