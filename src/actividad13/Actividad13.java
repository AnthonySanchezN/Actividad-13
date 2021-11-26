/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Intel
 */
public class Actividad13 {
    List<String> strings = new ArrayList<String>();
    
    public static void main(String[] args) {
        Actividad13 act = new Actividad13();
        act.loadStrings("Museo", "Social", "Digital", "Cerveza", "Telefono", "Levantar", "Gerente", "Joystick", "Oficial", "Pelusa");
        
        var sortLengthByAnonimousClass = act.sortLengthAnonimousClass();
        System.out.println("\n Length \n");
        System.out.println("\n Anonimus Class \n");
        act.showList(sortLengthByAnonimousClass);
        
        var sortLengthByLamda = act.sortLengthLamda();
        System.out.println("\n Lamda \n");
        act.showList(sortLengthByLamda);
        
        var sortLengthByReference = act.sortLengthReference();
        System.out.println("\n Reference \n");
        act.showList(sortLengthByReference);
        
        var sortAlphabeticalByAnonimousClass = act.sortAlphabeticalAnonimousClass();
        System.out.println("\n Alphabetical \n");
        System.out.println("\n Anonimous Class \n");
        act.showList(sortAlphabeticalByAnonimousClass);
        
        var sortAlphabeticalByLamda = act.sortAlphabeticalLamda();
        System.out.println("\n Lamda \n");
        act.showList(sortAlphabeticalByLamda);
        
        var sortAlphabeticalByReference = act.sortAlphabeticalReference();
        System.out.println("\n Reference \n");
        act.showList(sortAlphabeticalByReference);
        
        
        
    }
    
    public void loadStrings(String... strings){
        for(var string : strings) this.strings.add(string);
    }
    
    public List<String> sortLengthAnonimousClass(){
        List<String> strings = this.strings;
        strings.sort(new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                return str1.length() - str2.length();
            }
        });
        return strings;
    }
    
    public List<String> sortLengthLamda(){
        List<String> strings = this.strings;
        strings.sort((str1, str2) -> str1.length() - str2.length());
        return strings;
    }
    
    public List<String> sortLengthReference(){
        List<String> strings = this.strings;
        SortLength sortLength = new SortLength();
        strings.sort(sortLength::compare);
        return strings;
    }
    
    class SortLength implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().length() - o2.toString().length();
        }
        
    }
    
    public List<String> sortAlphabeticalAnonimousClass(){
        List<String> strings = this.strings;
        strings.sort(new Comparator<String>(){
            @Override
            public int compare(String str1, String str2) {
            return str1.compareToIgnoreCase(str2);
            }
        });
        return strings;
    }
    
    public List<String> sortAlphabeticalLamda(){
        List<String> strings = this.strings;
        strings.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        return strings;
    }
    
    public List<String> sortAlphabeticalReference(){
        List<String> strings = this.strings;
        SortAlphabetical sortAlphabetical = new SortAlphabetical();
        Collections.sort(strings, sortAlphabetical::compare);
        return strings;
    }
    
    class SortAlphabetical implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().compareToIgnoreCase(o2.toString());
        }
        
    }
    
    public void showList(List<String> strings){
        strings.forEach(System.out::println);
    }
    
    
    
   
}
