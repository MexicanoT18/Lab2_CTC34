package turingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class TuringMachine {
    private List<State> _states;
    private int _initialState;
    private List<Integer> _endStates;
    
    public TuringMachine(int nstates){
        _states = new ArrayList<>(nstates);
        for(int i=0; i<nstates; i++){
            _states.add(new State(this));
        }
        _endStates = new ArrayList<>();
        _initialState = 0;
    }
    
    public void setInitialState(int initialState) throws IllegalArgumentException{
        if (initialState < 0 || initialState >= _states.size()){
            throw new IllegalArgumentException("Estado não existente");
        }
        _initialState = initialState;
    }
    
    public void addEndState(int endState) throws IllegalAccessException {
        if (endState < 0 || endState >= _states.size()){
            throw new IllegalArgumentException("Estado não existente");
        }
        _endStates.add(endState);
    }
    
    public void addTransition(int from, int to, char toRead, char toWrite, char direction) throws IllegalArgumentException{
        if (from < 0 || from >= _states.size()){
            throw new IllegalArgumentException("Estado de inicio não existente");
        }
        if (to < 0 || to >= _states.size()){
            throw new IllegalArgumentException("Estado de chegada não existente");
        }
        if (direction != 'R' && direction != 'L'){
            throw new IllegalArgumentException("Direção não existente");
        }
        
        Transition transition = new Transition(from, to, toRead, toWrite, direction);
        
        _states.get(from).addTransition(transition);
    }
    
    public boolean simulate(char [] array){
        return simulateOnState(array, _initialState, 0);
    }
    
    boolean simulateOnState(char [] array, int state, int i){
        if (state < 0 || state >= _states.size())
            return false;
        if (i < 0 || i >= array.length)
            return false;
        if (_endStates.contains(state)) return true;
        return _states.get(state).simulate(array, i);
    }
}
