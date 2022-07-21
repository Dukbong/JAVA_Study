import java.util.*;

public class LOTTO {
    public static void main(String args[]) {
        ArrayList<Integer> lotto = new ArrayList<>(6);
        for (int i = 0; i < 6; i++){ // 6개 뽑기
            int a = (int)(Math.random()*45)+1; // 1 ~ 45
            lotto.add(a); // lotto ArrayList에 추가한다.
        }
        System.out.println(lotto);
    }
}