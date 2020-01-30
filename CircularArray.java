
public class CircularArray {

    private int start;
    private int size;
    private Object[] cir;

    /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
     */
    public CircularArray(Object[] lin, int st, int sz) {
        cir = new Object[lin.length];
        start = st;
        size = sz;
        int pointer = start;
        for (int i = 0; i < lin.length; i++) {
            cir[pointer] = lin[i];
            pointer = (pointer + 1) % cir.length;
        }
    }

    //Prints from index --> 0 to cir.length-1
    public void printFullLinear() {
        for (int i = 0; i < cir.length; i++) {
            if (i == cir.length - 1) {
                System.out.print(cir[i]);
            } else {
                System.out.print(cir[i] + ",");
            }
        }
        //TO DO
    }

    // Starts Printing from index start. Prints a total of size elements
    public void printForward() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(cir[(i + start) % cir.length]);
            } else {
                System.out.print(cir[(i + start) % cir.length] + ",");
            }
        }
        //To DO
    }

    public void printBackward() {
        System.out.println();
        int end = (start + size - 1) % cir.length;
        int p = end;
        for (int i = 0; i < size; i++) {
            System.out.print(cir[p] + ",");
            p--;
            if (p < 0) {
                p = (p + (cir.length)) % cir.length;
            }
        }
    }
    //TO DO

    // With no null cells
    public void linearize() {
        int p = start;
        Object temp[] = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = cir[p];
            p = (p + 1) % cir.length;
        }
        cir = new Object[size];
        cir = temp;
        //TO DO
    }

    // Do not change the Start index
    public void resizeStartUnchanged(int newcapacity) {
        System.out.println();
        Object temp[] = new Object[size];
        int p = start;
        for (int i = 0; i < size; i++) {
            temp[i] = cir[p];
            p = (p + 1) % cir.length;
        }
        cir = new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            cir[p] = temp[i];
            p = (p + 1) % cir.length;
        }
        //TO DO
    }

    // Start index becomes zero
    public void resizeByLinearize(int newcapacity) {
        System.out.println();
        Object temp[] = new Object[size];
        int p = start;
        for (int i = 0; i < size; i++) {
            temp[i] = cir[p];
            p = (p + 1) % cir.length;
        }
        cir = new Object[newcapacity];
        start = 0;
        for (int i = 0; i < size; i++) {
            cir[p] = temp[i];
            p = (p + 1) % cir.length;
        }
        //TO DO
    }

    /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
     */
    public void insertByRightShift(Object elem, int pos) {
        System.out.println();
        if (size == cir.length) {
            Object temp[] = new Object[size];
            int p = start;
            for (int i = 0; i < size; i++) {
                temp[i] = cir[p];
                p = (p + 1) % cir.length;
            }
            cir = new Object[cir.length + 3];
            for (int i = 0; i < size; i++) {
                cir[p] = temp[i];
                p = (p + 1) % cir.length;
            }
        }
        int from = (start + size) % cir.length;
        int to = (from - 1);
        for (int i = 0; i < size - start; i++) {
            cir[from] = cir[to];
            from = to;
            to = (to - 1);
            if (to == -1) {
                to = (to + cir.length) % cir.length;
            }
        }
        cir[start + pos] = elem;
        size = size + 1;
    }

    public void insertByLeftShift(Object elem, int pos) {
        System.out.println();
        if (size == cir.length) {
            Object temp[] = new Object[size];
            int p = start;
            for (int i = 0; i < cir.length - (size + start + 1); i++) {
                temp[i] = cir[p];
                p = (p + 1) % cir.length;
            }
            cir = new Object[cir.length + 3];
            for (int i = 0; i < size; i++) {
                cir[p] = temp[i];
                p = (p + 1) % cir.length;
            }
        }
        int from = (start) % cir.length;
        int to = (from - 1);
        for (int i = 0; i < size - start - 1; i++) {
            cir[to] = cir[from];
            to = from;
            from = (from + 1) % cir.length;
            if (from > cir.length) {
                from = (from + cir.length) % cir.length;
            }
        }
        cir[start + pos] = elem;
        size = (size + 1) % cir.length;
        start = (cir.length + start - 1) % cir.length;
    }

    /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
     */
    public void removeByLeftShift(int pos) {

        System.out.println();
        int from = (start) % cir.length;
        int to = (from - 1);
//        for (int i = 0; i < size - start - 1; i++) {
//            cir[to] = cir[from];
//            to = from;
//            from = (from + 1) % cir.length;
//            if (from > cir.length) {
//                from = (from + cir.length) % cir.length;
//            }
//        }
        cir[start+pos] = null;
//        size = (size -1+cir.length) % cir.length;
//        start = (start + 1) % cir.length;
    }

    /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
     */
    public void removeByRightShift(int pos) {
        //TO DO
    }

    //This method will check whether the array is palindrome or not
    public void palindromeCheck() {
        //TO DO
    }

    //This method will sort the values by keeping the start unchanged
    public void sort() {
        //TO DO
    }

    //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
    public boolean equivalent(CircularArray k) {
        //TO DO
        return false; // Remove this line
    }
}
