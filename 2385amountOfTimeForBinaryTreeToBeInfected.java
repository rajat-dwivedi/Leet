//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
//2385amountOfTimeForBinaryTreeToBeInfected

class Solution {
public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(root, graph);
        return maxDistance(graph, new LinkedList<>(List.of(start)), new HashSet<>(Set.of(start)));
    }

    private void createGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        List<Integer> adjacent = graph.computeIfAbsent(root.val, parameter -> new ArrayList<>());

        if (root.left != null) {
            graph.computeIfAbsent(root.left.val, param -> new ArrayList<>()).add(root.val);
            adjacent.add(root.left.val);
            createGraph(root.left, graph);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.right.val, param -> new ArrayList<>()).add(root.val);
            adjacent.add(root.right.val);
            createGraph(root.right, graph);
        }
    }

    private int maxDistance(Map<Integer, List<Integer>> graph, Queue<Integer> queue, Set<Integer> visited) {
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currentNode = queue.poll();
                for (int neighbour : graph.get(currentNode)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            maxDistance++;
        }

        return maxDistance - 1;
    }
}