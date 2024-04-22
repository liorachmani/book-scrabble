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
                MessageDigest md = MessageDigest.getInstance(algorithm);
                byte[] bts = md.digest(word.getBytes());
                BigInteger bi = new BigInteger(bts);
                int bitsAsInt = Math.abs(bi.intValue());
                int bitIndex = bitsAsInt % this.bitsArrayLength;

                this.bitsSet.set(bitIndex);
            }
            catch (NoSuchAlgorithmException ignored) {}
        }
    }

    public boolean contains(String word) {
        for (String algorithm : this.algorithms) {
            try {
                MessageDigest md = MessageDigest.getInstance(algorithm);
                byte[] bts = md.digest(word.getBytes());
                BigInteger bi = new BigInteger(bts);
                int bitsAsInt = Math.abs(bi.intValue());
                int bitIndex = bitsAsInt % this.bitsArrayLength;

                if(!this.bitsSet.get(bitIndex)) return false;
            }
            catch (NoSuchAlgorithmException ignored) {}
        }

        return true;
    }

    @Override
    public String toString() {
        String bitsAsStr = "";

        for (int i = 0; i < this.bitsSet.length(); i++) {
            String currentBitAsStr = this.bitsSet.get(i) ? "1" : "0";
            bitsAsStr = bitsAsStr.concat(currentBitAsStr);
        }

        return bitsAsStr;
    }
}
