package up.CS301.jeppesen_facemaker;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class faceController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener {


    private weDraw mainView;
    private Face faceMain;

    private TextView redLabel;
    private TextView greenLabel;
    private TextView blueLabel;

    //private Activity activity;

    //so we can use the main cakeview and not make a new object off it.
    public faceController(weDraw initFaceView, Activity myActivity){
        mainView = initFaceView;
        faceMain = mainView.getFace();
        redLabel = myActivity.findViewById(R.id.red);
        greenLabel = myActivity.findViewById(R.id.green);
        blueLabel = myActivity.findViewById(R.id.blue);
    }

    @Override
    public void onClick(View v) {
       // Log.d("cake", "click!");

        if(v == mainView.findViewById(R.id.hair)){
            faceMain.currentSelected = R.id.hair;
            Log.d("hair", "click!");
        }else if(v == mainView.findViewById(R.id.eyes)){
            faceMain.currentSelected = R.id.eyes;
        }
        mainView.invalidate();
//ViewPostIme pointer 1
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView == mainView.findViewById(R.id.hair)){
            faceMain.currentSelected = R.id.hair;
        }else if(buttonView == mainView.findViewById(R.id.eyes)){
            faceMain.currentSelected = R.id.eyes;
        }

        mainView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        //faceMain.red = progress;
        //this.updateColor();
        if(seekBar.getId() == R.id.numRed) {
            faceMain.red = progress;
            this.updateColor();
        }
        else if(seekBar.getId() == R.id.numGreen){
            faceMain.green = progress;
        }
        else if(seekBar.getId() == R.id.numBlue){
            faceMain.blue = progress;
        }
        int c = Color.rgb(faceMain.red, faceMain.green, faceMain.blue);

        if(mainView.findViewById(R.id.hair).isPressed()) {
            faceMain.setHairColor(c);
        }
        else if(mainView.findViewById(R.id.skin).isPressed()){
            faceMain.setSkinColor(c);
        }
        else if(mainView.findViewById(R.id.eyes).isPressed()){
            faceMain.setEyeColor(c);
        }
            mainView.invalidate();

    }



    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }

    public void updateColor(){
        this.redLabel.setText("Red:" + " " + faceMain.red);
    }
}
