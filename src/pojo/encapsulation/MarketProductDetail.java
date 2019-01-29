package pojo.encapsulation;

public class MarketProductDetail {
    //属于本次交易的信息
    private String mkid;
    private String mkpid;
    private String mkgid;
    private String mktime;
    private Double mkprice;
    private String mkname;
    private String mktitle;
    private String mkimg;

    //属于商品的信息，商品分类，没有统一属性名，需要逐个set
    private String mkgname;
    private String mkgtype;
    private String mkgdescribe;
    private String mkgimg;

    //属于卖家的信息
    private String sno;
    private String sex;
    private String photo_url;
    private String tel;

    public MarketProductDetail() {
    }

    public String getMkid() {
        return mkid;
    }

    public void setMkid(String mkid) {
        this.mkid = mkid;
    }

    public String getMkpid() {
        return mkpid;
    }

    public void setMkpid(String mkpid) {
        this.mkpid = mkpid;
    }

    public String getMkgid() {
        return mkgid;
    }

    public void setMkgid(String mkgid) {
        this.mkgid = mkgid;
    }

    public String getMktime() {
        return mktime;
    }

    public void setMktime(String mktime) {
        this.mktime = mktime;
    }

    public Double getMkprice() {
        return mkprice;
    }

    public void setMkprice(Double mkprice) {
        this.mkprice = mkprice;
    }

    public String getMkname() {
        return mkname;
    }

    public void setMkname(String mkname) {
        this.mkname = mkname;
    }

    public String getMktitle() {
        return mktitle;
    }

    public void setMktitle(String mktitle) {
        this.mktitle = mktitle;
    }

    public String getMkimg() {
        return mkimg;
    }

    public void setMkimg(String mkimg) {
        this.mkimg = mkimg;
    }

    public String getMkgname() {
        return mkgname;
    }

    public void setMkgname(String mkgname) {
        this.mkgname = mkgname;
    }

    public String getMkgtype() {
        return mkgtype;
    }

    public void setMkgtype(String mkgtype) {
        this.mkgtype = mkgtype;
    }

    public String getMkgdescribe() {
        return mkgdescribe;
    }

    public void setMkgdescribe(String mkgdescribe) {
        this.mkgdescribe = mkgdescribe;
    }

    public String getMkgimg() {
        return mkgimg;
    }

    public void setMkgimg(String mkgimg) {
        this.mkgimg = mkgimg;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "MarketProductDetail{" +
                "mkid='" + mkid + '\'' +
                ", mkpid='" + mkpid + '\'' +
                ", mkgid='" + mkgid + '\'' +
                ", mktime='" + mktime + '\'' +
                ", mkprice=" + mkprice +
                ", mkname='" + mkname + '\'' +
                ", mktitle='" + mktitle + '\'' +
                ", mkimg='" + mkimg + '\'' +
                ", mkgname='" + mkgname + '\'' +
                ", mkgtype='" + mkgtype + '\'' +
                ", mkgdescribe='" + mkgdescribe + '\'' +
                ", mkgimg='" + mkgimg + '\'' +
                ", sno='" + sno + '\'' +
                ", sex='" + sex + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
