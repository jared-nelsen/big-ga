# Big GA

Scaled Configurable Event Driven Genetic Algorithm

BigGA is an implementation of a genetic algorithm with these two properties in mind:

1. Scalability of Fitness Function
2. Obfuscation of Complexity

# Scalability
The major bottleneck in almost all Genetic Algorithms is the Fitness function step. Fitness functions generally are longer running and more complex than any of the other main functions of a GA.

The problem is that if a fitness function takes an hour to run and the population is 100 members wide it will take 100 hours for the fitness function step to run. However, if scaled horizontally to 100 workers then it will still only take 1 hour.

## Benefits

The main benefits of this implmentation are:

1. Speed - Fitness Function evaluation goes from order N to Order 1 effectively giving a P times speedup where P is the number of population members.
2. Experimentation - Can experiment with potentially huge populations.

# Obfuscation of Complexity
The goal would be to abstract away all of the work around every function except Fitness Evaluation. The pieces for mutation, crossover, selection, and reporting are essentially solved problems. All the user really needs to think about is their fitness function.


## Benefits

1. Ease of implementation. - Just write your fitness function in Python and hit Go!