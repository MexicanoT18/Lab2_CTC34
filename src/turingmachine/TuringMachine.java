package turingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Lucas
 */
public class TuringMachine {
    private List<State> _states;
    private int _initialState;
    private List<Integer> _endStates;
    private Stack<String> _instructions;
    
    public TuringMachine(int nstates){
        
        //initialize stuff
        _states = new ArrayList<>();
        for(int i=0; i<nstates; i++){
            _states.add(new State(this));
        }
        _endStates = new ArrayList<>();
        _initialState = 0;
        _instructions = new Stack<>();
    }
    
    public void setInitialState(int initialState) throws IllegalArgumentException{
        
        //check valid entry
        if (initialState < 0 || initialState >= _states.size()){
            throw new IllegalArgumentException("Estado não existente");
        }
        _initialState = initialState;
    }
    
    public void addEndState(int endState) throws IllegalAccessException {
        
        //check valid entry
        if (endState < 0 || endState >= _states.size()){
            throw new IllegalArgumentException("Estado não existente");
        }
        _endStates.add(endState);
    }
    
    public void addTransition(int from, int to, char toRead, char toWrite, char direction) throws IllegalArgumentException{
        
        //check valid entry
        if (from < 0 || from >= _states.size()){
            throw new IllegalArgumentException("Estado de inicio não existente");
        }
        if (to < 0 || to >= _states.size()){
            throw new IllegalArgumentException("Estado de chegada não existente");
        }
        if (direction != 'R' && direction != 'L'){
            throw new IllegalArgumentException("Direção não existente");
        }
        
        //build new transition
        Transition transition = new Transition(from, to, toRead, toWrite, direction);
        
        //add transition to state
        _states.get(from).addTransition(transition);
    }
    
    public boolean simulate(char [] array){
        
        //clear instructions stack to print them in right order
        _instructions.clear();
        
        //Simulação
        System.out.println("Simulação:");
        boolean accepted = simulateOnState(array, _initialState, 0);
        
        //print instructions if accepted array
        System.out.println("Cadeia final de transições:");
        while(accepted && !_instructions.isEmpty()){
            System.out.println(_instructions.pop());
        }
        
        return accepted;
    }
    
    public boolean simulateOnState(char [] array, int state, int i){
        
        printState(array, state, i);
        
        if (state < 0 || state >= _states.size())
            return false;
        if (i < 0 || i >= array.length)
            return false;
        if (_endStates.contains(state)) return true;
        return _states.get(state).simulate(array, i);
    }
    
    private void printState(char [] array, int state, int i){
        System.out.println("state " + state);
        System.out.println(array);
        for(int j=0; j<i; j++) System.out.print(" ");
        System.out.println("^");
    }
    
    public void pushToStack(String str){
        _instructions.push(str);
    }
}
