package pt.jmfgameiro.jpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pt.jmfgameiro.jpa.entities.JmfgameiroEntity;
import pt.jmfgameiro.jpa.repositories.JmfgameiroRepository;

@RestController
public class JmfgameiroController {
	
	/*****  *****/
	private JmfgameiroRepository repository;
	
	
	/*****  *****/
	@Autowired
	public JmfgameiroController( JmfgameiroRepository repository ) {
		this.repository = repository;
	}
	
	
	/*****  *****/
	@RequestMapping( value = "/add1", method = RequestMethod.GET )
	public boolean put1() {
		try {
			JmfgameiroEntity entity = new JmfgameiroEntity( "ADD1", true, false );
			entity = this.repository.save( entity );
			return true;
		}
		catch( JpaSystemException e ) {
			System.out.println( "EXCEPTION MESSAGE: " + e.getMessage() );
			System.out.println( "ROOT EXCEPTION MESSAGE:" + e.getRootCause().getMessage() );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		return false;
	}
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public boolean get() {
		List< JmfgameiroEntity > ite = this.repository.findAll();
		if( ite.size() == 0 )
			return false;
		
		for( JmfgameiroEntity entity : ite )
			System.out.println( "Entity: " + entity.getCode() + "  |" + entity.getDateInsert() + "  |" + entity.getTimestampInsert() + "  |" + entity.getFromNumber() + "  |" + entity.getFromVarchar() + "  |" + entity.getUtilizador() );
		
		return true;
	}
	
	
}
