/**
 * Created by 62316 on 2017/4/4.
 */
package Analysis;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> IDSET = new HashSet<Integer>();
    static int count = 0;
    static int R5number =0;
    static  ArrayList<String> R5list = new ArrayList<String>();
    //static ArrayList<ClanOverView> CLANOVERVIEW = new ArrayList<>();
  //  static ArrayList<ClanDetail> CLANDETAIL = new ArrayList<>();
    public static void main(String[] args)
    {
        char first = 65 ;
        char second = 65;
        GET get = new GET();


        ArrayList<Integer> Researchlist = new ArrayList<Integer>();
        System.out.println("searching");
      for(int i=0;i<26;i++) {

            SearchNeptune[] Neptune = new SearchNeptune[26];
          Neptune[i] = new SearchNeptune(first);
          Neptune[i].start();
          first = (char) ((int)first+1);

            //System.out.println(first);
        }
        while (count!=26)
        {
            try
            {
              Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }
            System.out.println(26-count+"Neptune still searching");
        }
        System.out.println("size is :"+IDSET.size());
        System.out.println(IDSET);

        ArrayList<Integer> IDLIST =  new ArrayList<>();
        IDLIST.addAll(IDSET);
        for (int i=0;i<IDLIST.size();i++) {
            AnalysisNoire[] Noire = new AnalysisNoire[IDLIST.size()];
            Noire[i] = new AnalysisNoire(IDLIST.get(i));
            Noire[i].start();
            try {
                Thread.sleep(200);
            } catch (Exception e)
            {

            }
        }
        try
        {Thread.sleep(5000);}
        catch (Exception e)
        {}
      //  System.out.println(CLANDETAIL.size());
      ///  System.out.println(CLANOVERVIEW);
        //System.out.println(CLANDETAIL);
        System.out.println(R5number);
        System.out.println(R5list);
        System.out.println("Finish");
//System.out.println(get.sendGet("http://asia.wargaming.net/clans/wows/2000007539/api/players/?battle_type=pvp",""));


    }
    public static class ClanOverView {
            private final SimpleIntegerProperty ClanSize;
            private final SimpleIntegerProperty ClanID;
            private final SimpleStringProperty ClanName;
            private final SimpleStringProperty Tag;
        public ClanOverView(int Size,int ID,String Name,String Tag)
        {   this.ClanSize = new SimpleIntegerProperty(Size);
            this.ClanID = new SimpleIntegerProperty(ID);
            this.ClanName = new SimpleStringProperty(Name);
            this.Tag = new SimpleStringProperty(Tag);
        }

        public void setTag(String tag) {
            this.Tag.set(tag);
        }

        public String getTag() {
            return Tag.get();
        }

        public void setClanID(int clanID) {
            this.ClanID.set(clanID);
        }

        public void setClanSize(int clanSize) {
            this.ClanSize.set(clanSize);
        }

        public int getClanID() {
            return ClanID.get();
        }

        public int getClanSize() {
            return ClanSize.get();
        }

        public void setClanName(String clanName) {
            this.ClanName.set(clanName);
        }

        public String getClanName() {
            return ClanName.get();
        }
    }
    public static class ClanDetail {
        private final SimpleIntegerProperty ClanSize;
        private final SimpleIntegerProperty ClanID;
        private final SimpleDoubleProperty AvgDamage;
        private final SimpleDoubleProperty WinRate;
        private final SimpleDoubleProperty AvgXp;
        private final SimpleIntegerProperty Ran1Number;
        private final SimpleDoubleProperty BattleRate;
        private final SimpleStringProperty ClanName;
        private final SimpleStringProperty Tag;
        private final SimpleStringProperty Describe;
        public ClanDetail(int Size,int ID,String Name,String Tag,String Describe,double AvgDamage,double WinRate,double BattleRate,double AvgXp,int Rank1Number)
        {   this.ClanSize = new SimpleIntegerProperty(Size);
            this.ClanID = new SimpleIntegerProperty(ID);
            this.AvgDamage = new SimpleDoubleProperty(AvgDamage);
            this.AvgXp = new SimpleDoubleProperty(AvgXp);
            this.BattleRate = new SimpleDoubleProperty(BattleRate);
            this.Ran1Number = new SimpleIntegerProperty(Rank1Number);
            this.WinRate = new SimpleDoubleProperty(WinRate);
            this.ClanName = new SimpleStringProperty(Name);
            this.Tag = new SimpleStringProperty(Tag);
            this.Describe =new SimpleStringProperty(Describe);
        }

        public void setAvgDamage(double avgDamage) {
            this.AvgDamage.set(avgDamage);
        }

        public void setAvgXp(double avgXp) {
            this.AvgXp.set(avgXp);
        }

        public void setRan1Number(int ran1Number) {
            this.Ran1Number.set(ran1Number);
        }

        public void setWinRate(double winRate) {
            this.WinRate.set(winRate);
        }

        public double getAvgDamage() {
            return AvgDamage.get();
        }

        public double getAvgXp() {
            return AvgXp.get();
        }

        public int getRan1Number() {
            return Ran1Number.get();
        }

        public double getWinRate() {
            return WinRate.get();
        }

        public void setBattleRate(double battleRate) {
            this.BattleRate.set(battleRate);
        }

        public void setDescribe(String describe) {
            this.Describe.set(describe);
        }

        public double getBattleRate() {
            return BattleRate.get();
        }

        public void setTag(String tag) {
            this.Tag.set(tag);
        }

        public String getTag() {
            return Tag.get();
        }

        public String getDescribe() {
            return Describe.get();
        }

        public void setClanID(int clanID) {
            this.ClanID.set(clanID);
        }

        public void setClanSize(int clanSize) {
            this.ClanSize.set(clanSize);
        }

        public int getClanID() {
            return ClanID.get();
        }

        public int getClanSize() {
            return ClanSize.get();
        }

        public void setClanName(String clanName) {
            this.ClanName.set(clanName);
        }

        public String getClanName() {
            return ClanName.get();
        }
    }


}
