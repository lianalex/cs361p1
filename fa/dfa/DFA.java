package fa.dfa;

import java.util.HashSet;
import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

	// DFA elements that are sets, e.g., set of states Q
	public HashSet<State> Q = new HashSet<>();
	public HashSet<State> F = new HashSet<>();


	/**
	 * Adds a final state to the DFA
	 * @param name is the label of the state
	 */
	public void addFinalState(String nextToken) {
		//F.add(State);
		
	}

	/**
	 * Adds the initial state to the DFA instance
	 * @param name is the label of the start state
	 */
	public void addStartState(String startStateName) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Adds a non-final, not initial state to the DFA instance
	 * @param name is the label of the state 
	 */
	public void addState(String nextToken) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Adds the transition to the DFA's delta data structure
	 * @param fromState is the label of the state where the transition starts
	 * @param onSymb is the symbol from the DFA's alphabet.
	 * @param toState is the label of the state where the transition ends
	 */
	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/**
	 * Getter for Q
	 * @return a set of states that FA has
	 */
	@Override
	public Set<? extends State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter for F
	 * @return a set of final states that FA has
	 */
	@Override
	public Set<? extends State> getFinalStates() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter for q0
	 * @return the start state of FA
	 */
	@Override
	public State getStartState() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter for Sigma
	 * @return the alphabet of FA
	 */
	@Override
	public Set<Character> getABC() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Uses transition function delta of FA
	 * @param from the source state
	 * @param onSymb the label of the transition
	 * @return the sink state.
	 */
	@Override
	public State getToState(DFAState from, char onSymb) {
		// TODO Auto-generated method stub
		return null;
	}

}
