package Analysis;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by 62316 on 2017/4/10.
 */
public class AnalysisNoire extends Thread {
    int ID;
    public AnalysisNoire(int i)
    {
 ID=i;
    }
    public void run()
    {
        GET get = new GET();
        // try {
        String Claninfo = new String(get.sendGet("http://asia.wargaming.net/clans/wows/" + ID, "/api/claninfo/"));
        JsonObject D = new JsonParser().parse(Claninfo).getAsJsonObject();
        JsonObject clanview = D.get("clanview").getAsJsonObject();
        JsonObject clan = clanview.get("clan").getAsJsonObject();
        String clanname = clan.get("name").getAsString();
        int id = clan.get("id").getAsInt();
        int member = clan.get("members_count").getAsInt();
        String description = clan.get("raw_description").getAsString();
        String tag = clan.get("tag").getAsString();
        JsonObject recruiting_restrictions = clan.get("recruiting_restrictions").getAsJsonObject();

        String Detail = new String(get.sendGet("http://asia.wargaming.net/clans/wows/" + ID, "/api/players/?battle_type=pvp"));
        JsonObject ALL = new JsonParser().parse(Detail).getAsJsonObject();
        JsonObject PVP = ALL.get("clan_statistics").getAsJsonObject();
        double battle = 0+PVP.get("battles_count").getAsDouble();
        double winrate = PVP.get("wins_percentage").getAsDouble();
        double average_damage = PVP.get("damage_per_battle").getAsDouble();
        double average_xp = PVP.get("exp_per_battle").getAsDouble();
        String time = clan.get("created_at").getAsString();
        JsonArray Player = ALL.get("items").getAsJsonArray();
        int R1 = 0;
        for (int i = 0; i < Player.size(); i++) {
            int R1member = 0;
            try {
                R1member = Player.get(i).getAsJsonObject().get("season_rank").getAsInt();



            } catch (Exception e) {
            }
            if (R1member==1) {

                String name = Player.get(i).getAsJsonObject().get("name").getAsString();
                int last_battle_time = Player.get(i).getAsJsonObject().get("last_battle_time").getAsInt();
                if (last_battle_time > 1498838400)
                {
                    Main.R5list.add("["+tag +"]"+name+"{"+R1member+"}");
                    Main.R5number++;

                }
            }
        }
           if(true)
           {
               System.out.println("————————"+"ID"+id+"  ANALYSISING————————");
               System.out.println("Name:" + clanname);
               System.out.println("TAG:" + tag);
               System.out.println("ID:" + id);
               System.out.println("number of member:" + member);
               System.out.println("winrate: " + winrate + "%");
               System.out.println("battle rate: " + battle);
               System.out.println("create time: " + time);
               System.out.println("average damage:" + average_damage);
               System.out.println( "average xp: " + average_xp);
               System.out.println("Rank 1 member:"+R1);
               System.out.println("======================================");
               System.out.println(description);
               System.out.println("---------------END-----------------");
        //try{

        //Main.ClanOverView ClanOverView = new Main.ClanOverView(member,id,clanname,tag);
          //  Main.ClanDetail ClanDetial = new Main.ClanDetail(member,id,clanname,tag,description,average_damage,winrate,battle,average_xp,R1);
            //Main.CLANDETAIL.add(ClanDetial);
            //Main.CLANOVERVIEW.add(ClanOverView);


    }


    }

}
