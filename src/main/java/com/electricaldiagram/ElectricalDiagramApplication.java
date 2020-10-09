package com.electricaldiagram;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Zkl
 * @create: 2010-10-09
 */
@EnableTransactionManagement    //事务管理
@MapperScan("com.electricaldiagram.dao")
@SpringBootApplication
//@EnableCaching                  //缓存管理功能
@Slf4j                          //日志管理
public class ElectricalDiagramApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElectricalDiagramApplication.class, args);
    }
}
