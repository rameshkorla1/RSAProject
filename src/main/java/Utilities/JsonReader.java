package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JsonReader {
	
	public static Object[][] getdata(String JSON_path, String typeData, int totalDataRow, int totalColumnEntry) throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{ 
		JsonParser jsonParser =  new JsonParser();
		JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
        JsonArray array = (JsonArray) jsonObj.get(typeData);
        return searchJsonElemnet(array, totalDataRow, totalColumnEntry);
	}

	/*
	 * converting a dynamic 2DList to 2Darray.
	 * As it will automatically allocate [row, column] to arrary,no need to specify
	 */
	 public static Object[][] toArray(List<List<Object>> list) 
	 {
		 Object[][] r = new Object[list.size()+1][];
		    int i = 0;
		    for (List<Object> next : list) 
		    {
		       r[i++] = next.toArray(new Object[next.size()+1]);
		    }
		    return r;
	 }
	
	public static Object[][] searchJsonElemnet(JsonArray jsonArray, int totalDataRow, int totalColumnEntry) throws NullPointerException 
	{
		//using gson google simple
		//String[][] stringArray = list.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);		
//		List<List<Object>> list = new ArrayList<List<Object>>();
//		Object[][] matrix = JsonReader.toArray(list);			
		Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
        int i =0;
        int j = 0;
        for (JsonElement jsonElement : jsonArray) 
        {
             for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) 
             {
            	 matrix[i][j] = entry.getValue().toString().replace("\"","");
                 j++;   
            }
            i++;
            j = 0;
        }
        return matrix;
	}

}
