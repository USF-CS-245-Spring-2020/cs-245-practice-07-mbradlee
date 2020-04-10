public class ArrayQueue<T> implements Queue<T> {

    protected T[] array;
    protected int front;
    protected int back;
    protected int items;

    public ArrayQueue(){
        front = 0;
        back = -1;
        items = 0;
        array = (T[])new Object[10];
    }

    public T dequeue() throws Exception{
        items--;
        return array[front++];
    }

    public void enqueue(T item){
        if(items == array.length){
            double_array();
            array[++back] = item;
            items++;
        }else{
            array[++back%array.length] = item;
            items++;
        }

    }

    public boolean empty(){
        return front == back + 1;
    }

    protected void double_array(){
//        T[] temp = (T[])new Object[items*2];
//        for(int i = 0; i < items; i++){
//            temp[(front+i)%array.length] = array[(front+i)%array.length];
//        }
//        front = 0;
//        back = ++items;
//        array = temp;
        T[] temp = (T[])new Object[array.length*2];
        for(int i = 0; i < items; i++){
            temp[i] = array[i];
        }
        array = temp;
    }

}
