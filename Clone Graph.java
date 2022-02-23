class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Node, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    map.put(node, new Node(node.val));
    while (!queue.isEmpty()) {
      Node removed = queue.remove();
      for (Node neighbor : removed.neighbors) {
        if (!map.containsKey(neighbor)) {
          map.put(neighbor, new Node(neighbor.val));
          queue.add(neighbor);
        }
        map.get(removed).neighbors.add(map.get(neighbor));
      }
    }
    return map.get(node);
  }
}
