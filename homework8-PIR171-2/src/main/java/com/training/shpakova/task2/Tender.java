package com.training.shpakova.task2;

import java.util.*;

public class Tender {
    private Optional<Brigade> winner;

    private Comparator<Brigade> COMPARE_BY_COST = Comparator.comparing(Brigade::getCost);

    public Optional<Brigade> findAdequateBrigade(Brigade[] brigades, int requiredBricklayer, int requiredPlasterer, int requiredPainter) {
        int bricklayerAmount = 0, plastererAmount = 0, painterAmount = 0;
        List<Brigade> appropriateBrigades = new ArrayList();
        for (Brigade brigade : brigades) {
            Iterator<Worker> workerIterator = brigade.getBrigade().iterator();
            bricklayerAmount = plastererAmount = painterAmount = 0;
            while (workerIterator.hasNext()) {
                Iterator<Skills> skillsIterator = workerIterator.next().getSkills().iterator();
                while (skillsIterator.hasNext()) {
                    Skills skill = skillsIterator.next();
                    if (skill == Skills.BRICKLAYER) {
                        bricklayerAmount++;
                    } else if (skill == Skills.PLASTERER) {
                        plastererAmount++;
                    } else {
                        painterAmount++;
                    }
                }
            }
            if (bricklayerAmount >= requiredBricklayer && plastererAmount >= requiredPlasterer && painterAmount >= requiredPainter) {
                appropriateBrigades.add(brigade);
            }
        }
        appropriateBrigades.sort(COMPARE_BY_COST);
        Brigade win = appropriateBrigades.size() != 0 ? appropriateBrigades.get(0) : null;
        return Optional.ofNullable(win);
    }

}
