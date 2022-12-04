package CSE214_Homework3;
/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */

public class CodeBlock {
    private String name;
    private Complexity blockComplexity;
    private Complexity highestSubComplexity;
    private String loopVariable;

    public static final String [] BLOCK_TYPES = {"def", "for", "while", "if", "elif", "else"};

    public static final int DEF = 0, FOR = 1, WHILE = 2, IF = 3, ELIF = 4, ELSE = 5;

    public CodeBlock(){}

    public CodeBlock(String name, Complexity blockComplexity, Complexity highestSubComplexity, String loopVariable) {
        this.name = name;
        this.blockComplexity = blockComplexity;
        this.highestSubComplexity = highestSubComplexity;
        this.loopVariable = loopVariable;
    }
    /* @ return
     *   It return the name of the codeBlock as a String value.
     */
    public String getName(){
        return name;
    }
    /* @ return
     *   It returns the blockComplexity of the codeBlock as the type of complexity.
     */
    public Complexity getBlockComplexity(){
        return blockComplexity;
    }
    /* @ return
     *   It returns the highestSubComplexity of the codeBlock as the type of complexity.
     */
    public Complexity getHighestSubComplexity(){
        return highestSubComplexity;
    }
    /* @ return
     *   It returns the loopVariable of the codeBlock as a String.
     */
    public String getLoopVariable(){
        return loopVariable;
    }
    /* @ param name
     *   It can set the name of the codeBlock.
     */
    public void setName(String name){
        this.name = name;
    }
    /* @ param blockComplexity
     *   It can set the blockComplexity of the codeBlock.
     */
    public void setBlockComplexity(Complexity blockComplexity){
        this.blockComplexity = blockComplexity;
    }
    /* @ param highestSubComplexity
     *   It can set the highestSubComplexity of the codeBlock.
     */
    public void setHighestSubComplexity(Complexity highestSubComplexity){
        this.highestSubComplexity = highestSubComplexity;
    }
    /* @ param loopVariable
     *   It can set the loopVariable of the codeBlock.
     */
    public void setLoopVariable(String loopVariable){
        this.loopVariable = loopVariable;
    }
}

