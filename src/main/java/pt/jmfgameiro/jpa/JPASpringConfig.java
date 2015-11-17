package pt.jmfgameiro.jpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories( "pt.jmfgameiro" )
@EnableTransactionManagement
public class JPASpringConfig {
	
private String[] packages = new String[] { "pt.jmfgameiro" };
	
	/***** BEANS *****/
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName( "oracle.jdbc.OracleDriver" );
		ds.setUrl( "jdbc:oracle:thin:@127.0.0.1:1501:SID" );
		ds.setUsername( "user" );
		ds.setPassword( "pass" );
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		try {
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
			
			// Data Source
			emf.setDataSource( dataSource() );
			
			// Packages to scan
			emf.setPackagesToScan( packages );
			
			// JPA Vendor Adapter
			HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			vendorAdapter.setShowSql( true );
			vendorAdapter.setDatabasePlatform( "org.hibernate.dialect.Oracle10gDialect" );
			emf.setJpaVendorAdapter( vendorAdapter );
			
			return emf;
		}
		catch( Exception e ) {
			throw new Exception( "Unable to initialize entity manager factory!", e );
		}
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		return new JpaTransactionManager( entityManagerFactory().getObject() );
	}
	
	
}
