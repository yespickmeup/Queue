/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

/**
 *
 * @author Guinness
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Voice1 {

    private static final String VOICENAME = "mbrola_us1";

    public static void main(String[] args) {
//        Number zero zero zero one... please proceed to counter number two, Thank you!!!...
        System.setProperty("mbrola.base", "C:\\Users\\Guinness\\Documents\\apps\\lib\\MBrola\\");
        Voice voice;
        // Taking instance of voice from VoiceManager factory.
        VoiceManager voiceManager = VoiceManager.getInstance(); 
        voice = voiceManager.getVoice(VOICENAME);
        // Allocating voice
        voice.allocate();
        // word per minute
        voice.setRate(150);
        voice.setPitch(150);
        System.out.print("Enter your text: ");
        // open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            // Ready to speak
            voice.speak(br.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
