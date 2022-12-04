package CS214_Homework3;

public class Complexity {
    private int nPower;
    private int logPower;

    public Complexity(int nPower, int logPower) {
        this.nPower = nPower;
        this.logPower = logPower;
    }

    public Complexity() {}

    /* @ return
         It returns the nPower of the complexity.
     */
    public int getNPower() {
        return nPower;
    }
     /* @ return
         It returns the logPower of the complexity.
     */
    public int getLogPower() {
        return logPower;
    }
    /* @ param nPower
         It can set the nPower of the complexity.
     */
    public void setNPower(int nPower) {
        this.nPower = nPower;
    }
    /* @ param logPower
         It can set the logPower of the complexity.
     */
    public void setLogPower(int logPower) {
        this.logPower = logPower;
    }
    /* @ return 
     *   It's a method which prints human-readable Big-Oh notation as a String value. 
     */
    /*
    public String toString() {
        String st = null;
        if (nPower == 1 && logPower == 1) {
            st = "O(n * log(n)";
        } else if (nPower == 0 && logPower == 0) {
            st = "O(1)";
        } else if (nPower > 1 && logPower == 0) {
            st = "O(n^2)";
        }
        else{
            st = "O(n)";
        }
        return st ;
    }
}
 */
public String toString(){
    String string = "";
    if(nPower == 0 && logPower == 0){
        string +="O(1)";
    }
    else if(nPower == 1 && logPower==1){
        string += "O(n * log(n))";
    }
    else if(nPower == 1){
        string += "O(n)";
    }
    else if(logPower == 1){
        string += "O(log(n))";
    }
    else if(logPower == 0 & nPower!=0){
        string +="O(n^"+nPower+")";
    }
    else{
        string+="O(n^"+nPower+" * log(n)^"+logPower+")";
    }
    return string;
    }
}
    
