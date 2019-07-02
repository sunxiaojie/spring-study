package com.sxj.product;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.sxj.product.domain.OrderInfoDO;
import com.sxj.product.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApp.class)
public class ProductTest {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void exportExcel() throws FileNotFoundException {
        Integer orderSize = orderMapper.countOrderList();
        System.out.println("订单size===============================" + orderSize);

        OutputStream out = new FileOutputStream("/Users/sunxiaojie/Downloads/aaa.xlsx");
        ExcelWriter excelWriter = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        int page = 5000;
        orderSize = 50000;
        int num = orderSize / page;
        Integer start;
        for (int i = 1; i <= num; i++) {
            start = (i - 1) * page;
            Sheet sheet = new Sheet(1, 1, OrderInfoDO.class);
            System.out.println(String.format("处理了第%s页，开始%s,页值%s", i, start, page));
            List<OrderInfoDO> orderInfoDOList = orderMapper.queryOrderList(start, page);
            excelWriter.write(orderInfoDOList, sheet);
            System.out.println(String.format("处理了第%s页,订单数量%s", i, orderInfoDOList.size()));
        }
        excelWriter.finish();

        System.out.println("end");
    }
}
