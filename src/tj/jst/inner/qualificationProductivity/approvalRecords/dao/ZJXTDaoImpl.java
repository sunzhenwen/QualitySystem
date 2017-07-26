package com.tj.jst.inner.qualificationProductivity.approvalRecords.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.inner.qualificationProductivity.approvalRecords.model.ZJT_ZJXT_INS;

public class ZJXTDaoImpl extends BaseDao implements ZJXTDao
{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public String queryCreateDate(String newqualid) 
	{
		// TODO Auto-generated method stub
		String sql = "select to_char(CREATEDATE_FLOORAPPROVAL,'yyyy-MM-dd HH24:mi:ss') CREATEDATE_FLOORAPPROVAL "
				+ "from TBQUALIFICATIONAPPLY "
				+ "where newqualid=?  ";
		String  ceateDate="";
		try 
		{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newqualid);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				ceateDate=rs.getString("CREATEDATE_FLOORAPPROVAL");				
			}
		} catch (SQLException e) 
		{		
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return ceateDate;
	}
	
	
	public String insertZjxt_Ins(ZJT_ZJXT_INS zjt_zjxt_ins) {
		insertZjxt_Ins_Oracle(zjt_zjxt_ins);
		
		ZJT_ZJXT_INS zjt=select_ZJXT_INS_ById(zjt_zjxt_ins.getINSID());
		if(zjt.getAPPPERSONNAME().equals("哈尔滨天健高新技术有限公司")||zjt.getAPPPERSONNAME().equals("测试企业二"))
		{
			
		}
		else
		{
			insertZjxt_Ins_SqlServer(zjt);
		}
		
		return "";
	}
	
	
	public String insertZjxt_Ins_Oracle(ZJT_ZJXT_INS zjt_zjxt_ins) {
		// TODO 自动生成的方法存根
		String message = "";
		String sql = "insert into hz_datatab_zjt_zjxt_ins "
				+ "(INSID, AEAANAME,AEAATYPE,SONLEVELDEP,"
				+ "APPPERSONNAME,"
				+ "RECEVIEDTIME,STARTTIME,COMPLETETIME,INSSTATE,REJECTREASON,CREATETIME,"
				+ "SECRECY,EMPHASES,PROCESSNAME) "
				+ "values(?,'权限内建筑业企业（含城市园林绿化企业二级）资质认定','行政许可审批','黑龙江省住房和城乡建设厅',"
				+ "?,"
				+ "to_date(?,'yyyy-MM-dd HH24:mi:ss'),to_date(?,'yyyy-MM-dd HH24:mi:ss'),to_date(?,'yyyy-MM-dd HH24:mi:ss'),?,?,to_date(?,'yyyy-MM-dd HH24:mi:ss'),"
				+ "'FALSE','FALSE',?)";
		try 
		{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,zjt_zjxt_ins.getINSID());
			pstmt.setString(2,zjt_zjxt_ins.getAPPPERSONNAME());
			pstmt.setString(3,zjt_zjxt_ins.getRECEVIEDTIME());
			pstmt.setString(4,zjt_zjxt_ins.getSTARTTIME());
			pstmt.setString(5,zjt_zjxt_ins.getCOMPLETETIME());
			pstmt.setString(6,zjt_zjxt_ins.getINSSTATE());
			pstmt.setString(7,zjt_zjxt_ins.getREJECTREASON());
			pstmt.setString(8,zjt_zjxt_ins.getCREATETIME());
			pstmt.setString(9,zjt_zjxt_ins.getPROCESSNAME());
			int check = pstmt.executeUpdate();
			if (check >0) 
			{
				message = "添加成功 ！";
			} else
			{
				message = "添加失败!";
			}
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	
	public String insertZjxt_Ins_SqlServer(ZJT_ZJXT_INS zjt_zjxt_ins) {
		
		String message = "";
		String sql = " insert into hz_datatab_zjt_zjxt_ins "
				+ "(RUNNUMBER, INSID, AEAANAME, AEAATYPE, PROCESSKEY, "
				+ "PROCESSNAME, BUSINESSDEP, SONLEVELDEP, APPPERSONID, APPPERSONNAME, "
				+ "RECEVIEDTIME, STARTTIME, COMPLETETIME, INSSTATE, REJECTREASON, "
				+ "CREATETIME, FETCHEDTIME, SECRECY, EMPHASES, ACCEPTPERIOD, "
				+ "LIMITDAY, PAYWAY, AEAAID, PROCESSTAG, APPLICATIONTB, "
				+ "APPLYTYPE, DBFLAG, CBFLAG, YELLOWLIGHT, REDLIGHT,"
				+ " SUMTIME, NOTETIME, EDITIONNUM, BATCH) "
				+ " values "
				+ "(?,?,?,?,?,"
				+ " ?,?,?,?,?,"
				+ " convert(datetime,?),convert(datetime,?),convert(datetime,?),?,?,"
				+ " convert(datetime,?),convert(datetime,?),?,?,?,"
				+ " ?,?,?,?,?,"
				+ " ?,?,?,?,?,"
				+ " ?,convert(datetime,?),?,? )  ";
		try 
		{
			conn = ConnectionFactory.getHzDataShareConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,zjt_zjxt_ins.getRUNNUMBER());
			pstmt.setString(2,zjt_zjxt_ins.getINSID());
			pstmt.setString(3,zjt_zjxt_ins.getAEAANAME());
			pstmt.setString(4,zjt_zjxt_ins.getAEAATYPE());
			pstmt.setString(5,zjt_zjxt_ins.getPROCESSKEY());
			
			pstmt.setString(6,zjt_zjxt_ins.getPROCESSNAME());
			pstmt.setString(7,zjt_zjxt_ins.getBUSINESSDEP());
			pstmt.setString(8,zjt_zjxt_ins.getSONLEVELDEP());
			pstmt.setString(9,zjt_zjxt_ins.getAPPPERSONID());
			pstmt.setString(10,zjt_zjxt_ins.getAPPPERSONNAME());
			
			pstmt.setString(11,zjt_zjxt_ins.getRECEVIEDTIME());
			pstmt.setString(12,zjt_zjxt_ins.getSTARTTIME());
			pstmt.setString(13,zjt_zjxt_ins.getCOMPLETETIME());
			pstmt.setString(14,zjt_zjxt_ins.getINSSTATE());
			pstmt.setString(15,zjt_zjxt_ins.getREJECTREASON());
			
			pstmt.setString(16,zjt_zjxt_ins.getCREATETIME());
			pstmt.setString(17,zjt_zjxt_ins.getFETCHEDTIME());
			pstmt.setString(18,zjt_zjxt_ins.getSECRECY());
			pstmt.setString(19,zjt_zjxt_ins.getEMPHASES());
			pstmt.setInt(20,zjt_zjxt_ins.getACCEPTPERIOD());
			
			pstmt.setInt(21,zjt_zjxt_ins.getLIMITDAY());
			pstmt.setString(22,zjt_zjxt_ins.getPAYWAY());
			pstmt.setString(23,zjt_zjxt_ins.getAEAAID());
			pstmt.setString(24,zjt_zjxt_ins.getPROCESSTAG());
			pstmt.setString(25,zjt_zjxt_ins.getAPPLICATIONTB());
			
			pstmt.setInt(26,zjt_zjxt_ins.getAPPLYTYPE());
			pstmt.setInt(27,zjt_zjxt_ins.getDBFLAG());
			pstmt.setInt(28,zjt_zjxt_ins.getCBFLAG());
			pstmt.setString(29,zjt_zjxt_ins.getYELLOWLIGHT());
			pstmt.setString(30,zjt_zjxt_ins.getREDLIGHT());
			
			pstmt.setInt(31,zjt_zjxt_ins.getSUMTIME());
			pstmt.setString(32,zjt_zjxt_ins.getNOTETIME());
			pstmt.setInt(33,zjt_zjxt_ins.getEDITIONNUM());
			pstmt.setString(34,zjt_zjxt_ins.getBATCH());
			//pstmt.setString(35,zjt_zjxt_ins.getMSG_STATUS());
			int check = pstmt.executeUpdate();
			if (check >0) 
			{
				message = "添加成功 ！";
			} else
			{
				message = "添加失败!";
			}
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try 
			{
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	public ZJT_ZJXT_INS select_ZJXT_INS_ById(String newqualid) 
	{
		
		// TODO Auto-generated method stub
		String sql = " select "
				+ "RUNNUMBER, INSID, AEAANAME, AEAATYPE, PROCESSKEY, "
				+ " PROCESSNAME, BUSINESSDEP, SONLEVELDEP, APPPERSONID, APPPERSONNAME,"
				+ " to_char(RECEVIEDTIME,'yyyy-MM-dd HH24:mi:ss') RECEVIEDTIME, to_char(STARTTIME,'yyyy-MM-dd HH24:mi:ss') STARTTIME, to_char(COMPLETETIME,'yyyy-MM-dd HH24:mi:ss') COMPLETETIME, INSSTATE, REJECTREASON,"
				+ " to_char(CREATETIME,'yyyy-MM-dd HH24:mi:ss') CREATETIME,to_char(FETCHEDTIME,'yyyy-MM-dd HH24:mi:ss') FETCHEDTIME, SECRECY, EMPHASES, ACCEPTPERIOD, "
				+ "LIMITDAY, PAYWAY, AEAAID, PROCESSTAG, APPLICATIONTB, "
				+ "APPLYTYPE, DBFLAG, CBFLAG, YELLOWLIGHT, REDLIGHT, "
				+ "SUMTIME,to_char(NOTETIME,'yyyy-MM-dd HH24:mi:ss') NOTETIME,EDITIONNUM,BATCH "
				+ "from hz_datatab_zjt_zjxt_ins "
				+ "where insid=? ";
		ZJT_ZJXT_INS zjt_zjxt_ins=new ZJT_ZJXT_INS();
		try 
		{
			
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newqualid);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				zjt_zjxt_ins.setRUNNUMBER(rs.getString("RUNNUMBER"));
				zjt_zjxt_ins.setINSID(rs.getString("INSID"));
				zjt_zjxt_ins.setAEAANAME(rs.getString("AEAANAME"));
				zjt_zjxt_ins.setAEAATYPE(rs.getString("AEAATYPE"));
				zjt_zjxt_ins.setPROCESSKEY(rs.getString("PROCESSKEY"));
				zjt_zjxt_ins.setPROCESSNAME(rs.getString("PROCESSNAME"));
				zjt_zjxt_ins.setBUSINESSDEP(rs.getString("BUSINESSDEP"));
				zjt_zjxt_ins.setSONLEVELDEP(rs.getString("SONLEVELDEP"));
				zjt_zjxt_ins.setAPPPERSONID(rs.getString("APPPERSONID"));
				zjt_zjxt_ins.setAPPPERSONNAME(rs.getString("APPPERSONNAME"));
				zjt_zjxt_ins.setRECEVIEDTIME(rs.getString("RECEVIEDTIME"));
				zjt_zjxt_ins.setSTARTTIME(rs.getString("STARTTIME"));
				zjt_zjxt_ins.setCOMPLETETIME(rs.getString("COMPLETETIME"));
				zjt_zjxt_ins.setINSSTATE(rs.getString("INSSTATE"));
				zjt_zjxt_ins.setREJECTREASON(rs.getString("REJECTREASON"));
				zjt_zjxt_ins.setCREATETIME(rs.getString("CREATETIME"));
				zjt_zjxt_ins.setFETCHEDTIME(rs.getString("FETCHEDTIME"));
				zjt_zjxt_ins.setSECRECY(rs.getString("SECRECY"));
				zjt_zjxt_ins.setEMPHASES(rs.getString("EMPHASES"));
				zjt_zjxt_ins.setACCEPTPERIOD(rs.getInt("ACCEPTPERIOD"));
				zjt_zjxt_ins.setLIMITDAY(rs.getInt("LIMITDAY"));
				zjt_zjxt_ins.setPAYWAY(rs.getString("PAYWAY"));
				zjt_zjxt_ins.setAEAAID(rs.getString("AEAAID"));
				zjt_zjxt_ins.setPROCESSTAG(rs.getString("PROCESSTAG"));
				zjt_zjxt_ins.setAPPLICATIONTB(rs.getString("APPLICATIONTB"));
				zjt_zjxt_ins.setAPPLYTYPE(rs.getInt("APPLYTYPE"));
				zjt_zjxt_ins.setDBFLAG(rs.getInt("DBFLAG"));
				zjt_zjxt_ins.setCBFLAG(rs.getInt("CBFLAG"));
				zjt_zjxt_ins.setYELLOWLIGHT(rs.getString("YELLOWLIGHT"));
				zjt_zjxt_ins.setREDLIGHT(rs.getString("REDLIGHT"));
				zjt_zjxt_ins.setSUMTIME(rs.getInt("SUMTIME"));
				zjt_zjxt_ins.setNOTETIME(rs.getString("NOTETIME"));
				zjt_zjxt_ins.setEDITIONNUM(rs.getInt("EDITIONNUM"));
				zjt_zjxt_ins.setBATCH(rs.getString("BATCH"));
				//zjt_zjxt_ins.setMSG_STATUS(rs.getString("MSG_STATUS"));
			}
		} catch (SQLException e) 
		{		
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return zjt_zjxt_ins;
	}


	@Override
	public String updateInsState(String insId,String InsState) {
		// TODO 自动生成的方法存根
		updateInsState_Oralce(insId,InsState);
		updateInsState_SQLserver(insId,InsState);
		return "";
	}


	@Override
	public String updateCompleteTime(String insId,String CompleteTime) {
		// TODO 自动生成的方法存根
		updateCompleteTime_Oracle(insId, CompleteTime);
		updateCompleteTime_SQLserver(insId,CompleteTime);
		return "";
	}
	
	

	public int updateInsState_Oralce(String insId,String InsState) {
		int checkNum=0;
		String sql="";
		sql =     " update hz_datatab_zjt_zjxt_ins "
				+ " set INSSTATE=? "
				+ " where INSID=? " ;
		try 
		{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,InsState);
			pstmt.setString(2,insId);
			checkNum=pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return checkNum;
	}


	
	public int updateCompleteTime_Oracle(String insId,String CompleteTime) 
	{
		int checkNum=0;
		String sql="";
		sql=" update hz_datatab_zjt_zjxt_ins "
				+ " set STARTTIME=to_date(?,'yyyy-MM-dd HH24:mi:ss'),"
				+ " COMPLETETIME=to_date(?,'yyyy-MM-dd HH24:mi:ss') "
				+ " where INSID=? " ;
		try 
		{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,CompleteTime);
			pstmt.setString(2,CompleteTime);
			pstmt.setString(3,insId);
			checkNum=pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		return checkNum;
	}
	
	public int updateInsState_SQLserver(String insId,String InsState) 
	{
		int checkNum=0;
		String sql="";
		sql =     " update hz_datatab_zjt_zjxt_ins "
				+ " set INSSTATE=? "
				+ " where INSID=? " ;
		try 
		{
			conn = ConnectionFactory.getHzDataShareConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,InsState);
			pstmt.setString(2,insId);
			checkNum=pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return checkNum;
	}


	
	public int updateCompleteTime_SQLserver(String insId,String CompleteTime) {
		int checkNum=0;
		String sql="";
		sql=" update hz_datatab_zjt_zjxt_ins "
				+ " set STARTTIME=convert(datetime,?), "
				+ " COMPLETETIME=convert(datetime,?) "
				+ " where INSID=? ";
		try 
		{
			conn = ConnectionFactory.getHzDataShareConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,CompleteTime);
			pstmt.setString(2,CompleteTime);
			pstmt.setString(3,insId);
			checkNum=pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return checkNum;
	}


	@Override
	public String updateRejectReason(String insid, String rejectReason) 
	{
		updateRejectReason_SQLServer(insid, rejectReason);
		updateRejectReason_Oracle(insid, rejectReason);
		return "";
	}
	
	
	public int updateRejectReason_Oracle(String insid, String rejectReason)
	{
		int checkNum=0;
		String sql="";
		sql =     " update hz_datatab_zjt_zjxt_ins "
				+ " set REJECTREASON=? "
				+ " where INSID=? " ;
		try 
		{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,rejectReason);
			pstmt.setString(2,insid);
			checkNum=pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return checkNum;
	}
	

	public int updateRejectReason_SQLServer(String insid, String rejectReason) 
	{
		int checkNum=0;
		String sql="";
		sql =     " update hz_datatab_zjt_zjxt_ins "
				+ " set REJECTREASON=? "
				+ " where INSID=? " ;
		try 
		{
			conn = ConnectionFactory.getHzDataShareConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,rejectReason);
			pstmt.setString(2,insid);
			checkNum=pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return checkNum;
	}
	

	
}
