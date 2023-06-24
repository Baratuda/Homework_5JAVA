import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Map<String, List<String>> note = new HashMap<>();
      Scanner sc = new Scanner(System.in);
      ContactService.noteFiller(sc,note);
      ContactService.sortedNoteOutPuter(note);
   }
}

