public class ArrayStack<T> implements Stack<T> {

    protected T[] array;
    protected int top;

    public ArrayStack(){
        top = 0;
        array = (T[])new Object[10];
    }

    public void push(T item){
        if(top == array.length - 1){
            double_array();
        }
        array[top++] = item;
    }

    public T pop() throws Exception{
        if(top == 0){
            return array[top-1];
        }else{
            top--;
            return array[top];
        }
    }

    public T peek() throws Exception{
        return array[top];
    }

    public boolean empty(){
        return top == 0;
    }

    protected void double_array(){
        T[] temp = (T[])new Object[top*2];
        for(int i = 0; i < top; i++){
            temp[i] = array[i];
        }
        array = temp;
        top++;
    }

}
