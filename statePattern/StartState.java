package statePattern;

public class StartState implements State{
	CalcV1 calcv1;
	
	StartState (CalcV1 calcv1) {
		this.calcv1=calcv1;
	}
	
	@Override
	public void processNumber(char ch) {
		
			calcv1.oper1=Integer.parseInt("" + ch);
			calcv1.setState(calcv1.firstOperand);
			//System.out.println(calcv1.oper1);
		// TODO Auto-generated method stub
	}

	@Override
	public void processOperator(char ch) {
		// TODO Auto-generated method stub
		
	}


		
		
		// TODO Auto-generated method stub
	}



		



