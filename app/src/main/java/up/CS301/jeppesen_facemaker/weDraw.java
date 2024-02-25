package up.CS301.jeppesen_facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

import kotlin.random.Random;

/**
 * @Author Emma Jeppesen
 * Date:2/22/24
 */

public class weDraw extends SurfaceView {

// create a face object. How exciting!
    Face mainFace = new Face();


    //color palette
    public Paint skinTone = new Paint();
    public Paint hairColor = new Paint();
    public Paint eyeColor = new Paint();



    public weDraw(Context context, AttributeSet attrs) {
    super(context, attrs);
    setWillNotDraw(false);

    }

//onDraw method that sets paint colors and calls face methods
    @Override
    protected void onDraw(Canvas canvas){


        //set the paint colors
        this.eyeColor.setColor(mainFace.eyeColor);
        this.hairColor.setColor(mainFace.hairColor);
        this.skinTone.setColor(mainFace.skinColor);

        //Make sure the drawing actually fills
        eyeColor.setStyle(Paint.Style.FILL);
        skinTone.setStyle(Paint.Style.FILL);
        hairColor.setStyle(Paint.Style.FILL);

//call the methods that draw the face components
        drawHead(canvas);
        drawEyes(canvas);
        drawSmile(canvas);
        drawHair(canvas);

        setBackgroundColor(Color.WHITE);

    }

    //Get da Face
    public Face getFace() {return mainFace;}

    //Draw dem face parts
    public void drawHead(Canvas canvas){
        canvas.drawCircle(1000.0f, 400.0f, 250.0f, skinTone);
    }
    //Draw the beautiful eyes. Stare into them. I dare you.
    public void drawEyes(Canvas canvas){
        canvas.drawCircle(900.0f, 350.0f, 30.0f, eyeColor);
        canvas.drawCircle(1100.0f, 350.0f, 30.0f, eyeColor);
    }

    //arc method for the smile
    public void drawSmile(Canvas canvas){
        RectF smile = new RectF(950.0f, 400.0f, 1050.0f, 450.0f);
        canvas.drawArc(smile, 0.0f, 180.0f, false, eyeColor);
    }

    //method to draw the different hair styles
    public void drawHair(Canvas canvas) {
        if (mainFace.hairStyle == 0) {
            //The Donny
            canvas.drawOval(700.0f, 100.0f, 1300.0f, 300.0f, hairColor);
            canvas.drawOval(700.0f, 200.0f, 800.0f, 500.0f, hairColor);

        } else if (mainFace.hairStyle == 1) {
            //AKA the Minecraft Steve haircut
            canvas.drawRect(700.0f, 100.0f, 1300.0f, 300.0f, hairColor);
            canvas.drawRect(700.0f, 100.0f, 800.0f, 350.0f, hairColor);
            canvas.drawRect(1200.0f, 100.0f, 1300.0f, 350.0f, hairColor);

        } else if (mainFace.hairStyle == 2) {
            //Long hair
            canvas.drawOval(725.0f, 100.0f, 1275.0f, 300.0f, hairColor);
            canvas.drawOval(1200.0f, 150.0f, 1300.0f, 650.0f, hairColor);
            canvas.drawOval(700.0f, 150.0f, 800.0f, 650, hairColor);

        }

    }


}