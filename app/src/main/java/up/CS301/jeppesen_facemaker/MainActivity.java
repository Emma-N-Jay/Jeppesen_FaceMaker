package up.CS301.jeppesen_facemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

/**
 * @Author Emma Jeppesen
 * Date:2/14/24
 */
/*
[20%] When the user selects a new value on the Spinner, the hair’s appearance should be
changed to reflect the user's choice.

• [30%] When the user selects one of the RadioButtons (hair, eyes or skin) the current
progress of the SeekBars (red, green and blue) should be moved to reflect the current
color of the corresponding element.

• [25%] When the user adjusts any of the SeekBars (red, green or blue), the currently
selected element (hair, eyes or skin) should change color on the SurfaceView.

• [5%] When the app starts up, it should display a random face with the various views
already set to reflect the values used to construct that face. Each time the user hits the
“Random Face” button, a new random face should be generated and displayed in the
same manner with matching views.

• [15%] Your program should conform to the CS301 Coding Standard.

• [5%] Turn your program in correctly using GitHub (see instructions below).
 */


public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, SeekBar.OnSeekBarChangeListener, View.OnClickListener {



    //find the seek bars
    SeekBar redSeek;
    SeekBar greenSeek;
    SeekBar blueSeek;


    //find buttons
    RadioButton hair;
    RadioButton eyes;
    RadioButton skin;

    private weDraw mainCanvas;
   private Face face;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.hairselector);

        //get the surface view
        mainCanvas = findViewById(R.id.faceView);
        face = mainCanvas.getFace();

        // Create an instance of faceController
        faceController mainControl = new faceController(mainCanvas, this);

        //find seek bars
        redSeek = findViewById(R.id.numRed);
        greenSeek = findViewById(R.id.numGreen);
        blueSeek = findViewById(R.id.numBlue);

        //find buttons
        hair = findViewById(R.id.hair);
        eyes = findViewById(R.id.eyes);
        skin = findViewById(R.id.skin);

        // Set mainControl as the OnClickListener for the buttons
        hair.setOnClickListener(mainControl);
        eyes.setOnClickListener(mainControl);
        skin.setOnClickListener(mainControl);

        // Set mainControl as the OnChangeListener for the seek bars
        redSeek.setOnSeekBarChangeListener(mainControl);
        greenSeek.setOnSeekBarChangeListener(mainControl);
        blueSeek.setOnSeekBarChangeListener(mainControl);



//Taken from the Android Studio page
// https://developer.android.com/develop/ui/views/components/spinner#java

// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hairstyles,
                android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        spinner.setAdapter(adapter);





//Handler idea from StackOverflow
        Handler seekBarHandler = new Handler();
        //SurfaceView surface = (SurfaceView) findViewById(R.id.faceView);

        //hair.setOnCheckedChangeListener(mainControl);
/**
 * COME BACK HERE: TODO - fix this
 */
//        if(hair.isChecked()){
//            face.currentSelected = R.id.hair;
//        }
//        if(eyes.isChecked()){
//            face.currentSelected = R.id.eyes;
//        }
//        if(skin.isChecked()){
//            face.currentSelected = R.id.skin;
//        }


//        if(hair.isChecked()){
//            //get the progress
//            redHair = this.getRed();
//            greenHair = this.getGreen();
//            blueHair = this.getBlue();
//
//            redSeek.setProgress(redHair);
//            greenSeek.setProgress(greenHair);
//            blueSeek.setProgress(blueHair);
//        }
//
//        if(eyes.isChecked()){
//            //get the progress
//            redEyes = this.getRed();
//            greenEyes = this.getGreen();
//            blueEyes= this.getBlue();
//
//            redSeek.setProgress(redEyes);
//            greenSeek.setProgress(greenEyes);
//            blueSeek.setProgress(blueEyes);
//        }
//
//        if(skin.isChecked()){
//            //get the progress
//            redSkin = this.getRed();
//            greenSkin = this.getGreen();
//            blueSkin= this.getBlue();
//
//            redSeek.setProgress(redSkin);
//            greenSeek.setProgress(greenSkin);
//            blueSeek.setProgress(blueSkin);
//        }

//        redSeek.setProgress(red);
//        greenSeek.setProgress(green);
//        blueSeek.setProgress(blue);

//        seekBar.setMax(0);
//        seekBar.setMax(max);
//        seekBar.setProgress(progress);
    }

    public int getRed() {
        return redSeek.getProgress();
    }
    public int getGreen() {
        return greenSeek.getProgress();
    }

    public int getBlue() {
        return blueSeek.getProgress();
    }

    public Activity getActivity(){
        return  this;
    }

    public void draw (Canvas canvas){

    }

    //Surface View stuff
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    //SeekBar stuff
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }

    @Override
    public void onClick(View v) {
        mainCanvas.invalidate();

    }
}