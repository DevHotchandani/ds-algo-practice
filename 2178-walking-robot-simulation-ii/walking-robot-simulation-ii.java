class Robot {
    int w, h;
    int x = 0, y = 0;
    int d = 0;
    int cycle;

    String[] dir = {"East","North","West","South"};

    public Robot(int width, int height) {
        w = width;
        h = height;
        cycle = 2 * (w + h) - 4;
    }

    public void step(int num) {
        if (cycle == 0) return;

        num %= cycle;

        if (num == 0) {
            if (x == 0 && y == 0) d = 3;
            return;
        }

        while (num > 0) {
            if (d == 0) {
                int move = Math.min(num, w - 1 - x);
                x += move;
                num -= move;
                if (move == 0) d = 1;
            } else if (d == 1) {
                int move = Math.min(num, h - 1 - y);
                y += move;
                num -= move;
                if (move == 0) d = 2;
            } else if (d == 2) {
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (move == 0) d = 3;
            } else {
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (move == 0) d = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dir[d];
    }
}