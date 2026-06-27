package phase1.collections;

import java.util.*;

/**
 * 【問題2 - 初級】Java 8以前の書き方をモダンな書き方に書き直す
 *
 * 下記 Java 8以前のコードを List.of / Set.of / Map.of / Map.ofEntries を使って
 * 書き直してください。
 */
public class Exercise2 {

    public static void main(String[] args) {

        // --- Java 8以前のコード（変更しないこと） ---
        List<String> oldList = Collections.unmodifiableList(
            Arrays.asList("Java", "Kotlin", "Scala")
        );

        Set<Integer> oldSet = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(2, 3, 5, 7, 11))
        );

        Map<String, Integer> tmp = new HashMap<>();
        tmp.put("January", 31);
        tmp.put("February", 28);
        tmp.put("March", 31);
        Map<String, Integer> oldMap = Collections.unmodifiableMap(tmp);

        System.out.println("oldList : " + oldList);
        System.out.println("oldSet  : " + oldSet);
        System.out.println("oldMap  : " + oldMap);

        // --- ここに Java 9以降の書き方で書き直す ---

        // TODO: newList を List.of で作成


        // TODO: newSet を Set.of で作成


        // TODO: newMap を Map.of で作成


        // 動作確認（oldXxx と同じ内容になることを確認）
        // System.out.println("newList : " + newList);
        // System.out.println("newSet  : " + newSet);
        // System.out.println("newMap  : " + newMap);
    }
}
