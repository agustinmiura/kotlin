package ar.com.miura.jvm.geometry;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        /*
        REC1 to the left of REC2
        REC1 to the right of REC2
        REC1 top of REC2
        REC1 below REC2
        */
        if ( rec2[0]>=rec1[2] || //left
                rec1[0]>=rec2[2] || //right
                rec1[1]>=rec2[3] || //top
                rec1[3]<=rec2[1]
        ) {
            return false;

        } else {
            return true;

        }
    }
}
