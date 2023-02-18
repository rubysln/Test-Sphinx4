package sphinxService;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;
import java.io.IOException;

public class Sphinx {
  private Configuration configuration = new Configuration();


  public Sphinx(String choiceLanguage){
    switch (choiceLanguage){
      case "en":
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        break;
      case "ru":
        // Будет добавлена русская библиотека
        // ...
    }
  }

  public void startRecording() throws IOException {
    LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
    recognizer.startRecognition(true);
    SpeechResult result;
    while ((result = recognizer.getResult()) != null) {
      for(WordResult word : result.getWords()) {
        System.out.println(word);
      }
    }
    recognizer.stopRecognition();
  }
}
