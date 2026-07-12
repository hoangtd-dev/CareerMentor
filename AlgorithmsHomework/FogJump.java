import java.util.Queue;
import java.util.ArrayDeque;

class FogJump {
	public static void main(String[] args) {
		System.out.println(fogJump(new int[] { 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0 }));
	}

	// O(24) + O(n x 24) => O(n)
	// Space: O(n) (Queue)
	public static int fogJump(int[] paths) {
		// Fibonancci
		int[] fiboList = new int[24];
		fiboList[0] = 1;
		fiboList[1] = 2;

		int lastFiboIndex = 2;
		while (fiboList[lastFiboIndex - 1] < paths.length) {
			fiboList[lastFiboIndex] = fiboList[lastFiboIndex - 2] + fiboList[lastFiboIndex - 1];
			lastFiboIndex++;
		}

		// { {-1: 0}, {0: 1}, {1: 1}, {4:1}, {7,1} }
		// { {1: 2}(R), {4: 2}(R), {7: 2}(R), {10: 2} (done) }
		Queue<int[]> levels = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[paths.length];
		levels.add(new int[] { -1, 0 });

		while (!levels.isEmpty()) {
			int[] level = levels.poll();
			int currIndex = level[0];
			int totalSteps = level[1];

			for (int i = 0; i < lastFiboIndex; i++) {
				int newPosition = currIndex + fiboList[i];
				if (newPosition == paths.length)
					return totalSteps + 1;

				if (newPosition < paths.length && paths[newPosition] == 1 && !visited[newPosition]) {
					levels.add(new int[] { newPosition, totalSteps + 1 });
					visited[newPosition] = true;
				}
			}
		}

		return -1;
	}
}
