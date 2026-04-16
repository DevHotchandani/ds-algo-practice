class Solution {
public:
    bool isRobotBounded(string instructions) {
        int x = 0, y = 0;
        int dir = 0;

        vector<vector<int>> d = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        for (int i = 0; i < instructions.size(); i++) {
            char ch = instructions[i];

            if (ch == 'G') {
                x += d[dir][0];
                y += d[dir][1];
            }
            else if (ch == 'L') {
                dir = (dir + 3) % 4;
            }
            else {
                dir = (dir + 1) % 4;
            }
        }

        if ((x == 0 && y == 0) || dir != 0)
            return true;

        return false;
    }
};