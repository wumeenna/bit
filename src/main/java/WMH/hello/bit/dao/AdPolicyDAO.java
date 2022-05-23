package WMH.hello.bit.dao;

import WMH.hello.bit.domain.AdPolicyVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.util.List;

public class AdPolicyDAO{

    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    Logger logger = Logger.getLogger( this.getClass() );

    public AdPolicyDAO( SqlSessionFactory sqlSessionFactory ){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List< AdPolicyVO > sAdPolicyList( AdPolicyVO adPolicyVO ){
        SqlSession session = sqlSessionFactory.openSession( true );
        List<AdPolicyVO> result = null;

        try {
            result = session.selectList( "AdPolicyMapper.sAdPolicyList" , adPolicyVO );
        } catch ( Exception e ) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public int iAdPolicy( AdPolicyVO adPolicyVO ){
        SqlSession session = sqlSessionFactory.openSession( true );
        int result = 0;

        try {
            result = session.update( "AdPolicyMapper.iAdPolicyList" , adPolicyVO );
        } catch ( Exception e ) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

}
