import com.mimi.mapper.EmpMapper;
import com.mimi.pojo.Emp;
import com.mimi.pojo.vo.EmpVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class MyTest {
    @Autowired
    EmpMapper empMapper;

    @Test
    public void teest(){
        EmpVo vo = new EmpVo();
        vo.setTypeid(1);
        vo.setEname("J");
        List<Emp> list = empMapper.tiaojianchaxun(vo);
        list.forEach(emp -> System.out.println(emp));
    }
}
