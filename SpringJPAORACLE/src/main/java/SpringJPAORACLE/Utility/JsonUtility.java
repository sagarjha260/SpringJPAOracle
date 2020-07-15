package SpringJPAORACLE.Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility 
{
	static ObjectMapper mapper = new ObjectMapper();
	
	public static String converttoJson(Object javaObject)
	{
		String x = null;
		try {
			x= mapper.writeValueAsString(javaObject);
		}
		
		catch(JsonProcessingException e){
		}
		return x;
	}

	public static <T> T toObject(String jsonString, Class<T> classType) throws JsonMappingException, JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		T x = mapper.readValue(jsonString, classType);
		return x;
	}
	
}
