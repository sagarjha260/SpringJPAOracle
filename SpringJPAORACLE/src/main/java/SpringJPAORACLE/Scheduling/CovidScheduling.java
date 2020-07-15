package SpringJPAORACLE.Scheduling;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import SpringJPAORACLE.Model.Cases_time_series;
import SpringJPAORACLE.Model.CovidData;
import SpringJPAORACLE.Model.CovidResult;
import SpringJPAORACLE.Model.Statewise;
import SpringJPAORACLE.Model.Tested;
import SpringJPAORACLE.Repo.CovidDataRepo;
import javassist.NotFoundException;

@EnableScheduling
@RestController
//@Component
public class CovidScheduling {

	@Autowired
	CovidDataRepo covidDataRepo;

	@Autowired
	RestTemplate restTemplate;

	// @Scheduled(cron = "0 * * * * *") // for every minute
	// @Scheduled(cron = "59 * * * * *") // for every 1 hour
	@RequestMapping("/testCovid")
	public List<CovidData> getProductList() {
		final String uri = "https://api.covid19india.org/data.json";
		String result = restTemplate.getForObject(uri, String.class);
		JsonObject data = new Gson().fromJson(result, JsonObject.class);

		List<Cases_time_series> listCasestimeseries = new ArrayList<>();
		List<Statewise> listStatewise = new ArrayList<>();
		List<Tested> listTested = new ArrayList<>();

		for (JsonElement element : data.get("cases_time_series").getAsJsonArray()) {
			Cases_time_series caseSeries = new Cases_time_series();
			caseSeries.setDailyconfirmed(element.getAsJsonObject().get("dailyconfirmed").getAsString());
			caseSeries.setDailydeceased(element.getAsJsonObject().get("dailydeceased").getAsString());
			caseSeries.setDailyrecovered(element.getAsJsonObject().get("dailyrecovered").getAsString());
			caseSeries.setDate(element.getAsJsonObject().get("date").getAsString());
			caseSeries.setTotalconfirmed(element.getAsJsonObject().get("totalconfirmed").getAsString());
			caseSeries.setTotaldeceased(element.getAsJsonObject().get("totaldeceased").getAsString());
			caseSeries.setTotalrecovered(element.getAsJsonObject().get("totalrecovered").getAsString());

			listCasestimeseries.add(caseSeries);
		}

		for (JsonElement element : data.get("statewise").getAsJsonArray()) {
			Statewise state = new Statewise();
			state.setActive(element.getAsJsonObject().get("active").getAsString());
			state.setConfirmed(element.getAsJsonObject().get("confirmed").getAsString());
			state.setDeaths(element.getAsJsonObject().get("deaths").getAsString());
			state.setDeltaconfirmed(element.getAsJsonObject().get("deltaconfirmed").getAsString());
			state.setDeltadeaths(element.getAsJsonObject().get("deltadeaths").getAsString());
			state.setDeltarecovered(element.getAsJsonObject().get("deltarecovered").getAsString());
			state.setLastupdatedtime(element.getAsJsonObject().get("lastupdatedtime").getAsString());
			state.setRecovered(element.getAsJsonObject().get("recovered").getAsString());
			state.setState(element.getAsJsonObject().get("state").getAsString());
			state.setStatecode(element.getAsJsonObject().get("statecode").getAsString());
			state.setStatenotes(element.getAsJsonObject().get("statenotes").getAsString());

			listStatewise.add(state);
		}

		for (JsonElement element : data.get("tested").getAsJsonArray()) {
			Tested tested = new Tested();
			tested.setIndividualstestedperconfirmedcase(element.getAsJsonObject().get("individualstestedperconfirmedcase").getAsString());
			tested.setPositivecasesfromsamplesreported(element.getAsJsonObject().get("positivecasesfromsamplesreported").getAsString());
			tested.setSamplereportedtoday(element.getAsJsonObject().get("samplereportedtoday").getAsString());
			tested.setSource(element.getAsJsonObject().get("source").getAsString());
			tested.setTestpositivityrate(element.getAsJsonObject().get("testpositivityrate").getAsString());
			tested.setTestsconductedbyprivatelabs(element.getAsJsonObject().get("testsconductedbyprivatelabs").getAsString());
			tested.setTestsperconfirmedcase(element.getAsJsonObject().get("testsperconfirmedcase").getAsString());
			tested.setTotalindividualstested(element.getAsJsonObject().get("totalindividualstested").getAsString());
			tested.setTotalpositivecases(element.getAsJsonObject().get("totalpositivecases").getAsString());
			tested.setTotalsamplestested(element.getAsJsonObject().get("totalsamplestested").getAsString());
			tested.setUpdatetimestamp(element.getAsJsonObject().get("updatetimestamp").getAsString());

			listTested.add(tested);
		}

		CovidResult covidResult = new CovidResult();
		covidResult.setListCasestimeseries(listCasestimeseries);
		covidResult.setListStatewise(listStatewise);
		covidResult.setListTested(listTested);

		CovidData covidData = new CovidData();
		covidData.setCovidResult(covidResult);

		// Insert/Update all JSOn into DB
		/*
		 * List<CovidData> listDBData = covidDataRepo.findAll();
		 * if(listDBData.isEmpty()) { LocalDateTime now = LocalDateTime.now();
		 * covidData.setCreatedAt(now); covidData.setId(1);
		 * covidDataRepo.save(covidData); } else { CovidData dbData = listDBData.get(0);
		 * if(covidData != null) { dbData.setCovidResult(covidData.getCovidResult());
		 * covidData.setId(1); covidDataRepo.save(covidData); } }
		 */

		// Getting data from DB (for Cases_time_series array)
		List<ArrayList<Cases_time_series>> listoflistCTS= new ArrayList<ArrayList<Cases_time_series>>();
		List<Cases_time_series> listCTS= new ArrayList<Cases_time_series>();
		
		List<CovidData> listCovidDataFromDB = covidDataRepo.findAll();
		for (CovidData cd : listCovidDataFromDB) 
		{
			listoflistCTS.add((ArrayList<Cases_time_series>) cd.getCovidResult().getListCasestimeseries());
			
			System.out.println(cd.getCovidResult().getListCasestimeseries().get(0));
			
		}

		System.out.println("listoflistCTS size : "+listoflistCTS.size());
		System.out.println("listoflistCTS : "+listoflistCTS);
		
		for (List<Cases_time_series> lcts : listoflistCTS) {
			for(Cases_time_series cts: lcts) {
				listCTS.add(cts);
			}
		}
		
		System.out.println("listCTS size : "+listCTS.size());
		System.out.println("listCTS : "+listCTS);
		
		for(Cases_time_series cts : listCTS) 
		{
			System.out.println("getDailyconfirmed "+cts.getDailyconfirmed());
			System.out.println("getDailydeceased "+cts.getDailydeceased());
			System.out.println("getDailyrecovered "+cts.getDailyrecovered());
			System.out.println("getTotalconfirmed "+cts.getTotalconfirmed());
			System.out.println("getTotaldeceased "+cts.getTotaldeceased());
			System.out.println("getTotalrecovered "+cts.getTotalrecovered());
			System.out.println("getDate "+cts.getDate());
			System.out.println("\n");
		}

		return listCovidDataFromDB;

	}

	//Converting object into json and sending to other url (POST)
	public JsonObject getApiResponse(Object object, String url) throws URISyntaxException, Exception
	{
		String token="hf12334";
		Object user= new ObjectMapper().writeValueAsString(object); 
		URI covidURI= new URI(url);
		MultiValueMap<String, String> headers= new LinkedMultiValueMap<String, String>();
		headers.add("Authorization", "Bearer"+token);
		headers.add("Content Type", "application/json");
		HttpEntity<Object> entity = new HttpEntity<>(user, headers);
		
		ResponseEntity<Object> resp= restTemplate.exchange(covidURI, HttpMethod.POST, entity, Object.class);
		if(resp.getStatusCode().equals(HttpStatus.NOT_FOUND))
			throw new NotFoundException("No Data avialbale for the given request");
		
		String jsonString= new Gson().toJson(resp.getBody(), LinkedHashMap.class);
		JsonObject data= new Gson().fromJson(jsonString, JsonObject.class); 
		if(data.has("error")) {
			//Do needful
		}
		return data;
	}

}
