package qc.cegep_ste_foy.felipe.test1;

import java.util.*;

import qc.cegep_ste_foy.felipe.test1.PriorityMember;

public class Evaluator
{
    private PriorityMember[] priorities = new PriorityMember[]{ new PriorityMember(1,"*"), new PriorityMember(2,"/"),
                                                                new PriorityMember(3,"+"), new PriorityMember(1,"-") };

    public ExpressionStructure Evaluate(String[] expressionToEvaluate, ExpressionStructure carry)
    {
        if (expressionToEvaluate.length == 0)
        {
            while (!carry.stack.isEmpty())
            {
                carry.output += carry.stack.pop() + " ";
            }
            carry.output.trim();
            return carry;
        }
        else
        {
            if (this.isOperand(expressionToEvaluate[0]))
            {
                carry.output += expressionToEvaluate[0] + " ";
                return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
            }
            else if (this.isBinomialOperator(expressionToEvaluate[0])){
                if (!carry.stack.isEmpty())
                {
                    String operatorToEvaluate = carry.stack.peek().toString();
                    int highestPriorityMember = this.whoHasTheHighestPriority(operatorToEvaluate, expressionToEvaluate[0]);
                    if (highestPriorityMember == 1)
                    {
                        carry.output += carry.stack.pop() + " ";
                    }
                    carry.stack.push(expressionToEvaluate[0]);
                    return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
                }
                else
                {
                    carry.stack.push(expressionToEvaluate[0]);
                    return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
                }
            }
            else if (this.isUnaryOperator(expressionToEvaluate[0]))
            {
                carry.output += expressionToEvaluate[0] + " ";
                return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
            }
            else if (expressionToEvaluate[0].equals("("))
            {
                carry.stack.push(expressionToEvaluate[0]);
                return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
            }
            else if (expressionToEvaluate[0].equals(")"))
            {
                if (!carry.stack.isEmpty())
                {
                    int j=1;
                    boolean i = true;
                    do
                    {
                        String operatorToEvaluate = carry.stack.peek().toString();
                        if (!operatorToEvaluate.equals("("))
                        {
                            carry.output += carry.stack.pop() + " ";
                        }
                        else
                        {
                            if (j==0)
                            {
                                i = false;
                                carry.stack.pop();
                            }
                            else
                            {
                                j-=1;
                            }
                        }
                    }while (i);
                    return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
                }
                else
                {
                    return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
                }
            }
            else
            {
                return Evaluate(this.removeAt(expressionToEvaluate,0),carry);
            }
        }
    }

    public boolean isOperand(String s)
    {
        return java.util.regex.Pattern.matches("\\d+",s);
    }

    public boolean isBinomialOperator(String s)
    {
        if (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
            return true;
        }
        return false;
    }

    public boolean isUnaryOperator(String s)
    {
        if (s.equals("!")){
            return true;
        }
        return false;
    }

    public String[] removeAt(String[] source, int x)
    {

        ArrayList<String> list= new ArrayList<String>();
        for (int i=0; i<source.length; i++)
        {
            if (i!=x)
            {
                list.add(source[i]);
            }
        }
        String responseArray[] = new String[list.size()];
        responseArray = list.toArray(responseArray);
        return responseArray;
    }

    private int whoHasTheHighestPriority(String operator1, String operator2)
    {
        if (operator1.equals(operator2)){
            return 1;
        }
        else
        {
            if (this.getPriority(operator1) <= this.getPriority(operator2)){
                return 1;
            }
            else{
                return 2;
            }
        }
    }

    private int getPriority(String operatorToBeEvaluated)
    {
        for (int i=0;i<this.priorities.length;i++)
        {
            if(this.priorities[i].operator.equals(operatorToBeEvaluated))
            {
                return this.priorities[i].priority;
            }
        }
        return 99;
    }
}
