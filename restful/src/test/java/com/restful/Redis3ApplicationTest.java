package com.restful;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restful.dao.PookRepository;
import com.restful.entity.Pooks;

@SpringBootTest
public class Redis3ApplicationTest {

    @Autowired
    private PookRepository pookRepository;

    @Test // 添加图书
    void testSavePooks() {
        Pooks book1 = new Pooks(1, "西游记", "文学", "吴承恩", 88);
        pookRepository.save(book1);
        Pooks book2 = new Pooks(2, "三国演义", "文学", "罗贯中", 78);
        pookRepository.save(book2);
        Pooks book3 = new Pooks(3, "水浒传", "文学", "施耐俺", 68);
        pookRepository.save(book3);
        Pooks book4 = new Pooks(4, "三国志", "文学", "佚名", 78);
        pookRepository.save(book4);
        System.out.println("添加成功！");
    }

    @Test // 查询所有图书
    void testFindAllPookss() {
        Iterable<Pooks> iterable = pookRepository.findAll();
        Iterator<Pooks> it = iterable.iterator();
        while (it.hasNext()) {
            Pooks book = it.next();
            System.out.println(book);
        }
    }

    @Test // 根据Id号图书
    void testFindPooksById() {
        Pooks book = pookRepository.findById(1).get();
        System.out.println(book);
    }

    // @Test //根据Name查询图书
    // void testFindPookssByName() {
    // Iterable<Pooks> iterable=pookRepository.findByName("三国志");
    // Iterator<Pooks> it=iterable.iterator();
    // while(it.hasNext()){
    // Pooks book= it.next();
    // System.out.println(book);
    // }
    // }

    @Test // 修改图书
    void testUpdatePooks() {
        Pooks book = pookRepository.findById(1).get();
        book.setPrice(98);
        pookRepository.save(book);
        System.out.println("修改成功！");
    }

    @Test // 删除图书
    void testDeletePooks() {
        pookRepository.deleteById(4);
        System.out.println("删除成功！");
    }
}
