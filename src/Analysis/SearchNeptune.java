package Analysis;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
/**
 * Created by 62316 on 2017/4/6.
 */
public class SearchNeptune extends Thread {
    char index;


    public SearchNeptune(char i)
    {
        index = i;
    }
    @Override

    public void run()
    {
        System.out.println("neptune " + index + "  is searching ");
        GET get = new GET();
        for(int x = 65; x < 91; x++)
        {
          try {
              String f = String.valueOf(index);
              String s = String.valueOf((char) x);
              //System.out.println(f+s);
              String AA = new String(get.sendGet("http://asia.wargaming.net/clans/wows/search/api/clans/?battle_type=pvp&offset=0&limit=50&search=", f + s));
              //System.out.println(AA);
              //System.out.println("______");
              JsonObject returnData = new JsonParser().parse(AA).getAsJsonObject();
              JsonArray array = returnData.get("clans").getAsJsonArray();
              for (int z = 0; z < array.size(); z++) {
                  JsonObject clanover = array.get(z).getAsJsonObject();
                  int id = clanover.get("id").getAsInt();
                 //System.out.println(id);
                  // System.out.println(id);
                 Main.IDSET.add(id);

              }
             // System.out.print(f+s);
              //System.out.println(i);
              //System.out.println(second);
          }
          catch (Exception e)
          {
              System.out.println("Neptune can't get result ");
          }
        }
        Main.count++;
        System.out.println("size of list"+Main.IDSET.size());
    }
}
