package dev.practice.order.common.util;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class TokenGenerator {
    private static final int TOKEN_LENGTH = 20;

    public static String randomCharacter(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomCharacterWithPrefix(String prefix) {
        return prefix + randomCharacter(TOKEN_LENGTH - prefix.length());
    }
}
