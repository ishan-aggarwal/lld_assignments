# Implement ZeroEvenOdd class with thread synchronization and main method

- Added `ZeroEvenOdd` class to print numbers in the sequence `0, 1, 0, 2, 0, 3, ...` up to a given number 'n'.
    - Utilizes three semaphores (`zeroSemaphore`, `evenSemaphore`, `oddSemaphore`) for synchronization between threads.
    - `zero` method prints `0` and alternates between releasing `evenSemaphore` and `oddSemaphore`.
    - `even` method prints even numbers and releases `zeroSemaphore` after each print.
    - `odd` method prints odd numbers and releases `zeroSemaphore` after each print.

- Included main method to test the `ZeroEvenOdd` class:
    - Initializes an instance of `ZeroEvenOdd` with a specific value of 'n'.
    - Defines an `IntConsumer` to print each number followed by a space.
    - Creates and starts three threads to execute the `zero`, `even`, and `odd` methods.

- Ensured that each printed number is followed by a space for better readability.

- Example output for `n=5`: `0 1 0 2 0 3 0 4 0 5`

This implementation ensures proper thread synchronization and correct output formatting.
