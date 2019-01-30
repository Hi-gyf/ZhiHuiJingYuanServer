package servlet;

import dao.MarketDao;
import dao.UserDao;
import org.apache.commons.beanutils.BeanMap;
import pojo.Market;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class showProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String mkId = request.getParameter("mkid");
        MarketDao marketDao = new MarketDao();
        Market market = marketDao.selectMarketById(mkId);
        Map<String,String> marketMap = new BeanMap(market);

        String userId = marketMap.get("mkgid");
        Map<String,String> userMap = new BeanMap();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
