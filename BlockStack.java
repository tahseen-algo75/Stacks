package CSE214_Homework3;
/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */
import java.util.Stack;
public class BlockStack {
    Stack <CodeBlock> stack;

    public BlockStack(){
        stack = new Stack <CodeBlock> ();
    }
    /* This method is implemented by using the JAVA API.
       It adds the codeblock from the stack.
     */
    public void push(CodeBlock codeBlock){
        stack.push(codeBlock);
    }
    /* This method is implemented by using the JAVA API.
       It removes the codeblock from the stack.
     */
    public CodeBlock pop(){
        return stack.pop();
    }
    /* This method is implemented by using the JAVA API.
       It returns the top value of the stack.
     */
    public CodeBlock peek(){
        return stack.peek();
    }
    /* This method is implemented by using the JAVA API.
       It returns the size of the stack.
     */
    public int size(){
        return stack.size();
    }
    /* This method is implemented by using the JAVA API.
       It returns the value to check whether the stack is empty or not.
     */
    public boolean isEmpty(){
        return stack.empty();
    }
}
