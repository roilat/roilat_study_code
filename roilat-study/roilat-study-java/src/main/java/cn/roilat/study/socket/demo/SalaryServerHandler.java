package cn.roilat.study.socket.demo;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import cn.roilat.study.utils.copybak.Crf3Des;

public class SalaryServerHandler extends IoHandlerAdapter {

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        System.out.println("message=" + str);
        String idCard = Crf3Des.cdsDecrypt(str);
        System.out.println(idCard);
        // query empNo by idCard
        String empNo = "N";
        String desStr = Crf3Des.cdsEncrypt(empNo);
        session.write(desStr);
        session.close(true);
    }

}