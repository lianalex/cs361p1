package fa.dfa;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import fa.State;

//@author Stephanie Ball and Alex Liang

public class DFA implements DFAInterface{

	// DFA elements that are sets, e.g., set of states Q
	private LinkedHashSet<DFAState> Q;		    // DFA states
	private HashMap<String, DFAState> delta; 	// transistions
	private LinkedHashSet<Character> sigma; 	// DFA alphabet
	private LinkedHashSet<DFAState> F;		    // Final states for DFA
	private DFAState startState; 			    // Starting state for DFA

	public DFA(){
		Q = new LinkedHashSet<>();
		delta = new HashMap<>();
		sigma = new LinkedHashSet<>();
		F = new LinkedHashSet<>();
		startState = null;
	}


	/**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
	public void addFinalState(String nextToken) {
		DFAState state = new DFAState(nextToken);
		F.add(state); 		// Adding to final state set
		Q.add(state); 		// Adding to Q set
	}

	/**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
	public void addStartState(String startStateName) {
		DFAState state = getStateFromQ(startStateName);
		if(state == null){
			state = new DFAState(startStateName);
			Q.add(state);
		}
		startState = state;
	}

	/**
	 * Adds a non-final, not initial state to the DFA instance
	 * @param name is the label of the state 
	 */
	public void addState(String nextToken) {
		DFAState state = new DFAState(nextToken);
		Q.add(state);
	}

	/**
	 * Adds the transition to the DFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
	public void addTransition(String valueOf, char c, String valueOf2) {
		DFAState transState = null;
		String key = valueOf + c;

		// Finding end state in Q set
		transState = getStateFromQ(valueOf2);

		// Adding key and transState in delta set
		delta.put(key, transState);	
		
		// Adding c to sigma if not already there
		if(!sigma.contains(c)){
			sigma.add(c);
		}
	}

	/**
	 * Computes a copy of this DFA
	 * which language is the complement
	 * of this DFA's language.
	 * @return a copy of this DFA
	 */
	public DFA complement() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Simulates a DFA on input s to determine
	 * whether the DFA accepts s.
	 * @param s - the input string
	 * @return true if s in the language of the DFA and false otherwise
	 */
	public boolean accepts(String input) {
		boolean accept = false;
		DFAState curr = startState;

		for(int i = 0; i < input.length(); i++){
			if(sigma.contains(input.charAt(i))){
				curr = (DFAState) getToState(curr, input.charAt(i));
			}
			else if(input.charAt(i) == 'e'){
				accept = true;
				break;
			}
		}

		// See if it is a final state
		if(accept && F.contains(curr)){
			accept = true;
		}
		else{
			accept = false;
		}
		return accept;
	}
	
	
	/**
	 * Getter for Q
	 * @return a set of states that FA has
	 */
	@Override
	public Set<? extends State> getStates() {
		return Q;
	}

	/**
	 * Getter for F
	 * @return a set of final states that FA has
	 */
	@Override
	public Set<? extends State> getFinalStates() {
		return F;
	}

	/**
	 * Getter for q0
	 * @return the start state of FA
	 */
	@Override
	public State getStartState() {
		return startState;
	}

	/**
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
	@Override
	public Set<Character> getABC() {
		return sigma;
	}

	/**
	 * Uses transition function delta of FA
	 * @param from the source state
	 * @param onSymb the label of the transition
	 * @return the sink state.
	 */
	@Override
	public State getToState(DFAState from, char onSymb) {
		DFAState state = delta.get(from.toString()+onSymb);
		return state;
	}

	// Helper methods

	/**
	 * Checks Q set to see if a state is already stored
	 * @param stateName
	 * @return state if found, otherwise returns null
	 */
	private DFAState getStateFromQ(String stateName){
		DFAState state = null;

		for(DFAState s : Q){
			if(s.getName().equals(stateName)){
				state = s;
				break;
			}
		}
		return state;
	}

	/**
	 * toString method to build expected output. Example output:
	 * 
	 * Q = { b a }
	 * Sigma = { 0 1 }
	 * delta = 
	 * 					0	1
	 * 				b	a	b
	 * 				a	a	b
	 * q0 = a
	 * F = { b}
	 * 
	 */
	@Override
	public String toString(){

		// Gets values in Q set
		String resultQ = "Q = { ";
		for(DFAState state: Q) {
			resultQ += state.toString() + " ";
		}	
		resultQ += "}\n";

		// Gets values in Sigma
		String resultSigma = "Sigma = { ";

		for(Character c: sigma) {
			resultSigma += c + " ";
		}
		resultSigma += "}\n";

		// Gets values in Delta
		String resultDelta = "delta =\n";
		resultDelta += "\t\t";

		for(Character c: sigma) {
			resultDelta += c + "\t";
		}

		resultDelta += "\n";

		for(DFAState state: Q) {
			resultDelta += "\t" + state.toString();

			for(Character c: sigma) {
				resultDelta += "\t" + delta.get(state.toString()+c).toString();
			}
			resultDelta += "\n";
		}

		// Gets Start Start 
		String resultStart = "q0 = " + startState.toString() + "\n";

		// Get Final State(s)
		String resultFinal = "F = { ";
		for(DFAState state: F) {
			resultFinal += state.toString() + " ";
		}
		resultFinal += "}\n";

		return resultQ + resultSigma + resultDelta + resultStart + resultFinal;
	}
}
