package test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class BloomFilter {
    private final int bitsArrayLength;
    private final String[] algorithms;
    private final BitSet bitsSet;

    public BloomFilter(int bitsArrayLength, String ...algs) {
        this.bitsArrayLength = bitsArrayLength;
        this.algorithms = algs;
        this.bitsSet = new BitSet(bitsArrayLength);
    }

    public void add(String word) {
        for (String algorithm : this.algorithms) {
            try {
                int bitIndex = calculateBitIndex(word, algorithm);
                this.bitsSet.set(bitIndex);
            }
            catch (NoSuchAlgorithmException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean contains(String word) {
        for (String algorithm : this.algorithms) {
            try {
                int bitIndex = calculateBitIndex(word, algorithm);
                if(!this.bitsSet.get(bitIndex)) return false;
            }
            catch (NoSuchAlgorithmException ignored) {}
        }

        return true;
    }

    private int calculateBitIndex(String word, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] bts = md.digest(word.getBytes());
        BigInteger bi = new BigInteger(bts);
        int bitsAsInt = Math.abs(bi.intValue());
        int bitIndex = bitsAsInt % this.bitsArrayLength;

        return bitIndex;
    }

    @Override
    public String toString() {
        StringBuilder bitsAsStr = new StringBuilder();

        for (int i = 0; i < this.bitsSet.length(); i++) {
            String currentBitAsStr = this.bitsSet.get(i) ? "1" : "0";
            bitsAsStr.append(currentBitAsStr);
        }

        return bitsAsStr.toString();
    }
}
