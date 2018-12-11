package com.jung.sql;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import org.apache.ibatis.session.SqlSession;

import com.jung.entity.Academic;
import com.jung.entity.Activation;
import com.jung.entity.Application;
import com.jung.entity.Attractions;
import com.jung.entity.Communication;
import com.jung.entity.DependAcademic;
import com.jung.entity.Food;
import com.jung.entity.LostAndFound;
import com.jung.entity.Merchant;
import com.jung.entity.Note;
import com.jung.entity.Reply;
import com.jung.entity.Send;
import com.jung.entity.Table;
import com.jung.entity.Titleacademic;
import com.jung.entity.User;

/**
 * 	to 具体数据库操作
 * @author jung
 *
 */
public class UserDAO {
    private SqlSession sqlSession;
    private SqlSession getSqlSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }
    /**
     * Login 、 判断用户是否存在 以及登录作用
     *没有找到返回空，找到了返回该数据
     *比较适合单条件验证 、多条件查询
     * @param user
     * @return
     */
    public User userLogin(User user){
        User returnUser = null;
        try{
            returnUser = getSqlSession().selectOne("userLogin",user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
        	sqlSession.close();
        }
        return returnUser;

    }
    
    public User verificationInfo(User user) {
    	User returnUser = null;
    	try {
    		returnUser = getSqlSession().selectOne("VerificationInformation",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}return returnUser;
    }
    
    
    /**
     * Register 0代表失败，1代表成功
     * @param user
     * @return
     */
    public Integer userRegister(User user) {
    	Integer isTrue = 0;
    	try {
    		isTrue = getSqlSession().insert("userRegister", user);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    /**
     * userRevice 更新用户信息. 当更新成功时返回1，失败时返回0 .
     * @param user
     * @return
     */
    public Integer userRevice(User user) {
    	System.out.println(user);
    	Integer isTrue = 0;
    	try{
    		isTrue = getSqlSession().update("userRevise",user);
            sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    public List getDetailNote(Note range) {
    	List<Note> list = new ArrayList<Note>();
    	try {
    		list = getSqlSession().selectList("getContext", range);
    	}catch(Exception e) {
    		System.out.println(e.getMessage()+"id=getDetailNote");
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    	
    }
    
    
    // --------------------------------------------------
    /**LJL
     * activate 、 判断激活码是否存在
     *没有找到返回空，找到了返回该数据
     *比较适合单条件验证 、多条件查询
     * @param activate
     * @return
     */
    public Activation userActivate(Activation user) {
    	Activation returnUser = null;
    	try {
    		returnUser = getSqlSession().selectOne("userActivation",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}return returnUser;
    }
    
    public Activation userTeacher(Activation user) {
    	Activation returnUser = null;
    	try {
    		returnUser = getSqlSession().selectOne("userTeacher",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}return returnUser;
    }
    
    public Activation userStudent(Activation user) {
    	Activation returnUser = null;
    	try {
    		returnUser = getSqlSession().selectOne("userStudent",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}return returnUser;
    }
    
    public Integer userStudentstatus(Activation user) {
    	Integer isTrue = 0;
    	try{
    		isTrue = getSqlSession().update("userStudentstatus",user);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage()+"12");
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    public Integer userTeacherstatus(Activation user) {
    	Integer isTrue = 0;
    	try{
    		isTrue = getSqlSession().update("userTeacherstatus",user);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    public Integer userStatus(Activation user) {
    	Integer isTrue = 0;
    	try{
    		isTrue = getSqlSession().update("userStatus",user);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    
    //-------------------------com.jung.surrounding-------------------------
    public List getAttraction() {
    	List<Attractions> list = new ArrayList<Attractions>();
    	try {
    		list = getSqlSession().selectList("getAttraction");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    public List getFood(Merchant mer) {
    	List<Food> list = new ArrayList<Food>();
    	try {
    		list = getSqlSession().selectList("getFood",mer);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    public List getMerchant() {
    	List<Merchant> list = new ArrayList<Merchant>();
    	try {
    		list = getSqlSession().selectList("getMerchant");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    //-------------------------com.jung.nearMerchant-------------------------
    public List getNearMerchant() {
    	List<Merchant> list = new ArrayList<Merchant>();
    	try {
    		list = getSqlSession().selectList("getNearMerchant");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    
    //------------------------com.jung.entity.Communication-----------------------
    public List getLostAndFound() {
    	List<LostAndFound> list = new ArrayList<LostAndFound>();
    	try {
    		list = getSqlSession().selectList("getLostAndFound");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    
    public List getCommunication() {
    	List<Communication> list = new ArrayList<Communication>();
    	try {
    		list = getSqlSession().selectList("getCommunication");
    	}catch(Exception e) {
    		System.out.println("这里报错");
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    
    public List getReply(Communication com) {
    	List<Reply> list = new ArrayList<Reply>();
    	try {
    		list = getSqlSession().selectList("getReply",com);
    	}catch(Exception e) {
    	    System.out.println("在getReply这里报错");
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    //------------------------com.jung.entity.academic-----------------------
    
    public int getAcademicId(Academic academic) {
    	int result  = -1;
    	try {
    		result = getSqlSession().selectOne("getAcademicId", academic);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return result;
    }
    
    
    public int insertAcademic(Academic academic) {
    	int isTrue = 0;
    	try {
        	isTrue = getSqlSession().insert("insertAcademic",academic);
        	sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    public int insertDependAcademic(List<DependAcademic> list) {
    	int isTrue = 0;
    	try {
        	isTrue = getSqlSession().insert("insertDependAcademic",list);
        	sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    public int insertApplication(List<Application> list ) {
    	int isTrue = 0;
    	try {
        	isTrue = getSqlSession().insert("insertApplication",list);
        	sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    public List selectApplication(Application application) {
    	List<Application> list = new ArrayList<>();
    	try {
    		list = getSqlSession().selectList("selectApplication",application);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list ;
    }
    //============================================================================
    public int insetCommunicaiton(Communication com) {
    	int isTrue = 0;
    	try {
    		isTrue  = getSqlSession().insert("insetCommunicaiton",com);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    public int insertReply(Reply re) {
    	int isTrue = 0;
    	try {
    		isTrue  = getSqlSession().insert("insertReply",re);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    public int insertLostAndFound(LostAndFound laf) {
    	int isTrue = 0;
    	try {
    		isTrue  = getSqlSession().insert("insertLostAndFound",laf);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    //=============================
    public List<Communication> queryCom(Communication com){
    	List<Communication> list = new ArrayList<Communication>();
    	try {
    		list = getSqlSession().selectList("queryCom", com);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    public List<LostAndFound> queryLaf(LostAndFound laf){
    	List<LostAndFound> list = new ArrayList<LostAndFound>();
    	try {
    		list = getSqlSession().selectList("queryLostAndFound",laf);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    //================ljl
 //------------------提交表单
    
    public Integer userSend(Table user) {
    	Integer isTrue = 0;
    	try{
    		isTrue = getSqlSession().update("userSend",user);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    public Integer StudentSend(Table user) {
    	Integer isTrue = 0;
    	try{
    		isTrue = getSqlSession().update("StudentSend",user);
    		sqlSession.commit();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return isTrue;
    }
    
    //---------------------获取商家招聘信息    
    public List getUser() {
    	List<Table> list = new ArrayList<Table>();
    	try {
    		list = getSqlSession().selectList("getUser");
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    
    public List getStudent(Table user) {
    	List<Table> list = new ArrayList<Table>();
    	try {
    		list = getSqlSession().selectList("getStudent",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
    
    public List<Send> queryUS(Send user){
    	List<Send> list = new ArrayList<Send>();
    	try {
    		list = getSqlSession().selectList("queryUserSend",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
		return list;
    }

    public List<Table> querySS(Table user){
    	List<Table> list = new ArrayList<Table>();
    	try {
    		list = getSqlSession().selectList("queryStudentSend",user);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
		return list;
    }
    public List getTitleAcademic(int types) {
    	List<Titleacademic> list = new ArrayList<>();
    	try {
    		list = getSqlSession().selectList("getTitleAcademic",types);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		sqlSession.close();
    	}
    	return list;
    }
}
