/*
* 작성자 : 지소민
* 작성일 : 2024-07-19
* 작성목적 : 병원관리프로그램 - Sort
* 작성환경 : MacBook Pro 13
*          JDK
*          Intellij
* */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    private List<Hospital> list;

    public Sort(List<Hospital> list) {
        this.list = list;
    }

    public void quickSort() {
        Collections.sort(this.list, new Comparator<Hospital>() {
            @Override
            public int compare(Hospital h1, Hospital h2) {
                return Integer.compare(h1.getNum(), h2.getNum());
            }
        });
    }
}
