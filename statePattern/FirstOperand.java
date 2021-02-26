package statePattern;

public class FirstOperand implements State{
	CalcV1 calcv1;
	
	FirstOperand (CalcV1 calcv1) {
		this.calcv1=calcv1;
	}
	
	@Override
	public void processNumber(char ch) {
		calcv1.oper1=Integer.parseInt("" + ch);
		calcv1.setState(calcv1.firstOperand);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processOperator(char ch) {
		
			calcv1.op = ch;
			calcv1.setState(calcv1.operator);
		
		// TODO Auto-generated method stub
		
	}




}


