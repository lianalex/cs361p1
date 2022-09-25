package fa.dfa;

import fa.State;

public class DFAState extends State{
    private String name;
    
    public DFAState(String name)
    {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString()
    {
        return name;
    }

}
