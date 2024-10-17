/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.currencyconverter;

/**
 *
 * @author lenovo
 */
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    // HashMap to store exchange rates relative to USD (as base)
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        // Initialize exchange rates (values are relative to USD)
        exchangeRates.put("USD", 1.0);  // USD to USD
        exchangeRates.put("EUR", 0.85); // USD to EUR
        exchangeRates.put("GBP", 0.76); // USD to GBP
        exchangeRates.put("INR", 73.58); // USD to INR
        exchangeRates.put("JPY", 110.48); // USD to JPY
        exchangeRates.put("AUD", 1.38); // USD to AUD
        exchangeRates.put("CAD", 1.27); // USD to CAD
        exchangeRates.put("CHF", 0.92); // USD to CHF

        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY, AUD, CAD, CHF");
        System.out.print("Enter the currency you want to convert from (e.g., USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(fromCurrency)) {
            System.out.println("Invalid currency: " + fromCurrency);
            return;
        }

        System.out.print("Enter the currency you want to convert to (e.g., EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(toCurrency)) {
            System.out.println("Invalid currency: " + toCurrency);
            return;
        }

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Perform the conversion
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
        System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
    }

    // Method to convert between currencies
    private static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        // Convert the amount to USD first, then to the target currency
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }
}
