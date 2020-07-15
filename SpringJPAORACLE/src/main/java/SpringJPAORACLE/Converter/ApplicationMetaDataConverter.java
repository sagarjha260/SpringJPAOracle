package SpringJPAORACLE.Converter;

import java.io.IOException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import SpringJPAORACLE.Model.CovidResult;

@Converter(autoApply = true)
public class ApplicationMetaDataConverter implements AttributeConverter<CovidResult, String>
{
	private final static ObjectMapper ObjectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(CovidResult meta) {
		try {
			return ObjectMapper.writeValueAsString(meta);
		}
		catch (JsonProcessingException e) {
			return null;
		}
	}

	@Override
	public CovidResult convertToEntityAttribute(String dbData) {
		try {
			return ObjectMapper.readValue(dbData, CovidResult.class);
		}
		catch (IOException e) {
			return null;
		}
	}

}
