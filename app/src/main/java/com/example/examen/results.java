package com.example.examen;

import java.util.List;

public class results {
    private List<ganadores> data;

    public results(List<ganadores> data) {
        this.data = data;
    }

    public List<ganadores> getData() {
        return data;
    }

    public void setData(List<ganadores> data) {
        this.data = data;
    }
}
