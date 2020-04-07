package com.aby.c0769778_ex6.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.aby.c0769778_ex6.R;
import com.aby.c0769778_ex6.adapters.AttractionsAdapter;
import com.aby.c0769778_ex6.model.CanadaAttractions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AttractionListActivity extends AppCompatActivity {
    private RecyclerView rvAttractions;
    private ArrayList<CanadaAttractions> attractions;
    private AttractionsAdapter attractionsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAttractions = findViewById(R.id.rvAttractions);

        loadAttractions();
        attractionsAdapter = new AttractionsAdapter(attractions);
        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvAttractions.setLayoutManager(mLinearLayoutManager);
        rvAttractions.setAdapter(attractionsAdapter);

    }

    public String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void loadAttractions()
    {

        String jasper_desc = "One of Canada's wildest places, Jasper National Park provides kaleidoscopic panoramas at every turn. " +
                "Travelers can marvel at many views as they trek from the peaks of Mount Edith Cavell to the caverns of Maligne Canyon. " +
                "Located on the eastern edge of Alberta, the park serves as a beacon for adventurers in the Northern Hemisphere. " +
                "Jasper boasts the distinction of being the largest park in the Canadian Rockies and was designated part of a UNESCO World Heritage Site, along with Banff and a handful of additional parks. " +
                "With more than 2.7 million acres of land to explore, travelers are sure to spot animals ranging from caribou to wolverine to moose.";
        String niagara_desc =  "It's not hard to understand why many consider Niagara Falls a top natural wonder of the world. " +
                "Or why it has been the location of some incredible (and now illegal) daredevil antics over the years. " +
                "The second you see the mammoth Niagara River rumbling toward a 188-foot waterfall at about 20 to 30 (and up to 68) mph, your mouth will drop. " +
                "The speed at which the river falls creates a misty fog and an unmistakable roar heard from miles away. " +
                "From the top, crowds flock to the railings to feel the mist on their faces. As you follow the water's path downward, boats, platforms and observation decks support colorful poncho-clad visitors.";
        String banf_desc = "If you're itching to experience the lifestyle of a Swiss skiing village, but don't want to fork over the cash for a trans-Atlantic flight, consider Banff. " +
                "Thanks to its location in the heart of the Canadian Rockies near the southeastern border of Banff National Park –" +
                " Canada's first national park – taking trips here will decrease not only your flight time from the U.S. but also your expenses " +
                "(although only marginally). Banff caters to intrepid explorers who prefer to end the day in a nice hotel rather than roughing it at the " +
                "campgrounds (though, there are plenty of those, too). Opportunities for adventure abound, so pick your sport: Ski down Mount Norquay, " +
                "hike to the massive, free-standing limestone pillars known as the Hoodoos, \"scramble\" up the face of the Stoney Squaw Mountain or bike along Healy Creek.";
         String victoriaIsland_desc="Although it's only a 90-minute ferry ride from bustling Vancouver, " +
                 "British Columbia's capital city may as well be a world away. Taking the opposite approach from its youthful neighbor, Victoria exudes a quainter atmosphere. " +
                 "Resting on the southern tip of Vancouver Island, This relatively small city remains deeply rooted in its Colonial past, relishing distinctively British traditions like afternoon tea at the Fairmont Empress and a pint at the pub. " +
                 "But that doesn't mean this destination is strictly reserved for Anglophiles.";
         String edward_desc = "Home to rolling green hills, red sandstone cliffs and a delicious bounty of seafood, " +
                 "Prince Edward Island is the place to travel for a relaxing respite from Canada's more adventure-driven destinations. " +
                 "When you're not enjoying the beach, perfect your swing at one of the island's golf courses. " +
                 "And be sure to keep an eye out for PEI's adorable harp seals.";
         String quebec_desc = "The sight of winding cobblestone streets and towering cathedrals; the sound of French pleasantries and tourists' \"Oohs;\" the smell of fresh-baked bread and pungent cheese; the taste of creamy cafe lattes and buttery croissants. All your senses agree: You're in France. But they're wrong: You're in Québec.\n" +
                 "\n" +
                 "Québec City – the capital of the Canadian province, Québec – dwelled in the shadow of its neighbor, Montréal, for a long time, but the 2008 celebration of its 400th birthday catapulted Québec City back into the spotlight. ";
         String whistler_dec = "Take adventure travel up a notch with a visit to Whistler. This Canadian resort town boasts everything from skiing and snowboarding to bobsled rides and bungee jumping. Travelers can spend their downtime in Whistler Village enjoying the après-ski scene or strolling Whistler Olympic Plaza. Meanwhile, warm-weather visitors can explore Brandywine Falls Provincial Park, home to the 230-foot waterfall from which the park gets its name.";
         String grosmorne_desc = "This UNESCO World Heritage Site encompasses nearly 448,000 acres on Newfoundland's west coast. Its top activity is undoubtedly hiking the Tablelands. Here, you'll traverse exposed earth mantle, a rust-colored landscape that was created millions of years ago by a collision of tectonic plates. Equally impressive: a boat ride through Western Brook Pond, which is a glacier-carved, landlocked fjord that features cascading waterfalls measuring 2,000 feet.";
         String kluane_desc = "Calling all adventure travelers: Kluane National Park and Reserve is home to Canada's highest peak (Mount Logan), the country's largest ice field and the continent's most genetically diverse grizzly population. Situated in the southwest corner of the Yukon, the park lures intrepid explorers with rafting trips on the Alsek River, multiday backcountry hikes and mountaineering on the Icefield Ranges of the St. Elias Mountains.";
         String mont_desc = "Nestled in the Laurentian Mountains northwest of Montréal, Mont-Tremblant is best known for its skiing, specifically Tremblant Resort, which occupies the highest peak in the mountain range. But warm-weather visitors are equally enchanted thanks to the Parc national du Mont-Tremblant, which boasts six rivers and 400 lakes and streams, not to mention countless hiking trails and beaches. Horseback riding, fishing and mountain biking are all popular here thanks to the area's diverse landscape.";

         attractions = new ArrayList<>();

        attractions.add(new CanadaAttractions("1","Jasper Park","Canadian Rockies","Alberta","Alberta", jasper_desc,R.drawable.jasper_park));
        attractions.add(new CanadaAttractions("2","Niagara Falls","The Falls","Ontario","Ontario",niagara_desc,R.drawable.niagarafalls));
        attractions.add(new CanadaAttractions("3","Banff Park","Canadian Rockies","Alberta","Alberta",banf_desc, R.drawable.banff));
        attractions.add(new CanadaAttractions("4","Victoria Island","Canadian Rockies","Vancouver","British Columbia", victoriaIsland_desc,R.drawable.victoriaandvancouverisland));
        attractions.add(new CanadaAttractions("5","Edward Park","Cliffs","Alberta","Alberta", edward_desc, R.drawable.princeedwardisland));
        attractions.add(new CanadaAttractions("6","Quebec City","New France","Quebec","Quebec", quebec_desc ,R.drawable.quebeccity));
        attractions.add(new CanadaAttractions("7","Whistler","VC","Vancouver","British Columbia", whistler_dec ,R.drawable.whistler));
        attractions.add(new CanadaAttractions("8","Grosmorne Park","Rocky Harbour","Newfoundland","Newfoundland", grosmorne_desc ,R.drawable.grosmorne));
        attractions.add(new CanadaAttractions("9","Kluane Reserve","Yukon","Yukon","Yukon", kluane_desc ,R.drawable.kluane));
        attractions.add(new CanadaAttractions("10","Jasper Park","Montreal","Montreal","Quebec", mont_desc,R.drawable.monttremblant));
    }
}
