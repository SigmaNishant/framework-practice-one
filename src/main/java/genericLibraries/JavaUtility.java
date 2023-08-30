package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable java method
 * @author NISHANT KUMAR
 *
 */

public class JavaUtility {
	
	/**
	 * This method generates random number within limit
	 * @param limit
	 * @return 
	 * @return
	 */
	
	public int generateRandomNum(int limit)   {
		Random random = new Random();
		int randomNum = random.nextInt(limit);
		return randomNum;
		
	}
	
	/**
	 * This method returns current time in specified format
	 * @return 
	 * @return
	 */
	
	
	public String getCurrentTime()   {
		Date date = new Date(); 
	    SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_hh_mm_sss");
		String currentTime = sdf.format(date);
		return currentTime;
		
	}

}
