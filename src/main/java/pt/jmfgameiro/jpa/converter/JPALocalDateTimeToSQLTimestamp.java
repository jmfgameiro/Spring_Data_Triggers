package pt.jmfgameiro.jpa.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JPALocalDateTimeToSQLTimestamp implements AttributeConverter< LocalDateTime, Timestamp > {
	
	
	/**
	 * Method to convert a LocalDateTime to a SQL Timestamp.
	 * @param localDateTime LocalDateTime
	 * @return Timestamp
	 */
	public final Timestamp convertToDatabaseColumn( LocalDateTime localDateTime ) {
		// If the parameter is null, then return null
		if( localDateTime == null )
			return null;
		// Otherwise, convert it to the respective element
		return Timestamp.valueOf( localDateTime );
	}
	
	/**
	 * Method to convert a SQL Timestamp to a LocalDateTime.
	 * @param timestamp
	 * @return
	 */
	public final LocalDateTime convertToEntityAttribute( Timestamp timestamp ) {
		// If the parameter is null, then return null
		if( timestamp == null )
			return null;
		// Otherwise, convert it to the respective element
		return timestamp.toLocalDateTime();
	}
	
	
}
