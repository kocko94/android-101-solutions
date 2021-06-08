package com.playground.android101solutions.datasource;


import com.playground.android101solutions.model.DummyData;
import com.playground.android101solutions.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23/03/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DummyDataService {

    private final List<DummyData> data = new ArrayList<>();

    public DummyDataService(int amountOfDummyData) {
        fillWithDummyData(amountOfDummyData);
    }

    private void fillWithDummyData(int amount) {
        int initialDimension = 48; //needed only to make different urls
        for (int i = 0; i <= amount; i++) {
            if (i % 5 == 0) {
                data.add(new DummyData(null, "Big title " + (i + 1), null, Type.TITLE));
            } else if (i % 3 == 0) {
                data.add(new DummyData(null,
                        "Big title " + (i + 1), "Left aligned description " + (i + 1),
                        Type.CONTENT_RIGHT));
            } else {
                data.add(new DummyData("https://picsum.photos/" + (initialDimension + i),
                        "Dummy title " + (i + 1),
                        "Dummy description " + (i + 1),
                        Type.CONTENT_LEFT));
            }
        }
    }

    public List<DummyData> getData() {
        return data;
    }
}
