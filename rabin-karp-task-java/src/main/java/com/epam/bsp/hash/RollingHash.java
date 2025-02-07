package com.epam.bsp.hash;

public class RollingHash {
    public String text;
    public int hashBase;
    public int hashModulo;
    private long[] powers;
    private long[] prefixHashes;

    public RollingHash(String text, int hashBase, int hashModulo) {
        this.text = text;
        this.hashBase = hashBase;
        this.hashModulo = hashModulo;
        this.powers = new long[text.length() + 1];
        this.prefixHashes = new long[text.length() + 1];
        powers[0] = 1;
        prefixHashes[0] = 0;
        for (int i = 1; i <= text.length(); i++) {
            powers[i] = (powers[i - 1] * hashBase) % hashModulo;
            prefixHashes[i] = (prefixHashes[i - 1] * hashBase + text.charAt(i - 1)) % hashModulo;
        }
    }
    public int getHash(int leftIndex, int rightIndex) {
        long hash = prefixHashes[rightIndex + 1] - (prefixHashes[leftIndex] * powers[rightIndex - leftIndex + 1]) % hashModulo;
        if (hash < 0) hash += hashModulo;
        return (int)hash;
    }
    public long[] getPowers() {
        return powers;
    }
}