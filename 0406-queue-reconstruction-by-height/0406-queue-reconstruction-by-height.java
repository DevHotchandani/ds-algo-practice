class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return b[0] - a[0];
                return a[1] - b[1];
            }
        });

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }

        int[][] result = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}