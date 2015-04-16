package qc.cegep_ste_foy.felipe.test1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import java.lang.*;

public class MainActivity extends ActionBarActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addListenerOnButton() {

        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                TextView t = (TextView)findViewById(R.id.text);
                String formule = t.getText().toString();
                String[] resultS = formule.split(" ");
                Evaluator e = new Evaluator();
                ExpressionStructure stru = new ExpressionStructure();
                ExpressionStructure str = e.Evaluate(resultS, stru);
                InverseEvaluator inv = new InverseEvaluator();
                double d =inv.EvaluateInverse(str.output.split(" "),0);
                TextView t2 = (TextView)findViewById(R.id.text2);

                t2.setText(String.valueOf(d));
            }

        });

    }


}
