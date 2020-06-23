package env;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
XML설정파일의 역할을 대신하는 클래스로 정의함
 */
@Configuration
public class EnvApplicationConfig {

	/*
	@Value
		: 멤버변수 초기값을 어노테이션으로 정의한다.
	 */
	@Value("${board1.user}")
	private String board_user; //계정아이디
	
	@Value("${board1.pass}")
	private String board_pass; //계정패스워드
	
	@Value("${board2.driver}")
	private String board_driver; //접속 드라이버
	
	@Value("${board2.url}")
	private String board_url; //접속 url
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		
		locations[0] = new ClassPathResource("EnvBoard1.properties");
		locations[1] = new ClassPathResource("EnvBoard2.properties");
		
		config.setLocations(locations);
		return config;
		
	}
	@Bean
	public BoardConnection boardConfig() {
		BoardConnection bconn = new BoardConnection();
		
		bconn.setUser(board_user);
		bconn.setPass(board_pass);
		bconn.setDriver(board_driver);
		bconn.setUrl(board_url);
		
		return bconn;
	}
}
