package pt.jmfgameiro.jpa.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pt.jmfgameiro.jpa.converter.JPABooleanToSQLNumber;
import pt.jmfgameiro.jpa.converter.JPABooleanToSQLVarchar;
import pt.jmfgameiro.jpa.converter.JPALocalDateTimeToSQLTimestamp;
import pt.jmfgameiro.jpa.converter.JPALocalDateToSQLDate;

@Entity
@Table( name = "JMFGAMEIRO_JPA_TRIGGER" )
public class JmfgameiroEntity implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	/***** VARIABLES *****/
	@Id
	@SequenceGenerator( name = "SQ_JMFGAMEIRO_JPA", sequenceName = "SQ_JMFGAMEIRO_JPA_TRIGGER", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SQ_JMFGAMEIRO_JPA" )
	@Column
	private Long id;
	@Column
	private String utilizador;
	@Column( nullable = false )
	private String code;
	@Column( name = "BOOL_FROM_VARCHAR", nullable = false )
	@Convert( converter = JPABooleanToSQLVarchar.class )
	private Boolean fromVarchar;
	@Column( name = "BOOL_FROM_NUMBER", nullable = false )
	@Convert( converter = JPABooleanToSQLNumber.class )
	private Boolean fromNumber;
	@Column( name = "DATE_INSERT" )
	@Convert( converter = JPALocalDateToSQLDate.class )
	private LocalDate dateInsert;
	@Column( name = "TIMESTAMP_INSERT" )
	@Convert( converter = JPALocalDateTimeToSQLTimestamp.class )
	private LocalDateTime timestampInsert;
	
	
	/***** CONSTRUCTOR *****/
	public JmfgameiroEntity() {}
	public JmfgameiroEntity( String code, Boolean fromVarchar, Boolean fromNumber ) {
		setCode( code );
		setFromVarchar( fromVarchar );
		setFromNumber( fromNumber );
	}
	public JmfgameiroEntity( Long id, String utilizador, String code, Boolean fromVarchar, Boolean fromNumber, LocalDate dateInsert, LocalDateTime timestampInsert ) {
		setId( id );
		setUtilizador( utilizador );
		setCode( code );
		setFromVarchar( fromVarchar );
		setFromNumber( fromNumber );
		setDateInsert( dateInsert );
		setTimestampInsert( timestampInsert );
	}
	public JmfgameiroEntity( JmfgameiroEntity entity ) {
		setId( entity.id );
		setUtilizador( entity.utilizador );
		setCode( entity.code );
		setFromVarchar( entity.fromVarchar );
		setFromNumber( entity.fromNumber );
		setDateInsert( entity.dateInsert );
		setTimestampInsert( entity.timestampInsert );
	}
	
	
	/***** GET/SET *****/
	public Long getId() {
		return id;
	}
	public JmfgameiroEntity setId( Long id ) {
		this.id = id;
		return this;
	}
	public String getUtilizador() {
		return utilizador;
	}
	public JmfgameiroEntity setUtilizador( String utilizador ) {
		this.utilizador = utilizador;
		return this;
	}
	public String getCode() {
		return code;
	}
	public JmfgameiroEntity setCode( String code ) {
		this.code = code;
		return this;
	}
	public Boolean getFromVarchar() {
		return fromVarchar;
	}
	public JmfgameiroEntity setFromVarchar( Boolean fromVarchar ) {
		this.fromVarchar = fromVarchar;
		return this;
	}
	public Boolean getFromNumber() {
		return fromNumber;
	}
	public JmfgameiroEntity setFromNumber( Boolean fromNumber ) {
		this.fromNumber = fromNumber;
		return this;
	}
	public LocalDate getDateInsert() {
		return dateInsert;
	}
	public JmfgameiroEntity setDateInsert( LocalDate dateInsert ) {
		this.dateInsert = dateInsert;
		return this;
	}
	public LocalDateTime getTimestampInsert() {
		return timestampInsert;
	}
	public JmfgameiroEntity setTimestampInsert( LocalDateTime timestampInsert ) {
		this.timestampInsert = timestampInsert;
		return this;
	}
	
	
}
