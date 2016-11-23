package turingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class State {
    
    private TuringMachine _machine;
    private List<Transition> _transitions;
    
    State(TuringMachine machine){
        _machine = machine;
        _transitions = new ArrayList<>();
    }
    
    public void addTransition(Transition transition){
        _transitions.add(transition);
    }
    
    public boolean simulate(char [] array, int i){
        char direction, curchar, toRead;
        int nexti, nextstate;
        
        //keep current char
        curchar = array[i];
        
        for(int j=0; j<_transitions.size(); j++){
            Transition transition = _transitions.get(j);
            
            //check if is valid transition
            toRead = transition.getToRead();
            if (toRead != 'e' && toRead != curchar)
                continue;
            
            //get nexti
            direction = transition.getDirection();
            switch (direction) {
                case 'L':
                    nexti = i-1;
                    break;
                case 'R':
                    nexti = i+1;
                    break;
                default:
                    nexti = -1;
                    break;
            }
            
            //get next state
            nextstate = transition.getTo();
            
            //write on array
            array[i] = transition.getToWrite();
            
            //keep simulation
            if (_machine.simulateOnState(array, nextstate, nexti))
                return true;
        }
        
        array[i] = curchar;
        
        return false;
    }
}
