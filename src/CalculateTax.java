
/**
 * Iterate over each bracket. When income becomes 0, break the loop. At each
 * iteration, take the min of current bracket-previous bracket and income. Then
 * apply tax logic on that diff and add it to tax. Then update income by
 * subtracting diff amount and prev bracket with current bracket.
 *
 */
class Solution {
	public double calculateTax(int[][] brackets, int income) {
		int prev = 0;
		double taxes = 0;

		for (int[] bracket : brackets) {
			if (income <= 0)
				break;

			int diff = Math.min((bracket[0] - prev), income);

			taxes += (double) diff * ((double) bracket[1] / 100);

			income -= diff;
			prev = bracket[0];
		}

		return taxes;
	}
}