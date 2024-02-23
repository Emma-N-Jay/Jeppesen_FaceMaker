package up.CS301.jeppesen_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class weDraw extends SurfaceView {


//    String redValue = Integer.toHexString(255);
//    String greenValue = Integer.toHexString(255);
//    String blueValue = Integer.toHexString(255);

// create an instance of a face controller
    Face mainFace = new Face();

    float faceX;
    float faceY;

    //color palette

    Paint skinTone = new Paint();

    //int red = mainFace.red
    //int green

    //skin tones

    Paint tan = new Paint();
    Paint hairColor = new Paint();
    Paint eyeColor = new Paint();
    Paint skinColor = new Paint();




    //hair colors
    Paint blonde = new Paint(0xFF5c4138);
    Paint brunette = new Paint(0xFF5c4138);
    Paint black = new Paint(0xFF5c4138);
    Paint red = new Paint(0xFF5c4138);


    public weDraw(Context context, AttributeSet attrs) {
    super(context, attrs);
    setWillNotDraw(false);

        tan.setColor(0xFFbc917b);
        tan.setStyle(Paint.Style.FILL);

        tan.setColor(0xFFbc917b);
        tan.setStyle(Paint.Style.FILL);

        tan.setColor(0xFFbc917b);
        tan.setStyle(Paint.Style.FILL);



    }

    public void drawHead(Canvas canvas,int r, int g, int b){
    }

    @Override
    protected void onDraw(Canvas canvas){
        //brightPink.setColor(0xFFFC0FC0);
        //drawHead(canvas,);
        //canvas.drawRect(300.0f, 100.0f,350.0f, 175.0f, lightTan);

        canvas.drawCircle(200.0f, 200.0f,50.0f, tan);

        setBackgroundColor(Color.WHITE);

        if(mainFace.currentSelected == R.id.hair){
            canvas.drawText("hair", 20,20, tan );
        }
        if(mainFace.currentSelected == R.id.eyes){
            canvas.drawText("eyes", 50f,20, tan );
        }

    }

    public Face getFace() {return mainFace;}

}