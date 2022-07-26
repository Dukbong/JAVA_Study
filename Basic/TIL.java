import java.util.Arrays;
import java.util.Scanner;

public class TIL {

    public static void main(String args[]) {
        System.out.println("test => class value = " + test.zz); // static 변수는 인스턴스 생성 없이 사용 가능
        test2 a = new test2(1,2,3,4); // test2 인스턴스 생성 후 (1,2,3,4)로 초기화 하고 그 주소를 참조 변수 a에 저장
        System.out.println("x = "+a.x);
        System.out.println("y = "+a.y);
        System.out.println("z = "+a.z);
        System.out.println("qq = "+a.qq);
        System.out.println(a.getAll());
        a.getAll2();
        a.getAll2(a.x);
        int result = a.addd(1,2,3);
        System.out.println("test => static method use = "+result);
        a.aaagg();
        func2(a.x);
        test2 cc = func(a); // (예: 주소 0X900)
        // 인스턴스를 생성하지 않았지만 주소값으로 생성되있는 인스턴스를 가르킨다.
        System.out.println("a.x = "+a.x);
        System.out.println("cc.x = "+cc.x);
        System.out.println("test0 class에서 만든 배열 0번째 값 = " +  test0.newarr[0]);
        System.out.println("String 비교 equals 사용한 결과 = " + a.pppee());
        System.out.println("test0에서 만든 배열의 형태를 보여주세요 = "+ a.getarr());
        
        // ================================================================
        // Scanner 사용해서 숫자 입력받기 
         System.out.printf("원하는 숫자를 입력해주세요. ");
         Scanner scanner = new Scanner(System.in);
         int xx = scanner.nextInt();
         int resultss = 0;
         for(int i = 1; i <= xx; i++){
             resultss = resultss + i;
         }
         System.out.println("작성 하신 숫자의 팩토리는 " + resultss);
        // ================================================================
        
        over h = new over();
        h.adder(1,'A');
        h.pick('a');
        h.pick2('a');
        h.adder(1, 1L);
        h.adder(1, 4.4);
    }
    static test2 func(test2 a){ // 참조형 매개변수
        test2 newtest = new test2(); // test2 인스턴스 생성 (예: 주소 0X900)
        newtest.x = a.x; // a.x값을 newtest.x값에 대입하여 초기화 한다.
        return newtest; // newtest 주소값을 반환한다. (예: 주소 0X900)
    }
    static void func2(int x){ // 기본형 매개변수
        test2 newtest2 = new test2();
        newtest2.x = 100000;
        System.out.println("newtest2.x = " + newtest2.x);
    }
}



class over{ // 오버로딩 및 형변환
    // 크기가 큰 타입으로 변환된다.
    // int 밑에는 int 타입으로 변환된다.
    int adder(int a, int b) {
        System.out.println("int adder(int a, int b) = " + a+b);
        return a+b;
    }
    long adder(int a, long b){
        System.out.println("long adder(int a, long b) = " + a+b);
        return a+b;
    }
    long adder(long a, long b){
        System.out.println("long adder(long a, long b) = " + a+b);
        return a+b;
    }
    int adder(int a, char b){
        int result = a + (int)b; // 아스키코드
        System.out.println("long adder(long a, char b) = " + result);
        return result;
    }
    double adder(int a, double b){
        System.out.println("double adder(int a, double b) = " + a+b);
        return a+b;
    }
    
    int pick(char c){
        System.out.println("pick(char c) = " + c + " Integer conversion = " + (int)c);
        return (int) c;
    }
    int pick2(char c){
        int result = c - '0';
        System.out.println("pick2(char c) = " + c + " char - '0' = " + result);
        return result;
    }
    
}

class stringtest {
    String ch;
    String tt;
    
    stringtest(){
        this("a","b");
    }
    stringtest(String ch, String tt){
        this.ch = ch;
        this.tt = tt;
    }
    
    boolean ee(){
        if(this.ch.equals(this.tt)){ // 문자열 비교
            return true;
        }
        return false;
    }
}

class etc{ // 포함을 위한 class
    int iv; // 자동 초기화
    static int ev; // 자동 초기화
    
    static{ // static 복잡한 초기화
        ev = 3;
    }
    etc(){this(0);}
    etc(int iv){
        this.iv = iv;
    }
    
    void gg(){
        System.out.println("인스턴스 변수 iv = "+ iv + "클래스 변수 ev = " + ev + "상속이 아닌 포함으로 만든 것");
    }
    
}
class test0/*extends Object*/{ // 상속이 없는 class는 extends Object가 숨어있다.
    int qq; // 인스턴스 변수
    static int[] newarr = new int[10]; // 10칸 짜리 배열 클래스 변수 생성
    
    static { // static 변수 초기화
        for (int i =0; i < newarr.length; i++){
            newarr[i] = (int)(Math.random()*10)+1; // 1~10 랜덤하게 배열에 넣는다.
        }
    }
    test0(){ // 생성자를 사용해서 인스턴스 변수 초기화
        this(0);
    }
    test0(int qq){ // 생성자를 사용해서 인스턴스 변수 초기화
        this.qq = qq;
    }
    
    String getarr(){
        return Arrays.toString(newarr);
    }
}


class test extends test0{
    int x;
    int y;
    static int zz = 1;
    test(){ // 기본 생성자
        this(0,0,0); // this 생성자 
    }
    test(int qq, int x, int y){ // 생성자
        super(qq);
        this.x/*참조변수 this*/ = x;
        this.y = y;
    }
    String getAll(){ // 오버라이딩
        return "x = " + this.x + " y = " + this.y + "qq = " + super.qq /*참조변수 super*/;
    }
    static int addd(int x, int y, int z){
        return x+y+z;
    }
}

class test2 extends test/*상속*/{
    stringtest ppp = new stringtest("abc", "abc");
    etc aaa = new etc(45); // 포함 etc 인스턴스 생성 후 45로 초기화하고 참조변수 aaa에 주소를 저장한다.
    int z; // 자동초기화
    test2(){
        this(0,0,0,0);
    }
    test2(int qq, int x, int y, int z){ // 생성자 사용한 복잡한 초기화
        super(qq, x, y); // super 생성자
        this.z = z;
    }
    
    String getAll(){
        return "x = " + super.x + " y = " + super.y + " z = " + this.z + " qq = " + super.qq;
    }
    void getAll2(){
        System.out.println("x = " + x);
        System.out.println("this.x = " + this.x);
        System.out.println("P x = " + super.x);
        System.out.println("P x = " + super.x);
        System.out.println("P qq = " + super.qq);
    }
    
    void getAll2(int x){ // 오버로딩
        System.out.println("오버로딩 한 결과" + super.x);
    }
    void aaagg(){
        aaa.gg();
    }
    
    boolean pppee(){
        return ppp.ee();
    }
}