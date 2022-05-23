package WMH.hello.bit;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


import java.io.Reader;

@Slf4j
public class MysqlDbConnFactroy{

    private static Logger logger = Logger.getLogger( MysqlDbConnFactroy.class );


    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            String resource = "MysqlMapClientManger.xml";
            Reader reader = Resources.getResourceAsReader( resource );
            if ( sqlSessionFactory == null ) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build( reader );
            }

            logger.info( "Create mysql session" + sqlSessionFactory.getConfiguration().getEnvironment() );

            reader.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
