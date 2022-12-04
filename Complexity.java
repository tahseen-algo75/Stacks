package CSE214_Homework3;
/*
 *  @author Tahseen Zaman
 *  ID : 114332480
 *  Recitation : 03
 */

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

