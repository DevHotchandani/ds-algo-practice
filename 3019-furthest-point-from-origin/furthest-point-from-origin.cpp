class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {
        int n = moves.size();
        int count1 = 0;
        int count2 = 0;
        int pt = 0;

        char ch;

        for(int i=0;i<n;i++)
        {
            if(moves[i]=='L') count1++;
            else if(moves[i]=='R') count2++;
        }

        if(count1 > count2) ch = 'L';
        else ch = 'R';
        
        for(int i=0;i<n;i++)
        {
            if(moves[i]=='_') moves[i] = ch;
        }

        for(int i=0;i<n;i++)
        {
            if(moves[i]=='L') pt = pt-1;
            else pt = pt+1;
        }

        if(pt<0) pt = -1*pt;

        return pt;
    }
};