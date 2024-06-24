
public class Test {

	public static void main(String[] args) {
		Calculator calc1= new Calculator ();
		calc1.setOperandOne(10.5);
		calc1.setOperation("-");
		calc1.setOperandTwo(5.2);
		calc1.performOperation();
		calc1.getResults();
	}

}
