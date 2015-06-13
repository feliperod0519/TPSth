package qc.cegep_ste_foy.equipe2.calculatorgs.graphic;

import android.graphics.Canvas;
import net.objecthunter.exp4j.*;
import net.objecthunter.exp4j.operator.Operator;

import qc.cegep_ste_foy.equipe2.calculatorgs.Calculator;


public class MappingCoordinates {

    public static final float aproxValue = 0.2F;
    public static final float delta= 0.05F;
    String expression = "x";

    public String getExpression()
    {
        return this.expression;
    }

    public void setExpression(String value)
    {
        this.expression = value;
    }

    public void yAxisSweeping(float x, Canvas canvas)
    {
        float yi = -10;
        while (yi>=-10 && yi<=10)
        {
            Operator factorial = Calculator.factorialOperator();

            Expression e = new ExpressionBuilder(this.expression)
                    .operator(factorial)
                    .variables("x", "pi", "e")
                    .build()
                    .setVariable("x", x)
                    .setVariable("pi", Math.PI)
                    .setVariable("e", Math.E);

            double valueToCompare = 0;
            try {
                valueToCompare = e.evaluate();
            } catch (Exception ex) {
            }

            if (valueToCompare>=(yi-MappingCoordinates.delta) && valueToCompare<=(yi+MappingCoordinates.delta))
            {
                ToolBox.drawAPoint(canvas,x,yi*-1);
            }
            yi += MappingCoordinates.aproxValue;

        }
    }

    private boolean validateIfCoordinatesMeetCriteria(AbstractCoords point)
    {
        float y= Evaluate(point.getX());
        if (point.getY()==y)
        {
            return true;
        }
        return false;
    }

    private float Evaluate(float x)
    {
        return 0.1F;
    }

}
