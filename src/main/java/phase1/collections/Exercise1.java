package phase1.collections;

import java.util.*;

/**
 * 【問題1 - 初級】エラー箇所を見つけて修正する
 *
 * 下記コードにはコンパイルエラーまたは実行時例外が発生する箇所が3つあります。
 * (A)(B)(C) それぞれ何が問題か、コメントで説明してから修正してください。
 */
public class Exercise1 {

    public static void main(String[] args) {

        // (A) 問題あり → 何が問題？コメントに書いてから修正
        List<String> list = List.of("Tokyo", null, "Osaka");

        // (B) 問題あり → 何が問題？コメントに書いてから修正
        Set<Integer> set = Set.of(1, 2, 3, 2);

        // (C) 問題あり → 何が問題？コメントに書いてから修正
        Map<String, Integer> map = Map.of("a", 1, "b", 2);
        map.put("c", 3);

        System.out.println("list : " + list);
        System.out.println("set  : " + set);
        System.out.println("map  : " + map);
    }
}
