/*
Create a class called Club which includes:
- the name of a club
- club's country
- the group it belongs to
- and whether it is the 1st or 2nd in the group
*/

public class Club {
	String name;
	String nation;
	char group;
	int ranking;
	
	public Club(String name, String nation, int ranking, char group) {
		this.name = name;
		this.nation = nation;
		this.ranking = ranking;
		this.group = group;
	}
	
        // Return true if it is possible to play against other club in the round of 16
        // otherwise return false
	public boolean hasConflictWith(Club other) {
		if (this.nation.equals(other.nation)) {
			return false;
		}
		if (this.group == other.group) {
			return false;
		}
		if (this.nation.equals("Russia") && other.nation.equals("Ukraine")) {
			return false;
		}
		if (this.nation.equals("Ukraine") && other.nation.equals("Russia")) {
			return false;
		}
		return true;
	}

	public String toString() { 
		return this.name + "(" + this.group + this.ranking + ")";
	}
}
