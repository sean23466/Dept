package com.stx.myproject.controller;

import com.stx.myproject.entity.Dept;
import com.stx.myproject.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptRepository deptRepository;
    @GetMapping("/findAll/{page}/{size}")
    /*page是查詢第幾頁*/
    public Page<Dept> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page, size);
        return deptRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody Dept dept){
        Dept result = deptRepository.save(dept);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{deptno}")
    public Dept findById(@PathVariable("deptno") Integer deptno){
       return deptRepository.findById(deptno).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Dept dept){
        Dept result = deptRepository.save(dept);
        if(result!=null){
            return "success";
        }else{
            return "error";
        }
    }
    @DeleteMapping("/delete/{deptno}")
    public void delete(@PathVariable("deptno") Integer deptno){
        deptRepository.deleteById(deptno);
    }
}
