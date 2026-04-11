class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String d) {
        int n = pos.length;

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = pos[i];
            arr[i][1] = h[i];
            arr[i][2] = d.charAt(i);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (arr[i][2] == 'R') {
                st.push(i);
            } else {
                while (!st.isEmpty() && arr[i][1] > 0) {
                    int j = st.peek();

                    if (arr[j][1] < arr[i][1]) {
                        st.pop();
                        arr[i][1]--;
                        arr[j][1] = 0;
                    } else if (arr[j][1] > arr[i][1]) {
                        arr[j][1]--;
                        arr[i][1] = 0;
                    } else {
                        st.pop();
                        arr[i][1] = 0;
                        arr[j][1] = 0;
                    }
                }
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            if (arr[i][1] > 0) {
                res[arr[i][3]] = arr[i][1];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : res) {
            if (x != -1) ans.add(x);
        }

        return ans;
    }
}