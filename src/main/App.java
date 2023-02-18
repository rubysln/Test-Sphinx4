import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import sphinxService.Sphinx;

public class App {
  public static void main(String args[]) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Выберите язык: RU/EN");
    String language = bf.readLine().toLowerCase();

    if(!(language.equals("ru") || language.equals("en"))){
      System.out.println("Вы ввели неверный язык!");
    }
    else{
      Sphinx sphinx = new Sphinx(language);
      sphinx.startRecording();
    }
  }
}
