package Coding_assessment;

import java.util.*;

public class StockDividend {
    static class Dividend {
        long amount, days;

        public Dividend(long amount, long days) {
            this.amount = amount;
            this.days = days;
        }
    }

    static class FuturePricingEngine {
        long stockPrice;
        TreeMap<Long, Long> priceOnDay;
        List<Dividend> dividends;

        public FuturePricingEngine(long stockPrice, List<Dividend> dividends) {
            this.stockPrice = stockPrice;
            this.priceOnDay = new TreeMap<>();

            // sort dividends by days in ascending order
            Collections.sort(dividends, Comparator.comparingLong(d -> d.days));
            this.dividends = dividends;

            long currentPrice = stockPrice;
            for (Dividend d : dividends) {
                currentPrice -= d.amount;
                priceOnDay.put(d.days, currentPrice);
            }
        }

        public void updateDividend(int dividendId, Dividend updatedDividend) {
            // Remove the old dividend and add the new one
            dividends.set(dividendId - 1, updatedDividend);
            priceOnDay = new FuturePricingEngine(stockPrice, dividends).priceOnDay;
        }

        long calculateFuturePrice(long daysToFuture) {
            Map.Entry<Long, Long> entry = priceOnDay.floorEntry(daysToFuture);
            if (entry == null) {
                return stockPrice;
            } else {
                return entry.getValue();
            }
        }
    }
}
