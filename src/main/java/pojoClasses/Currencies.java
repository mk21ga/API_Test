package pojoClasses;

import java.util.HashMap;

public class Currencies {

	private HashMap<String, Double> conversion_rates = new HashMap<String, Double>();
	private String result;
	private String documentation;
	private String terms_of_use;
	public String getResult() {
		return result;
	}

	public String getDocumentation() {
		return documentation;
	}

	public String getTerms_of_use() {
		return terms_of_use;
	}

	public int getTime_last_update_unix() {
		return time_last_update_unix;
	}

	public String getTime_last_update_utc() {
		return time_last_update_utc;
	}

	public int getTime_next_update_unix() {
		return time_next_update_unix;
	}

	public String getTime_next_update_utc() {
		return time_next_update_utc;
	}

	public String getBase_code() {
		return base_code;
	}

	private int time_last_update_unix;
	private String time_last_update_utc;
	private int time_next_update_unix;
	private String time_next_update_utc;
	private String base_code;
	
	public HashMap<String, Double> getConversion_rates()
	{
		return conversion_rates;
	}
}
