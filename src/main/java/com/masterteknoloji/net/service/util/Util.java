package com.masterteknoloji.net.service.util;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.masterteknoloji.net.domain.RawTable;

public class Util {

	public static Boolean checkIsItUnnecesary(RawTable rawTable,RawTable lastRawTableofDevice ) {
    	if(lastRawTableofDevice == null)
    		return false;
    	
    	if(rawTable.getDeviceIdOriginal().equals(lastRawTableofDevice.getDeviceIdOriginal())
    		&& rawTable.getDownPeople1().longValue() == lastRawTableofDevice.getDownPeople1().longValue()	
    		&& rawTable.getUpPeople1().longValue() == lastRawTableofDevice.getUpPeople1().longValue()	
    		
    		&& rawTable.getDownPeople2().longValue() == lastRawTableofDevice.getDownPeople2().longValue()	
    		&& rawTable.getUpPeople2().longValue() == lastRawTableofDevice.getUpPeople2().longValue()	
    		
    		&& rawTable.getDownPeople3().longValue() == lastRawTableofDevice.getDownPeople3().longValue()	
    		&& rawTable.getUpPeople3().longValue() == lastRawTableofDevice.getUpPeople3().longValue()	
    			
    		&& rawTable.getDownPeople4().longValue() == lastRawTableofDevice.getDownPeople4().longValue()	
    		&& rawTable.getUpPeople4().longValue() == lastRawTableofDevice.getUpPeople4().longValue()	
    	) return true;
    		else
    	return false;
    }
	
	public static Long calculateDiffGetIn(RawTable lastRawTable,RawTable currentRawTable) {
		Long result = 0l;
		
		if( lastRawTable == null) {
			result = 0l;
		}else {
			Long totalGetInOfCurrent = calculateGetInOfRawTable(currentRawTable);
			Long totalGetInOfLast = 	calculateGetInOfRawTable(lastRawTable);
			result = totalGetInOfCurrent -totalGetInOfLast;
		}
		
		return result;
	}

	public static Long calculateDiffGetOut(RawTable lastRawTable,RawTable currentRawTable) {
		Long result = 0l;
		
		if( lastRawTable == null) {
			result = 0l;
		}else {
			Long totalGetOutOfCurrent = calculateGetOutOfRawTable(currentRawTable);
			Long totalGetOutOfLast = 	calculateGetOutOfRawTable(lastRawTable);
			result = totalGetOutOfCurrent -totalGetOutOfLast;
		}
		
		return result;
	}
	
	public static Long calculateGetInOfRawTable(RawTable rawTable) {
		Long totalGetIn = 0l;
		totalGetIn = rawTable.getUpPeople1()+rawTable.getUpPeople2()+rawTable.getUpPeople3()+rawTable.getUpPeople4();
		return totalGetIn;
	}
	
	public static Long calculateGetOutOfRawTable(RawTable rawTable) {
		Long totalGetIn = 0l;
		totalGetIn = rawTable.getDownPeople1()+rawTable.getDownPeople2()+rawTable.getDownPeople3()+rawTable.getDownPeople4();
		return totalGetIn;
	}
	
	public static Long calculateCurrentPassengerCount(RawTable lastRawTable,RawTable rawTable,Long correction) {
		if( lastRawTable == null) {
			return 0l;
		}	
		Long totalGetIn = calculateGetInOfRawTable(rawTable);
		Long totalGetOut = calculateGetOutOfRawTable(rawTable);
		
		//totalGetIn  =totalGetIn + 130;
		return totalGetIn - totalGetOut-correction;
		//return totalGetIn - totalGetOut;
	}
	
	public static Boolean isValid(RawTable rawTable) {
		Boolean result = true;
		Instant insertDate =rawTable.getInsertDate();
		Duration duration = Duration.between(insertDate, Instant.now());
		
		System.out.println(Instant.now());
		System.out.println(rawTable.getInsertDate());
		System.out.println(insertDate);
		System.out.println(duration.getSeconds());
		if(duration.getSeconds()>120)
			result = false;
		
		return result;
	}
	

}
