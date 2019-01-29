package dao;

import Utils.JDBCUtil;
import org.apache.commons.beanutils.ConvertUtils;
import pojo.Market;
import pojo.encapsulation.AllMarketShowList;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class MarketDao extends AbstractDao{
    public int insertMarket(Market market){
        String sql = "insert into market(mkid,mkpid,mkgid,mktime,mkprice,mkname,mktitle,mkimg) " +
                "values(?,?,?,?,?,?,?,?)";
        Object[] data = new Object[]{market.getMkid(),market.getMkpid(),market.getMkgid(),market.getMktime(),market.getMkprice(),market.getMkname(),market.getMktitle(),market.getMkimg()};
        return super.update(sql,data);
    }

    public List<AllMarketShowList> selectAllMarkets(){
        List<AllMarketShowList> marketShowList = new ArrayList<AllMarketShowList>();
        AllMarketShowList marketItem = null;
        String sql = "select mkid,mktitle,mkprice,mkimg from market order by mktime desc";
        Vector<Map<String,String>> dataTable = super.select(sql,null);
        Map<String,String> dataLine;
        for(int i = 0; i < dataTable.size(); i++){
            dataLine = dataTable.get(i);
            marketItem = new AllMarketShowList();
            marketItem.setMkid(dataLine.get(0));
            marketItem.setMkTitle(dataLine.get(1));
            marketItem.setMkPrice(dataLine.get(2));
            marketItem.setMkImg(dataLine.get(3));
            marketShowList.add(marketItem);
        }
        return marketShowList;
    }

    public Market selectMarketById(String mkid){
        Market market = null;
        String sql = "select * from market where mkid = ?";
        Map<String,String> rs = super.select(sql,new Object[]{mkid}).get(0);
        if(rs != null){
           market = new Market();
           market.setParameters(rs);
        }
        return market;
    }
}
