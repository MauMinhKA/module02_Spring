package champ;

import java.util.ArrayList;
import java.util.List;

public class ChampsList {
    public static List<Champ> getChamp(){
        List<Champ> champList=new ArrayList<>();
        champList.add(new Champ(1,"Darius","Top","Đấu Sĩ","images/img1.jpg"));
        champList.add(new Champ(2,"Leesin","Rừng","Đấu Sĩ","images/img2.jpg"));
        champList.add(new Champ(3,"Yasuo","All","Gánh Team","images/img6.jpg"));
        champList.add(new Champ(4,"Ashe","Bot","Xạ Thủ","images/img4.jpg"));
        champList.add(new Champ(5,"Thresh","Bot","Hỗ Trợ","images/img5.jpg"));
        return champList;
    }
}
