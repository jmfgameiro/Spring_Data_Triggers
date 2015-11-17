package pt.jmfgameiro.jpa.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public final class JPALocalDateToSQLDate implements AttributeConverter< LocalDate, Date > {
	
	
	/**
	 * Method to convert a LocalDate to a SQL Date.
	 * @param localDate LocalDate
	 * @return Date
	 */
	public final Date convertToDatabaseColumn( LocalDate localDate ) {
		// If the parameter is null, then return null
		if( localDate == null )
			return null;
		// Otherwise, convert it to the respective element
		return Date.valueOf( localDate );
	}
	
	/**
	 * Method to convert a SQL Date to a LocalDate.
	 * @param date Date
	 * @return LocalDate
	 */
	public final LocalDate convertToEntityAttribute( Date date ) {
		// If the parameter is null, then return null
		if( date == null )
			return null;
		// Otherwise, convert it to the respective element
		return date.toLocalDate();
	}
	
	
}
