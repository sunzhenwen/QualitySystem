package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;
import com.tj.jst.outside.staffmanage.positions.condition.PositionsCondition;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * 查询岗位人员
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPositionsAction extends BaseAction {

	private List<Positions> list;
	private int Anquan; // 安全员
	private int Biaozhun;// 标准员
	private int Cailiao; // 材料员
	private int Celiang; // 工程测量员
	private int Zaojia; // 工程造价员
	private int Jiance;// 工程检测员
	private int Hetong; // 合同员
	private int Jixie;// 机械员
	private int Jishu; // 技术人员员
	private int Jianzheng; // 见证员
	private int Laowu;// 劳务员
	private int Quyang; // 取样员
	private int Fuze; // 技术负责人员
	private int Zhiliang; // 质量检查员
	private int Ziliao; // 资料员
	private int Shigong;// 施工员
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
	 * 查询岗位人员
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
	 * 岗位人员详细查看
	 * 
	 * @return
	 */
	public String getSomePositions() {
		IProvinceApprovalService provinceApprovalService = new ProvinceApprovalServiceImpl();
		condition = this.getCondition();
		if (FDuty != null) {
			switch (FDuty) {
			case "1":
				condition.setDuty("安全员");
				break;
			case "2":
				condition.setDuty("标准员");
				break;
			case "3":
				condition.setDuty("材料员");
				break;
			case "4":
				condition.setDuty("工程测量员");
				break;
			case "5":
				condition.setDuty("工程检测员");
				break;
			case "6":
				condition.setDuty("工程造价员");
				break;
			case "7":
				condition.setDuty("合同员");
				break;
			case "8":
				condition.setDuty("机械员");
				break;
			case "9":
				condition.setDuty("技术人员");
				break;
			case "10":
				condition.setDuty("见证员");
				break;
			case "11":
				condition.setDuty("劳务员");
				break;
			case "12":
				condition.setDuty("取样员");
				break;
			case "13":
				condition.setDuty("施工现场技术负责人");
				break;
			case "14":
				condition.setDuty("施工员");
				break;
			case "15":
				condition.setDuty("质量员");
				break;
			case "16":
				condition.setDuty("资料员");
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
