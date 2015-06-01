package qc.cegep_ste_foy.equipe2.calculatorgs;

import android.content.Context;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

import qc.cegep_ste_foy.felipe.equipe2.calculatorgs.R;

public class Calculator {

	private String equation;
	private double result;
    private boolean isRadianTrigonometric = false;

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

    public boolean isRadianTrigonometric() {
        return isRadianTrigonometric;
    }

    public void setRadianTrigonometric(boolean isRadianTrigo) {
        this.isRadianTrigonometric = isRadianTrigo;
    }

    public String toString() {
		return java.lang.Double.toString(result);
	}
	
	public void calculate(Context context) throws Exception {
		try {

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

			Function logb = new Function("log10", 1) {
				@Override
				public double apply(double... args) {
					return Math.log10(args[0]);
				}
			};

			String expressionString = getEquation();
			Expression expressionBuilder = new ExpressionBuilder(expressionString)
					.function(logb)
					.operator(factorial)
					.build();
			result = expressionBuilder.evaluate();

		} catch(NumberFormatException e) {
			throw(new Exception("Caractère(s) invalide(s)"));
		}
	}




}