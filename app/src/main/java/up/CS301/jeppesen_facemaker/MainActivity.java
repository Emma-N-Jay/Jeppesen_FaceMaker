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
 * Date:2/22/24
 */
public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback, SeekBar.OnSeekBarChangeListener, View.OnClickListener {



    //find the seek bars
    public SeekBar redSeek;
    public SeekBar greenSeek;
    public SeekBar blueSeek;


    //find buttons
    public RadioButton hair;
    public RadioButton eyes;
    public RadioButton skin;
    public Button randFace;
    public Spinner hairSpin;

    //get the canvas and instance of a face
    private weDraw mainCanvas;
   private Face face;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the surface view
        mainCanvas = findViewById(R.id.faceView);
        face = mainCanvas.getFace();



        // Create an instance of faceController
        faceController mainControl = new faceController(mainCanvas, this);

        //update the color based on the random face generated on start
        mainControl.updateColor();

        //find seek bars
        redSeek = findViewById(R.id.numRed);
        greenSeek = findViewById(R.id.numGreen);
        blueSeek = findViewById(R.id.numBlue);

        //find buttons
        hair = findViewById(R.id.hair);
        eyes = findViewById(R.id.eyes);
        skin = findViewById(R.id.skin);
        randFace = findViewById(R.id.randomFace);


        //Getting the instance of Spinner
        hairSpin = findViewById(R.id.hairselector);

        // Set mainControl as the OnClickListener for the buttons
        hair.setOnClickListener(mainControl);
        eyes.setOnClickListener(mainControl);
        skin.setOnClickListener(mainControl);
        randFace.setOnClickListener(mainControl);

        // Set mainControl as the OnChangeListener for the seek bars
        redSeek.setOnSeekBarChangeListener(mainControl);
        greenSeek.setOnSeekBarChangeListener(mainControl);
        blueSeek.setOnSeekBarChangeListener(mainControl);

        /**
         External Citation
         Date: 15 February 2024
         Problem: Didn't know how to populate a spinner
         Resource: https://developer.android.com/develop/ui/views/components/spinner#java
         Solution: Modified some example code from Android documentation
         */
// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.hairstyles,
                android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        hairSpin.setAdapter(adapter);

        //Set main control as OnItemSelectedListener for the spinny boi
        hairSpin.setOnItemSelectedListener(mainControl);
    }



    //Listener Methods
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