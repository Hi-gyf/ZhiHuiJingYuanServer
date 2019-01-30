package servlet;

import dao.FwalletDao;
import dao.LoseDao;
import pojo.Fwallet;
import pojo.Lose;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class wxLostItemServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        //判断为哪种物品的发布
        String category = request.getParameter("cate");
        Lose lose = new Lose();
        Map<String,String[]> map =  request.getParameterMap();
        Map<String,String> newmap = new HashMap<String,String>();
        Iterator<Map.Entry<String, String[]>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, String[]> entry = it.next();
            newmap.put(entry.getKey(),entry.getValue()[0]);
        }
        if("钱包".equals(category)){
            Fwallet fwallet = new Fwallet();
            String fwid = null;
            fwallet.setParameters(newmap);
            fwallet.setFwid("1"); //这里是需要手动设置
            System.out.println(fwallet);
            lose.setParameters(newmap);
            lose.setLgpid(UUID.randomUUID().toString().replace("-","")); //设置用户id
            FwalletDao.instance().insertBasicFwallet(fwallet);
            Map<String,String> map1 = FwalletDao.instance().getFwalletIdByFwallet(fwallet);
            if(map1.isEmpty() == false){
                fwid = map1.get("fwid");//获得id号
            }
            else{
                System.out.println("id为空，插入失败");
                return ;
            }
            lose.setLggid(fwid);//设置物品id
            lose.setLgname("fwallet"); //设置表名
            lose.setLgstatus("1");//默认为1
            lose.setLgid("1");
            LoseDao.instance().addLostItemMessage(lose);
        }


    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
