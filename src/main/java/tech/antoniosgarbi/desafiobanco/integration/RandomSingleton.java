package tech.antoniosgarbi.desafiobanco.integration;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomSingleton {
    private static Random randomInstance;

    public static Random getRandomInstance() {
        if (RandomSingleton.randomInstance == null)
            RandomSingleton.randomInstance = new Random(150L);
        return RandomSingleton.randomInstance;
    }
}
