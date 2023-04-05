package com.hansonwang99.server;

import com.zdx.thrift.api.RPCDateService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RPCDateServiceImpl implements RPCDateService.Iface {
    @Override
    public String getDate(String userName) throws TException {

        Date now=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
        String nowTime = simpleDateFormat.format( now );
        return "Hello " + userName + "\n" + nowTime;
    }
}
