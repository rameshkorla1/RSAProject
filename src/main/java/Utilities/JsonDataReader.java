package Utilities;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader {
	
	public List<HashMap<String, String>> getJsonDataReader(String filePath) throws IOException
	{
		// read the json to string from data file
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	    //String to HashMap- Jackson Datbind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
