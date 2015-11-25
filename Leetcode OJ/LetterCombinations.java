import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

public class LetterCombinations{

    public static void main(String args[]){
        BufferedReader br = null;
        String input=null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a digit string: ");
            input = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        List<String> ans = letterCombinations(input);
        for(String s : ans){
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if(digits == null)
            return null;

        HashMap<Integer, Character[]> map = buildNumCharMap();
        List<String> returnValues = new ArrayList<String>();
        //Base case
        if(digits.length() == 1){
            Character set[] = (Character [])map.get(digits.charAt(0) - '0');
            for(Character c : set)
                returnValues.add(Character.toString(c));
            return returnValues;
        }
        
        //Recursive call
        List<String> childList = letterCombinations(digits.substring(1));
        Character set[] = (Character [])map.get(digits.charAt(0) - '0');
        for(Character c : set){
            for(String str : childList){
                returnValues.add(Character.toString(c) + str);
            }
        }
        return returnValues;
    }

    
    public static HashMap<Integer, Character[]> buildNumCharMap(){
        HashMap<Integer, Character[]> map = new HashMap<Integer, Character[]>();
        int curr_char_start = 97;
        for(int i=2;i<=9;i++){
            if(i==7 || i==9){
                Character c[] = new Character[4];
                for(int j=0;j<4;j++)
                    c[j] = (char)(curr_char_start+j);
                curr_char_start += 4;
                map.put(i, c);
            }
            else{
                Character c[] = new Character[3];
                for(int j=0;j<3;j++)
                    c[j] = (char)(curr_char_start+j);
                curr_char_start += 3;
                map.put(i, c);
            }
        }
        return map;
    }
}