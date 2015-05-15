package qc.cegep_ste_foy.equipe2.calculatorgs;

import android.content.Context;

import qc.cegep_ste_foy.felipe.equipe2.calculatorgs.R;

/**
 * Created by Vicente on 3/21/2015.
 */
public class CalculatorLog {

    public static double calculate(Context context, String equation) throws Exception {

        String[] equations = equation.split(" ");

        if (equations.length == 2 ) {
            String log = equations[0];
            String valeur = equations[1];

            if (log.equals(context.getString(R.string.log).trim())) {
                return CalculatorLog.log(Double.valueOf(valeur));
            } else if (log.equals(context.getString(R.string.log_10).trim())) {
                return CalculatorLog.log10(Double.valueOf(valeur));
            }
        } else {
            throw(new Exception("Calcul logarithmique invalide"));
        }

        return 0;
    }


    public static double log(double value) {
        return Math.log(value);
    }

    public static double log10(double value) {
        return Math.log10(value);
    }


}
