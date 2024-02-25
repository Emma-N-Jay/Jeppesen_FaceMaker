package up.CS301.jeppesen_facemaker;


/**
 * @Author Emma Jeppesen
 * Date:2/22/24
 */

import static android.graphics.Color.rgb;

import kotlin.random.Random;

public class Face {

   //Eye variables
    public int eyeColor;
    public int eyeRed;
    public int eyeGreen;
    public int eyeBlue;

    //Hair variables
    public int hairColor;
    public int hairRed;
    public int hairGreen;
    public int hairBlue;
    int hairStyle;

    //Skin variables
    public int skinColor;
    public int skinR;
    public int skinG;
    public int skinB;


    //color instance variables
    int red;
    int green;
    int blue;

//Store which button is selected
    int currentSelected = R.id.hair;

//ctor with a randomize
    public Face(){
        this.randomize();
    }


//Gives previous values a random number
void randomize(){

    //randomizes skin
    this.skinR = Random.Default.nextInt(255);
    this.skinG = Random.Default.nextInt(255);
    this.skinB = Random.Default.nextInt(255);
    skinColor = rgb(skinR, skinG, skinB);


    //randomizes eyes
    this.eyeRed = Random.Default.nextInt(255);
    this.eyeGreen = Random.Default.nextInt(255);
    this.eyeBlue = Random.Default.nextInt(255);
    eyeColor = rgb(eyeRed, eyeGreen, eyeBlue);

    //randomizes hair
    this.hairRed = Random.Default.nextInt(255);
    this.hairGreen = Random.Default.nextInt(255);
    this.hairBlue = Random.Default.nextInt(255);
    hairColor = rgb(hairRed, hairGreen, hairBlue);

    this.hairStyle = Random.Default.nextInt(4);
}


    //set colors
    public void setHairColor(int x) { this.hairColor = x;}
    public void setEyeColor(int x) {this.eyeColor = x;}
    public void setSkinColor(int x) {this.skinColor = x;}
    public void setHairStyle(int x) {this.hairStyle = x;}

}
