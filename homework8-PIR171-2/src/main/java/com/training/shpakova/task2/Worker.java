package com.training.shpakova.task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Worker {
    private ArrayList workerSkills;

    public Worker(Skills[] skills) {
        workerSkills = new ArrayList();
        workerSkills.addAll(Arrays.asList(skills));
    }

    public ArrayList getSkills() {
        return workerSkills;
    }

}
