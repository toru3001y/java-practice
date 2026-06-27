package phase1.collections;

import java.util.*;

/**
 * Java 9 不変コレクション（List.of / Set.of / Map.of）デモ
 *
 * 学習ポイント:
 *   1. Java 8以前の書き方 vs Java 9以降の書き方
 *   2. List.of / Set.of / Map.of の基本
 *   3. 3つの制約：null不可 / 変更不可 / 重複不可（Set/Map）
 *   4. Map.ofEntries と Map.entry による大きなMapの作成
 */
public class ImmutableCollectionsDemo {

    public static void main(String[] args) {
        section1_beforeJava9();
        section2_listOf();
        section3_setOf();
        section4_mapOf();
        section5_mapOfEntries();
        section6_constraints();
    }

    // =========================================================
    // セクション1: Java 8以前の書き方（比較用）
    // =========================================================
    static void section1_beforeJava9() {
        System.out.println("=== Java 8以前: 不変コレクションの作り方 ===");

        // 不変List（2ステップ必要）
        List<String> oldList = Collections.unmodifiableList(
            Arrays.asList("apple", "banana", "cherry")
        );

        // 不変Set（3ステップ必要）
        Set<String> oldSet = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList("red", "green", "blue"))
        );

        // 不変Map（匿名クラスで初期化ブロックを使う"ダブルブレース初期化"は
        // メモリリークの懸念があり、アンチパタームとされていた）
        Map<String, Integer> oldMap = Collections.unmodifiableMap(
            new HashMap<String, Integer>() {{
                put("one", 1);
                put("two", 2);
                put("three", 3);
            }}
        );

        System.out.println("oldList  : " + oldList);
        System.out.println("oldSet   : " + oldSet);
        System.out.println("oldMap   : " + oldMap);
        System.out.println();
    }

    // =========================================================
    // セクション2: List.of（Java 9）
    // =========================================================
    static void section2_listOf() {
        System.out.println("=== Java 9: List.of ===");

        // 基本形: 要素を並べるだけ
        List<String> fruits = List.of("apple", "banana", "cherry");
        System.out.println("fruits      : " + fruits);
        System.out.println("size        : " + fruits.size());
        System.out.println("get(1)      : " + fruits.get(1));
        System.out.println("contains    : " + fruits.contains("banana"));

        // 空のList
        List<String> empty = List.of();
        System.out.println("empty       : " + empty);

        // 数値のList（ジェネリクスで型推論される）
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        System.out.println("numbers     : " + numbers);

        // 順序は保証される（Listなのでインデックスアクセス可能）
        System.out.println("numbers[2]  : " + numbers.get(2));
        System.out.println();
    }

    // =========================================================
    // セクション3: Set.of（Java 9）
    // =========================================================
    static void section3_setOf() {
        System.out.println("=== Java 9: Set.of ===");

        Set<String> colors = Set.of("red", "green", "blue");
        System.out.println("colors      : " + colors);
        System.out.println("size        : " + colors.size());
        System.out.println("contains    : " + colors.contains("red"));

        // 注意: Set.ofは順序を保証しない（実行ごとに出力順が変わりうる）
        // → 繰り返し処理でのみ使い、インデックスアクセスは不要
        System.out.println("※ Setなのでインデックスアクセス不可");

        // 空のSet
        Set<Integer> emptySet = Set.of();
        System.out.println("emptySet    : " + emptySet);
        System.out.println();
    }

    // =========================================================
    // セクション4: Map.of（Java 9） ※最大10エントリまで
    // =========================================================
    static void section4_mapOf() {
        System.out.println("=== Java 9: Map.of ===");

        // キーと値を交互に渡す（最大10ペアまで）
        Map<String, Integer> scores = Map.of(
            "Alice", 95,
            "Bob",   80,
            "Carol", 88
        );
        System.out.println("scores      : " + scores);
        System.out.println("Alice       : " + scores.get("Alice"));
        System.out.println("size        : " + scores.size());

        // containsKey / containsValue
        System.out.println("hasAlice    : " + scores.containsKey("Alice"));
        System.out.println("has95       : " + scores.containsValue(95));

        // keySet / values / entrySet でのイテレーション
        System.out.println("keys        : " + scores.keySet());
        System.out.println("values      : " + scores.values());
        System.out.println();
    }

    // =========================================================
    // セクション5: Map.ofEntries（Java 9） ※10エントリ超に対応
    // =========================================================
    static void section5_mapOfEntries() {
        System.out.println("=== Java 9: Map.ofEntries + Map.entry ===");

        // Map.of は最大10ペアまで。11ペア以上はMap.ofEntriesを使う
        Map<String, String> capitals = Map.ofEntries(
            Map.entry("Japan",   "Tokyo"),
            Map.entry("France",  "Paris"),
            Map.entry("Germany", "Berlin"),
            Map.entry("Italy",   "Rome"),
            Map.entry("Spain",   "Madrid"),
            Map.entry("UK",      "London"),
            Map.entry("USA",     "Washington D.C."),
            Map.entry("Canada",  "Ottawa"),
            Map.entry("Brazil",  "Brasília"),
            Map.entry("India",   "New Delhi"),
            Map.entry("China",   "Beijing")  // ← 11エントリ目（Map.ofでは不可）
        );

        System.out.println("capitals size : " + capitals.size());
        System.out.println("Japan         : " + capitals.get("Japan"));
        System.out.println("France        : " + capitals.get("France"));
        System.out.println();
    }

    // =========================================================
    // セクション6: 3つの制約の確認
    // =========================================================
    static void section6_constraints() {
        System.out.println("=== 3つの制約 ===");

        // 制約1: 変更不可（UnsupportedOperationException）
        List<String> list = List.of("a", "b", "c");
        try {
            list.add("d");  // 追加しようとすると例外
        } catch (UnsupportedOperationException e) {
            System.out.println("[制約1] add()は不可: UnsupportedOperationException");
        }
        try {
            list.set(0, "z");  // 変更も不可
        } catch (UnsupportedOperationException e) {
            System.out.println("[制約1] set()も不可: UnsupportedOperationException");
        }

        // 制約2: null不可（NullPointerException）
        try {
            List<String> nullList = List.of("a", null, "c");
        } catch (NullPointerException e) {
            System.out.println("[制約2] nullは不可: NullPointerException");
        }

        // 制約3: Set/Mapでの重複不可（IllegalArgumentException）
        try {
            Set<String> dupSet = Set.of("apple", "banana", "apple");  // 重複!
        } catch (IllegalArgumentException e) {
            System.out.println("[制約3] Set重複は不可: IllegalArgumentException");
        }
        try {
            Map<String, Integer> dupMap = Map.of("key", 1, "key", 2);  // キー重複!
        } catch (IllegalArgumentException e) {
            System.out.println("[制約3] Mapキー重複も不可: IllegalArgumentException");
        }

        System.out.println();

        // ※ 変更したい場合は、可変コレクションにコピーする
        System.out.println("--- 変更したい場合のパターン ---");
        List<String> immutable = List.of("a", "b", "c");
        List<String> mutable = new ArrayList<>(immutable);  // ArrayListにコピー
        mutable.add("d");
        System.out.println("コピー後に追加: " + mutable);
    }
}
