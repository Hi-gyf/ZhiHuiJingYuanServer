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
        Vector<Vector<Object>> dataTable = super.select(sql,null);
        Vector<Object> dataLine;
        for(int i = 0; i < dataTable.size(); i++){
            dataLine = dataTable.get(i);
            marketItem = new AllMarketShowList();
            marketItem.setMkid(dataLine.get(0).toString());
            marketItem.setMkTitle(dataLine.get(1).toString());
            marketItem.setMkPrice(dataLine.get(2).toString());
            marketItem.setMkImg(dataLine.get(3).toString());
            marketShowList.add(marketItem);
        }
        return marketShowList;
    }

    public Market selectMarketById(String mkid){
        Market market = null;
        String sql = "select * from market where mkid = ?";
        Vector<Object> rs = super.select(sql,new Object[]{mkid}).get(0);
        if(rs != null){
           market = new Market();
           market.setMkid(rs.get(0).toString());
           market.setMkpid(rs.get(1).toString());
           market.setMkgid(rs.get(2).toString());
           market.setMktime(rs.get(3).toString());
           market.setMkprice(Double.valueOf(rs.get(4).toString()));
           market.setMkname(rs.get(5).toString());
           market.setMktitle(rs.get(6).toString());
           market.setMkimg(rs.get(7).toString());
        }
        return market;
    }
}
