import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

val sb = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val st = StringTokenizer(readLine())
        val k = st.nextToken().toInt()
        if(k == 0) break
        val arr = Array(k) { st.nextToken().toInt() }
        val visited = BooleanArray(k)
        comb(arr, visited, 0, k, 6)
        sb.append('\n')
    }
    print(sb)
}

fun comb(arr: Array<Int>, visited: BooleanArray, s: Int, n: Int, r: Int) {
    if(r == 0) {
        for(i in visited.indices) {
            if(visited[i]) sb.append("${arr[i]} ")
        }
        sb.append('\n')
        return
    }

    for(i in s until n) {
        visited[i] = true
        comb(arr, visited, i + 1, n, r - 1)
        visited[i] = false
    }
}