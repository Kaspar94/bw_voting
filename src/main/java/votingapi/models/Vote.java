package votingapi.models;

public class Vote {
	
	private String votedItem;
	
	Vote() {}
	
	Vote(String votedItem) {
		this.votedItem = votedItem;
	}

	public String getVotedItem() {
		return votedItem;
	}

	public void setVotedItem(String votedItem) {
		this.votedItem = votedItem;
	}

	@Override
	public String toString() {
		return "Vote [votedItem=" + votedItem + "]";
	}
	
	public String toJson() {
		return "";
	}

}
