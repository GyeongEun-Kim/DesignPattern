package statePattern;
import java.util.Scanner;

public class CalcV1 {
	Scanner scanner=new Scanner(System.in);
    int oper1; 
    int oper2; 
    char op; 
    char ch;
    String inputStr;
    
    State firstOperand ;
    State secondOperand ;
    State operator;
    State startState;
    
    State state;
    
    public CalcV1 () {
    	startState=new StartState(this);
    	firstOperand= new FirstOperand(this);
    	secondOperand = new SecondOperand(this);
    	operator = new Operator(this);
    	state=startState;
    	
    }
    
    public void ProcessNumber () {
    	state.processNumber(ch);
    }
    
    public void ProcessOperator () {
    	state.processOperator(ch);
    }
    
    
	public void setState(State state) {
   		this.state= state;
    	}
	
	  String getInput(String s) {
	        System.out.println(s);
	        return scanner.next();
	    }

    boolean run() {
    	
    	inputStr = getInput("���� �Ǵ� +,-,*,/,= ��ȣ �� �� ���� �Է��ϼ���");
    	
 
        ch = inputStr.charAt(0);
        if (ch == 'q' || ch == 'Q') { // q�� �Է��ϸ� ���α׷� ����
            return false;
        }
        else if (ch >= '0' && ch <= '9') { // ������ �ԷµǸ�
        	
        	ProcessNumber();
            
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') { // ������ ó��
       
        	ProcessOperator();
        }
        return true;
    }
    
    	
   
}
    
