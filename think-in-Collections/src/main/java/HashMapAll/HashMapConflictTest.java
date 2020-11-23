package HashMapAll;

import java.util.*;

/**
 * https://coolshell.cn/articles/6424.html  制造 hash 冲突
 * Aa 和 BB 两个的 hash 值是一样的，且他们的排列组合的值也是一样的；所以可凭这两个字符串制造无穷多的 hash 冲突
 *
 * 下面的代码是有 16 个相同 Hash值 但内容不同的；可调试 链表、红黑树代码
 *
 */
public class HashMapConflictTest {
    public static void main(String[] args) {
        String a = "Aa";
        String b = "BB";

        Map map = new HashMap(2);
        List<String> list = new ArrayList<String>();
        Set set = new HashSet();
        list.add("AaAa");
        list.add("AaBB");
        list.add("BBAa");
        list.add("BBBB");

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                set.add(list.get(i) + list.get(j));
            }
        }

        Iterator it = set.iterator();
        while (it.hasNext()) {
//           System.out.println(it.next());
            String tmp = (String) it.next();
            map.put(tmp, tmp);
        }

        map.get("BBBBBBBB");

    }
}
