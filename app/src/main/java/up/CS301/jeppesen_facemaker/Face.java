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


}
