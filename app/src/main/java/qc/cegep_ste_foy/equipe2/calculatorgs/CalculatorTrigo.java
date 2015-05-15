package qc.cegep_ste_foy.equipe2.calculatorgs;

import android.content.Context;

import qc.cegep_ste_foy.felipe.equipe2.calculatorgs.R;

/**
 * Created by Vicente on 3/17/2015.
 */
public class CalculatorTrigo {

    public static boolean isRadianTrigo = false;

    public static double calculate(Context context, String equation) throws Exception {

        String[] equations = equation.split(" ");

        if (equations.length == 2 ) {
            String trigonometricOperation = equations[0];
            String value = equations[1];

            if (trigonometricOperation.equals(context.getString(R.string.sin_trigo).trim())) {
                return CalculatorTrigo.sin(Double.valueOf(value));
            } else if (trigonometricOperation.equals(context.getString(R.string.cos_trigo).trim())) {
                return CalculatorTrigo.cos(Double.valueOf(value));
            } if (trigonometricOperation.equals(context.getString(R.string.tan_trigo).trim())) {
                return CalculatorTrigo.tan(Double.valueOf(value));
            }
        } else {
            throw(new Exception("Calcul trigonométrique invalide"));
        }

        return 0;
    }

    public static double sin(double value) {
        double val = (CalculatorTrigo.isRadianTrigo)?value:CalculatorTrigo.toRadiansValue(value);
        return Math.sin(val);
    }

    public static double cos(double value) {
        double val = (CalculatorTrigo.isRadianTrigo)?value:CalculatorTrigo.toRadiansValue(value);
        return Math.cos(val);
    }

    public static double tan(double value) {
        double val = (CalculatorTrigo.isRadianTrigo)?value:CalculatorTrigo.toRadiansValue(value);
        return Math.tan(val);
    }

    private static double toRadiansValue(double degree) {
        return Math.toRadians(degree);
    }

    private static double toDegreeValue(double radian) {
        return Math.toDegrees(radian);
    }

}
