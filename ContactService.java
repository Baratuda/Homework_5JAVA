import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//Вспомогательный метод, который разделяет введенную в консоли строку на имя контакта и его номер и передает главному методу массив с этими значениями, и при
// попадании слова 'Exit' отправляет в главный метод массив в котором первый элемент является словом 'EXIT'
public class ContactService{
   private static String[] inputMethod(String input) {
        String[] arrayInpts = new String[3];
        if(input.equals("Exit")) arrayInpts[0] = "Exit";
        else arrayInpts = input.split(" ", 2);
        return arrayInpts;
    }
   //Метод который проверяет существования такого имени контакта и при нахождении добавляет этому контакту еще один номер
    private static void addContact(Map<String, List<String>> note,String[] inputArray) {
      List<String> listPnobenumbers = new ArrayList<>();
      if(!note.containsKey(inputArray[0])) {
         listPnobenumbers.add(inputArray[1]);
         note.put(inputArray[0], listPnobenumbers);
      }
      else {
         listPnobenumbers = note.get(inputArray[0]);
         listPnobenumbers.add(inputArray[1]);
         note.put(inputArray[0],listPnobenumbers);
      }
    }

    //Заполняет мапу значениями Имя пользователь и номерами телефонов пока не будет найдено слово exit.
    public static void noteFiller(Scanner sc,Map<String, List<String>> note) {
      while (true) {
            System.out.println("Для прекращения ввод контактов введите 'Exit'");
            System.out.println("Введите имя контакта и номер контакта: ");
            String[] inputArray = inputMethod(sc.nextLine());
            if (inputArray[0].equals("Exit")) break;
            else addContact(note,inputArray);
        }
    }
    
    public static void sortedNoteOutPuter(Map<String, List<String>> note){
       List<Contact> keys = new ArrayList<>();
       String name = "";
       //Преобразование HashMAp в список Contact для дальнейше сортировки.
       for (Map.Entry<String, List<String>> entry : note.entrySet()) 
         keys.add(new Contact(entry.getKey(), entry.getValue()));
       //Сортировка списка  
       Collections.sort(keys,Comparator.comparing(Contact::countPhoneNumber));
       //Вывод результатов.
       for (int i = keys.size()-1; i>=0; i--){
         name = keys.get(i).getName();
         System.out.println(name+" : "+note.get(name));
       }
         
       }
    }
