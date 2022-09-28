package com.crccalc;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        boolean allRight = true;

        out.println("Checking CRC-8...");
        allRight &= Check(Crc8.Params);

        out.println("Checking CRC-16...");
        allRight &= Check(Crc16.Params);

        out.println("Checking CRC-32...");
        allRight &= Check(Crc32.Params);

        out.println("Checking CRC-64...");
        allRight &= Check(Crc64.Params);

        if (allRight)
            out.println("All right!");
    }

    private static boolean Check(AlgoParams[] params)
    {
        out.println(params.length + " algos");
        boolean allRight = true;
        for (int i = 0; i < params.length; i++) {
            CrcCalculator calculator = new CrcCalculator(params[i]);
            long result = calculator.Calc(CrcCalculator.TestBytes, 0, CrcCalculator.TestBytes.length);
            if (result != calculator.Parameters.Check){
                out.println(calculator.Parameters.Name + " - BAD ALGO!!! " + Long.toHexString(result).toUpperCase());
                allRight = false;
            }
        }
        out.println("done");
        out.println();
        return allRight;
    }
}