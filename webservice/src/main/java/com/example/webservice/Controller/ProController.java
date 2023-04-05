package com.example.webservice.Controller;


import com.example.webservice.mapper.ProMapper;
import com.example.webservice.model.Prospector;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/prospector")
public class ProController {
    @Resource
    private ProMapper proMapper;

    @PostMapping("/add")
    public String addPro(@RequestBody Prospector prospector){
        int insert = proMapper.insert(prospector);
        return  String.valueOf(insert);
    }
    @PutMapping("/update")
    public String updatePro(@RequestBody Prospector prospector){
        if(null == prospector.getId()){return "id not null";}
        int update = proMapper.updateById(prospector);
        return  String.valueOf(update);
    }
    @DeleteMapping("/{id}")
    public String deletePro(@PathVariable Integer id){
        int delete = proMapper.deleteById(id);
        return  String.valueOf(delete);
    }
    @GetMapping("/{id}")
    public Prospector getPro(@PathVariable Integer id){
//          proMapper.selectById(id);
//          return "success";
          System.out.println(proMapper.selectById(id));
//          Prospector get =proMapper.selectById(id);
          return  proMapper.selectById(id);
//          return get;
    }
}
