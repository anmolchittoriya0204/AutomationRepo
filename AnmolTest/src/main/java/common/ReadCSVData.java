/**
 * 
 */
package common;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Amandeep.Philips
 *
 */
public class ReadCSVData {

	
	public static  ArrayList<String[]> getCSVData(String filename) throws Exception {
		ArrayList<String[]> myData = new ArrayList<String[]>();
		CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir") +File.separator+"datafile"+File.separator+filename));

		List<String[]> list= reader.readAll();
		 list.remove(0);
			reader.close();
		 myData.addAll(list);

		
			return myData;
		}
	
		}

