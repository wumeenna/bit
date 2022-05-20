package WMH.hello.bit.service;

import WMH.hello.bit.dao.AdPolicyDAO;
import WMH.hello.bit.domain.AdPolicyVO;
import WMH.hello.bit.MysqlDbConnFactroy;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class VdiMgmtServiceImpl implements VdiMgmtservice{

    private final Logger logger = Logger.getLogger( VdiMgmtServiceImpl.class );

    @Override
    public List< AdPolicyVO > getAdPolicyList( AdPolicyVO adPolicyVO ){

        List< AdPolicyVO > AdpolicyList;
        AdPolicyDAO adPolicyDAO = new AdPolicyDAO( MysqlDbConnFactroy.getSqlSessionFactory() );
        AdpolicyList = adPolicyDAO.sAdPolicyList( adPolicyVO );

        return AdpolicyList;
    }

    @Override
    public int setAdPoilcy( AdPolicyVO adPolicyVO ){

        int result = 0;

        AdPolicyDAO adPolicyDAO = new AdPolicyDAO( MysqlDbConnFactroy.getSqlSessionFactory() );

        SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar time = Calendar.getInstance();
        String format_time1 = format1.format( time.getTime() );
        adPolicyVO.setCreate_dtm( format_time1 );

        result = adPolicyDAO.iAdPolicy( adPolicyVO );

        return result;
    }
}
