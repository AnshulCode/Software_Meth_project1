package kisok;


/**
 * This is my Array List class, this is a custom array list I have amnd not using any of the library wqe were not supposed to use
 * Mainly used to help process batch commands
 *
 * @author Anshul Prasad , Alexander Reyes
 */
public class MyArrayList {
    /**
     * The Arr.
     */
    String[] arr;
    /**
     * The Size.
     */
    int size;
    /**
     * The Elements.
     */
    int elements;


    /**
     * Initializes the array list
     */
    public MyArrayList() {
        this.arr = new String[1];
        this.size = 0;
        this.elements = 0;
    }

    /**
     * This scales the array list and increases the size by a factor of 4 after each add
     */
    private void scale() {
        if (this.size == this.arr.length) {
            String[] copy = new String[this.size + 4];
            for (int i = 0; i < this.size; i++) {
                copy[i] = this.arr[i];
            }
            this.arr = copy;
        }

    }

    /**
     * Adds string to list
     *
     * @param element the element
     */
    public void add(String element) {
        this.scale();
        this.arr[this.elements] = element;
        this.elements++;
        this.size++;
    }

    /**
     * Return the string array of the array list;
     *
     * @return string [ ]
     */
    public String[] getArray() {
        return this.arr;
    }
}
