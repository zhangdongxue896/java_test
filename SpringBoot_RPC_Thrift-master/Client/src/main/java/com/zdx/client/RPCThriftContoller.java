package com.zdx.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/zdx")
public class RPCThriftContoller {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RPCThriftClient rpcThriftClient;

    @RequestMapping(value = "/thrift", method = RequestMethod.GET)
    public String thriftTest(HttpServletRequest request, HttpServletResponse response) {
        try {
            rpcThriftClient.open();
            return rpcThriftClient.getRPCThriftService().getDate("zdx");
        } catch (Exception e) {
            logger.error("RPC调用失败", e);
            return "error";
        } finally {
            rpcThriftClient.close();
        }
    }
}
