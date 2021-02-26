package statePattern;

public class SecondOperand implements State{

	CalcV1 calcv1;
	
	SecondOperand (CalcV1 calcv1) {
		this.calcv1=calcv1;
	}
	
	@Override
	public void processNumber( char ch) {
		calcv1.oper2=Integer.parseInt("" + ch);
		calcv1.setState(calcv1.secondOperand);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processOperator( char ch) {
	if (ch=='=') {
			
			switch (calcv1.op) {
			case '+':
				System.out.printf("%d + %d = %d\n", calcv1.oper1, calcv1.oper2, calcv1.oper1 + calcv1.oper2);
				break;

			case '-':	
				System.out.printf("%d - %d = %d\n", calcv1.oper1, calcv1.oper2, calcv1.oper1 - calcv1.oper2);
				break;

			case '*':	
				System.out.printf("%d * %d = %d\n", calcv1.oper1, calcv1.oper2, calcv1.oper1 * calcv1.oper2);
				break;

			case '/':
				System.out.printf("%d / %d = %d\n", calcv1.oper1, calcv1.oper2, calcv1.oper1 / calcv1.oper2);
				break;
				}
		}
	calcv1.setState(calcv1.startState);
		// TODO Auto-generated method stub
		
	}


		
		
		// TODO Auto-generated method stub
		
	}

	


