import java.util.*;

public class LOTTO {
    public static void main(String args[]) {
        ArrayList<Integer> lotto = new ArrayList<>(6);
        for (int i = 0; i < 6; i++){ // 6�� �̱�
            int a = (int)(Math.random()*45)+1; // 1 ~ 45
            lotto.add(a); // lotto ArrayList�� �߰��Ѵ�.
        }
        System.out.println(lotto);
    }
}