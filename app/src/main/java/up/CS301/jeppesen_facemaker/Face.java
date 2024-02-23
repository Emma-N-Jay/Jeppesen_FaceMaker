package up.CS301.jeppesen_facemaker;


/**
 * @Author Emma Jeppesen
 * Date:2/14/24
 */

import kotlin.random.Random;

public class Face {
   //instance variables
    int eyeColor;
    int hairColor;
    // identifies which hair style the face has.
    int hairStyle;
    int skinColor;

    //instance variables
    int red;
    int green;
    int blue;

    int currentSelected = R.id.hair;
    boolean hair = true;
    boolean eyes = false;
    boolean skin = false;


    public Face(){
        this.randomize();
    }


//Gives previous values a random number
void randomize(){
eyeColor = Random.Default.nextInt();
hairStyle = Random.Default.nextInt();
hairColor =Random.Default.nextInt();
}
void onDraw(){

 }

public int getEyeColor(int eColor){
   this.eyeColor=eColor;
    return eColor;
}

public int getHairColor(int hColor){
    this.hairColor=hColor;
    return hColor;
}

public int getHairStyle(int hStyle){
    this.hairStyle=hStyle;
    return hStyle;
}

//get colors
    public int getHairColor() { return this.hairColor;}
    public int getSkinColor() { return this.skinColor;}
    public int getEyeColor() { return this.eyeColor;}

    //set colors
    public void setHairColor(int x) { this.hairColor = x;}
    public void setEyeColor(int x) {this.eyeColor = x;}
    public void setSkinColor(int x) {this.skinColor = x;}

}
