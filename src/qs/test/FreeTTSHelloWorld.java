/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.test;

import guru.ttslib.TTS;

/**
 *
 * @author Guinness
 */
public class FreeTTSHelloWorld {

    static TTS tts;

    public static void main(String[] args) {
        System.setProperty("mbrola.base", "C:\\Users\\Guinness\\Documents\\apps\\lib\\mbrola");

        tts = new TTS("us1");
       
        tts.speak("Welcome");
      
       
    }
}
