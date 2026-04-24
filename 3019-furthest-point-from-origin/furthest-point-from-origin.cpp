class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int L = 0, R = 0, U = 0;

        for(int i = 0; i < moves.size(); i++) {
            if(moves[i] == 'L') L++;
            else if(moves[i] == 'R') R++;
            else U++;
        }

        return abs(L - R) + U;
    }
};