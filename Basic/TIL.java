import java.util.Arrays;
import java.util.Scanner;

public class TIL {

    public static void main(String args[]) {
        System.out.println("test => class value = " + test.zz); // static ������ �ν��Ͻ� ���� ���� ��� ����
        test2 a = new test2(1,2,3,4); // test2 �ν��Ͻ� ���� �� (1,2,3,4)�� �ʱ�ȭ �ϰ� �� �ּҸ� ���� ���� a�� ����
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
        test2 cc = func(a); // (��: �ּ� 0X900)
        // �ν��Ͻ��� �������� �ʾ����� �ּҰ����� �������ִ� �ν��Ͻ��� ����Ų��.
        System.out.println("a.x = "+a.x);
        System.out.println("cc.x = "+cc.x);
        System.out.println("test0 class���� ���� �迭 0��° �� = " +  test0.newarr[0]);
        System.out.println("String �� equals ����� ��� = " + a.pppee());
        System.out.println("test0���� ���� �迭�� ���¸� �����ּ��� = "+ a.getarr());
        
        // ================================================================
        // Scanner ����ؼ� ���� �Է¹ޱ� 
         System.out.printf("���ϴ� ���ڸ� �Է����ּ���. ");
         Scanner scanner = new Scanner(System.in);
         int xx = scanner.nextInt();
         int resultss = 0;
         for(int i = 1; i <= xx; i++){
             resultss = resultss + i;
         }
         System.out.println("�ۼ� �Ͻ� ������ ���丮�� " + resultss);
        // ================================================================
        
        over h = new over();
        h.adder(1,'A');
        h.pick('a');
        h.pick2('a');
        h.adder(1, 1L);
        h.adder(1, 4.4);
    }
    static test2 func(test2 a){ // ������ �Ű�����
        test2 newtest = new test2(); // test2 �ν��Ͻ� ���� (��: �ּ� 0X900)
        newtest.x = a.x; // a.x���� newtest.x���� �����Ͽ� �ʱ�ȭ �Ѵ�.
        return newtest; // newtest �ּҰ��� ��ȯ�Ѵ�. (��: �ּ� 0X900)
    }
    static void func2(int x){ // �⺻�� �Ű�����
        test2 newtest2 = new test2();
        newtest2.x = 100000;
        System.out.println("newtest2.x = " + newtest2.x);
    }
}



class over{ // �����ε� �� ����ȯ
    // ũ�Ⱑ ū Ÿ������ ��ȯ�ȴ�.
    // int �ؿ��� int Ÿ������ ��ȯ�ȴ�.
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
        int result = a + (int)b; // �ƽ�Ű�ڵ�
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
        if(this.ch.equals(this.tt)){ // ���ڿ� ��
            return true;
        }
        return false;
    }
}

class etc{ // ������ ���� class
    int iv; // �ڵ� �ʱ�ȭ
    static int ev; // �ڵ� �ʱ�ȭ
    
    static{ // static ������ �ʱ�ȭ
        ev = 3;
    }
    etc(){this(0);}
    etc(int iv){
        this.iv = iv;
    }
    
    void gg(){
        System.out.println("�ν��Ͻ� ���� iv = "+ iv + "Ŭ���� ���� ev = " + ev + "����� �ƴ� �������� ���� ��");
    }
    
}
class test0/*extends Object*/{ // ����� ���� class�� extends Object�� �����ִ�.
    int qq; // �ν��Ͻ� ����
    static int[] newarr = new int[10]; // 10ĭ ¥�� �迭 Ŭ���� ���� ����
    
    static { // static ���� �ʱ�ȭ
        for (int i =0; i < newarr.length; i++){
            newarr[i] = (int)(Math.random()*10)+1; // 1~10 �����ϰ� �迭�� �ִ´�.
        }
    }
    test0(){ // �����ڸ� ����ؼ� �ν��Ͻ� ���� �ʱ�ȭ
        this(0);
    }
    test0(int qq){ // �����ڸ� ����ؼ� �ν��Ͻ� ���� �ʱ�ȭ
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
    test(){ // �⺻ ������
        this(0,0,0); // this ������ 
    }
    test(int qq, int x, int y){ // ������
        super(qq);
        this.x/*�������� this*/ = x;
        this.y = y;
    }
    String getAll(){ // �������̵�
        return "x = " + this.x + " y = " + this.y + "qq = " + super.qq /*�������� super*/;
    }
    static int addd(int x, int y, int z){
        return x+y+z;
    }
}

class test2 extends test/*���*/{
    stringtest ppp = new stringtest("abc", "abc");
    etc aaa = new etc(45); // ���� etc �ν��Ͻ� ���� �� 45�� �ʱ�ȭ�ϰ� �������� aaa�� �ּҸ� �����Ѵ�.
    int z; // �ڵ��ʱ�ȭ
    test2(){
        this(0,0,0,0);
    }
    test2(int qq, int x, int y, int z){ // ������ ����� ������ �ʱ�ȭ
        super(qq, x, y); // super ������
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
    
    void getAll2(int x){ // �����ε�
        System.out.println("�����ε� �� ���" + super.x);
    }
    void aaagg(){
        aaa.gg();
    }
    
    boolean pppee(){
        return ppp.ee();
    }
}