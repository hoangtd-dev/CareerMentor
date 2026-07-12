class ChangeCoin {
	public static void main(String[] args) {
		System.out.println(changeCoins(50));
	}

	// O(coins)
	public static int changeCoins(int money) {
		int[] coins = new int[] { 20, 10, 5, 1 };
		int totalCoin = 0;

		for (int coin : coins) {
			totalCoin += money / coin;
			money %= coin;
			if (money == 0)
				break;
		}

		return totalCoin;
	}

	// O(n) + O(n * m) => O(n)
	// n = money + 1
	// m = coins => constraint
	public static int changeCoinsV2(int money) {
		// money = 8
		int[] coins = new int[] { 1, 5, 7 };

		int[] optimizedCoinsForMoney = new int[money + 1];
		optimizedCoinsForMoney[0] = 0;

		for (int i = 1; i < optimizedCoinsForMoney.length; i++) {
			optimizedCoinsForMoney[i] = money + 1;
		}

		// 0 1 2 3 4 5 6 7 8
		// Start: 0 9 9 9 9 9 9 9 9
		// 0 1 9 9 9 9 9 9 9
		// 0 1 2 9 9 9 9 9 9
		for (int i = 1; i < optimizedCoinsForMoney.length; i++) {

			for (int coin : coins) {
				if (i < coin)
					continue;

				optimizedCoinsForMoney[i] = Math.min(optimizedCoinsForMoney[i - coin] + 1, optimizedCoinsForMoney[i]);
			}
		}

		if (optimizedCoinsForMoney[money] > money) {
			return -1;
		} else {
			return optimizedCoinsForMoney[money];
		}
	}
}
