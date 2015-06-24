package com.codetheroad.eds.data;

import com.google.android.gms.maps.model.LatLng;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import net.sf.json.JSONSerializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Don't instantiate this directly, call ServerConnection.connect()
 */
public class MockServerConnection extends ServerConnection {
    protected String DATA_FILENAME = "mock_data.json";

    public Vehicle getVehicle() throws Exception {
        InputStream is = getClass().getResourceAsStream(DATA_FILENAME);
        String jsonTxt = IOUtils.toString(is);
        System.out.println(jsonTxt);
        JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );

        // Read location
        LatLng location = jsonToLocation(json.getJSONArray("location"));

        // Read items on board
        Map<Item, Integer> itemsOnBoard = new HashMap<Item, Integer>();
        JSONArray jsonItemsOnBoard = json.getJSONArray("itemsOnBoard");
        for (int i=0; i<jsonItemsOnBoard.length(); ++i) {
            JSONObject jsonItemAndQuantity = jsonItemsOnBoard.getJSONObject(i);
            int quantity = jsonItemAndQuantity.getInt("quantity");
            Item item = jsonToItem(jsonItemAndQuantity.getJSONObject("item"));
            itemsOnBoard.put(item, quantity);
        }

        // Read destinations
        List<Destination> destinations = new ArrayList<Destination>();
        JSONArray jsonDestinations = json.getJSONArray("destinations");
        for (int i=0; i<jsonDestinations.length(); ++i) {
            JSONObject jsonDestination = jsonDestinations.getJSONObject(i);
            Destination destination = jsonToDestination(jsonDestination);
            destinations.add(destination);
        }

        return new Vehicle(location, itemsOnBoard, destinations);
    }

    protected LatLng jsonToLocation(JSONArray jsonLocation) throws JSONException {
        return new LatLng(jsonLocation.getDouble(0), jsonLocation.getDouble(1));
    }

    // { description: "water" }
    protected Item jsonToItem(JSONObject jsonItem) throws JSONException {
        String description = jsonItem.getString("description");
        return new Item(description);
    }

    // { location: [33.76, 84.4], contactInfo: "770-555-9058", needs: [ { type: "shelter", quantity: 1 }, { type: "cold exposure", quantity: 2 } ] }
    protected Destination jsonToDestination(JSONObject jsonDestination) throws JSONException {
        LatLng location = jsonToLocation(jsonDestination.getJSONArray("location"));
        ContactInfo contactInfo = jsonToContactInfo(jsonDestination.getString("contactInfo")); // Later this will be more than just a String
        Map<Need, Integer> needs = new HashMap<Need, Integer>();
        JSONArray jsonNeeds = jsonDestination.getJSONArray("needs");
        for (int i=0; i<jsonNeeds.length(); ++i) {
            JSONObject jsonNeed = jsonNeeds.getJSONObject(i);
            Need need = Need.fromCategory(jsonNeed.getString("type"));
            int quantity = jsonNeed.getInt("quantity");
            needs.put(need, quantity);
        }
        return new Destination(location, needs, contactInfo);
    }

    protected ContactInfo jsonToContactInfo(String telephoneNumber) {
        return new ContactInfo(telephoneNumber);
    }
}

