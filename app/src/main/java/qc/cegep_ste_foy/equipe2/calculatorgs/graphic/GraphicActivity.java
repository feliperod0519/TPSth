package qc.cegep_ste_foy.equipe2.calculatorgs.graphic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import qc.cegep_ste_foy.felipe.equipe2.calculatorgs.R;


public class GraphicActivity extends ActionBarActivity {

    public static String KEY_EXPRESSION = "expression";

    CustomView graphCustomView;
    String expression;

    public static Intent getIntentGraphPortionActivity(Context context, String expression){
        Intent intent = new Intent(context, GraphicActivity.class);
        intent.putExtra(KEY_EXPRESSION, expression);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        graphCustomView = (CustomView) findViewById(R.id.graphCustomView);

        String expression = getIntent().getStringExtra(KEY_EXPRESSION);
        if (expression != null) {
            graphCustomView.setCustomViewContext(this);
            graphCustomView.setExpression(expression);
            setTitle(expression);
        }
    }

}
