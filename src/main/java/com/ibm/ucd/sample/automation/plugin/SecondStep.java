package com.ibm.ucd.sample.automation.plugin;

import java.util.Properties;

public class SecondStep {

    private final Medal medal;
    private final boolean isTermsAndConditionsAgreed;

    public SecondStep(Properties inputProperties) {
        medal = Medal.valueOf(inputProperties.getProperty("medal"));
        isTermsAndConditionsAgreed =
            Boolean.parseBoolean(inputProperties.getProperty("agreeTermsAndConditions"));
    }

    public static void main(String[] args) {
        int returnCode = 0;
        try {
            Properties inputProperties = Util.readProperties(args[0]);
            new SecondStep(inputProperties).execute();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            returnCode = 1;
        }
        System.exit(returnCode);
    }

    private void execute() {
        if (medal == Medal.GOLD)
            System.out.println("Great work!");
        else if (medal == Medal.SILVER)
            System.out.println("Good job!");
        else if (medal == Medal.BRONZE)
            System.out.println("Nice work!");
        else
            System.out.println("Better luck next time!");

        if (medal != Medal.NONE && !isTermsAndConditionsAgreed)
            throw new IllegalArgumentException("Medal winners must agree to the terms and conditions.");

        System.out.println("is Terms and Conditions agreed? " + isTermsAndConditionsAgreed);
    }

    private enum Medal {
        GOLD,
        SILVER,
        BRONZE,
        NONE
    }
}