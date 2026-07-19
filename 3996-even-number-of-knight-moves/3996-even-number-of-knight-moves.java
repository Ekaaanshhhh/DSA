class Solution {
    public boolean canReach(int[] start, int[] target) {
        int x = start[0];
        int y = start[1];
        int parity = (x+y)%2;

        int x1 = target[0];
        int x2=target[1];
        int parity2 = (x1+x2)%2;

        return parity==parity2;
    }
}