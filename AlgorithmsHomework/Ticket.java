class Ticket {
    public static void main(String[] args) {
        System.out.println(optimizeTicketFee(new int[] { 1, 2, 4, 5, 7, 29, 30 }));
    }

    // O(n + m)
    // n = total travel days
    // m = 30
    public static int optimizeTicketFee(int[] travelDays) {
        // Monthly ticket
        if (travelDays.length >= 23)
            return 25;

        // 0 = non-travel
        // 1 = travel
        int[] travel = new int[31];
        for (int day : travelDays)
            travel[day] = 1;

        int[] cost = new int[31];

        for (int day = 1; day <= 30; day++) {
            if (travel[day] != 1) {
                cost[day] = cost[day - 1];
                continue;
            }

            int cost1 = cost[day - 1] + 2;
            int cost7 = cost[Math.max(0, day - 7)] + 7;
            cost[day] = Math.min(cost1, cost7);
        }

        return cost[30];
    }
}