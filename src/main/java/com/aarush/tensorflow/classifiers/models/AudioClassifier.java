package com.aarush.tensorflow.classifiers.models;

import java.awt.image.BufferedImage;
import java.io.File;

public interface AudioClassifier extends AudioEncoder {
    String[] labels = new String[]{

            "blues", "classical", "country", "disco", "hiphop", "jazz", "metal",
            "pop", "reggae", "rock"

    };

    String predict_image(BufferedImage image);

    String predict_audio(File f);

    default String predict_image(BufferedImage image, int imgWidth, int imgHeight) {

    	System.out.println("Buffered image: " + image); 
        float[] predicted = encode_image(image, imgWidth, imgHeight);
        
        System.out.println("encode image: " + encode_image(image, imgWidth, imgHeight));
        
        if(predicted != null) {
            int nlabels = predicted.length;
            System.out.println("Predicted leangth: " + predicted.length); 
            int argmax = 0;
            float max = predicted[0];
            for (int i = 1; i < nlabels; ++i) {
                if (max < predicted[i]) {
                	System.out.println("Predicted " + i + predicted[i]);
                    max = predicted[i];
                    argmax = i;
                }
            }

            return labels[argmax];
        }

        return "unknown";
    }
}
