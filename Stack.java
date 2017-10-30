public class Stack<Item> {

    private Object[] S;
    private int N;      // pointer to next empty spot on stack

    public Stack (int maxN){
        this.S =(Item[]) new Object[maxN];
        this.N=0;
    }

    public boolean isEmpty(){
        return (N==0);
    }

    public void push(Object item){
        this.S[this.N] = item;
        this.N++;
    }

    public Object pop(){
        Object t = this.S[this.N-1];
        this.S[N-1] = null;
        this.N--;
	       return t;
    }

    @Override
    public String toString() {
        String S = "";
        for (int i=0; i<this.S.length; i++){
          if(this.S[i] != null)
            S +=  this.S[i] + " ";
        }
        return " "+S;

    }

    public int getN() {
        return N;
    }
}
