package WMH.com.god.bo.test.service;

import WMH.com.god.bo.test.mapper.TestMapper;
import WMH.com.god.bo.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService{

    @Autowired
    public TestMapper mapper;

    public List< TestVo > selectTest(){
        return mapper.selectTest();
    }
}
