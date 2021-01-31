package part_1.medium.ufs;


/**
 * description: 990. 等式方程的可满足性
 */
public class EquationsPossible990 {

    public static void main(String[] args) {
        String[] equations = {"a==b", "b==c", "a==c"};
        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for(String str : equations) {
            if(str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union1(parent, index1, index2);
            }
        }

        for(String str : equations) {
            if(str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                // 在前面等式关系中找到了不等式关系的反例，则返回false
                if(find1(parent, index1) == find1(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int find1(int[] parent, int index) {
        while(parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public static void union1(int[] parent, int index1, int index2) {
        parent[find1(parent, index1)] = find1(parent, index2);
    }
}
