# Collection Framework in Java

## Introduction

This project showcases the extensive usage of the Java Collection Framework, which provides a unified architecture for representing and manipulating collections. It includes examples of various data structures such as lists, sets, and maps, along with advanced features like concurrent collections and custom implementations.

## Features

- Detailed examples of `List`, `Set`, and `Map` implementations.
- Demonstrations of Java 8 Stream API, including intermediate and terminal operations, lazy evaluation, and parallel streams.
- Examples of concurrent collections such as `ConcurrentHashMap`, `CopyOnWriteArrayList`, `ConcurrentLinkedQueue`, and `BlockingQueue`.
- Custom implementations like an LRU Cache.
- Usage of specialized collections like `IdentityHashMap`, `WeakHashMap`, `EnumMap`, and `ImmutableMap`.
- Insights into Java features like garbage collection, hashCode and equals methods, and more.

## Project Structure

```
CollectionFramework/
├── src/
│   ├── StreamsEx/
│   │   ├── CollectorsEx.java          # Examples of Collectors in Streams
│   │   ├── IntermediateOps.java       # Demonstrates intermediate operations in Streams
│   │   ├── Java8Intro.java            # Features of Java 8
│   │   ├── LazyEvaluationEx.java      # Explains lazy evaluation in Streams
│   │   ├── ParallelStreamsEx.java     # Examples of parallel stream processing
│   │   ├── PrimitiveStreamsEx.java    # Usage of primitive streams like IntStream
│   │   ├── StreamJavaEx.java          # General Stream API examples
│   │   ├── TerminalOps.java           # Demonstrates terminal operations in Streams
│   │
│   ├── ArrayListEx.java               # Examples of ArrayList usage
│   ├── BlockingQueueEx.java           # Examples of BlockingQueue
│   ├── ComparableEx.java              # Demonstrates Comparable interface
│   ├── ConcurrentHashMapEx.java       # Examples of ConcurrentHashMap
│   ├── ConcurrentLinkedDequeEx.java   # Examples of ConcurrentLinkedDeque
│   ├── ConcurrentLinkedQueueEx.java   # Examples of ConcurrentLinkedQueue
│   ├── ConcurrentSkipListMapEx.java   # Examples of ConcurrentSkipListMap
│   ├── CopyOnWriteArrayListEx.java    # Examples of CopyOnWriteArrayList
│   ├── CopyOnWriteArraySetEx.java     # Examples of CopyOnWriteArraySet
│   ├── DelayQueueEx.java              # Examples of DelayQueue
│   ├── DequeEx.java                   # Examples of Deque
│   ├── EnumMapEx.java                 # Examples of EnumMap
│   ├── GarbageCollectorEx.java        # Demonstrates garbage collection behavior
│   ├── HashCodeAndEqualsMethodEx.java # Demonstrates hashCode and equals() methods
│   ├── HashEx.java                    # Example of Hash
│   ├── HashMapEx.java                 # Examples of HashMap usage
│   ├── HashTableEx.java               # Examples of Hashtable
│   ├── IdentityHashMapEx.java         # Examples of IdentityHashMap
│   ├── ImmutableMapEx.java            # Examples of immutable maps
│   ├── IteratorEx.java                # Demonstrates Iterator usage
│   ├── LinkedHashMapEx.java           # Examples of LinkedHashMap
│   ├── LinkedListEx.java              # Examples of LinkedList usage
│   ├── LRUCache.java                  # Custom implementation of LRU Cache
│   ├── PriorityQueueEx.java           # Examples of PriorityQueue
│   ├── QueueEx.java                   # Examples of Queue interface
│   ├── SetEx.java                     # Examples of Set interface
│   ├── SortedMapEx.java               # Examples of SortedMap
│   ├── StackEx.java                   # Examples of Stack usage
│   ├── SynchronousQueueEx.java        # Examples of SynchronousQueue
│   ├── VectorEx.java                  # Examples of Vector usage
│   ├── WeakHashMapEx.java             # Examples of WeakHashMap
│
├── .gitignore                         # Git ignore file
└── README.md                          # Project documentation
```

## Requirements

- Java Development Kit (JDK) 8 or higher.
- An IDE or text editor of your choice.

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/CollectionFramework.git
   ```
2. Navigate to the project directory:
   ```sh
   cd CollectionFramework
   ```

## Usage

1. Open the project in your IDE.
2. Compile the Java files:
   ```sh
   javac -d bin src/**/*.java
   ```
3. Run the desired example class:
   ```sh
   java -cp bin com.example.collectionframework.<ClassName>
   ```

Replace `<ClassName>` with the specific class you want to execute.

## Contributing

Contributions are welcome! Please fork the repository, make your changes, and submit a pull request.

## Contact

For any questions or feedback, please contact [JohnSunny](mailto:sunnyjohnballa@gmail.com).