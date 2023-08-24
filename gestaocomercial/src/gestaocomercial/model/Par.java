package gestaocomercial.model;

/**
 *
 * @author Freitas
 */
public class Par <First, Second> {

    public First first;
    public Second second;
    
    public Par(First first, Second second){
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString(){
        return second.toString();
    }
}
