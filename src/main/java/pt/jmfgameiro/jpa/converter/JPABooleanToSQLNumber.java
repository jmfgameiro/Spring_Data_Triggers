package pt.jmfgameiro.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JPABooleanToSQLNumber implements AttributeConverter< Boolean, Integer > {
	
	
	/**
	 * Method to convert a Boolean to a SQL Number.
	 * @param bool Boolean
	 * @return Integer
	 */
	public final Integer convertToDatabaseColumn( Boolean bool ) {
		// If the parameter is null, then return null
		if( bool == null )
			return null;
		// Otherwise, convert it to the respective element
		return bool ? 1 : 0;
	}
	
	/**
	 * Method to convert a SQL Number to a Boolean.
	 * @param value Integer
	 * @return Boolean
	 */
	public final Boolean convertToEntityAttribute( Integer value ) {
		// If the parameter is null, then return null
		if( value == null )
			return null;
		// Otherwise, convert it to the respective element
		return Boolean.valueOf( value.equals( 1 ) );
	}
	
	
}
