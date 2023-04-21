package com.animee.rf_week02.bean;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentDatas {
    public static List<String> dailyKindList = Arrays.asList("调料干货", "零食", "饮料", "烟酒", "厨房用品", "日用品", "清洁用品", "洗化用品");
    // 商品集合
    public static List<InfoBean> shopList
            = Arrays.asList(new InfoBean("http://t15.baidu.com/it/u=1118848058,701532755&fm=224&app=112&f=JPEG?w=500&h=500", "低钠盐", "调料干货", 100, 14.00),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg5.21food.cn%2Fimg%2Falbum%2F2017%2F9%2F19%2Ffood13536331244047X7.jpg&refer=http%3A%2F%2Fimg5.21food.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639486346&t=b7aca0e8238f6db68babcda8508f4be7", "优质白砂糖", "调料干货", 350, 16.50),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimage3.suning.cn%2Fuimg%2Fb2c%2Fnewcatentries%2F0070118418-000000000147925824_5_800x800.jpg&refer=http%3A%2F%2Fimage3.suning.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg", "老姜红糖", "调料干货", 350, 24.50),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn.sinaimg.cn%2Fsinakd202121s%2F419%2Fw700h519%2F20210201%2F709d-kiksqxh4937217.jpg&refer=http%3A%2F%2Fn.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670152659&t=8cce7563a9923ca345c64337eb53f84e", "太太乐鸡精", "调料干货", 350, 18.50),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqny.smzdm.com%2F202105%2F16%2F60a0b3bb8b63c5683.jpg_d250.jpg&refer=http%3A%2F%2Fqny.smzdm.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg", "金龙鱼实用调和油", "调料干货", 350, 41.00),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimage.suning.cn%2Fcontent%2Fcatentries%2F00000000010690%2F000000000106903642%2Ffullimage%2F000000000106903642_1f.jpg&refer=http%3A%2F%2Fimage.suning.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg", "福临门实用调和油", "调料干货", 250, 46.50),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.51yuansu.com%2Fpic3%2Fcover%2F00%2F79%2F64%2F58c73bcac0cd4_610.jpg&refer=http%3A%2F%2Fbpic.51yuansu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670152759&t=cbdaba0ecad2fe0e895066f8d9f3cb17", "旺旺维粒多", "零食", 200, 3.5),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fduolimi.cn%2FUpLoad%2F2014-8-12%2F20140812142292129212.jpg&refer=http%3A%2F%2Fduolimi.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670152790&t=8982b4fbbc1ac0935daa927334854cf8", "鱿鱼卷", "零食", 200, 14.3),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqny.smzdm.com%2F202109%2F08%2F61382ef72bdc72248.jpg&refer=http%3A%2F%2Fqny.smzdm.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670152819&t=d2416411f1f0de8130f5b10dd4b3e556", "乐事分享装", "零食", 200, 22.9),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi2%2F1588913126%2FO1CN01e2GB3u1YxkpEJPS8s_%21%210-item_pic.jpg_400x400.jpg&refer=http%3A%2F%2Fimg.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670152846&t=b8c50e183bdd5d7f8539d366dd635cd8", "旺旺大礼包", "零食", 200, 40.50),
            new InfoBean("https://img2.baidu.com/it/u=926088687,2201683876&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=332", "旺仔小馒头", "零食", 200, 8.5),
            new InfoBean("https://img1.baidu.com/it/u=710704254,2877306920&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500", "景田饮用纯净水", "饮料", 120, 5.00),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimgservice.suning.cn%2Fuimg1%2Fb2c%2Fimage%2FKxljet_TrpJGpkdwxe3jhw.jpg_800w_800h_4e&refer=http%3A%2F%2Fimgservice.suning.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153220&t=6f149b65d4af1845759c08687c146c30", "可口可乐", "饮料", 120, 3.00),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fp1.meituan.net%2Fwmproduct%2F6f611ad7b70a501af6a93cb3dc72da1f215283.jpg%2540249w_249h_1e_1c_1l%7Cwatermark%253D1%2526%2526r%253D1%2526p%253D9%2526x%253D2%2526y%253D2%2526relative%253D1%2526o%253D20&refer=http%3A%2F%2Fp1.meituan.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153253&t=0e2e40824f97eb5519fce2c1920af3a3", "雪碧", "饮料", 120, 3.00),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.yzcdn.cn%2Fupload_files%2F2015%2F04%2F18%2FFq1guyExiPbuPIUKFepobzEGs9o4.jpg%3FimageView2%2F2%2Fw%2F580%2Fh%2F580%2Fq%2F75%2Fformat%2Fjpg&refer=http%3A%2F%2Fimg.yzcdn.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639378582&t=7b34c9c92980e316d3877f2cdbd8781a", "中华(盒)", "烟酒", 500, 50),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.cnxiangyan.com%2Fuploads%2Fallimg%2F200720%2F2706-200H0111242509.jpg&refer=http%3A%2F%2Fwww.cnxiangyan.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639466559&t=70d7d55a334067ed99a8e374b890a1a6", "黄鹤楼(盒)", "烟酒", 200, 20),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.baike.soso.com%2Fugc%2Fbaikepic2%2F31517%2F20170202092126-1334117041.jpg%2F0&refer=http%3A%2F%2Fpic.baike.soso.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639466743&t=02cb2f0e804897fcb72a472942582990", "万宝路(盒)", "烟酒", 300, 22),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.yzcdn.cn%2Fupload_files%2F2017%2F06%2F30%2FFpwlPLqdyp7MWU0e0NaeZMQ_7E4T.jpg%3FimageView2%2F2%2Fw%2F580%2Fh%2F580%2Fq%2F75%2Fformat%2Fjpg&refer=http%3A%2F%2Fimg.yzcdn.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639466857&t=90649667928871a0514c991401665cf1", "玉溪(盒)", "烟酒", 180, 40),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.lingshimiyu.com%2Fuploadfile%2F2018100213565617523.jpg&refer=http%3A%2F%2Fwww.lingshimiyu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153035&t=3273677af8506c05dc8985a0d8168d6d", "旺旺仙贝", "零食", 3000, 6.8),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.yzcdn.cn%2Fupload_files%2F2018%2F07%2F13%2FFkB7uynmnBbpZg--ghsgDEDEbJ4V.jpg%3FimageView2%2F2%2Fw%2F580%2Fh%2F580%2Fq%2F75%2Fformat%2Fjpg&refer=http%3A%2F%2Fimg.yzcdn.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639382650&t=235174b3d2f9687201935b064ec4e179", "好丽友派", "零食", 200, 12.5),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbkimg.cdn.bcebos.com%2Fpic%2Fac4bd11373f082025aaf523eabb2ecedab64034fadd2&refer=http%3A%2F%2Fbkimg.cdn.bcebos.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153102&t=714a2a9cade82a58c7ae9ab38fe4886b", "奥利奥", "零食", 300, 10.5),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqny.smzdm.com%2F202011%2F10%2F5faa0467505085888.jpg_d250.jpg&refer=http%3A%2F%2Fqny.smzdm.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153135&t=abcdb78d911c690796967c32b8a76424", "趣多多", "零食", 300, 8.8),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.xplian.net%2FtuxpJDEwLmFsaWNkbi5jb20vaTIvMjMwMjMwMjE0Mi9UQjIwT2UxYjlDV0J1Tmp5MEZoWFhiNkVWWGFfISEyMzAyMzAyMTQyJDk.jpg&refer=http%3A%2F%2Fwww.xplian.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639457310&t=98957bf46afc7f2b9c75829bc3423587", "可比克薯片", "零食", 300, 8.5),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fgaitaobao3.alicdn.com%2Ftfscom%2Fi1%2FTB16iWoSpXXXXXMXFXXXXXXXXXX_%21%210-item_pic.jpg_300x300.jpg&refer=http%3A%2F%2Fgaitaobao3.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1639457890&t=cdfdd11e021783ae4f4435c25b97ae6e", "盼盼膨化饼干", "零食", 300, 13),
            new InfoBean("http://pic1.zhimg.com/v2-4985e07fa1218110910af1faf3dd1c69_hd.jpg", "蟹黄瓜子", "零食", 230, 9.5),
            new InfoBean("http://img04.taobaocdn.com/bao/uploaded/i4/T1rWANFrJcXXXXXXXX_!!0-item_pic.jpg", "士力架", "零食", 300, 12),
            new InfoBean("http://pic4.zhimg.com/v2-dabe30c4df18502b1bf4aa6fa2b1bc31_hd.jpg", "酸奶草莓", "零食", 210, 8.5),
            new InfoBean("https://gd3.alicdn.com/imgextra/i4/409015871/O1CN01RGzuCI1tExyD6nIGP_!!409015871.jpg", "康师傅方便面/箱", "零食", 400, 60),
            new InfoBean("https://gd2.alicdn.com/imgextra/i2/760015/O1CN01td3xdm1Byubg6aqY0_!!760015.jpg", "老北京方便面36袋/箱", "零食", 300, 35),
            new InfoBean("https://gd4.alicdn.com/imgextra/i4/2209812732121/O1CN014Dv4qO1RXSguXewby_!!2209812732121.jpg", "卫龙魔芋爽丝500g", "零食", 200, 1),
            new InfoBean("https://gd2.alicdn.com/imgextra/i4/2209812732121/O1CN01d4Qosc1RXSk3jCfFr_!!2209812732121.jpg", "卫龙辣条小面筋18g", "零食", 200, 0.5),
            new InfoBean("https://g-search1.alicdn.com/img/bao/uploaded/i4/i4/1741393998/O1CN01rdupuA1fP8BlsOAQc_!!0-item_pic.jpg_460x460Q90.jpg", "电饭锅支架", "厨房用品", 60, 59.5),
            new InfoBean("https://g-search1.alicdn.com/img/bao/uploaded/i4/i2/3284480025/O1CN01b0oXkh1C3UXOY59vU_!!0-item_pic.jpg_460x460Q90.jpg", "九阳刀具套装", "厨房用品", 100, 89),
            new InfoBean("https://g-search2.alicdn.com/img/bao/uploaded/i4/i2/2889308890/O1CN01wBkyqQ2FXfk9Ic9N9_!!0-item_pic.jpg_460x460Q90.jpg", "苏泊尔刀具套装", "厨房用品", 100, 229),
            new InfoBean("https://g-search3.alicdn.com/img/bao/uploaded/i4/i3/3284480025/O1CN01vZSpsx1C3UcWqtknh_!!0-item_pic.jpg_460x460Q90.jpg_.webp", "九阳油壶", "厨房用品", 200, 29),
            new InfoBean("https://img.alicdn.com/imgextra/i4/2549841410/O1CN01Fe8qlY1MHp5jCnEf7_!!2549841410.jpg_430x430q90.jpg", "双立人菜刀", "厨房用品", 200, 69),
            new InfoBean("https://imgservice.suning.cn/uimg1/b2c/image/HrO-XQi8_3SXFkxghHWdtQ.jpg_800w_800h_4e", "飘柔洗发水", "洗化用品", 200, 18),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.alicdn.com%2Fi4%2F2211100827839%2FO1CN01ftONwa27mJSPX5i8b_%21%210-item_pic.jpg&refer=http%3A%2F%2Fimg.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153334&t=5b7bba59ea84a9066037bc2685e06f71", "潘婷洗发水", "洗化用品", 200, 33),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi2%2FTB10EsBGXXXXXb9XpXXXXXXXXXX_%21%210-item_pic.jpg_400x400q90.jpg&refer=http%3A%2F%2Fimg.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153369&t=fe68fe4bd5092ed34eba0198f26cdc67", "海飞丝洗发水", "洗化用品", 200, 19),
            new InfoBean("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqna.smzdm.com%2F202108%2F31%2F612e31a879ee68678.jpg_e600.jpg&refer=http%3A%2F%2Fqna.smzdm.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670153418&t=05beed362c43a4ff16828a4d1153a296", "清扬洗发水", "洗化用品", 200, 31));

    /**
     * 购买商品列表
     */
    private static List<InfoBean> buyGoodsList = new ArrayList<>();

    public static List<InfoBean> getBuyGoodsList() {
        return buyGoodsList;
    }

    public static void addGoodsToBuyList(InfoBean bean) {
        boolean flag = true;
        for (InfoBean buyBean : buyGoodsList) {
            if (buyBean.getTitle().equals(bean.getTitle())) {
                int buycount = bean.getBuycount();
                buyBean.setBuycount(buyBean.getBuycount() + buycount);
                flag = false;
                break;
            }
        }
        if (flag) {
            buyGoodsList.add(bean);
        }
    }

    public static void printBuyList() {
        Log.i("lsh", "printBuyList: size====" + buyGoodsList.size());
        String msg = "";
        for (InfoBean bean : buyGoodsList) {
            msg = bean.getTitle() + ":" + bean.getBuycount();
            Log.i("lsh", "printBuyList: goods=~~~" + msg);
        }
    }
}
