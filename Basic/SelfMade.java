import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class SelfMade {

    public static void main(String[] args) {
        HashMap<Integer, Work> map1 = new HashMap<Integer, Work>();
        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        int i = 0;
        System.out.printf("Please fill out the schedule.\n\n");
        Scanner s = new Scanner(System.in);
        
        while(true){
            System.out.printf("Q: Exit || L: Look || W: write || R: remove || T: EndList ==>  ");
            String input = s.nextLine().trim();
            if (input.equals("Q")){
                System.out.println("Exit the program");
                break;
            }else if (input.equals("L")){
                if(map1.isEmpty() == false){
                    for (Integer j : map1.keySet()){
                        Work w = map1.get(j);
                        System.out.println(j + ". " + w.content);
                    }    
                }else{
                    System.out.println("There is currently no schedule.");
                }
                continue;
            }else if (input.equals("W")){
                System.out.println("This is where you create a schedule.");
                System.out.println("====================================");
                System.out.println("Enter qq to Exit");
                while(true){
                    System.out.print("Schedule : ");
                    String content = s.nextLine().trim();
                    if (content.equals("qq")){
                        System.out.println("====================================");
                        break;
                    }else{
                        if(!content.equals("")){
                            map1.put(++i, new Work(content));        
                        }else{
                            System.out.println("You cannot enter an empty value.");  
                        }
                    }
                }
            }else if (input.equals("R")){
                System.out.println("This is where you clear the completed schedule.");
                System.out.println("====================================");
                System.out.println("Enter 1001 to Exit");
                while(true){
                    System.out.print("enter the number to remove : ");
                    int re = s.nextInt();
                    if(re == 1001){
                        break;
                    }else{
                        if(map1.isEmpty() == false){
                            if (map1.containsKey(re) == true){
                                Work w2 = map1.get(re);
                                map2.put(re, strSum(w2.content));
                                map1.remove(re);
                            }else{
                                System.out.println("There is no schedule for the selected item.");
                            }
                        }else{
                            System.out.println("There is no data to delete."); 
                        }
                    }
                }
            }else if(input.equals("T")){
                if(map2.isEmpty() == true){
                    System.out.printf("\n\nThere is no data to verify.\n");
                }
                System.out.println("Success List");
                System.out.println("==========================");
                for(Integer k : map2.keySet()){
                    String w3 = map2.get(k);
                    System.out.println(k + ". " + w3);
                }
                System.out.printf("\n\nProgress\n");
                System.out.println("==========================");
                for (Integer u : map1.keySet()){
                    Work w4 = map1.get(u);
                    System.out.println(u + ". " + w4.content);
                }
            }
        }
    }
    static String strSum(String str){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
        String timer = formatter.format(today);
        return str + " || EndTime = [" + timer + "]";
    }
}

class Work{
    String content;
    Work(String content){
        this.content = content;
    }
}