package cn.roilat.study.socket;

import com.crfchina.salary.p2p.emp.entity.SalaryP2pEmp;
import com.crfchina.salary.p2p.emp.service.logic.SalaryP2pEmpLogicInterface;
import com.summer.kernel.util.Crf3Des;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.context.ApplicationContext;

public class SalaryServerHandler extends IoHandlerAdapter {
	
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//���տͻ��˱���, ���ؽ��
		String str = message.toString();
		String idCard = Crf3Des.cdsDecrypt(str);
		ApplicationContext ac = MyApplicationContextUtil.getContext();
		SalaryP2pEmpLogicInterface salaryP2pEmpLogic = (SalaryP2pEmpLogicInterface) ac.getBean("salaryP2pEmpLogic");
		String empNo = "N";
		if (idCard != null && !idCard.equals("")) {
			SalaryP2pEmp emp = salaryP2pEmpLogic.querySalaryP2pEmpByIdCard(idCard);
			if (emp != null) {
				empNo = emp.getEmpNo();
			}
		}
		String desStr = Crf3Des.cdsEncrypt(empNo);
		session.write(desStr);
		session.close(true);
		//log.info("��ѯ���ҵ��ԱԱ����ţ����ҵ��Ա���֤�ţ�" + idCard + "; ���ҵ��ԱԱ����ţ�" + empNo + "��");
	}
	
}