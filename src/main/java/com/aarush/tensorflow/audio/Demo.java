package com.aarush.tensorflow.audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aarush.tensorflow.classifiers.models.cifar10.Cifar10AudioClassifier;

public class Demo {
	public static void main(String[] args) {
		Cifar10AudioClassifier classifier = new Cifar10AudioClassifier();
		try {
			classifier.load_model();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> paths = getAudioFiles();

		Collections.shuffle(paths);

		for (String path : paths) {
			System.out.println("Predicting " + path + " ...");
			File f = new File(path);
			String label = classifier.predict_audio(f);

			System.out.println("Predicted: " + label);
		}
	}

	private static List<String> getAudioFiles() {
		List<String> list = new ArrayList<String>();
		list.add("C:\\Users\\mehav\\Downloads\\jazz.mp3");

		return list;
	}
}
