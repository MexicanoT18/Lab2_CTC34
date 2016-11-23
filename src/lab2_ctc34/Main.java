package lab2_ctc34;

import java.util.Arrays;
import turingmachine.TuringMachine;

/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int MAXN = 29;
    
    public static TuringMachine escovador7(){
        
        //turinga machine
        TuringMachine machine = new TuringMachine(14);
        
        //initial state
        try{
            machine.setInitialState(0);
        } catch (Exception e) {
            
        }
        
        //end state
        try{
            machine.addEndState(13);
        } catch (Exception e) {
            
        }
        
        //q0 transtions
        machine.addTransition(0, 1, 'a', 'B', 'R');
        machine.addTransition(0, 2, 'b', 'B', 'R');
        machine.addTransition(0, 3, 'c', 'B', 'R');
        machine.addTransition(0, 8, '1', 'B', 'R');
        
        //q1 transitions
        machine.addTransition(1, 1, 'a', 'a', 'R');
        machine.addTransition(1, 1, 'b', 'b', 'R');
        machine.addTransition(1, 1, 'c', 'c', 'R');
        machine.addTransition(1, 4, '1', '1', 'R');
        
        //q2 transitions
        machine.addTransition(2, 2, 'a', 'a', 'R');
        machine.addTransition(2, 2, 'b', 'b', 'R');
        machine.addTransition(2, 2, 'c', 'c', 'R');
        machine.addTransition(2, 5, '1', '1', 'R');
        
        //q3 transitions
        machine.addTransition(3, 3, 'a', 'a', 'R');
        machine.addTransition(3, 3, 'b', 'b', 'R');
        machine.addTransition(3, 3, 'c', 'c', 'R');
        machine.addTransition(3, 6, '1', '1', 'R');
        
        //q4 transitions
        machine.addTransition(4, 4, 'X', 'X', 'R');
        machine.addTransition(4, 4, '0', '0', 'R');
        machine.addTransition(4, 7, 'a', 'X', 'L');
        machine.addTransition(4, 7, 'e', '0', 'L');
        
        //q5 transitions
        machine.addTransition(5, 5, 'X', 'X', 'R');
        machine.addTransition(5, 5, '0', '0', 'R');
        machine.addTransition(5, 7, 'b', 'X', 'L');
        machine.addTransition(5, 7, 'e', '0', 'L');
        
        //q6 transitions
        machine.addTransition(6, 6, 'X', 'X', 'R');
        machine.addTransition(6, 6, '0', '0', 'R');
        machine.addTransition(6, 7, 'c', 'X', 'L');
        machine.addTransition(6, 7, 'e', '0', 'L');
        
        //q7 transitions
        machine.addTransition(7, 7, 'X', 'X', 'L');
        machine.addTransition(7, 7, '1', '1', 'L');
        machine.addTransition(7, 7, 'a', 'a', 'L');
        machine.addTransition(7, 7, 'b', 'b', 'L');
        machine.addTransition(7, 7, 'c', 'c', 'L');
        machine.addTransition(7, 7, '0', '0', 'L');
        machine.addTransition(7, 0, 'B', 'B', 'R');
        
        //q8 transitions
        machine.addTransition(8, 8, 'X', 'B', 'R');
        machine.addTransition(8, 9, '0', '0', 'R');
        
        //q9 transitions
        machine.addTransition(9, 9, 'X', 'X', 'R');
        machine.addTransition(9, 10, '0', 'X', 'L');
        machine.addTransition(9, 12, 'B', 'B', 'L');
        
        //q10 transitions
        machine.addTransition(10, 10, 'X', 'X', 'L');
        machine.addTransition(10, 11, '0', '0', 'R');
        
        //q11 transitions
        machine.addTransition(11, 9, 'X', '0', 'R');
        
        //q12 transitions
        machine.addTransition(12, 12, 'X', 'B', 'L');
        machine.addTransition(12, 13, '0', '0', 'R');
        
        return machine;
    }
    
    public static void print2array(char [] array, String str){
        for(int i=0; i<array.length; i++){
            array[i] = 'B';
        }
        for(int i=0; i<str.length(); i++){
            array[i] = str.charAt(i);
        }
    }
    
    public static void main(String[] args) {
        TuringMachine escovador = escovador7();
        
        char [] array = new char[MAXN];
        
        print2array(array, "baabc1bacba");
        
        if(escovador.simulate(array)){
            System.out.println("Cadeia aceita");
        }
        else{
            System.out.println("Cadeia rejeitada");
        }
        
        System.out.println(array);
    }
    
}
