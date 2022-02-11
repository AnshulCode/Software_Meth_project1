package kisok;



public class MyArrayList {
    String arr[];
    int size;
    int elements;
    public MyArrayList(){
        this.arr = new String[1];
        this.size = 0;
        this.elements = 0;
    }
    private void scale(){
        if(this.size == this.arr.length){
            String[] copy = new String[this.size+4];
            for (int i = 0; i < this.size; i++) {
                copy[i] = this.arr[i];
            }
            this.arr = copy;
        }

    }
    public void add(String element){
        this.scale();
        this.arr[this.elements] = element;
        this.elements++;
        this.size++;
    }
    public String[] getArray(){
        return this.arr;
    }
}
