package com.function.privates;

import java.io.File;

/**
 * Created by zeven on 12/20/2016.
 */
public class NameChange {
    public static void main(String argv[]){
        String s = "H:/sub";
        File f = new File(s);
        File [] listFiles = f.listFiles();
        for (File titlefile :
                listFiles) {
            for (int i =10; i <225 ; i++) {
                String str="";
                if (i<100)
                    str = "0";
                str+=i;
                if(titlefile.getName().contains(str)){
                    titlefile.renameTo(new File("H:/sub/[AU_RAW] Yu-Gi-Oh!DM "+str+" (DVDrip 480p x264_AC3).ass"));
                }
            }

        }
    }
}
