package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TicketDAO {
	
	//스프링JDBC를 사용하기 위한 멤버변수와 빈을 주입받기위한 setter() 
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	//트랜잭션 처리를 위한 멤버변수와 setter() 설정
	PlatformTransactionManager transactionManager;
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	/*
	위 2개의 멤버변수는 servlet-context.xml에서  TransactionDAO빈을 생성할때
	초기화된다.
	 */
	
	//기본생성자
	public TicketDAO() {
		System.out.println("TicketDAO생성자 호출 : "+template);
	}
	
	//티켓구매와 결제를 위한 메소드
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()메소드 호출");
		System.out.println(dto.getCustomerId()+"님이 "+"티켓 "+dto.getAmount() +"장을 구매합니다.");
		
		//DAO에서 트랜잭션 처리를 위한 객체생성
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		//2개의 업무를 하나의 프로세스로 처리하기 위해 try~catch로 묶어준다.
		/*
		※ 테스트시에는 아래 두개의 업무처리 로직을 try문 밖으로 이동한 후
		구매를 해본다. 6장 이상인 경우 pay테이블에는 insert되지만, ticket테이블에는
		제약조건 위배로 insert되지 않는다.
		 */
		try {
			//티켓 결제금액에 대한 DB처리
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String query = "INSERT INTO transaction_pay (customerId, amount) VALUES(?, ?)";
					PreparedStatement psmt = con.prepareStatement(query);
					psmt.setString(1, dto.getCustomerId());
					psmt.setInt(2, dto.getAmount()*10000);
					return psmt;
				}
			});
			//티켓 구매 처리
			/*
			check제약조건에 의해 countNum이 5를 초과하는 경우에는 제약조건위배로
			에러(예외)가 발생된다.
			 */
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String query = "INSERT INTO transaction_ticket (customerId, countNum) VALUES (?,?)";
					PreparedStatement psmt = con.prepareStatement(query);
					psmt.setString(1, dto.getCustomerId());
					psmt.setInt(2, dto.getAmount());
					return psmt;
				}
			});
			/*
			티켓구매갯수가 5이하인 경우 정상처리되어 모든 작업이 commit된다.
			 */
			System.out.println("카드결제와 티켓구매 모두 정상처리 되었습니다.");
			transactionManager.commit(status);
		}
		catch (Exception e) {
			/*
			티켓구매갯수가 6이상인 경우 예외가 발생되어 모든 작업은 
			취소(rollback)처리된다.
			 */
			System.out.println("제약조건을 위배하여 카드결제와 티켓구매 모두가 취소 되었습니다.");
			transactionManager.rollback(status);
		}
	}

}
