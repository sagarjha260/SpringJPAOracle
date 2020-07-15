package SpringJPAORACLE.Model;

import java.util.List;

public class CovidResult 
{
	List<Cases_time_series> listCasestimeseries;
	List<Statewise> listStatewise;
	List<Tested> listTested;
	
	public List<Cases_time_series> getListCasestimeseries() {
		return listCasestimeseries;
	}
	public void setListCasestimeseries(List<Cases_time_series> listCasestimeseries) {
		this.listCasestimeseries = listCasestimeseries;
	}
	public List<Statewise> getListStatewise() {
		return listStatewise;
	}
	public void setListStatewise(List<Statewise> listStatewise) {
		this.listStatewise = listStatewise;
	}
	public List<Tested> getListTested() {
		return listTested;
	}
	public void setListTested(List<Tested> listTested) {
		this.listTested = listTested;
	}
	
	@Override
	public String toString() {
		return "CovidData [listCasestimeseries=" + listCasestimeseries + ", listStatewise=" + listStatewise
				+ ", listTested=" + listTested + "]";
	}
    
	

}
