package turingmachine;

/**
 *
 * @author Lucas
 */
public final class Transition {
    private final int _from;
    private final int _to;
    private final char _toRead;
    private final char _toWrite;
    private final char _direction;

    public Transition(int from, int to, char toRead, char toWrite, char direction) throws IllegalArgumentException {
        _from = from;
        _to = to;
        _toRead = toRead;
        _toWrite = toWrite;
        _direction = direction;
    }
    
    public int getTo(){
        return _to;
    }
    
    public char getToRead(){
        return _toRead;
    }
    
    public char getToWrite(){
        return _toWrite;
    }
    
    public char getDirection(){
        return _direction;
    }
    
    public String toString(){
        return _from + "->" + _to + " (" + _toRead + "/" + _toWrite + "," + _direction + ")";
    }
            
}
