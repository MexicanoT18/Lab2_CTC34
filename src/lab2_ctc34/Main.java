package lab2_ctc34;

import turingmachine.TuringMachine;

/**
 *
 * @author Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public TuringMachine escovador7(){
        
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
        machine.addTransition(2, 2, 'a', 'a', 'R');
        machine.addTransition(2, 2, 'b', 'b', 'R');
        machine.addTransition(2, 2, 'c', 'c', 'R');
        machine.addTransition(2, 5, '1', '1', 'R');
        
        
        return machine;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
