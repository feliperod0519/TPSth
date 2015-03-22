package qc.cegep_ste_foy.felipe.test1;

import java.util.*;

public class InverseEvaluator
{
    public double EvaluateInverse(String[] postFixExpression, int i)
    {
        Evaluator e = new Evaluator();
        if (postFixExpression.length == 1)
        {
            return Double.parseDouble(postFixExpression[0]);
        }
        else
        {
            while (i<postFixExpression.length)
            {
                if (e.isOperand(postFixExpression[i]))
                {
                    i += 1;
                }
                else if (e.isBinomialOperator(postFixExpression[i]))
                {
                    double d = Double.MIN_VALUE;
                    if (postFixExpression[i].equals("+"))
                    {
                        d = Double.parseDouble(postFixExpression[i-2]) + Double.parseDouble(postFixExpression[i-1]);
                    }
                    else if (postFixExpression[i].equals("-"))
                    {
                        d = Double.parseDouble(postFixExpression[i-2]) - Double.parseDouble(postFixExpression[i-1]);
                    }
                    else if (postFixExpression[i].equals("*"))
                    {
                        d = Double.parseDouble(postFixExpression[i-2]) * Double.parseDouble(postFixExpression[i-1]);
                    }
                    else if (postFixExpression[i].equals("/"))
                    {
                        if (Double.parseDouble(postFixExpression[i-1]) != 0)
                        {
                            d = Double.parseDouble(postFixExpression[i-2]) / Double.parseDouble(postFixExpression[i-1]);
                        }
                        else
                        {
                            d = 0;
                        }
                    }
                    return EvaluateInverse(ReplaceMembersBySingleValue(i-2,i,String.valueOf(d),postFixExpression),0);
                }
                else if (e.isUnaryOperator(postFixExpression[i]))
                {
                    if (postFixExpression[i].equals("!"))
                    {
                        return EvaluateInverse(ReplaceMembersBySingleValue(i-1,i,
                                String.valueOf(factorial(Double.parseDouble(postFixExpression[i - 1]))),postFixExpression),0);
                    }
                    else
                    {
                        return EvaluateInverse(ReplaceMembersBySingleValue(i-1,i,postFixExpression[i-1],postFixExpression), 0);

                    }
                }
            }
            return 0;
        }
    }

    public String[] ReplaceMembersBySingleValue(int i, int j, String replacement, String[] arrayToBeModified)
    {
        ArrayList<String> list = new ArrayList<String>();
        boolean alreadyInserted = false;
        for (int k=0; k<arrayToBeModified.length; k++)
        {
            if (k>=i && k<=j)
            {
                if (!alreadyInserted){
                    list.add(replacement);
                    alreadyInserted = true;
                }
            }
            else
            {
                list.add(arrayToBeModified[k]);
            }
        }
        String responseArray[] = new String[list.size()];
        responseArray = list.toArray(responseArray);
        return responseArray;
    }

    private double factorial(double value)
    {
        int fact, i;
        fact = (int)Math.floor(value);
        for (i = fact -1; i>=1 ; i--)
        {
            fact = fact * i;
        }
        return fact;
    }
}