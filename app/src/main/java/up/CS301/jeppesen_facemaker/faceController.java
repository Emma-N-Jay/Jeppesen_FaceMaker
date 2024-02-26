package up.CS301.jeppesen_facemaker;

import static android.graphics.Color.rgb;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @Author Emma Jeppesen
 * Date:2/22/24
 */
public class faceController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener, AdapterView.OnItemSelectedListener {


    //Get some references
    private weDraw mainView;
    private Face faceMain;

    //set up the views
    private TextView redLabel;
    private TextView greenLabel;
    private TextView blueLabel;

    //(Would be for if the setting progress worked)
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;

    //value of rgb
    private int redVal;
    private int greenVal;
    private int blueVal;


    public faceController(weDraw initFaceView, Activity myActivity){
        //give all the things values
        mainView = initFaceView;
        faceMain = mainView.getFace();
        redLabel = myActivity.findViewById(R.id.red);
        greenLabel = myActivity.findViewById(R.id.green);
        blueLabel = myActivity.findViewById(R.id.blue);

    }

//    //Get the seek bars (Would be for if the setting progress worked)
//    redSeek = mainView.findViewById(R.id.numRed);
//    greenSeek = mainView.findViewById(R.id.numGreen);
//    blueSeek = mainView.findViewById(R.id.numBlue);

    @Override
    public void onClick(View v) {

        //Colors (Would be for if the setting progress worked)
        int red;
        int green;
        int blue;

        redSeek = mainView.findViewById(R.id.numRed);
        greenSeek = mainView.findViewById(R.id.numGreen);
        blueSeek = mainView.findViewById(R.id.numBlue);

        //if the view is equal to the button, change the current selected variable
        if(v.getId() == R.id.hair){
            faceMain.currentSelected = R.id.hair;

            /**
             * I really tried to get it to set the progress, but I couldn't figure
             * it out. Here is my attempt. It makes it crash when you click the hair button.
             */
//            red = Color.red(faceMain.hairRed);
//            green = Color.green(faceMain.hairGreen);
//            blue = Color.blue(faceMain.hairBlue);
//            this.redSeek.setProgress(red);
//            this.greenSeek.setProgress(green);
//            this.blueSeek.setProgress(blue);

        }else if(v.getId() == R.id.eyes){
            faceMain.currentSelected = R.id.eyes;
        }else if(v.getId() == R.id.skin){
            faceMain.currentSelected = R.id.skin;
        }

        if(v.getId() == R.id.randomFace){
            faceMain.randomize();
            this.updateColor();
        }

        mainView.invalidate();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mainView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //ids of the seek bars
         redVal = R.id.numRed;
         greenVal = R.id.numGreen;
         blueVal = R.id.numBlue;


        if(seekBar.getId() == redVal) {
            faceMain.red = progress;
            this.updateColor();
        }
        if(seekBar.getId() == greenVal){
            faceMain.green = progress;
            this.updateColor();
        }
        if(seekBar.getId() == blueVal){
            faceMain.blue = progress;
            this.updateColor();
        }
        int c = rgb(faceMain.red, faceMain.green, faceMain.blue);


        if(faceMain.currentSelected == R.id.hair) {
            faceMain.setHairColor(c);

            //TODO - Fix this!
            faceMain.hairRed = faceMain.red;
            faceMain.hairGreen = faceMain.green;
            faceMain.hairBlue = faceMain.blue;

            this.updateColor();
        }
        else if(faceMain.currentSelected == R.id.skin){
            faceMain.setSkinColor(c);

            faceMain.skinR = faceMain.red;
            faceMain.skinG = faceMain.green;
            faceMain.skinB = faceMain.blue;
            this.updateColor();
        }
        else if(faceMain.currentSelected == R.id.eyes){
            faceMain.setEyeColor(c);

            faceMain.eyeRed = faceMain.red;
            faceMain.eyeGreen = faceMain.green;
            faceMain.eyeBlue = faceMain.blue;

            this.updateColor();
        }

            mainView.invalidate();

    }



    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }

    //Updates the labels for the colors
    public void updateColor(){
        if(faceMain.currentSelected == R.id.hair) {
            this.redLabel.setText("Red:" + " " + faceMain.hairRed);
            this.greenLabel.setText("Green:" + " " + faceMain.hairGreen);
            this.blueLabel.setText("Blue:" + " " + faceMain.hairBlue);
        }
        else if(faceMain.currentSelected == R.id.skin){
            this.redLabel.setText("Red:" + " " + faceMain.skinR);
            this.greenLabel.setText("Green:" + " " + faceMain.skinG);
            this.blueLabel.setText("Blue:" + " " + faceMain.skinB);
        }
        else if(faceMain.currentSelected == R.id.eyes){
            this.redLabel.setText("Red:" + " " + faceMain.eyeRed);
            this.greenLabel.setText("Green:" + " " + faceMain.eyeGreen);
            this.blueLabel.setText("Blue:" + " " + faceMain.eyeBlue);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        faceMain.setHairStyle(position);
        mainView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
