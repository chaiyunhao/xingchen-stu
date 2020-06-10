package cn.xingchen;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataService dataService;

    @Autowired
    private ApplicationContext applicationContext;


    @Transactional(rollbackFor = RuntimeException.class)
    public void insert(String value){
        jdbcTemplate.update("INSERT INTO FOO(BAR) VALUES (?)", value);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertAndRollBack(String value){
        jdbcTemplate.update("INSERT INTO FOO(BAR) VALUES (?)", value);
        throw new RuntimeException("do throw");
    }

    public void printAllData(){
        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(r -> System.out.println("ID : "+r.get("ID")+" , BAR : "+r.get("BAR")));
    }

    public void invokeMethod(String value){
        try{
            insertAndRollBack(value);
        }catch (RuntimeException e){
            System.out.println("insertAndRollBack Error");
        }
    }

}
