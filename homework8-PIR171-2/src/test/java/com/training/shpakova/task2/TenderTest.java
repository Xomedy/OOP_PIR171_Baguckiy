package com.training.shpakova.task2;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;


public class TenderTest {
    public static final Tender TENDER = new Tender();
    public static final Optional<Brigade> notFoundWinner = Optional.empty();
    private Brigade [] brigades;
    private Optional<Brigade> foundWinner;
    private Optional<Brigade> winner;
    private int bricklayerAmount;
    private int plastererAmount;
    private int painterAmount;

    @Before
    public void init() {
        int brigadeAmount = 6;
        brigades = new Brigade[brigadeAmount];
        for (int i = 0; i < brigadeAmount; i++) {
            brigades[i] = new Brigade(String.format("Brigade %d", i));
        }
        Worker worker1Skill = new Worker(new Skills[]{Skills.BRICKLAYER});
        Worker worker2Skill = new Worker(new Skills[]{Skills.PLASTERER});
        Worker worker3Skill = new Worker(new Skills[]{Skills.PAINTER});
        Worker worker12Skill = new Worker(new Skills[]{Skills.BRICKLAYER, Skills.PLASTERER});
        Worker worker13Skill = new Worker(new Skills[]{Skills.BRICKLAYER, Skills.PAINTER});
        Worker worker23Skill = new Worker(new Skills[]{Skills.PLASTERER, Skills.PAINTER});
        Worker worker123Skill = new Worker(new Skills[]{Skills.BRICKLAYER, Skills.PLASTERER, Skills.PAINTER});
        brigades[0].setBrigade(new Worker[]{worker123Skill, worker1Skill, worker2Skill, worker2Skill, worker3Skill});
        brigades[0].setCost(new BigDecimal(1200));
        brigades[1].setBrigade(new Worker[]{worker1Skill, worker1Skill, worker1Skill, worker23Skill, worker2Skill});
        brigades[1].setCost(new BigDecimal(1000));
        brigades[2].setBrigade(new Worker[]{worker12Skill, worker1Skill, worker2Skill, worker2Skill, worker2Skill});
        brigades[2].setCost(new BigDecimal(900));
        brigades[3].setBrigade(new Worker[]{worker13Skill, worker2Skill, worker2Skill, worker2Skill});
        brigades[3].setCost(new BigDecimal(1100));
        brigades[4].setBrigade(new Worker[]{worker12Skill, worker12Skill, worker1Skill, worker2Skill, worker3Skill});
        brigades[4].setCost(new BigDecimal(1300));
        brigades[5].setBrigade(new Worker[]{worker1Skill, worker1Skill, worker2Skill, worker2Skill, worker3Skill, worker3Skill});
        brigades[5].setCost(new BigDecimal(1100));
        foundWinner = Optional.ofNullable(brigades[1]);
    }

    @Test
    public void testFindAdequateBrigadePositiveCase() {
        bricklayerAmount = 3;
        plastererAmount = 2;
        painterAmount = 1;
        winner = TENDER.findAdequateBrigade(brigades, bricklayerAmount, plastererAmount, painterAmount);
        Assert.assertEquals(foundWinner, winner);
    }

    @Test
    public void testFindAdequateBrigadeNegativeCase() {
        bricklayerAmount = 3;
        plastererAmount = 3;
        painterAmount = 3;
        winner = TENDER.findAdequateBrigade(brigades, bricklayerAmount, plastererAmount, painterAmount);
        Assert.assertEquals(notFoundWinner, winner);
    }

}