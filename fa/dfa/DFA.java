package fa.dfa;

import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

	public void addFinalState(String nextToken) {
		// TODO Auto-generated method stub
		
	}

	public void addStartState(String startStateName) {
		// TODO Auto-generated method stub
		
	}

	public void addState(String nextToken) {
		// TODO Auto-generated method stub
		
	}

	public void addTransition(String valueOf, char c, String valueOf2) {
		// TODO Auto-generated method stub
		
	}

	public DFA complement() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean accepts(String input) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public Set<? extends State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<? extends State> getFinalStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getStartState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Character> getABC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getToState(DFAState from, char onSymb) {
		// TODO Auto-generated method stub
		return null;
	}

}
