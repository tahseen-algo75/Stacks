package CSE214_Homework3;
/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */

import java.util.*;
import java.io.*;

public class PythonTracer {
    public static final int SPACE_COUNT = 4;

    public static Complexity traceFile(String filename) throws Exception {
        BlockStack stack = new BlockStack();
        CodeBlock oldTop = new CodeBlock();
        Complexity oldTopComplexity = new Complexity();
       
        int count = 0;
        
        File file = new File(filename);
        Scanner reader = new Scanner(file);
        while (reader.hasNext()) {
            String line = new String();
            line = reader.next();
            if(!line.isEmpty()&& !line.startsWith("#") ){ 
                int spaceCount = line.indexOf(line.trim());
                int indent = spaceCount / SPACE_COUNT;
                while (indent < stack.size()-1) {
                    if (indent == 0) {
                        reader.close();
                        return stack.peek().getBlockComplexity();
                    } else {
                        oldTop = stack.pop();
                        indent--;
                        oldTopComplexity = oldTop.getBlockComplexity();
                    }
                    if (oldTopComplexity.getNPower() > stack.peek().getBlockComplexity().getNPower()) {
                        stack.peek().setHighestSubComplexity(oldTopComplexity);
                    }
                    if (oldTopComplexity.getNPower() == stack.peek().getBlockComplexity().getNPower()) {
                        if (oldTopComplexity.getLogPower() > stack.peek().getBlockComplexity().getLogPower()) {
                            stack.peek().setHighestSubComplexity(oldTopComplexity);
                        }
                    }
                    System.out.println("Leaving " + oldTop.getName() + " updating " + stack.peek().getName());
                   
                    System.out.println("block complexity = " + stack.pop().getBlockComplexity().toString()
                            + "    "  +  " highest sub-complexity = " + stack.pop().getHighestSubComplexity().toString());
                }
            

                    String keyword = findKeyWord(line); 
                    
                    if(!keyword.isEmpty()){
                        int i = 0;
                        if(keyword.equals("for")){
                        if(line.trim().endsWith("log_N:")){
                            Complexity complexity = new Complexity();
                            Complexity highestSubComplexity = new Complexity();
                            complexity.setNPower(0);
                            complexity.setLogPower(1);
                            highestSubComplexity.setNPower(0);
                            highestSubComplexity.setLogPower(0);
                             CodeBlock codeBlock = new CodeBlock((stack.peek().getName() + "." + i), complexity, highestSubComplexity, "for");

                            System.out.println("Entering " + codeBlock.getName() + ":'" + codeBlock.getLoopVariable() + ":'");
                           
                            stack.push(codeBlock);
 
                            System.out.println("log_N : " + stack.peek().getName() +  "     "  +   "block complexity = " + codeBlock.getBlockComplexity().toString()
                            + "     "  +  " highest sub-complexity = " + codeBlock.getHighestSubComplexity().toString());

                            indent++;
                        }
                        else if(line.trim().endsWith("N:")){
                            Complexity complexity = new Complexity();
                            Complexity highestSubComplexity = new Complexity();
                            complexity.setNPower(1);
                            complexity.setLogPower(0);
                            highestSubComplexity.setNPower(0);
                            highestSubComplexity.setLogPower(0);
                            CodeBlock codeBlock = new CodeBlock((stack.peek().getName() + "." + i) , complexity, highestSubComplexity, "for");


                            System.out.println("N : " + stack.peek().getName());
                            System.out.println("Entering " + codeBlock.getName() + codeBlock.getLoopVariable());
                            stack.push(codeBlock);

                            
                            indent++;
                        }
                    }
                //}
                    else if(keyword.equals("while")){
                        Complexity complexity = new Complexity(); 
                        Complexity highestSubComplexity = new Complexity();
                        complexity.setNPower(0);
                        complexity.setLogPower(0);
                        highestSubComplexity.setNPower(0);
                        highestSubComplexity.setNPower(0);
                        
                        CodeBlock codeBlock = new CodeBlock("Block 1.2", complexity, highestSubComplexity, " while");
                        System.out.println("Entering " + codeBlock.getName()+ ":" + codeBlock.getLoopVariable() + " ");

                        stack.push(codeBlock);

                        System.out.println("block complexity = " + codeBlock.getBlockComplexity().toString()
                            + "    "  +  " highest sub-complexity = " + codeBlock.getHighestSubComplexity().toString());
                        }
                        else{
                            Complexity complexity = new Complexity();
                            complexity.setNPower(0);
                            complexity.setLogPower(0);
                            Complexity highestSubComplexity = new Complexity();
                            highestSubComplexity.setNPower(0);
                            highestSubComplexity.setNPower(0);
     
                            CodeBlock codeBlock = new CodeBlock("Block 1", complexity,  highestSubComplexity, "def");
                            System.out.println("Entering " + codeBlock.getName() + ":'" + codeBlock.getLoopVariable() + "'");
                           
                            stack.push(codeBlock);
     
                            System.out.println("log_N : " + stack.peek().getName() +  "     " + "block complexity = " + codeBlock.getBlockComplexity().toString()
                                + "    "  +  " highest sub-complexity = " + codeBlock.getHighestSubComplexity().toString());
                            }
                        }
                        else if(!stack.isEmpty() && stack.peek().getName().equals("while")){
                        if(line.contains("/=")){
                            Complexity complexity= new Complexity();
                            complexity.setNPower(0);
                            complexity.setLogPower(1);
                            stack.peek().setBlockComplexity(complexity);
                        }
                        else if(line.contains(("-="))){
                            Complexity complexity = new Complexity();
                            complexity.setNPower(1);
                            complexity.setLogPower(0);
                            stack.peek().setBlockComplexity(complexity);
                        }
                    }
                   
                }
                 
            }
     
              while(stack.size()>1){
                 oldTop = stack.pop();
                  if(oldTopComplexity.getNPower()>stack.peek().getHighestSubComplexity().getNPower()){
                     stack.peek().setHighestSubComplexity(oldTopComplexity);
                 }
             }
            return oldTopComplexity;
     
    
                }
           
    public static String findKeyWord(String st){
        
        if(st.trim().startsWith("for") && st.contains("for")) {
            return "for";
        }else if (st.trim().startsWith("while") && st.contains("while")) {
            return "while";
        }else if(st.trim().startsWith("def") && st.contains("def")){
            return "def";
        }else if(st.trim().startsWith("else") && st.contains("else")){
            return "else";
        }else if(st.trim().startsWith("elif") && st.contains("elif")){
            return "elif";
        }else if(st.trim().startsWith("if") && st.contains("if")){
            return "if";
        }
        return "";
}
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //System.out.println("Please enter a file name (or 'quit' to quit): quit ");
        
        try{
            String fileName = reader.nextLine().trim();
            if(fileName.equals("Quit") || fileName.equals("quit")) {
                System.out.println("Program is terminating successfully");
                    System.exit(0);
        }else {
            traceFile(fileName);
        }
        } catch(Exception e){
            //System.out.println("Sorry the file is not found. Please try again");
        }
        reader.close();
    }
}






