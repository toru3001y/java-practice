package phase1.collections;

import java.util.*;

/**
 * 【問題3 - 中級】Map.ofEntries で月ごとの日数Mapを作り、30日の月だけ取り出す
 *
 * 要件:
 *   1. Map.ofEntries + Map.entry を使って、12ヶ月の日数を持つ不変Mapを作成する
 *      1月:31, 2月:28, 3月:31, 4月:30, 5月:31,  6月:30
 *      7月:31, 8月:31, 9月:30, 10月:31, 11月:30, 12月:31
 *
 *   2. そのMapから「30日の月」だけを取り出し、List<String> に変換して出力する
 *      期待する出力例: [4月, 6月, 9月, 11月]  ※順序は問わない
 *
 * ヒント:
 *   - entrySet() でMapのエントリを繰り返し処理できる
 *   - Stream を使っても可（まだ学習前なので for文でも OK）
 */
public class Exercise3 {

    public static void main(String[] args) {

        // TODO: 12ヶ月の日数Mapを Map.ofEntries で作成


        // TODO: 30日の月だけ取り出して List<String> に変換して出力

    }
}
