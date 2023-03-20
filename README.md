# PrimeNumberCount
Java Multithreaded Code to count Total Prime Numbers till 100M. This Experiment WAS Done using 10 Threads.

Sequential Processing

Number of primes less than 100,000,000: 5761455. Took total 308.348 seconds.

Unfair Batching

Thread 1 17135 ms 17.135 seconds

Thread 2 28531 ms 28.531 seconds

Thread 3 34814 ms 34.814 seconds

Thread 4 41187 ms 41.187 seconds

Thread 5 45181 ms 45.181 seconds

Thread 6 48832 ms 48.832 seconds

Thread 7 52232 ms 52.232 seconds

Thread 8 55211 ms 55.211 seconds

Thread 9 57374 ms 57.374 seconds

Thread 10 59832 ms 59.832 seconds

Number of primes less than 100,000,000: 5761455. Took total 59.841 seconds.


Using Fair Thread Policy.

Thread 2 49714 ms 49.714 seconds

Thread 8 49714 ms 49.714 seconds

Thread 4 49714 ms 49.714 seconds

Thread 5 49714 ms 49.714 seconds

Thread 1 49715 ms 49.715 seconds

Thread 7 49714 ms 49.714 seconds

Thread 9 49714 ms 49.714 seconds

Thread 3 49714 ms 49.714 seconds

Thread 10 49713 ms 49.713 seconds

Thread 6 49714 ms 49.714 seconds

Number of primes less than 100,000,000: 5761455. Took total 49.747 seconds.
