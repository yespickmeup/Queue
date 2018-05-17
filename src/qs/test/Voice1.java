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
import com.sun.speech.freetts.VoiceManager;

public class Voice1 {

    public static void main(String[] args) {

        System.setProperty("mbrola.base", "C:\\Users\\Guinness\\Documents\\apps\\lib\\mbrola\\mbrola");

//        VoiceManager voiceManager = VoiceManager.getInstance();
//        Voice[] voices = voiceManager.getVoices();
//        for (int i = 0; i < voices.length; i++) {
//            System.out.println("    " + voices[i].getName()
//                    + " (" + voices[i].getDomain() + " domain)");
//        }

        String voiceName = "mbrola_us1"; // the only usable general purpose voice
        VoiceManager voiceManager = VoiceManager.getInstance();
        com.sun.speech.freetts.Voice voice = voiceManager.getVoice(voiceName);
        voice.allocate();
        voice.speak("hello sir.");
        voice.speak("how are you today");
        voice.deallocate();
    }

}
