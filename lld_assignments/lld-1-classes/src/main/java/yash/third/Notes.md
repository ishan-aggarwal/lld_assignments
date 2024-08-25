# C++

- vector
- set,
- map,
- queue,
- stack,
- priorityqueue,
- struct/ pair
- Comparator

#Java

- List -> Vector(x), ArrayList, LinkedList, CopyOnWriteArrayList(used in multi-threaded environment)
- Set -> HashSet, LinkedHashSet, TreeSet
- Map -> HashTable(x), HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap(used in multi-threaded environment)

List<String> list = new ArrayList<>();
Set<Integer> set = new HashSet<>();
Map<String, String> map = new HashMap<>();
Queue<String> queue = new LinkedList<>();
Stack<Integer> stack = new Stack<>();

- Queue -> Dqueue, LinkedList, LinkedBlockingQueue,
- Stack(?) -> Stack
- PriorityQueue
- Class
- Comparable (provides single sort sequence and can be used when we are allowed to make modifications in the class source code)
/Comparator (provides multiple sorting sequences and can be used when the class is a 3rd party class)