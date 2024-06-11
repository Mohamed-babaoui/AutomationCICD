/*package org.data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {


	public Object[][] getData() throws IOException {
		// Load the JSON file
		FileReader reader = new FileReader("src/test/java/org/data/PurchaseOrder.json");

		// Parse JSON file to List of HashMaps
		Type listType = new TypeToken<List<HashMap<String, String>>>() {}.getType();
		List<HashMap<String, String>> dataList = new Gson().fromJson(reader, listType);

		// Convert List to Object array
		Object[][] data = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			data[i][0] = dataList.get(i);
		}

		reader.close();
		return data;
	}
}
*/