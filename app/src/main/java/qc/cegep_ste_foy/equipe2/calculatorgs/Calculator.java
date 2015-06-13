package qc.cegep_ste_foy.equipe2.calculatorgs;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.operator.Operator;


public class Calculator {

	private String equation;
	private double result;

    public Calculator() {
		super();
	}
	
	public void setEquation(String eq) {
		this.equation = eq;
	}

	public String getEquation() {
		return equation;
	}

	public double getResult() {
		return result;
	}

    public String toString() {
		return java.lang.Double.toString(result);
	}
	
	public void calculate() throws Exception {
		try {

			Operator factorial = Calculator.factorialOperator();

			String expressionString = getEquation();
			Expression expressionBuilder = new ExpressionBuilder(expressionString)
					.variables("pi", "e")
					.operator(factorial)
					.build()
					.setVariable("pi", Math.PI)
					.setVariable("e", Math.E);
			result = expressionBuilder.evaluate();

		} catch(NumberFormatException e) {
			throw(new Exception("Caractère(s) invalide(s)"));
		}
	}

    public static Operator factorialOperator() {
        Operator factorial = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {

            @Override
            public double apply(double... args) {
                final int arg = (int) args[0];
                if ((double) arg != args[0]) {
                    throw new IllegalArgumentException("Operand for factorial has to be an integer");
                }
                if (arg < 0) {
                    throw new IllegalArgumentException("The operand of the factorial can not be less than zero");
                }
                double result = 1;
                for (int i = 1; i <= arg; i++) {
                    result *= i;
                }
                return result;
            }
        };

        return factorial;
    }




}