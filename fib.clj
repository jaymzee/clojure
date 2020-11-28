(ns clojure.examples.fib
  (:gen-class)
(defn fib' [[a b]]
  [b (+ a b)])
(defn fib
  "first n + 1 numbers of the fibonacci sequence"
  [n]
  (take (inc n) (map first (iterate fib' [0 1]))))
(println (fib 10))
