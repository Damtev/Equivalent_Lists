**Task**:

Пусть вам дана некоторая целочисленная переменная X, инициализированная случайным числом, и список, элементами которого являются простые арифметические операции: сложение и умножение. Если операции из списка начать последовательно применять к X, и результат каждого применения снова записывать в X, то мы получим результат применения списка.

Пример:

X=10
ops=[+5, *2, +12]

Результат применения ops к X: ((X+5)*2)+12 = 42
Пусть вам дано два списка, в которых один и тот же набор операций, но в разном порядке. Вам нужно понять, получается ли в итоге одинаковый результат, не выполняя сами операции. Например, результат применения списков ops1=[+2, +10, +20] и ops2=[+20, +10, +2] будет одинаковым, а результат применения списков ops1=[+10, *2] и ops2=[*2, +10] будет разным.

Напишите программу, принимающую на вход два списка и дающую булевский ответ: одинаковый ли результат их применения к случайному исходному значению или разный.

**Using**:

Run `run.sh` with 2 arguments: first list and second, separated by whitespace.
Lists should match following regular expression: `([+*]\\d+)+`. 
Numbers in lists should be non-negative and less than `1_000_000`. The program returns `true` then and only then lists have a same result 
with any number.




