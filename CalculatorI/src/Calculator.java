
public class Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	public void  setOperandOne(double num) {
		operandOne= num;
	}
	public double getOperandOne() {
		return operandOne;
	}
	public void  setOperandTwo(double num) {
		operandTwo= num;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperation(String op) {
		operation = op;
	}
	public String getOperation() {
		return operation;
	}
	public void performOperation() {
		switch(operation) {
		case "+":
			result = operandOne+operandTwo;
			break;
		case "-":
			result= operandOne-operandTwo;
			break;
		case "*":
			result=operandOne*operandTwo;
			break;
		case"/":
			result=operandOne/operandTwo;
			break;
		default:
			System.out.println("This operand is not supported");
		}}
	
	public double getResults() {
		System.out.println(result);
		return result;
	}
	
}
