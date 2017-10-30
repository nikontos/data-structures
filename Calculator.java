public class Calculator
{

    private static void Calculate(String expr) {
        int N = expr.length();
        Stack numStack = new Stack(N);   // stack with the numbers
        Stack opStack = new Stack(N);    // stack with the operators ( + - x )
        char[] a = expr.toCharArray();
        Object kati ;
        Object katiAllo ;
        Object result=0;

        for (int i = 0; i < N; i++) {
            Character c = a[i];
            kati = Character.getNumericValue(c);   // returns -1 if is an non-integer char
            katiAllo =(int)c.charValue();          // returns ASCII of the char

            // If its a number push the number ( wont work for -1 tho)
            if((int)kati != -1){
              System.out.println();
              numStack.push(kati);
            }
            // If it's an operator
            else if((int)kati == -1){
            // Identify which operator is it and push it to the operators Stack
              switch (c){
                case '+': case '-' : case '*' :
                  opStack.push(c.charValue());
                  break;
                // If it's a right parenthesis we got calculations to do
                case ')' :
                // pop the operators Stack and identify the operator
                // then push to the numers Stack the result
                  Object op = (char) opStack.pop();
                  switch ((char)op){
                    case '+' :
                    result = (int)numStack.pop() + (int)numStack.pop();
                      numStack.push(result);
                      break;
                    case '-' :
                      result = (int)numStack.pop()*(-1) + (int)numStack.pop();
                      numStack.push(result);
                      break;
                    case '*' :
                      result = (int)numStack.pop() * (int)numStack.pop();
                      numStack.push(result);
                    break;
                  }
                case '(' :
                   break;
              }
            }
        }
        System.out.println("Result is " + result + "\nNumbers Stack: " + numStack.toString() + "\nOperators Stack: " + opStack.toString());
    }


    public static void main (String[]args){
        {
            String expr = args[0];
            System.out.println("Input expression = " + expr + " , length = " + expr.length());

            Calculate(expr);
        }
    }
}
