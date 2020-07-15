package SpringJPAORACLE.Model;

public class Statewise 
{
	String active;
	String confirmed;
	String deaths;
	String deltaconfirmed;
	String deltadeaths;
	String deltarecovered;
	String lastupdatedtime;
	String recovered;
	String state;
	String statenotes;
	String statecode;
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getDeltaconfirmed() {
		return deltaconfirmed;
	}
	public void setDeltaconfirmed(String deltaconfirmed) {
		this.deltaconfirmed = deltaconfirmed;
	}
	public String getDeltadeaths() {
		return deltadeaths;
	}
	public void setDeltadeaths(String deltadeaths) {
		this.deltadeaths = deltadeaths;
	}
	public String getDeltarecovered() {
		return deltarecovered;
	}
	public void setDeltarecovered(String deltarecovered) {
		this.deltarecovered = deltarecovered;
	}
	public String getLastupdatedtime() {
		return lastupdatedtime;
	}
	public void setLastupdatedtime(String lastupdatedtime) {
		this.lastupdatedtime = lastupdatedtime;
	}
	public String getRecovered() {
		return recovered;
	}
	public void setRecovered(String recovered) {
		this.recovered = recovered;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatenotes() {
		return statenotes;
	}
	public void setStatenotes(String statenotes) {
		this.statenotes = statenotes;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	@Override
	public String toString() {
		return "Statewise [active=" + active + ", confirmed=" + confirmed + ", deaths=" + deaths + ", deltaconfirmed="
				+ deltaconfirmed + ", deltadeaths=" + deltadeaths + ", deltarecovered=" + deltarecovered
				+ ", lastupdatedtime=" + lastupdatedtime + ", recovered=" + recovered + ", state=" + state
				+ ", statenotes=" + statenotes + ", statecode=" + statecode + "]";
	}
	
	

	
}
