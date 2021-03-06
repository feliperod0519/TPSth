package qc.cegep_ste_foy.equipe2.calculatorgs.graphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Hashtable;
import android.widget.Toast;


import qc.cegep_ste_foy.felipe.equipe2.calculatorgs.R;

public class CustomView extends View
{

    private Paint paint = new Paint();
    private Hashtable<String,RealCoords> limitCoords = new Hashtable<String,RealCoords>();
    private String expression = "x";
    private Context context;

    public CustomView(Context context)
    {
        super(context);
        Initialization(null, 0);
    }

    public CustomView(Context context, AttributeSet attributes)
    {
        super(context,attributes);
        Initialization(attributes,0);
    }

    public CustomView(Context context, AttributeSet attributes, int defStyle)
    {
        super(context,attributes,defStyle);
        Initialization(attributes, defStyle);
    }

    private void Initialization(AttributeSet attributes, int defStyle)
    {
        this.paint.setColor(Color.RED);
    }

    public void setExpression(String expression)
    {
        this.expression = expression;
    }

    public String getExpression()
    {
        return this.expression;
    }

    public Context getCustomViewContext() {
        return context;
    }

    public void setCustomViewContext(Context context) {
        this.context = context;
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        this.DrawAxis(canvas);
        this.limitCoords = ToolBox.getLimitCoords(canvas);
        MappingCoordinates mappingCoordinates = new MappingCoordinates();
        mappingCoordinates.setExpression(this.expression);
        float xi = -10;
        while (xi<=10)
        {
            try {
                mappingCoordinates.yAxisSweeping(xi,canvas);
                xi += MappingCoordinates.aproxValue;
            } catch (Exception e) {
                Toast.makeText(context, context.getString(R.string.graph_display_error), Toast.LENGTH_LONG).show();
                e.printStackTrace();
                break;
            }
        }

    }

    private void DrawAxis(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        canvas.drawLine(0,canvas.getWidth()/2,canvas.getWidth(),canvas.getWidth()/2,paint);
        canvas.drawLine(canvas.getWidth()/2,0,canvas.getWidth()/2,canvas.getWidth(),paint);
    }
}
