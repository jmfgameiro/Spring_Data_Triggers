package pt.jmfgameiro.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JPABooleanToSQLVarchar implements AttributeConverter< Boolean, String > {
	
	
	/**
	 * Method to convert a Boolean to a SQL Varchar.
	 * @param bool Boolean
	 * @return String
	 */
	public final String convertToDatabaseColumn( Boolean bool ) {
		// If the parameter is null, then return null
		if( bool == null )
			return null;
		// Otherwise, convert it to the respective element
		return bool ? "S" : "N";
	}
	
	/**
	 * Method to convert a SQL Varchar to a Boolean.
	 * @param str String
	 * @return Boolean
	 */
	public final Boolean convertToEntityAttribute( String str ) {
		// If the parameter is null, then return null
		if( str == null )
			return null;
		// Otherwise, convert it to the respective element
		return Boolean.valueOf( str.equals( "S" ) );
	}
	
	
}
