import java.util.HashSet;
import java.util.Scanner;

public class selfRPGgame {

	public static void main(String[] args) {
        String[] Mlist = {"Java","Javascript","C++","Python","Golang","TS"};
        HashSet<Monster> Mset = new HashSet<Monster>();
        System.out.println("Game Start=============================");
        Scanner s = new Scanner(System.in);
        System.out.printf("enter a name ==> ");
        String name = s.nextLine();
        User u = new User(name);
        Loop1 : while(true){
            System.out.printf("1. Hunting || 2. Recovery || 3.Info ==> ");
            String str = s.nextLine();
            if(str.equals("1")){
                int Mi = (int)(Math.random()*Mlist.length);
                Monster mo = new Monster(Mlist[Mi]);
                System.out.printf("\n\n");
                System.out.println("=============FIGHT==============");
                System.out.println("Monster name = " + mo.name + " HP = " + mo.HP + " Power = " + mo.HitPoint);
                System.out.println("User name = " + u.name + " HP = " + u.HP + " Power = " + u.HitPoint);
                System.out.println("================================");
                System.out.printf("\n\n");
                while(true){
                    System.out.println("1. attack 2. Recovery 3. Run");
                    String str2 = s.nextLine();
                    if(str2.equals("1")){
                        System.out.println(u.name + " Attack!!!");
                        mo.HP = mo.HP - u.HitPoint;
                        if(mo.HP <= 0){
                            System.out.println("Monster Die..");
                            System.out.println("Power UP!!!!");
                            u.HitPoint = u.HitPoint + 2;
                            u.FullHP = u.FullHP + 10;
                            break;
                        }
                        System.out.println(mo.name + "Attack!!! [Damages : " + mo.HitPoint + "]");
                        u.HP = u.HP - mo.HitPoint;
                        if(u.HP <= 0){
                            System.out.println("Game Over");
                            break;
                        }
                    }else if(str2.equals("2")){
                        System.out.println("I've recovered myself.");
                        if(u.HP < u.FullHP){
                            u.HP = u.HP + 10;
                        }
                        System.out.println("The HP = " + u.HP);
                    }else if(str2.equals("3")){
                        if(u.HP > 5){
                            System.out.println("stamina Use!");    
                            System.out.println("Run!!!!!!!!!!!!!!!!!!!!!");
                            u.HP = u.HP-5;
                            break;
                        }else{
                            System.out.println("I don't have enough energy.");
                        }
                    }
                }
            }else if(str.equals("2")){
                if(u.HP + 4 < u.FullHP){
                    u.HP = u.HP + 4;
                }else{
                    System.out.println("HP is sufficient.");
                }
            }else if(str.equals("3")){
                System.out.println(u.info());
            }
        }
    }
}

abstract class Unitinfo{
    String name;
    int HP;
    int HitPoint;
    
    Unitinfo(String name){
        this.name = name;
        HP = (int)(Math.random()*100) + 75;
    }
    abstract int Hit();
}

class User extends Unitinfo{
    int Experience;
    int FullHP;
    User(String name){
        super(name);
        Experience = 40;
        HitPoint = Hit();
        FullHP = HP;
    }
    
    public int Hit(){
        return (int)(Math.random()*10) + 1;
    }
    
    public String info(){
        return "name = " + name + " FullHP = " + FullHP + " HP = " + HP + " HitPoint = " + HitPoint; 
    }
}

class Monster extends Unitinfo{
    Monster(String name){
        super(name);
        HitPoint = Hit();
    }
    
    public int Hit(){
        return (int)(Math.random()*10) + 1;
    }
}