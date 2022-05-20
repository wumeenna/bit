package WMH.com.god.bo.test.mapper;

import WMH.com.god.bo.test.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper{
    List<TestVo> selectTest();
}
