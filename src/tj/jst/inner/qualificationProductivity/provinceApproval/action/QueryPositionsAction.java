package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;
import com.tj.jst.outside.staffmanage.positions.condition.PositionsCondition;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * ��ѯ��λ��Ա
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPositionsAction extends BaseAction {

	private List<Positions> list;
	private int Anquan; // ��ȫԱ
	private int Biaozhun;// ��׼Ա
	private int Cailiao; // ����Ա
	private int Celiang; // ���̲���Ա
	private int Zaojia; // �������Ա
	private int Jiance;// ���̼��Ա
	private int Hetong; // ��ͬԱ
	private int Jixie;// ��еԱ
	private int Jishu; // ������ԱԱ
	private int Jianzheng; // ��֤Ա
	private int Laowu;// ����Ա
	private int Quyang; // ȡ��Ա
	private int Fuze; // ����������Ա
	private int Zhiliang; // �������Ա
	private int Ziliao; // ����Ա
	private int Shigong;// ʩ��Ա
	private String corpName;
	private String FDuty;

	private PositionsCondition condition = new PositionsCondition();

	public void setCondition(PositionsCondition condition) {
		this.condition = condition;
	}

	public PositionsCondition getCondition() {
		PositionsCondition sessionCondition = (PositionsCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ѯ��λ��Ա
	 * 
	 * @return
	 */
	public String getPositions() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		currentPage = provinceApprovalService.queryPositions(this
				.getCondition());
		corpName = this.getCondition().getCorpName();
		list = provinceApprovalService.queryPositionsNum(corpName);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAnquan() != null) {
				Anquan++;
			}
			if (list.get(i).getCailiao() != null) {
				Cailiao++;
			}
			if (list.get(i).getBiaozhun() != null) {
				Biaozhun++;
			}
			if (list.get(i).getCeliang() != null) {
				Celiang++;
			}
			if (list.get(i).getZaojia() != null) {
				Zaojia++;
			}
			if (list.get(i).getJiance() != null) {
				Jiance++;
			}
			if (list.get(i).getHetong() != null) {
				Hetong++;
			}
			if (list.get(i).getJixie() != null) {
				Jixie++;
			}
			if (list.get(i).getJishu() != null) {
				Jishu++;
			}
			if (list.get(i).getJianzheng() != null) {
				Jianzheng++;
			}
			if (list.get(i).getLaowu() != null) {
				Laowu++;
			}
			if (list.get(i).getQuyang() != null) {
				Quyang++;
			}
			if (list.get(i).getFuze() != null) {
				Fuze++;
			}
			if (list.get(i).getShigong() != null) {
				Shigong++;
			}
			if (list.get(i).getZhiliang() != null) {
				Zhiliang++;
			}
			if (list.get(i).getZiliao() != null) {
				Ziliao++;
			}
		}

		this.set(getActionName(), condition);
		return "getPositions";
	}

	/**
	 * ��λ��Ա��ϸ�鿴
	 * 
	 * @return
	 */
	public String getSomePositions() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		condition = this.getCondition();
		if (FDuty != null) {
			switch (FDuty) {
			case "1":
				condition.setDuty("��ȫԱ");
				break;
			case "2":
				condition.setDuty("��׼Ա");
				break;
			case "3":
				condition.setDuty("����Ա");
				break;
			case "4":
				condition.setDuty("���̲���Ա");
				break;
			case "5":
				condition.setDuty("���̼��Ա");
				break;
			case "6":
				condition.setDuty("�������Ա");
				break;
			case "7":
				condition.setDuty("��ͬԱ");
				break;
			case "8":
				condition.setDuty("��еԱ");
				break;
			case "9":
				condition.setDuty("������Ա");
				break;
			case "10":
				condition.setDuty("��֤Ա");
				break;
			case "11":
				condition.setDuty("����Ա");
				break;
			case "12":
				condition.setDuty("ȡ��Ա");
				break;
			case "13":
				condition.setDuty("ʩ���ֳ�����������");
				break;
			case "14":
				condition.setDuty("ʩ��Ա");
				break;
			case "15":
				condition.setDuty("����Ա");
				break;
			case "16":
				condition.setDuty("����Ա");
				break;
			}
		}

		currentPage = provinceApprovalService.queryPositions(condition);
		this.set(getActionName(), condition);
		return "getSomePositions";
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public List<Positions> getList() {
		return list;
	}

	public void setList(List<Positions> list) {
		this.list = list;
	}

	public int getAnquan() {
		return Anquan;
	}

	public void setAnquan(int anquan) {
		Anquan = anquan;
	}

	public int getCailiao() {
		return Cailiao;
	}

	public void setCailiao(int cailiao) {
		Cailiao = cailiao;
	}

	public int getCeliang() {
		return Celiang;
	}

	public void setCeliang(int celiang) {
		Celiang = celiang;
	}

	public int getZaojia() {
		return Zaojia;
	}

	public void setZaojia(int zaojia) {
		Zaojia = zaojia;
	}

	public int getHetong() {
		return Hetong;
	}

	public void setHetong(int hetong) {
		Hetong = hetong;
	}

	public int getJishu() {
		return Jishu;
	}

	public void setJishu(int jishu) {
		Jishu = jishu;
	}

	public int getJianzheng() {
		return Jianzheng;
	}

	public void setJianzheng(int jianzheng) {
		Jianzheng = jianzheng;
	}

	public int getQuyang() {
		return Quyang;
	}

	public void setQuyang(int quyang) {
		Quyang = quyang;
	}

	public int getFuze() {
		return Fuze;
	}

	public void setFuze(int fuze) {
		Fuze = fuze;
	}

	public int getZhiliang() {
		return Zhiliang;
	}

	public void setZhiliang(int zhiliang) {
		Zhiliang = zhiliang;
	}

	public int getZiliao() {
		return Ziliao;
	}

	public void setZiliao(int ziliao) {
		Ziliao = ziliao;
	}

	public String getFDuty() {
		return FDuty;
	}

	public void setFDuty(String fDuty) {
		FDuty = fDuty;
	}

	public int getBiaozhun() {
		return Biaozhun;
	}

	public void setBiaozhun(int biaozhun) {
		Biaozhun = biaozhun;
	}

	public int getJiance() {
		return Jiance;
	}

	public void setJiance(int jiance) {
		Jiance = jiance;
	}

	public int getJixie() {
		return Jixie;
	}

	public void setJixie(int jixie) {
		Jixie = jixie;
	}

	public int getLaowu() {
		return Laowu;
	}

	public void setLaowu(int laowu) {
		Laowu = laowu;
	}

	public int getShigong() {
		return Shigong;
	}

	public void setShigong(int shigong) {
		Shigong = shigong;
	}

}
